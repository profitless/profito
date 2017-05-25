package by.kanarski.profito.config;

import by.kanarski.profito.utils.CustomNamingStrategy;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Properties;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan("by.kanarski.profito")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "by.kanarski.profito.dao")
public class DaoConfig {

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
    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory(HikariDataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setNamingStrategy(new CustomNamingStrategy());
        sessionFactoryBean.setHibernateProperties(hibernateProperties().getProperties());
        sessionFactoryBean.setPackagesToScan("by.kanarski.profito.entities");
        return sessionFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa")
    public HibernateProperties hibernateProperties() {
        return new HibernateProperties();
    }

    @Bean
    @Primary
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean mvcValidator(MessageSource messageSource) {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }

    @Data
    public static class HibernateProperties {

        private Properties properties;

    }

}
