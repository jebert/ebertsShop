package com.eberts.shop.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.models.Client;
import com.eberts.shop.models.vo.ClientVo;
import com.eberts.shop.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "client")
@Tag(name = "Client", description = "Endpoints to Manage Clientes")
public class ClientResource {

	@Autowired
	private ClientService clientService;


	@GetMapping(value = "/{uuid}", produces = "application/json")
	@Operation(summary = "Find an Client by UUID", tags = "Client", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> findClientByUUID(@PathVariable UUID uuid) {

		return ResponseEntity.ok(clientService.findClientById(uuid).get());
	}
	
	@GetMapping( produces = "application/json")
	@Operation(summary = "Find all Saved Client", tags = "Client", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> findAllClientes() {

		return ResponseEntity.ok(clientService.findAllClients());
	}
	


	@PostMapping(consumes = "application/json", produces = "application/json")
	@Operation(summary = "Save an Client", tags = "Client", responses = {
			@ApiResponse(description = "Created", responseCode = "201", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> saveClient(@RequestBody @Valid ClientVo clientvo) {
		Client client = clientService.saveClient(clientService.converFromClientVo(clientvo));
		return ResponseEntity.status(HttpStatus.CREATED).body(client);

	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Delete an Client by UUID", tags = "Client", responses = {
			@ApiResponse(description = "No content", responseCode = "203", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> deleteClient(@PathVariable UUID uuid) {

		clientService.delete(uuid);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client deleted");

	}
	
	@PutMapping(value = "/{uuid}", consumes = "application/json", produces = "application/json")
	@Operation(summary = "Update an Client", tags = "Client", responses = {
			@ApiResponse(description = "Created", responseCode = "201", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> updateClient(
			@PathVariable UUID uuid, 
			@RequestBody @Valid ClientVo clientvo) {
		Client newClient = clientService.findClientById(uuid).get();


		return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.saveClient(newClient));

	}

}
