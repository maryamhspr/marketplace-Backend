package ir.irisa.marketplace.shared.utils;

import ir.irisa.marketplace.ws.model.dto.ProductDto;
import ir.irisa.marketplace.ws.model.dto.SupplierDto;
import ir.irisa.marketplace.ws.model.entity.ProductEntity;
import ir.irisa.marketplace.ws.model.entity.SupplierEntity;
import ir.irisa.marketplace.ws.model.request.ProductRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductSupplierUtil extends Util{
    private final ModelMapper modelMapper;

    public ProductSupplierUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDto convert(ProductRequest productRequest) {
        ProductDto productDto = modelMapper.map(productRequest, ProductDto.class);
        productDto.setPublicId(generateId());
        return productDto;
    }

    public <T> T convert(ProductDto productDto, Class<T> t) {
        return modelMapper.map(productDto, t);
    }
    public ProductDto convert(ProductEntity productEntity, BigDecimal price) {
        ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
        productDto.setPrice(price);
        return productDto;

    }
}
