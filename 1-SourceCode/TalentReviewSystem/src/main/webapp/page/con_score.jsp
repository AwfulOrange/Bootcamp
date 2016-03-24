<body ng-app="myApp" ng-controller="userCtrl" class="contentStyle">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <table style="text-align:left;font-size: 15px;">
               <tr>
                   <th style="width:16%;float:left;padding-bottom:5px ">Reviewee ID</th>
                    <th style="width:16%;float:left;">Name</th>
                    <th style="width:16%;float:left"  ng-model="allstatus">Status</th>
                    <th style="width:17%;float:left"  >Performance </th>
                    <th style="width:17%;float:left"  >Potential </th>
                    <th style="width:16%;float:left"  >Total</th>
               </tr>
        </table>  
      
        <form >
            <div ng-repeat="emp in emps" >
                <table  class="w3-hoverable" style="background-color:gainsboro" >
                    <tr></tr>
                    <tr ng-click="pageshow=!pageshow" id="revid{{$index}}" >
                        
                        <td ng-model="AssignmentNo" style="width:15%;text-align:left" >{{ emp.emid }}</td>
                        <td style="width:16%;text-align:left">{{ emp.screenName }}</td>
                        <td style="width: 18%;text-align:left" ng-init="status=backstatus(emp.talentReviewScoreCollection[0].status)" ng-model="status">{{status}}</td>
                        <td style="width:17%;text-align:left">{{achievingResults + orgImpact}} </td>
                        <td style="width:15%;text-align:left">{{learningAgility + versatility}} </td>
                        <td style="width:16%;text-align:left">{{achievingResults + orgImpact+learningAgility + versatility}}
                    </tr>
                </table>
                
       

                <div  ng-show="pageshow" >
                    
                    <table class="w3-table-all"  ng-show="personalshow">
                       
                        <h class="w3-hoverable" style="font-size:15px" ng-click="personalshow=!personalshow" id="P{{$index}}">
                        <img ng-if="personalshow"  style="height:15px;width:15px;position:relative;top:-5px;"  src="../img/down_1.png"   />
                        <img ng-if="!personalshow"  style="height:15px;width:15px;position:relative;top:-5px;" src="../img/up_1.png"  />
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
                            <td>{{emp.gdcStartDate}}</td>
                            <td>{{emp.workStartDate}}</td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                       <br>
                    <table class="w3-table-all"  ng-show="suportshow">
                        <h class="w3-hoverable" style="font-size:15px;" ng-click="suportshow=!suportshow" id="S{{$index}}">
                         <img ng-if="suportshow"  style="height:15px;width:15px;position:relative;top:-5px;"  
                              src="../img/down_1.png"   />
                        <img ng-if="!suportshow"  style="height:15px;width:15px;position:relative;top:-5px;" src="../img/up_1.png"  />
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
                                         ng-disabled="editable()"
                                         ng-init="achievingResults=emp.talentReviewScoreCollection[0].achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                        ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="A{{$index}}">{{emp.id}}  
                                </select>
                                <a class="tip-1" id="I{{$index}}">?<span class="popbox"  style="z-index:999;"><ol>
                                            <li>{{emp.listCriteria[0].rule}}</li><br/><li>{{emp.listCriteria[1].rule}}</li><br/><li>{{emp.listCriteria[2].rule}}</li><br/><li>{{emp.listCriteria[3].rule}}</li><br/><li>{{emp.listCriteria[4].rule}}</li>
                                </ol> </span></a>
                            </td>
                          
                            
                            <td class="minwidth">
                                <textarea class="text-area" name="text" rows="4" cols="100"
                                       ng-disabled="editable()"
                                       ng-init="achievingResultsComment=emp.talentReviewScoreCollection[0].achievingResultsComment" 
                                       ng-model="achievingResultsComment" 
                                       placeholder="Comment Here   (*)"  ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                           ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="E{{$index}}" required></textarea>
                            </td>
                        </tr>
                        <tr>
                        <td>Organization Impact
                                  <select class="select-s2"  ng-disabled="editable()"
                                          ng-model="orgImpact"  ng-options="act for act in number" 
                                            ng-init="orgImpact=emp.talentReviewScoreCollection[0].orgImpact" 
                                           ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="B{{$index}}"></select>
                          <a class="tip-2" id="J{{$index}}" >?<span class="popbox"><ol><li>{{emp.listCriteria[5].rule}}</li><br/><li>{{emp.listCriteria[6].rule}}</li><br/><li>{{emp.listCriteria[7].rule}}</li><br/><li>{{emp.listCriteria[8].rule}}</li><br/><li>{{emp.listCriteria[9].rule}}</li></ol></span></a>
                        </td>
                   
                        <td>
                             <textarea class="text-area" name="text"  
                                   type="text" ng-model="orgImpactComment"  placeholder="Comment Here   (*)" 
                                   ng-disabled="editable()"
                                   ng-init="orgImpactComment=emp.talentReviewScoreCollection[0].orgImpactComment" 
                                   ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
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
                               <select class="select-s3"  ng-disabled="editable()"
                                       ng-model="learningAgility"  ng-options="act for act in number" 
                                       ng-init="learningAgility=emp.talentReviewScoreCollection[0].learningAgility" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="C{{$index}}"></select>          
                           <a class="tip-3"  id="K{{$index}}">?<span class="popbox"><ol><li>{{emp.listCriteria[10].rule}}</li><br/><li>{{emp.listCriteria[11].rule}}</li><br/><li>{{emp.listCriteria[12].rule}}</li><br/><li>{{emp.listCriteria[13].rule}}</li><br/><li>{{emp.listCriteria[14].rule}}</li></ol></span></a>
                            </td>
                           
                            <td>
                                 <textarea class="text-area" name="text" 
                                       type="text" ng-model="learningAgilityComment"  placeholder="Comment Here   (*)" 
                                       ng-disabled="editable()"
                                       ng-init="learningAgilityComment=emp.talentReviewScoreCollection[0].learningAgilityComment" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="G{{$index}}" required>
                                   </textarea>
                                    </td>
                        <tr>
                            <td>Versatility
                                 <select class="select-s4"  ng-disabled="editable()"
                                        ng-model="versatility"  ng-options="act for act in number"  
                                        ng-init="versatility=emp.talentReviewScoreCollection[0].versatility" 
                                        ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="D{{$index}}"></select>         
                          <a class="tip-4"  id="L{{$index}}">?<span class="popbox"><ol><li>{{emp.listCriteria[15].rule}}</li><br/><li>{{emp.listCriteria[16].rule}}</li><br/><li>{{emp.listCriteria[17].rule}}</li><br/><li>{{emp.listCriteria[18].rule}}</li><br/><li>{{emp.listCriteria[19].rule}}</li></ol></span></a>
                            </td>
                           

                             <td> 
                                 <textarea class="text-area" name="text"  
                                       type="text" ng-model="versatilityComment"  placeholder="Comment Here   (*)"
                                       ng-disabled="editable()"
                                       ng-init="versatilityComment=emp.talentReviewScoreCollection[0].versatilityComment" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
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
            <button class="w3-btn w3-red w3-ripple"  ng-disabled="editable()" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>
        </form>
    </div>
</body>
