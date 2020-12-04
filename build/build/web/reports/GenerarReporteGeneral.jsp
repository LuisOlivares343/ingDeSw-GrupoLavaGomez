<%-- 
    Document   : Generar Reporte
    Created on : 3/12/2020, 01:49:54 AM
    Author     : padil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.io.File" %>
<%@page import="java.sql.*" %>
<%@page import="java.sql.*" %>
<%@page import="model.Connect"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Connection con = null;
        Connect cn = new Connect();
        con = cn.getConnection();
          
  
        File jasperFile = new File(application.getRealPath("reportGlobal.jasper"));        
        Map parametro = new HashMap();
        byte[] bytes = JasperRunManager.runReportToPdf(jasperFile.getPath(),null,con);
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        
        ServletOutputStream output = response.getOutputStream();
        response.getOutputStream();
        output.write(bytes,0,bytes.length);
        output.flush();
        output.close();

        %>  
        
        
    </body>
</html>
