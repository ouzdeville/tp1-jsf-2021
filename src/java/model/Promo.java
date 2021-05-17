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
@Table(name = "promo", catalog = "deliberation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promo.findAll", query = "SELECT p FROM Promo p"),
    @NamedQuery(name = "Promo.findByIdpromo", query = "SELECT p FROM Promo p WHERE p.idpromo = :idpromo"),
    @NamedQuery(name = "Promo.findByAnneeScolaire", query = "SELECT p FROM Promo p WHERE p.anneeScolaire = :anneeScolaire")})
public class Promo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROMO")
    private Integer idpromo;
    @Size(max = 10)
    @Column(name = "ANNEE_SCOLAIRE")
    private String anneeScolaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpromo")
    private List<EtudiantPromo> etudiantPromoList;
    @JoinColumn(name = "IDNIVEAU", referencedColumnName = "IDNIVEAU")
    @ManyToOne(optional = false)
    private Niveau idniveau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpromo")
    private List<Ue> ueList;

    public Promo() {
    }

    public Promo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public Integer getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    @XmlTransient
    public List<EtudiantPromo> getEtudiantPromoList() {
        return etudiantPromoList;
    }

    public void setEtudiantPromoList(List<EtudiantPromo> etudiantPromoList) {
        this.etudiantPromoList = etudiantPromoList;
    }

    public Niveau getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(Niveau idniveau) {
        this.idniveau = idniveau;
    }

    @XmlTransient
    public List<Ue> getUeList() {
        return ueList;
    }

    public void setUeList(List<Ue> ueList) {
        this.ueList = ueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromo != null ? idpromo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promo)) {
            return false;
        }
        Promo other = (Promo) object;
        if ((this.idpromo == null && other.idpromo != null) || (this.idpromo != null && !this.idpromo.equals(other.idpromo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Promo[ idpromo=" + idpromo + " ]";
    }
    
}
