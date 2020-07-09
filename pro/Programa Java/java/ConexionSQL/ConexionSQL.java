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
     // METODOS SET && GET
     //Saca el nombre
      public String Personaje(int id){
         String ComprobacionQuery = "select Nombre from personajes where cuentas_idCuentas = ?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
         String personaje = null;
         try {
        con = getConnection();
        //syso "onectado a".concat(url);
        //inicializamos Statement
        pst=con.prepareStatement(ComprobacionQuery);

        pst.setInt(1, id);
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
       
    //Saca el dmg del personaje
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
    //Saca la defensa del personaje
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
     //Saca la vida del personaje
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
     //Saca la exp del personaje
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
      //Saca el nivel del personaje
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
       //SETEAR TODA LA INFO
        public Jugador setJugador(Jugador player, String jugador) {
        String ComprobacionQuery= "SELECT * from personajes WHERE Nombre=?";
         Connection con = null;
         PreparedStatement pst = null;
         ResultSet rs = null;
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
            player.setNombre(rs.getString("Nombre"));
            player.setNivel(rs.getInt("Nivel"));
            player.setClase(rs.getString("Clase"));
            player.setAtq(rs.getInt("Dmg"));
            player.setDcrit(rs.getInt("CritDmg"));
            player.setDef(rs.getInt("Def"));
            player.setEva(rs.getInt("Evasion"));
            player.setHp(rs.getInt("Hp"));
            player.setMp(rs.getInt("Mp"));
           
             
          

        }
            pst.close();
            rs.close();
            con.close();
           return player;

        

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return player;
    }
  }
       
       
       //Saca el arma que tiene el personaje
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
        public String obtenerArmadura(String jugador) {
             String ComprobacionQuery= "SELECT ArmaduraEquipada from personajes WHERE Nombre=?";
             Connection con = null;
             PreparedStatement pst = null;
             ResultSet rs = null;
             String armadura = null;
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
                armadura = (rs.getString("ArmaduraEquipada"));


            }
                pst.close();
                rs.close();
                con.close();
               return armadura;



            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return armadura;
            }
          }
        //Saca el id del personaje
        public int obtenerIdPersonaje(String jugador) {
             String ComprobacionQuery= "SELECT idPersonajes from personajes WHERE Nombre=?";
             Connection con = null;
             PreparedStatement pst = null;
             ResultSet rs = null;
             int id = 0;
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
                id = (rs.getInt("idPersonajes"));


            }
                pst.close();
                rs.close();
                con.close();
                return id;



            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return id;
            }
          }  
         public int obtenerIdCuenta(String jugador) {
             String ComprobacionQuery= "SELECT idCuentas from cuentas WHERE Nick=?";
             Connection con = null;
             PreparedStatement pst = null;
             ResultSet rs = null;
             int id = 0;
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
                id = (rs.getInt("idCuentas"));


            }
                pst.close();
                rs.close();
                con.close();
                return id;



            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return id;
            }
          }  
        //Actualiza el oro del personaje
        public void lootGold(String jugador, int dinero) {
            String ComprobacionQuery= "update personajes SET Dinero = ? where Nombre = ?";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
                con = getConnection();

               //inicializamos Statement
               pst=con.prepareStatement(ComprobacionQuery);

               //Ejecutamos y recumeramos la consulta SQL
               pst.setInt(1, dinero);
               pst.setString(2, jugador);
               pst.executeUpdate();

                 pst.close();
                 con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println("Problemas al settear el dinero en la base de datos");

               }

        } 
        
      
       
// FIN METODOS DE SETS && GETS
      
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
        
         public void subirStatsWarr(String jugador, Jugador player) {
            String ComprobacionQuery= "UPDATE personajes SET Dmg = ?, Def = ?, Evasion = ?, Hp = ?, Mp = ? WHERE ( Nombre = ?)";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            double newmp = player.getMp() * 1.3;
            double newhp = player.getHp() * 1.5;
            double neweva = player.getEva() * 1.2;
            double newdef = player.getDef() * 1.7;
            double newdmg = player.getAtq() * 1.3;
            int mp = (int) newmp;
            int hp = (int) newhp;
            int eva = (int) neweva;
            int def = (int) newdef;
            int dmg = (int) newdmg;
            try {
            con = getConnection();

           //syso "onectado a".concat(url);
           //inicializamos Statement
           pst=con.prepareStatement(ComprobacionQuery);

           //Ejecutamos y recumeramos la consulta SQL
           pst.setInt(1, dmg);
           pst.setInt(2, def);
           pst.setInt(3, eva);
           pst.setInt(4, hp);
           pst.setInt(5, mp);
           pst.setString(6, jugador);
           pst.executeUpdate();

             pst.close();
             con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println("Fallo al subir los parametros al subir de nivel");
               }
            
    } 
           public void subirStatsMago(String jugador, Jugador player) {
            String ComprobacionQuery= "UPDATE personajes SET Dmg = ?, Def = ?, Evasion = ?, Hp = ?, Mp = ? WHERE ( Nombre = ?)";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            double newmp = player.getMp() * 1.7;
            double newhp = player.getHp() * 1.2;
            double neweva = player.getEva() * 1.2;
            double newdef = player.getDef() * 1.3;
            double newdmg = player.getAtq() * 1.5;
            int mp = (int) newmp;
            int hp = (int) newhp;
            int eva = (int) neweva;
            int def = (int) newdef;
            int dmg = (int) newdmg;
            try {
            con = getConnection();

           //syso "onectado a".concat(url);
           //inicializamos Statement
           pst=con.prepareStatement(ComprobacionQuery);

           //Ejecutamos y recumeramos la consulta SQL
           pst.setInt(1, dmg);
           pst.setInt(2, def);
           pst.setInt(3, eva);
           pst.setInt(4, hp);
           pst.setInt(5, mp);
           pst.setString(6, jugador);
           pst.executeUpdate();

             pst.close();
             con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println("Fallo al subir los parametros al subir de nivel");
               }
            
    } 
           
           public void subirStatsArcher(String jugador, Jugador player) {
            String ComprobacionQuery= "UPDATE personajes SET Dmg = ?, Def = ?, Evasion = ?, Hp = ?, Mp = ? WHERE ( Nombre = ?)";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            double newmp = player.getMp() * 1.5;
            double newhp = player.getHp() * 1.5;
            double neweva = player.getEva() * 1.6;
            double newdef = player.getDef() * 1.5;
            double newdmg = player.getAtq() * 1.5;
            int mp = (int) newmp;
            int hp = (int) newhp;
            int eva = (int) neweva;
            int def = (int) newdef;
            int dmg = (int) newdmg;
            try {
            con = getConnection();

           //syso "onectado a".concat(url);
           //inicializamos Statement
           pst=con.prepareStatement(ComprobacionQuery);

           //Ejecutamos y recumeramos la consulta SQL
           pst.setInt(1, dmg);
           pst.setInt(2, def);
           pst.setInt(3, eva);
           pst.setInt(4, hp);
           pst.setInt(5, mp);
           pst.setString(6, jugador);
           pst.executeUpdate();

             pst.close();
             con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println("Fallo al subir los parametros al subir de nivel");
               }
            
    } 
    //FIN METODOS DE SUBIR STATS AL SUBIR DE LVL
    //AÑADIR HABILIDADES A CADA CLASE
        public void newWarrSkillSQL(int id,String nombre, int dmg, int heal, int costemp, String elemento){
            String query = "INSERT INTO habilidades(personajes_idPersonajes, NombreHabilidad, SkillDmg, SkillHeal, CosteMp, Elemento) VALUES (?, ?, ?, ?, ?, ?)";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
            con = getConnection();
      
            //inicializamos Statement
            pst=con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setInt(3, dmg);
            pst.setInt(4, heal);
            pst.setInt(5, costemp);
            pst.setString(6, elemento);
            pst.executeUpdate();

            pst.close();
            con.close();

        }   catch (SQLException ex) {
                Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                   
            }
        }
        public void newMageSkillSQL(int id,String nombre, int dmg, int heal, int costemp, String elemento){
            String query = "INSERT INTO habilidades(personajes_idPersonajes, NombreHabilidad, SkillDmg, SkillHeal, CosteMp, Elemento) VALUES (?, ?, ?, ?, ?, ?)";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
            con = getConnection();

            //inicializamos Statement
            pst=con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setInt(3, dmg);
            pst.setInt(4, heal);
            pst.setInt(5, costemp);
            pst.setString(6, elemento);
            pst.executeUpdate();

             pst.close();
             con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);

               }
           }
        public void newArcherSkillSQL(int id,String nombre, int dmg, int heal, int costemp, String elemento){
            String query = "INSERT INTO habilidades(personajes_idPersonajes, NombreHabilidad, SkillDmg, SkillHeal, CosteMp, Elemento) VALUES (?, ?, ?, ?, ?, ?)";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
            con = getConnection();

           //inicializamos Statement
           pst=con.prepareStatement(query);

           pst.setInt(1, id);
           pst.setString(2, nombre);
           pst.setInt(3, dmg);
           pst.setInt(4, heal);
           pst.setInt(5, costemp);
           pst.setString(6, elemento);
           pst.executeUpdate();

             pst.close();
             con.close();

           }   catch (SQLException ex) {
                   Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);

               }
        }
    //FIN AÑADIR HABILIDADES A CADA CLASE    
        
       
}//Fin clase