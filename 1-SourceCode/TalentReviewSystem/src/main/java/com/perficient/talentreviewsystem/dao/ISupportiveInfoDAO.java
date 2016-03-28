/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao;

import com.perficient.talentreviewsystem.entity.SupportiveInfo;
import java.util.List;

/**
 *
 * @author bootcamp19
 */
public interface ISupportiveInfoDAO {

    public List<SupportiveInfo> selectAllSupportiveInfo();

    public SupportiveInfo selectSupportiveInfoByBoth(String empId, String rp);

}
