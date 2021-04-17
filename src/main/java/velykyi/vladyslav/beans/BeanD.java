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
public class BeanD implements Serializable, Validator {
    private static final Logger log = LogManager.getLogger(BeanD.class);
    private String name;
    private int value;

    public void init() {
        log.debug("Inside init() method for bean D");
    }

    public void cleanup() {
        log.debug("Inside cleanup() method for bean D");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BeanD.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "value", "value.empty");
        BeanD beanD = (BeanD) o;
        if (beanD.getValue() < 0) {
            errors.rejectValue("value", "value.negative");
        }
    }

    @Value("${beanD.name}")
    public void setName(String name) {
        log.debug("Inside setName() is: " + name);
    }

    @Value("${beanD.value}")
    public void setValue(int value) {
        log.debug("Inside setName() is: " + value);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
