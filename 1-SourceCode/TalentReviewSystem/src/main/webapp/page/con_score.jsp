<body ng-app="myApp" ng-controller="userCtrl" class="contentStyle">
    <div class="contentStyle"  >
        <table class="table">
               <tr>
                   <th style="width:200px">Reviewee ID</th>
                    <th style="width:400px">Name</th>
  
               </tr>
        </table>    
        <form >
            <div ng-repeat="emp in emps" >
                <table  class="w3-hoverable" style="background-color:#CCCCFF">
                    <tr>
                    </tr>
                    <tr ng-click="pageshow=!pageshow">
                        <td ng-model="AssignmentNo" style="width:400px" >{{ emp.emid }}</td>
                        <td style="width:400px">{{ emp.screenName }}</td>
                        
<!--                        <td>  <button class="w3-btn-group  w3-red w3-ripple"  ng-click="pageshow=!pageshow">&#10004; </button> </td>-->
                        <td>
                            
                        </td>
                    </tr>
                </table>
                
                
                <div  ng-show="pageshow">
                    
                    <table class="w3-table-all" ng-show="personalshow">
                        <h style="font-size: 20px" ng-click="personalshow=!personalshow">Personal Profile</h>
                        <tr>
                            <td>
                                <label>AssignmentNo</label>
                                
                            </td>
                           
                            <td>
                                <label>Name</label>
                                
                            </td>
                            <td>
                                <label>Start Level</label>
                                
                            </td>
                            <td>
                                <label>Perficient Level</label>
                            </td>
                            <td>
                                <label>Role</label>
                            </td>
                        </tr>
                        <tr>
                            <td>{{emp.emid}}</td>
                            <td>{{emp.screenName}}</td>
                            <td>{{emp.startLevel}}</td>
                            <td>{{emp.title}}</td>
                            <td>{{emp.role}}</td>
                        </tr>
                        <tr>
                            <td>
                                <label>Last Promotion Date</label>
                            </td>
                            <td>
                                <label>GDC Working Experience</label>
                                
                            </td>
                            <td>
                                <label>Total Working Experience</label>
                                
                            </td>
                            <td>
                                <label>Department</label>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                    
                            <td>{{emp.lastPromotionDate}}</td>
                            <td>{{emp.gdcStart}}</td>
                            <td></td>
                            <td>{{emp.bu}}</td>
                            <td></td>
                        </tr>
                        
                    </table>
                    <p></p>
                    <table class="w3-table-all"  ng-show="suportshow">
                        <h style="font-size:20px" ng-click="suportshow=!suportshow" >Supportive Information </h> 
                        
                        <tr>
                            <td>
                                <label>Award</label>
                            </td>
                            <td>
                                <label>Time entry compliance  </label>
                            </td>
                            <td>
                                <label>Company activity</label>
                            </td>
                            <td>
                                <label>Culture Committee </label>
                            </td>
                            <td>
                                <label>Training</label>
                            </td>
                          
                            
                        </tr>
                        <tr>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <label>Recruiting</label>
                                
                            </td>
                            <td>
                                <label>Certification</label>
                                
                            </td>
                            <td>
                                <label>Blog</label>
                                
                            </td>
                            <td>
                                <label>Center of Expertise</label>
                            </td>
                              <td></td>
                            
                        </tr>
                        <tr>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                              <td></td>
                        </tr>
                    </table>
                    <p></p>
                    <table class="table-s">
                        <h style="font-size:20px">Score</h> 
                        <tr>
                            <th>Achieving Results&nbsp;&nbsp;&nbsp;&nbsp;
                                <select  class="select-s" ng-model="achievingresults"  ng-options="act for act in number" ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>
                                
                            </th>
<!--                             <td>Comment:
                                <input class="w3-input w3-border" type="text" ng-model="ARComment"  placeholder="Comments Here"  required>
                              </td>-->
                        </tr>
                        <th >Organization Impact
                                  <select class="select-s"  ng-model="orgimpact"  ng-options="act for act in number" ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>
                            
                        </th>
                        <!-- <td>Comment:
                            <input class="w3-input w3-border" type="text" ng-model="OIComment"  placeholder="Comments Here"  required>
                                </td>-->
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th >Performance Total {{achievingresults + orgimpact}}</th>
                        </tr>
                        <tr>
                            <th>Learning Agility    &nbsp; &nbsp;&nbsp;        
                               <select class="select-s"  ng-model="learningagility"  ng-options="act for act in number" ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>          
                            </th>
                            <!--<td>Comment:
                                <input class="w3-input w3-border" type="text" ng-model="LAComment"  placeholder="Comments Here"  required>
                                    </td>-->
                        <tr>
                            <th>Versatility&nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;
                                 <select class="select-s"  ng-model="versatility"  ng-options="act for act in number"  ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>         
                            </th>
                            

                            
                            
                            
                            
                            
                            
                            <!--		 <td> Comment:
                                <input class="w3-input w3-border" type="text" ng-model="VSComment"  placeholder="Comments Here"  required>
                                    </td>-->
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th>Potential Total  {{learningagility + versatility}} </th>
                        </tr>
                        
                        <tr>
                            <th>Overall Rating {{achievingresults + orgimpact+"/"}}{{learningagility + versatility }}</th>
                        </tr>
                        <tr>
                            <th>Talent Review Score{{learningagility + versatility + achievingresults + orgimpact}}</th>
                        </tr>
                        
                    </table>
<!--                    <button class="w3-btn w3-ripple" ng-click="pageshow=save(emp.id,achievingresults,orgimpact,learningagility,versatility,pageshow)" >&#9998; Save</button>-->
                </div>
                
            </div>
            
            <button class="w3-btn w3-green w3-ripple" ng-disabled="error || incomplete" ng-click="postSubmit()">&#10004; Submit</button>
            <p>{{msg}}</p>
        </form>
        
        
        
    </div>
</body>
