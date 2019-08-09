package com.ls.service.impl;

import com.ls.dao.AccountDao;
import com.ls.domain.Account;
import com.ls.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: 账户的业务实现类
 *      事务控制应该都是在业务层
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAllAccountById(Integer accountId) {
        return accountDao.findAllAccountById(accountId);
    }


    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        // 根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        // 根据名称查转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 转出账户减钱
        source.setMoney(source.getMoney()-money);
        // 转入账户加钱
        target.setMoney(target.getMoney()+money);
        // 更新转出账户
        accountDao.updateAccount(source);

        int i = 1/0;

        // 更新转入账户
        accountDao.updateAccount(target);

    }
}
