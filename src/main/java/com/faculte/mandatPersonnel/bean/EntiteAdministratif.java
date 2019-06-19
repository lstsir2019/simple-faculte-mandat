/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author abdou
 */
@Entity
public class EntiteAdministratif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceEntiteAdministratif;

    @ManyToOne
    private TypeEntiteAdministratif typeEntiteAdministratif;

    @ManyToOne
    private SousProjet sousProjet;

   
    
    @OneToOne(fetch = FetchType.LAZY)
    private Personnel chef ;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceEntiteAdministratif() {
        return referenceEntiteAdministratif;
    }

    public void setReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
        this.referenceEntiteAdministratif = referenceEntiteAdministratif;
    }

    public SousProjet getSousProjet() {
        return sousProjet;
    }

    public void setSousProjet(SousProjet sousProjet) {
        this.sousProjet = sousProjet;
    }

    public TypeEntiteAdministratif getTypeEntiteAdministratif() {
        return typeEntiteAdministratif;
    }

    public void setTypeEntiteAdministratif(TypeEntiteAdministratif typeEntiteAdministratif) {
        this.typeEntiteAdministratif = typeEntiteAdministratif;
    }

    public Personnel getChef() {
        return chef;
    }

    public void setChef(Personnel chef) {
        this.chef = chef;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntiteAdministratif)) {
            return false;
        }
        EntiteAdministratif other = (EntiteAdministratif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.faculte.MandatPersonnel.bean.EntiteAdministratif[ id=" + id + " ]";
    }
}
