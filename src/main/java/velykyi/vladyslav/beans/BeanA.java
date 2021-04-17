package velykyi.vladyslav.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.Serializable;

@Component
public class BeanA implements InitializingBean, DisposableBean, Validator, Serializable {
    private static final Logger log = LogManager.getLogger(BeanA.class);
    private String name;
    private int value;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("Inside afterPropertiesSet() method for bean A");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("Inside destroy() method for bean A");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BeanA.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "value", "value.empty");
        BeanA beanA = (BeanA) o;
        if (beanA.getValue() < 0) {
            errors.rejectValue("value", "value.negative");
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}