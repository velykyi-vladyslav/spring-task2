package velykyi.vladyslav.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanG implements BeanFactoryPostProcessor {
    private static final Logger log = LogManager.getLogger(BeanG.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        configurableListableBeanFactory.getBeanDefinition("beanB").setInitMethodName("initMethod");
        log.info("Inside postProcessBeanFactory() method for bean G: " +
                "the name of init() method for bean B has changed to \"initMethod()\"");
    }

    @Override
    public String toString() {
        return "BeanG{}";
    }
}
