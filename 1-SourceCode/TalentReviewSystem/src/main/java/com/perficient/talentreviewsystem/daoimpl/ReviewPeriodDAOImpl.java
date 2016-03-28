/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.dao.IReviewPeriodDAO;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
import com.perficient.talentreviewsystem.jpacontroller.ReviewPeriodJpaController;
import java.util.List;
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

}
