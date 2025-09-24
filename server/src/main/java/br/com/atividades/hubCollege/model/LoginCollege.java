package br.com.atividades.hubCollege.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "login")
public class LoginCollege {

    @Id
    @Column(name = "registrationNumber")
    private String registrationNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "studentStatus")
    private String studentStatus;

    @Column(name = "logedIn")
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

    @PrePersist
    public void prePersist() {
        if (logedIn == null) {
            logedIn = LocalDateTime.now();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoginCollege that)) return false;
        return Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getStudentStatus(), that.getStudentStatus()) && Objects.equals(getLogedIn(), that.getLogedIn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationNumber(), getPassword(), getStudentStatus(), getLogedIn());
    }
}
