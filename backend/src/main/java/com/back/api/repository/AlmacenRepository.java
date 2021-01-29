package com.back.api.repository;
import com.back.api.models.AlmacenModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<AlmacenModel, Long> {
}
