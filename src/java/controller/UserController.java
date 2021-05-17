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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.User;

/**
 *
 * @author OUSMANE
 */
@ManagedBean  // oubien @Named import javax.enterprise.context.SessionScoped;
@SessionScoped
public class UserController {
    public User user=new User();
    public List<User> userList=null;
    private EntityManager em;
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
        EntityManagerFactory emf=Persistence.
                createEntityManagerFactory("hellom2021PU");
        em=emf.createEntityManager();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String inscription(){
        System.out.println(this.user.getNom()+"-"+this.user.getPrenom());
        return  "";
    }
    
    public String auth(){
        
        return "";
    }
    
    /**
     * Pas besoin de donner l'objet user en argument car c'est déjà mise à jour par JSF
     * 1- verifier si tous les champs sont corrects 
     * 2-ajouter à la liste
     * @return 
     */
    public String creerCompte(){
        
        return "";
    }
    
    
    

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    
}
