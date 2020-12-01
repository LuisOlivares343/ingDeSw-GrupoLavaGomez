<%-- 
    Document   : myActOp
    Created on : 01-dic-2020, 12:04:55
    Author     : noble
--%>

<%@page import="java.sql.*"%>
<%@page import="model.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
          String cod = request.getParameter("user_mail");

          Connection con = null;
          Connect cn = new Connect();
          Statement st = null;
          ResultSet rs = null;
          
          System.out.println("AQUÍ: "+cod);
          
          try {
            con = cn.getConnection();
            st = con.createStatement();
            st.executeQuery("select * from actividades where lider_act = (select rfc_usr from usuarios where correo_usr='"+cod+"')");
            request.getRequestDispatcher("activitiesOp.jsp").forward(request, response);
            st.close();
            rs.close();
            con.close();
          } catch (SQLException e) {
          }
        %>
    </body>
</html>
