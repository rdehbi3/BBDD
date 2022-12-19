package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// @TODO completar las anotaciones de la clase
@Entity
@Table(name = "usuarioGenerico")
public class UsuarioGenerico {

    @Id
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "direcciones")
    private Direccion direcciones;

    @OneToMany(mappedBy = "usuariosGenericos", cascade = CascadeType.ALL)
    private Set<Paquete> paquetes;

    @OneToMany(mappedBy = "usuariosGenericos", cascade = CascadeType.ALL)
    private Set<Carta> cartas;

    public UsuarioGenerico() {
    }

    public UsuarioGenerico(Long id, String nombre, String apellidos, Direccion direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcciones = direcciones;
        this.paquetes = new HashSet<Paquete>();
        this.cartas = new HashSet<Carta>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Direccion getDirecciones() {
        return direcciones;
    }

    public Set<Paquete> getPaquetes() {
        return paquetes;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDirecciones(Direccion direcciones) {
        this.direcciones = direcciones;
    }
}

