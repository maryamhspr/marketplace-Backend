package ir.irisa.marketplace.ws.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String publicId;

    @Size(
            min = 2, max = 20,
            message = "Firstname should have a length between 2 and 20 characters.")
    private String firstname;

    @Size(
            min = 2, max = 20,
            message = "Lastname should have a length between 2 and 20 characters.")
    private String lastname;

    @Column(nullable = false,unique = true)
    @NotBlank(message = "Username can't be left empty")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "Password can't be left empty")
    private String encryptedPassword;

    private String role;
}
