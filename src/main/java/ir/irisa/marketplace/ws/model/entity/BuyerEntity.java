package ir.irisa.marketplace.ws.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buyers")
@PrimaryKeyJoinColumn(name = "buyer_id")
public class BuyerEntity extends UserEntity{

    @Email(message = "Please enter a valid email.")
    @NotNull(message = "Email cannot be NULL")
    private String email;

    @Pattern(regexp = "^09\\d{9}$", message = "Phone number must be a 11-digit number and start by 09.")
    private String phoneNumber;

    @Size(
            min = 10, max = 100,
            message = "Address should have a length between 10 and 100 characters.")
    private String address;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderEntity> orderList;
}
