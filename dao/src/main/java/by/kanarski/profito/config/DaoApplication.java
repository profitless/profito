package by.kanarski.profito.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "by.kanarski.profito.dao")
public class DaoApplication {

//    @Bean
//    @Primary
//    public DataSource dataSource() throws PropertyVetoException {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("com.mysql.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mysql://localhost/profito?autoReconnect=true&useSSL=false");
//        config.setUsername("dbadmin");
//        config.setPassword("1234");
//        return new HikariDataSource(config);
//    }

//    @Bean
//    @Primary
//    @ConfigurationProperties("app.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .type(HikariDataSource.class).build();
//    }

    @Bean
    @Autowired
    @ConfigurationProperties(prefix = "spring.jpa.properties")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(HikariDataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("by.kanarski.profito.entities");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties().getProperties());
        return em;
    }

//  Используется только для подсветки сущностей
//    @Bean
//    @Autowired
//    public LocalSessionFactoryBean sessionFactory(HikariDataSource dataSource) {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setNamingStrategy(new CustomNamingStrategy());
////        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        sessionFactoryBean.setPackagesToScan("by.kanarski.profito.entities");
//        return sessionFactoryBean;
//    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa")
    public HibernateProperties hibernateProperties() {
        return new HibernateProperties();
    }

    @Data
    public static class HibernateProperties {

        private Properties properties;

    }

}
