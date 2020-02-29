
package dao;

import model.Admin;
import service.GetConnection;
import security.MD5;
import security.GenerateToken;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
   public static boolean authenticateAdmin(Admin admin){
      boolean status = false;
      Connection con = null;
      try{
          
       con = GetConnection.getConnection();
       String sql ="select * from admin where email = ? and password = ?";
       PreparedStatement ps = con.prepareStatement(sql);
       
       String pswd= admin.getPassword();
       String pass = MD5.getMd5(pswd);
       ps.setString(1,admin.getEmail());
       ps.setString(2, pass);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
        status = true;
       }
   
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      finally{
         try{
          con.close();
         }
         catch(Exception e)
         {
           e.printStackTrace();
         }
      }
      return status;
   } 
   
   public static boolean updateToken(Admin admin){
    boolean status = false;
    Connection con = null;
    try{
     con = GetConnection.getConnection();
     String pswd= admin.getPassword();
     String pass = MD5.getMd5(pswd);
     long token = GenerateToken.tokenGeneration();
     String sql = "update admin set token = ? where email = ? and password = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setLong(1, token);
     ps.setString(2, admin.getEmail());
     ps.setString(3, pass);
     if(ps.executeUpdate()!=0)
      status = true;
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally{
       try{
        con.close();
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
    }
    return status;
  }
   
   
   public static Admin getAdmin(Admin admin){
    Connection con = null;
    Admin a= null;
    try{
     con = GetConnection.getConnection();
     String sql = "select * from admin where email = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, admin.getUsername());
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
        int id = rs.getInt(1);
        String adminName = rs.getString(2);
        String email = rs.getString(3);
        int mob = rs.getInt(4);
        a = new Admin(id, adminName , email , mob);
     }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally{
      try{
       con.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
      return a;

    }
   
}
