import ormExpressCorreos.Controller;
import ormExpressCorreos.model.*;

import java.sql.SQLException;

public class Main {

    public static void main (String [] args) {
        try {
            Controller controlador= new Controller();
            Provincia cMadrid = new Provincia("Madrid");


            Municipio madrid = new Municipio("Madrid",cMadrid);
            Calle guzman_el_bueno = new Calle("Guzman el Bueno",madrid);
            Direccion direccion = new Direccion(32,1,"B",guzman_el_bueno);

            UsuarioIdentificado usuarioIdentificado = controlador.createUsuarioIdentificado("11896382T", "Ismael","Alonso","iismaelar@gmail.com");


            // @TODO añada las llamadas a las funciones de la clase Controller.java necesarias
            // para la creación del usuario identificado y la direccion.


                System.out.println("Se ha creado el usuario identificado " + usuarioIdentificado.getNombre() + " con DNI "
                        + usuarioIdentificado.getDNI() + " que vive en " + direccion.getDireccionCompleta());


        } catch(SQLException e) {
            System.err.println("Se ha producido un error en la conexión con la base de datos");
            e.printStackTrace();
        }
    }
}
