package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.user.UserBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserWithTypeDto;
import org.cedacri.spring.cedintlibra.dto_s.user_type.UserTypeDto;
import org.cedacri.spring.cedintlibra.entity.User;

public class UserMapper {

    public static UserBaseDto mapToDto(User user){
        return new UserBaseDto(
                user.getId(),user.getName(), user.getEmail(), user.getLogin(), user.getTelephone()
        );
    }

    /**
     * password is null, because we need to encode it in service layer {@link org.cedacri.spring.cedintlibra.services.user.UserService}
     * user type is null, searching type logic is set in {@link org.cedacri.spring.cedintlibra.services.user.UserService}
     */
    public static User mapCreateDtoToEntity(UserCreateDto dto) {
        return new User(
                dto.getName(), dto.getEmail(), dto.getLogin(), null, dto.getTelephone(), null
        );
    }

    public static UserWithTypeDto mapToUserWithTypeDto(User user) {
        UserTypeDto userTypeDto = UserTypeMapper.mapToDto(user.getUserType());
        return new UserWithTypeDto(user.getName(), user.getEmail(), user.getLogin(),user.getTelephone(), userTypeDto);
    }


}
