package com.hillel.artemjev.notebook.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JsonServlet extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();

    protected void writeJson(Object object, HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "application/json");
        String strResponse = mapper.writeValueAsString(object);
        response.getWriter().print(strResponse);
        response.getWriter().flush();
    }

    protected <T> T readJson(Class<T> clazz, HttpServletRequest request) throws IOException {
        return mapper.readValue(request.getInputStream(), clazz);
    }
}
