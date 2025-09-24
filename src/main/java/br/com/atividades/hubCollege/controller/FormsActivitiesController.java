package br.com.atividades.hubCollege.controller;

import br.com.atividades.hubCollege.controller.docs.FormsActivitiesControllerDocs;
import br.com.atividades.hubCollege.data.dto.FormsActivitiesCollegeDTO;
import br.com.atividades.hubCollege.model.FormsActivitiesCollege;
import br.com.atividades.hubCollege.repository.FormsActivitiesRepository;
import br.com.atividades.hubCollege.service.FormsActivitiesServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/activities/v1")
@Tag(name = "activities", description = "Endpoint for managing Activities")
public class FormsActivitiesController implements FormsActivitiesControllerDocs {

    @Autowired
    private FormsActivitiesServices service;
    @Autowired
    private FormsActivitiesRepository repository;

    @GetMapping(
            value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    @Override
    public FormsActivitiesCollegeDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE
            }
    )
    @Override
    public List<FormsActivitiesCollegeDTO> findAll() {
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
    @Override
    public FormsActivitiesCollegeDTO create(@RequestBody FormsActivitiesCollegeDTO activity) {
        return service.create(activity);
    }

    // POST VIA FRONT
    @PostMapping("/response")
    @Override
    public ResponseEntity<?> salvarFormulario(
            @RequestBody FormsActivitiesCollege dadosRecebidos
    ) {
        System.out.println("Recebido: " + dadosRecebidos.getName());
        FormsActivitiesCollege salvo = repository.save(dadosRecebidos);
        return ResponseEntity.ok(salvo);
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
    @Override
    public FormsActivitiesCollegeDTO update(@RequestBody FormsActivitiesCollegeDTO activity) {
        return service.update(activity);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable("id") String id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
