import { Component } from '@angular/core';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../producto';

@Component({
  selector: 'app-eliminar-producto',
  templateUrl: './eliminar-producto.component.html',
})
export class EliminarProductoComponent {
  producto: Producto = new Producto();
  id: number;

  constructor(private productoServicio: ProductoService, private ruta: ActivatedRoute, private enrutador: Router){}

  ngOnInit(){
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obtenerProductoPorId(this.id).subscribe(
      {
        next: (datos) => this.producto = datos
        ,
        error: (errores: any) => console.log(errores)
      }
    );
  }
  
  onSubmit(){
    this.productoServicio.eliminarProducto(this.id).subscribe(
      {
        next: (datos) => this.irProductoLista()
        ,
        error: (errores) => console.log(errores)
      }
    )
  }

  irProductoLista(){
    this.enrutador.navigate(['productos'])
  }
}
