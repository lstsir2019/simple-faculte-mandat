/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.vo.exchange;



import java.util.List;

/**
 * @author Xrio
 */
public class EchelleVo {

    private Long id;
    private String referenceEchelle;
    private String libelle;
    private String ordre;
    private String description;
    private List<EchelonVo> echelons;
    private String referenceTypePersonnel;

    public EchelleVo() {
    }

    public EchelleVo(Long id, String referenceEchelle, String libelle, String ordre, String description, List<EchelonVo> echelons, String referenceTypePersonnel) {
        this.id = id;
        this.referenceEchelle = referenceEchelle;
        this.libelle = libelle;
        this.ordre = ordre;
        this.description = description;
        this.echelons = echelons;
        this.referenceTypePersonnel = referenceTypePersonnel;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceEchelle() {
        return referenceEchelle;
    }

    public void setReferenceEchelle(String referenceEchelle) {
        this.referenceEchelle = referenceEchelle;
    }

   

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EchelonVo> getEchelons() {
        return echelons;
    }

    public void setEchelons(List<EchelonVo> echelons) {
        this.echelons = echelons;
    }

    public String getReferenceTypePersonnel() {
        return referenceTypePersonnel;
    }

    public void setReferenceTypePersonnel(String referenceTypePersonnel) {
        this.referenceTypePersonnel = referenceTypePersonnel;
    }
}
