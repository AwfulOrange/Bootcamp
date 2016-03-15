/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.jpacontroller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.perficient.talentreviewsystem.entity.Critical;
import com.perficient.talentreviewsystem.entity.Rule;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bootcamp19
 */
public class RuleJpaController implements Serializable {

    public RuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rule rule) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Critical calId = rule.getCalId();
            if (calId != null) {
                calId = em.getReference(calId.getClass(), calId.getCalId());
                rule.setCalId(calId);
            }
            em.persist(rule);
            if (calId != null) {
                calId.getRuleCollection().add(rule);
                calId = em.merge(calId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRule(rule.getRId()) != null) {
                throw new PreexistingEntityException("Rule " + rule + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rule rule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rule persistentRule = em.find(Rule.class, rule.getRId());
            Critical calIdOld = persistentRule.getCalId();
            Critical calIdNew = rule.getCalId();
            if (calIdNew != null) {
                calIdNew = em.getReference(calIdNew.getClass(), calIdNew.getCalId());
                rule.setCalId(calIdNew);
            }
            rule = em.merge(rule);
            if (calIdOld != null && !calIdOld.equals(calIdNew)) {
                calIdOld.getRuleCollection().remove(rule);
                calIdOld = em.merge(calIdOld);
            }
            if (calIdNew != null && !calIdNew.equals(calIdOld)) {
                calIdNew.getRuleCollection().add(rule);
                calIdNew = em.merge(calIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rule.getRId();
                if (findRule(id) == null) {
                    throw new NonexistentEntityException("The rule with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rule rule;
            try {
                rule = em.getReference(Rule.class, id);
                rule.getRId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rule with id " + id + " no longer exists.", enfe);
            }
            Critical calId = rule.getCalId();
            if (calId != null) {
                calId.getRuleCollection().remove(rule);
                calId = em.merge(calId);
            }
            em.remove(rule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rule> findRuleEntities() {
        return findRuleEntities(true, -1, -1);
    }

    public List<Rule> findRuleEntities(int maxResults, int firstResult) {
        return findRuleEntities(false, maxResults, firstResult);
    }

    private List<Rule> findRuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rule.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Rule findRule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rule.class, id);
        } finally {
            em.close();
        }
    }

    public int getRuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rule> rt = cq.from(Rule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
