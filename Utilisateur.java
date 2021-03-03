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
public class Utilisateur {
     private int id_utilisateur;
     private String nom_utilisateur;
       private String mot_de_passe;
       private String nom;
       private String prénom;
       private int age;
       private String email;
        private  double moyenne;
        private double salaire;
        private int role;
        private String metier;

    public Utilisateur() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public double getSalaire() {
        return salaire;
    }

    public int getRole() {
        return role;
    }

    public String getMetier() {
        return metier;
    }

    public Utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Utilisateur(int id_utilisateur, String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age, String email, double moyenne, int role) {
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.email = email;
        this.moyenne = moyenne;
        this.role = role;
    }

    public Utilisateur(String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age, String email) {
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.email = email;
    }

    public Utilisateur(String nom_utilisateur, String mot_de_passe) {
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_utilisateur=" + id_utilisateur + ", nom_utilisateur=" + nom_utilisateur + ", mot_de_passe=" + mot_de_passe + ", nom=" + nom + ", pr\u00e9nom=" + prénom + ", age=" + age + ", email=" + email + ", moyenne=" + moyenne + ", salaire=" + salaire + ", role=" + role + ", metier=" + metier + '}';
    }
    
}
