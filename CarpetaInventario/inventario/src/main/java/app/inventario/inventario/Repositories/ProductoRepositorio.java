package app.inventario.inventario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.inventario.inventario.Entities.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}
