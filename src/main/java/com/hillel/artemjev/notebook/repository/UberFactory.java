package com.hillel.artemjev.notebook.repository;

import com.hillel.artemjev.notebook.repository.note.NotesRepository;
import com.hillel.artemjev.notebook.repository.note.NotesRepositoryDbImpl;
import com.hillel.artemjev.notebook.util.jdbcquery.JdbcTemplate;
import com.hillel.artemjev.notebook.util.jdbcquery.NoteDtoBuilder;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;


public class UberFactory {
    private static final UberFactory INSTANCE = new UberFactory();

    public static UberFactory instance() {
        return INSTANCE;
    }

    private final NotesRepository NOTE_REPOSITORY;
//    private final NoteDtoBuilder NOTE_DTO_BUILDER;


    private UberFactory() {
        String dsn = "jdbc:postgresql://localhost:5432/notebook";
        String user = "postgres";
        String password = "0000";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dsn);
        config.setUsername(user);
        config.setPassword(password);

        // думал считывать параметры подключения с файла properties
//        String configFileName = "app-dev.properties";
//        ConfigLoader configLoader = new ConfigLoader();
//        AppProperties appProperties = configLoader.getFileProps(AppProperties.class, configFileName);
//        appProperties.checkPropertiesExists();
//        config.setJdbcUrl(appProperties.getDatabaseUrl());
//        config.setUsername(appProperties.getDatabaseUsername());
//        config.setPassword(appProperties.getDatabasePassword());

        config.setMaximumPoolSize(8);
        config.setMinimumIdle(4);
        config.setDriverClassName("org.postgresql.Driver");
        DataSource dataSource = new HikariDataSource(config);

        NOTE_REPOSITORY = new NotesRepositoryDbImpl(
                new JdbcTemplate(dataSource)
        );

//        NOTE_DTO_BUILDER = new NoteDtoBuilder();
    }

    public NotesRepository getNotesRepository() {
        return NOTE_REPOSITORY;
    }

//    public NoteDtoBuilder getNoteDtoBuilder() {
//        return NOTE_DTO_BUILDER;
//    }
}
