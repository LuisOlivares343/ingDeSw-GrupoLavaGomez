package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Connect;
import java.sql.*;

public final class createactivities_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Crear Actividades - GRUPO LAVAGÓMEZ</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=stylesheet type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <link rel=stylesheet type=\"text/css\" href=\"css/normalize.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div>\n");
      out.write("                <a href=\"index.jsp\">\n");
      out.write("                    <img src=\"img/logolavagomez2020.png\" class=logo>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <nav class=\"nav\">\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"reportes.jsp\">Reportes</a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"activities.jsp\">Actividades</a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"createactivities.jsp\">Crear Actividad</a>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"#.jsp\">Mi cuenta</a>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section align=center>\n");
      out.write("            <h1>Crear Actividad</h1>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <section align=center>\n");
      out.write("            <form class=\"twoforms\" method=\"post\" action=\"create\">\n");
      out.write("                <table border=\"1\" align=\"center\" width=\"500\">\n");
      out.write("                    <th>\n");
      out.write("                        <div align=\"left\">Nombre de la actividad</div>\n");
      out.write("                        <input type=\"text\" class=txtfield name=\"act_name\" required=true/><br><br>\n");
      out.write("\n");
      out.write("                        <div align=\"left\">&Aacute;rea</div>\n");
      out.write("                        <input type=\"text\" class=txtfield name=\"act_area\" required=true/><br><br>\n");
      out.write("\n");
      out.write("                        <div align=left>Materiales</div>\n");
      out.write("                        <input type=\"textarea\" class=txtfield name=\"act_materials\" required=true/><br><br>\n");
      out.write("\n");
      out.write("                        <div align=left>Duración máxima de la actividad (En minutos)</div>\n");
      out.write("                        <input type=\"textarea\" class=txtfield name=\"act_time\" required=true/><br><br>\n");
      out.write("                    </th>\n");
      out.write("\n");
      out.write("                    <th>\n");
      out.write("                        <div align=left>Fecha y hora de inicio</div>\n");
      out.write("                        <input type=\"date\" class=txtfield name=\"act_beg_date\" required=true/><br>\n");
      out.write("                        <input type=\"time\" class=txtfield name=\"act_beg_time\" required=true/><br><br>\n");
      out.write("\n");
      out.write("                        <div align=left>Fecha y hora de fin</div>\n");
      out.write("                        <input type=\"date\" class=txtfield name=\"act_end_date\" required=true/><br>\n");
      out.write("                        <input type=\"time\" class=txtfield name=\"act_end_time\" required=true/><br><br>\n");
      out.write("\n");
      out.write("                        <div align=left>Encargado de la actividad</div>\n");
      out.write("                        <input type=\"textarea\" class=txtfield name=\"act_leader\" required=true/><br><br>\n");
      out.write("                    </th>\n");
      out.write("                </table>\n");
      out.write("                <br>\n");
      out.write("                <button name=\"crt\" class=btns type=\"submit\" value=\"create\">Crear actividad</button>\n");
      out.write("                <br>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            <h3>Última actividad creada</h3>\n");

  Connection con = null;
  Connect cn = new Connect();
  Statement st = null;
  ResultSet rs = null;
  try {
    con = cn.getConnection();
    st = con.createStatement();
    rs = st.executeQuery("SELECT id_act, nombre_act, area_act, lider_act FROM actividades ORDER BY id_act DESC LIMIT 1");

    while (rs.next()) {

      out.write("\n");
      out.write("                <table align=\"center\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>C&oacute;digo</th>\n");
      out.write("                        <th>Nombre</th>\n");
      out.write("                        <th>&Aacute;rea</th>\n");
      out.write("                        <th>L&iacute;der</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th> ");
      out.print(rs.getString("id_act"));
      out.write(" </th>\n");
      out.write("                        <th> ");
      out.print(rs.getString("nombre_act"));
      out.write("  </th>\n");
      out.write("                        <th> ");
      out.print(rs.getString("area_act"));
      out.write("    </th>\n");
      out.write("                        <th> ");
      out.print(rs.getString("lider_act"));
      out.write("   </th>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
  }
    st.close();
    rs.close();
    con.close();
  } catch (SQLException e) {
  }


      out.write("\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        <footer class=footer>\n");
      out.write("            <hr width=700><br>\n");
      out.write("            Copyright &copy; 2020 GRUPO LAVAGÓMEZ\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
