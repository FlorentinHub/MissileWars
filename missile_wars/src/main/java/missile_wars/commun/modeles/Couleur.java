package missile_wars.commun.modeles;

import missile_wars.commun.valeurs.Usager;

public class Couleur {
    private int rouge;
    private int vert;
    private int bleu;

    public Couleur() {
    	
    }
    public Couleur(int rouge, int vert, int bleu) {
        this.rouge = rouge;
        this.vert = vert;
        this.bleu = bleu;
    }
//    public int[] getCouleur() {
//        return (getRouge(), getBleu(), getVert());
//    }

    public int getRouge() {
        return rouge;
    }

    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }

    public int getBleu() {
        return bleu;
    }

    public void setBleu(int bleu) {
        this.bleu = bleu;
    }
//
//    public String toJson() {
//        JSONObject json = new JSONObject();
//        json.put("rouge", rouge);
//        json.put("vert", vert);
//        json.put("bleu", bleu);
//        return json.toString();
//    }
}