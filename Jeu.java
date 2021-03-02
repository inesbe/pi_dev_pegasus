/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author asus
 */
public class Jeu {
    int id,cours;
    String titre,description,topscore,diff,source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopscore() {
        return topscore;
    }

    public void setTopscore(String topscore) {
        this.topscore = topscore;
    }

    public int getCours() {
        return cours;
    }

    public void setCours(int cours) {
        this.cours = cours;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }
    
 public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    
    public Jeu(){
        
    }
    
    public Jeu(int id, String titre, String description, int cours, String diff,String source) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.cours = cours;
        this.diff = diff;
        this.source=source;
    }
    
    
        public Jeu(int id, String titre, String description, int cours, String diff,String source,String topscore) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.cours = cours;
        this.diff = diff;
        this.topscore=topscore;
        this.source=source;
    }
        
}
