package ormExpressCorreos.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @Column(name = "jornada")
    private Integer jornada;

    @Column(name = "hora_ini")
    private Time horaIni;

    @Column(name = "hora_FIN")
    private Time horaFin;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "oficinas")
    private Oficina oficinas;

    @ManyToMany(mappedBy = "turnos", cascade = CascadeType.ALL)
    private Set<Cartero> carteros;

    public Turno(Integer jornada, Time horaIni, Time horaFin, Oficina oficinas) {
        this.jornada = jornada;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
        this.oficinas = oficinas;
        this.carteros = new HashSet<Cartero>();
    }

    public Integer getJornada() {
        return jornada;
    }

    public Time getHoraIni() {
        return horaIni;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public Oficina getOficinas() {
        return oficinas;
    }

    public Set<Cartero> getCarteros() {
        return carteros;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public void setHoraIni(Time horaIni) {
        this.horaIni = horaIni;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public void setOficinas(Oficina oficinas) {
        this.oficinas = oficinas;
    }
}
