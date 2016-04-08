<body ng-app="myApp" ng-controller="userCtrl" ng-model="p" ng-init="p = true" class="contentStyle">
    <link href="../css/hoverCss.css" rel="stylesheet" />
    <div class="contentStyle"  >
        <div style="height: 5px;width:100%;border-top: 1px solid black;"></div>
        <table style="text-align:left;font-size: 15px;">

            <span  ng-model="allstatus"></span>
            <tr>
                <th style="width:15%;">
                    <p style="padding: 0; margin: 0;float: left;">
                        Name
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
                <th style="width:15%;"  >
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
                <th style="width:13%;"  >
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
                <th style="width:8%;"  >
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
                <th style="width:27%;"  >
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
                <th style="width:12%;"  >
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
                <th style="width:12%;"  >
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
                    <input style="width: 70%" ng-model="filter1"id="filter1"/>
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

            </tr>
        </table>  
        
        <form style="margin-top: 5px;">
            <div  ng-repeat="emp in emps| orderBy:order:p | 
                        filter:{screenName : filter0}:false | 
                        filter:{performance : filter1}:false | 
                        filter:{potential : filter2}:false | 
                        filter:{total : filter3}:false | 
                        filter:{title : filter4}:false | 
                        filter:{role : filter5}:false  |
                        filter:{status: filter6}:false " >
                <table  class="w3-hoverable" style="background-color:gainsboro" >
                    <tr></tr>
                    <tr ng-click="pageshow = !pageshow" id="revid{{$index}}" >
                        <td id="p0{{$index}}" style="width:15%;text-align:left">{{ emp.screenName}}</td>
                        <td id="p1{{$index}}" style="width:15%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{emp.performance}} </td>
                        <td id="p2{{$index}}" style="width:13%;text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;{{emp.potential}} </td>
                        <td id="p3{{$index}}" style="width:8%;text-align:left">&nbsp;&nbsp;{{emp.total}}
                        <td id="p4{{$index}}" style="width:27%;text-align:left">{{emp.title}}
                        <td id="p5{{$index}}" style="width:12%;text-align:left">{{emp.role}}
                        <td id="p6{{$index}}" style="width:12%;text-align:left" ng-init="status = emp.score.status" ng-model="status">{{status}}</td>
                    </tr>
                </table>



                <div  ng-show="pageshow" >

                    <table class="w3-table-all"  ng-show="personalshow">

                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="personalshow = !personalshow" id="P{{$index}}">
                            <img ng-if="personalshow"  class="w1-img"   src="../img/up_1.png"   />
                            <img ng-if="!personalshow"  class="w1-img"  src="../img/down_1.png"  />
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
                        <h class="w3-hoverable" style="font-size:15px;cursor:pointer;" ng-click="suportshow = !suportshow" id="S{{$index}}">
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
                                         ng-init="achievingResults = emp.score.achievingResults" 
                                         ng-model="achievingResults"  ng-options="act for act in number" 
                                         ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                         , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="A{{$index}}">{{emp.id}}  
                                </select>

                                <a class="tip-1" id="I{{$index}}">?<span class="popbox"  style="z-index:999;"><ol>
                                            <li>{{findCriteriaByLevel("Achieves Results", emp.title)[0].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", emp.title)[1].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", emp.title)[2].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", emp.title)[3].rule}}</li><br/>
                                            <li>{{findCriteriaByLevel("Achieves Results", emp.title)[4].rule}}</li>
                                        </ol> </span></a>
                            </td>


                            <td class="minwidth2">
                                <textarea class="text-area" name="text" rows="4" cols="100"
                                          ng-disabled="editable()"
                                          ng-init="achievingResultsComment = emp.score.achievingResultsComment" 
                                          ng-model="achievingResultsComment" 
                                          placeholder="Comment Here   (*)"  ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                   , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="E{{$index}}" required></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Organization Impact</td>
                            <td >
                                <select class="select-s"  ng-disabled="editable()"
                                        ng-model="orgImpact"  ng-options="act for act in number" 
                                        ng-init="orgImpact = emp.score.orgImpact" 
                                        ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                           , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="B{{$index}}">

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
                                          ng-init="orgImpactComment = emp.score.orgImpactComment" 
                                          ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                               , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="F{{$index}}" required>
                                </textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Learning Agility   </td>
                            <td >     
                                <select class="select-s"  ng-disabled="editable()"
                                        ng-model="learningAgility"  ng-options="act for act in number" 
                                        ng-init="learningAgility = emp.score.learningAgility" 
                                        ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                       , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="C{{$index}}">

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
                                          ng-init="learningAgilityComment = emp.score.learningAgilityComment" 
                                          ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                   , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="G{{$index}}" required>
                                </textarea>
                            </td>
                        <tr>
                            <td>Versatility</td>
                            <td >
                                <select class="select-s"  ng-disabled="editable()"
                                        ng-model="versatility"  ng-options="act for act in number"  
                                        ng-init="versatility = emp.score.versatility" 
                                        ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                        , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)" id="D{{$index}}">

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
                                          ng-init="versatilityComment = emp.score.versatilityComment" 
                                          ng-blur="status = save(emp.id, achievingResults, orgImpact, learningAgility, versatility
                                                                   , achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)"id="H{{$index}}" required>
                                </textarea>
                            </td>
                        </tr>


                    </table>
                </div>
               
            </div>
             <button class="w3-btn w3-red w3-ripple"  ng-disabled="editable()" ng-click="postSubmit()" id="submitbt" ng-show="buttonshow">&#10004; Submit</button>
        </form>
    </div>
</body>
