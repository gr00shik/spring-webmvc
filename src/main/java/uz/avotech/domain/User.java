package uz.avotech.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor @AllArgsConstructor
public class User {

    @NotNull @Length(min = 2, max = 8, message = "incorrect login")
    private String login;
    @Length(min = 6, message = "length wrong")
    private String password;

}
