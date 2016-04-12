/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.dao.IReviewPeriodDAO;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
import com.perficient.talentreviewsystem.jpacontroller.ReviewPeriodJpaController;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.IllegalOrphanException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
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
public class ReviewPeriodDAOImpl implements IReviewPeriodDAO {

    EntityManagerFactory emf = null;
    ReviewPeriodJpaController rpjc = null;
    ReviewPeriod reviewPeriod = null;
    EntityManager em = null;
    List<String> rps = null;
    String sql =null;

    @Override
    public ReviewPeriod selectReviewPeriodByRP(String rp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        rpjc = new ReviewPeriodJpaController(emf);
        reviewPeriod = rpjc.findReviewPeriod(rp);
        return reviewPeriod;
    }

    @Override
    public String findMaxRp() {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        sql = JPAUtil.SELECT_MAX_REVIEW_PERIOD;
        Query query =em.createNativeQuery(sql);
        rps=query.getResultList();
        return rps.get(0);
    }

    @Override
    public int addReviewPeriod(ReviewPeriod rp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        rpjc = new ReviewPeriodJpaController(emf);
        try {
            rpjc.create(rp);
            return 1;
        } catch (Exception ex) {
            Logger.getLogger(ReviewPeriodDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int deleteReviewPeriod(String srp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        rpjc = new ReviewPeriodJpaController(emf);
        try {
            rpjc.destroy(srp);
            return 1;
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ReviewPeriodDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ReviewPeriodDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
