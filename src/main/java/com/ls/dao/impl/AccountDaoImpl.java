package com.ls.dao.impl;

import com.ls.dao.AccountDao;
import com.ls.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 *      使用 JdbcDaoSupport 参考文档：
 *          https://blog.csdn.net/weixin_42112635/article/details/88020509
 *
 *       使用注解@Repository("accountDao")方式时，就不能用 extends JdbcDaoSupport 的方式了，
 *          换成下面的方式
 *          并且配置一下
 * @author:Lisa
 * @create:2019/08/06
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAllAccountById(Integer accountId) {
        String sql = "select id,name,money from account_proxy where id = ?";
        //getJdbcTemplate()方法是从父类上继承下来的。
        List<Account> list = jdbcTemplate.query("select * from account where id = ? ",new AccountRowMapper(),accountId);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account_proxy set name=?,money=? where id=?",
                account.getName(),account.getMoney(),account.getId());
    }


    @Override
    public Account findAccountByName(String name) {
        String sql = "select id,name,money from account_proxy where name = ?";
        List<Account> list = jdbcTemplate.query(sql,new AccountRowMapper(),name);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果集不唯一，不是只有一个账户对象");
        }
        return list.get(0);
    }
}
