package org.cedacri.spring.cedintlibra.services.user;

import jakarta.transaction.Transactional;
import org.cedacri.spring.cedintlibra.dto_s.user.UserBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserUpdateDto;
import org.cedacri.spring.cedintlibra.entity.User;
import org.cedacri.spring.cedintlibra.entity.UserType;
import org.cedacri.spring.cedintlibra.mappers.UserMapper;
import org.cedacri.spring.cedintlibra.repositories.UserRepository;
import org.cedacri.spring.cedintlibra.repositories.UserTypeRepository;
import org.cedacri.spring.cedintlibra.utils.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    public UserService(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    public List<UserBaseDto> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserMapper::mapToDto).toList();
    }

    public UserBaseDto getById(Long id){
        User user = getUser(id);
        return UserMapper.mapToDto(user);
    }

    @Transactional
    public void createUser(UserCreateDto dto){
        User user = UserMapper.mapCreateDtoToEntity(dto);
        user.setPassword(PasswordUtil.hash(dto.getPassword()));
        userRepository.save(user);
    }
    
    @Transactional
    public void updateUser(Long id,UserUpdateDto dto) {
        User user = getUser(id);

        if (notBlank(dto.getName())) {
            user.setName(dto.getName().trim());
        }
        if (notBlank(dto.getEmail())) {
            user.setEmail(dto.getEmail());
        }
        if (notBlank(dto.getLogin())) {
            user.setLogin(dto.getLogin());
        }
        if (notBlank(dto.getPassword())) {
            String encoded = PasswordUtil.hash(dto.getPassword());
            user.setPassword(encoded);
        }
        if (notBlank(dto.getTelephone())) {
            user.setTelephone(dto.getTelephone().trim());
        }
        if (dto.getUserTypeId() != null) {
            UserType userType = userTypeRepository.findById(dto.getUserTypeId())
                    .orElseThrow(() -> new NoSuchElementException("user type does not exist"));
            user.setUserType(userType);
        }
    }

    //TODO: cascade delete logic
    @Transactional
    public void deleteUser(Long id){
        User user = getUser(id);
        userRepository.delete(user);
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this user does not exist"));
    }

    private boolean notBlank(String s) {
        return s != null && !s.trim().isEmpty();
    }


}
