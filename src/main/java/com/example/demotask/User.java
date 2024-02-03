package com.example.demotask;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "user", urlPatterns = "/user")
public class User extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Extract value from the last path segment
//        String info = req.getPathInfo();
//        String extractedValue = (info != null) ? info.substring(1) : "";
//
//        // Extract values from custom headers
//        String customHeader1 = req.getHeader("Custom-Header-1");
//        String customHeader2 = req.getHeader("Custom-Header-2");
//
//        // Check for null and provide default values if necessary
//        customHeader1 = (customHeader1 != null) ? customHeader1 : "";
//        customHeader2 = (customHeader2 != null) ? customHeader2 : "";
//
//        // Perform processing using extractedValue, customHeader1, and customHeader2
//        String result = "Processed: " + extractedValue + ", Custom Header 1: " + customHeader1 + ", Custom Header 2: " + customHeader2;
//
//        // Set response content type
//        resp.setContentType("text/plain");
//
//        // Write the result to the response
//        try (PrintWriter out = resp.getWriter()) {
//            out.println(result);
//        }
        String name = "Kamal";
        String city = "Colombo";




    }
}
