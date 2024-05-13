package ir.irisa.marketplace.ws.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String role;
    private String companyName;
    private boolean enable;
}
