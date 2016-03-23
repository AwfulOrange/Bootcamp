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
import com.perficient.talentreviewsystem.daoimpl.CriteriaDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.entity.Criteria;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.utils.DateUtils;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.util.ArrayList;

/**
 *
 * @author bootcamp19
 */
public class EmployeeInfoServiceImpl implements IEmployeeInfoService{
    ICriteriaDAO criDAO = new CriteriaDAOImpl();
    IEmployeeInfoDAO empDAO = new EmployeeInfoDAOImpl();

    @Override
    public List<Employee> findAll() {
        List<EmployeeInfo> empInfoList = empDAO.selectAllEmployeeInfo();
        
        String empsInfo = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        
        List<Employee> empListSelected = new ArrayList<>();
        empListSelected.add(empList.get(0));
        empListSelected.add(empList.get(1));
        empListSelected.add(empList.get(2));
        
        combineTPTandDataBase(empInfoList, empListSelected);
        
        return empListSelected;
    }

    private void combineTPTandDataBase(List<EmployeeInfo> empInfoList, List<Employee> empListSelected) {
        for(int i=0; i<empInfoList.size(); i++){
            for(int j=0 ;j<empListSelected.size(); j++){
                if(empInfoList.get(i).getEmployeeId().equals(empListSelected.get(j).getId())){
                    EmployeeInfo ei = empInfoList.get(i);
                    Employee e = empListSelected.get(j);
                    e.setDepartment(ei.getDepartment());
                    e.setWorkStartDate(DateUtils.calcuDate(e.getWorkStartDate()));
                    e.setGdcStartDate(DateUtils.calcuDate(Long.toString(ei.getGdcStartDate().getTime())));
                    e.setLastPromotionDate(DateUtils.formatDate(ei.getLastPromotionDate()));
                    e.setStartLevel(ei.getStartLevel());
                    e.setSupportiveInfoCollection(ei.getSupportiveInfoCollection());
                    e.setTalentReviewScoreCollection(ei.getTalentReviewScoreCollection());
                    e.setLastDay(DateUtils.toDate(e.getLastDay()));
                    List<Criteria> listCri = criDAO.getCriteriaByLevel(e.getTitle());
                    e.setListCriteria(listCri);
                    
                }
            } 
        }
    }
    
}