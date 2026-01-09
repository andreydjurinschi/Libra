package org.cedacri.spring.cedintlibra.dto_s.user;


import org.cedacri.spring.cedintlibra.entity.UserType;

public class UserBaseDto {
    private String name;
    private String email;
    private String login;
    private String telephone;
    private UserType userType;

    public UserBaseDto(String name, String email, String login, String telephone, UserType userType) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.telephone = telephone;
        this.userType = userType;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
