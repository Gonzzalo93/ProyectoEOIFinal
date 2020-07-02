/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import ValoresUsuario.Jugador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ValoresUsuario.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class ConexionSQL {
    // CONEXION CON LA BASE DE DATOS
        public static Connection getConnection() throws SQLException {
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

     // METODOS DE MYSQL
     public boolean validarUsuario(Usuario usu) {
         String ComprobacionQuery= "SELECT Password from cuentas WHERE Nick=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         Usuario usuario = null;
         String password = null;
         try {
        con = getConnection();
        System.out.println("Conectado a ");
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        pst.setString(1, usu.getUsuario());
        //Ejecutamos y recumeramos la consulta SQL

        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            password = (rs.getString("password"));
          

        }
            pst.close();
            rs.close();
            con.close();
            if(usu.getPassword().equals(password)){
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
     // METODOS SET
      public String Personaje(String nick){
         String ComprobacionQuery = "SELECT Nombre from personajes WHERE cuentas_Nick=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         String personaje = null;
         try {
        con = getConnection();
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        pst.setString(1, nick);
        //Ejecutamos y recumeramos la consulta SQL

        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            personaje = (rs.getString("Nombre"));
          

        }
            pst.close();
            rs.close();
            con.close();
           
            return personaje;
        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return personaje;
    }
      }
       
    
    public int obtenerDmg(String jugador){
        String ComprobacionQuery= "SELECT Dmg from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         int dmg = 0;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setString(1, jugador);
        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            dmg = (rs.getInt("Dmg"));
          

        }
            pst.close();
            rs.close();
            con.close();
           return dmg;

        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
             System.out.println("No me coge el daño");
        return dmg;
    }
     }    
     public int obtenerDef(String jugador){
        String ComprobacionQuery= "SELECT Def from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         int def = 0;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setString(1, jugador);
        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            def = (rs.getInt("Def"));
          

        }
            pst.close();
            rs.close();
            con.close();
           return def;

        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
             System.out.println("No me coge el daño");
        return def;
    }
     }    
     public int obtenerHp(String jugador) {
        String ComprobacionQuery= "SELECT Hp from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         int hp = 0;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setString(1, jugador);
        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            hp = (rs.getInt("Hp"));
          

        }
            pst.close();
            rs.close();
            con.close();
           return hp;

        

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return hp;
        }
     }   
      public int obtenerExp(String jugador) {
        String ComprobacionQuery= "SELECT Experiencia from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         int exp = 0;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setString(1, jugador);
        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            exp = (rs.getInt("Experiencia"));
          

        }
            pst.close();
            rs.close();
            con.close();
           return exp;

        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return exp;
    }
  }
      
       public int obtenerLvl(String jugador) {
        String ComprobacionQuery= "SELECT Nivel from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         int lvl = 0;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setString(1, jugador);
        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            lvl = (rs.getInt("Nivel"));
          

        }
            pst.close();
            rs.close();
            con.close();
           return lvl;

        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return lvl;
    }
  }
       
       public String obtenerArma(String jugador) {
        String ComprobacionQuery= "SELECT ArmaEquipada from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         String arma = null;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setString(1, jugador);
        rs= pst.executeQuery();


        //recorremos el cursor con los datos obtenidos
            while (rs.next()) {
            arma = (rs.getString("ArmaEquipada"));
          

        }
            pst.close();
            rs.close();
            con.close();
           return arma;

        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return arma;
    }
  }
       
       
// FIN METODOS DE SETS
      
        public int sumarExp(String jugador, int exp, int exp2) {
        String ComprobacionQuery= "update personajes SET Experiencia = ? where Nombre = ?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         int expe = exp + exp2;
         try {
        con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setInt(1, expe);
        pst.setString(2, jugador);
        pst.executeUpdate();

          pst.close();
          con.close();
          return expe;
        }   catch (SQLException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   return expe;
            }
            
    } 


        // METODOS DE LVL UP
        public void levelUpSQL(String jugador, int nivel) {
            String ComprobacionQuery= "update personajes SET Nivel = ? where Nombre = ?";
             Connection con = null;
             PreparedStatement pst = null;

             try {
                con = getConnection();

                //syso "onectado a".concat(url);
                //inicializamos Statement
                pst=con.prepareStatement(ComprobacionQuery);

                //Ejecutamos y recumeramos la consulta SQL
                pst.setInt(1, nivel);
                pst.setString(2, jugador);
                pst.executeUpdate();

                  pst.close();
                  con.close();

            }   catch (SQLException ex) {
                    Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
          

        

    } 
        
         public void subirDmg(String jugador, Jugador player) {
            String ComprobacionQuery= "update personajes SET Dmg = ? where Nombre = ?";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            double newdmg = player.getAtq() * 1.3;
            int dmg = (int) newdmg;
            try {
            con = getConnection();

           //syso "onectado a".concat(url);
           //inicializamos Statement
           pst=con.prepareStatement(ComprobacionQuery);

           //Ejecutamos y recumeramos la consulta SQL
           pst.setInt(1, dmg);
           pst.setString(2, jugador);
           pst.executeUpdate();

             pst.close();
             con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);

               }
            
    } 
         public void subirDef(String jugador, Jugador player) {
         String ComprobacionQuery= "update personajes SET Def = ? where Nombre = ?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         double newdef = player.getDef() * 1.8;
         int def = (int) newdef;
         try {
         con = getConnection();
      
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setInt(1, def);
        pst.setString(2, jugador);
        pst.executeUpdate();

          pst.close();
          con.close();
          
        }   catch (SQLException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   
            }
            
    }  
        public void subirHp(String jugador, Jugador player) {
         String ComprobacionQuery= "update personajes SET Hp = ? where Nombre = ?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         double newhp = player.getHp() * 1.4;
         int hp = (int) newhp;
         try {
         con = getConnection();
      
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        //Ejecutamos y recumeramos la consulta SQL
        pst.setInt(1, hp);
        pst.setString(2, jugador);
        pst.executeUpdate();

          pst.close();
          con.close();
          
        }   catch (SQLException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   
            }
            
    } 
}//Fin clase






    

