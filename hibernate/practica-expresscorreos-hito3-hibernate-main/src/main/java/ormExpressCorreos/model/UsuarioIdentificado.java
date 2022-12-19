package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarioIdentificado")
public class UsuarioIdentificado {
    @Id
    @Column(name = "DNI")
    private String DNI;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuariosIdentificadosR")
    private UsuarioIdentificado usuariosIdentificados;

    @ManyToMany(mappedBy = "usuariosIdentificados", cascade = CascadeType.ALL)
    private Set<Cartero> carteros;

    @ManyToMany(mappedBy = "usuariosIdentificados1", cascade = CascadeType.ALL)
    private Set<CartaCertificada> cartasCertificadas1;

    @ManyToMany(mappedBy = "usuariosIdentificados", cascade = CascadeType.ALL)
    private Set<Direccion> direcciones;

    @OneToMany(mappedBy = "usuariosIdentificados", cascade = CascadeType.ALL)
    private Set<UsuarioIdentificado> usuariosIdentificadosR;

    @OneToMany(mappedBy = "usuariosIdentificados", cascade = CascadeType.ALL)
    private Set<CartaCertificada> cartasCertificadas;

    @OneToMany(mappedBy = "usuariosIdentificados", cascade = CascadeType.ALL)
    private Set<Recogida> recogidas;

    public UsuarioIdentificado() {
    }

    public UsuarioIdentificado(String DNI, String nombre, String apellidos, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.carteros = new HashSet<Cartero>();
        this.cartasCertificadas1 = new HashSet<CartaCertificada>();
        this.direcciones = new HashSet<Direccion>();
        this.usuariosIdentificadosR = new HashSet<UsuarioIdentificado>();
        this.cartasCertificadas = new HashSet<CartaCertificada>();
        this.recogidas = new HashSet<Recogida>();
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioIdentificado getUsuariosIdentificados() {
        return usuariosIdentificados;
    }

    public Set<Cartero> getCarteros() {
        return carteros;
    }

    public Set<CartaCertificada> getCartasCertificadas1() {
        return cartasCertificadas1;
    }

    public Set<Direccion> getDirecciones() {
        return direcciones;
    }

    public Set<UsuarioIdentificado> getUsuariosIdentificadosR() {
        return usuariosIdentificadosR;
    }

    public Set<CartaCertificada> getCartasCertificadas() {
        return cartasCertificadas;
    }

    public Set<Recogida> getRecogidas() {
        return recogidas;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsuariosIdentificados(UsuarioIdentificado usuariosIdentificados) {
        this.usuariosIdentificados = usuariosIdentificados;
    }
}
