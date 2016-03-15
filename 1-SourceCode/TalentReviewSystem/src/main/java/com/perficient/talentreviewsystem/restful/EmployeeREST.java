/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.utils.HttpConnection;
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
    
    Gson gson = new Gson();
    
    @GET
    @Path("{id}")
    public String findSingle(@PathParam("id") String id) {
        String empsInfo = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        List<Employee> empList = gson.fromJson(empsInfo, new TypeToken<ArrayList<Employee>>(){}.getType());
        Employee emp = null;
        for (Employee e : empList){
            if(e.getId().equals(id)) {
                emp = e;
                break;
            }
        }
        return gson.toJson(emp);
    }
    
    @GET
    public String findAll() {
        String empsInfo = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        List<Employee> empList = gson.fromJson(empsInfo, new TypeToken<ArrayList<Employee>>(){}.getType());
        List<Employee> empListSelected = new ArrayList<Employee>();
        empListSelected.add(empList.get(0));
        empListSelected.add(empList.get(1));
        empListSelected.add(empList.get(2));
        return gson.toJson(empListSelected);
    }
}
