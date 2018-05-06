package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.DevBootstrap;
import com.dkkcorp.mybankapp.converter.UserCommandToUser;
import com.dkkcorp.mybankapp.converter.UserToUserCommand;
import com.dkkcorp.mybankapp.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTest {

    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;
    @Mock
    UserCommandToUser userCommandToUser;
    @Mock
    UserToUserCommand userToUserCommand;
    @Mock
    DevBootstrap devBootstrap;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService=new UserServiceImpl(userRepository,userCommandToUser,userToUserCommand);
        devBootstrap.tryIt();
    }

//    @Test
//    public void findUser() throws RuntimeException{
//        Long id=new Long(0);
//        UserCommand returnUser=new UserCommand();
//        returnUser.setFirstName("David");
//        when(userService.findUser(id)).thenReturn(returnUser);
//
//        UserCommand userCommand=userService.findUser(0L);
//        assertEquals("David",userCommand.getFirstName());
//    }
//
//    @Test
//    public void findAllUser() throws RuntimeException {
//        List<UserCommand> listUser=new ArrayList<>();
//        UserCommand returnUser=new UserCommand();
//        returnUser.setFirstName("David");
//        listUser.add(returnUser);
//        when(userService.findAllUser()).thenReturn(listUser);
//        List<UserCommand> list=userService.findAllUser();
//        assertEquals(list.size(),0);
//    }

    @Test
    public void saveUser() {
    }

    @Test
    public void deleteUser() {
    }
}