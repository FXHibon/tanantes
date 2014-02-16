package org.maurange.formation.licpro.rest;

/**
 * Created by François-Xavier on 13/02/14.
 */
public class Attente {

    private int sens;
    private String terminus;
    private boolean infotrafic;
    private String temps;
    private Arret arret;
    private NumLigne ligne;

    @Override
    public String toString() {
        return "Attente{" +
                "sens=" + sens +
                ", terminus='" + terminus + '\'' +
                ", infotrafic=" + infotrafic +
                ", temps='" + temps + '\'' +
                ", ligne=" + ligne +
                ", arret=" + arret.getCodeArret() +
                '}';
    }

    public int getSens() {
        return sens;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    public String getTerminus() {
        return terminus;
    }

    public void setTerminus(String terminus) {
        this.terminus = terminus;
    }

    public boolean isInfotrafic() {
        return infotrafic;
    }

    public void setInfotrafic(boolean infotrafic) {
        this.infotrafic = infotrafic;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public Arret getArret() {
        return arret;
    }

    public void setArret(Arret arret) {
        this.arret = arret;
    }

    public NumLigne getLigne() {
        return ligne;
    }

    public void setLigne(NumLigne ligne) {
        this.ligne = ligne;
    }
}
