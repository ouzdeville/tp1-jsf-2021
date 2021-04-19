/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author OUSMANE
 * Cette classe est un JavaBean donc, elle doit
 * etre publique et avoir
 * Un constructeur par défaut publique
 * des attributs et getter & setter pour chacun
 * en option, implements serializable
 */
public class Utilisateur {
    // private Type Variable
    
    private int id;
    private String nom="tdsi";
    private String prenom;
    private String login;
    private String password;
    private String image;
    private String email;

    /**
     * Le constructeur par défaut.
     */
    public Utilisateur() {
        
    }

    public Utilisateur(String nom, String prenom, String login, String password, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

   

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }  
    
    @Override
    public String toString() {
        return this.prenom+" "+this.nom;
    }

    
    @Override
    public  Utilisateur clone() {
        return new Utilisateur( nom,  prenom,  login,  password, email);
    }
}
