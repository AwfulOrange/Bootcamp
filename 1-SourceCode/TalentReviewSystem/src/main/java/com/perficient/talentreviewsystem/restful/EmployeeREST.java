/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.serviceImpl.EmployeeInfoServiceImpl;
import com.perficient.talentreviewsystem.utils.HttpConnection;
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
    private IEmployeeInfoService empService = new EmployeeInfoServiceImpl();
    
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
        return JSON.toJSONString(empService.findAll(),SerializerFeature.DisableCircularReferenceDetect);
    }
    
}