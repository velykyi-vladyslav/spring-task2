package velykyi.vladyslav.config;

import org.springframework.context.annotation.*;
import velykyi.vladyslav.beans.*;

@Configuration
@PropertySource("classpath:application.properties")
public class InnerConfig {

    @Bean(value = "beanB", initMethod = "init", destroyMethod = "cleanup")
    @DependsOn("beanD")
    public BeanB getBeanB() {
        return new BeanB();
    }

    @Bean(value = "beanC", initMethod = "init", destroyMethod = "cleanup")
    @DependsOn("beanB")
    public BeanC getBeanC() {
        return new BeanC();
    }

    @Bean(value = "beanD", initMethod = "init", destroyMethod = "cleanup")
    public BeanD getBeanD() {
        return new BeanD();
    }

    @Bean
    public BeanE getBeanE() {
        return new BeanE();
    }

    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean
    @Lazy
    public BeanF getBeanF() {
        return new BeanF();
    }
}
