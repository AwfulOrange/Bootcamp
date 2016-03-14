/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author bootcamp19
 */
@Embeddable
public class SupportiveInfoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "employee_id")
    private String employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "review_period")
    private String reviewPeriod;

    public SupportiveInfoPK() {
    }

    public SupportiveInfoPK(String employeeId, String reviewPeriod) {
        this.employeeId = employeeId;
        this.reviewPeriod = reviewPeriod;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getReviewPeriod() {
        return reviewPeriod;
    }

    public void setReviewPeriod(String reviewPeriod) {
        this.reviewPeriod = reviewPeriod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        hash += (reviewPeriod != null ? reviewPeriod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupportiveInfoPK)) {
            return false;
        }
        SupportiveInfoPK other = (SupportiveInfoPK) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        if ((this.reviewPeriod == null && other.reviewPeriod != null) || (this.reviewPeriod != null && !this.reviewPeriod.equals(other.reviewPeriod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.SupportiveInfoPK[ employeeId=" + employeeId + ", reviewPeriod=" + reviewPeriod + " ]";
    }
    
}
