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
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
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
        talentReviewScore.getTalentReviewScorePK().setEmployeeId(talentReviewScore.getEmployeeInfo().getEmployeeId());
        talentReviewScore.getTalentReviewScorePK().setReviewPeriod(talentReviewScore.getReviewPeriod1().getReviewPeriod());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmployeeInfo employeeInfo = talentReviewScore.getEmployeeInfo();
            if (employeeInfo != null) {
                employeeInfo = em.getReference(employeeInfo.getClass(), employeeInfo.getEmployeeId());
                talentReviewScore.setEmployeeInfo(employeeInfo);
            }
            ReviewPeriod reviewPeriod1 = talentReviewScore.getReviewPeriod1();
            if (reviewPeriod1 != null) {
                reviewPeriod1 = em.getReference(reviewPeriod1.getClass(), reviewPeriod1.getReviewPeriod());
                talentReviewScore.setReviewPeriod1(reviewPeriod1);
            }
            em.persist(talentReviewScore);
            if (employeeInfo != null) {
                employeeInfo.getTalentReviewScoreCollection().add(talentReviewScore);
                employeeInfo = em.merge(employeeInfo);
            }
            if (reviewPeriod1 != null) {
                reviewPeriod1.getTalentReviewScoreCollection().add(talentReviewScore);
                reviewPeriod1 = em.merge(reviewPeriod1);
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
        talentReviewScore.getTalentReviewScorePK().setEmployeeId(talentReviewScore.getEmployeeInfo().getEmployeeId());
        talentReviewScore.getTalentReviewScorePK().setReviewPeriod(talentReviewScore.getReviewPeriod1().getReviewPeriod());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TalentReviewScore persistentTalentReviewScore = em.find(TalentReviewScore.class, talentReviewScore.getTalentReviewScorePK());
            EmployeeInfo employeeInfoOld = persistentTalentReviewScore.getEmployeeInfo();
            EmployeeInfo employeeInfoNew = talentReviewScore.getEmployeeInfo();
            ReviewPeriod reviewPeriod1Old = persistentTalentReviewScore.getReviewPeriod1();
            ReviewPeriod reviewPeriod1New = talentReviewScore.getReviewPeriod1();
            if (employeeInfoNew != null) {
                employeeInfoNew = em.getReference(employeeInfoNew.getClass(), employeeInfoNew.getEmployeeId());
                talentReviewScore.setEmployeeInfo(employeeInfoNew);
            }
            if (reviewPeriod1New != null) {
                reviewPeriod1New = em.getReference(reviewPeriod1New.getClass(), reviewPeriod1New.getReviewPeriod());
                talentReviewScore.setReviewPeriod1(reviewPeriod1New);
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
            if (reviewPeriod1Old != null && !reviewPeriod1Old.equals(reviewPeriod1New)) {
                reviewPeriod1Old.getTalentReviewScoreCollection().remove(talentReviewScore);
                reviewPeriod1Old = em.merge(reviewPeriod1Old);
            }
            if (reviewPeriod1New != null && !reviewPeriod1New.equals(reviewPeriod1Old)) {
                reviewPeriod1New.getTalentReviewScoreCollection().add(talentReviewScore);
                reviewPeriod1New = em.merge(reviewPeriod1New);
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
            ReviewPeriod reviewPeriod1 = talentReviewScore.getReviewPeriod1();
            if (reviewPeriod1 != null) {
                reviewPeriod1.getTalentReviewScoreCollection().remove(talentReviewScore);
                reviewPeriod1 = em.merge(reviewPeriod1);
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
