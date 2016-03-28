/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public class Group implements Serializable{
    private String reviewname;
    private List<Employee> emp;

    /**
     * @return the reviewname
     */
    public String getReviewname() {
        return reviewname;
    }

    /**
     * @param reviewname the reviewname to set
     */
    public void setReviewname(String reviewname) {
        this.reviewname = reviewname;
    }

    /**
     * @return the emp
     */
    public List<Employee> getEmp() {
        return emp;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }


    
    
}
