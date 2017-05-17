package by.kanarski.profito.config;

import by.kanarski.profito.utils.CustomNamingStrategy;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("by.kanarski.profito")
@PropertySources(value = {@PropertySource("classpath:application.properties")})
@EnableJpaRepositories(basePackages = "by.kanarski.profito.dao")
//@EntityScan({"by.kanarski.profito.dto"})
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost/profito?autoReconnect=true&useSSL=false");
        config.setUsername("dbadmin");
        config.setPassword("1234");
        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "by.kanarski.profito.entities" });
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }



    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setNamingStrategy(new CustomNamingStrategy());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan("by.kanarski.profito.entities");
//        sessionFactoryBean.setPackagesToScan("by.kanarski.profito.dto");
        return sessionFactoryBean;
    }

//    @Bean
//    public ImprovedNamingStrategy namingStrategy() {
//        return new ImprovedNamingStrategy();
//    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("debug", "true");
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.cglib.use_reflection_optimizer", "true");
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.hikari.autocommit", "true");
                setProperty("hibernate.hikari.minimumIdle", "5");
                setProperty("hibernate.hikari.maximumPoolSize", "20");
                setProperty("hibernate.hikari.connectionTimeout", "30000");
                setProperty("hibernate.hikari.idleTimeout", "60000");
                setProperty("hibernate.cache.use_second_level_cache", "true");
                setProperty("hibernate.cache.use_query_cache", "true");
                setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
                setProperty("hibernate.ejb.naming_strategy", "by.kanarski.profito.utils.CustomNamingStrategy");
                setProperty("hibernate.hbm2ddl.auto", "validate");
            }
        };
    }
}
