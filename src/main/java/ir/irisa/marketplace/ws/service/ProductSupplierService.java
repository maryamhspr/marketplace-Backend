package ir.irisa.marketplace.ws.service;

import ir.irisa.marketplace.shared.model.BaseApiResponse;
import ir.irisa.marketplace.ws.model.request.ProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductSupplierService {
    ResponseEntity<BaseApiResponse> createAProduct(String publicId, ProductRequest productRequest);
}
