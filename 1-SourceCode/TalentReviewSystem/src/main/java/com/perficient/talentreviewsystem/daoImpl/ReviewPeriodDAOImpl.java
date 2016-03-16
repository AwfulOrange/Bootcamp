/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.dao.IReviewPeriodDAO;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
import com.perficient.talentreviewsystem.jpacontroller.ReviewPeriodJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bootcamp19
 */
public class ReviewPeriodDAOImpl implements IReviewPeriodDAO {

    EntityManagerFactory emf = null;
    ReviewPeriodJpaController rpjc = null;
    ReviewPeriod reviewPeriod = null;

    @Override
    public ReviewPeriod selectReviePeriodByRP(String rp) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        rpjc = new ReviewPeriodJpaController(emf);
        reviewPeriod = rpjc.findReviewPeriod(rp);
        return reviewPeriod;
    }

}
