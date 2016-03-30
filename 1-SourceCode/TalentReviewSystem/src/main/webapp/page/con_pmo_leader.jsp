<body ng-app="myApp1"  class="contentStyle" ng-controller="pmoCtrl" ng-model="app1">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >

        <table style="text-align:left;font-size: 17px;">
               <tr>
                   <th style="width:16%;float:left;padding-bottom:5px ">Reviewer</th>
                   <!--<th style="width:16%;float:right;padding-bottom:5px ">Status</th>-->
               </tr>
        </table>  
 
        <div  ng-repeat="pmo in pmos" >
            <table  class="w3-hoverable" style="background-color:gainsboro" >

                    <tr></tr>
                    <tr  ng-click="p=!p" id="pmo{{$index}}" style="cursor:pointer">
                        
                        <td  style="width:15%;text-align:left;" >
                <img ng-if="p"  class="w1-imgpmo"  src="../img/up_1.png"   />
                <img ng-if="!p" class="w1-imgpmo"  src="../img/down_1.png"  />
                            
                            {{ pmo.reviewname }}</td>
                        <!--<td style="width: 18%;text-align:right" ng-init=" pstatus='incompleted'" ng-model="pstatus">{{pstatus}}</td>-->
                    </tr>
                </table>
            <div ng-show="p" class="w1-form">
              <table style="text-align:left;font-size: 13px;">
               <tr>
                   <th style="width:16%;float:left;padding-bottom:5px ">Reviewee ID</th>
                    <th style="width:16%;float:left;">Name</th>
                    <th style="width:16%;float:left">Status</th>
                    <th style="width:18%;float:left"  >Performance </th>
                    <th style="width:17%;float:left"  >Potential </th>
                    <th style="width:16%;float:left"  >Total</th>
               </tr>
             </table> 
            <div ng-repeat="emp in pmo.emp" >

                
                
                <table  class="w1-hoverable" style="background-color:ff3333;" >
                    <tr></tr>
                    <tr ng-click="pageshow=!pageshow" id="revid{{$index}}" >
                        
                        <td ng-model="AssignmentNo" style="width:15%;text-align:left" >{{ emp.emid }}</td>
                        <td style="width:16%;text-align:left">{{ emp.screenName }}</td>
                        <td style="width: 18%;text-align:left" ng-init=" status=backstatus(emp.score.status)" ng-model="status">{{status}}</td>
                        <td style="width:17%;text-align:left">{{achievingResults + orgImpact}} </td>
                        <td style="width:15%;text-align:left">{{learningAgility + versatility}} </td>
                        <td style="width:16%;text-align:left">{{achievingResults + orgImpact+learningAgility + versatility}}
                    </tr>
                </table>
                
       

                <div  ng-show="pageshow" >
                    
                    <table class="w3-table-all"  ng-show="personalshow">
                       
                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="personalshow=!personalshow" id="P{{$index}}">
                        <img ng-if="personalshow"  class="w1-imgpmo"  src="../img/up_1.png"   />
                        <img ng-if="!personalshow"  class="w1-imgpmo" src="../img/down_1.png"  />
                            Personal Profile                        
                        </h>
                        <tr>
                            <td >
                                Assignment Number
                            </td>
                            <td>
                                Name
                            </td>
                            <td>
                               Perficient Level
                            </td>
                            <td>
                                Role
                            </td>
                        </tr>
                        <tr>
                            <td>{{emp.emid}}</td>
                            <td>{{emp.screenName}}</td>

                            <td>{{emp.title}}</td>
                            <td>{{emp.role}}</td>
                        </tr>
                        <tr>
                            <td>
                                GDC Working Experience
                            </td>
                            <td>
                                Total Working Experience
                            </td>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td>{{emp.gdcExperience}}</td>
                            <td>{{emp.workExperience}}</td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                       <br>
                    <table class="w3-table-all"  ng-show="suportshow">
                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="suportshow=!suportshow" id="S{{$index}}">
                         <img ng-if="suportshow"  class="w1-imgpmo"   
                              src="../img/up_1.png"   />
                        <img ng-if="!suportshow"  class="w1-imgpmo" src="../img/down_1.png"  />
                            Supportive Information</h> 
                        <tr>
                            <td>
                               Award
                            </td>
                            <td>
                               Time entry compliance 
                            </td>
                            <td>
                            Company activity
                            </td>
                            <td>
                               Culture Committee 
                            </td>
                            <td>
                             Training
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                              Recruiting
                            </td>
                            <td>
                             Certification
                            </td>
                            <td>
                              Blog
                            </td>
                            <td>
                              Center of Expertise
                            </td>
                              <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                              <td></td>
                        </tr>
                    </table>
                    <br>
                    <table class="table-s">
                        <tr><td><h style="font-size:15px;padding-top:-5px;text-align: left;"><b>Score</b></h></td> 
                         <td><h style="font-size:15px;padding-top:-5px;text-align: left; left: 40%"><b>Comment</b></h></td>
                        </tr>
                        <tr>
                            <td class="minwidth">Achieving Results
                                <select  class="select-s1"  
                                         ng-disabled="editable(status)"
                                         ng-init="achievingResults=emp.score.achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                        ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="A{{$index}}">{{emp.id}}  
                                </select>
                                <a class="tip-1" id="I{{$index}}">?<span class="popbox"  style="z-index:999;"><ol>
                                             <li>{{findCriteriaByLevel("Achieves Results",emp.title)[0].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results",emp.title)[1].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results",emp.title)[2].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results",emp.title)[3].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results",emp.title)[4].rule}}</li>
                                </ol> </span></a>
                            </td>
                          
                            
                            <td class="minwidth">
                                <textarea class="text-area" name="text" rows="4" cols="100"
                                       ng-disabled="editable(status)"
                                       ng-init="achievingResultsComment=emp.score.achievingResultsComment" 
                                       ng-model="achievingResultsComment" 
                                       placeholder="Comment Here   (*)"  ng-blur="save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                           ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="E{{$index}}" required></textarea>
                            </td>
                        </tr>
                        <tr>
                        <td>Organization Impact
                                  <select class="select-s2"  ng-disabled="editable(status)"
                                          ng-model="orgImpact"  ng-options="act for act in number" 
                                            ng-init="orgImpact=emp.score.orgImpact" 
                                           ng-blur="save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="B{{$index}}"></select>
                          <a class="tip-2" id="J{{$index}}" >?<span class="popbox"><ol>
                                       <li>{{findCriteriaByName("Org Impact")[0].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[1].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[2].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[3].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[4].rule}}</li></ol></span></a>
                        </td>
                   
                        <td>
                             <textarea class="text-area" name="text"  
                                   type="text" ng-model="orgImpactComment"  placeholder="Comment Here   (*)" 
                                   ng-disabled="editable(status)"
                                   ng-init="orgImpactComment=emp.score.orgImpactComment" 
                                   ng-blur="save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="F{{$index}}" required>
                                   </textarea>
                         </td>
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th >Performance Total &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              {{achievingResults + orgImpact}}</th>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Learning Agility        
                               <select class="select-s3"  ng-disabled="editable(status)"
                                       ng-model="learningAgility"  ng-options="act for act in number" 
                                       ng-init="learningAgility=emp.score.learningAgility" 
                                       ng-blur=" save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="C{{$index}}"></select>          
                           <a class="tip-3"  id="K{{$index}}">?<span class="popbox"><ol>
                                       <li>{{findCriteriaByName("Learning Agility")[0].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[1].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[2].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[3].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[4].rule}}</li></ol></span></a>
                            </td>
                           
                            <td>
                                 <textarea class="text-area" name="text" 
                                       type="text" ng-model="learningAgilityComment"  placeholder="Comment Here   (*)" 
                                       ng-disabled="editable(status)"
                                       ng-init="learningAgilityComment=emp.score.learningAgilityComment" 
                                       ng-blur=" save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="G{{$index}}" required>
                                   </textarea>
                                    </td>
                        <tr>
                            <td>Versatility
                                 <select class="select-s4"  ng-disabled="editable(status)"
                                        ng-model="versatility"  ng-options="act for act in number"  
                                        ng-init="versatility=emp.score.versatility" 
                                        ng-blur=" save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="D{{$index}}"></select>         
                          <a class="tip-4"  id="L{{$index}}">?<span class="popbox"><ol>
                                      <li>{{findCriteriaByName("Versatility")[0].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[1].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[2].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[3].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[4].rule}}</li></ol></span></a>
                            </td>
                           

                             <td> 
                                 <textarea class="text-area" name="text"  
                                       type="text" ng-model="versatilityComment"  placeholder="Comment Here   (*)"
                                       ng-disabled="editable(status)"
                                       ng-init="versatilityComment=emp.score.versatilityComment" 
                                       ng-blur=" save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)"id="H{{$index}}" required>
                                   </textarea>
                                    </td>
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th>Potential Total  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              {{learningAgility + versatility}} </th>
                            <td></td>
                        </tr>
                        
                      
                    </table>

                </div>
            </div>
            <!--<button class="w3-btn w3-red w3-ripple"  ng-disabled="editable()" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>-->

            </div>  
                        
        </div>
         <button class="w3-btn w3-red w3-ripple"  ng-disabled="editablebutton()" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>
        <table>
            <tr></tr>
            
        </table>
        
    </div>
</body>
