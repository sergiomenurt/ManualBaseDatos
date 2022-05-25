/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

//importamos paquetes necesarios

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//importamos el paquete de conexion
import manualbasedatos.ManualBaseDatos;

/**
 *
 * @author dam1
 */
public class operaciones {
    
    //creamos las variables para la conexion
    
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo=new DefaultTableModel();
    
    //creamos la operacion para mostrar datos en el jform
    public DefaultTableModel lista(){
        
        try{
            
            cn = ManualBaseDatos.Enlace(cn);
            
            Statement s=cn.createStatement();
            
            //consulta a mostrar
            String query = "select * from producto";
            rs = s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            //contenemos numero de columnas
            int CanColumns = rsmd.getColumnCount();
            
            //comprobamos
            for(int i=1;i<CanColumns;i++){
                
                //cargamos columnas en modelo
                
                modelo.addColumn(rsmd.getColumnLabel(i));
                
            }
            while(rs.next()){
                
                //Creamos array
                
                Object[] fila=new Object[CanColumns];
                
                //cargamos datos a modelo
                for(int i=0;i<CanColumns;i++){
                    
                    fila[i]  =rs.getObject(i+1);
                }
                modelo.addRow(fila);
                
            }
            
        }catch(Exception e){}
            
            //retornamos modelo para jtable

            return modelo;
        
        
    }
    
    //creamos metodo para insertar datos
    public void AgregarDatos(String nombre,String precio){
        
        //dentro de try catch por si los errores
        
        try{
            
            Statement s=cn.createStatement();
            String query = "INSERT INTO producto(nombre,precio)values ('"+nombre+"',"+precio+")";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
            
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
       
        }
        
        //creamos metodo para eliminar datos
       
        
    }
    
     
        public void EliminarConsulta(String id){
            
            try{
                
                Statement s = cn.createStatement();
                String query = "DELETE FROM producto WHERE id="+id+"";
                s.executeUpdate(query);
                s.close();
                cn.close();
                JOptionPane.showMessageDialog(null, "ELIMINADO");
                
                
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            
        }
        
        //creamos metodo para modificar datos
        
        public void ModificarConsulta(String nombre,String precio,String id){
            
            try{
                
                Statement s = cn.createStatement();
                String query = "UPDATE producto SET nombre='"+nombre+"', precio="+precio+"WHERE id ="+id+"";
                s.executeUpdate(query);
                s.close();
                cn.close();
                
                JOptionPane.showMessageDialog(null, "MODIFICADO");
                
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);
            
        }
    
}
        
}
