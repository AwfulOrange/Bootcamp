/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.service;

import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.Group;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public interface IEmployeeInfoService {
    
    List<Employee> findAll();
    List<Group> findAllByPMOID(String pmoid);
    List<Employee> findAllByReviewerID(String reviewerid);
    
}
