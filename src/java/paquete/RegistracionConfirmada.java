/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author julien
 */
@WebServlet(name = "RegistracionConfirmada", urlPatterns = {"/RegistracionConfirmada"})
public class RegistracionConfirmada extends HttpServlet {

    private Connection conexionBD;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistracionConfirmada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistracionConfirmada at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String nombre = request.getParameter("nombre");
        int numeroDias = Integer.parseInt(request.getParameter("numeroDias")); 
        int numeroEskis = Integer.parseInt(request.getParameter("numeroEskis")); 
        int numeroBotas= Integer.parseInt(request.getParameter("numeroBotas")); 
        int numeroPalos= Integer.parseInt(request.getParameter("numeroPalos"));
        int numeroSnowboards = Integer.parseInt(request.getParameter("numeroSnowboards")); 
        int costeTotal = Integer.parseInt(request.getParameter("costeTotal"));
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        
        String bd = "jdbc:mysql://localhost/tiendaEski";
        try {
        Class.forName("com.mysql.jdbc.Driver"); // Driver de mysql
        // Conexión usando usuario y clave de administrador de la BD
        conexionBD = DriverManager.getConnection(bd, "root","root");
        }
        catch(Exception e){
        // Error en la conexión con la BD
        System.out.println("Error de conexión");
        }
         ResultSet resultados = null;
        try {
        String con;
        Statement s = conexionBD.createStatement();
        // Consulta SQL
        con = "SELECT * FROM `reservas`";
        resultados = s.executeQuery(con);
        int res;
        while(resultados.next()){
            res = resultados.getInt(1);
            out.println("<html>\n" +
            " <head>\n" +
            "<title>Redirection en htm</title\n" +
            "<meta http-equiv=\"refresh\" content=\"5; URL=\"http://localhost:8080/Servlet1/formulario.html\">\n" +
            "</head>\n" +
            "<body>\n" +
            " Redirection vers www.manouvelleadresse.com dans "+ res + " secondes.\n" +
            " </body>\n" +
            "</html>");
            }
        }
            
        catch(Exception e){
        // Error en al realizar la consulta
        System.out.println("Error en la petición a la BD");
        }
        /**
        ResultSet resultados = null;
        try {
        String con;
        Statement s = conexionBD.createStatement();
        // Operación SQL sobre la base de datos
        con = "INSERT INTO RESERVAS (num_esquis,num_palos,num_botas, num_snowboards, coste_total, nombre, apellidos, email, telefono) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = conexionBD.prepareStatement(con);
        preparedStmt.setInt (1, numeroEskis);
        preparedStmt.setInt (2, numeroPalos);
        preparedStmt.setInt (3, numeroBotas);
        preparedStmt.setInt (4, numeroSnowboards);
        preparedStmt.setInt (5, costeTotal);
        preparedStmt.setString (6, nombre);
        preparedStmt.setString (7, apellidos);
        preparedStmt.setString (8, email);
        preparedStmt.setString (9, telefono);
        preparedStmt.executeUpdate();
        }
        catch(Exception e){
        // Error al realizar la operación
        System.out.println("No se ha completado la operación");
        }
        //conexionBD.close(); // Cerrar conexión
        **/
        

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    /**@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    * */
}
}
