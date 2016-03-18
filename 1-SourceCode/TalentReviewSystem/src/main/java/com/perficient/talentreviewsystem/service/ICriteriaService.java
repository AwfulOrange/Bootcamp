/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.service;

import com.perficient.talentreviewsystem.entity.Criteria;

/**
 *
 * @author bootcamp19
 */
public interface ICriteriaService {
    
    Criteria findSingle(String jsonStr);
}
