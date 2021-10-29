package fa.training.enity;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author san vui
 * @create 25/10/2021 - 10:12 AM
 * @sanvankhanh@gmail.com
 */
public class UserBean {

    @NotNull(message = "ID is cannot be null!")
    private Long id;

    @NotNull
    @Size(min = 6, max = 20, message = "Name size > 6 and max < 20!")
    private String name;

    @NotNull
    @Email
    private String email;

    public UserBean() {
    }

    public UserBean(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
