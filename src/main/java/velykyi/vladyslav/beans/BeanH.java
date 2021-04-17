package velykyi.vladyslav.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;


public class BeanH implements BeanPostProcessor {
    private static final Logger log = LogManager.getLogger(BeanH.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Validator) {

            final DataBinder dataBinder = new DataBinder(bean);
            dataBinder.addValidators((Validator) bean);
            dataBinder.validate();
            if (dataBinder.getBindingResult().hasErrors()) {
                log.error(bean);
                log.error(dataBinder.getBindingResult().getAllErrors().get(0).toString());
            } else {
                log.info(bean + " validated");
            }
        }
        return bean;
    }

    @Override
    public String toString() {
        return "BeanH{}";
    }
}
