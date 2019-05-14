package com.faculte.mandatPersonnel.rest.vo.exchange;

public class EvolutionPersonnelVo {

    private Long id;
    private String reference;
    private LoiEvolutionTypePersonnelVo loiEvolutionTypePersonnel;
    private String referencePersonnel;
    private String referenceTypePersonnel;
    private EchelonVo echelonDepart;
    private EchelonVo echelonFin;
    private String dateEvolution;

    public EvolutionPersonnelVo() { }

    public EvolutionPersonnelVo(Long id, String reference, LoiEvolutionTypePersonnelVo loiEvolutionTypePersonnel, String referencePersonnel, String referenceTypePersonnel, EchelonVo echelonDepart, EchelonVo echelonFin, String dateEvolution) {
        this.id = id;
        this.reference = reference;
        this.loiEvolutionTypePersonnel = loiEvolutionTypePersonnel;
        this.referencePersonnel = referencePersonnel;
        this.referenceTypePersonnel = referenceTypePersonnel;
        this.echelonDepart = echelonDepart;
        this.echelonFin = echelonFin;
        this.dateEvolution = dateEvolution;
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

    public LoiEvolutionTypePersonnelVo getLoiEvolutionTypePersonnel() {
        return loiEvolutionTypePersonnel;
    }

    public void setLoiEvolutionTypePersonnel(LoiEvolutionTypePersonnelVo loiEvolutionTypePersonnel) {
        this.loiEvolutionTypePersonnel = loiEvolutionTypePersonnel;
    }

    public String getReferencePersonnel() {
        return referencePersonnel;
    }

    public void setReferencePersonnel(String referencePersonnel) {
        this.referencePersonnel = referencePersonnel;
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

    public String getDateEvolution() {
        return dateEvolution;
    }

    public void setDateEvolution(String dateEvolution) {
        this.dateEvolution = dateEvolution;
    }
}
