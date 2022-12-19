package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "oficina")
public class Oficina {

    @Id
    @Column(name = "cod_oficina")
    private String codigo;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "municipios")
    private Municipio municipios;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "centrosClasificacion")
    private CentroDeClasificacion centrosClasificacion;

    @OneToMany(mappedBy = "oficinas", cascade = CascadeType.ALL)
    private Set<Coche> coches;

    @OneToMany(mappedBy = "oficinas", cascade = CascadeType.ALL)
    private Set<AreaDeEnvio> areasDeEnvio;

    @OneToMany(mappedBy = "oficinas", cascade = CascadeType.ALL)
    private Set<Turno> turnos;

    @ManyToMany(mappedBy = "oficinas", cascade = CascadeType.ALL)
    private Set<Cartero> carteros;

    public Oficina(String codigo, Municipio municipios, CentroDeClasificacion centrosClasificacion) {
        this.codigo = codigo;
        this.municipios = municipios;
        this.centrosClasificacion = centrosClasificacion;
        this.coches = new HashSet<Coche>();
        this.areasDeEnvio = new HashSet<AreaDeEnvio>();
        this.turnos = new HashSet<Turno>();
        this.carteros = new HashSet<Cartero>();
    }

    public String getCodigo() {
        return codigo;
    }

    public Municipio getMunicipios() {
        return municipios;
    }

    public CentroDeClasificacion getCentrosClasificacion() {
        return centrosClasificacion;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public Set<AreaDeEnvio> getAreasDeEnvio() {
        return areasDeEnvio;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public Set<Cartero> getCarteros() {
        return carteros;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMunicipios(Municipio municipios) {
        this.municipios = municipios;
    }

    public void setCentrosClasificacion(CentroDeClasificacion centrosClasificacion) {
        this.centrosClasificacion = centrosClasificacion;
    }
}
