/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Connect;

/**
 *
 * @author noble
 */
@WebServlet(name = "End", urlPatterns = {"/End"})
public class End extends HttpServlet {

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
    String act_end = request.getParameter("act_end_date") + " " + request.getParameter("act_end_time");
    String cod = request.getParameter("cod");
    
    System.out.println("here "+act_end+" "+cod);
    
    Connection con = null;
    Connect cn = new Connect();
    Statement st = null;
    ResultSet rs = null;
    try {
      con = cn.getConnection();
      st = con.createStatement();
      st.executeUpdate("update actividades set fin_act='"+act_end+"' where id_act="+cod);
      st.executeUpdate("update actividades set estatus_act='concluida' where id_act="+cod);
      
      request.getRequestDispatcher("activitiesOp.jsp").forward(request, response);
      st.close();
      rs.close();
      con.close();
      
    } catch (SQLException e) {
      System.out.println("NO SE PUDO SOBREESCRIBIR EL DATO: " + e.getMessage());
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
