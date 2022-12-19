package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartero")
public class Cartero {

    @Id
    @Column(name = "dni_cartero")
    private String dni;

    @Column(name = "nombre_cartero")
    private String nombre;

    @Column(name = "apellidos_cartero")
    private String apellidos;

    @ManyToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<Oficina> oficinas;

    @ManyToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<Turno> turnos;

    @ManyToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<AreaDeEnvio> areasDeEnvio;

    @ManyToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<UsuarioIdentificado> usuariosIdentificados;

    @OneToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<Reparto> repartos;

    @OneToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<CartaCertificada> cartasCertificadas;

    @OneToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<Carta> cartas;

    @OneToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<Paquete> paquetes;

    @OneToMany(mappedBy = "carteros", cascade = CascadeType.ALL)
    private Set<Recogida> recogidas;

    public Cartero(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oficinas = new HashSet<Oficina>();
        this.turnos = new HashSet<Turno>();
        this.areasDeEnvio = new HashSet<AreaDeEnvio>();
        this.usuariosIdentificados = new HashSet<UsuarioIdentificado>();
        this.repartos = new HashSet<Reparto>();
        this.cartasCertificadas = new HashSet<CartaCertificada>();
        this.cartas = new HashSet<Carta>();
        this.paquetes = new HashSet<Paquete>();
        this.recogidas = new HashSet<Recogida>();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Set<Oficina> getOficinas() {
        return oficinas;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public Set<AreaDeEnvio> getAreasDeEnvio() {
        return areasDeEnvio;
    }

    public Set<UsuarioIdentificado> getUsuariosIdentificados() {
        return usuariosIdentificados;
    }

    public Set<Reparto> getRepartos() {
        return repartos;
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

    public Set<Recogida> getRecogidas() {
        return recogidas;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
