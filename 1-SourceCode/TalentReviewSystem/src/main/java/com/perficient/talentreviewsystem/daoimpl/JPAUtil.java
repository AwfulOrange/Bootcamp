/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

/**
 *
 * @author bootcamp19
 */
public class JPAUtil {

    public static final String JPA = "com.perficient_TalentReviewSystem_war_1.0-SNAPSHOTPU";
    public static final String SELECT_CRITERIA_BY_CRITERIA_LEVEL = "select * from public.cri where criteria=? and level=?";
    public static final String SELECT_CRITERIA_BY_LEVLE = "select * from public.cri where level=? or level='all' ";
    public static final String SELECT_TALENTREVIEWSCORE_BY_REVIEWER = "select * from public.talent_review_score where reviewer_id=? order by reviewer_id,employee_id";
    public static final String SELECT_TALENTREVIEWSCORE_BY_PMO = "select  * from public.talent_review_score where pmo_id=?";
    public static final String SELECT_REVIEWER_BY_PMO = "select distinct reviewer_id from public.talent_review_score where pmo_id=?";
    public static final String SELECT_MAX_REVIEW_PERIOD = "select review_period from public.rp where id=(select max(id) from public.rp)";

    private JPAUtil() {
    }
}
