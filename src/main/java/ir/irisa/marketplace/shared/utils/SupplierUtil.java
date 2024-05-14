package ir.irisa.marketplace.shared.utils;

import ir.irisa.marketplace.ws.model.dto.SupplierDto;
import ir.irisa.marketplace.ws.model.entity.SupplierEntity;
import ir.irisa.marketplace.ws.model.request.SupplierRequest;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SupplierUtil extends Util{
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public SupplierUtil(ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public SupplierDto convert(SupplierRequest supplierRequest) {
        SupplierDto supplierDto = modelMapper.map(supplierRequest, SupplierDto.class);
        supplierDto.setPublicId(generateId());
        supplierDto.setEncryptedPassword(passwordEncoder.encode(supplierDto.getPassword()));
        return supplierDto;
    }
    public <T> T convert(SupplierDto supplierDto, Class<T> t) {
        return modelMapper.map(supplierDto, t);
    }
    public SupplierDto convert(SupplierEntity supplierEntity) {
        return modelMapper.map(supplierEntity, SupplierDto.class);
    }
}
