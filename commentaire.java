/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entity;

import java.time.LocalDate;

/**
 *
 * @author Espace Info
 */
public class commentaire {
    private int id_commentaire;
    private LocalDate date; 
    private String email;
    private String contenu; 
    
    public commentaire()
{
    
}
 public commentaire(int id_commentaire, LocalDate date, String email ,String contenu) {
       this.id_commentaire=id_commentaire;
       this.date=date; 
       this.email=email;
       this.contenu=contenu; 
    }
 public commentaire(String email ,String contenu, LocalDate date) {
       this.email=email;
       this.contenu=contenu; 
       this.date=date;
    }
 public commentaire(int id_commentaire)
 {
     this.id_commentaire=id_commentaire;
 }

    public commentaire(String email, String contenu) {
        this.email = email;
        this.contenu = contenu;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    
    
        @Override
    public String toString() {
        return "commentaire{" + "id_commentaire=" + id_commentaire + ", date=" + date + ", email=" + email + ", contenu=" + contenu + '}';
    }
    
    
    
    
    
}
