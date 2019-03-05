/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.vo;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import java.util.List;

/**
 *
 * @author abdou
 */
public class EntiteAdministratifVo {

    private Long id;
    private String entite;
    private SousProjetVo sousProjetVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public SousProjetVo getSousProjetVo() {
        return sousProjetVo;
    }

    public void setSousProjetVo(SousProjetVo sousProjetVo) {
        this.sousProjetVo = sousProjetVo;
    }

    public List<EntiteAdministratif> toItem(List<EntiteAdministratifVo> entiteAdministratifsVo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
