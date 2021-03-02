/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entity;

/**
 *
 * @author shado
 */
public class Cours {
    
    private int id_cours;
    private String nom_cours;

    public Cours(int id_cours) {
        this.id_cours = id_cours;
    }
    private String domaine;
    private String lien;

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public void setNom_cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public int getId_cours() {
        return id_cours;
    }

    public String getNom_cours() {
        return nom_cours;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getLien() {
        return lien;
    }
    public Cours()
    {
        
    }
    public Cours(int id_cours, String nom_cours, String domaine, String lien) {
        this.id_cours = id_cours;
        this.nom_cours = nom_cours;
        this.domaine = domaine;
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Cours{" + "id_cours=" + id_cours + ", nom_cours=" + nom_cours + ", domaine=" + domaine + ", lien=" + lien + '}';
    }
    
}
