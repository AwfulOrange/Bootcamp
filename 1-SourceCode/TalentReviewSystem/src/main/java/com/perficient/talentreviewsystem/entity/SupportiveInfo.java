/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bootcamp19
 */
@Entity
@Table(name = "supportive_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupportiveInfo.findAll", query = "SELECT s FROM SupportiveInfo s"),
    @NamedQuery(name = "SupportiveInfo.findByActivity", query = "SELECT s FROM SupportiveInfo s WHERE s.activity = :activity"),
    @NamedQuery(name = "SupportiveInfo.findByAward", query = "SELECT s FROM SupportiveInfo s WHERE s.award = :award"),
    @NamedQuery(name = "SupportiveInfo.findByBlog", query = "SELECT s FROM SupportiveInfo s WHERE s.blog = :blog"),
    @NamedQuery(name = "SupportiveInfo.findByCertification", query = "SELECT s FROM SupportiveInfo s WHERE s.certification = :certification"),
    @NamedQuery(name = "SupportiveInfo.findByCoe", query = "SELECT s FROM SupportiveInfo s WHERE s.coe = :coe"),
    @NamedQuery(name = "SupportiveInfo.findByCulture", query = "SELECT s FROM SupportiveInfo s WHERE s.culture = :culture"),
    @NamedQuery(name = "SupportiveInfo.findByRecruting", query = "SELECT s FROM SupportiveInfo s WHERE s.recruting = :recruting"),
    @NamedQuery(name = "SupportiveInfo.findByTimeEntry", query = "SELECT s FROM SupportiveInfo s WHERE s.timeEntry = :timeEntry"),
    @NamedQuery(name = "SupportiveInfo.findByTraining", query = "SELECT s FROM SupportiveInfo s WHERE s.training = :training"),
    @NamedQuery(name = "SupportiveInfo.findByEmployeeId", query = "SELECT s FROM SupportiveInfo s WHERE s.supportiveInfoPK.employeeId = :employeeId"),
    @NamedQuery(name = "SupportiveInfo.findByReviewPeriod", query = "SELECT s FROM SupportiveInfo s WHERE s.supportiveInfoPK.reviewPeriod = :reviewPeriod")})
public class SupportiveInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupportiveInfoPK supportiveInfoPK;
    @Size(max = 255)
    @Column(name = "activity")
    private String activity;
    @Size(max = 255)
    @Column(name = "award")
    private String award;
    @Size(max = 255)
    @Column(name = "blog")
    private String blog;
    @Size(max = 255)
    @Column(name = "certification")
    private String certification;
    @Size(max = 255)
    @Column(name = "coe")
    private String coe;
    @Size(max = 255)
    @Column(name = "culture")
    private String culture;
    @Size(max = 255)
    @Column(name = "recruting")
    private String recruting;
    @Size(max = 255)
    @Column(name = "time_entry")
    private String timeEntry;
    @Size(max = 255)
    @Column(name = "training")
    private String training;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeInfo employeeInfo;
    @JoinColumn(name = "review_period", referencedColumnName = "review_period", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReviewPeriod reviewPeriod1;

    public SupportiveInfo() {
    }

    public SupportiveInfo(SupportiveInfoPK supportiveInfoPK) {
        this.supportiveInfoPK = supportiveInfoPK;
    }

    public SupportiveInfo(String employeeId, String reviewPeriod) {
        this.supportiveInfoPK = new SupportiveInfoPK(employeeId, reviewPeriod);
    }

    public SupportiveInfoPK getSupportiveInfoPK() {
        return supportiveInfoPK;
    }

    public void setSupportiveInfoPK(SupportiveInfoPK supportiveInfoPK) {
        this.supportiveInfoPK = supportiveInfoPK;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCoe() {
        return coe;
    }

    public void setCoe(String coe) {
        this.coe = coe;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getRecruting() {
        return recruting;
    }

    public void setRecruting(String recruting) {
        this.recruting = recruting;
    }

    public String getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(String timeEntry) {
        this.timeEntry = timeEntry;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
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
        hash += (supportiveInfoPK != null ? supportiveInfoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupportiveInfo)) {
            return false;
        }
        SupportiveInfo other = (SupportiveInfo) object;
        if ((this.supportiveInfoPK == null && other.supportiveInfoPK != null) || (this.supportiveInfoPK != null && !this.supportiveInfoPK.equals(other.supportiveInfoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.SupportiveInfo[ supportiveInfoPK=" + supportiveInfoPK + " ]";
    }
    
}
