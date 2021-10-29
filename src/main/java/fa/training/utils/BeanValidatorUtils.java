package fa.training.utils;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author san vui
 * @create 25/10/2021 - 10:16 AM
 * @sanvankhanh@gmail.com
 */
public class BeanValidatorUtils {
    public static void validateBean(Object o) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if (violations.isEmpty()) {
            System.out.println("your object is ok.");
        } else {
            System.out.println("your object not oke.");
        }
    }

}
