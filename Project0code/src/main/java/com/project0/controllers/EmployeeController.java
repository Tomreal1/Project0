package com.project0.controllers;


import com.project0.models.Employee;
import com.project0.service.EmployeeService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class EmployeeController {

    //The controller layer has the sole responsibility of taking in HttpRequests and has the responsibilty of sending the
    //corresponding response.
    private static final EmployeeService employeeService = new EmployeeService();

    // We want to add in a logger so let's follow the same process we did before
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public static void handleGetAll(Context ctx) {
        // Inside here we need to make a call to our Employee Service to get us all the employees listed
        ArrayList<Employee> employees = employeeService.getAllEmployees();

        ctx.status(200);
        ctx.json(employees);
    }

    public static void handleCreate(Context ctx) {
        // To create a new employee from our Context body we need to essentially take it in as a JSON and convert it
        // To an object of the appropriate class

        Employee emp = ctx.bodyAsClass(Employee.class);

        Employee returnedEmployee = employeeService.createNewEmployee(emp);

        // If the employee object we receive from the service is null, something has gone wrong

        if (returnedEmployee != null) {
            // This means the employee was created
            ctx.status(201);
            ctx.json(returnedEmployee);
            logger.info("The following employee was created: " + returnedEmployee.toString());
        } else {
            // What happens if it comes back null?
            ctx.status(400);
            logger.warn("Creation failed");
        }
    }
    public static void handleDelete(Context ctx) {
        String idstring = ctx.pathParam("id");
        int id = Integer.parseInt(idstring);
        boolean deleteEmployee = employeeService.deleteEmployee(id);

        if (deleteEmployee) {
            ctx.status(200);// Set HTTP status code to 200 (successful) since the employee was successfully deleted
            ctx.result("Employee deleted");
            logger.info("Employee deleted with ID: " + id);
        } else {
            ctx.status(404); // Set HTTP status code to 404 (Not Found) if the employee was not found or delete failed
            logger.warn("Failed to delete employee: " + id);
        }
    }




    // Create some method stubs here just for now
    public static void handleGetOne(Context ctx) {ctx.status(405);
    }

    public static void handleUpdate(Context ctx) {

        ctx.status(405);
    }



}
