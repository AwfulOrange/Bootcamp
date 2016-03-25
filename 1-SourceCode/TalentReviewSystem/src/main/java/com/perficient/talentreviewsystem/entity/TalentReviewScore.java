/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bootcamp19
 */
@Entity
@Table(name = "talent_review_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TalentReviewScore.findAll", query = "SELECT t FROM TalentReviewScore t"),
    @NamedQuery(name = "TalentReviewScore.findByAchievingResults", query = "SELECT t FROM TalentReviewScore t WHERE t.achievingResults = :achievingResults"),
    @NamedQuery(name = "TalentReviewScore.findByAchievingResultsComment", query = "SELECT t FROM TalentReviewScore t WHERE t.achievingResultsComment = :achievingResultsComment"),
    @NamedQuery(name = "TalentReviewScore.findByLearningAgility", query = "SELECT t FROM TalentReviewScore t WHERE t.learningAgility = :learningAgility"),
    @NamedQuery(name = "TalentReviewScore.findByLearningAgilityComment", query = "SELECT t FROM TalentReviewScore t WHERE t.learningAgilityComment = :learningAgilityComment"),
    @NamedQuery(name = "TalentReviewScore.findByOrgImpact", query = "SELECT t FROM TalentReviewScore t WHERE t.orgImpact = :orgImpact"),
    @NamedQuery(name = "TalentReviewScore.findByOrgImpactComment", query = "SELECT t FROM TalentReviewScore t WHERE t.orgImpactComment = :orgImpactComment"),
    @NamedQuery(name = "TalentReviewScore.findByVersatility", query = "SELECT t FROM TalentReviewScore t WHERE t.versatility = :versatility"),
    @NamedQuery(name = "TalentReviewScore.findByVersatilityComment", query = "SELECT t FROM TalentReviewScore t WHERE t.versatilityComment = :versatilityComment"),
    @NamedQuery(name = "TalentReviewScore.findByEmployeeId", query = "SELECT t FROM TalentReviewScore t WHERE t.talentReviewScorePK.employeeId = :employeeId"),
    @NamedQuery(name = "TalentReviewScore.findByReviewPeriod", query = "SELECT t FROM TalentReviewScore t WHERE t.talentReviewScorePK.reviewPeriod = :reviewPeriod"),
    @NamedQuery(name = "TalentReviewScore.findByStatus", query = "SELECT t FROM TalentReviewScore t WHERE t.status = :status"),
    @NamedQuery(name = "TalentReviewScore.findByReviewerId", query = "SELECT t FROM TalentReviewScore t WHERE t.reviewerId = :reviewerId"),
    @NamedQuery(name = "TalentReviewScore.findByPmoId", query = "SELECT t FROM TalentReviewScore t WHERE t.pmoId = :pmoId")})
public class TalentReviewScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TalentReviewScorePK talentReviewScorePK;
    @Column(name = "achieving_results")
    private Integer achievingResults;
    @Size(max = 255)
    @Column(name = "achieving_results_comment")
    private String achievingResultsComment;
    @Column(name = "learning_agility")
    private Integer learningAgility;
    @Size(max = 255)
    @Column(name = "learning_agility_comment")
    private String learningAgilityComment;
    @Column(name = "org_impact")
    private Integer orgImpact;
    @Size(max = 255)
    @Column(name = "org_impact_comment")
    private String orgImpactComment;
    @Column(name = "versatility")
    private Integer versatility;
    @Size(max = 255)
    @Column(name = "versatility_comment")
    private String versatilityComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Size(max = 255)
    @Column(name = "reviewer_id")
    private String reviewerId;
    @Size(max = 255)
    @Column(name = "pmo_id")
    private String pmoId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeInfo employeeInfo;
    @JoinColumn(name = "review_period", referencedColumnName = "review_period", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReviewPeriod reviewPeriod1;
    @Transient
    private String employeeId;

    public TalentReviewScore() {
    }

    public TalentReviewScore(TalentReviewScorePK talentReviewScorePK) {
        this.talentReviewScorePK = talentReviewScorePK;
    }

    public TalentReviewScore(TalentReviewScorePK talentReviewScorePK, int status) {
        this.talentReviewScorePK = talentReviewScorePK;
        this.status = status;
    }

    public TalentReviewScore(String employeeId, String reviewPeriod) {
        this.talentReviewScorePK = new TalentReviewScorePK(employeeId, reviewPeriod);
    }

    public TalentReviewScorePK getTalentReviewScorePK() {
        return talentReviewScorePK;
    }

    public void setTalentReviewScorePK(TalentReviewScorePK talentReviewScorePK) {
        this.talentReviewScorePK = talentReviewScorePK;
    }

    public Integer getAchievingResults() {
        return achievingResults;
    }

    public void setAchievingResults(Integer achievingResults) {
        this.achievingResults = achievingResults;
    }

    public String getAchievingResultsComment() {
        return achievingResultsComment;
    }

    public void setAchievingResultsComment(String achievingResultsComment) {
        this.achievingResultsComment = achievingResultsComment;
    }

    public Integer getLearningAgility() {
        return learningAgility;
    }

    public void setLearningAgility(Integer learningAgility) {
        this.learningAgility = learningAgility;
    }

    public String getLearningAgilityComment() {
        return learningAgilityComment;
    }

    public void setLearningAgilityComment(String learningAgilityComment) {
        this.learningAgilityComment = learningAgilityComment;
    }

    public Integer getOrgImpact() {
        return orgImpact;
    }

    public void setOrgImpact(Integer orgImpact) {
        this.orgImpact = orgImpact;
    }

    public String getOrgImpactComment() {
        return orgImpactComment;
    }

    public void setOrgImpactComment(String orgImpactComment) {
        this.orgImpactComment = orgImpactComment;
    }

    public Integer getVersatility() {
        return versatility;
    }

    public void setVersatility(Integer versatility) {
        this.versatility = versatility;
    }

    public String getVersatilityComment() {
        return versatilityComment;
    }

    public void setVersatilityComment(String versatilityComment) {
        this.versatilityComment = versatilityComment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getPmoId() {
        return pmoId;
    }

    public void setPmoId(String pmoId) {
        this.pmoId = pmoId;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public ReviewPeriod getReviewPeriod1() {
        return reviewPeriod1;
    }

    public void setReviewPeriod1(ReviewPeriod reviewPeriod1) {
        this.reviewPeriod1 = reviewPeriod1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talentReviewScorePK != null ? talentReviewScorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TalentReviewScore)) {
            return false;
        }
        TalentReviewScore other = (TalentReviewScore) object;
        if ((this.talentReviewScorePK == null && other.talentReviewScorePK != null) || (this.talentReviewScorePK != null && !this.talentReviewScorePK.equals(other.talentReviewScorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.TalentReviewScore[ talentReviewScorePK=" + talentReviewScorePK + " ]";
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
}
