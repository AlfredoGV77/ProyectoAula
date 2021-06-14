/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Adiccion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bailarina77
 */
public class AccionesUsuario {
    
    /*REGISTRO DE USUARIOS*/
    public static int registrarUsuario(Usuario e){
        int estatus=0;
        try{
            Connection con= Conexion.getConnection();
            String q="insert into MUsuario(nombre,apellidos,usuario,contraseña,correo,edad,sexo) "
                    +"values(?,?,?,?,?,?,?)";     
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,e.getNombre());
            ps.setString(2,e.getApellidos());
            ps.setString(3,e.getUsuario());
            ps.setString(4,e.getContraseña());
            ps.setString(5,e.getCorreo());
            ps.setInt(6,e.getEdad());
            ps.setString(7,e.getSexo());
        

            estatus=ps.executeUpdate();
            System.out.println("Registro exitoso");
            con.close();
            
            /*OTRA QUERY PARA INSERTAR EN MAdiccion_Usuario
             String a="insert into MAdiccion_Usuario(id_usuario,id_adiccion,fecha_adiccion) "
                    +"values(?,?,?,?,?,?,?,?,?)";     
            */
            
        }catch(Exception ed){
            System.out.println("Error al registrar");
            System.out.println(ed.getMessage());
        }
        
        return estatus;
    }
    
    public static int validarUsuario(Usuario e){
        int estatus=0;
        try{
            Connection con=Conexion.getConnection();
            String q="select * from musuario where usuario = ? and contraseña = ? ";
             
              
             PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,e.getUsuario());
            ps.setString(2,e.getContraseña());
            ResultSet rs = ps.executeQuery();
             while(rs.next()){
             
                   estatus = estatus +1 ;
                   e.setUsuario(rs.getString("usuario"));
                   e.setContraseña(rs.getString("contraseña"));
                   if(estatus == 1){
                   
                         return 1;
                   
             }else{
             
                   return 0;
             }
             }
            System.out.println("Login exitoso");
            con.close();
            
        }catch(Exception ed){
            System.out.println("Error al logear");
            System.out.println(ed.getMessage());
        
          }
        return 0;
    }
    
}