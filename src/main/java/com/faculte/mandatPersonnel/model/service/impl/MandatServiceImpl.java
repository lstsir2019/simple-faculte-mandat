/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.faculte.mandatPersonnel.model.service.impl;
//
//import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
//import com.faculte.mandatPersonnel.bean.Mandat;
//import com.faculte.mandatPersonnel.bean.Personnel;
//import com.faculte.mandatPersonnel.bean.Responsabilite;
//import com.faculte.mandatPersonnel.model.dao.MandatDao;
//import com.faculte.mandatPersonnel.model.service.MandatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author abdou
// */
//@Service
//public class MandatServiceImpl implements MandatService {
//
//    @Autowired
//    private MandatDao mandatDao;
//
//    @Override
//    public Mandat findByMandatDateDebutMandatPersonnelCin(String cin) {
//        return mandatDao.findByMandatDateDebutMandatPersonnelCin(cin);
//    }
//
//    @Override
//    public Mandat creerMandat(Personnel personnel, EntiteAdministratif entiteAdministratif,
//            Responsabilite responsabilite, Mandat mandat) {
//        if (personnel != null) {
//            Mandat m = findByMandatDateDebutMandatPersonnelCin(personnel.getCin());
//            if (m != null || entiteAdministratif == null || responsabilite == null) {
//                return null;
//            } else {
//                mandatDao.save(mandat);
//                System.out.println("mandat");
//                return mandat;
//                
//            }
//        }
//        return null;
//    }
//
//    public MandatDao getMandatDao() {
//        return mandatDao;
//    }
//
//    public void setMandatDao(MandatDao mandatDao) {
//        this.mandatDao = mandatDao;
//    }

    
//}
