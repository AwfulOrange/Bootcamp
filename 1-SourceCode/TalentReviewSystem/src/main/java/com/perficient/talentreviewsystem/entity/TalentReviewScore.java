/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bootcamp19
 */
@Entity
@Table(name = "Talent_Review_Score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TalentReviewScore.findAll", query = "SELECT t FROM TalentReviewScore t"),
    @NamedQuery(name = "TalentReviewScore.findByEmployeeId", query = "SELECT t FROM TalentReviewScore t WHERE t.talentReviewScorePK.employeeId = :employeeId"),
    @NamedQuery(name = "TalentReviewScore.findByAchievingResults", query = "SELECT t FROM TalentReviewScore t WHERE t.achievingResults = :achievingResults"),
    @NamedQuery(name = "TalentReviewScore.findByOrgImpact", query = "SELECT t FROM TalentReviewScore t WHERE t.orgImpact = :orgImpact"),
    @NamedQuery(name = "TalentReviewScore.findByLearningAgility", query = "SELECT t FROM TalentReviewScore t WHERE t.learningAgility = :learningAgility"),
    @NamedQuery(name = "TalentReviewScore.findByVersatility", query = "SELECT t FROM TalentReviewScore t WHERE t.versatility = :versatility"),
    @NamedQuery(name = "TalentReviewScore.findByAchievingResultsComment", query = "SELECT t FROM TalentReviewScore t WHERE t.achievingResultsComment = :achievingResultsComment"),
    @NamedQuery(name = "TalentReviewScore.findByOrgImpactComment", query = "SELECT t FROM TalentReviewScore t WHERE t.orgImpactComment = :orgImpactComment"),
    @NamedQuery(name = "TalentReviewScore.findByLearningAgilityComment", query = "SELECT t FROM TalentReviewScore t WHERE t.learningAgilityComment = :learningAgilityComment"),
    @NamedQuery(name = "TalentReviewScore.findByVersatilityComment", query = "SELECT t FROM TalentReviewScore t WHERE t.versatilityComment = :versatilityComment"),
    @NamedQuery(name = "TalentReviewScore.findByReviewPeriod", query = "SELECT t FROM TalentReviewScore t WHERE t.talentReviewScorePK.reviewPeriod = :reviewPeriod")})
public class TalentReviewScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TalentReviewScorePK talentReviewScorePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "achieving_results")
    private int achievingResults;
    @Basic(optional = false)
    @NotNull
    @Column(name = "org_impact")
    private int orgImpact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "learning _agility")
    private int learningAgility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "versatility")
    private int versatility;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "achieving_results_comment")
    private String achievingResultsComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "org_impact_comment")
    private String orgImpactComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "learning _agility_comment")
    private String learningAgilityComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "versatility_comment")
    private String versatilityComment;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeInfo employeeInfo;
    @JoinColumn(name = "review_period", referencedColumnName = "review_period", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReviewPeriod reviewPeriod1;

    public TalentReviewScore() {
    }

    public TalentReviewScore(TalentReviewScorePK talentReviewScorePK) {
        this.talentReviewScorePK = talentReviewScorePK;
    }

    public TalentReviewScore(TalentReviewScorePK talentReviewScorePK, int achievingResults, int orgImpact, int learningAgility, int versatility, String achievingResultsComment, String orgImpactComment, String learningAgilityComment, String versatilityComment) {
        this.talentReviewScorePK = talentReviewScorePK;
        this.achievingResults = achievingResults;
        this.orgImpact = orgImpact;
        this.learningAgility = learningAgility;
        this.versatility = versatility;
        this.achievingResultsComment = achievingResultsComment;
        this.orgImpactComment = orgImpactComment;
        this.learningAgilityComment = learningAgilityComment;
        this.versatilityComment = versatilityComment;
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

    public int getAchievingResults() {
        return achievingResults;
    }

    public void setAchievingResults(int achievingResults) {
        this.achievingResults = achievingResults;
    }

    public int getOrgImpact() {
        return orgImpact;
    }

    public void setOrgImpact(int orgImpact) {
        this.orgImpact = orgImpact;
    }

    public int getLearningAgility() {
        return learningAgility;
    }

    public void setLearningAgility(int learningAgility) {
        this.learningAgility = learningAgility;
    }

    public int getVersatility() {
        return versatility;
    }

    public void setVersatility(int versatility) {
        this.versatility = versatility;
    }

    public String getAchievingResultsComment() {
        return achievingResultsComment;
    }

    public void setAchievingResultsComment(String achievingResultsComment) {
        this.achievingResultsComment = achievingResultsComment;
    }

    public String getOrgImpactComment() {
        return orgImpactComment;
    }

    public void setOrgImpactComment(String orgImpactComment) {
        this.orgImpactComment = orgImpactComment;
    }

    public String getLearningAgilityComment() {
        return learningAgilityComment;
    }

    public void setLearningAgilityComment(String learningAgilityComment) {
        this.learningAgilityComment = learningAgilityComment;
    }

    public String getVersatilityComment() {
        return versatilityComment;
    }

    public void setVersatilityComment(String versatilityComment) {
        this.versatilityComment = versatilityComment;
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
    
}
