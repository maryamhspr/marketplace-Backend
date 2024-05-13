package ir.irisa.marketplace.ws.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SupplierResponse {
    private String publicId;
    private String firstname;
    private String lastname;
    private String username;
    private String role;
    private String companyName;
    private boolean enable;
}
