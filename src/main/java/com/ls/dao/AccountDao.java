package com.ls.dao;

import com.ls.domain.Account;

public interface AccountDao {

    Account findAllAccountById(Integer accountId);

    void updateAccount(Account account);

    Account findAccountByName(String name);
}
