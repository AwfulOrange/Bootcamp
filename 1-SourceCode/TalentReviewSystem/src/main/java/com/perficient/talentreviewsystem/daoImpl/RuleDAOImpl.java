/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.dao.IRuleDAO;
import com.perficient.talentreviewsystem.entity.Rule;
import com.perficient.talentreviewsystem.jpacontroller.RuleJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bootcamp19
 */
public class RuleDAOImpl implements IRuleDAO{

     EntityManagerFactory emf = null;
    RuleJpaController rjc =null;

    
    List<Rule> rules = new ArrayList<Rule>();
    
    @Override
    public List<Rule> selectAllRule() {
        emf = Persistence.createEntityManagerFactory(JPAUtil.JPA);
        rjc = new RuleJpaController(emf);
        rules = rjc.findRuleEntities();
        return rules;
    }
    
}
