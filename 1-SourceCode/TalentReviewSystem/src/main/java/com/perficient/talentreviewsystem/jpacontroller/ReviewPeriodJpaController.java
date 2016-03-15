/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.jpacontroller;

import com.perficient.talentreviewsystem.entity.ReviewPeriod;
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
public class ReviewPeriodJpaController implements Serializable {

    public ReviewPeriodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReviewPeriod reviewPeriod) throws PreexistingEntityException, Exception {
        if (reviewPeriod.getTalentReviewScoreCollection() == null) {
            reviewPeriod.setTalentReviewScoreCollection(new ArrayList<TalentReviewScore>());
        }
        if (reviewPeriod.getSupportiveInfoCollection() == null) {
            reviewPeriod.setSupportiveInfoCollection(new ArrayList<SupportiveInfo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TalentReviewScore> attachedTalentReviewScoreCollection = new ArrayList<TalentReviewScore>();
            for (TalentReviewScore talentReviewScoreCollectionTalentReviewScoreToAttach : reviewPeriod.getTalentReviewScoreCollection()) {
                talentReviewScoreCollectionTalentReviewScoreToAttach = em.getReference(talentReviewScoreCollectionTalentReviewScoreToAttach.getClass(), talentReviewScoreCollectionTalentReviewScoreToAttach.getTalentReviewScorePK());
                attachedTalentReviewScoreCollection.add(talentReviewScoreCollectionTalentReviewScoreToAttach);
            }
            reviewPeriod.setTalentReviewScoreCollection(attachedTalentReviewScoreCollection);
            Collection<SupportiveInfo> attachedSupportiveInfoCollection = new ArrayList<SupportiveInfo>();
            for (SupportiveInfo supportiveInfoCollectionSupportiveInfoToAttach : reviewPeriod.getSupportiveInfoCollection()) {
                supportiveInfoCollectionSupportiveInfoToAttach = em.getReference(supportiveInfoCollectionSupportiveInfoToAttach.getClass(), supportiveInfoCollectionSupportiveInfoToAttach.getSupportiveInfoPK());
                attachedSupportiveInfoCollection.add(supportiveInfoCollectionSupportiveInfoToAttach);
            }
            reviewPeriod.setSupportiveInfoCollection(attachedSupportiveInfoCollection);
            em.persist(reviewPeriod);
            for (TalentReviewScore talentReviewScoreCollectionTalentReviewScore : reviewPeriod.getTalentReviewScoreCollection()) {
                ReviewPeriod oldReviewPeriod1OfTalentReviewScoreCollectionTalentReviewScore = talentReviewScoreCollectionTalentReviewScore.getReviewPeriod1();
                talentReviewScoreCollectionTalentReviewScore.setReviewPeriod1(reviewPeriod);
                talentReviewScoreCollectionTalentReviewScore = em.merge(talentReviewScoreCollectionTalentReviewScore);
                if (oldReviewPeriod1OfTalentReviewScoreCollectionTalentReviewScore != null) {
                    oldReviewPeriod1OfTalentReviewScoreCollectionTalentReviewScore.getTalentReviewScoreCollection().remove(talentReviewScoreCollectionTalentReviewScore);
                    oldReviewPeriod1OfTalentReviewScoreCollectionTalentReviewScore = em.merge(oldReviewPeriod1OfTalentReviewScoreCollectionTalentReviewScore);
                }
            }
            for (SupportiveInfo supportiveInfoCollectionSupportiveInfo : reviewPeriod.getSupportiveInfoCollection()) {
                ReviewPeriod oldReviewPeriod1OfSupportiveInfoCollectionSupportiveInfo = supportiveInfoCollectionSupportiveInfo.getReviewPeriod1();
                supportiveInfoCollectionSupportiveInfo.setReviewPeriod1(reviewPeriod);
                supportiveInfoCollectionSupportiveInfo = em.merge(supportiveInfoCollectionSupportiveInfo);
                if (oldReviewPeriod1OfSupportiveInfoCollectionSupportiveInfo != null) {
                    oldReviewPeriod1OfSupportiveInfoCollectionSupportiveInfo.getSupportiveInfoCollection().remove(supportiveInfoCollectionSupportiveInfo);
                    oldReviewPeriod1OfSupportiveInfoCollectionSupportiveInfo = em.merge(oldReviewPeriod1OfSupportiveInfoCollectionSupportiveInfo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReviewPeriod(reviewPeriod.getReviewPeriod()) != null) {
                throw new PreexistingEntityException("ReviewPeriod " + reviewPeriod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReviewPeriod reviewPeriod) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ReviewPeriod persistentReviewPeriod = em.find(ReviewPeriod.class, reviewPeriod.getReviewPeriod());
            Collection<TalentReviewScore> talentReviewScoreCollectionOld = persistentReviewPeriod.getTalentReviewScoreCollection();
            Collection<TalentReviewScore> talentReviewScoreCollectionNew = reviewPeriod.getTalentReviewScoreCollection();
            Collection<SupportiveInfo> supportiveInfoCollectionOld = persistentReviewPeriod.getSupportiveInfoCollection();
            Collection<SupportiveInfo> supportiveInfoCollectionNew = reviewPeriod.getSupportiveInfoCollection();
            List<String> illegalOrphanMessages = null;
            for (TalentReviewScore talentReviewScoreCollectionOldTalentReviewScore : talentReviewScoreCollectionOld) {
                if (!talentReviewScoreCollectionNew.contains(talentReviewScoreCollectionOldTalentReviewScore)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TalentReviewScore " + talentReviewScoreCollectionOldTalentReviewScore + " since its reviewPeriod1 field is not nullable.");
                }
            }
            for (SupportiveInfo supportiveInfoCollectionOldSupportiveInfo : supportiveInfoCollectionOld) {
                if (!supportiveInfoCollectionNew.contains(supportiveInfoCollectionOldSupportiveInfo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SupportiveInfo " + supportiveInfoCollectionOldSupportiveInfo + " since its reviewPeriod1 field is not nullable.");
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
            reviewPeriod.setTalentReviewScoreCollection(talentReviewScoreCollectionNew);
            Collection<SupportiveInfo> attachedSupportiveInfoCollectionNew = new ArrayList<SupportiveInfo>();
            for (SupportiveInfo supportiveInfoCollectionNewSupportiveInfoToAttach : supportiveInfoCollectionNew) {
                supportiveInfoCollectionNewSupportiveInfoToAttach = em.getReference(supportiveInfoCollectionNewSupportiveInfoToAttach.getClass(), supportiveInfoCollectionNewSupportiveInfoToAttach.getSupportiveInfoPK());
                attachedSupportiveInfoCollectionNew.add(supportiveInfoCollectionNewSupportiveInfoToAttach);
            }
            supportiveInfoCollectionNew = attachedSupportiveInfoCollectionNew;
            reviewPeriod.setSupportiveInfoCollection(supportiveInfoCollectionNew);
            reviewPeriod = em.merge(reviewPeriod);
            for (TalentReviewScore talentReviewScoreCollectionNewTalentReviewScore : talentReviewScoreCollectionNew) {
                if (!talentReviewScoreCollectionOld.contains(talentReviewScoreCollectionNewTalentReviewScore)) {
                    ReviewPeriod oldReviewPeriod1OfTalentReviewScoreCollectionNewTalentReviewScore = talentReviewScoreCollectionNewTalentReviewScore.getReviewPeriod1();
                    talentReviewScoreCollectionNewTalentReviewScore.setReviewPeriod1(reviewPeriod);
                    talentReviewScoreCollectionNewTalentReviewScore = em.merge(talentReviewScoreCollectionNewTalentReviewScore);
                    if (oldReviewPeriod1OfTalentReviewScoreCollectionNewTalentReviewScore != null && !oldReviewPeriod1OfTalentReviewScoreCollectionNewTalentReviewScore.equals(reviewPeriod)) {
                        oldReviewPeriod1OfTalentReviewScoreCollectionNewTalentReviewScore.getTalentReviewScoreCollection().remove(talentReviewScoreCollectionNewTalentReviewScore);
                        oldReviewPeriod1OfTalentReviewScoreCollectionNewTalentReviewScore = em.merge(oldReviewPeriod1OfTalentReviewScoreCollectionNewTalentReviewScore);
                    }
                }
            }
            for (SupportiveInfo supportiveInfoCollectionNewSupportiveInfo : supportiveInfoCollectionNew) {
                if (!supportiveInfoCollectionOld.contains(supportiveInfoCollectionNewSupportiveInfo)) {
                    ReviewPeriod oldReviewPeriod1OfSupportiveInfoCollectionNewSupportiveInfo = supportiveInfoCollectionNewSupportiveInfo.getReviewPeriod1();
                    supportiveInfoCollectionNewSupportiveInfo.setReviewPeriod1(reviewPeriod);
                    supportiveInfoCollectionNewSupportiveInfo = em.merge(supportiveInfoCollectionNewSupportiveInfo);
                    if (oldReviewPeriod1OfSupportiveInfoCollectionNewSupportiveInfo != null && !oldReviewPeriod1OfSupportiveInfoCollectionNewSupportiveInfo.equals(reviewPeriod)) {
                        oldReviewPeriod1OfSupportiveInfoCollectionNewSupportiveInfo.getSupportiveInfoCollection().remove(supportiveInfoCollectionNewSupportiveInfo);
                        oldReviewPeriod1OfSupportiveInfoCollectionNewSupportiveInfo = em.merge(oldReviewPeriod1OfSupportiveInfoCollectionNewSupportiveInfo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = reviewPeriod.getReviewPeriod();
                if (findReviewPeriod(id) == null) {
                    throw new NonexistentEntityException("The reviewPeriod with id " + id + " no longer exists.");
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
            ReviewPeriod reviewPeriod;
            try {
                reviewPeriod = em.getReference(ReviewPeriod.class, id);
                reviewPeriod.getReviewPeriod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reviewPeriod with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<TalentReviewScore> talentReviewScoreCollectionOrphanCheck = reviewPeriod.getTalentReviewScoreCollection();
            for (TalentReviewScore talentReviewScoreCollectionOrphanCheckTalentReviewScore : talentReviewScoreCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ReviewPeriod (" + reviewPeriod + ") cannot be destroyed since the TalentReviewScore " + talentReviewScoreCollectionOrphanCheckTalentReviewScore + " in its talentReviewScoreCollection field has a non-nullable reviewPeriod1 field.");
            }
            Collection<SupportiveInfo> supportiveInfoCollectionOrphanCheck = reviewPeriod.getSupportiveInfoCollection();
            for (SupportiveInfo supportiveInfoCollectionOrphanCheckSupportiveInfo : supportiveInfoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ReviewPeriod (" + reviewPeriod + ") cannot be destroyed since the SupportiveInfo " + supportiveInfoCollectionOrphanCheckSupportiveInfo + " in its supportiveInfoCollection field has a non-nullable reviewPeriod1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(reviewPeriod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReviewPeriod> findReviewPeriodEntities() {
        return findReviewPeriodEntities(true, -1, -1);
    }

    public List<ReviewPeriod> findReviewPeriodEntities(int maxResults, int firstResult) {
        return findReviewPeriodEntities(false, maxResults, firstResult);
    }

    private List<ReviewPeriod> findReviewPeriodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReviewPeriod.class));
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

    public ReviewPeriod findReviewPeriod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReviewPeriod.class, id);
        } finally {
            em.close();
        }
    }

    public int getReviewPeriodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReviewPeriod> rt = cq.from(ReviewPeriod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
