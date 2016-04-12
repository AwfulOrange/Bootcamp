/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.jpacontroller;

import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import java.util.ArrayList;
import java.util.Collection;
import com.perficient.talentreviewsystem.entity.SupportiveInfo;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.IllegalOrphanException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bootcamp19
 */
public class EmployeeInfoJpaController implements Serializable {

    public EmployeeInfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmployeeInfo employeeInfo) throws PreexistingEntityException, Exception {
        if (employeeInfo.getTalentReviewScoreCollection() == null) {
            employeeInfo.setTalentReviewScoreCollection(new ArrayList<TalentReviewScore>());
        }
        if (employeeInfo.getSupportiveInfoCollection() == null) {
            employeeInfo.setSupportiveInfoCollection(new ArrayList<SupportiveInfo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TalentReviewScore> attachedTalentReviewScoreCollection = new ArrayList<TalentReviewScore>();
            for (TalentReviewScore talentReviewScoreCollectionTalentReviewScoreToAttach : employeeInfo.getTalentReviewScoreCollection()) {
                talentReviewScoreCollectionTalentReviewScoreToAttach = em.getReference(talentReviewScoreCollectionTalentReviewScoreToAttach.getClass(), talentReviewScoreCollectionTalentReviewScoreToAttach.getTalentReviewScorePK());
                attachedTalentReviewScoreCollection.add(talentReviewScoreCollectionTalentReviewScoreToAttach);
            }
            employeeInfo.setTalentReviewScoreCollection(attachedTalentReviewScoreCollection);
            Collection<SupportiveInfo> attachedSupportiveInfoCollection = new ArrayList<SupportiveInfo>();
            for (SupportiveInfo supportiveInfoCollectionSupportiveInfoToAttach : employeeInfo.getSupportiveInfoCollection()) {
                supportiveInfoCollectionSupportiveInfoToAttach = em.getReference(supportiveInfoCollectionSupportiveInfoToAttach.getClass(), supportiveInfoCollectionSupportiveInfoToAttach.getSupportiveInfoPK());
                attachedSupportiveInfoCollection.add(supportiveInfoCollectionSupportiveInfoToAttach);
            }
            employeeInfo.setSupportiveInfoCollection(attachedSupportiveInfoCollection);
            em.persist(employeeInfo);
            for (TalentReviewScore talentReviewScoreCollectionTalentReviewScore : employeeInfo.getTalentReviewScoreCollection()) {
                EmployeeInfo oldEmployeeInfoOfTalentReviewScoreCollectionTalentReviewScore = talentReviewScoreCollectionTalentReviewScore.getEmployeeInfo();
                talentReviewScoreCollectionTalentReviewScore.setEmployeeInfo(employeeInfo);
                talentReviewScoreCollectionTalentReviewScore = em.merge(talentReviewScoreCollectionTalentReviewScore);
                if (oldEmployeeInfoOfTalentReviewScoreCollectionTalentReviewScore != null) {
                    oldEmployeeInfoOfTalentReviewScoreCollectionTalentReviewScore.getTalentReviewScoreCollection().remove(talentReviewScoreCollectionTalentReviewScore);
                    oldEmployeeInfoOfTalentReviewScoreCollectionTalentReviewScore = em.merge(oldEmployeeInfoOfTalentReviewScoreCollectionTalentReviewScore);
                }
            }
            for (SupportiveInfo supportiveInfoCollectionSupportiveInfo : employeeInfo.getSupportiveInfoCollection()) {
                EmployeeInfo oldEmployeeInfoOfSupportiveInfoCollectionSupportiveInfo = supportiveInfoCollectionSupportiveInfo.getEmployeeInfo();
                supportiveInfoCollectionSupportiveInfo.setEmployeeInfo(employeeInfo);
                supportiveInfoCollectionSupportiveInfo = em.merge(supportiveInfoCollectionSupportiveInfo);
                if (oldEmployeeInfoOfSupportiveInfoCollectionSupportiveInfo != null) {
                    oldEmployeeInfoOfSupportiveInfoCollectionSupportiveInfo.getSupportiveInfoCollection().remove(supportiveInfoCollectionSupportiveInfo);
                    oldEmployeeInfoOfSupportiveInfoCollectionSupportiveInfo = em.merge(oldEmployeeInfoOfSupportiveInfoCollectionSupportiveInfo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmployeeInfo(employeeInfo.getEmployeeId()) != null) {
                throw new PreexistingEntityException("EmployeeInfo " + employeeInfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmployeeInfo employeeInfo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmployeeInfo persistentEmployeeInfo = em.find(EmployeeInfo.class, employeeInfo.getEmployeeId());
            Collection<TalentReviewScore> talentReviewScoreCollectionOld = persistentEmployeeInfo.getTalentReviewScoreCollection();
            Collection<TalentReviewScore> talentReviewScoreCollectionNew = employeeInfo.getTalentReviewScoreCollection();
            Collection<SupportiveInfo> supportiveInfoCollectionOld = persistentEmployeeInfo.getSupportiveInfoCollection();
            Collection<SupportiveInfo> supportiveInfoCollectionNew = employeeInfo.getSupportiveInfoCollection();
            List<String> illegalOrphanMessages = null;
            for (TalentReviewScore talentReviewScoreCollectionOldTalentReviewScore : talentReviewScoreCollectionOld) {
                if (!talentReviewScoreCollectionNew.contains(talentReviewScoreCollectionOldTalentReviewScore)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TalentReviewScore " + talentReviewScoreCollectionOldTalentReviewScore + " since its employeeInfo field is not nullable.");
                }
            }
            for (SupportiveInfo supportiveInfoCollectionOldSupportiveInfo : supportiveInfoCollectionOld) {
                if (!supportiveInfoCollectionNew.contains(supportiveInfoCollectionOldSupportiveInfo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SupportiveInfo " + supportiveInfoCollectionOldSupportiveInfo + " since its employeeInfo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<TalentReviewScore> attachedTalentReviewScoreCollectionNew = new ArrayList<TalentReviewScore>();
            for (TalentReviewScore talentReviewScoreCollectionNewTalentReviewScoreToAttach : talentReviewScoreCollectionNew) {
                talentReviewScoreCollectionNewTalentReviewScoreToAttach = em.getReference(talentReviewScoreCollectionNewTalentReviewScoreToAttach.getClass(), talentReviewScoreCollectionNewTalentReviewScoreToAttach.getTalentReviewScorePK());
                attachedTalentReviewScoreCollectionNew.add(talentReviewScoreCollectionNewTalentReviewScoreToAttach);
            }
            talentReviewScoreCollectionNew = attachedTalentReviewScoreCollectionNew;
            employeeInfo.setTalentReviewScoreCollection(talentReviewScoreCollectionNew);
            Collection<SupportiveInfo> attachedSupportiveInfoCollectionNew = new ArrayList<SupportiveInfo>();
            for (SupportiveInfo supportiveInfoCollectionNewSupportiveInfoToAttach : supportiveInfoCollectionNew) {
                supportiveInfoCollectionNewSupportiveInfoToAttach = em.getReference(supportiveInfoCollectionNewSupportiveInfoToAttach.getClass(), supportiveInfoCollectionNewSupportiveInfoToAttach.getSupportiveInfoPK());
                attachedSupportiveInfoCollectionNew.add(supportiveInfoCollectionNewSupportiveInfoToAttach);
            }
            supportiveInfoCollectionNew = attachedSupportiveInfoCollectionNew;
            employeeInfo.setSupportiveInfoCollection(supportiveInfoCollectionNew);
            employeeInfo = em.merge(employeeInfo);
            for (TalentReviewScore talentReviewScoreCollectionNewTalentReviewScore : talentReviewScoreCollectionNew) {
                if (!talentReviewScoreCollectionOld.contains(talentReviewScoreCollectionNewTalentReviewScore)) {
                    EmployeeInfo oldEmployeeInfoOfTalentReviewScoreCollectionNewTalentReviewScore = talentReviewScoreCollectionNewTalentReviewScore.getEmployeeInfo();
                    talentReviewScoreCollectionNewTalentReviewScore.setEmployeeInfo(employeeInfo);
                    talentReviewScoreCollectionNewTalentReviewScore = em.merge(talentReviewScoreCollectionNewTalentReviewScore);
                    if (oldEmployeeInfoOfTalentReviewScoreCollectionNewTalentReviewScore != null && !oldEmployeeInfoOfTalentReviewScoreCollectionNewTalentReviewScore.equals(employeeInfo)) {
                        oldEmployeeInfoOfTalentReviewScoreCollectionNewTalentReviewScore.getTalentReviewScoreCollection().remove(talentReviewScoreCollectionNewTalentReviewScore);
                        oldEmployeeInfoOfTalentReviewScoreCollectionNewTalentReviewScore = em.merge(oldEmployeeInfoOfTalentReviewScoreCollectionNewTalentReviewScore);
                    }
                }
            }
            for (SupportiveInfo supportiveInfoCollectionNewSupportiveInfo : supportiveInfoCollectionNew) {
                if (!supportiveInfoCollectionOld.contains(supportiveInfoCollectionNewSupportiveInfo)) {
                    EmployeeInfo oldEmployeeInfoOfSupportiveInfoCollectionNewSupportiveInfo = supportiveInfoCollectionNewSupportiveInfo.getEmployeeInfo();
                    supportiveInfoCollectionNewSupportiveInfo.setEmployeeInfo(employeeInfo);
                    supportiveInfoCollectionNewSupportiveInfo = em.merge(supportiveInfoCollectionNewSupportiveInfo);
                    if (oldEmployeeInfoOfSupportiveInfoCollectionNewSupportiveInfo != null && !oldEmployeeInfoOfSupportiveInfoCollectionNewSupportiveInfo.equals(employeeInfo)) {
                        oldEmployeeInfoOfSupportiveInfoCollectionNewSupportiveInfo.getSupportiveInfoCollection().remove(supportiveInfoCollectionNewSupportiveInfo);
                        oldEmployeeInfoOfSupportiveInfoCollectionNewSupportiveInfo = em.merge(oldEmployeeInfoOfSupportiveInfoCollectionNewSupportiveInfo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = employeeInfo.getEmployeeId();
                if (findEmployeeInfo(id) == null) {
                    throw new NonexistentEntityException("The employeeInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmployeeInfo employeeInfo;
            try {
                employeeInfo = em.getReference(EmployeeInfo.class, id);
                employeeInfo.getEmployeeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employeeInfo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<TalentReviewScore> talentReviewScoreCollectionOrphanCheck = employeeInfo.getTalentReviewScoreCollection();
            for (TalentReviewScore talentReviewScoreCollectionOrphanCheckTalentReviewScore : talentReviewScoreCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmployeeInfo (" + employeeInfo + ") cannot be destroyed since the TalentReviewScore " + talentReviewScoreCollectionOrphanCheckTalentReviewScore + " in its talentReviewScoreCollection field has a non-nullable employeeInfo field.");
            }
            Collection<SupportiveInfo> supportiveInfoCollectionOrphanCheck = employeeInfo.getSupportiveInfoCollection();
            for (SupportiveInfo supportiveInfoCollectionOrphanCheckSupportiveInfo : supportiveInfoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EmployeeInfo (" + employeeInfo + ") cannot be destroyed since the SupportiveInfo " + supportiveInfoCollectionOrphanCheckSupportiveInfo + " in its supportiveInfoCollection field has a non-nullable employeeInfo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(employeeInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmployeeInfo> findEmployeeInfoEntities() {
        return findEmployeeInfoEntities(true, -1, -1);
    }

    public List<EmployeeInfo> findEmployeeInfoEntities(int maxResults, int firstResult) {
        return findEmployeeInfoEntities(false, maxResults, firstResult);
    }

    private List<EmployeeInfo> findEmployeeInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmployeeInfo.class));
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

    public EmployeeInfo findEmployeeInfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmployeeInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeeInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmployeeInfo> rt = cq.from(EmployeeInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
