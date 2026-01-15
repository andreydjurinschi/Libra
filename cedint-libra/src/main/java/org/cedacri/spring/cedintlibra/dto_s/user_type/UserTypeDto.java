package org.cedacri.spring.cedintlibra.dto_s.user_type;

public class UserTypeDto {

    private Long id;
    private String userType;

    public UserTypeDto() {}

    public UserTypeDto(Long id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
