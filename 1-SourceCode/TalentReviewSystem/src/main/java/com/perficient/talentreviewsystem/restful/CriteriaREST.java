/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.perficient.talentreviewsystem.entity.Criteria;
import com.perficient.talentreviewsystem.serviceImpl.CriteriaServiceImpl;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/criteria")
public class CriteriaREST {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Criteria findSingle(String jsonStr) {
        return new CriteriaServiceImpl().findSingle(jsonStr);
    }
    
}
