package ir.irisa.marketplace.ws.model.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ProductDto {
    private long id;
    private String publicId;
    private String name;
    private String description;
    private BigDecimal price;
}
