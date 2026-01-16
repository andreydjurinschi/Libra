package org.cedacri.spring.cedintlibra.dto_s.user;

public class UserBaseDto {
    private Long id;
    private String name;
    private String email;
    private String login;
    private String telephone;


    public UserBaseDto(Long id, String name, String email, String login, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.telephone = telephone;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
