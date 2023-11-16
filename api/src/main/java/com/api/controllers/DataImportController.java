package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.services.interfaces.IDataImporter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/data")
@ComponentScan(basePackages = "com.api.services")
public class DataImportController {

	@Autowired
	IDataImporter importer;

	@Operation(summary = "Cargar data de archivo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cantidad de datos importados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) })
				})
	@PostMapping("/importLocal")
	public Integer importLocalData() {
		return importer.startupScan();
	}

	@Operation(summary = "Cargar data de archivo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cantidad de datos importados en el path dado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) }),
			@ApiResponse(responseCode = "404", description = "No hay archivo en la ruta dada", content = @Content)
				})
	@PostMapping("/inPath/{path}")
	public Integer importData(@RequestBody String path ) {
		return importer.importData( path );
	}
	
}