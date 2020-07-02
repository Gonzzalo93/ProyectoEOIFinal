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
    int hp;
    int def;
    int atq;
    int eva;
    int Tcrit;
    int Dcrit;
    int exp;
    int nivel;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    
 //TO STRING
    @Override
    public String toString() {
        return this.nombre + "lvl: " + this.nivel+ "\nHP: " + this.hp + "\ndaño: " + atq +
                "\ndef: " + def;
    }
    // METODOS
    //CALCULAR DAÑOS
    public int calcAtacar(Jugador jugador, Monstruo enemigo){
        Random number = new Random();
        Random probCrit = new Random();
        int crit = probCrit.nextInt(100) + 1;
        int N = jugador.getNivel();
        int A = jugador.getAtq();
        int D = enemigo.getDef();
        int V = number.nextInt(15)+85;
        int Tc = jugador.getTcrit();
        int Dc = jugador.getDcrit();
        double calc =  0.01 * V * ((( 3 * A ) *N) / (6 * D) + 2) ;
        int res = (int) calc;
        
        if(crit <= Tc){
            res = res * Dcrit;
            return res;
        }else {
            return res;
        }
    }
     public int calcSkill(Jugador jugador, Monstruo enemigo) {
        int E = 1;
        Random random = new Random();
        int V = random.nextInt(15) + 85;
        int N = 2;
        int A = 20;
        int P = 1;//Entre 1 y 5 según sistema de estrellas
        int D = 10;
        double skill = 0.02 * E * V * ((((5 * N) * A * P)/(10 * D))+3);
        int dmg = (int) skill;
        System.out.println(dmg);
        return dmg;
    }
     //SUBIDAS DE NIVEL
   public int levelUp(int exp){
       
               if(exp >= 30 && exp < 100){
                   return 2;
               }else if(exp >= 100 && exp < 240){
                   return 3;
               }else if(exp >= 240  && exp < 500){
                   return 4;
               }else if(exp >= 500  && exp < 940){
                   return 5;
               }else if(exp >= 940  && exp < 1830){
                   return 6;
               }else if(exp >= 1830  && exp < 3200){
                   return 7;
               }else if(exp >= 3200  && exp < 5780){
                   return 8;
               }else if(exp >= 5780  && exp < 11080){
                   return 9;
               }else if(exp >= 11080  && exp < 24900){
                   return 10;
               }else  if(exp >= 24900){
                   return 11;
               }else {
                   return 1;
               }  
             
       }
        public void equipo(Jugador jugador, String arma){
        
            switch(arma){
                case "Nada":
                    jugador.setAtq(jugador.getAtq() + 0);
                    jugador.setTcrit(0);                
                    break;
                case "Espada de madera":
                    jugador.setAtq(jugador.getAtq() + 4);
                    jugador.setTcrit(4);                
                    break;
                case "Espada de plata":
                    jugador.setAtq(jugador.getAtq() + 8);
                    jugador.setTcrit(8);                
                    break;
                case "Espada de hierro rojo":
                    jugador.setAtq(jugador.getAtq() + 14);
                    jugador.setTcrit(15);                
                    break;
                case "Espada de los antiguos":
                    jugador.setAtq(jugador.getAtq() + 21);
                    jugador.setTcrit(25);                
                    break;
                case "Sangre nocturna":
                    jugador.setAtq(jugador.getAtq() + 32);
                    jugador.setTcrit(40);                
                    break;
                case "Arco de practica":
                    jugador.setAtq(jugador.getAtq() + 4);
                    jugador.setTcrit(6);                
                    break;
                case "Arco del bosque":
                    jugador.setAtq(jugador.getAtq() + 9);
                    jugador.setTcrit(12);                
                    break;
                case "Arco de tirador":
                    jugador.setAtq(jugador.getAtq() + 16);
                    jugador.setTcrit(20);                
                    break;
                case "Trazadora":
                    jugador.setAtq(jugador.getAtq() + 25);
                    jugador.setTcrit(32);                
                    break;
                case "Diente de dragon":
                    jugador.setAtq(jugador.getAtq() + 36);
                    jugador.setTcrit(60);                
                    break;
                case "Varita de principiante":
                    jugador.setAtq(jugador.getAtq() + 7);
                    break;
                case "Baston de guerra":
                    jugador.setAtq(jugador.getAtq() + 13);
                    break;
                case "Vara del caos":
                    jugador.setAtq(jugador.getAtq() + 22);
                    break;
                case "Baston infernal":
                    jugador.setAtq(jugador.getAtq() + 30);
                    break;
                case "Remanente helado":
                    jugador.setAtq(jugador.getAtq() + 49);
                    break;
                default:
                    System.out.println("No tiene arma");
                    break;
        }
            
        }
}
    

