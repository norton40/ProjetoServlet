/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class JuroSimples extends HttpServlet {

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
            out.println("<title>Servlet JuroSimples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            out.println("CÁLCULO DE JUROS SIMPLES");
            out.println("</h1>");
            out.println("<a href='index.html'> PÁGINA INICIAL </a>");
            out.println("<BR><a href='juroComposto'>JUROS COMPOSTO </a>");
            out.println("<HR/>");
            out.println("<form>");
            out.println("<br> Informe o valor do capital: <input type='number' name='capital'>");
            out.println("<br> Informe o valor da taxa de juros (em porcentagem(%)): <input type='number' name='txJuros'>");
            out.println("<br>Informe o valor do período (em meses): <input type='number' name='nPeriodo'>");
            out.println("<br>");
            out.print("<input type='submit' name='vai' value='GERAR'>");
            out.println("</form>");
            
            
            if(request.getParameter("vai")!=null){
                try {
                    
                    double cap = Double.valueOf(request.getParameter("capital"));
                    double t = Double.valueOf(request.getParameter("nPeriodo"));
                    double i = Double.valueOf(request.getParameter("txJuros"));
                    
                    double m = cap * (1+( (i/100) * t ));
                    BigDecimal bd = new BigDecimal(m).setScale(2, RoundingMode.HALF_EVEN);
                    out.println("<table>");
                    out.println("<tr>");
                     out.println("<br>Valor do Montante: "+bd);
                    out.println("</tr>");
                    
                   
                    out.println("</table>");
                    
                } catch (Exception e) {
                    out.println("<h1 style='color:red;'> Campos Inválidos! Preencha todos os campos de forma numérica!<h1>");
                }
            }
           
            
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
