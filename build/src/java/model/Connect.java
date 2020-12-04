package model;

import java.sql.*;

public class Connect {
  
  public Connection getConnection(){
    Connection con = null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection
        ("jdbc:mysql://localhost/grupoLavagomez?user=root&password=");
      System.out.println("CONEXION EXITOSA!");
    }catch(ClassNotFoundException | SQLException e){
      System.out.println("ERROR: "+e.getMessage());
    }
    return con;
  }
}
