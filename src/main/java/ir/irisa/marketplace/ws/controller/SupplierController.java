package ir.irisa.marketplace.ws.controller;

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
    public ResponseEntity<BaseApiResponse> createASupplier(@Valid @RequestBody SupplierRequest supplierRequest){
        return supplierService.createASupplier(supplierRequest);
    }

    @GetMapping
    public ResponseEntity<BaseApiResponse> getAllSupplier(){
        return supplierService.getAllSupplier();
    }

}
