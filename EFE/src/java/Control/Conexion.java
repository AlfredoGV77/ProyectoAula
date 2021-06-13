/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bailarina77
 */
public class Conexion {
    
 public static Connection getConnection(){
        String url, userName, password;
        url="jdbc:mysql://localhost/Ludex";
        userName="root";
        password="2122loken";
        
        Connection con=null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,userName, password);
            System.out.println("Se conecto a la BD");
            
        }catch(Exception e){
            System.out.println("No se conecto, efe");
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}

   



