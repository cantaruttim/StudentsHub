package br.com.atividades.hubCollege.repository;

import br.com.atividades.hubCollege.model.FormsActivitiesCollege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormsActivitiesRepository
        extends JpaRepository<FormsActivitiesCollege, String> {}
