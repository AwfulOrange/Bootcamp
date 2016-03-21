angular.module('myApp', []).controller('userCtrl', function($scope,$http) {

var empslength=0;
$http.get("http://localhost:8080/TRS/web/employee/")
.success(function (data) {
    $scope.emps = data;    
    empslength=data.length;
   // console.log(empslength);
    changestatus(data);
    console.log(data[1].status);
});
var allscore=[];
$scope.save=function(id,achievingResults,orgImpact,learningAgility,
versatility,achievingResultsComment,orgImpactComment,learningAgilityComment,versatilityComment,status)
{
   status=1;
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
         status:status
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
    
//    $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){
//       
//    }).error(function(data) {
//        //alert(" save failure message:" + JSON.stringify({data:data}));
//    });
    //console.log(allscore);
   // backstatus(allscore);
      // console.log(scoredata.status);
        backstatus(scoredata);
        return scoredata.status;
}

    var valid=function(){
//        var a=true; 

        if(allscore.length!=empslength)
        {
            return false;       
        }
        for(var i=0;i<allscore.length;i++)
        {
            for(var j=0;j<5;j++)
            {
              //  console.log(allscore[i].achievingResults==undefined);
                if(allscore[i].employeeId==undefined){
                    return false; 
                }else if(allscore[i].achievingResults==undefined){
                    return false; 
                }else if(allscore[i].orgImpact==undefined){
                    return false; 
                }else if(allscore[i].learningAgility==undefined){
                    return false; 
                }else if(allscore[i].versatility==undefined){
                    return false; 
                }
                else if(allscore[i].achievingResultsComment==undefined){
                    return false; 
                }
                else if(allscore[i].orgImpactComment==undefined){
                    return false; 
                }
                else if(allscore[i].learningAgilityComment==undefined){
                    return false; 
                }
                else if(allscore[i].versatilityComment==undefined){
                    return false; 
                }
            }
        }
        return true;
    }

$scope.postSubmit = function()
{
         for(var i=0;i<allscore.length;i++)
         {
          allscore[i].status=2;
         }
        //   console.log($scope.status);
        $scope.status="Submitted";
         console.log($scope.status);
         //   changestatus(allscore);
            return "Submitted";
            
//       if(valid()){
//             $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){           
//            alert("Submit successfully!");

           //  allsocre.status="Submitted";
     
//        }).error(function(data) {
//            alert("Sorry,Fail to send message!" );
//        });
//        }
//        else
//        { alert("Please input all data!");}   
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
        else 
            data[i].status=="Submitted";
        //  console.log(data[i].status);
    }
 }
var backstatus=function(allscore)
{
    if(allscore.status==1)
    {
      allscore.status="Saved";
    }
    else if (allscore.status==undefined)
    {
      allscore.status="Unfinished";
    }
    else 
        allscore.status="Submitted";
}
});