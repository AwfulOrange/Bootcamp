/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.entity.TalentReviewScorePK;
import com.perficient.talentreviewsystem.jpacontroller.TalentReviewScoreJpaController;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bootcamp19
 */
public class TalentReviewScoreDAOImpl implements ITalentReviewScoreDAO {
 
    EntityManagerFactory emf = null;
    TalentReviewScoreJpaController trsjc = null;
    List<TalentReviewScore> talentReviewScores = null;
    TalentReviewScorePK trspk = null;
    TalentReviewScore trs = null;
    EntityManager em = null;

    @Override
    public int addTalentReviewScore(TalentReviewScore trs) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        try {
            trsjc.create(trs);
            return 1;
        } catch (Exception ex) {
           Logger.getLogger(TalentReviewScoreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<TalentReviewScore> selectAllTalentReviewScore() {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        talentReviewScores = trsjc.findTalentReviewScoreEntities();
        return talentReviewScores;
    }

    @Override
    public TalentReviewScore selectSingleByBoth(String empId, String rp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        trspk = new TalentReviewScorePK(empId, rp);
        trs = trsjc.findTalentReviewScore(trspk);
        return trs;
    }

    @Override
    public int updateTalentReviewScore(TalentReviewScore talentReviewScore) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);

        try {
            trsjc.edit(talentReviewScore);
            return 1;
        } catch (Exception ex) {
            Logger.getLogger(TalentReviewScoreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int deleteTalentReviewScore(String empId, String rp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        trsjc = new TalentReviewScoreJpaController(emf);
        trspk = new TalentReviewScorePK(empId, rp);
        try {
            trsjc.destroy(trspk);
            return 1;
        } catch (NonexistentEntityException ex) {
             Logger.getLogger(TalentReviewScoreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    //acquire the information of reviewees according to reviewer's id
    @Override
    public List<TalentReviewScore> selectTRScoreByReviewerId(String reviewerId) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        Query query = em.createNativeQuery(JPAUtil.SELECT_TALENTREVIEWSCORE_BY_REVIEWER, TalentReviewScore.class);
        query.setParameter(1, reviewerId);
        talentReviewScores = query.getResultList();
        return talentReviewScores;
    }
     @Override 
    public List<TalentReviewScore> selectTRScoreByPmoId(String pmoId) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        Query query = em.createNativeQuery(JPAUtil.SELECT_TALENTREVIEWSCORE_BY_PMO, TalentReviewScore.class);
        query.setParameter(1, pmoId);
        talentReviewScores = query.getResultList();
        return talentReviewScores;
    }
        @Override 
    public List<String> selectreviewerByPmoId(String pmoId) {
          List<String> reviewerId=new ArrayList<String>();
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        Query query = em.createNativeQuery(JPAUtil.SELECT_reviewer_BY_PMO);
        query.setParameter(1, pmoId);
      
        reviewerId = query.getResultList();
       // System.out.print(reviewerId.size());
        return reviewerId;
    }
    
    
    @Override
      public List<List<TalentReviewScore>> selectTRScoreByBoth(String pmoId) 
      {
              TalentReviewScoreDAOImpl trsdao=new TalentReviewScoreDAOImpl();
             
              List<String> reviewerInfo=new ArrayList<String>();
              reviewerInfo=trsdao.selectreviewerByPmoId(pmoId);
              List<List<TalentReviewScore>> employeeInfo=new ArrayList<List<TalentReviewScore>>();
              for(int i=0;i<reviewerInfo.size();i++)
              {
               employeeInfo.add(trsdao.selectTRScoreByReviewerId(reviewerInfo.get(i))) ;  
              }
              return employeeInfo;
      }

}
