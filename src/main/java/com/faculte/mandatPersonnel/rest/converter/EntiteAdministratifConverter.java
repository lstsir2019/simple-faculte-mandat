/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import com.faculte.mandatPersonnel.rest.vo.EntiteAdministratifVo;
import com.faculte.mandatPersonnel.rest.vo.SousProjetVo;
import com.faculte.mandatPersonnel.rest.vo.TypeEntiteAdministratifVo;

/**
 *
 * @author abdou
 */
public class EntiteAdministratifConverter extends AbstractConverter<EntiteAdministratif, EntiteAdministratifVo> {

    @Override
    public EntiteAdministratif toItem(EntiteAdministratifVo vo) {
        if (vo == null) {
            return null;
        } else {
            EntiteAdministratif item = new EntiteAdministratif();
            item.setId(vo.getId());
            item.setReferenceEntiteAdministratif(vo.getReferenceEntiteAdministratif());
            SousProjet sp = new SousProjet();
            if (vo.getSousProjetVo() != null) {
                sp.setId(vo.getSousProjetVo().getId());
                sp.setReferenceSousProjet(vo.getSousProjetVo().getReferenceSousProjet());
                item.setSousProjet(sp);

            }
            TypeEntiteAdministratif tea = new TypeEntiteAdministratif();
            if (vo.getTypeEntiteAdministratifVo() != null) {
                System.out.println("converter : not null");
                tea.setId(vo.getTypeEntiteAdministratifVo().getId());
                tea.setLibelle(vo.getTypeEntiteAdministratifVo().getLibelle());
                System.out.println("converter : " + vo.getTypeEntiteAdministratifVo().getLibelle());
                item.setTypeEntiteAdministratif(tea);
            }
            return item;
        }
    }

    @Override
    public EntiteAdministratifVo toVo(EntiteAdministratif item) {
        if (item == null) {
            return null;
        } else {
            EntiteAdministratifVo vo = new EntiteAdministratifVo();
            vo.setId(item.getId());
            vo.setReferenceEntiteAdministratif(item.getReferenceEntiteAdministratif());
            SousProjetVo sp = new SousProjetVo();
            if (item.getSousProjet() != null) {
                sp.setId(item.getSousProjet().getId());
                sp.setReferenceSousProjet(item.getSousProjet().getReferenceSousProjet());
                vo.setSousProjetVo(sp);

            }
             TypeEntiteAdministratifVo tea = new TypeEntiteAdministratifVo();
            if (item.getTypeEntiteAdministratif() != null) {
                System.out.println("converter : not null");
                System.out.println("convert of typeEntite" +item.getTypeEntiteAdministratif());
                tea.setId(item.getTypeEntiteAdministratif().getId());
                tea.setLibelle(item.getTypeEntiteAdministratif().getLibelle());
                vo.setTypeEntiteAdministratifVo(tea);
            }
            return vo;
        }
    }

}
