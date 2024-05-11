package ir.irisa.marketplace.ws.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")
@PrimaryKeyJoinColumn(name = "supplier_id")
public class SupplierEntity extends UserEntity{

    @Size(
            min = 2, max = 20,
            message = "Company name should have a length between 2 and 20 characters.")
    private String companyName;

    private boolean isEnable;

    @OneToMany(mappedBy = "supplierEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductSupplierEntity> productSupplierList;
}
