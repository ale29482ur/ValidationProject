package Process.example.ValidationProject.model;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Integer age;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;

    public UserDto () {}

    public UserDto(String name, Integer age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}


