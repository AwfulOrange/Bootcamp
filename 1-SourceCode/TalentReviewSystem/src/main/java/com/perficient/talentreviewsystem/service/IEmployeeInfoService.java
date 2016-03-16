/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.service;

import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public interface IEmployeeInfoService {
    
    List<EmployeeInfo> findAll();
    
}
