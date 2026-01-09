package org.cedacri.spring.cedintlibra.dto_s.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.cedacri.spring.cedintlibra.entity.User;

/**
 * create dto for {@link User}
 */
public class UserCreateDto {
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "email is required")
    @Email
    private String email;
    @NotBlank(message = "login is required")
    private String login;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "telephone is required")
    private String telephone;

    public UserCreateDto() {
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
}
