package org.cedacri.spring.cedintlibra.dto_s.user;

import org.cedacri.spring.cedintlibra.dto_s.user_type.UserTypeDto;

public class UserWithTypeDto {
    private String name;
    private String email;
    private String login;
    private String telephone;
    private UserTypeDto userType;

    public UserWithTypeDto(String name, String email, String login, String telephone, UserTypeDto userType) {
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

    public UserTypeDto getUserType() {
        return userType;
    }

    public void setUserType(UserTypeDto userType) {
        this.userType = userType;
    }
}
