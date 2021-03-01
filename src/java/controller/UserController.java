/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Utilisateur;

/**
 *
 * @author OUSMANE
 */
@ManagedBean  // oubien @Named import javax.enterprise.context.SessionScoped;
@SessionScoped
public class UserController {
    public Utilisateur user=new Utilisateur();
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    public String inscription(){
        System.out.println(this.user.getNom()+"-"+this.user.getPrenom());
        return  "";
    }
    
    public String auth(){
        if(this.user.getLogin().equals("tdsi") && this.user.getPassword().equals("tdsi")){
            return "accueil?faces-redirect=true";
        }
        else return "";
    }
    
    public String creerCompte(){
        return "connexion?faces-redirect=true";
    }
}
