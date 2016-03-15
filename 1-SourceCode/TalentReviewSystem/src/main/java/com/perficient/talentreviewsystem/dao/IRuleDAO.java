/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao;

import com.perficient.talentreviewsystem.entity.Rule;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public interface IRuleDAO {
    public List<Rule> selectAllRule();
}
