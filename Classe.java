/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entity;

/**
 *
 * @author Espace Info
 */
public class Classe {
    private int id_class;
    private int id_utilisateur;
    private String nom_class;
    private int age;
public Classe()
{
    
}

    public Classe(int id_utilisateur, String nom_class, int age) {
        this.id_utilisateur = id_utilisateur;
        this.nom_class = nom_class;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Class{" + "id_class=" + id_class + ", id_utilisateur=" + id_utilisateur + ", nom_class=" + nom_class + ", age=" + age + '}';
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setNom_class(String nom_class) {
        this.nom_class = nom_class;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_class() {
        return id_class;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom_class() {
        return nom_class;
    }

    public int getAge() {
        return age;
    }

    public Classe(int id_class, int id_utilisateur, String nom_class, int age) {
        this.id_class = id_class;
        this.id_utilisateur = id_utilisateur;
        this.nom_class = nom_class;
        this.age = age;
    }
    
}
