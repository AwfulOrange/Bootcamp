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
import com.perficient.talentreviewsystem.entity.SupportiveInfo;
import com.perficient.talentreviewsystem.entity.SupportiveInfoPK;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bootcamp19
 */
public class SupportiveInfoJpaController implements Serializable {

    public SupportiveInfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private transient EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SupportiveInfo supportiveInfo) throws PreexistingEntityException, Exception {
        if (supportiveInfo.getSupportiveInfoPK() == null) {
            supportiveInfo.setSupportiveInfoPK(new SupportiveInfoPK());
        }
        supportiveInfo.getSupportiveInfoPK().setEmployeeId(supportiveInfo.getEmployeeInfo().getEmployeeId());
        supportiveInfo.getSupportiveInfoPK().setReviewPeriod(supportiveInfo.getReviewPeriod1().getReviewPeriod());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmployeeInfo employeeInfo = supportiveInfo.getEmployeeInfo();
            if (employeeInfo != null) {
                employeeInfo = em.getReference(employeeInfo.getClass(), employeeInfo.getEmployeeId());
                supportiveInfo.setEmployeeInfo(employeeInfo);
            }
            ReviewPeriod reviewPeriod1 = supportiveInfo.getReviewPeriod1();
            if (reviewPeriod1 != null) {
                reviewPeriod1 = em.getReference(reviewPeriod1.getClass(), reviewPeriod1.getReviewPeriod());
                supportiveInfo.setReviewPeriod1(reviewPeriod1);
            }
            em.persist(supportiveInfo);
            if (employeeInfo != null) {
                employeeInfo.getSupportiveInfoCollection().add(supportiveInfo);
                employeeInfo = em.merge(employeeInfo);
            }
            if (reviewPeriod1 != null) {
                reviewPeriod1.getSupportiveInfoCollection().add(supportiveInfo);
                reviewPeriod1 = em.merge(reviewPeriod1);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSupportiveInfo(supportiveInfo.getSupportiveInfoPK()) != null) {
                throw new PreexistingEntityException("SupportiveInfo " + supportiveInfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SupportiveInfo supportiveInfo) throws NonexistentEntityException, Exception {
        supportiveInfo.getSupportiveInfoPK().setEmployeeId(supportiveInfo.getEmployeeInfo().getEmployeeId());
        supportiveInfo.getSupportiveInfoPK().setReviewPeriod(supportiveInfo.getReviewPeriod1().getReviewPeriod());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SupportiveInfo persistentSupportiveInfo = em.find(SupportiveInfo.class, supportiveInfo.getSupportiveInfoPK());
            EmployeeInfo employeeInfoOld = persistentSupportiveInfo.getEmployeeInfo();
            EmployeeInfo employeeInfoNew = supportiveInfo.getEmployeeInfo();
            ReviewPeriod reviewPeriod1Old = persistentSupportiveInfo.getReviewPeriod1();
            ReviewPeriod reviewPeriod1New = supportiveInfo.getReviewPeriod1();
            if (employeeInfoNew != null) {
                employeeInfoNew = em.getReference(employeeInfoNew.getClass(), employeeInfoNew.getEmployeeId());
                supportiveInfo.setEmployeeInfo(employeeInfoNew);
            }
            if (reviewPeriod1New != null) {
                reviewPeriod1New = em.getReference(reviewPeriod1New.getClass(), reviewPeriod1New.getReviewPeriod());
                supportiveInfo.setReviewPeriod1(reviewPeriod1New);
            }
            supportiveInfo = em.merge(supportiveInfo);
            if (employeeInfoOld != null && !employeeInfoOld.equals(employeeInfoNew)) {
                employeeInfoOld.getSupportiveInfoCollection().remove(supportiveInfo);
                employeeInfoOld = em.merge(employeeInfoOld);
            }
            if (employeeInfoNew != null && !employeeInfoNew.equals(employeeInfoOld)) {
                employeeInfoNew.getSupportiveInfoCollection().add(supportiveInfo);
                employeeInfoNew = em.merge(employeeInfoNew);
            }
            if (reviewPeriod1Old != null && !reviewPeriod1Old.equals(reviewPeriod1New)) {
                reviewPeriod1Old.getSupportiveInfoCollection().remove(supportiveInfo);
                reviewPeriod1Old = em.merge(reviewPeriod1Old);
            }
            if (reviewPeriod1New != null && !reviewPeriod1New.equals(reviewPeriod1Old)) {
                reviewPeriod1New.getSupportiveInfoCollection().add(supportiveInfo);
                reviewPeriod1New = em.merge(reviewPeriod1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                SupportiveInfoPK id = supportiveInfo.getSupportiveInfoPK();
                if (findSupportiveInfo(id) == null) {
                    throw new NonexistentEntityException("The supportiveInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(SupportiveInfoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SupportiveInfo supportiveInfo;
            try {
                supportiveInfo = em.getReference(SupportiveInfo.class, id);
                supportiveInfo.getSupportiveInfoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The supportiveInfo with id " + id + " no longer exists.", enfe);
            }
            EmployeeInfo employeeInfo = supportiveInfo.getEmployeeInfo();
            if (employeeInfo != null) {
                employeeInfo.getSupportiveInfoCollection().remove(supportiveInfo);
                employeeInfo = em.merge(employeeInfo);
            }
            ReviewPeriod reviewPeriod1 = supportiveInfo.getReviewPeriod1();
            if (reviewPeriod1 != null) {
                reviewPeriod1.getSupportiveInfoCollection().remove(supportiveInfo);
                reviewPeriod1 = em.merge(reviewPeriod1);
            }
            em.remove(supportiveInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SupportiveInfo> findSupportiveInfoEntities() {
        return findSupportiveInfoEntities(true, -1, -1);
    }

    public List<SupportiveInfo> findSupportiveInfoEntities(int maxResults, int firstResult) {
        return findSupportiveInfoEntities(false, maxResults, firstResult);
    }

    private List<SupportiveInfo> findSupportiveInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SupportiveInfo.class));
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

    public SupportiveInfo findSupportiveInfo(SupportiveInfoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SupportiveInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupportiveInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SupportiveInfo> rt = cq.from(SupportiveInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
