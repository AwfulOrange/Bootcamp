/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao;

import com.perficient.talentreviewsystem.entity.Rp;

/**
 *
 * @author bootcamp19
 */
public interface IReviewPeriodDAO {

    public Rp selectReviewPeriodByRP(String rp);

    public String findMaxRp();

    public int addReviewPeriod(Rp rp);
    
    public int deleteReviewPeriod(String srp);
}
