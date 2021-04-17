package velykyi.vladyslav.beans;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.Serializable;

@Component
public class BeanF implements Serializable, Validator {
    private String name;
    private int value;

    @Override
    public boolean supports(Class<?> aClass) {
        return BeanF.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "value", "value.empty");
        BeanF beanF = (BeanF) o;
        if (beanF.getValue() < 0) {
            errors.rejectValue("value", "value.negative");
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
