<body ng-app="myApp" ng-controller="userCtrl" class="contentStyle">
    <div class="contentStyle"  >
        <table style="text-align:center">
               <tr>
                   <th style="width:400px;float:left;padding-bottom:5px ">Reviewee ID</th>
                    <th style="width:400px;float:left;">Name</th>
                    <th style="width:432.82px;float:left">status</th>
               </tr>
        </table>    
        <form >
            <div ng-repeat="emp in emps" >
                <table  class="w3-hoverable" >
                    <tr></tr>
                    <tr ng-click="pageshow=!pageshow">
                        <td ng-model="AssignmentNo" style="width:400px;text-align:center" >{{ emp.emid }}</td>
                        <td style="width:400px;text-align:center">{{ emp.screenName }}</td>
                        <td></td>
<!--                        <td>  <button class="w3-btn-group  w3-red w3-ripple"  ng-click="pageshow=!pageshow">&#10004; </button> </td>-->

                    </tr>
                </table>
                
        
                <div  ng-show="pageshow" >
                    
                    <table class="w3-table-all"  ng-show="personalshow">
                        <h style="font-size:20px" ng-click="personalshow=!personalshow">Personal Profile</h>
                        
                    <button  class="w3-btn w3-green w3-ripple" style="position: relative;right:83%;top:7px" ng-click="personalshow=!personalshow"  >                                      
                        </button>
                   
                        <tr>
                            <td >
                                Assignment No.
                                
                            </td>
                           
                            <td>
                                Name
                                
                            </td>
                            <td>
                               Start Level
                                
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
                            <td>{{emp.startLevel}}</td>
                            <td>{{emp.title}}</td>
                            <td>{{emp.role}}</td>
                        </tr>
                        <tr>
                            <td>
                                Last Promotion Date
                            </td>
                            <td>
                                GDC Working Experience
                                
                            </td>
                            <td>
                                Total Working Experience
                                
                            </td>
                            <td>
                               Departmen
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
                       <br>
                    <table class="w3-table-all"  ng-show="suportshow">
                        <h style="font-size:20px" ng-click="suportshow=!suportshow" >Supportive Information </h> 
                         <button  class="w3-btn w3-green w3-ripple" style="position: relative;right:78%;top:7px" ng-click="suportshow=!suportshow"  >      
                                
                        </button>
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
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
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
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                            <td>{{emp.id}}</td>
                              <td></td>
                        </tr>
                    </table>
                    <br>
                    <table class="table-s">
                        <h style="font-size:20px;padding-top:-5px">Score</h> 
                        <tr>
                            <th>Achieving Results
                                <select  class="select-s1" ng-model="achievingresults"  ng-options="act for act in number" ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>
                                
                            </th>
<!--                             <td>Comment:
                                <input class="w3-input w3-border" type="text" ng-model="ARComment"  placeholder="Comments Here"  required>
                              </td>-->
                        </tr>
                        <th >Organization Impact
                                  <select class="select-s2"  ng-model="orgimpact"  ng-options="act for act in number" ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>
                            
                        </th>
                        <!-- <td>Comment:
                            <input class="w3-input w3-border" type="text" ng-model="OIComment"  placeholder="Comments Here"  required>
                                </td>-->
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th >Performance Total &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              {{achievingresults + orgimpact}}</th>
                        </tr>
                        <tr>
                            <th>Learning Agility        
                               <select class="select-s3"  ng-model="learningagility"  ng-options="act for act in number" ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>          
                            </th>
                            <!--<td>Comment:
                                <input class="w3-input w3-border" type="text" ng-model="LAComment"  placeholder="Comments Here"  required>
                                    </td>-->
                        <tr>
                            <th>Versatility
                                 <select class="select-s4"  ng-model="versatility"  ng-options="act for act in number"  ng-blur="save(emp.emid,achievingresults,orgimpact,learningagility,versatility)"></select>         
                            </th>
                            

                            
                            
                            
                            
                            
                            
                            <!--		 <td> Comment:
                                <input class="w3-input w3-border" type="text" ng-model="VSComment"  placeholder="Comments Here"  required>
                                    </td>-->
                        </tr>
                        <tr style="background-color:#f1f1f1">
                            <th>Potential Total  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              {{learningagility + versatility}} </th>
                        </tr>
                        
                        <tr>
                            <th style="width: 280px;">Overall Rating &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            {{achievingresults + orgimpact}}/{{learningagility + versatility }}</th>
                        </tr>
                        <tr>
                            <th>Talent Review Score&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{learningagility + versatility + achievingresults + orgimpact}}</th>
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
