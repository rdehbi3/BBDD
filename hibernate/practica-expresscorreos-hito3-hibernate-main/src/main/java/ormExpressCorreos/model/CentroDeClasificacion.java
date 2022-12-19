package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CentroDeClasificacion")
public class CentroDeClasificacion {

    @Id
    @Column(name = "codigo_cc")
    private String codigo;

    @Column(name = "nombre_centro_clasificacion")
    private String nombre;

    @Column(name = "numMax")
    private Long numMax;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "municipio")
    private Municipio municipios;

    @OneToMany(mappedBy = "centrosClasificacion", cascade = CascadeType.ALL)
    private Set<Oficina> oficinas;

    public CentroDeClasificacion(String codigo, String nombre, Long numMax, Municipio municipios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numMax = numMax;
        this.municipios = municipios;
        this.oficinas = new HashSet<Oficina>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getNumMax() {
        return numMax;
    }

    public Municipio getMunicipios() {
        return municipios;
    }

    public Set<Oficina> getOficinas() {
        return oficinas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumMax(Long numMax) {
        this.numMax = numMax;
    }

    public void setMunicipios(Municipio municipios) {
        this.municipios = municipios;
    }
}
