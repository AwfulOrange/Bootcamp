/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.jpacontroller;

import com.perficient.talentreviewsystem.entity.Rp;
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
public class RpJpaController implements Serializable {

    public RpJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rp rp) throws PreexistingEntityException, Exception {
        if (rp.getTalentReviewScoreCollection() == null) {
            rp.setTalentReviewScoreCollection(new ArrayList<TalentReviewScore>());
        }
        if (rp.getSupportiveInfoCollection() == null) {
            rp.setSupportiveInfoCollection(new ArrayList<SupportiveInfo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TalentReviewScore> attachedTalentReviewScoreCollection = new ArrayList<TalentReviewScore>();
            for (TalentReviewScore talentReviewScoreCollectionTalentReviewScoreToAttach : rp.getTalentReviewScoreCollection()) {
                talentReviewScoreCollectionTalentReviewScoreToAttach = em.getReference(talentReviewScoreCollectionTalentReviewScoreToAttach.getClass(), talentReviewScoreCollectionTalentReviewScoreToAttach.getTalentReviewScorePK());
                attachedTalentReviewScoreCollection.add(talentReviewScoreCollectionTalentReviewScoreToAttach);
            }
            rp.setTalentReviewScoreCollection(attachedTalentReviewScoreCollection);
            Collection<SupportiveInfo> attachedSupportiveInfoCollection = new ArrayList<SupportiveInfo>();
            for (SupportiveInfo supportiveInfoCollectionSupportiveInfoToAttach : rp.getSupportiveInfoCollection()) {
                supportiveInfoCollectionSupportiveInfoToAttach = em.getReference(supportiveInfoCollectionSupportiveInfoToAttach.getClass(), supportiveInfoCollectionSupportiveInfoToAttach.getSupportiveInfoPK());
                attachedSupportiveInfoCollection.add(supportiveInfoCollectionSupportiveInfoToAttach);
            }
            rp.setSupportiveInfoCollection(attachedSupportiveInfoCollection);
            em.persist(rp);
            for (TalentReviewScore talentReviewScoreCollectionTalentReviewScore : rp.getTalentReviewScoreCollection()) {
                Rp oldRpOfTalentReviewScoreCollectionTalentReviewScore = talentReviewScoreCollectionTalentReviewScore.getRp();
                talentReviewScoreCollectionTalentReviewScore.setRp(rp);
                talentReviewScoreCollectionTalentReviewScore = em.merge(talentReviewScoreCollectionTalentReviewScore);
                if (oldRpOfTalentReviewScoreCollectionTalentReviewScore != null) {
                    oldRpOfTalentReviewScoreCollectionTalentReviewScore.getTalentReviewScoreCollection().remove(talentReviewScoreCollectionTalentReviewScore);
                    oldRpOfTalentReviewScoreCollectionTalentReviewScore = em.merge(oldRpOfTalentReviewScoreCollectionTalentReviewScore);
                }
            }
            for (SupportiveInfo supportiveInfoCollectionSupportiveInfo : rp.getSupportiveInfoCollection()) {
                Rp oldRpOfSupportiveInfoCollectionSupportiveInfo = supportiveInfoCollectionSupportiveInfo.getRp();
                supportiveInfoCollectionSupportiveInfo.setRp(rp);
                supportiveInfoCollectionSupportiveInfo = em.merge(supportiveInfoCollectionSupportiveInfo);
                if (oldRpOfSupportiveInfoCollectionSupportiveInfo != null) {
                    oldRpOfSupportiveInfoCollectionSupportiveInfo.getSupportiveInfoCollection().remove(supportiveInfoCollectionSupportiveInfo);
                    oldRpOfSupportiveInfoCollectionSupportiveInfo = em.merge(oldRpOfSupportiveInfoCollectionSupportiveInfo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRp(rp.getReviewPeriod()) != null) {
                throw new PreexistingEntityException("Rp " + rp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rp rp) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rp persistentRp = em.find(Rp.class, rp.getReviewPeriod());
            Collection<TalentReviewScore> talentReviewScoreCollectionOld = persistentRp.getTalentReviewScoreCollection();
            Collection<TalentReviewScore> talentReviewScoreCollectionNew = rp.getTalentReviewScoreCollection();
            Collection<SupportiveInfo> supportiveInfoCollectionOld = persistentRp.getSupportiveInfoCollection();
            Collection<SupportiveInfo> supportiveInfoCollectionNew = rp.getSupportiveInfoCollection();
            List<String> illegalOrphanMessages = null;
            for (TalentReviewScore talentReviewScoreCollectionOldTalentReviewScore : talentReviewScoreCollectionOld) {
                if (!talentReviewScoreCollectionNew.contains(talentReviewScoreCollectionOldTalentReviewScore)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TalentReviewScore " + talentReviewScoreCollectionOldTalentReviewScore + " since its rp field is not nullable.");
                }
            }
            for (SupportiveInfo supportiveInfoCollectionOldSupportiveInfo : supportiveInfoCollectionOld) {
                if (!supportiveInfoCollectionNew.contains(supportiveInfoCollectionOldSupportiveInfo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SupportiveInfo " + supportiveInfoCollectionOldSupportiveInfo + " since its rp field is not nullable.");
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
            rp.setTalentReviewScoreCollection(talentReviewScoreCollectionNew);
            Collection<SupportiveInfo> attachedSupportiveInfoCollectionNew = new ArrayList<SupportiveInfo>();
            for (SupportiveInfo supportiveInfoCollectionNewSupportiveInfoToAttach : supportiveInfoCollectionNew) {
                supportiveInfoCollectionNewSupportiveInfoToAttach = em.getReference(supportiveInfoCollectionNewSupportiveInfoToAttach.getClass(), supportiveInfoCollectionNewSupportiveInfoToAttach.getSupportiveInfoPK());
                attachedSupportiveInfoCollectionNew.add(supportiveInfoCollectionNewSupportiveInfoToAttach);
            }
            supportiveInfoCollectionNew = attachedSupportiveInfoCollectionNew;
            rp.setSupportiveInfoCollection(supportiveInfoCollectionNew);
            rp = em.merge(rp);
            for (TalentReviewScore talentReviewScoreCollectionNewTalentReviewScore : talentReviewScoreCollectionNew) {
                if (!talentReviewScoreCollectionOld.contains(talentReviewScoreCollectionNewTalentReviewScore)) {
                    Rp oldRpOfTalentReviewScoreCollectionNewTalentReviewScore = talentReviewScoreCollectionNewTalentReviewScore.getRp();
                    talentReviewScoreCollectionNewTalentReviewScore.setRp(rp);
                    talentReviewScoreCollectionNewTalentReviewScore = em.merge(talentReviewScoreCollectionNewTalentReviewScore);
                    if (oldRpOfTalentReviewScoreCollectionNewTalentReviewScore != null && !oldRpOfTalentReviewScoreCollectionNewTalentReviewScore.equals(rp)) {
                        oldRpOfTalentReviewScoreCollectionNewTalentReviewScore.getTalentReviewScoreCollection().remove(talentReviewScoreCollectionNewTalentReviewScore);
                        oldRpOfTalentReviewScoreCollectionNewTalentReviewScore = em.merge(oldRpOfTalentReviewScoreCollectionNewTalentReviewScore);
                    }
                }
            }
            for (SupportiveInfo supportiveInfoCollectionNewSupportiveInfo : supportiveInfoCollectionNew) {
                if (!supportiveInfoCollectionOld.contains(supportiveInfoCollectionNewSupportiveInfo)) {
                    Rp oldRpOfSupportiveInfoCollectionNewSupportiveInfo = supportiveInfoCollectionNewSupportiveInfo.getRp();
                    supportiveInfoCollectionNewSupportiveInfo.setRp(rp);
                    supportiveInfoCollectionNewSupportiveInfo = em.merge(supportiveInfoCollectionNewSupportiveInfo);
                    if (oldRpOfSupportiveInfoCollectionNewSupportiveInfo != null && !oldRpOfSupportiveInfoCollectionNewSupportiveInfo.equals(rp)) {
                        oldRpOfSupportiveInfoCollectionNewSupportiveInfo.getSupportiveInfoCollection().remove(supportiveInfoCollectionNewSupportiveInfo);
                        oldRpOfSupportiveInfoCollectionNewSupportiveInfo = em.merge(oldRpOfSupportiveInfoCollectionNewSupportiveInfo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = rp.getReviewPeriod();
                if (findRp(id) == null) {
                    throw new NonexistentEntityException("The rp with id " + id + " no longer exists.");
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
            Rp rp;
            try {
                rp = em.getReference(Rp.class, id);
                rp.getReviewPeriod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rp with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<TalentReviewScore> talentReviewScoreCollectionOrphanCheck = rp.getTalentReviewScoreCollection();
            for (TalentReviewScore talentReviewScoreCollectionOrphanCheckTalentReviewScore : talentReviewScoreCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rp (" + rp + ") cannot be destroyed since the TalentReviewScore " + talentReviewScoreCollectionOrphanCheckTalentReviewScore + " in its talentReviewScoreCollection field has a non-nullable rp field.");
            }
            Collection<SupportiveInfo> supportiveInfoCollectionOrphanCheck = rp.getSupportiveInfoCollection();
            for (SupportiveInfo supportiveInfoCollectionOrphanCheckSupportiveInfo : supportiveInfoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rp (" + rp + ") cannot be destroyed since the SupportiveInfo " + supportiveInfoCollectionOrphanCheckSupportiveInfo + " in its supportiveInfoCollection field has a non-nullable rp field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(rp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rp> findRpEntities() {
        return findRpEntities(true, -1, -1);
    }

    public List<Rp> findRpEntities(int maxResults, int firstResult) {
        return findRpEntities(false, maxResults, firstResult);
    }

    private List<Rp> findRpEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rp.class));
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

    public Rp findRp(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rp.class, id);
        } finally {
            em.close();
        }
    }

    public int getRpCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rp> rt = cq.from(Rp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
