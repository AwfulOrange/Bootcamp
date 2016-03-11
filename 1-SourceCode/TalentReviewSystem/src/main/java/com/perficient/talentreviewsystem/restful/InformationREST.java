/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.google.gson.Gson;
import com.perficient.talentreviewsystem.service.InformationService;
import com.perficient.talentreviewsystem.serviceImpl.InformationServiceImpl;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("information")
public class InformationREST {

    InformationService infoService = new InformationServiceImpl();
    Gson gson = new Gson();

    @GET
    public String findAll() {
        String info = HttpConnection.getFromUrl("http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees");
        return info;
    }

}
