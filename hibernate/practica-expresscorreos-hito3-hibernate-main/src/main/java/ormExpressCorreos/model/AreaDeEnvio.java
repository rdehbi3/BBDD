package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "areaDeEnvio")
public class AreaDeEnvio {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "oficinas")
    private Oficina oficinas;

    @ManyToMany(mappedBy = "areasDeEnvio", cascade = CascadeType.ALL)
    private Set<Segmento> segmentos;

    @ManyToMany(mappedBy = "areasDeEnvio", cascade = CascadeType.ALL)
    private Set<AreaDeEnvio> areasDeEnvio;

    @ManyToMany(mappedBy = "areasDeEnvio", cascade = CascadeType.ALL)
    private Set<Cartero> carteros;

    public AreaDeEnvio(Integer id, Oficina oficinas) {
        this.id = id;
        this.oficinas = oficinas;
        this.segmentos = new HashSet<Segmento>();
        this.areasDeEnvio = new HashSet<AreaDeEnvio>();
        this.carteros = new HashSet<Cartero>();
    }

    public Integer getId() {
        return id;
    }

    public Oficina getOficinas() {
        return oficinas;
    }

    public Set<Segmento> getSegmentos() {
        return segmentos;
    }

    public Set<AreaDeEnvio> getAreasDeEnvio() {
        return areasDeEnvio;
    }

    public Set<Cartero> getCarteros() {
        return carteros;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOficinas(Oficina oficinas) {
        this.oficinas = oficinas;
    }
}
