package ru.spring;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig  {
    @Bean
    @Autowired
    public DataSource dataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:C:\\Users\\zorro\\IdeaProjects\\re-educate-4\\src\\main\\resources\\DB");
        ds.setUser("sa");
        return ds;
    }
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(DataSource ds) {
        return  new DataSourceTransactionManager(ds);
    }
    @Bean
    @Autowired
    public NamedParameterJdbcOperations namedParameter(DataSource ds) {
        return  new NamedParameterJdbcTemplate(ds);
    }
}
