/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceImpl;

import com.perficient.talentreviewsystem.entity.Information;
import com.perficient.talentreviewsystem.service.InformationService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public class InformationServiceImpl implements InformationService {

    @Override
    public List<Information> findAll() {
        List<Information> list = new ArrayList<Information>();
        for (int i = 0; i < 5; i++) {
            Information info = new Information();
            info.setEmpId(i+"");
            info.setCoe("bi" + i);
            info.setDepartment("haha" + i);
            list.add(info);
        }
        return list;
    }

}
