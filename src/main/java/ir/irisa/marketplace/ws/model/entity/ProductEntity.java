package ir.irisa.marketplace.ws.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String publicId;

    @Size(
            min = 2, max = 20,
            message = "Product name should have a length between 2 and 20 characters.")
    private String name;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderEntity> ordersList;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductSupplierEntity> productSupplierList;
}
