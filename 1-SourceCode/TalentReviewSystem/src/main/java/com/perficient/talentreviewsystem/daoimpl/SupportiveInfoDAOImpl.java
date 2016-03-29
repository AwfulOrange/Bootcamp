/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.dao.ISupportiveInfoDAO;
import com.perficient.talentreviewsystem.entity.SupportiveInfo;
import com.perficient.talentreviewsystem.entity.SupportiveInfoPK;
import com.perficient.talentreviewsystem.jpacontroller.SupportiveInfoJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bootcamp19
 */
public class SupportiveInfoDAOImpl implements ISupportiveInfoDAO{

    EntityManagerFactory emf = null;
    List<SupportiveInfo> sis =null;
    SupportiveInfoJpaController sijc =null;
    SupportiveInfoPK sipk =null;
    SupportiveInfo si =null;
   
    @Override
    public List<SupportiveInfo> selectAllSupportiveInfo() {
        emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
        sijc = new SupportiveInfoJpaController(emf);
        sis = sijc.findSupportiveInfoEntities();
        return sis;
    }

    @Override
    public SupportiveInfo selectSupportiveInfoByBoth(String empId, String rp) {
        emf =Persistence.createEntityManagerFactory(JPAUtil.JPA);
        sijc = new SupportiveInfoJpaController(emf);
        sipk =new SupportiveInfoPK(empId, rp);
        si = sijc.findSupportiveInfo(sipk);
        return si;
    }
    
}
