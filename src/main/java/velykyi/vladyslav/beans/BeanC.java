package velykyi.vladyslav.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.Serializable;

@Component
@PropertySource("application.properties")
public class BeanC implements Serializable, Validator {
    private static final Logger log = LogManager.getLogger(BeanC.class);
    private String name;
    private int value;

    public void init() {
        log.debug("Inside init() method for bean C");
    }

    public void cleanup() {
        log.debug("Inside cleanup() method for bean C");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BeanC.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "value", "value.empty");
        BeanC beanC = (BeanC) o;
        if (beanC.getValue() < 0) {
            errors.rejectValue("value", "value.negative");
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Value("${beanC.name}")
    public void setName(String name) {
        log.debug("Inside setName() is: " + name);
    }

    @Value("${beanC.value}")
    public void setValue(int value) {
        log.debug("Inside setName() is: " + value);
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
