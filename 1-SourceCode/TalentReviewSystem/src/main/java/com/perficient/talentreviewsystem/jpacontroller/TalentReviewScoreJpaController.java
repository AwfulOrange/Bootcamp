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
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.entity.Rp;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.entity.TalentReviewScorePK;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bootcamp19
 */
public class TalentReviewScoreJpaController implements Serializable {

    public TalentReviewScoreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TalentReviewScore talentReviewScore) throws PreexistingEntityException, Exception {
        if (talentReviewScore.getTalentReviewScorePK() == null) {
            talentReviewScore.setTalentReviewScorePK(new TalentReviewScorePK());
        }
        talentReviewScore.getTalentReviewScorePK().setReviewPeriod(talentReviewScore.getRp().getReviewPeriod());
        talentReviewScore.getTalentReviewScorePK().setEmployeeId(talentReviewScore.getEmployeeInfo().getEmployeeId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmployeeInfo employeeInfo = talentReviewScore.getEmployeeInfo();
            if (employeeInfo != null) {
                employeeInfo = em.getReference(employeeInfo.getClass(), employeeInfo.getEmployeeId());
                talentReviewScore.setEmployeeInfo(employeeInfo);
            }
            Rp rp = talentReviewScore.getRp();
            if (rp != null) {
                rp = em.getReference(rp.getClass(), rp.getReviewPeriod());
                talentReviewScore.setRp(rp);
            }
            em.persist(talentReviewScore);
            if (employeeInfo != null) {
                employeeInfo.getTalentReviewScoreCollection().add(talentReviewScore);
                employeeInfo = em.merge(employeeInfo);
            }
            if (rp != null) {
                rp.getTalentReviewScoreCollection().add(talentReviewScore);
                rp = em.merge(rp);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTalentReviewScore(talentReviewScore.getTalentReviewScorePK()) != null) {
                throw new PreexistingEntityException("TalentReviewScore " + talentReviewScore + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TalentReviewScore talentReviewScore) throws NonexistentEntityException, Exception {
        talentReviewScore.getTalentReviewScorePK().setReviewPeriod(talentReviewScore.getRp().getReviewPeriod());
        talentReviewScore.getTalentReviewScorePK().setEmployeeId(talentReviewScore.getEmployeeInfo().getEmployeeId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TalentReviewScore persistentTalentReviewScore = em.find(TalentReviewScore.class, talentReviewScore.getTalentReviewScorePK());
            EmployeeInfo employeeInfoOld = persistentTalentReviewScore.getEmployeeInfo();
            EmployeeInfo employeeInfoNew = talentReviewScore.getEmployeeInfo();
            Rp rpOld = persistentTalentReviewScore.getRp();
            Rp rpNew = talentReviewScore.getRp();
            if (employeeInfoNew != null) {
                employeeInfoNew = em.getReference(employeeInfoNew.getClass(), employeeInfoNew.getEmployeeId());
                talentReviewScore.setEmployeeInfo(employeeInfoNew);
            }
            if (rpNew != null) {
                rpNew = em.getReference(rpNew.getClass(), rpNew.getReviewPeriod());
                talentReviewScore.setRp(rpNew);
            }
            talentReviewScore = em.merge(talentReviewScore);
            if (employeeInfoOld != null && !employeeInfoOld.equals(employeeInfoNew)) {
                employeeInfoOld.getTalentReviewScoreCollection().remove(talentReviewScore);
                employeeInfoOld = em.merge(employeeInfoOld);
            }
            if (employeeInfoNew != null && !employeeInfoNew.equals(employeeInfoOld)) {
                employeeInfoNew.getTalentReviewScoreCollection().add(talentReviewScore);
                employeeInfoNew = em.merge(employeeInfoNew);
            }
            if (rpOld != null && !rpOld.equals(rpNew)) {
                rpOld.getTalentReviewScoreCollection().remove(talentReviewScore);
                rpOld = em.merge(rpOld);
            }
            if (rpNew != null && !rpNew.equals(rpOld)) {
                rpNew.getTalentReviewScoreCollection().add(talentReviewScore);
                rpNew = em.merge(rpNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TalentReviewScorePK id = talentReviewScore.getTalentReviewScorePK();
                if (findTalentReviewScore(id) == null) {
                    throw new NonexistentEntityException("The talentReviewScore with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TalentReviewScorePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TalentReviewScore talentReviewScore;
            try {
                talentReviewScore = em.getReference(TalentReviewScore.class, id);
                talentReviewScore.getTalentReviewScorePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The talentReviewScore with id " + id + " no longer exists.", enfe);
            }
            EmployeeInfo employeeInfo = talentReviewScore.getEmployeeInfo();
            if (employeeInfo != null) {
                employeeInfo.getTalentReviewScoreCollection().remove(talentReviewScore);
                employeeInfo = em.merge(employeeInfo);
            }
            Rp rp = talentReviewScore.getRp();
            if (rp != null) {
                rp.getTalentReviewScoreCollection().remove(talentReviewScore);
                rp = em.merge(rp);
            }
            em.remove(talentReviewScore);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TalentReviewScore> findTalentReviewScoreEntities() {
        return findTalentReviewScoreEntities(true, -1, -1);
    }

    public List<TalentReviewScore> findTalentReviewScoreEntities(int maxResults, int firstResult) {
        return findTalentReviewScoreEntities(false, maxResults, firstResult);
    }

    private List<TalentReviewScore> findTalentReviewScoreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TalentReviewScore.class));
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

    public TalentReviewScore findTalentReviewScore(TalentReviewScorePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TalentReviewScore.class, id);
        } finally {
            em.close();
        }
    }

    public int getTalentReviewScoreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TalentReviewScore> rt = cq.from(TalentReviewScore.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
