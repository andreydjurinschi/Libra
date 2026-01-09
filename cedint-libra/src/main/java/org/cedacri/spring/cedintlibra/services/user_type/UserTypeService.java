package org.cedacri.spring.cedintlibra.services.user_type;

import org.cedacri.spring.cedintlibra.dto_s.user_type.UserTypeDto;
import org.cedacri.spring.cedintlibra.entity.UserType;
import org.cedacri.spring.cedintlibra.mappers.UserTypeMapper;
import org.cedacri.spring.cedintlibra.repositories.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserTypeService {
    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public List<UserTypeDto> getAll(){
        return userTypeRepository.findAll().stream().map(UserTypeMapper::mapToDto).toList();
    }

    public UserTypeDto findById(Long id){
        UserType userType = userTypeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("this user type does not exist"));
        return UserTypeMapper.mapToDto(userType);
    }
}
