package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reparto")
public class Reparto {

    @Id
    @Column(name = "id_reparto")
    private Integer id;

    @Column(name = "fecha_reparto")
    private Date fecha;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "rutas")
    private Ruta rutas;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "coches")
    private Coche coches;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteros")
    private Cartero carteros;

    @OneToMany(mappedBy = "repartos", cascade = CascadeType.ALL)
    private Set<CartaCertificada> cartasCertificadas;

    @OneToMany(mappedBy = "repartos", cascade = CascadeType.ALL)
    private Set<Carta> cartas;

    @OneToMany(mappedBy = "repartos", cascade = CascadeType.ALL)
    private Set<Paquete> paquetes;

    public Reparto() {
    }

    public Reparto(Integer id, Date fecha, Ruta rutas, Coche coches, Cartero carteros) {
        this.id = id;
        this.fecha = fecha;
        this.rutas = rutas;
        this.coches = coches;
        this.carteros = carteros;
        this.cartasCertificadas = new HashSet<CartaCertificada>();
        this.cartas = new HashSet<Carta>();
        this.paquetes = new HashSet<Paquete>();
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Ruta getRutas() {
        return rutas;
    }

    public Coche getCoches() {
        return coches;
    }

    public Cartero getCarteros() {
        return carteros;
    }

    public Set<CartaCertificada> getCartasCertificadas() {
        return cartasCertificadas;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public Set<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }

    public void setCoches(Coche coches) {
        this.coches = coches;
    }

    public void setCarteros(Cartero carteros) {
        this.carteros = carteros;
    }
}
