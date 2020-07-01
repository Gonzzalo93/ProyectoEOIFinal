/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author migue
 */
public class ConexionSQL {
     private Connection getConnection() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/shadowlands?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "Admin1234";
             try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de MySQL: " + ex);
                }

                return DriverManager.getConnection(url, user, pass);
            }
     public boolean checkLogin(String user, String pass){
         String query = "Select Nick, Password from cuentas where Nick = ? and Password = ?";
         Connection con = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         String password = null;
         String usuario = null;
         
            try {
                con = getConnection();
                stmt = con.prepareStatement(query);
		stmt.setString(1, user);
                stmt.setString(2, pass);
                System.out.println("Ejecutando la query: " + query);
				
		rs = stmt.executeQuery();
                while(rs.next()){
                    usuario = rs.getString("Nick");
                    password = rs.getString("Password");
                }
                
                rs = null;
		stmt.close();
                con.close();
                if (user.equals(usuario) && pass.equals(password)){
                    return true;
                }else{
                    return false;
                }
                
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               return false;
            }
           
    }
      public boolean createUsuario(String usuario, String password, String correo, String pais, String fnacimiento, String direccion) {

	String insertQuery = "INSERT INTO cuentas(Nick, Email, Password, Direccion, Pais, Nacimiento, TipoCuenta) VALUES (?, ?, ?, ?, ?, ?, player)";
	Connection con = null;
	PreparedStatement stmt = null;
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
		stmt.setString(1, usuario);
                stmt.setString(2, correo);
                stmt.setString(3, password);
                stmt.setString(4, direccion);
                stmt.setString(5, pais);
                stmt.setString(6, fnacimiento);
                System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
				
		return true;
				
				
	    } catch (SQLException e) {
		e.printStackTrace();
		return false;
        }
            
    }
}
