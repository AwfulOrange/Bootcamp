/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.daoImpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoImpl.ReviewPeriodDAOImpl;
import com.perficient.talentreviewsystem.daoImpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
import com.perficient.talentreviewsystem.entity.Score;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.service.ITalentReviewScoreService;

/**
 *
 * @author bootcamp19
 */
public class TalentReviewScoreServiceImpl implements ITalentReviewScoreService{

    
    
    @Override
    public int add(String jsonStr) {
        TalentReviewScore trScore = JSON.parseObject(jsonStr, TalentReviewScore.class);
        
        IEmployeeInfoDAO employeeInfoDao = new EmployeeInfoDAOImpl();
        EmployeeInfo emp = employeeInfoDao.selectEmployeeInfoById(trScore.getEmployeeId());

        ReviewPeriod rp = new ReviewPeriodDAOImpl().selectReviePeriodByRP("201503");
        trScore.setReviewPeriod1(rp);
        trScore.setEmployeeInfo(emp); 
        
        
        ITalentReviewScoreDAO trDao = new TalentReviewScoreDAOImpl();
        return trDao.addTalentReviewScore(trScore);
    }
    
    
}
