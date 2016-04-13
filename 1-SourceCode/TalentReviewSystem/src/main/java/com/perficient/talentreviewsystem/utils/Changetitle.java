/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import com.perficient.talentreviewsystem.entity.Employee;

/**
 *
 * @author bootcamp19
 */
public class Changetitle {
    private Changetitle(){}
    public static void changeTitile(Employee emp) {
        switch(emp.getTitle()){
            case "Accounting Assistant" :
            {
                emp.setTitlebre("AA");
                break;
            }
            case "Accounting Manager" :
            {
                emp.setTitlebre("AM");
                break;
            }
            case "Accounting Supervisor" :
            {
                emp.setTitlebre("AS");
                break;
            }
            case "Associate Technical Consultant" :
            {
                emp.setTitlebre("ATC");
                break;
            }
            case "Coordinator Talent Acquisition" :
            {
                emp.setTitlebre("CTA");
                break;
            }
            case "Director" :
            {
                emp.setTitlebre("Di");
                break;
            }
            case "HCM Administrator" :
            {
                emp.setTitlebre("HCM A");
                break;
            }
            case "HCM Generalist" :
            {
                emp.setTitlebre("HCM G");
                break;
            }
            case "HCM Manager" :
            {
                emp.setTitlebre("HCM M");
                break;
            }
            case "HCM Supervisor" :
            {
                emp.setTitlebre("HCM S");
                break;
            }
            case "Information Technology Technical Lead" :
            {
                emp.setTitlebre("ITTL");
                break;
            }
            case "IT Manager" :
            {
                emp.setTitlebre("ITM");
                break;
            }
            case "Lead Recruiter" :
            {
                emp.setTitlebre("LR");
                break;
            }
            case "Lead Technical Consultant" :
            {
                emp.setTitlebre("LTC");
                break;
            }
            case "Manager Talent Acquisition" :
            {
                emp.setTitlebre("MTA");
                break;
            }
            case "Project Manager" :
            {
                emp.setTitlebre("PM");
                break;
            }
            case "Senior Systems Administrator" :
            {
                emp.setTitlebre("SSA");
                break;
            }
            case "Service Desk Technician" :
            {
                emp.setTitlebre("SDT");
                break;
            }
            case "Sr. Accountant" :
            {
                emp.setTitlebre("Sr.A");
                break;
            }
            case "Sr. HCM Generalist" :
            {
                emp.setTitlebre("Sr.HCMG");
                break;
            }
            case "Sr. Project Manager" :
            {
                emp.setTitlebre("Sr.PM");
                break;
            }
            case "Sr. Talent Acquisition Specialist" :
            {
                emp.setTitlebre("Sr.TAS");
                break;
            }
            case "Sr. Technical Architect" :
            {
                emp.setTitlebre("Sr.TA");
                break;
            }
            case "Sr. Technical Consultant" :
            {
                emp.setTitlebre("Sr.TC");
                break;
            }
            case "Staff Accountant" :
            {
                emp.setTitlebre("SA");
                break;
            }
            case "Systems Administrator" :
            {
                emp.setTitlebre("SysA");
                break;
            }
            case "Talent Acquisition Specialist" :
            {
                emp.setTitlebre("TAS");
                break;
            }
            case "Technical Architect" :
            {
                emp.setTitlebre("TA");
                break;
            }
            case "Technical Consultant" :
            {
                emp.setTitlebre("TC");
                break;
            }
            default: 
                break;
        }
    }
    
    
}
