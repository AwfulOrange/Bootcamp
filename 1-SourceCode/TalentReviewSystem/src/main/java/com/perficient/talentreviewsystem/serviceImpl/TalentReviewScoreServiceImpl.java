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
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.service.ITalentReviewScoreService;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public class TalentReviewScoreServiceImpl implements ITalentReviewScoreService{
    private ITalentReviewScoreDAO trsDao = new TalentReviewScoreDAOImpl();
    private IEmployeeInfoDAO employeeInfoDao = new EmployeeInfoDAOImpl();
    
    
    @Override
    public int add(String jsonStr) {
        ReviewPeriod rp = new ReviewPeriodDAOImpl().selectReviewPeriodByRP("201503");
        
        List<TalentReviewScore> trScore = JSON.parseArray(jsonStr, TalentReviewScore.class);
        int status = 0;
        status = cycleInsert(trScore, rp, status);
        return status;
    }

    private int cycleInsert(List<TalentReviewScore> trScore, ReviewPeriod rp, int status) {
        for(int i=0;i<trScore.size();i++){
            EmployeeInfo emp = employeeInfoDao.selectEmployeeInfoById(trScore.get(i).getEmployeeId());

            trScore.get(i).setReviewPeriod1(rp);
            trScore.get(i).setEmployeeInfo(emp); 
            
            TalentReviewScore trs = trsDao.selectSingleByBoth(trScore.get(i).getEmployeeId(), rp.getReviewPeriod());
            if(trs == null){
                status = trsDao.addTalentReviewScore(trScore.get(i));
            } else {
                trScore.get(i).setTalentReviewScorePK(trs.getTalentReviewScorePK());
                status = trsDao.updateTalentReviewScore(trScore.get(i));
            }
        }
        return status;
    }
 
}
