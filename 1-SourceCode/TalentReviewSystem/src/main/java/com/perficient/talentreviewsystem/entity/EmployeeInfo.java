/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bootcamp19
 */
@Entity
@Table(name = "Employee_Info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeInfo.findAll", query = "SELECT e FROM EmployeeInfo e"),
    @NamedQuery(name = "EmployeeInfo.findByEmployeeId", query = "SELECT e FROM EmployeeInfo e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "EmployeeInfo.findByStartLevel", query = "SELECT e FROM EmployeeInfo e WHERE e.startLevel = :startLevel"),
    @NamedQuery(name = "EmployeeInfo.findByLastPromotionDate", query = "SELECT e FROM EmployeeInfo e WHERE e.lastPromotionDate = :lastPromotionDate"),
    @NamedQuery(name = "EmployeeInfo.findByGdcStartDate", query = "SELECT e FROM EmployeeInfo e WHERE e.gdcStartDate = :gdcStartDate"),
    @NamedQuery(name = "EmployeeInfo.findByWorkStartDate", query = "SELECT e FROM EmployeeInfo e WHERE e.workStartDate = :workStartDate"),
    @NamedQuery(name = "EmployeeInfo.findByDepartment", query = "SELECT e FROM EmployeeInfo e WHERE e.department = :department")})
public class EmployeeInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "employee_id")
    private String employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "start_level")
    private String startLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_promotion_date")
    private String lastPromotionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gdc_start_date")
    @Temporal(TemporalType.DATE)
    private Date gdcStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "work_start_date")
    @Temporal(TemporalType.DATE)
    private Date workStartDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "department")
    private String department;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeInfo")
    private Collection<SupportiveInfo> supportiveInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeInfo")
    private Collection<TalentReviewScore> talentReviewScoreCollection;

    public EmployeeInfo() {
    }

    public EmployeeInfo(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeInfo(String employeeId, String startLevel, String lastPromotionDate, Date gdcStartDate, Date workStartDate, String department) {
        this.employeeId = employeeId;
        this.startLevel = startLevel;
        this.lastPromotionDate = lastPromotionDate;
        this.gdcStartDate = gdcStartDate;
        this.workStartDate = workStartDate;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(String startLevel) {
        this.startLevel = startLevel;
    }

    public String getLastPromotionDate() {
        return lastPromotionDate;
    }

    public void setLastPromotionDate(String lastPromotionDate) {
        this.lastPromotionDate = lastPromotionDate;
    }

    public Date getGdcStartDate() {
        return gdcStartDate;
    }

    public void setGdcStartDate(Date gdcStartDate) {
        this.gdcStartDate = gdcStartDate;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @XmlTransient
    public Collection<SupportiveInfo> getSupportiveInfoCollection() {
        return supportiveInfoCollection;
    }

    public void setSupportiveInfoCollection(Collection<SupportiveInfo> supportiveInfoCollection) {
        this.supportiveInfoCollection = supportiveInfoCollection;
    }

    @XmlTransient
    public Collection<TalentReviewScore> getTalentReviewScoreCollection() {
        return talentReviewScoreCollection;
    }

    public void setTalentReviewScoreCollection(Collection<TalentReviewScore> talentReviewScoreCollection) {
        this.talentReviewScoreCollection = talentReviewScoreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeInfo)) {
            return false;
        }
        EmployeeInfo other = (EmployeeInfo) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.EmployeeInfo[ employeeId=" + employeeId + " ]";
    }
    
}
