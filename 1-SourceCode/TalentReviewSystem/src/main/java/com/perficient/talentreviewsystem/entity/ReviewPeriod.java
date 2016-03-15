/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import com.alibaba.fastjson.annotation.JSONField;
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
@Table(name = "review_period")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewPeriod.findAll", query = "SELECT r FROM ReviewPeriod r"),
    @NamedQuery(name = "ReviewPeriod.findByReviewPeriod", query = "SELECT r FROM ReviewPeriod r WHERE r.reviewPeriod = :reviewPeriod"),
    @NamedQuery(name = "ReviewPeriod.findById", query = "SELECT r FROM ReviewPeriod r WHERE r.id = :id")})
public class ReviewPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "review_period")
    private String reviewPeriod;
    @Column(name = "id")
    private Integer id;
    @JSONField(serialize=false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewPeriod1")
    private Collection<TalentReviewScore> talentReviewScoreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewPeriod1")
    @JSONField(serialize=false)
    private Collection<SupportiveInfo> supportiveInfoCollection;

    public ReviewPeriod() {
    }

    public ReviewPeriod(String reviewPeriod) {
        this.reviewPeriod = reviewPeriod;
    }

    public String getReviewPeriod() {
        return reviewPeriod;
    }

    public void setReviewPeriod(String reviewPeriod) {
        this.reviewPeriod = reviewPeriod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<TalentReviewScore> getTalentReviewScoreCollection() {
        return talentReviewScoreCollection;
    }

    public void setTalentReviewScoreCollection(Collection<TalentReviewScore> talentReviewScoreCollection) {
        this.talentReviewScoreCollection = talentReviewScoreCollection;
    }

    @XmlTransient
    public Collection<SupportiveInfo> getSupportiveInfoCollection() {
        return supportiveInfoCollection;
    }

    public void setSupportiveInfoCollection(Collection<SupportiveInfo> supportiveInfoCollection) {
        this.supportiveInfoCollection = supportiveInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewPeriod != null ? reviewPeriod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewPeriod)) {
            return false;
        }
        ReviewPeriod other = (ReviewPeriod) object;
        if ((this.reviewPeriod == null && other.reviewPeriod != null) || (this.reviewPeriod != null && !this.reviewPeriod.equals(other.reviewPeriod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.ReviewPeriod[ reviewPeriod=" + reviewPeriod + " ]";
    }
    
}
