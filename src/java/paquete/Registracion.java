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

/**
 *
 * @author julien
 */
@WebServlet(name = "Registracion", urlPatterns = {"/Registracion"})
public class Registracion extends HttpServlet {

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
            out.println("<title>Servlet Registracion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registracion at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int[] preciosUnDia = {15,4,10,16};
        int[] preciosDosTresDias = {13,3,9,15};
        int[] preciosMasDeTresDias = {11,3,8,14};
        String nombre = request.getParameter("nombre");
        int numeroDias = Integer.parseInt(request.getParameter("numeroDias")); 
        int numeroEskis = Integer.parseInt(request.getParameter("numeroEskis")); 
        int numeroBotas= Integer.parseInt(request.getParameter("numeroBotas")); 
        int numeroPalos= Integer.parseInt(request.getParameter("numeroPalos"));
        int numeroSnowboards = Integer.parseInt(request.getParameter("numeroSnowboards")); 
        int costeTotal = Integer.parseInt(request.getParameter("costeTotal"));
        out.println("<html><head><title>Registracion"
        + "</title></head><body>\n");
        out.println("<form action=\"RegistracionConfirmada\" method=\"POST\">"
                +"<div>\n" +
"               <label for=\"nombre\">Nombre : " + nombre + " </label>\n"
                +"<div>\n" 
                +"<div> <input type=\"hidden\" value=" + nombre + " name=\"nombre\" </div>"
                +"<div> <input type=\"hidden\" value=" + request.getParameter("numeroEskis") + " name=\"numeroEskis\" </div>"
                +"<div> <input type=\"hidden\" value=" + request.getParameter("numeroBotas") + " name=\"numeroBotas\" </div>"
                +"<div> <input type=\"hidden\" value=" + request.getParameter("numeroPalos") + " name=\"numeroPalos\" </div>"
                +"<div> <input type=\"hidden\" value=" + request.getParameter("numeroDias") + " name=\"numeroDias\" </div>"
                +"<div> <input type=\"hidden\" value=" + request.getParameter("costeTotal") + " name=\"costeTotal\" </div>"
                +"<div> <input type=\"hidden\" value=" + request.getParameter("numeroSnowboards") + " name=\"numeroSnowboards\" </div>"
                +"<label for=\"apellidos\">Apellidos :</label>\n" +
                "<input type=\"text\" name=\"apellidos\" required>\n" +
                "</div>"+
                "<div>\n" +
                "<label for=\"email\">email :</label>\n" +
                "<input type=\"mail\" name=\"email\" required>\n" +
                "</div>"+
                "<div>\n" +
                "<label for=\"numeroTelefono\">Numero de telefono :</label>\n" +
                "<input type=\"tel\" name=\"numeroTelefono\" required>\n" +
                "</div>"
                + "<div class=\"button\">\n" +
                "<button type=\"submit\">Presupuesto</button>\n" +
                "</div>"
                +"</form>");
        out.println("<a href=\"formulario.html\">Inicio </a>");
        out.println("</body>");
        }
    

}
