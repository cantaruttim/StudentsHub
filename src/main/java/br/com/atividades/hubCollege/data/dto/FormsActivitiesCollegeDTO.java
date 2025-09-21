package br.com.atividades.atividades.data.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonPropertyOrder({"registrationNumber", "name", "email", "module", "questionOne", "questionTwo", "sentAt"})
public class FormsActivitiesCollegeDTO extends RepresentationModel<FormsActivitiesCollegeDTO> implements Serializable {

    private String name;
    private String email;
    private String registrationNumber;
    private String module;
    private String questionOne;
    private String questionTwo;
    private LocalDateTime sentAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FormsActivitiesCollegeDTO that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getModule(), that.getModule()) && Objects.equals(getQuestionOne(), that.getQuestionOne()) && Objects.equals(getQuestionTwo(), that.getQuestionTwo()) && Objects.equals(getSentAt(), that.getSentAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getEmail(), getRegistrationNumber(), getModule(), getQuestionOne(), getQuestionTwo(), getSentAt());
    }
}
