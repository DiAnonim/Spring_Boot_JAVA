package kz.itstep.SpringBoot_1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name", unique = true, nullable = false, length = 20)
    @NotNull(message = "User name cannot be null")
    @NotEmpty(message = "User name cannot be empty")
    @Size(min = 4, max = 20)
    private String user_name;

    @NotNull(message = "User password cannot be null")
    @NotEmpty(message = "User password cannot be empty")
    @Size(min = 8, max = 30)
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,30}$",
//            message = "User password must contain at least one number, one uppercase and lowercase letter, one special character and must be between 8 and 30 characters long")
    private String user_pass;

    public User(String user_name, String user_pass) {
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

}
