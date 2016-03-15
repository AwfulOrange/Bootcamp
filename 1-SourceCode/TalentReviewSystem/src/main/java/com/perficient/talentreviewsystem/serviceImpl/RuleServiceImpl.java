/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceImpl;

import com.perficient.talentreviewsystem.entity.Rule;
import java.util.List;
import com.perficient.talentreviewsystem.service.IRuleService;
import com.perficient.talentreviewsystem.dao.IRuleDAO;
import com.perficient.talentreviewsystem.daoImpl.RuleDAOImpl;

/**
 *
 * @author bootcamp19
 */
public class RuleServiceImpl implements IRuleService{

    IRuleDAO ruleDAO = null;

    @Override
    public List<Rule> findAll() {
        ruleDAO = new RuleDAOImpl();
        return ruleDAO.selectAllRule();
    }
    
    
}
