/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Projet;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.dao.ProjetDao;
import com.faculte.mandatPersonnel.model.service.ProjetService;
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
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetDao projetDao;

    @Autowired
    private SousProjetService sousProjetService;

    @Autowired
    private ProjetService projetService;

    @Override
    public Projet findByLibelleP(String libelleP) {
        return projetDao.findByLibelleP(libelleP);
    }

    @Override
    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    @Override
    public int creerProjet(Projet projet) {
        Projet p = findByLibelleP(projet.getLibelleP());
        if (p == null) {
            projetDao.save(projet);
        }
        List<SousProjet> sousProjets = projet.getSousProjets();
        for (SousProjet sousProjet : sousProjets) {
            sousProjet.setProjet(projet);
            sousProjetService.creerSousProjet(sousProjet, projet.getId());
        }
        return 1;
    }

    @Override
    public int deleteByLibelleP(String libelleP) {
        Projet projet = projetService.findByLibelleP(libelleP);
        if (projet == null) {
            return -1;
        } else {
            List<SousProjet> sousProjets = sousProjetService.findByProjetLibelleP(libelleP);
            for (SousProjet sousProjet : sousProjets) {
                sousProjetService.deleteSousProjetById(sousProjet.getId());
            }
            projetDao.delete(projet);
            return 1;
        }
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Projet> chercherProjet(String libelleP) {

        String query = "select p from Projet p where 1=1";
        if (libelleP != null && !libelleP.equals("")) {
            query += SearchUtil.addConstraint("p", "libelleP", "LIKE", libelleP);
        }
        System.out.println("query --->" + query);
        return entityManager.createQuery(query).getResultList();
    }

    public ProjetDao getProjetDao() {
        return projetDao;
    }

    public void setProjetDao(ProjetDao projetDao) {
        this.projetDao = projetDao;
    }

    public SousProjetService getSousProjetService() {
        return sousProjetService;
    }

    public void setSousProjetService(SousProjetService sousProjetService) {
        this.sousProjetService = sousProjetService;
    }

    public ProjetService getProjetService() {
        return projetService;
    }

    public void setProjetService(ProjetService projetService) {
        this.projetService = projetService;
    }

}
