/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import com.perficient.talentreviewsystem.entity.Criteria;
import com.perficient.talentreviewsystem.jpacontroller.CriteriaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author bootcamp19
 */
public class CriteriaDAOImpl implements ICriteriaDAO {

    EntityManagerFactory emf = null;
    UserTransaction ut = null;
    CriteriaJpaController cjc = null;
    List<Criteria> criterias;
    EntityManager em = null;

    @Override
    public List<Criteria> selectAllCriteria() {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        cjc = new CriteriaJpaController(ut, emf);
        criterias = cjc.findCriteriaEntities();
        return criterias;
    }

    //代测！！！
    @Override
    public Criteria getCriteriaByBoth(String criteria, String level) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        Query query = em.createNativeQuery(JPAUtil.SELECT_CRITERIA_BY_CRITERIA_LEVEL);
        query.setParameter(1, criteria);
        query.setParameter(2, level);
        criterias = query.getResultList();
        return criterias.get(0);
    }

}
