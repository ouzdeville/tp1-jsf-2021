/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author OUSMANE
 */
public class Utilisateur {
    // private Type Variable
    
    private int id;
    private String nom="tdsi";
    private String prenom;
    private String login;
    private String password;
    private String image;

    public Utilisateur() {
        
    }

    public Utilisateur(String tour, String prenom, String login, String password) {
        this.nom = tour;
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
    
    
    
}
