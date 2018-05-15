package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.command.AdminCommand;
import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.converter.AdminCommandToAdmin;
import com.dkkcorp.mybankapp.converter.AdminToAdminCommand;
import com.dkkcorp.mybankapp.domain.Admin;
import com.dkkcorp.mybankapp.domain.Transactions;
import com.dkkcorp.mybankapp.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private AdminToAdminCommand adminToAdminCommand;
    private AdminCommandToAdmin adminCommandToAdmin;
    private UserService userService;
    private AccountService accountService;
    private TransactionsService transactionsService;

    public AdminServiceImpl(AdminRepository adminRepository, AdminToAdminCommand adminToAdminCommand,
                            AdminCommandToAdmin adminCommandToAdmin, UserService userService,
                            AccountService accountService, TransactionsService transactionsService) {
        this.adminRepository = adminRepository;
        this.adminToAdminCommand = adminToAdminCommand;
        this.adminCommandToAdmin = adminCommandToAdmin;
        this.userService = userService;
        this.accountService = accountService;
        this.transactionsService = transactionsService;
    }

    @Override
    public List<AdminCommand> findAllAdmin() {
        List<AdminCommand> listAdmin=new ArrayList<>();
        adminRepository.findAll().iterator().forEachRemaining(admin -> listAdmin.add(adminToAdminCommand.convert(admin)));
        if(listAdmin.isEmpty()){
            return null;
        }
        return listAdmin;
    }

    @Override
    public AdminCommand findAdmin(Long id) {
        Optional<Admin> userAdminOptional= adminRepository.findById(id);
        if(!userAdminOptional.isPresent()){
            return null;
        }
        return adminToAdminCommand.convert(userAdminOptional.get());
    }

    @Override
    public AdminCommand saveAdmin(AdminCommand adminCommand) {
        Admin adminFected = adminCommandToAdmin.convert(adminCommand);
        Admin adminSeved = adminRepository.save(adminFected);
        return adminToAdminCommand.convert(adminSeved);
    }

    @Override
    public void deleteAdmin(Long id) {
    }

    @Override
    public List<UserCommand> findAllUser() {
        List<UserCommand> listUser=userService.findAllUser();
        return listUser;
    }

    @Override
    public List<AccountCommand> findAllAccount() {
        List<AccountCommand> accountCommandList=accountService.findAllAccount();
        return accountCommandList;
    }


}