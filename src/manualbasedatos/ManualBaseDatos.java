/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualbasedatos;

import Capa_presentacion.Vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author dam1
 */
public class ManualBaseDatos {
    
    //creamos la coneccion
    static Connection cn =null;
    
    //creamos la clase conexion
    public static Connection Enlace(Connection cn) throws SQLException{
        
        //ruta de la base de datos la cual crearemos
        String ruta = "";
        
        try{
            Class.forName("org.sqlite.JBDC");
            cn = DriverManager.getConnection("jbdc:sqlite"+ruta);
            
        }catch(ClassNotFoundException e){
            
            JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }
     public static void main(String[] args) {
       
        Vista vi = new Vista();
        vi.setVisible(true);
        
    }
}
