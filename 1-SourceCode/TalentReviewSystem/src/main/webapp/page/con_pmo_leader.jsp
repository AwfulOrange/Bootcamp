<body ng-app="myApp1"  class="contentStyle" ng-controller="pmoCtrl" ng-model="app1">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <div style="height: 15px;width:100%;border-top: 0;"></div>
        <table style="text-align:left;font-size: 15px;">
            <tr>
                <th style="width:12%;">
                    <p style="padding: 0; margin: 0;float: left;">
                        Reviewer
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        
                            <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order1=!order1;order = sorterUp('reviewername');" ng-show="order1"/>                       
                            <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order1=!order1;order = sorterDown('reviewername');" ng-show="!order1"/>

                    </ul>


                </th>
                <th style="width:12%;">
                    <p style="padding: 0; margin: 0;float: left;">
                        Reviewee
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order2=!order2;order = sorterUp('screenName');" ng-show="order2"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order2=!order2;order = sorterDown('screenName');" ng-show="!order2"/>
                      
                    </ul>


                </th>
                <th style="width:12%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Performance
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                       <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order3=!order3;order = sorterUp('performance');" ng-show="order3"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order3=!order3;order = sorterDown('performance');" ng-show="!order3"/>
                      
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Potential
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                         <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order4=!order4;order = sorterUp('potential');" ng-show="order4"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order4=!order4;order = sorterDown('potential');" ng-show="!order4"/>
                       
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Total
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                       <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order5=!order5;order = sorterUp('total');" ng-show="order5"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order5=!order5;order = sorterDown('total');" ng-show="!order5"/>
                       
                       
                    </ul>
                </th>
                <th style="width:24%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Level
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order6=!order6;order = sorterUp('title');" ng-show="order6"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order6=!order6;order = sorterDown('title');" ng-show="!order6"/>
                       
               
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Role
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                         <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order7=!order7;order = sorterUp('role');" ng-show="order7"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order7=!order7;order = sorterDown('role');" ng-show="!order7"/>
                     
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Status
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                     <img style="width: 15px;height: 15px;" class="w1-img" src="../img/up.png"  ng-click="order8=!order8;order = sorterUp('status');" ng-show="order8"/>                       
                        <img style="width: 15px;height: 15px;" class="w1-img" src="../img/down.png"  ng-click="order8=!order8;order = sorterDown('status');" ng-show="!order8"/>
                    </ul>
                </th>
            </tr>
             <tr>
                  <td >
                    <input style="width: 70%" ng-model="filter0" id="filter0"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter1" id="filter1"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter2"id="filter2"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter3"id="filter3"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter4"id="filter4"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter5"id="filter5"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter6"id="filter6"/>
                </td>
                <td >
                    <input style="width: 70%" ng-model="filter7"id="filter7"/>
                </td>

            </tr>

        </table> 
        
        <div style="margin-top: 10px;height: 5px;width:100%;border-bottom: 3px solid #b3b3b3;"></div>
        
        <div  ng-repeat="pmo in pmos| orderBy:order:p | 
                    filter:{reviewername : filter0}:false|
                    filter:{screenName : filter1}:false | 
                    filter:{performance : filter2}:false |
                    filter:{potential : filter3}:false | 
                    filter:{total : filter4}:false |
                    filter:{title : filter5}:false | 
                    filter:{role : filter6}:false |
                    filter:{status : filter7}:false " >
            <div  class="w1-form">
                <table  class="w1-hoverable" style="background-color:ff3333;" >
                    <tr></tr>
                    <input type="hidden"  ng-init="reviewerId = pmo.score.reviewerId" ng-model="reviewerId" >
                    <input type="hidden"  ng-init="pmoId = pmo.score.pmoId" ng-model="pmoId" >
                    <tr ng-click="pageshow = !pageshow" id="revid{{$index}}" > 
                        <td id="p0{{$index}}" style="width:12%;text-align:left">{{ pmo.reviewername}}</td>
                        <td id="p1{{$index}}" style="width:12%;text-align:left">{{ pmo.screenName}}</td>
                        <td id="p2{{$index}}" style="width:12%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{achievingResults + orgImpact}} </td>
                        <td id="p3{{$index}}" style="width:10%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;{{learningAgility + versatility}} </td>
                        <td id="p4{{$index}}" style="width:10%;text-align:left">&nbsp;&nbsp;{{achievingResults + orgImpact + learningAgility + versatility}}
                        <td id="p5{{$index}}" style="width:24%;text-align:left">{{pmo.title}}</td>
                        <td id="p6{{$index}}" style="width:10%;text-align:left">{{pmo.role}}</td>
                        <td style="width:10%;text-align:left" ng-init="status = pmo.status" ng-model="status" >{{status}}</td>
                    </tr>
                </table>



                <div  ng-show="pageshow" >

                    <table class="w3-table-all"  ng-show="personalshow">

                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="personalshow = !personalshow" id="P{{$index}}">
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
                            <td>{{pmo.emid}}</td>
                            <td>{{pmo.gdcExperience}}</td>
                            <td>{{pmo.workExperience}}</td>
                            <td>{{pmo.lastPromotionDate}}</td>
                        </tr>

                    </table>
                    <br>
                    <table class="w3-table-all"  ng-show="suportshow">
                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="suportshow = !suportshow" id="S{{$index}}">
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
                                         ng-init="achievingResults = pmo.score.achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                             , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="A{{$index}}">{{pmo.id}}  
                                </select>
                                <a class="tip-1" id="I{{$index}}">?<span class="popbox"  style="z-index:999;"><ol>
                                            <li>{{findCriteriaByLevel("Achieves Results", pmo.title)[0].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", pmo.title)[1].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", pmo.title)[2].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", pmo.title)[3].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", pmo.title)[4].rule}}</li>
                                        </ol> </span></a>
                            </td>


                            <td class="minwidth2">
                                <textarea class="text-area" name="text" rows="4" cols="100"
                                          ng-disabled="editable(status)"
                                          ng-init="achievingResultsComment = pmo.score.achievingResultsComment" 
                                          ng-model="achievingResultsComment" 
                                          placeholder="Comment Here   (*)"  ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="E{{$index}}" required></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Organization Impact
                            </td>
                            <td >
                                <select class="select-s"  ng-disabled="editable(status)"
                                        ng-model="orgImpact"  ng-options="act for act in number" 
                                        ng-init="orgImpact = pmo.score.orgImpact" 
                                        ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                            , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="B{{$index}}"></select>
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
                                          ng-disabled="editable(status)"
                                          ng-init="orgImpactComment = pmo.score.orgImpactComment" 
                                          ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="F{{$index}}" required>
                                </textarea>
                            </td>
                        </tr>

                        <tr>
                            <td>Learning Agility 
                            </td>
                            <td >
                                <select class="select-s"  ng-disabled="editable(status)"
                                        ng-model="learningAgility"  ng-options="act for act in number" 
                                        ng-init="learningAgility = pmo.score.learningAgility" 
                                        ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                            , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="C{{$index}}"></select>          
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
                                          ng-disabled="editable(status)"
                                          ng-init="learningAgilityComment = pmo.score.learningAgilityComment" 
                                          ng-blur=" status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="G{{$index}}" required>
                                </textarea>
                            </td>
                        <tr>
                            <td>Versatility
                            </td>
                            <td >
                                <select class="select-s"  ng-disabled="editable(status)"
                                        ng-model="versatility"  ng-options="act for act in number"  
                                        ng-init="versatility = pmo.score.versatility" 
                                        ng-blur=" status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                            , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="D{{$index}}"></select>         
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
                                          ng-disabled="editable(status)"
                                          ng-init="versatilityComment = pmo.score.versatilityComment" 
                                          ng-blur=" status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)"id="H{{$index}}" required>
                                </textarea>
                            </td>
                        </tr>                        

                    </table>
                    <table>
                        <tr><button class="w3-btn w3-red w3-ripple"  ng-disabled="editable(status)" ng-click="status = postSubmit(pmo.id, achievingResults, orgImpact, learningAgility,
                                                    versatility, achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="submitbt{{$index}}" >approve</button></tr>
                    </table>
                </div>
                <!--</div>-->
                <!--<button class="w3-btn w3-red w3-ripple"  ng-disabled="editable()" ng-click="postSubmit()" id="submitbt">&#10004; Submit</button>-->

            </div>  

        </div>

        <table>
            <tr></tr>

        </table>

    </div>
</body>
