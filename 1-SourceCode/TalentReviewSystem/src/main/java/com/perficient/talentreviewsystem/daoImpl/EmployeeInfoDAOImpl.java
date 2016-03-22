/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.jpacontroller.EmployeeInfoJpaController;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.IllegalOrphanException;
import com.perficient.talentreviewsystem.jpacontroller.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    EmployeeInfo employeeInfo =null;
    
    @Override
    public List<EmployeeInfo> selectAllEmployeeInfo() {
        emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
        eijc = new EmployeeInfoJpaController(emf);
        employeeInfos = eijc.findEmployeeInfoEntities();
        
        return employeeInfos;
    }
    
    @Override
    public int addEmployeeInfo(EmployeeInfo employeeInfo) {
        try {
            emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
            eijc =new EmployeeInfoJpaController(emf);
            eijc.create(employeeInfo);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public EmployeeInfo selectEmployeeInfoById(String id) {
        emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
        eijc =new EmployeeInfoJpaController(emf);
        employeeInfo=eijc.findEmployeeInfo(id);
        return  employeeInfo;
    }
    
    
    @Override
    public void deleteEmployeeInfoById(String id) {
        emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
        eijc =new EmployeeInfoJpaController(emf);   
        try {
            eijc.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(EmployeeInfoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmployeeInfoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
