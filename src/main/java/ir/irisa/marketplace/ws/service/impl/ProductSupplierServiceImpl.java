package ir.irisa.marketplace.ws.service.impl;

import ir.irisa.marketplace.config.exception.SystemServiceException;
import ir.irisa.marketplace.config.exception.constant.ExceptionMessages;
import ir.irisa.marketplace.shared.model.BaseApiResponse;
import ir.irisa.marketplace.shared.utils.ProductSupplierUtil;
import ir.irisa.marketplace.ws.model.dto.ProductDto;
import ir.irisa.marketplace.ws.model.entity.ProductEntity;
import ir.irisa.marketplace.ws.model.entity.ProductSupplierEntity;
import ir.irisa.marketplace.ws.model.entity.SupplierEntity;
import ir.irisa.marketplace.ws.model.request.ProductRequest;
import ir.irisa.marketplace.ws.model.response.ProductResponse;
import ir.irisa.marketplace.ws.repository.ProductRepository;
import ir.irisa.marketplace.ws.repository.ProductSupplierRepository;
import ir.irisa.marketplace.ws.repository.SupplierRepository;
import ir.irisa.marketplace.ws.service.ProductSupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

    private final SupplierRepository supplierRepository;

    private final ProductSupplierUtil util;

    private final ProductRepository productRepository;

    private final ProductSupplierRepository productSupplierRepository;

    public ProductSupplierServiceImpl(SupplierRepository supplierRepository, ProductSupplierUtil util, ProductRepository productRepository, ProductSupplierRepository productSupplierRepository) {
        this.supplierRepository = supplierRepository;
        this.util = util;
        this.productRepository = productRepository;
        this.productSupplierRepository = productSupplierRepository;
    }

    @Override
    public ResponseEntity<BaseApiResponse> createAProduct(String publicId, ProductRequest productRequest) {
        SupplierEntity supplierEntity =supplierRepository.findByPublicId(publicId).orElseThrow(() ->
                new SystemServiceException(ExceptionMessages.NO_RECORD_FOUND.getMessage(), HttpStatus.NOT_FOUND)
        );
        ProductDto productDto = util.convert(productRequest);
        ProductEntity productEntity = util.convert(productDto, ProductEntity.class);
        ProductEntity savedProduct;
        try {
            savedProduct = productRepository.save(productEntity);
        }catch (Exception exception) {
            throw new SystemServiceException(ExceptionMessages.DATABASE_IO_EXCEPTION.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ProductSupplierEntity productSupplierEntity = ProductSupplierEntity.builder()
                .productEntity(productEntity)
                .supplierEntity(supplierEntity)
                .price(productDto.getPrice())
                .build();
        ProductSupplierEntity savedProductSupplier;
        try {
            savedProductSupplier = productSupplierRepository.save(productSupplierEntity);
        }catch (Exception exception) {
            throw new SystemServiceException(ExceptionMessages.DATABASE_IO_EXCEPTION.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ProductDto savedProductDto = util.convert(savedProduct,savedProductSupplier.getPrice());
        return util.createResponse(util.convert(savedProductDto, ProductResponse.class), HttpStatus.CREATED);
    }
}
