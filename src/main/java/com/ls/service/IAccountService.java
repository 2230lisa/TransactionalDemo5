package com.ls.service;

import com.ls.domain.Account;

import java.util.List;

public interface IAccountService {

    Account findAllAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);
}
