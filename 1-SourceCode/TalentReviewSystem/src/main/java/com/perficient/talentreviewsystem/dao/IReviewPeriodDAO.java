/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao;

import com.perficient.talentreviewsystem.entity.ReviewPeriod;

/**
 *
 * @author bootcamp19
 */
public interface IReviewPeriodDAO {
    public ReviewPeriod selectReviePeriodByRP(String rp);
}