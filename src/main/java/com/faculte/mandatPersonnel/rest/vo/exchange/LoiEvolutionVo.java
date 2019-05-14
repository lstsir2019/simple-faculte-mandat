package com.faculte.mandatPersonnel.rest.vo.exchange;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class LoiEvolutionVo {

    private Long id;
    private String reference;
    private String dateDebut;
    private String dateFin;
    private String description;
    @JsonIgnore
    private List<LoiEvolutionTypePersonnelVo> loiEvolutionTypePersonnelsVo;

    public LoiEvolutionVo() {
    }

    public LoiEvolutionVo(Long id, String reference, String dateDebut, String dateFin, String description, List<LoiEvolutionTypePersonnelVo> loiEvolutionTypePersonnelsVo) {
        this.id = id;
        this.reference = reference;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.loiEvolutionTypePersonnelsVo = loiEvolutionTypePersonnelsVo;
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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public List<LoiEvolutionTypePersonnelVo> getLoiEvolutionTypePersonnelsVo() {
        return loiEvolutionTypePersonnelsVo;
    }

    @JsonSetter
    public void setLoiEvolutionTypePersonnelsVo(List<LoiEvolutionTypePersonnelVo> loiEvolutionTypePersonnelsVo) {
        this.loiEvolutionTypePersonnelsVo = loiEvolutionTypePersonnelsVo;
    }
}
