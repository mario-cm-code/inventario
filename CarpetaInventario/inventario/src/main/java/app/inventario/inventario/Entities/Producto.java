package app.inventario.inventario.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="producto_sequence")
    @SequenceGenerator(name="producto_sequence", sequenceName="producto_sequence", allocationSize=100)
    private Long id_producto;
    private String Descripcion;
    private Double precio;
    private Integer existencia;
}