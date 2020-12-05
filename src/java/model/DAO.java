package model;

import java.sql.*;

public class DAO {
  Connection con;
  Connect cn = new Connect();
  PreparedStatement ps;
  ResultSet rs;
  int r;
  
  public int validar(User u){
    String sql  = "select * from usuarios where correo_usr=? and psw_usr=?";
    try{
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      ps.setString(1, u.getMail());
      ps.setString(2, u.getPsw());
      rs = ps.executeQuery();
      
      while(rs.next()){
        r=r+1;
        u.setMail(rs.getString("correo_usr"));
        u.setPsw(rs.getString("psw_usr"));
        u.setType(rs.getString("tipo_usr"));
      }
      if(r==1){
        r=0;
        return 1;
      }else{
        r=0;
        return 0;
      }
    }catch(SQLException e){
      return 0;
    }
  }
}