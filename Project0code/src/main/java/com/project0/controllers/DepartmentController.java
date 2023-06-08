package com.project0.controllers;

import com.project0.daos.DepartmentDAO;
import com.project0.models.Department;
import com.project0.service.DepartmentService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentController {

    private static final DepartmentService departmentService = new DepartmentService(new DepartmentDAO());

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    // Now we have our 5 methods to implement
    // Our department service gives us the ability to update and get a specific department so we need to implement
    // handleGetOne and handleUpdate
    public static void handleGetOne(Context ctx){

        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch (NumberFormatException e){
            // This block running means they didn't have a valid integer in their path
            ctx.status(400);

            // Let's add a logger to show the invalid id
            logger.warn("Unable to parse id = " + ctx.pathParam("id"));

            // Adding a return statement here because there's no point continuing with a bad int
            return;
        }

        // Let's call the department service and attempt to pull the value
        Department department = departmentService.getDepartmentById(id);

        // We need to check if the department is null or not
        if (department != null){
            // This is good, it found the roll
            ctx.status(200);
            ctx.json(department);
            // This is unnecessary but we'll add a log here
            logger.info("The following department was obtained from db: " + department.toString());
        } else{
            ctx.status(404);
            logger.warn("No resource was found at id = " + id + " from ip: " + ctx.ip());
        }
    }

    public static void handleGetAll(Context ctx){
        ctx.status(405);
    }

    public static void handleCreate(Context ctx){
        ctx.status(405);
    }

    public static void handleUpdate(Context ctx){

        // We need to deserialize that and create a Department object
        Department submittedDepartment = ctx.bodyAsClass(Department.class);

        // Call the department service to actually do something with this info
        boolean updateSuccessful = departmentService.updateDepBudget(submittedDepartment.getDep_budget(),
                submittedDepartment.getDep_name());

        // So updateSuccessful should let us know if we successfully updated the DB
        if (updateSuccessful){
            // This is good
            ctx.status(200);
            // Successful update should have some logging
            logger.info("Department: " + submittedDepartment.getDep_name() + " was updated to a budget of $" +
                    submittedDepartment.getDep_budget());
        } else{
            // Was not able to update DB for some reason
            ctx.status(400);
        }
    }

    public static void handleDelete(Context ctx){
        ctx.status(405); // Method is not allowed
    }
}
