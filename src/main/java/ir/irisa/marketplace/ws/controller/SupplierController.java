package ir.irisa.marketplace.ws.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import ir.irisa.marketplace.shared.model.BaseApiResponse;
import ir.irisa.marketplace.ws.model.request.SupplierRequest;
import ir.irisa.marketplace.ws.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@Tag(name = "Suppliers", description = "Supplier endpoints")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    @Operation(summary = "Add a new supplier into database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "409",
                    description = "A supplier with this username is already exist",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "Return a stored supplier",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error in getting role",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "System Default Exception (SDE), or when database IO exception occurred",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            )
    })
    public ResponseEntity<BaseApiResponse> createASupplier(@Valid @RequestBody SupplierRequest supplierRequest){
        return supplierService.createASupplier(supplierRequest);
    }

    @GetMapping
    @Operation(summary = "Get list of suppliers")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Return list of suppliers",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "System Default Exception (SDE), or when database IO exception occurred",
                    content = {@Content(mediaType = "application/json"), @Content(mediaType = "application/xml")}
            )
    })
    public ResponseEntity<BaseApiResponse> getAllSupplier(){
        return supplierService.getAllSupplier();
    }

}
