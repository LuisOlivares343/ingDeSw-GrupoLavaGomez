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

@WebServlet(name = "create", urlPatterns = {"/create"})
public class Create extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    int act_id;
    String act_name = request.getParameter("act_name");
    String act_area = request.getParameter("act_area");
    String act_begin = request.getParameter("act_beg_date") + " " + request.getParameter("act_beg_time");
    String act_end = request.getParameter("act_end_date") + " " + request.getParameter("act_end_time");
    String act_materials = request.getParameter("act_materials");
    int act_time = Integer.parseInt(request.getParameter("act_time"));
    String act_leader = request.getParameter("act_leader");

    Connection con = null;
    Connect cn = new Connect();
    Statement st = null;
    ResultSet rs = null;
    try {
      con = cn.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("SELECT id_act FROM actividades ORDER BY id_act DESC LIMIT 1");
      rs.next();
      act_id = Integer.parseInt(rs.getString("id_act")) + 1;
      st.executeUpdate("insert into actividades values(" + act_id + ",'" + act_name + "','" + act_area + "','" + act_begin + "','" + act_end + "','" + act_materials + "'," + act_time + ",'" + act_leader + "')");
      
      try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id=\"popup\" class=\"overlay\">" +
                "<div id=\"popupBody\">" +
                "<h2>Título de la ventana</h2>" +
                "<a id=\"cerrar\" href=\"#\">&times;</a>" +
                "<div class=\"popupContent\">" +
                "<p>Este es el contenido</p>" +
                "</div>" +
                "</div>" +
                "</div>");
        out.println("</body>");
        out.println("</html>");
      }
      
      request.getRequestDispatcher("createactivities.jsp").forward(request, response);
      st.close();
      rs.close();
      con.close();
      
    } catch (SQLException e) {
      System.out.println("NO SE SOBREESCRIBIÓ EL DATO: " + e.getMessage());
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
