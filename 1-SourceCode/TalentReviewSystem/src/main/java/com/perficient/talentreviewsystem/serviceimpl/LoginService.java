/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.LoginUser;
import com.perficient.talentreviewsystem.entity.RoleList;
import com.perficient.talentreviewsystem.restful.RoleRest;
import com.perficient.talentreviewsystem.utils.GetProperty;
import com.perficient.talentreviewsystem.utils.HttpConnection;
import java.util.ArrayList;
import java.util.List;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bootcamp19
 */
public class LoginService extends AbstractCasAssertionUserDetailsService{

    @Override
    protected UserDetails loadUserDetails(Assertion asrtn) {
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        AttributePrincipal principal = asrtn.getPrincipal();
        
        String name = principal.getName();
        String empsInfo = HttpConnection.getFromUrl(new GetProperty().getString("tptPath"));
        
        List<Employee> empList = JSON.parseArray(empsInfo, Employee.class);
        
        for(int i = 0; i < empList.size(); i++){
            if(name.equalsIgnoreCase(empList.get(i).getScreenName())){
                if(empList.get(i).getRole().equalsIgnoreCase(RoleList.ROLE_PMO)){
                    grantedAuthorities.add(new SimpleGrantedAuthority(RoleList.ROLE_P));
                }else {
                    grantedAuthorities.add(new SimpleGrantedAuthority(RoleList.ROLE_R));
                }
                break;
            }
        }
        return new User(name, "NO_PASSWORD", grantedAuthorities);
    }
}
