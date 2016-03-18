/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.entity.TalentReviewScorePK;
import com.perficient.talentreviewsystem.jpacontroller.TalentReviewScoreJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bootcamp19
 */
public class TalentReviewScoreDAOImpl implements ITalentReviewScoreDAO {

    EntityManagerFactory emf = null;
    TalentReviewScoreJpaController trsjc = null;
    List<TalentReviewScore> TalentReviewScores = null;
    TalentReviewScorePK trspk = null;
    TalentReviewScore trs =null;
    
    
    @Override
    public int addTalentReviewScore(TalentReviewScore trs) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        try {
            trsjc.create(trs);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public List<TalentReviewScore> selectAllTalentReviewScore() {
        emf =  Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        TalentReviewScores = trsjc.findTalentReviewScoreEntities();
        return TalentReviewScores;
    }


    //待测
    @Override
    public TalentReviewScore selectSingleByBoth(String emfInfo, String rp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        trspk = new TalentReviewScorePK(emfInfo,rp);
        trs = trsjc.findTalentReviewScore(trspk);
        return trs;
    }

    
}
