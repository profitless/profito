package by.kanarski.profito.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan("by.kanarski.profito")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportAutoConfiguration(DaoApplication.class)
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class ServicesApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class, args);
    }

//    @Bean
//    public FactoryBean<IEntityConversionService> entityConversionService() {
//        CustomConversionServiceFactoryBean factoryBean = new CustomConversionServiceFactoryBean();
//        factoryBean.setConverters(converterSet());
//        return factoryBean;
//    }
//    private Set<Converter> converterSet() {
//        Map<String, Converter> converterMap = applicationContext.getBeansOfType(Converter.class);
//        return new HashSet<>(converterMap.values());
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper looseEmptyModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}