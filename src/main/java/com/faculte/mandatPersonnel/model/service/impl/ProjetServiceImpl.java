/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Projet;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.dao.ProjetDao;
import com.faculte.mandatPersonnel.model.dao.SousProjetDao;
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
    private SousProjetDao sousProjetDao;

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
        boolean creerp = false;
        Projet p = findByLibelleP(projet.getLibelleP());
        if (p == null) {
            projetDao.save(projet);
            creerp = true;
        }
        p = findByLibelleP(projet.getLibelleP());
        List<SousProjet> sousProjets = projet.getSousProjets();
        for (SousProjet sousProjet : sousProjets) {
            sousProjet.setProjet(p);
            sousProjetService.creerSousProjet(sousProjet, projet.getLibelleP());
        }

//        return creerp ? 1 : 2;
        if (creerp) {
            return 1;
        } else {
            return 2;
        }
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

    @Override
    public int updateProjet(Projet projet) {
        Projet p = projetDao.getOne(projet.getId());
        List<SousProjet> sp1 = sousProjetService.findByProjetLibelleP(p.getLibelleP());
        String libelle = p.getLibelleP();
        List<SousProjet> sp2 = projet.getSousProjets();
        int i = 0, b = 0;
        for (SousProjet sousProjet : sp1) {
            for (SousProjet sousProjet1 : sp2) {
                if (sousProjet1.getReferenceSousProjet().equals(sousProjet.getReferenceSousProjet())) {
                    System.out.println("kayen 1");
                    i = 1;
                }
            }
            if (i == 0) {
                sousProjetDao.delete(sousProjet);
            }
            i = 0;
        }
        for (SousProjet sousProjet : sp2) {
            for (SousProjet sousProjet1 : sp1) {
                if (sousProjet1.getReferenceSousProjet().equals(sousProjet.getReferenceSousProjet())) {
                    b = 1;
                    System.out.println("kayen 2");
                }
            }
            if (b == 0) {
                sousProjet.setProjet(projet);
                sousProjetService.creerSousProjet(sousProjet, libelle);
                
            }
            b = 0;

        }
        projetDao.save(projet);
        return 1;

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
