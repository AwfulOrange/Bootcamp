/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.entity.Group;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.serviceimpl.EmployeeInfoServiceImpl;
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
    public String findAll() {
        return JSON.toJSONString(empService.findAll());
    }
    @GET
    @Path("{id}")
    public String findByPMOID(@PathParam("id") String id){
        return JSON.toJSONString(empService.findAllByPMOID(id));
    }
    
    
}