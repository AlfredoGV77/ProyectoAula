/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.AccionesUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bailarina77
 */
public class registrarUsuario extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            
            /*GENERAMOS LA SESION*/
            HttpSession sesionusu=request.getSession(true);
            String idsesion=sesionusu.getId();
            long creacion=sesionusu.getCreationTime();
            
            Integer cuenta=(Integer)sesionusu.getAttribute("cuenta.ss");
            if(cuenta==null){
                cuenta= new Integer(1);
            }else{
                cuenta=new Integer(cuenta.intValue()+1);
            }
            
            sesionusu.setAttribute("cuenta.ss", cuenta);
            
            System.out.println("id sesion:"+idsesion);
            System.out.println("Fecha en que fue creada: " + new Date(creacion).toString());
            
            //PARAMETROS
            Enumeration parametrosSesion=sesionusu.getAttributeNames();
            while(parametrosSesion.hasMoreElements()){
                String parametros= (String)parametrosSesion.nextElement();
                Object valor= sesionusu.getAttribute(parametros);
                System.out.println("El parametro es "+ parametros
                +" su valor es:"+ valor.toString()
                );
            }
            
            
            String nombre, apellidos, usuario, contraseña, correo,sexo;
            int edad;
            
            nombre=request.getParameter("nombre");
            apellidos=request.getParameter("appe");
            usuario=request.getParameter("usuario");
            contraseña=request.getParameter("password");
            correo=request.getParameter("correo");
            edad=Integer.parseInt(request.getParameter("edad"));
            sexo=request.getParameter("sexo");
            
            Usuario e=new Usuario();
            e.setNombre(nombre);
            e.setApellidos(apellidos);
            e.setUsuario(usuario);
            e.setContraseña(contraseña);
            e.setCorreo(correo);
            e.setEdad(edad);
            e.setSexo(sexo);
            
            int estatus=AccionesUsuario.registrarUsuario(e);
             if(estatus>0){
                response.sendRedirect("JSP/mensajeExito.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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