package ormExpressCorreos.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Phaser;

@Entity
@Table(name = "ruta")
public class Ruta {

    @Id
    @Column(name = "id_ruta")
    private Integer id;

    @ManyToMany(mappedBy = "rutas", cascade = CascadeType.ALL)
    private Set<Segmento> segmentos;

    @OneToMany(mappedBy = "rutas", cascade = CascadeType.ALL)
    private Set<Reparto> repartos;

    public Ruta(Integer id) {
        this.id = id;
        this.segmentos = new HashSet<Segmento>();
        this.repartos = new HashSet<Reparto>();
    }

    public Integer getId() {
        return id;
    }

    public Set<Segmento> getSegmentos() {
        return segmentos;
    }

    public Set<Reparto> getRepartos() {
        return repartos;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
