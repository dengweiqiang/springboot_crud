package top.dengwq.springboot_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dengwq.springboot_crud.entity.Account;
import top.dengwq.springboot_crud.mapper.AccountMapper;

import java.util.List;

/**
 * Created by dengweiqiang on 2020/4/14
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }
    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }
    public int delete(int id) {
        return accountMapper.delete(id);
    }
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
