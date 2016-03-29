/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import java.util.List;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.daoimpl.CriteriaDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.Criteria;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.Group;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import com.perficient.talentreviewsystem.utils.DateUtils;
import com.perficient.talentreviewsystem.utils.GetProperty;
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

    @Override
    public List<Employee> findAll() {
        List<EmployeeInfo> empInfoList = empDAO.selectAllEmployeeInfo();
        
        String empsInfo = HttpConnection.getFromUrl(new GetProperty().getString("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        
        List<Employee> empListSelected = new ArrayList<>();
        empList=selectActiveEmployee(empList);
        empListSelected.add(empList.get(0));
        empListSelected.add(empList.get(1));
        empListSelected.add(empList.get(2));
        
        combineTPTandDataBase(empInfoList, empListSelected);
        
        return empListSelected;
    } 
    private List<Employee> selectActiveEmployee(List<Employee> allemp){
        List<Employee> ActiveEmployee = new ArrayList<>();
        for(int i=0;i<allemp.size();i++)
            if(allemp.get(i).isActive()){
                ActiveEmployee.add(allemp.get(i));
                
            }
        return ActiveEmployee;
    }
    private String findEmpNameById(String id,List<Employee> allemp){
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
        String empsInfo = HttpConnection.getFromUrl(new GetProperty().getString("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        empList=selectActiveEmployee(empList);    
 
        List<TalentReviewScore> talentReviewScores=trsDAO.selectTRScoreByReviewerId(reviewerid);
        List<Employee> emp=mergeScoreAndEmployee(talentReviewScores,empList);
   
        return emp;
    }
    
    @Override
    public List<Group> findAllByPMOID(String pmoid) {
        List<String> reviewerID=trsDAO.selectreviewerByPmoId(pmoid);
        String empsInfo = HttpConnection.getFromUrl(new GetProperty().getString("tptPath"));
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

    
    private List<Employee> mergeScoreAndEmployee(List<TalentReviewScore> score, List<Employee> empList){
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

    private void combineTPTandDataBase(List<EmployeeInfo> empInfoList, List<Employee> empListSelected) {
        for(int j=0 ;j<empListSelected.size(); j++){
            for(int i=0; i<empInfoList.size(); i++){
                if(empInfoList.get(i).getEmployeeId().equals(empListSelected.get(j).getId())){
                    EmployeeInfo ei = empInfoList.get(i);
                    Employee e = empListSelected.get(j);
                    e.setDepartment(ei.getDepartment());
                    e.setWorkStartDate(DateUtils.calcuDate(e.getWorkStartDate()));
                    e.setGdcStartDate(DateUtils.calcuDate(Long.toString(ei.getGdcStartDate().getTime())));
                    e.setLastPromotionDate(DateUtils.formatDate(ei.getLastPromotionDate()));
                    e.setStartLevel(ei.getStartLevel());
                    e.setSupportiveInfoCollection(ei.getSupportiveInfoCollection());
                    e.setLastDay(DateUtils.toDate(e.getLastDay()));
                    List<Criteria> listCri = criDAO.getCriteriaByLevel(e.getTitle());
                    e.setListCriteria(listCri);
                    
                }
            } 
        }
    }
    
}
