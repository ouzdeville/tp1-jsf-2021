/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author OUSMANE
 */
@Entity
@Table(name = "ec", catalog = "deliberation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ec.findAll", query = "SELECT e FROM Ec e"),
    @NamedQuery(name = "Ec.findByIdec", query = "SELECT e FROM Ec e WHERE e.idec = :idec"),
    @NamedQuery(name = "Ec.findByValeur", query = "SELECT e FROM Ec e WHERE e.valeur = :valeur"),
    @NamedQuery(name = "Ec.findByCoefficient", query = "SELECT e FROM Ec e WHERE e.coefficient = :coefficient")})
public class Ec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEC")
    private Integer idec;
    @Column(name = "VALEUR")
    private BigInteger valeur;
    @Column(name = "COEFFICIENT")
    private Integer coefficient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idec")
    private List<MoyenneEc> moyenneEcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idec")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "IDUE", referencedColumnName = "IDUE")
    @ManyToOne(optional = false)
    private Ue idue;

    public Ec() {
    }

    public Ec(Integer idec) {
        this.idec = idec;
    }

    public Integer getIdec() {
        return idec;
    }

    public void setIdec(Integer idec) {
        this.idec = idec;
    }

    public BigInteger getValeur() {
        return valeur;
    }

    public void setValeur(BigInteger valeur) {
        this.valeur = valeur;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    @XmlTransient
    public List<MoyenneEc> getMoyenneEcList() {
        return moyenneEcList;
    }

    public void setMoyenneEcList(List<MoyenneEc> moyenneEcList) {
        this.moyenneEcList = moyenneEcList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Ue getIdue() {
        return idue;
    }

    public void setIdue(Ue idue) {
        this.idue = idue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idec != null ? idec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ec)) {
            return false;
        }
        Ec other = (Ec) object;
        if ((this.idec == null && other.idec != null) || (this.idec != null && !this.idec.equals(other.idec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ec[ idec=" + idec + " ]";
    }
    
}
