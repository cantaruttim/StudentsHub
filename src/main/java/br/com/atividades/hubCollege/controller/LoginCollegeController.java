package br.com.atividades.hubCollege.controller;

import br.com.atividades.hubCollege.data.dto.LoginCollegeDTO;
import br.com.atividades.hubCollege.exception.ResourceNotFoundException;
import br.com.atividades.hubCollege.repository.LoginCollegeRepository;
import br.com.atividades.hubCollege.service.LoginCollegeServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/login/v1")
public class LoginCollegeController {

    @Autowired
    private LoginCollegeServices service;
    @Autowired
    private LoginCollegeRepository repository;


    @GetMapping(
            value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        try {
            LoginCollegeDTO dto = service.findById(id);
            return ResponseEntity.ok(dto); // 200 OK com o DTO
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body("registration number not found!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("ERROR to find registration number");
        }
    }

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    @Operation(
            summary = "Find all logins",
            description = "Find all logins",
            tags = {"Logins"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = LoginCollegeDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public List<LoginCollegeDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    @Operation(
            summary = "Creating an activities",
            description = "Creating an activities",
            tags = {"Logins"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = LoginCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public LoginCollegeDTO create(@RequestBody LoginCollegeDTO login) {
        return service.create(login);
    }

    @PutMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    @Operation(
            summary = "Updating an activities",
            description = "Updating an activities",
            tags = {"Logins"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = LoginCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public LoginCollegeDTO update(@RequestBody LoginCollegeDTO login) {
        return service.update(login);
    }


    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Deleting an activities",
            description = "Deleting an activities",
            tags = {"Logins"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = LoginCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<Void> delete(
            @PathVariable("id") String id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
