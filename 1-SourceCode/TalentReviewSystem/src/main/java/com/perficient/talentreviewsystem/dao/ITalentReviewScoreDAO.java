/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao;

import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public interface ITalentReviewScoreDAO {
    public int addTalentReviewScore(TalentReviewScore trs);
    public List<TalentReviewScore> selectAllTalentReviewScore();
    public TalentReviewScore selectSingleByBoth(String empId ,String rp);
    public int updateTalentReviewScore(TalentReviewScore talentReviewScore);
}
