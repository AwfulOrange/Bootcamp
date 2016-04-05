<body ng-app="myApp" ng-controller="userCtrl" ng-model="p" ng-init="p=true" class="contentStyle">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <table style="text-align:left;font-size: 15px;">
            <tr>
                <td style="width:15%;padding-bottom:5px;margin-right: 1%">
                    <input style="width: 70%" ng-model="filter1"/>
                </td>
                <td style="width:15%;margin-right: 1%">
                    <input style="width: 70%" ng-model="filter2"/>
                </td>
                <td style="width:15%;margin-right: 1%">
                    <input style="width: 70%" ng-model="filter3"/>
                </td>
                <td style="width:16%;margin-right: 1%">
                    <input style="width: 70%" ng-model="filter4"/>
                </td>
                <td style="width:16%;margin-right: 1%">
                    <input style="width: 70%" ng-model="filter5"/>
                </td>
                <td style="width:15%;float:left;">
                    <input style="width: 70%" ng-model="filter6"/>
                </td>
            </tr>
            <span  ng-model="allstatus"></span>
               <tr>
                    <th style="width:15%;" ng-click="order = sorter('screenName');" >Name</th>
                    <th style="width:15%;" ng-click="order = sorter('performance');" >Performance </th>
                    <th style="width:10%;" ng-click="order = sorter('potential');" >Potential </th>
                    <th style="width:10%;" ng-click="order = sorter('total');" >Total</th>
                    <th style="width:35%;" ng-click="order = sorter('title');" >&nbsp;&nbsp;&nbsp;&nbsp;Level</th>
                    <th style="width:15%;" ng-click="order = sorter('role');" >&nbsp;&nbsp;Role</th>
               </tr>
        </table>  
      
        <form >
            <div  ng-repeat="emp in emps | orderBy:order:p | filter:{screenName : filter1}:false | filter:{performance : filter2}:false | filter:{potential : filter3}:false | filter:{total : filter4}:false | filter:{title : filter5}:false | filter:{role : filter6}:false" >
                <table  class="w3-hoverable" style="background-color:gainsboro" >
                    <tr></tr>
                    <tr ng-click="pageshow=!pageshow" id="revid{{$index}}" >
                        <td id="p0{{$index}}" style="width:15%;text-align:left">{{ emp.screenName }}</td>
                        <td id="p2{{$index}}" style="width:15%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{emp.performance}} </td>
                        <td id="p3{{$index}}" style="width:10%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;{{emp.potential}} </td>
                        <td id="p4{{$index}}" style="width:10%;text-align:left">&nbsp;&nbsp;{{emp.total}}
                        <td id="p5{{$index}}" style="width:35%;text-align:left">{{emp.title}}
                        <td id="p6{{$index}}" style="width:15%;text-align:left">{{emp.role}}
                        <!--<td style="width:32%;text-align:left" >place for level</td>-->
                        
                    </tr>
                </table>
                
       

                <div  ng-show="pageshow" >
                    
                    <table class="w3-table-all"  ng-show="personalshow">
                       
                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="personalshow=!personalshow" id="P{{$index}}">
                        <img ng-if="personalshow"  class="w1-img"   src="../img/up_1.png"   />
                        <img ng-if="!personalshow"  class="w1-img"  src="../img/down_1.png"  />
                            Personal Profile                        
                        </h>
                        <tr>
                            <td >
                                Assignment Number
                            </td>
                            <td>
                                GDC Working Experience
                            </td>
                            <td>
                               Total Working Experience
                            </td>
                            <td>
                                Last Promotion Date
                            </td>
                        </tr>
                        <tr>
                            <td>{{emp.emid}}</td>
                            <td>{{emp.gdcExperience}}</td>
                            <td>{{emp.workExperience}}</td>
                            <td>{{emp.lastPromotionDate}}</td>
                        </tr>
                        
                    </table>
                       <br>
                    <table class="w3-table-all"  ng-show="suportshow">
                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="suportshow=!suportshow" id="S{{$index}}">
                         <img ng-if="suportshow"  class="w1-img" 
                              src="../img/up_1.png"   />
                        <img ng-if="!suportshow"  class="w1-img" src="../img/down_1.png"  />
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
                        <td></td>
                         <td><h style="font-size:15px;padding-top:-5px;text-align: left; left: 40%"><b>Comment</b></h></td>
                        </tr>
                        <tr>
                            <td class="minwidth">Achieving Results</td>
                            <td class="minwidth">
                                <select  class="select-s"  
                                         ng-disabled="editable()"
                                         ng-init="achievingResults=emp.score.achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
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
                          
                            
                            <td class="minwidth2">
                                <textarea class="text-area" name="text" rows="4" cols="100"
                                       ng-disabled="editable()"
                                       ng-init="achievingResultsComment=emp.score.achievingResultsComment" 
                                       ng-model="achievingResultsComment" 
                                       placeholder="Comment Here   (*)"  ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                           ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="E{{$index}}" required></textarea>
                            </td>
                        </tr>
                        <tr>
                        <td>Organization Impact</td>
                        <td >
                                  <select class="select-s"  ng-disabled="editable()"
                                          ng-model="orgImpact"  ng-options="act for act in number" 
                                            ng-init="orgImpact=emp.score.orgImpact" 
                                           ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                               ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="B{{$index}}">
                                               
                                  </select>
                        
                          <a class="tip-1" id="J{{$index}}" >?<span class="popbox"><ol>
                                      <li>{{findCriteriaByName("Org Impact")[0].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[1].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[2].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[3].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Org Impact")[4].rule}}</li></ol></span></a>
                        </td>
                   
                        <td>
                             <textarea class="text-area" name="text"  
                                   type="text" ng-model="orgImpactComment"  placeholder="Comment Here   (*)" 
                                   ng-disabled="editable()"
                                   ng-init="orgImpactComment=emp.score.orgImpactComment" 
                                   ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="F{{$index}}" required>
                                   </textarea>
                         </td>
                        </tr>
                        <tr>
                            <td>Learning Agility   </td>
                            <td >     
                               <select class="select-s"  ng-disabled="editable()"
                                       ng-model="learningAgility"  ng-options="act for act in number" 
                                       ng-init="learningAgility=emp.score.learningAgility" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                           ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="C{{$index}}">
                                           
                               </select> 
                            
                           <a class="tip-1"  id="K{{$index}}">?<span class="popbox"><ol>
                                       <li>{{findCriteriaByName("Learning Agility")[0].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[1].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[2].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[3].rule}}</li><br/>
                                       <li>{{findCriteriaByName("Learning Agility")[4].rule}}</li></ol></span></a>
                            </td>
                           
                            <td>
                                 <textarea class="text-area" name="text" 
                                       type="text" ng-model="learningAgilityComment"  placeholder="Comment Here   (*)" 
                                       ng-disabled="editable()"
                                       ng-init="learningAgilityComment=emp.score.learningAgilityComment" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="G{{$index}}" required>
                                   </textarea>
                                    </td>
                        <tr>
                            <td>Versatility</td>
                            <td >
                                 <select class="select-s"  ng-disabled="editable()"
                                        ng-model="versatility"  ng-options="act for act in number"  
                                        ng-init="versatility=emp.score.versatility" 
                                        ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                            ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="D{{$index}}">
                                            
                                 </select> 
                            
                          <a class="tip-1"  id="L{{$index}}">?<span class="popbox"><ol>
                                      <li>{{findCriteriaByName("Versatility")[0].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[1].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[2].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[3].rule}}</li><br/>
                                      <li>{{findCriteriaByName("Versatility")[4].rule}}</li></ol></span></a>
                            </td>
                           

                             <td> 
                                 <textarea class="text-area" name="text"  
                                       type="text" ng-model="versatilityComment"  placeholder="Comment Here   (*)"
                                       ng-disabled="editable()"
                                       ng-init="versatilityComment=emp.score.versatilityComment" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)"id="H{{$index}}" required>
                                   </textarea>
                                    </td>
                        </tr>
                        
                      versatility
                    </table>
                </div>
            </div>
            <button class="w3-btn w3-red w3-ripple"  ng-disabled="editable()" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>
        </form>
    </div>
</body>
