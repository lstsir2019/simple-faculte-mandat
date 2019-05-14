/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.dao.SousProjetDao;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.SearchUtil;

/**
 *
 * @author abdou
 */
@Service
public class SousProjetServiceImpl implements SousProjetService {

    @Autowired
    private SousProjetDao sousProjetDao;
    @Autowired
    private SousProjetService sousProjetService;

    @Override
    public List<SousProjet> findAll() {
        return sousProjetDao.findAll();
    }

    @Override
    public SousProjet findByReferenceSousProjet(String referenceSousProjet) {
        return sousProjetDao.findByReferenceSousProjet(referenceSousProjet);
    }

    @Override
    public List<SousProjet> findByProjetLibelleP(String libelleP) {
        return sousProjetDao.findByProjetLibelleP(libelleP);
    }

    @Override
    public int creerSousProjet(SousProjet sousProjet) {
        sousProjetDao.save(sousProjet);
        return 1;
    }

    public SousProjetDao getSousProjetDao() {
        return sousProjetDao;
    }

    public void setSousProjetDao(SousProjetDao sousProjetDao) {
        this.sousProjetDao = sousProjetDao;
    }

    @Override
    public int deleteByReferenceSousProjet(String referenceSousProjet) {
        SousProjet s = sousProjetService.findByReferenceSousProjet(referenceSousProjet);
        if (s == null) {
            return -1;
        } else {
            sousProjetDao.delete(s);
            return 1;
        }
    }

    @Override
    public int deleteSousProjetById(Long id) {
        boolean sp = sousProjetDao.existsById(id);
        if (!sp) {
            return -1;
        } else {
            SousProjet s = sousProjetDao.getOne(id);
            sousProjetDao.delete(s);
            return 1;
        }
    }
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public String constructQuery(String projet) {
//        String query = "SELECT sp From SousProjet sp where 1=1";
//        if (projet != null) {
//            query += " and sp.projet.libelleP = '" + projet + "'";
//        }
//        return query;
//    }
//
//    @Override
//    public List<SousProjet> findByCriteria(String libelleP) {
//        return entityManager.createQuery(constructQuery(libelleP)).getResultList();
//    }

}
