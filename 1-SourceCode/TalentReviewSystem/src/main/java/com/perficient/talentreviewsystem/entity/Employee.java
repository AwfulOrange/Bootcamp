/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author bootcamp19
 */
public class Employee implements Serializable {

    private String id;
    private String type;
    private String role;
    private String title;
    private boolean active;
    private String firstName;
    private String lastName;
    private String screenName;
    private String gender;
    private String emid;
    private String lastUpdated;
    private String onBoardDate;
    private String photoURL;
    private String bu;
    private String workStartDate;
    private String workExperience;
    private String lineManager;
    private String lastDay;
    private String status;
    private String department;
    private String gdcStartDate;
    private String gdcExperience;
    private String lastPromotionDate;
    private String startLevel;
    private String reviewername;
    private String titlebre;
    private Collection<SupportiveInfo> supportiveInfoCollection;
    private TalentReviewScore Score;
    private int ar;
    private int oi;
    private int la;
    private int ver;
    private int performance;
    private int potential;
    private int total;
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the screenName
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * @param screenName the screenName to set
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the emid
     */
    public String getEmid() {
        return emid;
    }

    /**
     * @param emid the emid to set
     */
    public void setEmid(String emid) {
        this.emid = emid;
    }

    /**
     * @return the lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the onBoardDate
     */
    public String getOnBoardDate() {
        return onBoardDate;
    }

    /**
     * @param onBoardDate the onBoardDate to set
     */
    public void setOnBoardDate(String onBoardDate) {
        this.onBoardDate = onBoardDate;
    }

    /**
     * @return the photoURL
     */
    public String getPhotoURL() {
        return photoURL;
    }

    /**
     * @param photoURL the photoURL to set
     */
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    /**
     * @return the bu
     */
    public String getBu() {
        return bu;
    }

    /**
     * @param bu the bu to set
     */
    public void setBu(String bu) {
        this.bu = bu;
    }

    /**
     * @return the workStartDate
     */
    public String getWorkStartDate() {
        return workStartDate;
    }

    /**
     * @param workStartDate the workStartDate to set
     */
    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    /**
     * @return the lineManager
     */
    public String getLineManager() {
        return lineManager;
    }

    /**
     * @param lineManager the lineManager to set
     */
    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    /**
     * @return the lastDay
     */
    public String getLastDay() {
        return lastDay;
    }

    /**
     * @param lastDay the lastDay to set
     */
    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the gdcStartDate
     */
    public String getGdcStartDate() {
        return gdcStartDate;
    }

    /**
     * @param gdcStartDate the gdcStartDate to set
     */
    public void setGdcStartDate(String gdcStartDate) {
        this.gdcStartDate = gdcStartDate;
    }

    /**
     * @return the lastPromotionDate
     */
    public String getLastPromotionDate() {
        return lastPromotionDate;
    }

    /**
     * @param lastPromotionDate the lastPromotionDate to set
     */
    public void setLastPromotionDate(String lastPromotionDate) {
        this.lastPromotionDate = lastPromotionDate;
    }

    /**
     * @return the startLevel
     */
    public String getStartLevel() {
        return startLevel;
    }

    /**
     * @param startLevel the startLevel to set
     */
    public void setStartLevel(String startLevel) {
        this.startLevel = startLevel;
    }


    /**
     * @return the supportiveInfoCollection
     */
    public Collection<SupportiveInfo> getSupportiveInfoCollection() {
        return supportiveInfoCollection;
    }

    /**
     * @param supportiveInfoCollection the supportiveInfoCollection to set
     */
    public void setSupportiveInfoCollection(Collection<SupportiveInfo> supportiveInfoCollection) {
        this.supportiveInfoCollection = supportiveInfoCollection;
    }

    /**
     * @return the Score
     */
    public TalentReviewScore getScore() {
        return Score;
    }

    /**
     * @param score the Score to set
     */
    public void setScore(TalentReviewScore score) {
        this.Score = score;
    }

    /**
     * @return the workExperience
     */
    public String getWorkExperience() {
        return workExperience;
    }

    /**
     * @param workExperience the workExperience to set
     */
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    /**
     * @return the gdcExperience
     */
    public String getGdcExperience() {
        return gdcExperience;
    }

    /**
     * @param gdcExperience the gdcExperience to set
     */
    public void setGdcExperience(String gdcExperience) {
        this.gdcExperience = gdcExperience;
    }

    /**
     * @return the performance
     */
    public int getPerformance() {
        return performance;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(int performance) {
        this.performance = performance;
    }

    /**
     * @return the potential
     */
    public int getPotential() {
        return potential;
    }

    /**
     * @param potential the potential to set
     */
    public void setPotential(int potential) {
        this.potential = potential;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the reviewername
     */
    public String getReviewername() {
        return reviewername;
    }

    /**
     * @param reviewername the reviewername to set
     */
    public void setReviewername(String reviewername) {
        this.reviewername = reviewername;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param ar the ar to set
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * @param oi the oi to set
     */
    public void setOi(int oi) {
        this.oi = oi;
    }

    /**
     * @param la the la to set
     */
    public void setLa(int la) {
        this.la = la;
    }

    /**
     * @param ver the ver to set
     */
    public void setVer(int ver) {
        this.ver = ver;
    }

    /**
     * @return the ar
     */
    public int getAr() {
        return ar;
    }

    /**
     * @return the oi
     */
    public int getOi() {
        return oi;
    }

    /**
     * @return the la
     */
    public int getLa() {
        return la;
    }

    /**
     * @return the ver
     */
    public int getVer() {
        return ver;
    }

    /**
     * @return the titlebre
     */
    public String getTitlebre() {
        return titlebre;
    }

    /**
     * @param titlebre the titlebre to set
     */
    public void setTitlebre(String titlebre) {
        this.titlebre = titlebre;
    }


}
