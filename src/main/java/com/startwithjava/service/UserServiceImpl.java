package com.startwithjava.service;

import com.startwithjava.controller.User;
import com.startwithjava.dao.UserDao;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements  UserService {
    private UserDao userDao;
    private BaseTranslator<User,UserDto> userDtoTranslator;
    public List<User> findAll(){
        User user =new User(1L,"Gaurav","gaurav.kumar@gmail.com");
        return Arrays.asList(user);
    }

    @Override
    public long create(User user) {
        return userDao.create(userDtoTranslator.translate(user,UserDto.class));
    }

    @Override
    public Optional<UserDto> findById(long userId) {
        return userDao.findById(userId).map(UserDto::new);
    }
}
