package velykyi.vladyslav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import velykyi.vladyslav.beans.BeanG;
import velykyi.vladyslav.beans.BeanH;

@Configuration
@Import(InnerConfig.class)
public class OuterConfig {

    @Bean
    public BeanG getBeanG() {
        return new BeanG();
    }

    @Bean(value = "beansValidator")
    public BeanH getBeanH() {
        return new BeanH();
    }
}
