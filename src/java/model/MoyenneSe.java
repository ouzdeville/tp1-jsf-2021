/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name = "moyenne_se", catalog = "deliberation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoyenneSe.findAll", query = "SELECT m FROM MoyenneSe m"),
    @NamedQuery(name = "MoyenneSe.findByIdmse", query = "SELECT m FROM MoyenneSe m WHERE m.idmse = :idmse"),
    @NamedQuery(name = "MoyenneSe.findByValeur", query = "SELECT m FROM MoyenneSe m WHERE m.valeur = :valeur"),
    @NamedQuery(name = "MoyenneSe.findByAttribut42", query = "SELECT m FROM MoyenneSe m WHERE m.attribut42 = :attribut42")})
public class MoyenneSe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMSE")
    private Integer idmse;
    @Column(name = "VALEUR")
    private Integer valeur;
    @Column(name = "ATTRIBUT_42")
    private Integer attribut42;
    @JoinColumn(name = "IDETUDIANTP", referencedColumnName = "IDETUDIANTP")
    @ManyToOne(optional = false)
    private EtudiantPromo idetudiantp;
    @JoinColumn(name = "IDSEMESTRE", referencedColumnName = "IDSEMESTRE")
    @ManyToOne(optional = false)
    private Semestre idsemestre;

    public MoyenneSe() {
    }

    public MoyenneSe(Integer idmse) {
        this.idmse = idmse;
    }

    public Integer getIdmse() {
        return idmse;
    }

    public void setIdmse(Integer idmse) {
        this.idmse = idmse;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Integer getAttribut42() {
        return attribut42;
    }

    public void setAttribut42(Integer attribut42) {
        this.attribut42 = attribut42;
    }

    public EtudiantPromo getIdetudiantp() {
        return idetudiantp;
    }

    public void setIdetudiantp(EtudiantPromo idetudiantp) {
        this.idetudiantp = idetudiantp;
    }

    public Semestre getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(Semestre idsemestre) {
        this.idsemestre = idsemestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmse != null ? idmse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoyenneSe)) {
            return false;
        }
        MoyenneSe other = (MoyenneSe) object;
        if ((this.idmse == null && other.idmse != null) || (this.idmse != null && !this.idmse.equals(other.idmse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MoyenneSe[ idmse=" + idmse + " ]";
    }
    
}
