package Process.example.ValidationProject.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

    @NotBlank
    @Setter
    @Getter
    private String email;

    @NotBlank
    @Setter
    @Getter
    private String password;
}
