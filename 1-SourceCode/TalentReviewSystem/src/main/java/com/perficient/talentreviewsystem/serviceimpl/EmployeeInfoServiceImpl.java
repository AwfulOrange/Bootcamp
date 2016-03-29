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
import com.perficient.talentreviewsystem.entity.Group;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
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
        String name="www";
        for(int i=0;i<allemp.size();i++)
            if(allemp.get(i).getId().equalsIgnoreCase(id)){
                name=allemp.get(i).getScreenName();
                return name;
            }
        return name;
    }
    @Override
    public List<Employee> findAllByReviewerID(String reviewerid) {
        String empsInfo = HttpConnection.getFromUrl(new GetProperties().getProperty("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        empList=selectActiveEmployee(empList);    
 
        List<TalentReviewScore> talentReviewScores=trsDAO.selectTRScoreByReviewerId(reviewerid);
        return mergeScoreAndEmployee(talentReviewScores,empList);
    }
    
    @Override
    public List<Group> findAllByPMOID(String pmoid) {
        List<String> reviewerID=trsDAO.selectreviewerByPmoId(pmoid);
        String empsInfo = HttpConnection.getFromUrl(new GetProperties().getProperty("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        empList=selectActiveEmployee(empList);
        List<Group> group=new ArrayList<Group>();
        for(int i=0;i<reviewerID.size();i++){
            Group singleGroup=new Group();
            List<TalentReviewScore> talentReviewScores=trsDAO.selectTRScoreByReviewerId(reviewerID.get(i));
            List<Employee> emp=mergeScoreAndEmployee(talentReviewScores,empList);
            String name=findEmpNameById(reviewerID.get(i),empList);
            singleGroup.setEmp(emp);
            singleGroup.setReviewname(name);
            group.add(singleGroup);
        }     
        return group;
    }

    
    private static List<Employee> mergeScoreAndEmployee(List<TalentReviewScore> score, List<Employee> empList){
        List<Employee> empListSelected =new ArrayList();
        for(int i=0;i<score.size();i++){
            Employee emp=new Employee();
            for(int j=0;j<empList.size();j++){
                if(empList.get(j).getId().equals(score.get(i).getEmployeeInfo().getEmployeeId())){
                emp=empList.get(j);
                emp.setScore(score.get(i));
                }
            }
            empListSelected.add(emp);
        }
        
        return empListSelected;
    
    
    }

    
}
