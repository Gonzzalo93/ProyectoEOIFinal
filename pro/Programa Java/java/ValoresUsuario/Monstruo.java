/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValoresUsuario;

/**
 *
 * @author migue
 */
public class Monstruo {
    String nombre;
    int hp;
    int def;
    int atq;
    int Tcrit;
    int Dcrit;
    int eva;
    int exp;
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
        return "Enemigo: " + nombre + "\nhp: " + hp + 
                "\n atq: " + atq + "\n def: " + def;
    }
    
    
    
}
