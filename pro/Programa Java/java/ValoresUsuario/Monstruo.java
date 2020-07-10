/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValoresUsuario;

import java.util.Random;

/**
 *
 * @author migue
 */
public class Monstruo {
    String nombre;
    String elemento;
    int hp;
    int maxHp;
    int nivel;
    int def;
    int atq;
    int Tcrit;
    int Dcrit;
    int eva;
    int exp;
    int dinero;
    public Monstruo(){
        
    }
    public Monstruo(String nombre,int hp,int atq, int exp ){
        this.nombre = nombre;
        this.hp = hp;
        this.atq = atq;
        this.exp = exp;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
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

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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

    public int getEva() {
        return eva;
    }

    public void setEva(int eva) {
        this.eva = eva;
    }

    
    @Override
    public String toString() {
        return "Enemigo: " + nombre + " lvl: " + nivel +
                "\nElemento: "+ elemento + "\nhp: " + hp + 
                "\n atq: " + atq + "\n def: " + def;
    }
    
    //CALCULAR DAÑOS
    public int calcAtacar(Jugador jugador, Monstruo enemigo){
        Random number = new Random();
        Random probCrit = new Random();
        Random probEva = new Random ();
        int rEva = probEva.nextInt(100) + 1;
        int rCrit = probCrit.nextInt(100) + 1;
        int N = enemigo.getNivel();
        int A = enemigo.getAtq();
        int D = jugador.getDef();
        int V = number.nextInt(15)+85;
        int eva = jugador.getEva();
        int tc = enemigo.getTcrit();
        int dc = enemigo.getDcrit();
        double calc =  0.01 * V * ((( 8 * A ) *N) /  ( 3 * D)) ;
        int res = (int) calc;
        
        if(rCrit <= tc){
            res = res * (dc / 100 );
            
        }
        if (rEva <= eva){
            res = 0;
        }
        return res;
    }
    
}
