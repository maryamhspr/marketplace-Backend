package ir.irisa.marketplace.ws.repository;

import ir.irisa.marketplace.ws.model.entity.ProductSupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplierEntity, Long> {
}
