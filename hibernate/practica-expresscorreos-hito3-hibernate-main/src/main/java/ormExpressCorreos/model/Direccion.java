package ormExpressCorreos.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

// @TODO completar las anotaciones de la clase
@Entity
@Table(name = "direccion")
public class Direccion {

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "piso")
    private Integer piso;

    @Column(name = "letra")
    private String letra;

    @Column(name = "portal")
    private String portal;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "calles")
    private Calle calles;

    @ManyToMany(mappedBy = "direcciones", cascade = CascadeType.ALL)
    private Set<UsuarioIdentificado> usuariosIdentificados;

    @OneToMany(mappedBy = "direcciones", cascade = CascadeType.ALL)
    private Set<UsuarioGenerico> usuarioGenericos;

    @OneToMany(mappedBy = "direcciones", cascade = CascadeType.ALL)
    private Set<Recogida> recogidas;


    // @TODO completar las anotaciones de todos los atributos

    public Direccion(Integer numero, Integer piso, String letra, String portal, String comentario, Calle calle) {
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
        this.portal = portal;
        this.comentario = comentario;
        this.calles = calle;
        this.usuarioGenericos = new HashSet<UsuarioGenerico>();
        this.recogidas = new HashSet<Recogida>();

    }
    public Direccion(Integer numero, Integer piso, String letra, String portal, Calle calle) {
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
        this.portal = portal;
        this.calles = calle;
        this.usuarioGenericos = new HashSet<UsuarioGenerico>();
        this.recogidas = new HashSet<Recogida>();

    }
    public Direccion(Integer numero, Integer piso, String letra, Calle calle) {
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
        this.calles = calle;
        this.usuarioGenericos = new HashSet<UsuarioGenerico>();
        this.recogidas = new HashSet<Recogida>();

    }

    public Integer getNumero() {
        return this.numero;
    }
    public void setNumero(Integer numero) {this.numero = numero;}

    public Integer getPiso() {
        return this.piso;
    }
    public void setPiso(Integer piso) {this.piso = piso;}

    public String getLetra() {
        return this.letra;
    }
    public void setLetra(String letra) {this.letra = letra;}

    public String getPortal() {
        return this.portal;
    }
    public void setPortal(String portal) {this.portal = portal;}

    public String getComentario() {
        return this.comentario;
    }
    public void setComentario(String comentario) {this.comentario = comentario;}

    public Calle getCalle() {
        return this.calles;
    }
    public void setCalle(Calle calle) {this.calles = calle;}

    public Set<Recogida> getRecogidas() {
        return recogidas;
    }

    public Set<UsuarioGenerico> getUsuarioGenericos(){
        return usuarioGenericos;
    }


    public String getDireccionCompleta() {
        return "Direccion{" +
                "numero=" + numero +
                ", piso=" + piso +
                ", letra='" + letra + '\'' +
                ", portal='" + portal + '\'' +
                ", comentario='" + comentario + '\'' +
                ", calles=" + calles.toString() +
                '}';
    }
}
