import { provideHttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ProductoService } from './producto.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
//  providers: [provideHttpClient()]
})
export class AppComponent {
  title = 'inventario-app';
}
