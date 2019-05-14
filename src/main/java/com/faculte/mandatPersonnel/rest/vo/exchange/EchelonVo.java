/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.vo.exchange;

/**
 *
 * @author Xrio
 */
public class EchelonVo {

    private Long id;
    private String referenceEchelon;
    private String ordre;
    private String libelle;

    public EchelonVo(Long id, String referenceEchelon, String ordre, String libelle) {
        this.id = id;
        this.referenceEchelon = referenceEchelon;
        this.ordre = ordre;
        this.libelle = libelle;
    }

    
    public EchelonVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceEchelon() {
        return referenceEchelon;
    }

    public void setReferenceEchelon(String referenceEchelon) {
        this.referenceEchelon = referenceEchelon;
    }

  
    

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
