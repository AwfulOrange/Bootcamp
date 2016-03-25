angular.module('myApp1', []).controller('pmoCtrl', 
function($scope,$http,$window) {
var pmoslength=0;
var empslength=[];
var allscore=[];

    
    
$http.get("http://localhost:8080/TRS/test/testpmo.json")
.success(function (data) {
    $scope.pmos =data;
    var p=data;   
    pmoslength=data.length;
//    console.log(pmoslength);
    for(var i=0;i<pmoslength;i++){
    empslength[i]=p[i].emps.length;
        }
//    console.log(empslength);
for(var i=0;i<pmoslength;i++){
       for(var j=0;j<empslength[i];j++){
//           console.log(data[i].emps[j]);
if(data[i].emps[j].talentReviewScoreCollection.length!=0)
    {
    var scoredata={
        employeeId:data[i].emps[j].id,
        achievingResults:data[i].emps[j].talentReviewScoreCollection[0].achievingResults,
        orgImpact:data[i].emps[j].talentReviewScoreCollection[0].orgImpact,
        learningAgility:data[i].emps[j].talentReviewScoreCollection[0].learningAgility,
        versatility:data[i].emps[j].talentReviewScoreCollection[0].versatility,
        achievingResultsComment:data[i].emps[j].talentReviewScoreCollection[0].achievingResultsComment,
        orgImpactComment:data[i].emps[j].talentReviewScoreCollection[0].orgImpactComment,
        learningAgilityComment:data[i].emps[j].talentReviewScoreCollection[0].learningAgilityComment,
        versatilityComment:data[i].emps[j].talentReviewScoreCollection[0].versatilityComment,
         status:data[i].emps[j].talentReviewScoreCollection[0].status
    }

    allscore.push(scoredata);
    }
       }
}

  
//    for(var j=0;j<empslength[0];j++){
//    if(data[0].emps[j].talentReviewScoreCollection[0].status==0||data[0].emps[j].talentReviewScoreCollection[0].status==1||data[0].emps[j].talentReviewScoreCollection[0].status==3)
//    {
//        edit=true;
//    }
//    
//    }

});


$scope.editable=function(status){
    if(status=="Submitted"){
        return false;
    }else{
        return true;
    }
}
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
    if(  checkScoredata(scoredata)==false)
    {
        scoredata.status=3;
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
        $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){

        }).error(function(data) {
         alert("Fail to save!");
        });            
        return "Modified";
    }
    else 
    {
        scoredata.status=1;
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
        $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){
        }).error(function(data) {
            alert("Fail to save!");
        });            
            return "Completed";
    }
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
     for(var i=0;i<pmoslength;i++)
     {
         
         
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
    
    
    }

$scope.postSubmit = function()
{          
      
       if(valid()){
                for(var m=0;m<allscore.length;m++)
            {
             allscore[m].status=2;
            }
//            var con =window.confirm("Are you sure to submit");
//            if(con){
            $http.post('http://localhost:8080/TRS/web/score/', allscore).success(function(){  
               
               $window.location.reload();
       }).error(function(data) {
           alert("Sorry,Fail to send message!" );
       });
//         }
       }
        else
      { alert("Please input all data!");}   
};
 $scope.number=[1,2,3,4,5 ];
var changestatus=function(data){
     for(var i=0;i<pmoslength;i++)
     {
         for(var j=0;j<empslength[i];j++)
    {
        if(data[i].emps[j].status==0)
        {
            data[i].emps[j].status="New";
        }
        else if(data[i].emps[j].status==1)
        {
            data[i].emps[j].status=="Completed"
        }
        else if(data[i].emps[j].status==2) 
            data[i].emps[j].status=="Submitted";
        else 
            data[i].emps[j].status=="Modified"
    }
     }
 }
$scope.backstatus=function(status)
{
    if(status==1)
    {
      status="Completed";
    }
    else if (status==0)
    {
      status="New";
    }
    else if(status==2) 
        status="Submitted";
    else if(status==3)
        status="Modified";
    
    return status;
}
var statustoNum=function(status)
{
      if( status=="Completed")
      {
          status=1;
      }
      else if(status=="New")
      {
          status=0;
      }
            else if(status=="Modified")
      {
          status=3;
      }
            else if(status=="Submitted")
      {
          status=2;
      }
      return status;
}  
    
$scope.editablebutton=function(){

    
    
}


});
