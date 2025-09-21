package br.com.atividades.hubCollege.data.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonPropertyOrder({"registrationNumber", "password", "studentStatus", "logedIn"})
public class LoginCollegeDTO extends RepresentationModel<LoginCollegeDTO> implements Serializable {

    private String registrationNumber;
    private String password;
    private String studentStatus;
    private LocalDateTime logedIn;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public LocalDateTime getLogedIn() {
        return logedIn;
    }

    public void setLogedIn(LocalDateTime logedIn) {
        this.logedIn = logedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoginCollegeDTO that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getStudentStatus(), that.getStudentStatus()) && Objects.equals(getLogedIn(), that.getLogedIn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRegistrationNumber(), getPassword(), getStudentStatus(), getLogedIn());
    }
}
