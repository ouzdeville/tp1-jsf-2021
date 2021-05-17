/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OUSMANE
 */
@Entity
@Table(name = "moyenne_ue", catalog = "deliberation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoyenneUe.findAll", query = "SELECT m FROM MoyenneUe m"),
    @NamedQuery(name = "MoyenneUe.findByIdmue", query = "SELECT m FROM MoyenneUe m WHERE m.idmue = :idmue"),
    @NamedQuery(name = "MoyenneUe.findByValeur", query = "SELECT m FROM MoyenneUe m WHERE m.valeur = :valeur"),
    @NamedQuery(name = "MoyenneUe.findByCredit", query = "SELECT m FROM MoyenneUe m WHERE m.credit = :credit")})
public class MoyenneUe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMUE")
    private Integer idmue;
    @Column(name = "VALEUR")
    private BigInteger valeur;
    @Column(name = "CREDIT")
    private Integer credit;
    @JoinColumn(name = "IDETUDIANTP", referencedColumnName = "IDETUDIANTP")
    @ManyToOne(optional = false)
    private EtudiantPromo idetudiantp;
    @JoinColumn(name = "IDUE", referencedColumnName = "IDUE")
    @ManyToOne(optional = false)
    private Ue idue;

    public MoyenneUe() {
    }

    public MoyenneUe(Integer idmue) {
        this.idmue = idmue;
    }

    public Integer getIdmue() {
        return idmue;
    }

    public void setIdmue(Integer idmue) {
        this.idmue = idmue;
    }

    public BigInteger getValeur() {
        return valeur;
    }

    public void setValeur(BigInteger valeur) {
        this.valeur = valeur;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public EtudiantPromo getIdetudiantp() {
        return idetudiantp;
    }

    public void setIdetudiantp(EtudiantPromo idetudiantp) {
        this.idetudiantp = idetudiantp;
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
        hash += (idmue != null ? idmue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoyenneUe)) {
            return false;
        }
        MoyenneUe other = (MoyenneUe) object;
        if ((this.idmue == null && other.idmue != null) || (this.idmue != null && !this.idmue.equals(other.idmue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MoyenneUe[ idmue=" + idmue + " ]";
    }
    
}
