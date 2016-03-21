/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao.JUnitTest;

import com.perficient.talentreviewsystem.dao.IEmployeeInfoDAO;
import com.perficient.talentreviewsystem.daoImpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bootcamp19
 */
public class IEmployeeInfoDAOTest {

    public IEmployeeInfoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of selectAllEmployeeInfo method, of class IEmployeeInfoDAO.
     */
    @Test
    public void testSelectAllEmployeeInfo() {
        System.out.println("selectAllEmployeeInfo");
        IEmployeeInfoDAO instance = new EmployeeInfoDAOImpl();
        List<EmployeeInfo> expResult = new ArrayList<EmployeeInfo>();
        EmployeeInfo emp = new EmployeeInfo();
        List<EmployeeInfo> result = instance.selectAllEmployeeInfo();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployeeInfo method, of class IEmployeeInfoDAO.
     */
    @Test
    public void testAddEmployeeInfo() {
        System.out.println("addEmployeeInfo");
        EmployeeInfo employeeInfo = new EmployeeInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        IEmployeeInfoDAO instance = new EmployeeInfoDAOImpl();
        employeeInfo.setEmployeeId("9");
        employeeInfo.setDepartment("China GDC");
        employeeInfo.setGdcStartDate(new Date(2015, 3, 1));
        employeeInfo.setLastPromotionDate(new Date(2016, 3, 1));
        employeeInfo.setStartLevel("China GDC");
        employeeInfo.setWorkStartDate(new Date(2010, 3, 1));
        int expResult = 0;
        int result = instance.addEmployeeInfo(employeeInfo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectEmployeeInfoById method, of class IEmployeeInfoDAO.
     */
    @Test
    public void testSelectEmployeeInfoById() {
        System.out.println("selectEmployeeInfoById");
        String id = "9";
        IEmployeeInfoDAO instance = new EmployeeInfoDAOImpl();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeId("9");
        employeeInfo.setDepartment("China GDC");
        employeeInfo.setGdcStartDate(new Date(2015, 3, 1));
        employeeInfo.setLastPromotionDate(new Date(2016, 3, 1));
        employeeInfo.setStartLevel("China GDC");
        employeeInfo.setWorkStartDate(new Date(2010, 3, 1));
        EmployeeInfo expResult = employeeInfo;
        EmployeeInfo result = instance.selectEmployeeInfoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IEmployeeInfoDAOImpl implements IEmployeeInfoDAO {

        public List<EmployeeInfo> selectAllEmployeeInfo() {
            return null;
        }

        public int addEmployeeInfo(EmployeeInfo employeeInfo) {
            return 0;
        }

        public EmployeeInfo selectEmployeeInfoById(String id) {
            return null;
        }
    }

}
