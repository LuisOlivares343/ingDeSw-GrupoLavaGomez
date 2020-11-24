<%-- 
    Document   : detele
    Created on : 23-nov-2020, 18:36:59
    Author     : noble
--%>

<%@page import="model.Connect"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          String cod = request.getParameter("cod");

          Connection con = null;
          Connect cn = new Connect();
          Statement st = null;
          ResultSet rs = null;
          try {
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate("delete from actividades where id_act='"+cod+"'");
            request.getRequestDispatcher("activities.jsp").forward(request, response);
            st.close();
            rs.close();
            con.close();
          } catch (SQLException e) {
          }
        %>
    </body>
</html>
