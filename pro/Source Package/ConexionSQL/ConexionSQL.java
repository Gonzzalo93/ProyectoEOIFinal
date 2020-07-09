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
import javax.servlet.http.HttpSession;

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
       
         public int checkIdPersonaje(int id){
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
            
        public String checkPersonaje(int id){
         String query = "Select Nombre from personajes where cuentas_idCuentas= ?";
         Connection con = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         String nombre = null;
            try {
                con = getConnection();
                stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
                System.out.println("Ejecutando la query: " + query);
				
		rs = stmt.executeQuery();
                while(rs.next()){
                   nombre = rs.getString("Nombre");
                }
                
                rs = null;
		stmt.close();
                con.close();
                return nombre;
                
            } catch (SQLException e) {
               // TODO Auto-generated catch block
                System.out.println("Fallo en el metodo de sql");
               e.printStackTrace();
               return nombre;
            }
         }     
         public int checkCash(int cash){
            String query = "Select Dinero from personajes where cuentas_idCuentas= ?";
            Connection con = null;
             PreparedStatement stmt = null;
             ResultSet rs = null;
                 int dinero = 0;
                    try {
                        con = getConnection();
                        stmt = con.prepareStatement(query);
                        stmt.setInt(1, cash);
                        System.out.println("Ejecutando la query: " + query);
				
                        rs = stmt.executeQuery();
                         while(rs.next()){
                         dinero = rs.getInt("Dinero");
                             }
                
                            rs = null;
                            stmt.close();
                            con.close();
                            return dinero;
                
            } catch (SQLException e) {
               // TODO Auto-generated catch block
                System.out.println("Fallo en el metodo de sql");
               e.printStackTrace();
               return dinero;
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
                stmt.setInt(4, 25);
                stmt.setInt(5, 200);
                stmt.setInt(6, 18);
                stmt.setInt(7, 10);
                stmt.setInt(8, 160);
                stmt.setInt(9, 120);
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
                stmt.setInt(4, 15);
                stmt.setInt(5, 150);
                stmt.setInt(6, 23);
                stmt.setInt(7, 3);
                stmt.setInt(8, 240);
                stmt.setInt(9, 70);
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
                stmt.setInt(4, 31);
                stmt.setInt(5, 0);
                stmt.setInt(6, 13);
                stmt.setInt(7, 5);
                stmt.setInt(8, 110);
                stmt.setInt(9, 200);
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
        
        public boolean nuevoNombre(String nombre, String cambioname) {
         try {
             String insertQuery = "UPDATE cuentas SET Nick = ? WHERE Nick = ? "; /* en test habrá que cojer el nombre del login antiguo*/
                     
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, nombre);
             stmt.setString(2, cambioname);
              System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
				
		return true;
         } catch (SQLException ex) {
             
                return false;
         }
      }
      
      public boolean cambioPassword(String password, String nuevapass) {
         try {
             String insertQuery = "UPDATE cuentas SET Password = ? WHERE (Nick = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, password);
             stmt.setString(2, nuevapass);
             System.out.println(" sesion vale: " + nuevapass);
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
             
             return true;
         } catch (SQLException ex) {
            
             return false;
         }
      }
        
        
      
      
       public boolean cambioEmail(String email, String sesioncorreo) {
         try {
             String insertQuery = "UPDATE cuentas SET Email = ? WHERE (Nick = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, email);
             stmt.setString(2, sesioncorreo);
             System.out.println("sesioncorreo vale :D ---> " + sesioncorreo);
                     
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
             
             return true;
         } catch (SQLException ex) {
            
             return false;
         }
      }
       
       
       public boolean borrarCuenta(String borrarnick) {
          
         try {
             
             String insertQuery = "DELETE FROM cuentas WHERE (Nick = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString (1 , borrarnick);
             System.out.println("borranick vale.. :D --> " + borrarnick);
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
             
             return true;
         } catch (SQLException ex) {
            
             return false;
         }
      }
       /* "INSERT INTO personajes(cuentas_idCuentas, Nombre,Clase, Dmg,"
                + "CritDmg, Def, Evasion, Hp, Mp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; */
       
       public boolean enviarTicket(int id, String opcion, String titulo, String descripcion) {
         try {
             String insertQuery = "INSERT INTO consultas (cuentas_idCuentas, Categoria, Titulo, Comentarios) VALUES (?, ?, ?, ?)";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             /* if (gestion.cambioPassword(opcion,titulo,descripcion,nuevapass)){*/
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setInt(1, id);
             stmt.setString(2, opcion);    
             stmt.setString(3, titulo);
             stmt.setString(4, descripcion);
             /*stmt.setString(4, sesion);*/
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
             
             return true;
         } catch (SQLException ex) {
            
             return false;
         }
       }
         // METODOS TIENDA
         
        public void addWeapon(int id, String personaje, String arma) {

            String insertQuery = "INSERT INTO personajes (cuentas_idCuentas,Nombre, ArmaEquipada) VALUES (?, ?, ?)";
            Connection con = null;
            PreparedStatement stmt = null;

            int rows = 0;
                try {
                    con = getConnection();
                    stmt = con.prepareStatement(insertQuery);
                    stmt.setInt(1, id);
                    stmt.setString(2, personaje);
                    stmt.setString(3, arma);
                    System.out.println("Ejecutando la query: " + insertQuery);

                    rows = stmt.executeUpdate();
                    System.out.println("Registros afectados: " + rows);

                    stmt.close();
                    con.close();

                    


                } catch (SQLException e) {
                    e.printStackTrace();
                    
            }

        }
        public void addArmor(int id, String personaje, String armor) {

            String insertQuery = "INSERT INTO personajes (cuentas_idCuentas,Nombre, ArmadiraEquipada) VALUES (?, ?, ?)";
            Connection con = null;
            PreparedStatement stmt = null;

            int rows = 0;
                try {
                    con = getConnection();
                    stmt = con.prepareStatement(insertQuery);
                    stmt.setInt(1, id);
                    stmt.setString(2, personaje);
                    stmt.setString(3, armor);
                    System.out.println("Ejecutando la query: " + insertQuery);

                    rows = stmt.executeUpdate();
                    System.out.println("Registros afectados: " + rows);

                    stmt.close();
                    con.close();


                } catch (SQLException e) {
                    e.printStackTrace();
            }

        }
         public void cambioArma(String personaje, String arma) {
         try {
             String insertQuery = "UPDATE personajes SET ArmaEquipada = ? WHERE (Nombre = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, arma);
             stmt.setString(2, personaje);
                     
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
         } catch (SQLException ex) {
         }
      }
        public void cambioArmadura(String personaje, String armadura) {
         try {
             String insertQuery = "UPDATE personajes SET ArmaduraEquipada = ? WHERE (Nombre = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, armadura);
             stmt.setString(2, personaje);
                     
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
         } catch (SQLException ex) {
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
          }  public String obtenerArmadura(String jugador) {
             String ComprobacionQuery= "SELECT ArmaduraEquipada from personajes WHERE Nombre=?";
             Connection con = null;
             PreparedStatement pst = null;
             ResultSet rs = null;
             String armadura = null;
             try {
            con = getConnection();

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
          public void gastarDinero(String personaje, int coste) {
         try {
             String insertQuery = "UPDATE personajes SET Dinero= ? WHERE (Nombre = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setInt(1, coste);
             stmt.setString(2, personaje);
                     
             System.out.println("Ejecutando la query: " + insertQuery);
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
         } catch (SQLException ex) {
         }
      }
     //FIN METODOS TIENDA
          
       
       /* ########## GESTION DEL ADMINISTRADOR ##########*/
       
       public boolean adminNuevoNombre(String antiguo, String nuevo) {
         try {
             String insertQuery = "UPDATE cuentas SET Nick = ? WHERE Nick = ? "; 
                     
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, nuevo);
             stmt.setString(2, antiguo);
             System.out.println("nuevoo" + nuevo);
             System.out.println("antiguooooo" + antiguo);
              System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
		return true;		
		
         } catch (SQLException ex) {
             
               return false;
         }
      }
       
       
       public boolean adminNuevaPass(String user, String nueva) {
         try {
             String insertQuery = "UPDATE cuentas SET Password = ? WHERE Nick = ? "; 
                     
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, nueva);
             stmt.setString(2, user);
             System.out.println("al usuario " + user);
             System.out.println("contraseñaa " + nueva);
              System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
		return true;		
		
         } catch (SQLException ex) {
             
               return false;
         }
      }
       
        public boolean adminNuevoEmail(String user, String nueva) {
         try {
             String insertQuery = "UPDATE cuentas SET Email = ? WHERE Nick = ? "; 
                     
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString(1, nueva);
             stmt.setString(2, user);
              System.out.println("Ejecutando la query: " + insertQuery);
				
		rows = stmt.executeUpdate();
                System.out.println("Registros afectados: " + rows);
				
		stmt.close();
                con.close();
		return true;		
		
         } catch (SQLException ex) {
             
               return false;
         }
      }
        
        
        
        public boolean adminBorrarCuenta(String user) {
          
         try {
             
             String insertQuery = "DELETE FROM cuentas WHERE (Nick = ? )";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString (1 , user);
             
            
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
             
             return true;
         } catch (SQLException ex) {
            
             return false;
         }
      }

    public boolean adminEstadisticas(String cuenta, String personaje, String clase, String oro, String nivel, String progreso, String hp, String mp, String atq, String def, String eva) {
          
         try {
             
             String insertQuery = "UPDATE cuentas SET personaje = ?, clase = ?, oro = ?, nivel = ?, progreso = ?, hp = ?, mp = ?, atq = ?, def = ?, eva = ? WHERE cuentas_idCuentas = ? ";
             Connection con = null;
             PreparedStatement stmt = null;
             int rows = 0;
             
             
             con = getConnection();
             stmt = con.prepareStatement(insertQuery);
             stmt.setString (1 , cuenta);
             stmt.setString (2 , personaje);
             stmt.setString (3 , clase);
             stmt.setString (4 , oro);
             stmt.setString (5 , nivel);
             stmt.setString (6 , progreso);
             stmt.setString (7 , hp);
             stmt.setString (8 , mp);
             stmt.setString (9 , atq);
             stmt.setString (10 , def);
             stmt.setString (11 , eva);
             
            
             
             rows = stmt.executeUpdate();
             System.out.println("Registros afectados: " + rows);
             
             stmt.close();
             con.close();
             
             return true;
         } catch (SQLException ex) {
            
             return false;
         }
    }
}

