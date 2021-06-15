 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.AccionesAdiccionUsuario;
import Control.AccionesUsuario;
import Control.Conexion;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bailarina77
 */
public class VerificarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String user,pass;
            user=request.getParameter("usuario2");
            pass=request.getParameter("password22");
            
            System.out.println("hola "+user);
            System.out.println("hola "+pass);
            
            int estatus = 0;
           
            Usuario u= new Usuario();
            u.setUsuario(user);
            u.setContraseña(pass);
             
            
            try{
                Connection con=Conexion.getConnection();
                String q="select * from musuario where usuario =? and contraseña = ? ";
                 PreparedStatement ps=con.prepareStatement(q);
                ps.setString(1,user);
                ps.setString(2,pass);
                ResultSet rs = ps.executeQuery();
                 while(rs.next()){
                       int privilegio=rs.getInt("rol"); 
                       estatus = estatus +1 ;
                       u.setRol(rs.getInt("rol"));
             }
            System.out.println("CONSULTA EXITOSA");
            con.close();
            
        }catch(Exception ed){
            System.out.println("Error al CONSULTAR");
            System.out.println(ed.getMessage());
        
          }

            
            
            
            int estatus2= AccionesUsuario.validarUsuario(u);
            if(estatus2==1){                
                HttpSession session = request.getSession(true);
                session.setAttribute("Usuario",user);
                System.out.println("holiiiiiis "+ u.getRol());
                if(u.getRol()==1){
                    response.sendRedirect("JSP/paginaCigarro.jsp");
                }
                
                if(u.getRol()==2){
                    response.sendRedirect("JSP/paginaAlcohol.jsp");
                }
                
               if(u.getRol()==3){
                    response.sendRedirect("JSP/paginaAzucar.jsp");
                }
 
            }
            else{
                response.sendRedirect("JSP/error.jsp");
            }
            
            

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
