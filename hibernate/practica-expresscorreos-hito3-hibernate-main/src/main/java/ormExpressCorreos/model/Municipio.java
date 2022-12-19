package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @Column(name = "nombre")
    private String Nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Calle calle;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "provincias")
    private Provincia provincias;

    @OneToMany(mappedBy = "municipios", cascade = CascadeType.ALL)
    private Set<Oficina> oficinas;

    @OneToMany(mappedBy = "municipios", cascade = CascadeType.ALL)
    private Set<CentroDeClasificacion> centrosClasificacion;

    public Municipio(String nombre, Calle calle, Provincia provincias) {
        Nombre = nombre;
        this.calle = calle;
        this.provincias = provincias;
        this.oficinas = new HashSet<Oficina>();
        this.centrosClasificacion = new HashSet<CentroDeClasificacion>();
    }
    public Municipio(String nombre, Provincia provincias) {
        Nombre = nombre;
        this.provincias = provincias;
        this.oficinas = new HashSet<Oficina>();
        this.centrosClasificacion = new HashSet<CentroDeClasificacion>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public Set<Oficina> getOficinas() {
        return oficinas;
    }

    public Set<CentroDeClasificacion> getCentrosClasificacion() {
        return centrosClasificacion;
    }

    public Provincia getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincia provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "Nombre='" + Nombre + '\'' +
                ", provincias=" + provincias.toString() +
                '}';
    }
}
