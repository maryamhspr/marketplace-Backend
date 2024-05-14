package ir.irisa.marketplace.ws.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ir.irisa.marketplace.shared.model.BaseApiResponse;
import ir.irisa.marketplace.ws.model.request.ProductRequest;
import ir.irisa.marketplace.ws.service.ProductSupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-supplier")
public class ProductSupplierController {

    private final ProductSupplierService productSupplierService;

    public ProductSupplierController(ProductSupplierService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }

    @PostMapping("/{publicId}")
    @Operation(summary = "Add a new product by a supplier into database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    description = "A supplier with this username is not found",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "Return a stored product",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "System Default Exception (SDE), or when database IO exception occurred",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            )
    })
    public ResponseEntity<BaseApiResponse> createAProduct(@Valid @RequestBody ProductRequest productRequest,
                                                          @PathVariable String publicId){
        return productSupplierService.createAProduct(publicId, productRequest);

    }
}
