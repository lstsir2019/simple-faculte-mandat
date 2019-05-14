package com.faculte.mandatPersonnel.rest.vo.exchange;

import java.util.List;

public class LoiEvolutionTypePersonnelVo {

    private Long id;
    private String reference;
    private String referenceTypePersonnel;
    private EchelonVo echelonDepart;
    private EchelonVo echelonFin;
    private String nombreAnnees;
    private LoiEvolutionVo loiEvolution;

    public LoiEvolutionTypePersonnelVo() {
    }

    public LoiEvolutionTypePersonnelVo(Long id, String reference, String referenceTypePersonnel, EchelonVo echelonDepart, EchelonVo echelonFin, String nombreAnnees, LoiEvolutionVo loiEvolution) {
        this.id = id;
        this.reference = reference;
        this.referenceTypePersonnel = referenceTypePersonnel;
        this.echelonDepart = echelonDepart;
        this.echelonFin = echelonFin;
        this.nombreAnnees = nombreAnnees;
        this.loiEvolution = loiEvolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceTypePersonnel() {
        return referenceTypePersonnel;
    }

    public void setReferenceTypePersonnel(String referenceTypePersonnel) {
        this.referenceTypePersonnel = referenceTypePersonnel;
    }

    public EchelonVo getEchelonDepart() {
        return echelonDepart;
    }

    public void setEchelonDepart(EchelonVo echelonDepart) {
        this.echelonDepart = echelonDepart;
    }

    public EchelonVo getEchelonFin() {
        return echelonFin;
    }

    public void setEchelonFin(EchelonVo echelonFin) {
        this.echelonFin = echelonFin;
    }

    public String getNombreAnnees() {
        return nombreAnnees;
    }

    public void setNombreAnnees(String nombreAnnees) {
        this.nombreAnnees = nombreAnnees;
    }

    public LoiEvolutionVo getLoiEvolution() {
        return loiEvolution;
    }

    public void setLoiEvolution(LoiEvolutionVo loiEvolution) {
        this.loiEvolution = loiEvolution;
    }
}
