package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.converter.UserCommandToUser;
import com.dkkcorp.mybankapp.converter.UserToUserCommand;
import com.dkkcorp.mybankapp.domain.User;
import com.dkkcorp.mybankapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

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
    public UserCommand saveUser(UserCommand userCommand) {
        User user=userCommandToUser.convert(userCommand);

        user=userRepository.save(user);
        return userToUserCommand.convert(user);
    }

}
