angular.module('myApp', []).controller('userCtrl', function($scope,$http,$window) {
var edit=false;
var empslength=0;
var allscore=[];

$http.get("http://10.2.1.183:8080/TRS/web/employee/")
.success(function (data) {
    $scope.emps = data;    
    empslength=data.length;
    changestatus(data);
for(var i=0;i<empslength;i++){
if(data[i].talentReviewScoreCollection.length!=0)
    {
    var scoredata={
        employeeId:data[i].id,
        achievingResults:data[i].talentReviewScoreCollection[0].achievingResults,
        orgImpact:data[i].talentReviewScoreCollection[0].orgImpact,
        learningAgility:data[i].talentReviewScoreCollection[0].learningAgility,
        versatility:data[i].talentReviewScoreCollection[0].versatility,
        achievingResultsComment:data[i].talentReviewScoreCollection[0].achievingResultsComment,
        orgImpactComment:data[i].talentReviewScoreCollection[0].orgImpactComment,
        learningAgilityComment:data[i].talentReviewScoreCollection[0].learningAgilityComment,
        versatilityComment:data[i].talentReviewScoreCollection[0].versatilityComment,
         status:data[i].talentReviewScoreCollection[0].status
    }
    if(data[i].talentReviewScoreCollection[0].status==2)
    {
        edit=true;
    }
    allscore.push(scoredata);
    }
}
});


$scope.editable=function(){
    return edit;
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
        $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function(){

        }).error(function(data) {
         alert("Fail to save!");
        });            
        return "Partially completed";
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
        $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function(){
        }).error(function(data) {
            alert("Fail to save!");
        });            
            return "Saved";
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
                for(var m=0;m<allscore.length;m++)
            {
             allscore[m].status=2;
            }

            $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function(){  
               alert("Submit successfully!");
               $window.location.reload();
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
            data[i].status=="Partially completed"
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
        status="Partially completed";
    
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
            else if(status=="Partially completed")
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
