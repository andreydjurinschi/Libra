package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.user_type.UserTypeDto;
import org.cedacri.spring.cedintlibra.entity.UserType;

public class UserTypeMapper {

    public static UserTypeDto mapToDto(UserType userType) {
        return new UserTypeDto(
                userType.getId(),
                userType.getUserType()
        );
    }}
