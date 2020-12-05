package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;
import java.sql.*;
import model.Connect;

public final class myAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Mi Cuenta - GRUPO LAVAGÓMEZ</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=stylesheet type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <link rel=stylesheet type=\"text/css\" href=\"css/normalize.css\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

              request.getSession();
              User usu = (User) session.getAttribute("usuario");
              
              if(usu == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
              }
            
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            <div>\r\n");
      out.write("                <a href=\"index.jsp\">\r\n");
      out.write("                    <img src=\"img/logolavagomez2020.png\" class=logo>\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <nav class=\"nav\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <a href=\"activitiesOp.jsp\">Mis actividades</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <a href=\"myAccount.jsp\">Mi cuenta(");
 out.print(usu.getMail());
      out.write(")</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <section class=\"cuenta\" align=\"left\">\r\n");
      out.write("            <img src=\"img/icon_id.png\" width=\"10%\" height=\"auto\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <h1>");
 out.print(usu.getMail());
      out.write("</h1>\r\n");
      out.write("                <a href=\"LogOutServlet\">Cerrar Sesión</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section> \r\n");
      out.write("\r\n");
      out.write("        ");

          Connection con = null;
          Connect cn = new Connect();
          Statement st = null;
          ResultSet rs = null;
          try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from usuarios where correo_usr='" + usu.getMail() + "'");

            while (rs.next()) {
        
      out.write("\r\n");
      out.write("        <div class=\"twoforms\" style=\"padding-left: 25%;\">\r\n");
      out.write("            <h2><img src=\"img/icon_user.png\" width=\"5%\" height=\"auto\"> ");
      out.print(rs.getString("nombre_usr") + " " + rs.getString("apellido_usr"));
      out.write(" </h2>\r\n");
      out.write("            <h2><img src=\"img/icon_add.png\" width=\"5%\" height=\"auto\"> ");
      out.print(rs.getString("domicilio_usr"));
      out.write(" </h2>\r\n");
      out.write("            <h2><img src=\"img/icon_ph2.png\" width=\"5%\" height=\"auto\"> ");
      out.print(rs.getString("tel_usr"));
      out.write(" </h2>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
  }
            st.close();
            rs.close();
            con.close();
          } catch (SQLException e) {
          }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <footer class=\"footer\">\r\n");
      out.write("            <hr width=700><br>\r\n");
      out.write("            Copyright &copy; 2020 GRUPO LAVAGÓMEZ\r\n");
      out.write("        </footer>\r\n");
      out.write("    </body>\r\n");
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
