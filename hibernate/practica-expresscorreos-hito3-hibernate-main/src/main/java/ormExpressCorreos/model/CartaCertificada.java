package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartaCertificada")
public class CartaCertificada {

    @Id
    @Column(name = "id_Cc")
    private String id;

    @Column(name = "nivelUrgencia")
    private Integer nivelUrgencia;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "repartos")
    private Reparto repartos;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteros")
    private Cartero carteros;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuariosIdentificados")
    private UsuarioIdentificado usuariosIdentificados;

    @ManyToMany(mappedBy = "cartasCertificadas", cascade = CascadeType.ALL)
    private Set<UsuarioIdentificado> usuariosIdentificados1;

    public CartaCertificada(String id, Integer nivelUrgencia, Reparto repartos, Cartero carteros, UsuarioIdentificado usuariosIdentificados) {
        this.id = id;
        this.nivelUrgencia = nivelUrgencia;
        this.repartos = repartos;
        this.carteros = carteros;
        this.usuariosIdentificados = usuariosIdentificados;
        this.usuariosIdentificados1 = new HashSet<UsuarioIdentificado>();
    }

    public String getId() {
        return id;
    }

    public Integer getNivelUrgencia() {
        return nivelUrgencia;
    }

    public Reparto getRepartos() {
        return repartos;
    }

    public Cartero getCarteros() {
        return carteros;
    }

    public UsuarioIdentificado getUsuariosIdentificados() {
        return usuariosIdentificados;
    }

    public Set<UsuarioIdentificado> getUsuariosIdentificados1() {
        return usuariosIdentificados1;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNivelUrgencia(Integer nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    public void setRepartos(Reparto repartos) {
        this.repartos = repartos;
    }

    public void setCarteros(Cartero carteros) {
        this.carteros = carteros;
    }

    public void setUsuariosIdentificados(UsuarioIdentificado usuariosIdentificados) {
        this.usuariosIdentificados = usuariosIdentificados;
    }
}
