package app.inventario.inventario.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id_producto;
    String Descripcion;
    Double precio;
    Integer existencia;
}