package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.services.interfaces.IEmployeeService;
import com.api.services.models.Employee;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/employees")
@ComponentScan(basePackages = "com.api.services")
public class EmployeeController {

	@Autowired
	IEmployeeService empService; 

	@Operation(summary = "Obtener todos los empleados")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Obtenidos Todos los Empleados", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Employee.class))) }),
			@ApiResponse(responseCode = "201", description = "No hay empleados registrados", content = @Content)})
	@GetMapping("")
	public List<Employee> getAll(@RequestParam(required = false) String type, @RequestParam(required = false) String compensationGrade) {
		return empService.getAllEmployees();
	}
	
	@Operation(summary = "Obtener un empleado según su id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Obtenido el Empleado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)) }),
			@ApiResponse(responseCode = "404", description = "No se encontró un empleado registrado con el Id dado", content = @Content)})
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return empService.getEmployeeById(id);
	}
	
	@Operation(summary = "Obtener un empleado según la id de su manager")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Obtenido el Empleado", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Employee.class))) }),
			@ApiResponse(responseCode = "404", description = "No se encontró un managerId dado", content = @Content),
			@ApiResponse(responseCode = "201", description = "Ese manager no tiene dependientes", content = @Content)})
	@GetMapping("/managedBy/{id}")
	public List<Employee> getEmployeeByManager(@PathVariable String id) {
		return empService.getEmployeesByManager(id);
	}
}