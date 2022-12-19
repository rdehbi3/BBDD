package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @Column(name = "provincia")
    private String nombre;

    @OneToMany(mappedBy = "provincias", cascade = CascadeType.ALL )
    private Set<Municipio> municipios;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.municipios = new HashSet<Municipio>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Municipio> getMunicipios() {
        return municipios;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
