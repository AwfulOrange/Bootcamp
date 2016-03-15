/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bootcamp19
 */
@Entity
@Table(name = "critical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Critical.findAll", query = "SELECT c FROM Critical c"),
    @NamedQuery(name = "Critical.findByCalId", query = "SELECT c FROM Critical c WHERE c.calId = :calId"),
    @NamedQuery(name = "Critical.findByCalType", query = "SELECT c FROM Critical c WHERE c.calType = :calType")})
public class Critical implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cal_id")
    private Integer calId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cal_type")
    private String calType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calId")
    private Collection<Rule> ruleCollection;

    public Critical() {
    }

    public Critical(Integer calId) {
        this.calId = calId;
    }

    public Critical(Integer calId, String calType) {
        this.calId = calId;
        this.calType = calType;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    @XmlTransient
    public Collection<Rule> getRuleCollection() {
        return ruleCollection;
    }

    public void setRuleCollection(Collection<Rule> ruleCollection) {
        this.ruleCollection = ruleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calId != null ? calId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Critical)) {
            return false;
        }
        Critical other = (Critical) object;
        if ((this.calId == null && other.calId != null) || (this.calId != null && !this.calId.equals(other.calId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.Critical[ calId=" + calId + " ]";
    }
    
}
