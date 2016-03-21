/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.perficient.talentreviewsystem.serviceImpl.TalentReviewScoreServiceImpl;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/score")
public class TalentReviewScoreREST {
    
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int addScore(String str) {
        return new TalentReviewScoreServiceImpl().add(str);
    }
}
