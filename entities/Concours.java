/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * 
 */
public class Concours {
    
    private int id_concours;
    private String nom_concours;
    private  int id_class;
     private LocalDate date_debut;
    private LocalDate date_fin;


    private  int prix;

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public Concours() {
    }

    public Concours(int id_concours) {
        this.id_concours = id_concours;
    }

    public Concours(String nom_concours, int id_class, LocalDate date_debut, LocalDate date_fin, int prix) {
        this.nom_concours = nom_concours;
        this.id_class = id_class;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
    }
    
    

    public Concours(int id_concours, String nom_concours, int id_class, int prix, LocalDate date_debut, LocalDate date_fin) {
        this.id_concours = id_concours;
        this.nom_concours = nom_concours;
        this.id_class = id_class;
        this.prix = prix;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
   

    public Concours(int id_concours, String nom_concours, int id_class, int prix) {
        this.id_concours = id_concours;
        this.nom_concours = nom_concours;
        this.id_class = id_class;
        this.prix = prix;
    }

    public int getId_concours() {
        return id_concours;
    }

    public String getNom_concours() {
        return nom_concours;
    }

    public int getId_class() {
        return id_class;
    }

    public int getPrix() {
        return prix;
    }

    public void setId_concours(int id_concours) {
        this.id_concours = id_concours;
    }

    public void setNom_concours(String nom_concours) {
        this.nom_concours = nom_concours;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Concours{" + "id_concours=" + id_concours + ", nom_concours=" + nom_concours + ", id_class=" + id_class + ", prix=" + prix + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
