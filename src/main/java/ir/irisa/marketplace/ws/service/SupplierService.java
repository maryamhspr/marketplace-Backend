package ir.irisa.marketplace.ws.service;

import ir.irisa.marketplace.shared.model.BaseApiResponse;
import ir.irisa.marketplace.ws.model.request.SupplierRequest;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<BaseApiResponse> createASupplier(SupplierRequest supplierRequest);

    ResponseEntity<BaseApiResponse> getAllSupplier();
}
