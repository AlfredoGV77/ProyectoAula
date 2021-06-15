/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.MAdiccion_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bailarina77
 */
public class AccionesAdiccionUsuario {
    
            /*INICIA LA BUSQUEDA*/
    public static  MAdiccion_Usuario  buscarUsuarioById(int id){
        MAdiccion_Usuario e=new MAdiccion_Usuario();
        try{
            Connection con=Conexion.getConnection();
            String q="select * from MAdiccion_Usuario where id_usuario=?";
            PreparedStatement ps=con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setId_adiccion(rs.getInt(1));
                e.setId_usuario(rs.getInt(2));
                
            }
            System.out.println("Se encontro al Usuario");
            con.close();
            
        }catch(Exception ed){
            System.out.println("Error al buscar");
            System.out.println(ed.getMessage());
        }
        return e;
    }
    /*TERMINA LA BUSQUEDA*/
    
    
    
    
    
    
    
}
