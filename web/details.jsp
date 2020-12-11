<%-- 
    Document   : details
    Created on : 07-dic-2020, 16:31:06
    Author     : noble
--%>

<%@page import="model.User"%>
<%@page import="model.Connect"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actividades - GRUPO LAVAGÓMEZ</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel=stylesheet type="text/css" href="css/style.css">
        <link rel=stylesheet type="text/css" href="css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
        
    </head>
    <body>
        <%
              request.getSession();
              User usu = (User) session.getAttribute("usuario");
              
              if(usu == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
              }
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <header>
            <div>
                <a href="index.jsp">
                    <img src="img/logolavagomez2020.png" class=logo>
                </a>
            </div>
            <nav class="nav">
                <div>
                    <a href="reportes.jsp">Reportes</a>
                </div>
                <div>
                    <a href="activities.jsp">Actividades</a>
                </div>
                <div>
                    <a href="createactivities.jsp">Crear Actividad</a>
                </div>
                <div>
                    <a href="myAccountAd.jsp">Mi cuenta(<% out.print(usu.getMail());%>)</a>
                </div>
            </nav>
    </header>
    <section align=center>
        <br></br>
        <h1>Detalles</h1>
    </section>        
    <body>
        <%
            Connection con = null;
            Connect cn = new Connect();
            Statement st = null;
            ResultSet rs = null;
         //   try {
                con = cn.getConnection();
                st = con.createStatement();
                String cod = request.getParameter("cod");
                rs = st.executeQuery("select * from actividades where id_act ="+ cod);
                while (rs.next()) {        
        %>
        <section align="center">
            <form class="twoforms" action="">
                <table border="1" align="center" width="500">
                    <th>
                        <div align="left">ID de la actividad</div>
                        <input type="text" class=txtfield name="cod" readonly="" value="<%=rs.getInt("id_act")%>" /><br><br>
                        
                        <div align="left">Nombre de la actividad</div>
                        <input type="text" class=txtfield  name="nom_act" value="<%=rs.getString("nombre_act") %>"/><br><br>

                        <div align="left">&Aacute;rea</div>
                        <input type="text" class=txtfield name="act_area"  value="<%=rs.getString("area_act")%>"/><br><br>

                        <div align=left>Materiales</div>
                        <input type="textarea" class=txtfield name="act_materials"  value="<%=rs.getString("material_act")%>" /><br><br>

                        <div align=left>Duración máxima de la actividad (En minutos)</div>
                        <input type="textarea" class=txtfield name="act_time" value="<%=rs.getInt("duracionMax_act")%>"/><br><br>
                    </th>

                    <th>
                        <div align=left>Fecha y hora de inicio</div>
                        <input type="date" class=txtfield name="act_beg_date" value="<%=rs.getDate("ini_act")%>" /><br>
                        <input type="time" class=txtfield name="act_beg_time"  value="<%=rs.getTime("ini_act")%>"/><br><br>
                        

                        <div align=left>Encargado de la actividad</div>
                        <input type="textarea" class=txtfield name="act_leader"  value="<%=rs.getString("lider_act")%>"/><br><br>
                    </th>   
                </table>
                    
                <br>
                <button align="center" name="guardar" class=btns type="submit">Cerrar y guardar</button>              
                <br>
            </form>
        </section>
        
        <%  
               }
                if (request.getParameter("guardar") != null) {
                        
                    
                    String act_name = request.getParameter("nom_act");
                    String act_area = request.getParameter("act_area");
                    String ini_act = request.getParameter("act_beg_date") + " " + request.getParameter("act_beg_time");
                    String act_materials = request.getParameter("act_materials");
                    int duracionMax_act = Integer.parseInt(request.getParameter("act_time")) ;
                    String lider_act = request.getParameter("act_leader");
                    st.executeUpdate("update actividades set nombre_act='" + act_name +
                    "', area_act='" + act_area + "', ini_act='" + ini_act +
                    "', material_act='" + act_materials + "', duracionMax_act=" 
                    + duracionMax_act + ", lider_act='" + lider_act + "' where id_act =" + cod);
                    request.getRequestDispatcher("activities.jsp").forward(request, response);
                }

        
        st.close();
        rs.close();
        con.close();
        %>
        <br>
      <footer class=footer>
            <hr width=700><br>
            Copyright &copy; 2020 GRUPO LAVAGÓMEZ
        </footer>
    </body>
</html>
  <%

       // }catch (SQLException e) {
      //  System.out.println("NO SE PUDO SOBREESCRIBIR EL DATO: " + e.getMessage());
     // }
%>