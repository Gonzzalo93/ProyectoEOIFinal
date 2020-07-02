/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import ConexionSQL.ConexionSQL;
import ValoresUsuario.Jugador;
import ValoresUsuario.Monstruo;
import ValoresUsuario.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login login = new Login();
        login.setVisible(true);
        System.out.println(login.check);
        if(login.isCheck() == true){
            charSelect select = new charSelect();
            login.dispose();
            select.setVisible(true);
        }
    }
    
}
// VENTANAS
// VENTANA LOGIN
class Login extends javax.swing.JFrame {
    boolean check = true;
    //Setters & Getters

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        campoUsuario = new javax.swing.JTextField();
        campoPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoUsuario)
                            .addComponent(campoPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addContainerGap(161, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(loginButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>                        

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        
                String user = campoUsuario.getText();
		String password = campoPassword.getText();
				
                ConexionSQL gestion = new ConexionSQL();
                
		Usuario usu = new Usuario();
		usu.setUsuario(user);
		usu.setPassword(password);
		gestion.validarUsuario(usu);
		
		if(gestion.validarUsuario(usu)) {
			JOptionPane.showMessageDialog(null, "Bienvenido");
			
                        this.check=true;
                          
			
		}else {
			JOptionPane.showMessageDialog(null, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
                        this.check=false;
					
		}
    }                                           
//METODOS MANUALES
   

    // Variables                      
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    // End of variables declaration 
}
// FIN VENTANA LOGIN
///////////////////////////////////
// VENTANA SELECCION DEL MAPA
class charSelect extends javax.swing.JFrame {

    /**
     * Creates new form charSelect
     */
    public charSelect() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        Mapa1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mapa1.setText("Mapa1");
        Mapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mapa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Mapa1)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Mapa1)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void Mapa1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
         
         Mapa1 ventana = new Mapa1 ();
         this.dispose();
         ventana.setVisible(true);
    }                                     

  

    // Variables declaration - do not modify                     
    private javax.swing.JButton Mapa1;
    private java.awt.Canvas canvas1;
    // End of variables declaration                   
}
// FIN DE LA VENTANA DE SELECCIÓN DEL MAPA
///////////////////////////////////////////////////
// VENTANA DEL PRIMER MAPA
class Mapa1 extends javax.swing.JFrame {
Jugador jugador = new Jugador();
Monstruo enemigo = new Monstruo ();
    /**
     * Creates new form Mapa1
     */
    public Mapa1() {
        initComponents();
        jugador.setHp(200);
        jugador.setAtq(30);
        enemigo.setAtq(10);
        enemigo.setHp(120);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Atacar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Atacar.setText("Atacar");
        Atacar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtacarMouseClicked(evt);
            }
        });
        Atacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtacarActionPerformed(evt);
            }
        });

        Consola.setColumns(20);
        Consola.setRows(5);
        jScrollPane1.setViewportView(Consola);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(Atacar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Atacar)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void AtacarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        enemigo.setHp(enemigo.getHp()-jugador.getAtq());
        jugador.setHp(jugador.getHp()-enemigo.getAtq());
        Consola.setText(jugador.toString()+
                "Infliges: " + jugador.getAtq() + " de daño al enemigo"+ "\n" +
            "Salud total del enemigo:" + enemigo.getHp() + "\n"+
            "Te infligen: " + enemigo.getAtq() + " de daño como contraataque" + "\n" +
            "Tu salud: " + jugador.getHp());
        if(jugador.getHp() <=0 || enemigo.getHp() <=0){
            charSelect ventana = new charSelect();
            ventana.setVisible(true);
            this.dispose();
        }
    }                                      

    private void AtacarMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
    }                                   
  

    // Variables declaration - do not modify                     
    private javax.swing.JButton Atacar;
    private javax.swing.JTextArea Consola;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   

}
// FIN VENTANA DEL MAPA 1
/////////////////////////////