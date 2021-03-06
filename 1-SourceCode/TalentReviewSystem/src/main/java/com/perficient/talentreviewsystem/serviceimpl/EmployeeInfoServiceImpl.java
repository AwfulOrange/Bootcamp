/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import java.util.List;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.daoimpl.CriteriaDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.utils.Changetitle;
import static com.perficient.talentreviewsystem.utils.DateUtils.calcuDate;
import static com.perficient.talentreviewsystem.utils.DateUtils.toDate;
import com.perficient.talentreviewsystem.utils.GetProperties;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.util.ArrayList;

/**
 *
 * @author bootcamp19
 */
public class EmployeeInfoServiceImpl implements IEmployeeInfoService{
    ICriteriaDAO criDAO = new CriteriaDAOImpl();
    IEmployeeInfoDAO empDAO = new EmployeeInfoDAOImpl();
    ITalentReviewScoreDAO trsDAO=new TalentReviewScoreDAOImpl();

    private static List<Employee> selectActiveEmployee(List<Employee> allemp){
        List<Employee> activeEmployee = new ArrayList<>();
        for(int i=0;i<allemp.size();i++)
            if(allemp.get(i).isActive()){
                activeEmployee.add(allemp.get(i));
                
            }
        return activeEmployee;
    }
    private static String findEmpNameById(String id,List<Employee> allemp){
        String name="";
        for(int i=0;i<allemp.size();i++){
            if(allemp.get(i).getId().equalsIgnoreCase(id)){
                name=allemp.get(i).getScreenName();
                return name;
            }
        }
        return name;
    }
    @Override
    public List<Employee> findAllByReviewerID(String reviewerid) {
        String empsInfo = HttpConnection.getFromUrl(new GetProperties().getProperty("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        empList=selectActiveEmployee(empList);    
        String name=findEmpNameById(reviewerid,empList);
        List<TalentReviewScore> talentReviewScores=trsDAO.selectTRScoreByReviewerId(reviewerid);
        return mergeScoreAndEmployee(talentReviewScores,empList,name);
    }
    
    @Override
    public List<Employee> findAllByPMOID(String pmoid) {
        List<String> reviewerID=trsDAO.selectreviewerByPmoId(pmoid);
        String empsInfo = HttpConnection.getFromUrl(new GetProperties().getProperty("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        empList=selectActiveEmployee(empList);
         List<Employee> allempList=new ArrayList<>();
        for(int i=0;i<reviewerID.size();i++){
            List<TalentReviewScore> talentReviewScores=trsDAO.selectTRScoreByReviewerId(reviewerID.get(i));
            String name=findEmpNameById(reviewerID.get(i),empList);
            List<Employee> emp=mergeScoreAndEmployee(talentReviewScores,empList,name);
            allempList.addAll(emp);
        }     
        return allempList;
    }

    
    private static List<Employee> mergeScoreAndEmployee(List<TalentReviewScore> score, List<Employee> empList,String name){
        List<Employee> empListSelected =new ArrayList();
        for(int i=0;i<score.size();i++){
            Employee emp=new Employee();
            for(int j=0;j<empList.size();j++){
                if(empList.get(j).getId().equals(score.get(i).getEmployeeInfo().getEmployeeId())){
                emp=empList.get(j);
                emp.setScore(score.get(i));
                
                }
                
            }
            emp.setWorkExperience(calcuDate(emp.getWorkStartDate()));
            emp.setGdcExperience(calcuDate(emp.getOnBoardDate()));
            Long promotion=score.get(i).getEmployeeInfo().getLastPromotionDate().getTime();
            emp.setLastPromotionDate(toDate(Long.toString(promotion)));
            emp.setReviewername(name);
            emp.setStatus(score.get(i).getStatus());
            emp=copyScoreToEmp(emp,score.get(i));
            Changetitle.changeTitile(emp);
            empListSelected.add(emp);
        }
        
        return empListSelected;
    
    
    }

    public static Employee copyScoreToEmp(Employee emp,TalentReviewScore score){
        
        if(score.getAchievingResults()!=null){
            emp.setAr(score.getAchievingResults());
        }
        if(score.getOrgImpact()!=null){
            emp.setOi(score.getOrgImpact());
        }
        if(score.getLearningAgility()!=null){
            emp.setLa(score.getLearningAgility());
        }
        if(score.getVersatility()!=null){
            emp.setVer(score.getVersatility());
        }
        int performance;
        if(score.getAchievingResults()!=null&&score.getOrgImpact()!=null){
            performance=score.getAchievingResults()+score.getOrgImpact();
            emp.setPerformance(performance);
            }
        else {
            performance=0;
        }
        int potential;
        if(score.getLearningAgility()!=null&&score.getVersatility()!=null){
            potential=score.getLearningAgility()+score.getVersatility();
            emp.setPotential(potential);
        }
        else{
            potential=0;
        }
        int total=performance+potential;
        emp.setTotal(total);
        return emp;
    }
}
