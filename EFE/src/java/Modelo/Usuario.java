/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bailarina77
 */
public class Usuario {
    private String nombre,apellidos,usuario,contraseña, correo,sexo;
    private int edad, id,rol;

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Usuario verificarUsuario(String user, String pass) throws ClassNotFoundException, SQLException{
        Usuario u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConnection();
            String q ="select * from MUsuario where usuario = ? and contraseña = ?";
            ps = con.prepareStatement(q);
            //enviar los parametros de user y password
            ps.setString(1, user);
            ps.setString(2, pass);
            //ejecutamos al querry
            rs = ps.executeQuery();
            //buscar adentro de la tabla musuario los datos que queremos 
            while(rs.next()){
                u = new Usuario();
                u.setId(rs.getInt("id_Usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setSexo(rs.getString("sexo"));
                u.setCorreo(rs.getString("correo"));
                u.setContraseña(rs.getString("contraseña"));
                u.setUsuario(rs.getString("usuario"));
                u.setEdad(rs.getInt("edad"));
                break;
                
            }
        }catch(SQLException e){
            System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            u = null;
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                con.close();
            }catch(SQLException e){
                System.out.println("No se encontro");
                System.out.println(e.getMessage());
            }
        }
        return u;
    }    
    
}
