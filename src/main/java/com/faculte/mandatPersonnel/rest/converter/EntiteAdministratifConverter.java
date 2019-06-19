/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import com.faculte.mandatPersonnel.common.util.DateUtil;
import com.faculte.mandatPersonnel.common.util.NumberUtil;
import com.faculte.mandatPersonnel.rest.vo.EntiteAdministratifVo;
import com.faculte.mandatPersonnel.rest.vo.PersonnelVo;
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
            // item.setChef(new PersonnelConverter().toItem(vo.getChefVo()));
            Personnel p = new Personnel();
            if (vo.getChefVo() != null) {
                p.setId(vo.getId());
                p.setCin(vo.getChefVo().getCin());
                p.setReferenceEchelle(vo.getChefVo().getReferenceEchelle());
                p.setReferenceEchelon(vo.getChefVo().getReferenceEchelon());
                p.setDateAccesFonctionPublique(DateUtil.parse(vo.getChefVo().getDateAccesFonctionPublique()));
                p.setDateActivation(DateUtil.parse(vo.getChefVo().getDateActivation()));
                p.setDateDebutTypePersonnel(DateUtil.parse(vo.getChefVo().getDateDebutTypePersonnel()));
                p.setDateExerciceEchelle(DateUtil.parse(vo.getChefVo().getDateExerciceEchelle()));
                p.setDateNaissance(DateUtil.parse(vo.getChefVo().getDateNaissance()));
                p.setEtatSocial(vo.getChefVo().getEtatSocial());
                p.setGrade(vo.getChefVo().getGrade());
                p.setLieuAffectation(vo.getChefVo().getLieuAffectation());
                p.setLieuNaissance(vo.getChefVo().getLieuNaissance());
                p.setNom(vo.getChefVo().getNom());
                p.setNombreEnfants(NumberUtil.toInt(vo.getChefVo().getNombreEnfants()));
                p.setNumeroLocation(vo.getChefVo().getNumeroLocation());
                p.setPrenom(vo.getChefVo().getPrenom());
                item.setChef(p);
            }
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
            //vo.setChefVo(new PersonnelConverter().toVo(item.getChef()));
            PersonnelVo p = new PersonnelVo();
            if (item.getChef() != null) {
                p.setId(item.getChef().getId());
                p.setCin(item.getChef().getCin());
                p.setReferenceEchelle(item.getChef().getReferenceEchelle());
                p.setReferenceEchelon(item.getChef().getReferenceEchelon());
                p.setDateAccesFonctionPublique(DateUtil.formateDate(item.getChef().getDateAccesFonctionPublique()));
                p.setDateActivation(DateUtil.formateDate(item.getChef().getDateActivation()));
                p.setDateDebutTypePersonnel(DateUtil.formateDate(item.getChef().getDateDebutTypePersonnel()));
                p.setDateExerciceEchelle(DateUtil.formateDate(item.getChef().getDateExerciceEchelle()));
                p.setDateNaissance(DateUtil.formateDate(item.getChef().getDateNaissance()));
                p.setEtatSocial(item.getChef().getEtatSocial());
                p.setGrade(item.getChef().getGrade());
                p.setLieuAffectation(item.getChef().getLieuAffectation());
                p.setLieuNaissance(item.getChef().getLieuNaissance());
                p.setNom(item.getChef().getNom());
                p.setNombreEnfants(NumberUtil.toString(item.getChef().getNombreEnfants()));
                p.setNumeroLocation(item.getChef().getNumeroLocation());
                p.setPrenom(item.getChef().getPrenom());
                vo.setChefVo(p);
            }
            SousProjetVo sp = new SousProjetVo();
            if (item.getSousProjet() != null) {
                sp.setId(item.getSousProjet().getId());
                sp.setReferenceSousProjet(item.getSousProjet().getReferenceSousProjet());
                vo.setSousProjetVo(sp);

            }
            TypeEntiteAdministratifVo tea = new TypeEntiteAdministratifVo();
            if (item.getTypeEntiteAdministratif() != null) {
                System.out.println("converter : not null");
                System.out.println("convert of typeEntite" + item.getTypeEntiteAdministratif());
                tea.setId(item.getTypeEntiteAdministratif().getId());
                tea.setLibelle(item.getTypeEntiteAdministratif().getLibelle());
                vo.setTypeEntiteAdministratifVo(tea);
            }
            return vo;
        }
    }

}
