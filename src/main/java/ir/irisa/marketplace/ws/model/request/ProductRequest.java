package ir.irisa.marketplace.ws.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    @Schema(description = "Name for product", example = "Laptop")
    private String name;
    @Schema(description = "Description for product", example = "The brand of this laptop is Asus...")
    private String description;
    @Schema(description = "Price for product", example = "120000")
    private BigDecimal price;
}
