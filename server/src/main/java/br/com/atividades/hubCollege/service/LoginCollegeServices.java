package br.com.atividades.hubCollege.service;

import br.com.atividades.hubCollege.data.dto.LoginCollegeDTO;
import br.com.atividades.hubCollege.exception.ResourceNotFoundException;
import br.com.atividades.hubCollege.model.LoginCollege;
import br.com.atividades.hubCollege.repository.LoginCollegeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;

import static br.com.atividades.hubCollege.mapper.ObjectMapper.parseListObject;
import static br.com.atividades.hubCollege.mapper.ObjectMapper.parseObject;


@Service
public class LoginCollegeServices {

    private final Logger logger = LoggerFactory.getLogger(
            LoginCollegeServices.class.getName()
    );

    @Autowired
    LoginCollegeRepository repository;

    public List<LoginCollegeDTO> findAll() {
        logger.info("Finding all People!");
        var forms = parseListObject(
                repository.findAll(),
                LoginCollegeDTO.class
        );

//        forms.forEach(this::addHateoasLinks);
        return forms;

    }


    public LoginCollegeDTO findById(String id) {
        logger.info("Finding One Activity!");

        var entity = repository.findById(id)
                .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
        var dto = parseObject(entity, LoginCollegeDTO.class);
//        addHateoasLinks(dto);
        return dto;
    }


    public LoginCollegeDTO create(
            LoginCollegeDTO login
    ) {
        logger.info("Creating One Activity!");
        var entity = parseObject(login, LoginCollege.class);
        var dto = parseObject(repository.save(entity), LoginCollegeDTO.class);
//        addHateoasLinks(dto);
        return dto;
    }


    public void delete(String id) {
        logger.info("Deleting One Activity!");
        LoginCollege entity = repository
                .findById(id)
                .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
        repository.delete(entity);
    }


    public LoginCollegeDTO update(LoginCollegeDTO login) {
        logger.info("Updating One Login!");

        LoginCollege entity = repository
                .findById(login.getRegistrationNumber())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setRegistrationNumber(login.getRegistrationNumber());
        entity.setPassword(login.getPassword());
        entity.setLogedIn(login.getLogedIn());

        var dto = parseObject(repository.save(entity), LoginCollegeDTO.class);
//        addHateoasLinks(dto);
        return dto;
    }

}
