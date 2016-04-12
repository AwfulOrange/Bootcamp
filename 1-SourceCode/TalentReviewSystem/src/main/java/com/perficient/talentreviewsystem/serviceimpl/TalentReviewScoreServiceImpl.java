/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.ReviewPeriodDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.entity.Rp;
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
    public int add(List<TalentReviewScore> scoreList) {
        Rp rp = new ReviewPeriodDAOImpl().selectReviewPeriodByRP("201503");
        
        return cycleInsert(scoreList, rp);
    }

    private int cycleInsert(List<TalentReviewScore> scoreList, Rp rp) {
        int status = 0;
        for(int i=0;i<scoreList.size();i++){
            EmployeeInfo emp = employeeInfoDao.selectEmployeeInfoById(scoreList.get(i).getEmployeeId());

            scoreList.get(i).setRp(rp);
            scoreList.get(i).setEmployeeInfo(emp); 
            TalentReviewScore trs = trsDao.selectSingleByBoth(scoreList.get(i).getEmployeeId(), rp.getReviewPeriod());
            if(trs == null){
                status = trsDao.addTalentReviewScore(scoreList.get(i));
            } else {
                scoreList.get(i).setTalentReviewScorePK(trs.getTalentReviewScorePK());
                status = trsDao.updateTalentReviewScore(scoreList.get(i));
            }
        }
        return status;
    }
}
