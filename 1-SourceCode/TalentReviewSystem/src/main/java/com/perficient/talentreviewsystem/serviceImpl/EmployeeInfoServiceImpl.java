/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import java.util.List;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.daoImpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.entity.Criteria;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.service.ICriteriaService;
import com.perficient.talentreviewsystem.utils.DateUtils;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author bootcamp19
 */
public class EmployeeInfoServiceImpl implements IEmployeeInfoService{

    public List<Employee> findAll() {
        IEmployeeInfoDAO empDAO = new EmployeeInfoDAOImpl();
        List<EmployeeInfo> empInfoList = empDAO.selectAllEmployeeInfo();
        
        String empsInfo = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        
        List<Employee> empListSelected = new ArrayList<Employee>();
        empListSelected.add(empList.get(0));
        empListSelected.add(empList.get(1));
        empListSelected.add(empList.get(2));
        
        for(int i=0; i<empListSelected.size(); i++){
            Employee e = empListSelected.get(i);
            e.setWorkStartDate(DateUtils.calcuDate(e.getWorkStartDate()));
        }
        ICriteriaService criService = new CriteriaServiceImpl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        for(int i=0; i<empInfoList.size(); i++){
            for(int j=0 ;j<empListSelected.size(); j++){
                if(empInfoList.get(i).getEmployeeId().equals(empListSelected.get(j).getId())){
                    EmployeeInfo ei = empInfoList.get(i);
                    Employee e = empListSelected.get(j);
                    e.setDepartment(ei.getDepartment());
                    e.setGdcStartDate(DateUtils.calcuDate(Long.toString(ei.getGdcStartDate().getTime())));
                    e.setLastPromotionDate(sdf.format(ei.getLastPromotionDate()));
                    e.setStartLevel(ei.getStartLevel());
                    e.setSupportiveInfoCollection(ei.getSupportiveInfoCollection());
                    e.setTalentReviewScoreCollection(ei.getTalentReviewScoreCollection());
                    
                    List<Criteria> listCri = criService.getCriteriaByLevel(e.getTitle());
                    e.setListCriteria(listCri);
                    
                }
            } 
        }
        
        
        return empListSelected;
    }
    
}