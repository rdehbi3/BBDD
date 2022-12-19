package ormExpressCorreos.model;

import javax.persistence.*;

@Entity
@Table(name = "carta")
public class Carta {

    @Id
    @Column(name = "id_carta")
    private String id;

    @Column(name = "formato")
    private String formato;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "repartos")
    private Reparto repartos;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteros")
    private Cartero carteros;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuariosGenericos")
    private UsuarioGenerico usuariosGenericos;

    public Carta(String id, String formato, Reparto repartos, Cartero carteros, UsuarioGenerico usuariosGenericos) {
        this.id = id;
        this.formato = formato;
        this.repartos = repartos;
        this.carteros = carteros;
        this.usuariosGenericos = usuariosGenericos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Reparto getRepartos() {
        return repartos;
    }

    public void setRepartos(Reparto repartos) {
        this.repartos = repartos;
    }

    public Cartero getCarteros() {
        return carteros;
    }

    public void setCarteros(Cartero carteros) {
        this.carteros = carteros;
    }

    public UsuarioGenerico getUsuariosGenericos() {
        return usuariosGenericos;
    }

    public void setUsuariosGenericos(UsuarioGenerico usuariosGenericos) {
        this.usuariosGenericos = usuariosGenericos;
    }
}
