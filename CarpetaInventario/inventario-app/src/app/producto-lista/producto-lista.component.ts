import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html',
})
export class ProductoListaComponent {
  productos: Producto[];

  constructor(private productoServicio: ProductoService, private enrutador: Router

  ){}

  ngOnInit(){
    this.obtenerProductos();
  }

  private obtenerProductos(){
    this.productoServicio.obtenerProductosLista().subscribe(
      (datos => {
        this.productos = datos;
      })
    );
  }

    editarProducto(id: number){
    this.enrutador.navigate(['editar-producto/', id]);
  }
    eliminarProducto(id: number){
    this.enrutador.navigate(['eliminar-producto/', id]);
  }
}
