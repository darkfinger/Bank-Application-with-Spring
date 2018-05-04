package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.converter.UserCommandToUser;
import com.dkkcorp.mybankapp.converter.UserToUserCommand;
import com.dkkcorp.mybankapp.domain.User;
import com.dkkcorp.mybankapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserCommandToUser userCommandToUser;
    UserToUserCommand userToUserCommand;

    public UserServiceImpl(UserRepository userRepository, UserCommandToUser userCommandToUser, UserToUserCommand userToUserCommand) {
        this.userRepository = userRepository;
        this.userCommandToUser = userCommandToUser;
        this.userToUserCommand = userToUserCommand;
    }

    @Override
    public UserCommand findUser(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new RuntimeException("No user found with id : "+id);
        }
        final UserCommand user=userToUserCommand.convert(userOptional.get());
        return user;
    }

    @Override
    public List<UserCommand> findAllUser() {
        List<UserCommand> listUser=new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(user -> listUser.add(userToUserCommand.convert(user)));
        if ((listUser.isEmpty())){
            throw new RuntimeException("No user found ");
        }
        return listUser;
    }

    @Override
    public UserCommand saveUser(UserCommand userCommand) {
        User user=userCommandToUser.convert(userCommand);
        user=userRepository.save(user);
        return userToUserCommand.convert(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
