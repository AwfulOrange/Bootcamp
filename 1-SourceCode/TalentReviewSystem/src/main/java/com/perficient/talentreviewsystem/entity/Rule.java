/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r"),
    @NamedQuery(name = "Rule.findByRId", query = "SELECT r FROM Rule r WHERE r.rId = :rId"),
    @NamedQuery(name = "Rule.findByRContent", query = "SELECT r FROM Rule r WHERE r.rContent = :rContent")})
public class Rule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "r_id")
    private Integer rId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "r_content")
    private String rContent;
    @JoinColumn(name = "cal_id", referencedColumnName = "cal_id")
    @ManyToOne(optional = false)
    private Critical calId;

    public Rule() {
    }

    public Rule(Integer rId) {
        this.rId = rId;
    }

    public Rule(Integer rId, String rContent) {
        this.rId = rId;
        this.rContent = rContent;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRContent() {
        return rContent;
    }

    public void setRContent(String rContent) {
        this.rContent = rContent;
    }

    public Critical getCalId() {
        return calId;
    }

    public void setCalId(Critical calId) {
        this.calId = calId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.Rule[ rId=" + rId + " ]";
    }
    
}
