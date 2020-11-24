<%-- 
    Document   : createactivities
    Created on : 23-nov-2020, 20:50:13
    Author     : noble
--%>

<%@page import="model.Connect"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Actividades - GRUPO LAVAGÓMEZ</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel=stylesheet type="text/css" href="css/style.css">
        <link rel=stylesheet type="text/css" href="css/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
    </head>

    <body>
        <header>
            <div>
                <a href="index.jsp">
                    <img src="img/logolavagomez2020.png" class=logo>
                </a>
            </div>
            <nav class="nav">
                <div>
                    <a href="#.jsp">Reportes</a>
                </div>
                <div>
                    <a href="activities.jsp">Actividades</a>
                </div>
                <div>
                    <a href="createactivities.jsp">Crear Actividad</a>
                </div>
                <div>
                    <a href="#.jsp">Mi cuenta</a>
                </div>
            </nav>
        </header>

        <section align=center>
            <h1>Crear Actividad</h1>
        </section>

        <section align=center>
            <form class="twoforms" method="post" action="create">
                <table border="1" align="center" width="500">
                    <th>
                        <div align="left">Nombre de la actividad</div>
                        <input type="text" class=txtfield name="act_name" required=true/><br><br>

                        <div align="left">&Aacute;rea</div>
                        <input type="text" class=txtfield name="act_area" required=true/><br><br>

                        <div align=left>Materiales</div>
                        <input type="textarea" class=txtfield name="act_materials" required=true/><br><br>

                        <div align=left>Duración máxima de la actividad (En minutos)</div>
                        <input type="textarea" class=txtfield name="act_time" required=true/><br><br>
                    </th>

                    <th>
                        <div align=left>Fecha y hora de inicio</div>
                        <input type="date" class=txtfield name="act_beg_date" required=true/><br>
                        <input type="time" class=txtfield name="act_beg_time" required=true/><br><br>

                        <div align=left>Fecha y hora de fin</div>
                        <input type="date" class=txtfield name="act_end_date" required=true/><br>
                        <input type="time" class=txtfield name="act_end_time" required=true/><br><br>

                        <div align=left>Encargado de la actividad</div>
                        <input type="textarea" class=txtfield name="act_leader" required=true/><br><br>
                    </th>
                </table>
                <br>
                <button name="crt" class=btns type="submit" value="create">Crear actividad</button>
                <br>
            </form>
            
            <h3>Última actividad creada</h3>
<%
  Connection con = null;
  Connect cn = new Connect();
  Statement st = null;
  ResultSet rs = null;
  try {
    con = cn.getConnection();
    st = con.createStatement();
    rs = st.executeQuery("SELECT id_act, nombre_act, area_act, lider_act FROM actividades ORDER BY id_act DESC LIMIT 1");

    while (rs.next()) {
%>
                <table align="center">
                    <tr>
                        <th>C&oacute;digo</th>
                        <th>Nombre</th>
                        <th>&Aacute;rea</th>
                        <th>L&iacute;der</th>
                    </tr>
                    <tr>
                        <th> <%=rs.getString("id_act")%> </th>
                        <th> <%=rs.getString("nombre_act")%>  </th>
                        <th> <%=rs.getString("area_act")%>    </th>
                        <th> <%=rs.getString("lider_act")%>   </th>
                    </tr>
                </table>
<%  }
    st.close();
    rs.close();
    con.close();
  } catch (SQLException e) {
  }

%>

        </section>
        <footer class=footer>
            <hr width=700><br>
            Copyright &copy; 2020 GRUPO LAVAGÓMEZ
        </footer>
    </body>
</html>
