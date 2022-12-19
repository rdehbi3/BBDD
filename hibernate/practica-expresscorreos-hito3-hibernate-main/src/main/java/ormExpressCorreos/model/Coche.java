package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coche")
public class Coche {

    @Id
    @Column(name = "matricula")
    private String matricula;

    @Column(name = "capacidad")
    private Integer capacidad;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "oficinas")
    private Oficina oficinas;

    @OneToMany(mappedBy = "coches", cascade = CascadeType.ALL)
    private Set<Reparto> repartos;

    public Coche(String matricula, Integer capacidad, Oficina oficinas) {
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.oficinas = oficinas;
        this.repartos = new HashSet<Reparto>();
    }

    public String getMatricula() {
        return matricula;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Oficina getOficinas() {
        return oficinas;
    }

    public Set<Reparto> getRepartos() {
        return repartos;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setOficinas(Oficina oficinas) {
        this.oficinas = oficinas;
    }
}
