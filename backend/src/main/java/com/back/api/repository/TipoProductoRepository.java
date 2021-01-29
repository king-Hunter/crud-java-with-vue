package com.back.api.repository;
import com.back.api.models.TipoProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoModel, Long> {
    
}
