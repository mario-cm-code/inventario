import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html'
})
export class EditarProductoComponent {
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
    this.actualizarProducto();
  }

  actualizarProducto(){
    return this.productoServicio.actualizarProducto(this.id, this.producto).subscribe(
      {
        next: (datos) => this.irProductoLista()
        ,
        error: (errores) => console.log(errores)
      }
    )
  }

  irProductoLista(){
    this.enrutador.navigate(['productos']);
  }
}
