package ir.irisa.marketplace.ws.service.impl;

import ir.irisa.marketplace.config.exception.SystemServiceException;
import ir.irisa.marketplace.config.exception.constant.ExceptionMessages;
import ir.irisa.marketplace.shared.model.BaseApiResponse;
import ir.irisa.marketplace.shared.utils.SupplierUtil;
import ir.irisa.marketplace.ws.model.dto.SupplierDto;
import ir.irisa.marketplace.ws.model.entity.SupplierEntity;
import ir.irisa.marketplace.ws.model.request.SupplierRequest;
import ir.irisa.marketplace.ws.model.response.SupplierResponse;
import ir.irisa.marketplace.ws.repository.SupplierRepository;
import ir.irisa.marketplace.ws.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierUtil util;
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierUtil util, SupplierRepository supplierRepository) {
        this.util = util;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ResponseEntity<BaseApiResponse> createASupplier(SupplierRequest supplierRequest) {
        if(!supplierRequest.getRole().equals("SUPPLIER"))
            throw new SystemServiceException(ExceptionMessages.INVALID_ROLE.getMessage(), HttpStatus.BAD_REQUEST);
        Optional<SupplierEntity> existedSupplier = supplierRepository.findByUsername(supplierRequest.getUsername());
        if (existedSupplier.isPresent())
            throw new SystemServiceException(ExceptionMessages.RECORD_ALREADY_EXISTS.getMessage(), HttpStatus.CONFLICT);
        SupplierDto supplierDto = util.convert(supplierRequest);
        SupplierEntity supplierEntity = util.convert(supplierDto, SupplierEntity.class);
        try {
            SupplierEntity savedSupplier = supplierRepository.save(supplierEntity);
            SupplierDto savedSupplierDto = util.convert(savedSupplier);
            return util.createResponse(util.convert(savedSupplierDto, SupplierResponse.class), HttpStatus.CREATED);
        }catch (Exception exception) {
            throw new SystemServiceException(ExceptionMessages.DATABASE_IO_EXCEPTION.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BaseApiResponse> getAllSupplier() {
        List<SupplierResponse> response = supplierRepository.findAll().stream()
                .map(util::convert)
                .map(supplierDto -> util.convert(supplierDto, SupplierResponse.class))
                .toList();
        return util.createResponse(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseApiResponse> editEnable(String publicId, boolean newEnable) {
        SupplierEntity supplierEntity =supplierRepository.findByPublicId(publicId).orElseThrow(() ->
                new SystemServiceException(ExceptionMessages.NO_RECORD_FOUND.getMessage(), HttpStatus.NOT_FOUND)
        );
        supplierEntity.setEnable(newEnable);
        SupplierEntity savedSupplier;
        try {
            savedSupplier = supplierRepository.save(supplierEntity);
            SupplierDto savedSupplierDto = util.convert(savedSupplier);
            return util.createResponse(util.convert(savedSupplierDto, SupplierResponse.class), HttpStatus.OK);
        }catch (Exception exception) {
            throw new SystemServiceException(ExceptionMessages.DATABASE_IO_EXCEPTION.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
