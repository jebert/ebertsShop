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

import com.eberts.shop.models.User;
import com.eberts.shop.models.vo.UserVo;
import com.eberts.shop.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "user")
@Tag(name = "User", description = "Endpoints to Manage Users")
public class UserResource {

    @Autowired
    private UserService UserService;


    @GetMapping(value = "/{uuid}", produces = "application/json")
    @Operation(summary = "Find an User by UUID", tags = "User", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserVo.class)) }),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
    public ResponseEntity<?> findUserByUUID(@PathVariable UUID uuid) {

        return ResponseEntity.ok(UserService.findUserById(uuid).get());
    }

    @GetMapping( produces = "application/json")
    @Operation(summary = "Find all Saved Users", tags = "User", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
    public ResponseEntity<?> findAllUsers() {

        return ResponseEntity.ok(UserService.findAllUsers());
    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    @Operation(summary = "Save an User", tags = "User", responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserVo Uservo) {
        User User = UserService.saveUser(UserService.convertFromUserVo(Uservo));
        return ResponseEntity.status(HttpStatus.CREATED).body(User);

    }

    @DeleteMapping(value = "/{uuid}")
    @Operation(summary = "Delete an User by UUID", tags = "User", responses = {
            @ApiResponse(description = "No content", responseCode = "203", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
    public ResponseEntity<?> deleteUser(@PathVariable UUID uuid) {

        UserService.delete(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted");

    }

    @PutMapping(value = "/{uuid}", consumes = "application/json", produces = "application/json")
    @Operation(summary = "Update an User", tags = "User", responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
    public ResponseEntity<?> updateUser(
            @PathVariable UUID uuid,
            @RequestBody @Valid UserVo Uservo) {
        User newUser = UserService.findUserById(uuid).get();


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(UserService.saveUser(newUser));

    }

}
