package app.inventario.inventario.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.inventario.inventario.Entities.Producto;
import app.inventario.inventario.Exceptions.RecursoNoEncontradoExcepcion;
import app.inventario.inventario.Services.ProductoServicio;

@RestController
//  http://localhost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
	
	@Autowired
	private ProductoServicio ps;
	
	@GetMapping("/productos")
	public List<Producto> obtenerProductos(){
		List<Producto> productos = this.ps.listarProductos();
		logger.info("Productos en el inventario:");
		productos.forEach((producto -> logger.info(producto.toString())));
		return productos;
	}
	
	@PostMapping("/productos")
	public Producto agregarProducto(@RequestBody Producto producto) {
		logger.info("Producto a agregar: " + producto);
		return this.ps.guardarProducto(producto);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
		Producto producto = this.ps.buscarPorId(id);
		if(producto!=null)
			return ResponseEntity.ok(producto);
		else
			throw new RecursoNoEncontradoExcepcion("No se encontro el id seleccionado");
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido){
		Producto producto = this.ps.buscarPorId(id);
		if(producto==null)
			throw new RecursoNoEncontradoExcepcion("No se encontro el id seleccionado");
		else
			producto.setDescripcion(productoRecibido.getDescripcion());
			producto.setPrecio(productoRecibido.getPrecio());
			producto.setExistencia(productoRecibido.getExistencia());
			this.ps.guardarProducto(producto);
			return ResponseEntity.ok(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
		Producto producto = ps.buscarPorId(id);
		if(producto==null)
			throw new RecursoNoEncontradoExcepcion("No se encontro el id seleccionado");
		else
			this.ps.eliminarProducto(producto);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminado", Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	}
}
