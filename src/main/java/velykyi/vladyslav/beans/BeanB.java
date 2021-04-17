package velykyi.vladyslav.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.Serializable;

@Component
public class BeanB implements Validator, Serializable {
    private static final Logger log = LogManager.getLogger(BeanB.class);
    private String name;
    private int value;

    public void init() {
        log.debug("Inside init() method for bean B");
    }

    public void initMethod() {
        log.debug("Inside initMethod() method for bean B");
    }

    public void cleanup() {
        log.debug("Inside cleanup() method for bean B");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BeanB.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "value", "value.empty");
        BeanB beanB = (BeanB) o;
        if (beanB.getValue() < 0) {
            errors.rejectValue("value", "value.negative");
        }
    }

    @Value("${beanB.name}")
    public void setName(String name) {
        log.debug("Inside setName() is: " + name);
        this.name = name;
    }

    @Value("${beanB.value}")
    public void setValue(int value) {
        log.debug("Inside setValue() is: " + value);
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
