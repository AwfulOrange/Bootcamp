/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import com.perficient.talentreviewsystem.daoimpl.CriteriaDAOImpl;
import com.perficient.talentreviewsystem.entity.Cri;
import com.perficient.talentreviewsystem.service.ICriteriaInfoService;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public class CriteriaInfoServiceImpl implements ICriteriaInfoService{

    @Override
    public List<Cri> getAllCriteria() {
        ICriteriaDAO criDAO = new CriteriaDAOImpl();
        return criDAO.selectAllCriteria();
    }
    
}
