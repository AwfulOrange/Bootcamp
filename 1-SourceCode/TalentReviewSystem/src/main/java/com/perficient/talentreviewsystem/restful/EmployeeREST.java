/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.service.IEmployeeInfoService;
import com.perficient.talentreviewsystem.serviceimpl.EmployeeInfoServiceImpl;
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
    @Path("pmo/{id}")
    public String findByPMOID(@PathParam("id") String id){
        return JSON.toJSONString(empService.findAllByPMOID(id));
    }
    @GET
    @Path("reviewer/{id}")
    public String findByReviewID(@PathParam("id") String id){
        return JSON.toJSONString(empService.findAllByReviewerID(id));
    }
    
    
    
}