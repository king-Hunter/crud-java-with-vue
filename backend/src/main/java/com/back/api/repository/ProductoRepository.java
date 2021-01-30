package com.back.api.repository;



import com.back.api.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer> {
    
    /*@Query("SELECT curso.m_producto.id_producto, curso.m_producto.nombre, curso.m_producto.fecha_modificacion, curso.m_producto.id_tipo_producto, curso.m_producto.registro_activo, curso.m_producto.usuario_modificacion, curso.c_tipo_producto.tipo_producto, curso.c_tipo_producto.registro_activo FROM curso.m_producto INNER JOIN curso.c_tipo_producto ON curso.c_tipo_producto.id_tipo_producto = curso.m_producto.id_tipo_producto")
    
 public List<ProductoModel> obtenerProductoConTipo();*/
}
