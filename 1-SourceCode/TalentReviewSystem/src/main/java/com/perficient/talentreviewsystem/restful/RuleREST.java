/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.perficient.talentreviewsystem.entity.Rule;
import com.perficient.talentreviewsystem.service.IRuleService;
import com.perficient.talentreviewsystem.serviceImpl.RuleServiceImpl;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/rule")
public class RuleREST {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rule> findAll() {
        IRuleService ruleService = new RuleServiceImpl();
        List<Rule> list = ruleService.findAll();
        return list;
    }
}
