/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

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
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        return new User(principal.getName(), "NO_PASSWORD", grantedAuthorities);
    }
}
