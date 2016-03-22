/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import com.perficient.talentreviewsystem.daoImpl.CriteriaDAOImpl;
import com.perficient.talentreviewsystem.entity.Criteria;
import com.perficient.talentreviewsystem.service.ICriteriaService;

/**
 *
 * @author bootcamp19
 */
public class CriteriaServiceImpl implements ICriteriaService{

    @Override
    public Criteria findSingle(String jsonStr) {
        Criteria cri = JSON.parseObject(jsonStr, Criteria.class);
        ICriteriaDAO criDao = new CriteriaDAOImpl();
        cri = criDao.getCriteriaByBoth(cri.getCriteria(), cri.getLevel());
        return cri;
    }
}
