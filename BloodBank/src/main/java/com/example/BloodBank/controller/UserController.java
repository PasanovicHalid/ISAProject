package com.example.BloodBank.controller;

import com.example.BloodBank.adapters.UserMapper;
import com.example.BloodBank.dto.UserDTO;
import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.User;
import com.example.BloodBank.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    private static UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        userMapper = new UserMapper(modelMapper);
    }

    @Operation(summary = "Update an existing user", description = "Update an existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully edited",
                    content =
                            { @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> Update(@RequestBody UserDTO userDTO){
        try {
            User user = userMapper.fromDTO(userDTO);
            userService.Update(user);
            return ResponseEntity.status(HttpStatus.OK).body(userService.Read(user.getId()));
        } catch (Exception e){
            if(e instanceof EntityDoesntExistException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
