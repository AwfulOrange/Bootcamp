/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao;

import com.perficient.talentreviewsystem.entity.Criteria;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public interface ICriteriaDAO {
    public List<Criteria> selectAllCriteria();
    public List<Criteria> getCriteriaByBoth(String criteria,String level);
    public List<Criteria> getCriteriaByLevel(String level);
}
