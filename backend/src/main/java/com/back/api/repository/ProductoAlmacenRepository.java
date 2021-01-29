package com.back.api.repository;
import com.back.api.models.ProductoAlmacenModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductoAlmacenRepository extends JpaRepository<ProductoAlmacenModel, Long> {
}
