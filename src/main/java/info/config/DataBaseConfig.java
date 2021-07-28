package info.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
@PropertySource("classpath:application.properties")
public class DataBaseConfig {

    @Value("${db.url}")
    private  String URL_KEY ;
    @Value("${db.username}")
    private String USERNAME_KEY;
    @Value("${db.password}")
    private String PASSWORD_KEY;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(URL_KEY);
        dataSource.setUsername(USERNAME_KEY);
        dataSource.setPassword(PASSWORD_KEY);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

}
