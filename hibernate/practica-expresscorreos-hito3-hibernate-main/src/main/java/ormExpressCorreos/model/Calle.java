package ormExpressCorreos.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "calle")
public class Calle {

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "calles", cascade = CascadeType.ALL )
    private Set<Direccion> direcciones;

    @OneToMany(mappedBy = "calles", cascade = CascadeType.ALL)
    private Set<Segmento> segmentos;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Municipio municipio;

    public Calle(String nombre, Municipio municipio) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.direcciones = new HashSet<Direccion>();
        this.segmentos = new HashSet<Segmento>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Direccion> getDirecciones() {
        return direcciones;
    }

    public Set<Segmento> getSegmentos() {
        return segmentos;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirecciones(Set<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void setSegmentos(Set<Segmento> segmentos) {
        this.segmentos = segmentos;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Calle{" +
                "nombre='" + nombre + '\'' +
                ", municipio=" + municipio.toString() +
                '}';
    }
}
