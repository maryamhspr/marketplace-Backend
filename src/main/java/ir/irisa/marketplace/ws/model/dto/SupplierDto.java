package ir.irisa.marketplace.ws.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class SupplierDto {
    private long id;
    private String publicId;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String encryptedPassword;
    private String role;
    private String companyName;
    private boolean enable;
}
