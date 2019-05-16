/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author abdou
 */
@Entity
public class Responsabilite implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceResponsabilite ;

    public Responsabilite() {
    }

    public Responsabilite(String referenceResponsabilite) {
        this.referenceResponsabilite = referenceResponsabilite;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceResponsabilite() {
        return referenceResponsabilite;
    }

    public void setReferenceResponsabilite(String referenceResponsabilite) {
        this.referenceResponsabilite = referenceResponsabilite;
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
        if (!(object instanceof Responsabilite)) {
            return false;
        }
        Responsabilite other = (Responsabilite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.faculte.MandatPersonnel.bean.Responsabilite[ id=" + id + " ]";
    }
    
    
}
