package br.com.atividades.hubCollege.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class LoginCollege {

    private String registrationNumber;
    private String password;
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

    public LocalDateTime getLogedIn() {
        return logedIn;
    }

    public void setLogedIn(LocalDateTime logedIn) {
        this.logedIn = logedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoginCollege that)) return false;
        return Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getLogedIn(), that.getLogedIn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationNumber(), getPassword(), getLogedIn());
    }
}
