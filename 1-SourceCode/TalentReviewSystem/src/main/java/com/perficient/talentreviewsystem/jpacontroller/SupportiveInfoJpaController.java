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
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SupportiveInfo supportiveInfo) throws PreexistingEntityException, Exception {
        if (supportiveInfo.getSupportiveInfoPK() == null) {
            supportiveInfo.setSupportiveInfoPK(new SupportiveInfoPK());
        }
        supportiveInfo.getSupportiveInfoPK().setReviewPeriod(supportiveInfo.getRp().getReviewPeriod());
        supportiveInfo.getSupportiveInfoPK().setEmployeeId(supportiveInfo.getEmployeeInfo().getEmployeeId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmployeeInfo employeeInfo = supportiveInfo.getEmployeeInfo();
            if (employeeInfo != null) {
                employeeInfo = em.getReference(employeeInfo.getClass(), employeeInfo.getEmployeeId());
                supportiveInfo.setEmployeeInfo(employeeInfo);
            }
            Rp rp = supportiveInfo.getRp();
            if (rp != null) {
                rp = em.getReference(rp.getClass(), rp.getReviewPeriod());
                supportiveInfo.setRp(rp);
            }
            em.persist(supportiveInfo);
            if (employeeInfo != null) {
                employeeInfo.getSupportiveInfoCollection().add(supportiveInfo);
                employeeInfo = em.merge(employeeInfo);
            }
            if (rp != null) {
                rp.getSupportiveInfoCollection().add(supportiveInfo);
                rp = em.merge(rp);
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
        supportiveInfo.getSupportiveInfoPK().setReviewPeriod(supportiveInfo.getRp().getReviewPeriod());
        supportiveInfo.getSupportiveInfoPK().setEmployeeId(supportiveInfo.getEmployeeInfo().getEmployeeId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SupportiveInfo persistentSupportiveInfo = em.find(SupportiveInfo.class, supportiveInfo.getSupportiveInfoPK());
            EmployeeInfo employeeInfoOld = persistentSupportiveInfo.getEmployeeInfo();
            EmployeeInfo employeeInfoNew = supportiveInfo.getEmployeeInfo();
            Rp rpOld = persistentSupportiveInfo.getRp();
            Rp rpNew = supportiveInfo.getRp();
            if (employeeInfoNew != null) {
                employeeInfoNew = em.getReference(employeeInfoNew.getClass(), employeeInfoNew.getEmployeeId());
                supportiveInfo.setEmployeeInfo(employeeInfoNew);
            }
            if (rpNew != null) {
                rpNew = em.getReference(rpNew.getClass(), rpNew.getReviewPeriod());
                supportiveInfo.setRp(rpNew);
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
            if (rpOld != null && !rpOld.equals(rpNew)) {
                rpOld.getSupportiveInfoCollection().remove(supportiveInfo);
                rpOld = em.merge(rpOld);
            }
            if (rpNew != null && !rpNew.equals(rpOld)) {
                rpNew.getSupportiveInfoCollection().add(supportiveInfo);
                rpNew = em.merge(rpNew);
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
            Rp rp = supportiveInfo.getRp();
            if (rp != null) {
                rp.getSupportiveInfoCollection().remove(supportiveInfo);
                rp = em.merge(rp);
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
