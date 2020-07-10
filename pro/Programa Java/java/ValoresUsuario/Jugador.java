/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValoresUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConexionSQL.ConexionSQL;
import static ConexionSQL.ConexionSQL.getConnection;
import java.sql.SQLException;
import java.util.Random;
/**
 *
 * @author migue
 */
public class Jugador {
     String nombre;
     String clase;
    int hp;
    int mp;
    int def;
    int atq;
    int eva;
    int Tcrit;
    int Dcrit;
    int exp;
    int nivel;
    int dinero;
    public Jugador(){
       // CONSTRUCTORES
    }
    public Jugador(String nombre,int hp,int atq, int def, int exp ){
        this.nombre = nombre;
        this.hp = hp;
        this.atq = atq;
        this.exp = exp;
        this.def = def;
    }
    //SETTERS & GETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getEva() {
        return eva;
    }

    public void setEva(int eva) {
        this.eva = eva;
    }

    public int getTcrit() {
        return Tcrit;
    }

    public void setTcrit(int Tcrit) {
        this.Tcrit = Tcrit;
    }

    public int getDcrit() {
        return Dcrit;
    }

    public void setDcrit(int Dcrit) {
        this.Dcrit = Dcrit;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    
 //TO STRING
    @Override
    public String toString() {
        return this.nombre + " lvl: " + this.nivel+ "\n Clase: "+ clase +"\nHP: " + this.hp + "MP: " + this.mp + "\ndaño: " + atq +
                "\ndef: " + def;
    }
    // METODOS
    //CALCULAR DAÑOS
    public int calcAtacar(Jugador jugador, Monstruo enemigo){
        Random number = new Random();
        Random probCrit = new Random();
        Random probEva = new Random ();
        int rEva = probEva.nextInt(100) + 1;
        int rCrit = probCrit.nextInt(100) + 1;
        int N = jugador.getNivel();
        int A = jugador.getAtq();
        int D = enemigo.getDef();
        int V = number.nextInt(15)+85;
        int eva = enemigo.getEva();
        int tc = jugador.getTcrit();
        int dc = jugador.getDcrit();
        double calc =  0.01 * V * ((( 8 * A ) *N) / ( 5 * D)) ;
        int res = (int) calc;
        
        if(rCrit <= tc){
            res = res * (dc / 100 );
            
        }
        if (rEva <= eva){
            res = 0;
        }
        return res;
    }
     public int calcSkill(Jugador jugador, Monstruo enemigo, int p) {
         Random number = new Random();
        Random probCrit = new Random();
        Random probEva = new Random ();
        int rEva = probEva.nextInt(100) + 1;
        int rCrit = probCrit.nextInt(100) + 1;
        int N = jugador.getNivel();
        int A = jugador.getAtq();
        int D = enemigo.getDef();
        int V = number.nextInt(15)+85;
        int eva = enemigo.getEva();
        int tc = jugador.getTcrit();
        int dc = jugador.getDcrit();
        double calc =  0.01 * V * ((( 7 * (A * p)) * N) /  ( 6 * D )) ;
        int res = (int) calc;
        
        if(rCrit <= tc){
            res = res * (dc / 100 );
            
        }
        if (rEva <= eva){
            res = 0;
        }
        return res;
    }
     //SUBIDAS DE NIVEL
   public int levelUp(int exp){
       
               if(exp >= 30 && exp < 100){
                   return 2;
               }else if(exp >= 100 && exp < 500){
                   return 3;
               }else if(exp >= 500  && exp < 940){
                   return 4;
               }else if(exp >= 940  && exp < 1830){
                   return 5;
               }else if(exp >= 1830  && exp < 3200){
                   return 6;
               }else if(exp >= 3200  && exp < 5780){
                   return 7;
               }else if(exp >= 5780  && exp < 11080){
                   return 8;
               }else if(exp >= 11080  && exp < 24900){
                   return 9;
               }else if(exp >= 24900  && exp < 52300){
                   return 10;
               }else  if(exp >= 24900){
                   return 11;
               }else {
                   return 1;
               }  
             
       }
    //FIN DE LEVELUP
  
    //METODOS PARA SUBIR STATS SI TIENE EQUIPADO UN ARMA O ARMADURA
        public void equipo(Jugador jugador, String arma, String armadura){
            //ARMADURAS
            switch(armadura){
                case "Nada":
                    jugador.setDef(jugador.getDef() + 0);
                    jugador.setHp(jugador.getHp() +0);                
                    jugador.setEva(jugador.getEva() + 0);
                    break;
                    //ARMADURA GUERRERO
                case "Escudo basico":
                    jugador.setDef(jugador.getDef() + 14);
                    jugador.setHp(jugador.getHp() +100);                
                    jugador.setEva(jugador.getEva() + 2);        
                    break;
                case "Escudo robusto":
                    jugador.setDef(jugador.getDef() + 33);
                    jugador.setHp(jugador.getHp() +470);                
                    jugador.setEva(jugador.getEva() + 3);         
                    break;
                case "Escudo de plata":
                    jugador.setDef(jugador.getDef() + 68);
                    jugador.setHp(jugador.getHp() +810);                
                    jugador.setEva(jugador.getEva() + 4);           
                    break;
                case "Gran escudo":
                    jugador.setDef(jugador.getDef() + 94);
                    jugador.setHp(jugador.getHp() + 1300);                
                    jugador.setEva(jugador.getEva() + 4);           
                    break;
                case "Coraza inmortal":
                    jugador.setDef(jugador.getDef() + 140);
                    jugador.setHp(jugador.getHp() +2520);                
                    jugador.setEva(jugador.getEva() + 5);             
                    break;
                    //ARMADURA ARQUERO
                case "Zapatillas basicas":
                    jugador.setDef(jugador.getDef() + 8);
                    jugador.setHp(jugador.getHp() +50);                
                    jugador.setEva(jugador.getEva() + 3);           
                    break;
                case "Zapatillas practicas":
                    jugador.setDef(jugador.getDef() + 18);
                    jugador.setHp(jugador.getHp() +140);                
                    jugador.setEva(jugador.getEva() + 6);              
                    break;
                case "Chanclas del viento":
                    jugador.setDef(jugador.getDef() + 31);
                    jugador.setHp(jugador.getHp() +210);                
                    jugador.setEva(jugador.getEva() + 9);               
                    break;
                case "Viento aureo":
                    jugador.setDef(jugador.getDef() + 68);
                    jugador.setHp(jugador.getHp() +370);                
                    jugador.setEva(jugador.getEva() + 12);               
                    break;
                case "Paso ligero":
                    jugador.setDef(jugador.getDef() + 92);
                    jugador.setHp(jugador.getHp() +560);                
                    jugador.setEva(jugador.getEva() + 15);             
                    break;
                    //ARMADURA DE MAGO
                case "Gorro de principiante":
                    jugador.setDef(jugador.getDef() + 5);
                    jugador.setHp(jugador.getHp() +20);                
                    jugador.setEva(jugador.getEva() + 2);
                    break;
                case "Gorro de mago":
                    jugador.setDef(jugador.getDef() + 15);
                    jugador.setHp(jugador.getHp() + 60);                
                    jugador.setEva(jugador.getEva() + 5);
                    break;
                case "Gorro maldito":
                    jugador.setDef(jugador.getDef() + 28);
                    jugador.setHp(jugador.getHp() +120);                
                    jugador.setEva(jugador.getEva() + 6);
                    break;
                case "Tiara infernal":
                    jugador.setDef(jugador.getDef() + 49);
                    jugador.setHp(jugador.getHp() +200);                
                    jugador.setEva(jugador.getEva() + 7);
                    break;
                case "Corona del fin":
                    jugador.setDef(jugador.getDef() + 65);
                    jugador.setHp(jugador.getHp() +400);                
                    jugador.setEva(jugador.getEva() + 10);
                    break;
                default:
                    System.out.println("No tiene armadura");
                    break;
        }
            //ARMAS
            switch(arma){
                case "Nada":
                    jugador.setAtq(jugador.getAtq() + 0);
                    jugador.setTcrit(0);                
                    break;
                    //ARMA GUERRERO
                case "Espada de madera":
                    jugador.setAtq(jugador.getAtq() + 20);
                    jugador.setTcrit(4);                
                    break;
                case "Espada de plata":
                    jugador.setAtq(jugador.getAtq() + 44);
                    jugador.setTcrit(8);                
                    break;
                case "Espada de hierro rojo":
                    jugador.setAtq(jugador.getAtq() + 67);
                    jugador.setTcrit(15);                
                    break;
                case "Espada de los antiguos":
                    jugador.setAtq(jugador.getAtq() + 100);
                    jugador.setTcrit(25);                
                    break;
                case "Sangre nocturna":
                    jugador.setAtq(jugador.getAtq() + 140);
                    jugador.setTcrit(40);                
                    break;
                    //ARMA ARQUERO
                case "Arco de practica":
                    jugador.setAtq(jugador.getAtq() + 30);
                    jugador.setTcrit(6);                
                    break;
                case "Arco del bosque":
                    jugador.setAtq(jugador.getAtq() + 58);
                    jugador.setTcrit(12);                
                    break;
                case "Arco de tirador":
                    jugador.setAtq(jugador.getAtq() + 92);
                    jugador.setTcrit(20);                
                    break;
                case "Trazadora":
                    jugador.setAtq(jugador.getAtq() + 150);
                    jugador.setTcrit(32);                
                    break;
                case "Diente de dragon":
                    jugador.setAtq(jugador.getAtq() + 190);
                    jugador.setTcrit(60);                
                    break;
                    //ARMA DE MAGO
                case "Varita de principiante":
                    jugador.setAtq(jugador.getAtq() + 40);
                    break;
                case "Baston de guerra":
                    jugador.setAtq(jugador.getAtq() + 76);
                    break;
                case "Vara del caos":
                    jugador.setAtq(jugador.getAtq() + 112);
                    break;
                case "Baston infernal":
                    jugador.setAtq(jugador.getAtq() + 179);
                    break;
                case "Remanente helado":
                    jugador.setAtq(jugador.getAtq() + 230);
                    break;
                default:
                    System.out.println("No tiene arma");
                    break;
        }
            
        }
}
    

