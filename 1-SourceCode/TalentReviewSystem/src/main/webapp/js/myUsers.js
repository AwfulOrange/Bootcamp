angular.module('myApp', []).controller('userCtrl', function($scope,$http) {


$http.get("http://localhost:8080/TRS/web/employee/")
.success(function (data) {
    $scope.emps = data;
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

$scope.postSubmit = function(){
        console.log(allscore);
//        var judgena=function(){           
//                     for(var i=0;i<allscore.length;i++) 
//                        if(allscore[i])
//                    {
//                        
//                    }
//        }
//        if(     1    ) 
//        {
//                $http.post('http://localhost:8080/TRS/web/employee/', allscore).success(function()
//                {
////           alert(data.employeeId+","+data.achievingresults+","+data.orgimpact+","+data.learningagility+","+data.versatility);
//                })
//        }
//        else
//        {
//                 alert("Please check message!");
//         }
// 
    };
 $scope.number=[1,2,3,4,5 ];

});