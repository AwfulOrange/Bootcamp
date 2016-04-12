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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cri.findAll", query = "SELECT c FROM Cri c"),
    @NamedQuery(name = "Cri.findById", query = "SELECT c FROM Cri c WHERE c.id = :id"),
    @NamedQuery(name = "Cri.findByCriteria", query = "SELECT c FROM Cri c WHERE c.criteria = :criteria"),
    @NamedQuery(name = "Cri.findByLevel", query = "SELECT c FROM Cri c WHERE c.level = :level"),
    @NamedQuery(name = "Cri.findByRule", query = "SELECT c FROM Cri c WHERE c.rule = :rule"),
    @NamedQuery(name = "Cri.findByScore", query = "SELECT c FROM Cri c WHERE c.score = :score")})
public class Cri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "criteria")
    private String criteria;
    @Size(max = 500)
    @Column(name = "level")
    private String level;
    @Size(max = 10000)
    @Column(name = "rule")
    private String rule;
    @Column(name = "score")
    private Integer score;

    public Cri() {
    }

    public Cri(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cri)) {
            return false;
        }
        Cri other = (Cri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.Cri[ id=" + id + " ]";
    }
    
}
