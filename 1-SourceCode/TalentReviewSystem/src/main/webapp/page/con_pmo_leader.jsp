<body ng-app="myApp1"  class="contentStyle" ng-controller="pmoCtrl" ng-model="app1">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <div style="height: 5px;width:100%;border-top: 1px solid black;"></div>
        <table style="text-align:left;font-size: 15px;">
            <tr>
                <th style="width:12%;">
                    <p style="padding: 0; margin: 0;float: left;">
                        Reviewer
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('reviewername');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('reviewername');" />
                        </li>
                    </ul>


                </th>
                <th style="width:12%;">
                    <p style="padding: 0; margin: 0;float: left;">
                        Reviewee
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('screenName');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('screenName');" />
                        </li>
                    </ul>


                </th>
                <th style="width:12%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Performance
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('performance');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('performance');" />
                        </li>
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Potential
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('potential');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('potential');" />
                        </li>
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Total
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('total');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('total');" />
                        </li>
                    </ul>
                </th>
                <th style="width:24%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Level
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('title');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('title');" />
                        </li>
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Role
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('role');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('role');" />
                        </li>
                    </ul>
                </th>
                <th style="width:10%;"  >
                    <p style="padding: 0; margin: 0;float: left;">
                        Status
                    </p>
                    <ul style="list-style: none;float: left;margin: 0; width: 10px; margin-left: 3px;">
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/up.png"  ng-click="order = sorterUp('status');" />
                        </li>
                        <li style="width: 8px;height: 8px;">
                            <img style="width: 8px;height: 8px;" class="w1-img" src="../img/down.png"  ng-click="order = sorterDown('status');" />
                        </li>
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
                    <tr ng-click="pageshow = !pageshow" id="revid{{$parent.$index}}{{$index}}" > 
                        <td style="width:12%;text-align:left">{{ pmo.reviewername}}</td>
                        <td style="width:12%;text-align:left">{{ pmo.screenName}}</td>
                        <td style="width:12%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{achievingResults + orgImpact}} </td>
                        <td style="width:10%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;{{learningAgility + versatility}} </td>
                        <td style="width:10%;text-align:left">&nbsp;&nbsp;{{achievingResults + orgImpact + learningAgility + versatility}}
                        <td id="p5{{$index}}" style="width:24%;text-align:left">{{pmo.title}}</td>
                        <td id="p6{{$index}}" style="width:10%;text-align:left">{{pmo.role}}</td>
                        <td style="width:10%;text-align:left" ng-init="status = pmo.status" ng-model="status" >{{status}}</td>
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
                            <td>{{pmo.emid}}</td>
                            <td>{{pmo.gdcExperience}}</td>
                            <td>{{pmo.workExperience}}</td>
                            <td>{{pmo.lastPromotionDate}}</td>
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
                                         ng-init="achievingResults = pmo.score.achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                             , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="A{{$parent.$index}}{{$index}}">{{pmo.id}}  
                                </select>
                                <a class="tip-1" id="I{{$parent.$index}}{{$index}}">?<span class="popbox"  style="z-index:999;"><ol>
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
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="E{{$parent.$index}}{{$index}}" required></textarea>
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
                                          ng-init="orgImpactComment = pmo.score.orgImpactComment" 
                                          ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
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
                                        ng-init="learningAgility = pmo.score.learningAgility" 
                                        ng-blur="status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
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
                                          ng-init="learningAgilityComment = pmo.score.learningAgilityComment" 
                                          ng-blur=" status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="G{{$parent.$index}}{{$index}}" required>
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
                                          ng-init="versatilityComment = pmo.score.versatilityComment" 
                                          ng-blur=" status = save(pmo.id, achievingResults, orgImpact, learningAgility, versatility
                                                                          , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)"id="H{{$parent.$index}}{{$index}}" required>
                                </textarea>
                            </td>
                        </tr>                        

                    </table>
                    <table>
                        <tr><button class="w3-btn w3-red w3-ripple"  ng-disabled="editable(status)" ng-click="status = postSubmit(pmo.id, achievingResults, orgImpact, learningAgility,
                                                    versatility, achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId)" id="submitbt{{$parent.$index}}{{$index}}" >approve</button></tr>
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
