package com.ziumks.iot;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.repository.AccountRepository;
@RunWith(SpringRunner.class)
@SpringBootTest 
public class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountRepository accountRepository;
    @Test
    public void di() throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
    }
    @Test
    public void accountTest() throws SQLException {
        Account account = new Account();
        account.setId(6L);
        account.setUsername("maddog");
        account.setPassword("1234");
        account.setPhone("010-1212-8989");
        account.setEmail("mad@dog.com");
        
        
        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();
        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotNull();
        Account nonExistingAccount = accountRepository.findByUsername("superman");
        assertThat(nonExistingAccount).isNull();
    }
}	