package velykyi.vladyslav.beans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

@Component
public class BeanE implements Serializable, Validator {
    private static final Logger log = LogManager.getLogger(BeanE.class);
    private String name;
    private int value;

    @PostConstruct
    public void doPostConstructLogic() {
        log.debug("Inside doPostConstructLogic() method for bean E");
    }

    @PreDestroy
    public void doPreDestroyLogic() {
        log.debug("Inside doPreDestroyLogic() method for bean E");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BeanE.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "value", "value.empty");
        BeanE beanE = (BeanE) o;
        if (beanE.getValue() < 0) {
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
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
