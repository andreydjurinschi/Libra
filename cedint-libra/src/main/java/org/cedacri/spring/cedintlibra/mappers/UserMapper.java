package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.user.UserBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserCreateDto;
import org.cedacri.spring.cedintlibra.entity.User;

public class UserMapper {

    public static UserBaseDto mapToDto(User user){
        return new UserBaseDto(
                user.getName(), user.getEmail(), user.getLogin(), user.getTelephone(), user.getUserType()
        );
    }

    /**
     * password is null, because we need to encode it in service layer
     * user type is null temporarily
     */
    public static User mapCreateDtoToEntity(UserCreateDto dto) {
        return new User(
                dto.getName(), dto.getEmail(), dto.getLogin(), null, dto.getTelephone(), null
        );
    }
}
