package com.project0;

import com.project0.utils.javalinAppConfig;

public class Driver {

    // This driver has the sole responsibility of starting our Javalin application, in a perfect world this will likely
    // contain the ONLY main method in our application

    public static void main(String[] args) {

        // Create a new instance of the Javalin Config class
        javalinAppConfig app = new javalinAppConfig();

        // Start the app with app.start
        app.start(8080);

    }
}