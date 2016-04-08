<body ng-app="myApp1"  class="contentStyle" ng-controller="pmoCtrl" ng-model="app1">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <div style="height: 5px;width:100%;border-top: 1px solid black;"></div>
        <table style="text-align:left;font-size: 15px;">
            <tr>
                <th style="width:12%;float:left;">Reviewer</th>
                <th style="width:12%;float:left;">Reviewee</th>

                <th style="width:12%;float:left"  >Performance </th>
                <th style="width:10%;float:left"  >Potential </th>
                <th style="width:10%;float:left"  >Total</th>
                <th style="width:24%;float:left" >Level</th>
                <th style="width:10%;float:left" >Role</th>
                <th style="width:10%;float:left">Status</th>
            </tr>
        </table> 

        <div  ng-repeat="pmo in pmos| orderBy:'reviewname'" >
            <div  class="w1-form">

                <div ng-repeat="emp in pmo.emp| orderBy:'screenName' | filter:filt" >
                    <table  class="w1-hoverable" style="background-color:ff3333;" >
                        <tr></tr>
                        <input type="hidden"  ng-init="reviewerId = emp.score.reviewerId" ng-model="reviewerId" >
                        <input type="hidden"  ng-init="pmoId = emp.score.pmoId" ng-model="pmoId" >
                        <tr ng-click="pageshow = !pageshow" id="revid{{$parent.$index}}{{$index}}" > 
                            <td style="width:12%;text-align:left">{{ pmo.reviewname}}</td>
                            <td style="width:12%;text-align:left">{{ emp.screenName}}</td>
                            <td style="width:12%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{achievingResults + orgImpact}} </td>
                            <td style="width:10%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;{{learningAgility + versatility}} </td>
                            <td style="width:10%;text-align:left">&nbsp;&nbsp;{{achievingResults + orgImpact + learningAgility + versatility}}
                            <td id="p5{{$index}}" style="width:24%;text-align:left">{{emp.title}}</td>
                            <td id="p6{{$index}}" style="width:10%;text-align:left">{{emp.role}}</td>
                            <td style="width:10%;text-align:left" ng-init="status = emp.score.status" ng-model="status" >{{status}}</td>
                        </tr>
                    </table>



                    <div  ng-show="pageshow" >

                        <table class="w3-table-all"  ng-show="personalshow">

                            <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="personalshow = !personalshow" id="P{{$parent.$index}}{{$index}}">
                                <img ng-if="personalshow"  class="w1-imgpmo"  src="../img/up_1.png"   />
                                <img ng-if="!personalshow"  class="w1-imgpmo" src="../img/down_1.png"  />
                                Personal Profile                        
                            </h>
                            <tr>
                                <td >
                                    Employee ID
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
                            <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="suportshow = !suportshow" id="S{{$parent.$index}}{{$index}}">
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
                            <td></td>

                            <td><h style="font-size:15px;padding-top:-5px;text-align: left; left: 40%"><b>Comment</b></h></td>
                            </tr>
                            <tr>
                                <td class="minwidth">Achieving Results
                                </td>
                                <td class="minwidth">
                                    <select  class="select-s"  
                                             ng-disabled="editable(status)"
                                             ng-init="achievingResults = emp.score.achievingResults" 
                                             ng-model="achievingResults"  ng-options="act for act in number" 
                                             ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                             , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="A{{$parent.$index}}{{$index}}">{{emp.id}}  
                                    </select>
                                    <a class="tip-1" id="I{{$parent.$index}}{{$index}}">?<span class="popbox"  style="z-index:999;"><ol>
                                                <li>{{findCriteriaByLevel("Achieves Results", emp.title)[0].rule}}</li><br/>
                                                <li>{{findCriteriaByLevel("Achieves Results", emp.title)[1].rule}}</li><br/>
                                                <li>{{findCriteriaByLevel("Achieves Results", emp.title)[2].rule}}</li><br/>
                                                <li>{{findCriteriaByLevel("Achieves Results", emp.title)[3].rule}}</li><br/>
                                                <li>{{findCriteriaByLevel("Achieves Results", emp.title)[4].rule}}</li>
                                            </ol> </span></a>
                                </td>


                                <td class="minwidth2">
                                    <textarea class="text-area" name="text" rows="4" cols="100"
                                              ng-disabled="editable(status)"
                                              ng-init="achievingResultsComment = emp.score.achievingResultsComment" 
                                              ng-model="achievingResultsComment" 
                                              placeholder="Comment Here   (*)"  ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                       , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="E{{$parent.$index}}{{$index}}" required></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>Organization Impact
                                </td>
                                <td >
                                    <select class="select-s"  ng-disabled="editable(status)"
                                            ng-model="orgImpact"  ng-options="act for act in number" 
                                            ng-init="orgImpact = emp.score.orgImpact" 
                                            ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                               , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="B{{$parent.$index}}{{$index}}"></select>
                                    <a class="tip-1" id="J{{$parent.$index}}{{$index}}" >?<span class="popbox"><ol>
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
                                              ng-init="orgImpactComment = emp.score.orgImpactComment" 
                                              ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                   , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="F{{$parent.$index}}{{$index}}" required>
                                    </textarea>
                                </td>
                            </tr>

                            <tr>
                                <td>Learning Agility 
                                </td>
                                <td >
                                    <select class="select-s"  ng-disabled="editable(status)"
                                            ng-model="learningAgility"  ng-options="act for act in number" 
                                            ng-init="learningAgility = emp.score.learningAgility" 
                                            ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                           , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="C{{$parent.$index}}{{$index}}"></select>          
                                    <a class="tip-1"  id="K{{$parent.$index}}{{$index}}">?<span class="popbox"><ol>
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
                                              ng-init="learningAgilityComment = emp.score.learningAgilityComment" 
                                              ng-blur=" status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                       , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="G{{$parent.$index}}{{$index}}" required>
                                    </textarea>
                                </td>
                            <tr>
                                <td>Versatility
                                </td>
                                <td >
                                    <select class="select-s"  ng-disabled="editable(status)"
                                            ng-model="versatility"  ng-options="act for act in number"  
                                            ng-init="versatility = emp.score.versatility" 
                                            ng-blur=" status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                            , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="D{{$parent.$index}}{{$index}}"></select>         
                                    <a class="tip-1"  id="L{{$parent.$index}}{{$index}}">?<span class="popbox"><ol>
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
                                              ng-init="versatilityComment = emp.score.versatilityComment" 
                                              ng-blur=" status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                       , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)"id="H{{$parent.$index}}{{$index}}" required>
                                    </textarea>
                                </td>
                            </tr>                        

                        </table>
                        <table>
                            <tr><button class="w3-btn w3-red w3-ripple"  ng-disabled="editable(status)" ng-click="status = postSubmit(emp.id, achievingResults, orgImpact, learningAgility,
                                                    versatility, achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="submitbt{{$parent.$index}}{{$index}}" >approve</button></tr>
                        </table>
                    </div>
                </div>
                <!--<button class="w3-btn w3-red w3-ripple"  ng-disabled="editable()" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>-->

            </div>  

        </div>

        <table>
            <tr></tr>

        </table>

    </div>
</body>
