angular.module('myApp', []).controller('userCtrl', function($scope,$http) {

var empslength=0;
$http.get("http://localhost:8080/TRS/web/employee/")
.success(function (data) {
    $scope.emps = data;    
    empslength=data.length;
    changestatus(data);
});
var allscore=[];
$scope.save=function(id,achievingResults,orgImpact,learningAgility,
versatility,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)
{
    var scoredata={
        employeeId:id,
        achievingResults:achievingResults,
        orgImpact:orgImpact,
        learningAgility:learningAgility,
        versatility:versatility,
        achievingResultsComment:achievingResultsComment,
        orgImpactComment:orgImpactComment,
        learningAgilityComment:learningAgilityComment,
        versatilityComment:versatilityComment,
         status:statustoNum(status)
    };
    allscore.push(scoredata);
    for(var i=0;i<allscore.length;i++)
    {
        for(var j=i+1;j<allscore.length;j++)
        {
            if(allscore[i].employeeId==allscore[j].employeeId)
            {
                allscore.splice(i,1);
                j--;
            }
        }
    }
  // console.log(allscore);
    
    $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){
         
    }).error(function(data) {
     alert("Save fail!");
    });            
      if(  checkScoredata(scoredata)==false)
      {
       return "Saved,but Unfinished";
      }
      else 
        return "Saved";
}
    var checkScoredata=function(data){
        if(data.employeeId==undefined){
                    return false; 
                }else if(data.achievingResults==undefined){
                    return false; 
                }else if(data.orgImpact==undefined){
                    return false; 
                }else if(data.learningAgility==undefined){
                    return false; 
                }else if(data.versatility==undefined){
                    return false; 
                }
                else if(data.achievingResultsComment==undefined){
                    return false; 
                }
                else if(data.orgImpactComment==undefined){
                    return false; 
                }
                else if(data.learningAgilityComment==undefined){
                    return false; 
                }
                else if(data.versatilityComment==undefined){
                    return false; 
                }
    }
    var valid=function(){
//        var a=true; 

        if(allscore.length!=empslength)
        {
            return false;       
        }
        for(var i=0;i<allscore.length;i++)
        {
           if(checkScoredata(allscore[i])==false){
               return false;
           }
              
  
        }
        return true;
    }

$scope.postSubmit = function()
{          
       if(valid()){
            $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){      
                      for(var i=0;i<allscore.length;i++)
         {
          allscore[i].status=2;
         }
           for(var i=0;i<$scope.emps.length;i++)
         {
          $scope.emps[i].status="Submitted";
         }     
            alert("Submit successfully!");

            allsocre.status="Submitted";
     
       }).error(function(data) {
           alert("Sorry,Fail to send message!" );
       });
       }
        else
      { alert("Please input all data!");}   
};


 $scope.number=[1,2,3,4,5 ];
var changestatus=function(data){
     for(var i=0;i<empslength;i++)
    {
        if(data[i].status==undefined)
        {
            data[i].status="Unfinished";
        }
        else if(data[i].status==1)
        {
            data[i].status=="Saved"
        }
        else if(data[i].status==2) 
            data[i].status=="Submitted";
        else 
            data[i].status=="Saved,but Unfinished"
        //  console.log(data[i].status);
    }
 }
$scope.backstatus=function(status)
{
    if(status==1)
    {
      status="Saved";
    }
    else if (status==0)
    {
      status="Unfinished";
    }
    else if(status==2) 
        status="Submitted";
    else if(status==3)
        status="Saved,but Unfinished";
    
    return status;
}
var statustoNum=function(status)
{
      if( status=="Saved")
      {
          status=1;
      }
      else if(status=="Unfinished")
      {
          status=0;
      }
            else if(status=="Saved,but Unfinished")
      {
          status=3;
      }
            else if(status=="Submitted")
      {
          status=2;
      }
      return status;
}
});