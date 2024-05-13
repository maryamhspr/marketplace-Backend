package ir.irisa.marketplace.ws.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierRequest {
    @Schema(description = "Firstname for supplier", example = "Mahya")
    private String firstname;
    @Schema(description = "Lastname for supplier", example = "Jafari")
    private String lastname;
    @Schema(description = "Username for supplier", example = "M-Jafari")
    private String username;
    @Schema(description = "Password for supplier", example = "123@bgh")
    private String password;
    @Schema(description = "Role for supplier", example = "SUPPLIER")
    private String role;
    @Schema(description = "Company name for supplier", example = "MhYA")
    private String companyName;
    @Schema(description = "Enable for supplier", example = "true")
    private boolean enable;
}
