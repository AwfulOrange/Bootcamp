/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.jpacontroller.EmployeeInfoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bootcamp19
 */
public class EmployeeInfoDAOImpl implements IEmployeeInfoDAO{

    EntityManagerFactory emf = null;
    EmployeeInfoJpaController eijc = null;
    List<EmployeeInfo> employeeInfos =new ArrayList<EmployeeInfo>();
    
    
    @Override
    public List<EmployeeInfo> selectAllEmployeeInfo() {
        emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
        eijc = new EmployeeInfoJpaController(emf);
        employeeInfos = eijc.findEmployeeInfoEntities();
        
        return employeeInfos;
    }
    
}
