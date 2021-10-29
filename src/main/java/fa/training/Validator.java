package fa.training;

import fa.training.enity.UserBean;
import fa.training.utils.BeanValidatorUtils;

/**
 * @author san vui
 * @create 25/10/2021 - 10:26 AM
 * @sanvankhanh@gmail.com
 */
public class Validator {
    public static void main(String[] args) {
        UserBean userBean = new UserBean();
        userBean.setId(null);
        userBean.setName("Tom csaasd");
        userBean.setEmail("sadas@gmail.com");
        BeanValidatorUtils.validateBean(userBean);
    }
}
