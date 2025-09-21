package br.com.atividades.hubCollege.controller;

import br.com.atividades.hubCollege.data.dto.FormsActivitiesCollegeDTO;
import br.com.atividades.hubCollege.model.FormsActivitiesCollege;
import br.com.atividades.hubCollege.repository.FormsActivitiesRepository;
import br.com.atividades.hubCollege.service.FormsActivitiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/activities/v1")
public class FormsActivitiesController {

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
    public FormsActivitiesCollegeDTO create(@RequestBody FormsActivitiesCollegeDTO activity) {
        return service.create(activity);
    }

    // POST VIA FRONT
    @PostMapping("/response")
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
    public FormsActivitiesCollegeDTO update(@RequestBody FormsActivitiesCollegeDTO activity) {
        return service.update(activity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") String id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
