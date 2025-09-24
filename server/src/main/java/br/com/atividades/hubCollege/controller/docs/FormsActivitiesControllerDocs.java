package br.com.atividades.hubCollege.controller.docs;

import br.com.atividades.hubCollege.data.dto.FormsActivitiesCollegeDTO;
import br.com.atividades.hubCollege.model.FormsActivitiesCollege;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface FormsActivitiesControllerDocs {

    FormsActivitiesCollegeDTO findById(@PathVariable("id") String id);

    @Operation(
            summary = "Find all activities",
            description = "Find all activities",
            tags = {"Activities"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = FormsActivitiesCollegeDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    List<FormsActivitiesCollegeDTO> findAll();

    @Operation(
            summary = "Find an activities",
            description = "Find an activities",
            tags = {"Activities"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = FormsActivitiesCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    FormsActivitiesCollegeDTO create(@RequestBody FormsActivitiesCollegeDTO activity);

    @Operation(
            summary = "Creating an activities",
            description = "Creating an activities",
            tags = {"Activities"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = FormsActivitiesCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    ResponseEntity<?> salvarFormulario(
            @RequestBody FormsActivitiesCollege dadosRecebidos
    );

    @Operation(
            summary = "Updating an activities",
            description = "Updating an activities",
            tags = {"Activities"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = FormsActivitiesCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    FormsActivitiesCollegeDTO update(@RequestBody FormsActivitiesCollegeDTO activity);

    @Operation(
            summary = "Deleting an activities",
            description = "Deleting an activities",
            tags = {"Activities"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = FormsActivitiesCollegeDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    ResponseEntity<Void> delete(
            @PathVariable("id") String id
    );
}
