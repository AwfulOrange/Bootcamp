/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.service.ICriteriaInfoService;
import com.perficient.talentreviewsystem.serviceimpl.CriteriaInfoServiceImpl;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/cri")
public class CriteriaREST {
    
    @GET
    public String getCriteria(){
        ICriteriaInfoService criteria=new CriteriaInfoServiceImpl();
        return JSON.toJSONString(criteria.getAllCriteria());
    }
}
