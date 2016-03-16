<body ng-app="myApp" ng-controller="userCtrl" class="contentStyle">
    <div class="contentStyle"  >
        <h3>Talent Review </h3> 
        <form >
            <div ng-repeat="emp in emps">
                <table  class="w3-table w3-bordered w3-striped">
                    <tr>
                        <th>Reviewee ID</th>
                        <th>Name</th>
                        
                        <!--	<th>Review</th>-->
                    </tr>
                    <tr>
                        <td ng-model="AssignmentNo">{{ emp.id }}</td>
                        <td>{{ emp.screenName }}</td>
                        
                        <td>  <button class="w3-btn w3-green w3-ripple"  ng-click="pageshow=!pageshow">&#10004; </button> </td>
                        <td>
                            
                        </td>
                    </tr>
                </table>
                
                
                <div  ng-show="pageshow">
                    
                    <table >
                        <h3>Personal Profile</h3> 
                        <tr>
                            <td>
                                <label>AssignmentNo</label>
                                
                            </td>
                            <td>
                                <label>English name :</label>
                                
                            </td>
                            <td>
                                <label>Chinese Name:</label>
                                
                            </td>
                            <td>
                                <label>Start Level:</label>
                                
                            </td>
                            <td>
                                <label>Perficient Level:</label>
                            </td>
                        </tr>
                        <tr>
                            <td>{{emp.id}}</td>
                            <td>{{emp.screenName}}</td>
                            <td>{{emp.screenName}}</td>
                            <td>{{emp.startLevel}}</td>
                            <td>{{emp.title}}</td>
                        </tr>
                        <tr>
                            <td>
                                <label>Role:</label>
                            </td>
                            <td>
                                <label>Last Promotion Date:</label>
                            </td>
                            <td>
                                <label>GDC Working Experience:</label>
                                
                            </td>
                            <td>
                                <label>Total Working Experience:</label>
                                
                            </td>
                            <td>
                                <label>Department:</label>
                            </td>
                        </tr>
                        <tr>
                            <td>{{emp.role}}</td>
                            <td>{{emp.lastPromotionDate}}</td>
                            <td>{{emp.gdcStart}}</td>
                            <td></td>
                            <td>{{emp.bu}}</td>
                        </tr>
                        
                    </table>
                    
                    <table style="boder:1px">
                        <h3 >Supportive Information </h3> 
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
                            
                        </tr>
                        <tr>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                        </tr>
                    </table>
                    
                    <table class="w3-table w3-bordered w3-striped">
                        <h3>Score</h3> 
                        <tr>
                            <th>Achieving Results:&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="number"   ng-model="achievingresults" name='achievingresults' ng-pattern='/^\d+$/' min="1" max="5"    style="width:150px;height: 40px" required >
                                
                            </th>
                            <!--  <td>Comment:
                                <input class="w3-input w3-border" type="text" ng-model="ARComment"  placeholder="Comments Here"  required>
                              </td>-->
                        </tr>
                        <th>Organization Impact:
                            <input type="number"   ng-model="orgimpact "  ng-pattern='/^\d+$/' min="1" max="5"  name='orgimpact'   style="width:150px;height: 40px" required>
                            
                        </th>
                        <!-- <td>Comment:
                            <input class="w3-input w3-border" type="text" ng-model="OIComment"  placeholder="Comments Here"  required>
                                </td>-->
                        </tr>
                        <tr>
                            <th>Performance Total: {{achievingresults + orgimpact}}</th>
                        </tr>
                    </table>
                    <br>
                    <br>
                    <table class="w3-table w3-bordered w3-striped">
                        <tr>
                            <th>Learning Agility :   &nbsp; &nbsp;&nbsp;        
                                <input type="number"  ng-model="learningagility" ng-pattern='/^\d+$/' min="1" max="5"   name='learningagility'   style="width:150px;height: 40px" required>            
                            </th>
                            <!--	 <td>Comment:
                                <input class="w3-input w3-border" type="text" ng-model="LAComment"  placeholder="Comments Here"  required>
                                    </td>-->
                        <tr>
                            <th>Versatility:&nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp;    
                                <input type="number"  ng-model="versatility" ng-pattern='/^\d+$/' min="1" max="5"   name='versatility' style="width:150px;height: 40px" required>
                                
                            </th>
                            <!--		 <td> Comment:
                                <input class="w3-input w3-border" type="text" ng-model="VSComment"  placeholder="Comments Here"  required>
                                    </td>-->
                        </tr>
                        <tr>
                            <th>Potential Total:  {{learningagility + versatility}} </th>
                        </tr>
                        
                        <tr>
                            <th>Overall Rating: {{achievingresults + orgimpact+"/"}}{{learningagility + versatility }}</th>
                        </tr>
                        <tr>
                            <th>Talent Review Score:{{learningagility + versatility + achievingresults + orgimpact}}</th>
                        </tr>
                        
                    </table>
                    <button class="w3-btn w3-ripple" ng-click="pageshow=save(emp.id,achievingresults,orgimpact,learningagility,versatility,pageshow)" >&#9998; Save</button>
                </div>
                
            </div>
            
            <button class="w3-btn w3-green w3-ripple" ng-disabled="error || incomplete" ng-click="postSubmit()">&#10004; Submit</button>
            <p>{{msg}}</p>
        </form>
        
        
        
    </div>
</body>
