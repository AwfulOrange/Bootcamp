/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

/**
 *
 * @author bootcamp19
 */
public class Score {

    private String employeeId;
    private Integer achievingresults;
    private Integer orgimpact;
    private Integer learningagility;
    private Integer versatility;

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the achievingresults
     */
    public Integer getAchievingresults() {
        return achievingresults;
    }

    /**
     * @param achievingresults the achievingresults to set
     */
    public void setAchievingresults(Integer achievingresults) {
        this.achievingresults = achievingresults;
    }

    /**
     * @return the orgimpact
     */
    public Integer getOrgimpact() {
        return orgimpact;
    }

    /**
     * @param orgimpact the orgimpact to set
     */
    public void setOrgimpact(Integer orgimpact) {
        this.orgimpact = orgimpact;
    }

    /**
     * @return the learningagility
     */
    public Integer getLearningagility() {
        return learningagility;
    }

    /**
     * @param learningagility the learningagility to set
     */
    public void setLearningagility(Integer learningagility) {
        this.learningagility = learningagility;
    }

    /**
     * @return the versatility
     */
    public Integer getVersatility() {
        return versatility;
    }

    /**
     * @param versatility the versatility to set
     */
    public void setVersatility(Integer versatility) {
        this.versatility = versatility;
    }

    @Override
    public String toString() {
        return "employeeId:"+employeeId+",achievingresults:"+achievingresults+",orgimpact:"+orgimpact+",learningagility:"+learningagility+",versatility:"+versatility;
    }
}
