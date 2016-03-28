/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.LoginUser;
import com.perficient.talentreviewsystem.entity.RoleList;
import com.perficient.talentreviewsystem.utils.GetProperty;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/")
public class RoleRest {
    
    @GET
    @Path("/role")
    @Produces("application/json")
    public LoginUser getLoginUser(){
        String empsInfo = HttpConnection.getFromUrl(new GetProperty().getString("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        LoginUser login = new LoginUser();
        AttributePrincipal prin = (AttributePrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        
        if (!(prin instanceof UserDetails)) {
            return login;
        }
        UserDetails userDetails = (UserDetails) prin;
        Collection<? extends GrantedAuthority> author = userDetails.getAuthorities();
        if(author.contains(RoleList.ROLE_R)){
            login.setRole(RoleList.ROLE_REVIEWER);
        }else if (author.contains(RoleList.ROLE_P)){
            login.setRole(RoleList.ROLE_PMO);
        }
        login.setScreenName(prin.getName());
        return login;
    }
}
