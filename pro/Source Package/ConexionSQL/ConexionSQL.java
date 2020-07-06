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
    // METODO CONEXION DE MYSQL
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
     // FIN METODO CONEXION MYSQL
     ///////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////
     // METODOS SQL DE CHECKEO DE PARAMETROS
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
                System.out.println("Fallo en el metodo de sql");
               e.printStackTrace();
               return false;
            }
           
    }
       public int checkId(String user){
         String query = "Select idCuentas from cuentas where Nick = ? ";
         Connection con = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         String password = null;
         String usuario = null;
         int id = 0;
         
            try {
                con = getConnection();
                stmt = con.prepareStatement(query);
		stmt.setString(1, user);
                System.out.println("Ejecutando la query: " + query);
				
		rs = stmt.executeQuery();
                while(rs.next()){
                   id = rs.getInt("idCuentas");
                }
                
                rs = null;
		stmt.close();
                con.close();
                return id;
                
            } catch (SQLException e) {
               // TODO Auto-generated catch block
                System.out.println("Fallo en el metodo de sql");
               e.printStackTrace();
               return id;
            }
           
    }
       
         public int checkPersonaje(int id){
         String query = "Select idPersonajes from personajes where cuentas_idCuentas= ?";
         Connection con = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         int idp = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
                System.out.println("Ejecutando la query: " + query);
				
		rs = stmt.executeQuery();
                while(rs.next()){
                   idp = rs.getInt("idPersonajes");
                }
                
                rs = null;
		stmt.close();
                con.close();
                return idp;
                
            } catch (SQLException e) {
               // TODO Auto-generated catch block
                System.out.println("Fallo en el metodo de sql");
               e.printStackTrace();
               return idp;
            }
           
    }
     //FIN METODOS DE CHECKEO DE PARAMETROS  
     ///////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////
     // METODOS DE GESTION DE CUENTA
      public boolean createUsuario(String usuario, String password, String correo, String pais, String fnacimiento, String direccion) {

	String insertQuery = "INSERT INTO cuentas(Nick, Email, Password, Direccion, Pais, Nacimiento) VALUES (?, ?, ?, ?, ?, ?)";
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
      // FIN METODOS DE GESTION DE CUENTAS
      ///////////////////////////////////////////////////////////////
      ///////////////////////////////////////////////////////////////
      ///////////////////////////////////////////////////////////////
      // METODOS CREAR CLASES
      public boolean createArquero(int id, String usuario, String personaje) {

	String insertQuery = "INSERT INTO personajes(cuentas_idCuentas, Nombre,Clase, Dmg,"
                + "CritDmg, Def, Evasion, Hp, Mp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
        
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
                stmt.setInt(1, id);
                stmt.setString(2, personaje);
                stmt.setString(3, "Arquero");
                stmt.setInt(4, 15);
                stmt.setInt(5, 200);
                stmt.setInt(6, 9);
                stmt.setInt(7, 10);
                stmt.setInt(8, 100);
                stmt.setInt(9, 58);
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
      
       public boolean createWarrior(int id, String usuario, String personaje) {

	String insertQuery = "INSERT INTO personajes(cuentas_idCuentas, Nombre,Clase, Dmg,"
                + "CritDmg, Def, Evasion, Hp, Mp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
        
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
                stmt.setInt(1, id);
                stmt.setString(2, personaje);
                stmt.setString(3, "Guerrero");
                stmt.setInt(4, 8);
                stmt.setInt(5, 150);
                stmt.setInt(6, 14);
                stmt.setInt(7, 3);
                stmt.setInt(8, 140);
                stmt.setInt(9, 24);
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
        public boolean createMago(int id, String usuario, String personaje) {

	String insertQuery = "INSERT INTO personajes(cuentas_idCuentas, Nombre,Clase, Dmg,"
                + "CritDmg, Def, Evasion, Hp, Mp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	Connection con = null;
	PreparedStatement stmt = null;
        
	int rows = 0;
            try {
                con = getConnection();
                stmt = con.prepareStatement(insertQuery);
                stmt.setInt(1, id);
                stmt.setString(2, personaje);
                stmt.setString(3, "Mago");
                stmt.setInt(4, 22);
                stmt.setInt(5, 0);
                stmt.setInt(6, 6);
                stmt.setInt(7, 5);
                stmt.setInt(8, 70);
                stmt.setInt(9, 110);
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
      // FIN METODOS CREAR CLASES
}
