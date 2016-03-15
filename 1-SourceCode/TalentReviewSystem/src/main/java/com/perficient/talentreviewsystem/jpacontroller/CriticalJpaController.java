/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.jpacontroller;

import com.perficient.talentreviewsystem.entity.Critical;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.perficient.talentreviewsystem.entity.Rule;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.IllegalOrphanException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bootcamp19
 */
public class CriticalJpaController implements Serializable {

    public CriticalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Critical critical) throws PreexistingEntityException, Exception {
        if (critical.getRuleCollection() == null) {
            critical.setRuleCollection(new ArrayList<Rule>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rule> attachedRuleCollection = new ArrayList<Rule>();
            for (Rule ruleCollectionRuleToAttach : critical.getRuleCollection()) {
                ruleCollectionRuleToAttach = em.getReference(ruleCollectionRuleToAttach.getClass(), ruleCollectionRuleToAttach.getRId());
                attachedRuleCollection.add(ruleCollectionRuleToAttach);
            }
            critical.setRuleCollection(attachedRuleCollection);
            em.persist(critical);
            for (Rule ruleCollectionRule : critical.getRuleCollection()) {
                Critical oldCalIdOfRuleCollectionRule = ruleCollectionRule.getCalId();
                ruleCollectionRule.setCalId(critical);
                ruleCollectionRule = em.merge(ruleCollectionRule);
                if (oldCalIdOfRuleCollectionRule != null) {
                    oldCalIdOfRuleCollectionRule.getRuleCollection().remove(ruleCollectionRule);
                    oldCalIdOfRuleCollectionRule = em.merge(oldCalIdOfRuleCollectionRule);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCritical(critical.getCalId()) != null) {
                throw new PreexistingEntityException("Critical " + critical + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Critical critical) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Critical persistentCritical = em.find(Critical.class, critical.getCalId());
            Collection<Rule> ruleCollectionOld = persistentCritical.getRuleCollection();
            Collection<Rule> ruleCollectionNew = critical.getRuleCollection();
            List<String> illegalOrphanMessages = null;
            for (Rule ruleCollectionOldRule : ruleCollectionOld) {
                if (!ruleCollectionNew.contains(ruleCollectionOldRule)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rule " + ruleCollectionOldRule + " since its calId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Rule> attachedRuleCollectionNew = new ArrayList<Rule>();
            for (Rule ruleCollectionNewRuleToAttach : ruleCollectionNew) {
                ruleCollectionNewRuleToAttach = em.getReference(ruleCollectionNewRuleToAttach.getClass(), ruleCollectionNewRuleToAttach.getRId());
                attachedRuleCollectionNew.add(ruleCollectionNewRuleToAttach);
            }
            ruleCollectionNew = attachedRuleCollectionNew;
            critical.setRuleCollection(ruleCollectionNew);
            critical = em.merge(critical);
            for (Rule ruleCollectionNewRule : ruleCollectionNew) {
                if (!ruleCollectionOld.contains(ruleCollectionNewRule)) {
                    Critical oldCalIdOfRuleCollectionNewRule = ruleCollectionNewRule.getCalId();
                    ruleCollectionNewRule.setCalId(critical);
                    ruleCollectionNewRule = em.merge(ruleCollectionNewRule);
                    if (oldCalIdOfRuleCollectionNewRule != null && !oldCalIdOfRuleCollectionNewRule.equals(critical)) {
                        oldCalIdOfRuleCollectionNewRule.getRuleCollection().remove(ruleCollectionNewRule);
                        oldCalIdOfRuleCollectionNewRule = em.merge(oldCalIdOfRuleCollectionNewRule);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = critical.getCalId();
                if (findCritical(id) == null) {
                    throw new NonexistentEntityException("The critical with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Critical critical;
            try {
                critical = em.getReference(Critical.class, id);
                critical.getCalId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The critical with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Rule> ruleCollectionOrphanCheck = critical.getRuleCollection();
            for (Rule ruleCollectionOrphanCheckRule : ruleCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Critical (" + critical + ") cannot be destroyed since the Rule " + ruleCollectionOrphanCheckRule + " in its ruleCollection field has a non-nullable calId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(critical);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Critical> findCriticalEntities() {
        return findCriticalEntities(true, -1, -1);
    }

    public List<Critical> findCriticalEntities(int maxResults, int firstResult) {
        return findCriticalEntities(false, maxResults, firstResult);
    }

    private List<Critical> findCriticalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Critical.class));
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

    public Critical findCritical(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Critical.class, id);
        } finally {
            em.close();
        }
    }

    public int getCriticalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Critical> rt = cq.from(Critical.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
