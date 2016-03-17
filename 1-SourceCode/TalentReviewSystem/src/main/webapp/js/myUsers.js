angular.module('myApp', []).controller('userCtrl', function($scope,$http) {

var empslength=0;
$http.get("http://localhost:8080/TRS/web/employee/")
.success(function (data) {
    $scope.emps = data;
    empslength=data.length;
    console.log(empslength);
    

});
var allscore=[];
$scope.save=function(emid,achievingresults,orgimpact,learningagility,versatility)
{
   
    var scoredata={
        employeeId:emid,
        achievingresults:achievingresults,
        orgimpact:orgimpact,
        learningagility:learningagility,
        versatility:versatility
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
    
    console.log(allscore);
}
    var valid=function(){
//        var a=true; 
console.log(empslength);
console.log(allscore.length);
console.log(allscore.length==empslength);
        if(allscore.length!=empslength)
        {
            return false;       
        }
        for(var i=0;i<allscore.length;i++)
        {
            for(var j=0;j<5;j++)
            {
                console.log(allscore[i].achievingresults==undefined);
                if(allscore[i].employeeId==undefined){
                    return false; 
                }else if(allscore[i].achievingresults==undefined){
                    return false; 
                }else if(allscore[i].orgimpact==undefined){
                    return false; 
                }else if(allscore[i].learningagility==undefined){
                    return false; 
                }else if(allscore[i].versatility==undefined){
                    return false; 
                }

            }
        }
        return true;
    }

$scope.postSubmit = function(){
        if(valid()){
             $http.post('http://localhost:8080/TRS/web/employee/', allscore).success(function(){
           
            alert("success");
           
        }).error(function(data) {
            alert("failure message:" + JSON.stringify({data:data}));
        });
        }
        else
        { alert("please input all data!");}
           
       
};

 $scope.number=[1,2,3,4,5 ];

});