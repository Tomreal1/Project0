package com.project0.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project0.controllers.DepartmentController;
import com.project0.controllers.EmployeeController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class javalinAppConfig {

    Gson gson = new GsonBuilder().create();

    JsonMapper gsonMapper = new JsonMapper() {
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {
            return gson.toJson(obj, type);
        }

        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    private static final Logger logger = LoggerFactory.getLogger(javalinAppConfig.class);

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            // I want to add a log for debugging later, so I'll tell Logback to create a log
            // for every request I send to the server
            .before(ctx -> {
                // This logic here will run before ALL requests to the server
                // We want to use to log our request sent
                logger.info(ctx.method() + " Request was sent to path: " + ctx.fullUrl());
            })
            // routes will declare all our possible paths
            .routes(() ->{
                // each path will allow to group like method
                path("employees", () ->{
                    // Declare my routes and methods super quickly
                    get(EmployeeController::handleGetAll);
                    post(EmployeeController::handleCreate);
                    put(EmployeeController::handleUpdate);
                    delete(EmployeeController::handleDelete);
                    // What about /employees/{id}?????
                    path("{id}", () ->{
                        get(EmployeeController::handleGetOne);
                    });
                });
                path("departments", () ->{
                    // Declare my routes and methods super quickly
                    get(DepartmentController::handleGetAll);
                    post(DepartmentController::handleCreate);
                    put(DepartmentController::handleUpdate);
                    delete(DepartmentController::handleDelete);
                    // What about /Dpartments/{id}?????
                    path("{id}", () ->{
                        get(DepartmentController::handleGetOne);
                    });
                });
            });


    public void start(int port){
        app.start(port);
    }
}
