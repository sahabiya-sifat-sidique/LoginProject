package model;

public class Admin {
   private int id;
   private String username;
   private String password;
   private String email;
   private String token;
   private int mob;
   private String time;
 
   public Admin() {
 }

   
 public Admin(int id, String email, String password) {
  this.id = id;
  this.email=email;
 // this.username = username;
  this.password = password;
 }

    public Admin(int id, String username, String email, int mob) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mob = mob;
    }


   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getMob() {
        return mob;
    }

    public void setMob(int mob) {
        this.mob = mob;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
   
}
