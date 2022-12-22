package ormExpressCorreos;

import ormExpressCorreos.model.Calle;
import ormExpressCorreos.model.Direccion;
import ormExpressCorreos.model.UsuarioGenerico;
import ormExpressCorreos.model.UsuarioIdentificado;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;

/**
 * Controlador de la aplicación. Por favor, revise detenidamente la clase y complete las partes omitidas
 * atendiendo a los comentarios indicados mediante @TODO
 */
public class Controller {

    private Session session;

    /**
     * Crea un nuevo controlador
     */
    public Controller () {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        this.session = sessionFactory.openSession();
    }

    /**
     * Crea un nuevo usuario_generico
     * param id id del usuario
     * param nombre nombre del usuario
     * param apellidos apellidos del usuario
     * @return el nuevo usuario creado
     * @throws SQLException
     */
    public UsuarioGenerico createUsuarioGenerico(Long id, String nombre, String apellidos, Direccion direccion) throws SQLException{
        // @TODO completa este metodo para crear de forma presistente un usuario genérico
        UsuarioGenerico usuarioGen = new UsuarioGenerico(id,nombre,apellidos,direccion);
        session.beginTransaction();
        session.saveOrUpdate(usuarioGen);
        session.getTransaction().commit();
        return usuarioGen;

    }

    public UsuarioIdentificado createUsuarioIdentificado(String DNI, String nombre, String apellidos, String email) throws SQLException {
        // @TODO completa este metodo para crear de forma presistente un usuario identificado
        UsuarioIdentificado usuarioIden = new UsuarioIdentificado(DNI,nombre,apellidos,email);
        session.beginTransaction();
        session.saveOrUpdate(usuarioIden);
        session.getTransaction().commit();
        return usuarioIden;

    }

    public UsuarioIdentificado createDireccion(Integer numero, Integer piso, String letra, String portal, String comentario, Calle calle) throws SQLException {
        // @TODO completa este metodo para crear de forma presistente una direccion
        UsuarioIdentificado nuevo = new UsuarioIdentificado();
        Direccion nuevadir = new Direccion(numero,piso,letra,portal,comentario,calle);
        nuevo.getDirecciones().add(nuevadir);
        session.beginTransaction();
        session.saveOrUpdate(nuevo);
        session.getTransaction().commit();
        return nuevo;
    }

    public Calle createCalle(String nombre, Municipio municipio,Provincia provincia) throws SQLException{
        Calle calle= new Calle(nombre,municipio,provincia);
        session.beginTransaction();
        session.saveOrUpdate(calle);
        session.getTransaction().commit();
        return calle;
    }
    public Municipio createMunicipio(String nombre, Provincia provincia) throws SQLException{
        Municipio municipio= new Municipio(nombre,provincia);
        session.beginTransaction();
        session.saveOrUpdate(municipio);
        session.getTransaction().commit();
        return municipio;
    }
    
        public Provincia createProvincia(String nombre) throws SQLException{
        Provincia provincia = new Provincia(nombre);
        session.beginTransaction();
        session.saveOrUpdate(provincia);
        session.getTransaction().commit();
        return provincia;
    }
}
