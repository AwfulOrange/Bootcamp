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
@Table(name = "infomation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Information.findAll", query = "SELECT i FROM Information i"),
    @NamedQuery(name = "Information.findByEmpId", query = "SELECT i FROM Information i WHERE i.empId = :empId"),
    @NamedQuery(name = "Information.findByEmpStartLevel", query = "SELECT i FROM Information i WHERE i.empStartLevel = :empStartLevel"),
    @NamedQuery(name = "Information.findByPerficientLevel", query = "SELECT i FROM Information i WHERE i.perficientLevel = :perficientLevel"),
    @NamedQuery(name = "Information.findByLastproDate", query = "SELECT i FROM Information i WHERE i.lastproDate = :lastproDate"),
    @NamedQuery(name = "Information.findByGdcworkingExp", query = "SELECT i FROM Information i WHERE i.gdcworkingExp = :gdcworkingExp"),
    @NamedQuery(name = "Information.findByTotalworkingExp", query = "SELECT i FROM Information i WHERE i.totalworkingExp = :totalworkingExp"),
    @NamedQuery(name = "Information.findByDepartment", query = "SELECT i FROM Information i WHERE i.department = :department"),
    @NamedQuery(name = "Information.findByAchieveresults", query = "SELECT i FROM Information i WHERE i.achieveresults = :achieveresults"),
    @NamedQuery(name = "Information.findByOrgimpact", query = "SELECT i FROM Information i WHERE i.orgimpact = :orgimpact"),
    @NamedQuery(name = "Information.findByLearningagility", query = "SELECT i FROM Information i WHERE i.learningagility = :learningagility"),
    @NamedQuery(name = "Information.findByVersatility", query = "SELECT i FROM Information i WHERE i.versatility = :versatility"),
    @NamedQuery(name = "Information.findByOrgComm", query = "SELECT i FROM Information i WHERE i.orgComm = :orgComm"),
    @NamedQuery(name = "Information.findByAchieveComm", query = "SELECT i FROM Information i WHERE i.achieveComm = :achieveComm"),
    @NamedQuery(name = "Information.findByLearningComm", query = "SELECT i FROM Information i WHERE i.learningComm = :learningComm"),
    @NamedQuery(name = "Information.findByVersatiComm", query = "SELECT i FROM Information i WHERE i.versatiComm = :versatiComm"),
    @NamedQuery(name = "Information.findByAward", query = "SELECT i FROM Information i WHERE i.award = :award"),
    @NamedQuery(name = "Information.findByTimeEntryComp", query = "SELECT i FROM Information i WHERE i.timeEntryComp = :timeEntryComp"),
    @NamedQuery(name = "Information.findByCompanyAct", query = "SELECT i FROM Information i WHERE i.companyAct = :companyAct"),
    @NamedQuery(name = "Information.findByCultureCom", query = "SELECT i FROM Information i WHERE i.cultureCom = :cultureCom"),
    @NamedQuery(name = "Information.findByTra", query = "SELECT i FROM Information i WHERE i.tra = :tra"),
    @NamedQuery(name = "Information.findByRecr", query = "SELECT i FROM Information i WHERE i.recr = :recr"),
    @NamedQuery(name = "Information.findByCerti", query = "SELECT i FROM Information i WHERE i.certi = :certi"),
    @NamedQuery(name = "Information.findByBlog", query = "SELECT i FROM Information i WHERE i.blog = :blog"),
    @NamedQuery(name = "Information.findByCoe", query = "SELECT i FROM Information i WHERE i.coe = :coe")})
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emp_id")
    private String empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emp_start_level")
    private String empStartLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "perficient_level")
    private String perficientLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lastpro_date")
    private String lastproDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "gdcworking_exp")
    private String gdcworkingExp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "totalworking_exp")
    private String totalworkingExp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @NotNull
    @Column(name = "achieveresults")
    private int achieveresults;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orgimpact")
    private int orgimpact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "learningagility")
    private int learningagility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "versatility")
    private int versatility;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "org_comm")
    private String orgComm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "achieve_comm")
    private String achieveComm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "learning_comm")
    private String learningComm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "versati_comm")
    private String versatiComm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "award")
    private int award;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "time_entry_comp")
    private String timeEntryComp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "company_act")
    private String companyAct;
    @Size(max = 20)
    @Column(name = "culture_com")
    private String cultureCom;
    @Size(max = 20)
    @Column(name = "tra")
    private String tra;
    @Size(max = 20)
    @Column(name = "recr")
    private String recr;
    @Size(max = 20)
    @Column(name = "certi")
    private String certi;
    @Size(max = 20)
    @Column(name = "blog")
    private String blog;
    @Size(max = 20)
    @Column(name = "coe")
    private String coe;

    public Information() {
    }

    public Information(String empId) {
        this.empId = empId;
    }

    public Information(String empId, String empStartLevel, String perficientLevel, String lastproDate, String gdcworkingExp, String totalworkingExp, String department, int achieveresults, int orgimpact, int learningagility, int versatility, String orgComm, String achieveComm, String learningComm, String versatiComm, int award, String timeEntryComp, String companyAct) {
        this.empId = empId;
        this.empStartLevel = empStartLevel;
        this.perficientLevel = perficientLevel;
        this.lastproDate = lastproDate;
        this.gdcworkingExp = gdcworkingExp;
        this.totalworkingExp = totalworkingExp;
        this.department = department;
        this.achieveresults = achieveresults;
        this.orgimpact = orgimpact;
        this.learningagility = learningagility;
        this.versatility = versatility;
        this.orgComm = orgComm;
        this.achieveComm = achieveComm;
        this.learningComm = learningComm;
        this.versatiComm = versatiComm;
        this.award = award;
        this.timeEntryComp = timeEntryComp;
        this.companyAct = companyAct;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpStartLevel() {
        return empStartLevel;
    }

    public void setEmpStartLevel(String empStartLevel) {
        this.empStartLevel = empStartLevel;
    }

    public String getPerficientLevel() {
        return perficientLevel;
    }

    public void setPerficientLevel(String perficientLevel) {
        this.perficientLevel = perficientLevel;
    }

    public String getLastproDate() {
        return lastproDate;
    }

    public void setLastproDate(String lastproDate) {
        this.lastproDate = lastproDate;
    }

    public String getGdcworkingExp() {
        return gdcworkingExp;
    }

    public void setGdcworkingExp(String gdcworkingExp) {
        this.gdcworkingExp = gdcworkingExp;
    }

    public String getTotalworkingExp() {
        return totalworkingExp;
    }

    public void setTotalworkingExp(String totalworkingExp) {
        this.totalworkingExp = totalworkingExp;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAchieveresults() {
        return achieveresults;
    }

    public void setAchieveresults(int achieveresults) {
        this.achieveresults = achieveresults;
    }

    public int getOrgimpact() {
        return orgimpact;
    }

    public void setOrgimpact(int orgimpact) {
        this.orgimpact = orgimpact;
    }

    public int getLearningagility() {
        return learningagility;
    }

    public void setLearningagility(int learningagility) {
        this.learningagility = learningagility;
    }

    public int getVersatility() {
        return versatility;
    }

    public void setVersatility(int versatility) {
        this.versatility = versatility;
    }

    public String getOrgComm() {
        return orgComm;
    }

    public void setOrgComm(String orgComm) {
        this.orgComm = orgComm;
    }

    public String getAchieveComm() {
        return achieveComm;
    }

    public void setAchieveComm(String achieveComm) {
        this.achieveComm = achieveComm;
    }

    public String getLearningComm() {
        return learningComm;
    }

    public void setLearningComm(String learningComm) {
        this.learningComm = learningComm;
    }

    public String getVersatiComm() {
        return versatiComm;
    }

    public void setVersatiComm(String versatiComm) {
        this.versatiComm = versatiComm;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public String getTimeEntryComp() {
        return timeEntryComp;
    }

    public void setTimeEntryComp(String timeEntryComp) {
        this.timeEntryComp = timeEntryComp;
    }

    public String getCompanyAct() {
        return companyAct;
    }

    public void setCompanyAct(String companyAct) {
        this.companyAct = companyAct;
    }

    public String getCultureCom() {
        return cultureCom;
    }

    public void setCultureCom(String cultureCom) {
        this.cultureCom = cultureCom;
    }

    public String getTra() {
        return tra;
    }

    public void setTra(String tra) {
        this.tra = tra;
    }

    public String getRecr() {
        return recr;
    }

    public void setRecr(String recr) {
        this.recr = recr;
    }

    public String getCerti() {
        return certi;
    }

    public void setCerti(String certi) {
        this.certi = certi;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCoe() {
        return coe;
    }

    public void setCoe(String coe) {
        this.coe = coe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Information)) {
            return false;
        }
        Information other = (Information) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perficient.talentreviewsystem.entity.Information[ empId=" + empId + " ]";
    }
    
}
