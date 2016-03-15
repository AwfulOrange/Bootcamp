/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.serviceImpl.EmployeeInfoServiceImpl;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/employee")
public class EmployeeREST {
    
    
    
    @GET
    @Path("{id}")
    public String findSingle(@PathParam("id") String id) {
        String empsInfo = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        Employee emp = null;
        for (Employee e : empList){
            if(e.getId().equals(id)) {
                emp = e;
                break;
            }
        }
        return JSON.toJSONString(emp);
    }
    
    @GET
    public String findAll() {
        String empsInfo = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        IEmployeeInfoService empService = new EmployeeInfoServiceImpl();
        List<EmployeeInfo> empInfoList = empService.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        for(int i=0; i<empInfoList.size(); i++){
            for(int j=0 ;j<empList.size(); j++){
                if(empInfoList.get(i).getEmployeeId().equals(empList.get(j).getId())){
                    EmployeeInfo ei = empInfoList.get(i);
                    Employee e = empList.get(j);
                    e.setDepartment(ei.getDepartment());
                    e.setGdcStartDate(sdf.format(ei.getGdcStartDate()));
                    e.setLastPromotionDate(sdf.format(ei.getLastPromotionDate()));
                    e.setStartLevel(ei.getStartLevel());
                    e.setSupportiveInfoCollection(ei.getSupportiveInfoCollection());
                    e.setTalentReviewScoreCollection(ei.getTalentReviewScoreCollection());
                }
            } 
        }
        List<Employee> empListSelected = new ArrayList<Employee>();
        empListSelected.add(empList.get(0));
        empListSelected.add(empList.get(1));
        empListSelected.add(empList.get(2));
        
        return JSON.toJSONString(empListSelected,SerializerFeature.DisableCircularReferenceDetect);
    }
}
