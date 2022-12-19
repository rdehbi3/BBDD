package ormExpressCorreos.model;

import javax.persistence.*;

@Entity
@Table(name = "paquete")
public class Paquete {

    @Id
    @Column(name = "id_paquete")
    private String id;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "dimension1")
    private Integer dimension1;

    @Column(name = "dimension2")
    private Integer dimension2;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteros")
    private Cartero carteros;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "repartos")
    private Reparto repartos;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "recogidas")
    private Recogida recogidas;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuariosGenericos")
    private UsuarioGenerico usuariosGenericos;

    public Paquete(String id, Integer peso, Integer dimension1, Integer dimension2, Cartero carteros, Reparto repartos, Recogida recogidas, UsuarioGenerico usuariosGenericos) {
        this.id = id;
        this.peso = peso;
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
        this.carteros = carteros;
        this.repartos = repartos;
        this.recogidas = recogidas;
        this.usuariosGenericos = usuariosGenericos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getDimension1() {
        return dimension1;
    }

    public void setDimension1(Integer dimension1) {
        this.dimension1 = dimension1;
    }

    public Integer getDimension2() {
        return dimension2;
    }

    public void setDimension2(Integer dimension2) {
        this.dimension2 = dimension2;
    }

    public Cartero getCarteros() {
        return carteros;
    }

    public void setCarteros(Cartero carteros) {
        this.carteros = carteros;
    }

    public Reparto getRepartos() {
        return repartos;
    }

    public void setRepartos(Reparto repartos) {
        this.repartos = repartos;
    }

    public Recogida getRecogidas() {
        return recogidas;
    }

    public void setRecogidas(Recogida recogidas) {
        this.recogidas = recogidas;
    }

    public UsuarioGenerico getUsuariosGenericos() {
        return usuariosGenericos;
    }

    public void setUsuariosGenericos(UsuarioGenerico usuariosGenericos) {
        this.usuariosGenericos = usuariosGenericos;
    }
}
