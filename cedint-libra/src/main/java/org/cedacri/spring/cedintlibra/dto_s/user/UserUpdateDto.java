package org.cedacri.spring.cedintlibra.dto_s.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserUpdateDto {

    @Size(min = 2, max = 50, message = "name must contain 2 - 50 letters")
    private String name;

    @Email
    private String email;

    @Size(min = 4, max = 15, message = "login must contain 4 - 15 letters")
    private String login;

    private String password;

    private String telephone;

    private Long userTypeId;

    public UserUpdateDto(String name, String email, String login, String password, String telephone, Long userTypeId) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.telephone = telephone;
        this.userTypeId = userTypeId;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }
}
