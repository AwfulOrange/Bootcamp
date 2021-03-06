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
import com.perficient.talentreviewsystem.utils.GetProperties;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bootcamp19
 */
@Stateless
@Path("/role")
public class RoleREST {
    
    @GET
    //@Produces("application/json")
    public String getLoginUser(){
        String empsInfo = HttpConnection.getFromUrl(new GetProperties().getProperty("tptPath"));
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        LoginUser login = new LoginUser();
        
        if (!(SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal() instanceof UserDetails)) {
            return null;
        }
        UserDetails ud = (UserDetails)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        
        Collection<? extends GrantedAuthority> author = ud.getAuthorities();
        if(author.contains(new SimpleGrantedAuthority(RoleList.ROLE_R))){
            login.setRole(RoleList.ROLE_REVIEWER);
        }else if (author.contains(new SimpleGrantedAuthority(RoleList.ROLE_P))){
            login.setRole(RoleList.ROLE_PMO);
        }
        login.setScreenName(ud.getUsername());
        for(int i=0;i<empList.size();i++)
        {
            if(login.getScreenName().equalsIgnoreCase(empList.get(i).getScreenName())){
                login.setId(empList.get(i).getId());
                break;
            }
        }
        
        return JSON.toJSONString(login);
    }
}
