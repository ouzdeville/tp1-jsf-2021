/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author OUSMANE
 */
@Entity
@Table(name = "niveau", catalog = "deliberation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n"),
    @NamedQuery(name = "Niveau.findByIdniveau", query = "SELECT n FROM Niveau n WHERE n.idniveau = :idniveau"),
    @NamedQuery(name = "Niveau.findByNom", query = "SELECT n FROM Niveau n WHERE n.nom = :nom")})
public class Niveau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDNIVEAU")
    private Integer idniveau;
    @Size(max = 10)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "IDFILIERE", referencedColumnName = "IDFILIERE")
    @ManyToOne(optional = false)
    private Filiere idfiliere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idniveau")
    private List<Promo> promoList;

    public Niveau() {
    }

    public Niveau(Integer idniveau) {
        this.idniveau = idniveau;
    }

    public Integer getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(Integer idniveau) {
        this.idniveau = idniveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Filiere getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(Filiere idfiliere) {
        this.idfiliere = idfiliere;
    }

    @XmlTransient
    public List<Promo> getPromoList() {
        return promoList;
    }

    public void setPromoList(List<Promo> promoList) {
        this.promoList = promoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idniveau != null ? idniveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.idniveau == null && other.idniveau != null) || (this.idniveau != null && !this.idniveau.equals(other.idniveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Niveau[ idniveau=" + idniveau + " ]";
    }
    
}
