/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import com.perficient.talentreviewsystem.entity.Cri;
import com.perficient.talentreviewsystem.jpacontroller.CriJpaController;
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
    CriJpaController cjc = null;
    List<Cri> criterias;
    EntityManager em = null;
    String sql =null;

    @Override
    public List<Cri> selectAllCriteria() {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        cjc = new CriJpaController(emf);
        criterias = cjc.findCriEntities();
        return criterias;
    }

    
    @Override
    public List<Cri> getCriteriaByBoth(String criteria, String level) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        sql =JPAUtil.SELECT_CRITERIA_BY_CRITERIA_LEVEL;
        Query query = em.createNativeQuery(sql,Cri.class);
        query.setParameter(1, criteria);
        query.setParameter(2, level);
        criterias = query.getResultList();
        return criterias;
    }

    @Override
    public List<Cri> getCriteriaByLevel(String level) {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        em = emf.createEntityManager();
        sql= JPAUtil.SELECT_CRITERIA_BY_LEVLE;
        Query query =em.createNativeQuery(sql, Cri.class);
        query.setParameter(1, level);
        criterias = query.getResultList();
        return  criterias;
        
    }

}
