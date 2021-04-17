package velykyi.vladyslav;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import velykyi.vladyslav.config.OuterConfig;

import java.util.stream.Stream;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                new AnnotationConfigApplicationContext(OuterConfig.class);

        Stream.of(ctx.getBeanDefinitionNames()).
                forEach(name -> log.info(ctx.getBean(name)));
        ctx.close();
    }
}
