package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.user_type.UserTypeDto;
import org.cedacri.spring.cedintlibra.entity.UserType;

public class UserTypeMapper {

    public static UserTypeDto mapToDto(UserType type){
        return new UserTypeDto(type.getUserType());
    }
}
