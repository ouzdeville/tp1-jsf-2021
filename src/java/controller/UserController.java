/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    public List<Utilisateur> userList=null;
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
        
    }
    /**
     * PostConstruct Permet d'initaliser les variables pour éviter les n
     * ullPointerException
     */
    @PostConstruct
    public void init(){
        System.out.println("Appel de INIT ");
        userList=new ArrayList<>();
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
    
    /**
     * Pas besoin de donner l'objet user en argument car c'est déjà mise à jour par JSF
     * 1- verifier si tous les champs sont corrects 
     * 2-ajouter à la liste
     * @return 
     */
    public String creerCompte(){
        if(!this.user.getNom().equals("") &&
                !this.user.getPrenom().equals("")){
            
            userList.add(0, user.clone());
             user=new Utilisateur();
            System.out.println(userList);
            return "accueil?faces-redirect=true";
        }
        return "";
    }
    
    
    

    public List<Utilisateur> getUserList() {
        return userList;
    }

    public void setUserList(List<Utilisateur> userList) {
        this.userList = userList;
    }
    
    
}
