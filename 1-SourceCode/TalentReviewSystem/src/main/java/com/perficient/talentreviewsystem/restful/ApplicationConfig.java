/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author bootcamp19
 */
@javax.ws.rs.ApplicationPath("web")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.perficient.talentreviewsystem.restful.CriteriaREST.class);
        resources.add(com.perficient.talentreviewsystem.restful.EmployeeREST.class);
        resources.add(com.perficient.talentreviewsystem.restful.RoleREST.class);
        resources.add(com.perficient.talentreviewsystem.restful.RoleRest.class);
        resources.add(com.perficient.talentreviewsystem.restful.TalentReviewScoreREST.class);
    }
    
}
