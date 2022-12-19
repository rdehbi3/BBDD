package ormExpressCorreos.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "segmento")
public class Segmento {

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "numIni")
    private Integer numIni;

    @Column(name = "numFin")
    private Integer numFin;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "calles")
    private Calle calles;

    @ManyToMany(mappedBy = "segmentos", cascade = CascadeType.ALL)
    private Set<AreaDeEnvio> areasDeEnvio;

    @ManyToMany(mappedBy = "segmentos", cascade = CascadeType.ALL)
    private Set<Ruta> rutas;

    public Segmento(Integer orden, Integer numIni, Integer numFin, Calle calles) {
        this.orden = orden;
        this.numIni = numIni;
        this.numFin = numFin;
        this.calles = calles;
        this.areasDeEnvio = new HashSet<AreaDeEnvio>();
        this.rutas = new HashSet<Ruta>();
    }

    public Integer getOrden() {
        return orden;
    }

    public Integer getNumIni() {
        return numIni;
    }

    public Integer getNumFin() {
        return numFin;
    }

    public Calle getCalles() {
        return calles;
    }

    public Set<AreaDeEnvio> getAreasDeEnvio() {
        return areasDeEnvio;
    }

    public Set<Ruta> getRutas() {
        return rutas;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public void setNumIni(Integer numIni) {
        this.numIni = numIni;
    }

    public void setNumFin(Integer numFin) {
        this.numFin = numFin;
    }

    public void setCalles(Calle calles) {
        this.calles = calles;
    }
}
