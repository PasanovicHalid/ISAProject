package com.example.BloodBank.controller;

import adapters.UserMapper;
import adapters.ViewUserMapper;
import com.example.BloodBank.dto.UserDTO;
import com.example.BloodBank.dto.ViewUserDTO;
import com.example.BloodBank.exceptions.EntityDoesntExistException;
import com.example.BloodBank.model.User;
import com.example.BloodBank.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private UserMapper userMapper;
    private ViewUserMapper viewUserMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        userMapper = new UserMapper(modelMapper);
        viewUserMapper = new ViewUserMapper(modelMapper);
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
    public ResponseEntity<Object> Update(@Valid @RequestBody UserDTO userDTO){
        try {
            User user = userMapper.fromDTO(userDTO);
            userService.Update(user);
            user = userService.Read(user.getId());
            return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDTO(user));
        } catch (Exception e){
            if(e instanceof EntityDoesntExistException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


//    @GetMapping(path = "{page}/{size}/{search}")
    @GetMapping
    public ResponseEntity<List<ViewUserDTO>> getUsers(@RequestParam("page") Optional<String> pageNumber,
                                                      @RequestParam("size") Optional<String> size,
                                               @RequestParam("search") Optional<String> searchTerm) {
        try {
            Pageable page;
            page = PageRequest.of(Integer.valueOf(pageNumber.get()), Integer.valueOf(size.get()));
            List<User> users = userService.findAllByFirstNameOrLastName(searchTerm.get(), page);
            return new ResponseEntity<>(viewUserMapper.toDTO(users), HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="amount")
    public ResponseEntity<Integer> getNumberOfUsers( @RequestParam("search") Optional<String> searchTerm) {
        try {
            int amount = userService.getUsersAmountWithSearch(searchTerm.get());
            return new ResponseEntity<>(amount, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
