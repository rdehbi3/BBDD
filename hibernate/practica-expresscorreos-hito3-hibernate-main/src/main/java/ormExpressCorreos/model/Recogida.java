package ormExpressCorreos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recogida")
public class Recogida {

    @Id
    @Column(name = "id_recogida")
    private Integer id;

    @Column(name = "fecha_recogida")
    private Date fecha;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteros")
    private Cartero carteros;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "direcciones")
    private Direccion direcciones;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuariosIdentificados")
    private UsuarioIdentificado usuariosIdentificados;

    @OneToMany(mappedBy = "recogidas", cascade = CascadeType.ALL)
    private Set<Paquete> paquetes;

    public Recogida(Integer id, Date fecha, Cartero carteros, Direccion direcciones, UsuarioIdentificado usuariosIdentificados) {
        this.id = id;
        this.fecha = fecha;
        this.carteros = carteros;
        this.direcciones = direcciones;
        this.usuariosIdentificados = usuariosIdentificados;
        this.paquetes = new HashSet<Paquete>();
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cartero getCarteros() {
        return carteros;
    }

    public Direccion getDirecciones() {
        return direcciones;
    }

    public UsuarioIdentificado getUsuariosIdentificados() {
        return usuariosIdentificados;
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

    public void setCarteros(Cartero carteros) {
        this.carteros = carteros;
    }

    public void setDirecciones(Direccion direcciones) {
        this.direcciones = direcciones;
    }

    public void setUsuariosIdentificados(UsuarioIdentificado usuariosIdentificados) {
        this.usuariosIdentificados = usuariosIdentificados;
    }
}
