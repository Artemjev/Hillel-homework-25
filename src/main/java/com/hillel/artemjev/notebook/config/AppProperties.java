package com.hillel.artemjev.notebook.config;


import com.hillel.artemjev.notebook.annotations.PropertyName;
import com.hillel.artemjev.notebook.exception.FailLoadPropertiesFromFileException;
import lombok.Data;

@Data
public class AppProperties {
    @PropertyName("database.url")
    private String databaseUrl;

    @PropertyName("database.username")
    private String databaseUsername;

    @PropertyName("database.password")
    private String databasePassword;

    public void checkPropertiesExists() {
        if (databaseUrl == null) {
            throw new FailLoadPropertiesFromFileException("\"databaseUrl\" property is empty for \"database\" mode");
        }
        if (databaseUsername == null) {
            throw new FailLoadPropertiesFromFileException("\"databaseUsername\" property is empty for \"database\" mode");
        }
        if (databasePassword == null) {
            throw new FailLoadPropertiesFromFileException("\"databasePassword\" property is empty for \"database\" mode");
        }
    }
}
