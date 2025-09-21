package br.com.atividades.hubCollege.repository;

import br.com.atividades.hubCollege.model.LoginCollege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginCollegeRepository
        extends JpaRepository<LoginCollege, String> { }
