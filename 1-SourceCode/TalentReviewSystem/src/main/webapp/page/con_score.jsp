<body ng-app="myApp" ng-controller="userCtrl" class="contentStyle">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <table style="text-align:left">
               <tr>
                   <th style="width:33%;float:left;padding-bottom:5px ">Reviewee ID</th>
                    <th style="width:33%;float:left;">Name</th>
                    <th style="width:33%;float:left"  ng-model="allstatus">status</th>
               </tr>
        </table>  
      
        <form>
            <div ng-repeat="emp in emps" >
                <table  class="w3-hoverable" style="background-color:gainsboro" >
                    <tr></tr>
                    <tr ng-click="pageshow=!pageshow" id="revid{{$index}}" >
                        <td ng-model="AssignmentNo" style="width:33%;text-align:left" >{{ emp.emid }}</td>
                        <td style="width:33%;text-align:left">{{ emp.screenName }}</td>
                        <td style="width: 33%;text-align:left" ng-init="status=backstatus(emp.talentReviewScoreCollection[0].status)" ng-model="status">{{status}}</td>
                        <td></td>
<!--                        <td>  <button class="w3-btn-group  w3-red w3-ripple"  ng-click="pageshow=!pageshow">&#10004; </button> </td>-->

                    </tr>
                </table>
                
       

                <div  ng-show="pageshow" >
                    
                    <table class="w3-table-all"  ng-show="personalshow">
                        <h class="w3-hoverable" style="font-size:20px" ng-click="personalshow=!personalshow" id="P{{$index}}">Personal Profile                        
                        <img ng-if="personalshow"  style="height:20px;width:20px"  src="../img/minus.png"   />
                        <img ng-if="!personalshow"  style="height:20px;width:20px" src="../img/plus.png"  /></h>

                   
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
                            <td></td>
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
                        <h class="w3-hoverable" style="font-size:20px" ng-click="suportshow=!suportshow" id="S{{$index}}">Supportive Information
                            <img ng-if="suportshow"  style="height:20px;width:20px"  src="../img/minus.png"   />
                        <img ng-if="!suportshow"  style="height:20px;width:20px" src="../img/plus.png"  /></h> 

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
                        <h style="font-size:20px;padding-top:-5px;position: relative;left:5%">Score</h> 
                         <h style="font-size:20px;padding-top:-5px;position: relative;left:40%">Comments</h> 
                        <tr>
                            <th class="minwidth">Achieving Results
                                <select  class="select-s1" ng-init="achievingResults=emp.talentReviewScoreCollection[0].achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                        ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="A{{$index}}">{{emp.id}}  
                                </select>
                                <a class="tip" id="I{{$index}}">?<span class="popbox"  style="z-index:999;">
                                1:{{emp.listCriteria[0].rule}}<br/>2:{{emp.listCriteria[1].rule}}<br/>3:{{emp.listCriteria[2].rule}}<br/>4:{{emp.listCriteria[3].rule}}<br/>5:{{emp.listCriteria[4].rule}}
                                 </span></a>
                            </th>
                          
                            
                            <th>
                                <input style="display:block;border:1px solid #B;height:32px;width:65%" type="text"
                                       ng-init="achievingResultsComment=emp.talentReviewScoreCollection[0].achievingResultsComment" 
                                       ng-model="achievingResultsComment" 
                                       placeholder="Comments Here   (*)"  ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                    ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="E{{$index}}" required>
                            </th>
                        </tr>
                        <tr>
                        <th>Organization Impact
                                  <select class="select-s2"  ng-model="orgImpact"  ng-options="act for act in number" 
                                            ng-init="orgImpact=emp.talentReviewScoreCollection[0].orgImpact" 
                                           ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="B{{$index}}"></select>
                          <a class="tip" id="J{{$index}}" >?<span class="popbox">1:{{emp.listCriteria[5].rule}}<br/>2:{{emp.listCriteria[6].rule}}<br/>3:{{emp.listCriteria[7].rule}}<br/>4:{{emp.listCriteria[8].rule}}<br/>5:{{emp.listCriteria[9].rule}}</span></a>
                        </th>
                   
                        <th>
                            <input style="display:block;border:1px solid #B;height:32px;width:65%"  type="text" ng-model="orgImpactComment"  placeholder="Comments Here   (*)"  
                                        ng-init="orgImpactComment=emp.talentReviewScoreCollection[0].orgImpactComment" 
                                   ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="F{{$index}}" required>
                         </th>
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th >Performance Total &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              {{achievingResults + orgImpact}}</th>
                        </tr>
                        <tr>
                            <th>Learning Agility        
                               <select class="select-s3"  ng-model="learningAgility"  ng-options="act for act in number" 
                                         ng-init="learningAgility=emp.talentReviewScoreCollection[0].learningAgility" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="C{{$index}}"></select>          
                           <a class="tip"  id="K{{$index}}">?<span class="popbox">1:{{emp.listCriteria[10].rule}}<br/>2:{{emp.listCriteria[11].rule}}<br/>3:{{emp.listCriteria[12].rule}}<br/>4:{{emp.listCriteria[13].rule}}<br/>5:{{emp.listCriteria[14].rule}}</span></a>
                            </th>
                           
                            <th>
                                <input style="display:block;border:1px solid #B;height:32px;width:65%"  type="text" ng-model="learningAgilityComment"  placeholder="Comments Here   (*)" 
                                        ng-init="learningAgilityComment=emp.talentReviewScoreCollection[0].learningAgilityComment" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="G{{$index}}" required>
                                    </th>
                        <tr>
                            <th>Versatility
                                 <select class="select-s4"  ng-model="versatility"  ng-options="act for act in number"  
                                          ng-init="versatility=emp.talentReviewScoreCollection[0].versatility" 
                                        ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)" id="D{{$index}}"></select>         
                          <a class="tip"  id="L{{$index}}">?<span class="popbox">1:{{emp.listCriteria[15].rule}}<br/>2:{{emp.listCriteria[16].rule}}<br/>3:{{emp.listCriteria[17].rule}}<br/>4:{{emp.listCriteria[18].rule}}<br/>5:{{emp.listCriteria[19].rule}}</span></a>
                            </th>
                           

                             <th> 
                                <input style="display:block;border:1px solid #B;height:32px;width:65%"  type="text" ng-model="versatilityComment"  placeholder="Comments Here   (*)" 
                                        ng-init="versatilityComment=emp.talentReviewScoreCollection[0].versatilityComment" 
                                       ng-blur="status=save(emp.id,achievingResults,orgImpact,learningAgility,versatility
                                             ,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)"id="H{{$index}}" required>
                                    </th>
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th>Potential Total  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              {{learningAgility + versatility}} </th>
                        </tr>
                        
                        <tr>
                            <th style="width: 33%;">Overall Rating &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             {{achievingResults + orgImpact}}/{{learningAgility + versatility }}</th>
                        </tr>
                        <tr>
                            <th>Talent Review Score&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{learningAgility + versatility + achievingResults + orgImpact}}</th>
                        </tr>
                        
                    </table>
<!--                    <button class="w3-btn w3-ripple" ng-click="pageshow=save(emp.id,achievingresults,orgimpact,learningagility,versatility,pageshow)" >&#9998; Save</button>-->
                </div>
                
            </div>
            
            <button class="w3-btn w3-red w3-ripple" ng-disabled="error || incomplete" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>
     
        </form>
        
        
        
    </div>
</body>
