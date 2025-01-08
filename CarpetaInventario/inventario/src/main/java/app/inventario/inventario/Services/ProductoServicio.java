package app.inventario.inventario.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.inventario.inventario.Entities.Producto;
import app.inventario.inventario.Repositories.ProductoRepositorio;

@Service
public class ProductoServicio{

	@Autowired
	private ProductoRepositorio pr;
	
	public List<Producto> listarProductos() {
		return pr.findAll();
	}

	public Producto buscarPorId(Integer idProducto) {
		return pr.findById(idProducto).orElse(null);
	}

	public Producto guardarProducto(Producto producto) {
		return pr.save(producto);
	}

	public void eliminarProducto(Producto producto) {
		pr.delete(producto);
		
	}

}
