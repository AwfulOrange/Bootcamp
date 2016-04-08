angular.module('myApp', []).controller('userCtrl', function ($scope, $http, $window) {
    var edit = false;
    var empslength = 0;
    var allscore = [];
    var criteria = [];
    var reviewerId = "";
    var pmoId = "";

    $http.get("http://10.2.1.183:8080/TRS/web/role")
            .success(function (ndata) {
                $scope.info = ndata;
                var info = ndata;
                var ID = ndata.id;
                //console.log(ndata)

                $scope.checkT = function () {
                    if (info.role == "pmo") {
                        //console.log(info.role)
                        return true;
                    } else {
                        return false;
                    }
                }


                $http.get("http://10.2.1.183:8080/TRS/web/employee/reviewer/" + ID)
                        .success(function (data) {
                            $scope.emps = data;
                           
                            empslength = data.length;
                            if(empslength>0){
                                $scope.buttonshow=true; 
                                 $scope.sortfilter=true;
                            }
//                            changestatus(data);
                            for (var i = 0; i < empslength; i++) {
                                if (data[i].score != null)
                                {
                                    var scoredata = {
                                        employeeId: data[i].id,
                                        achievingResults: data[i].score.achievingResults,
                                        orgImpact: data[i].score.orgImpact,
                                        learningAgility: data[i].score.learningAgility,
                                        versatility: data[i].score.versatility,
                                        achievingResultsComment: data[i].score.achievingResultsComment,
                                        orgImpactComment: data[i].score.orgImpactComment,
                                        learningAgilityComment: data[i].score.learningAgilityComment,
                                        versatilityComment: data[i].score.versatilityComment,
                                        status: data[i].status,
                                        reviewerId: data[i].score.reviewerId,
                                        pmoId: data[i].score.pmoId,
                                        performance: data[i].performance,
                                        potential: data[i].potential,
                                        total: data[i].total
                                    }
                                    if (data[i].score.status =="Submitted")
                                    {
                                        edit = true;
                                    }else if(data[i].score.status =="Update")
                                    {
                                        edit = true;
                                    }else if(data[i].score.status =="Approve")
                                    {
                                        edit = true;
                                    }
                                    allscore.push(scoredata);
                                    
                                }
                            }
                            
                        });


            })





    $http.get("http://10.2.1.183:8080/TRS/web/cri").success(function (data) {
        criteria = data;
    });
    $scope.findCriteriaByName = function (name) {
        var lvlCriteria = [];
        for (var i = 0; i < criteria.length; i++)
        {
            if (name == criteria[i].criteria)
            {
                lvlCriteria.push(criteria[i]);
            }
        }
        return lvlCriteria;
    }
    $scope.findCriteriaByLevel = function (name, level) {
        var lvlCriteria = [];
        for (var i = 0; i < criteria.length; i++)
        {
            if (name == criteria[i].criteria && level == criteria[i].level)
            {
                lvlCriteria.push(criteria[i]);
            }
        }
        return lvlCriteria;
    }

    $scope.editable = function () {
        return edit;
    }
    $scope.save = function (id, achievingResults, orgImpact, learningAgility,
            versatility, achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, status)
    {
        var scoredata = {
            employeeId: id,
            achievingResults: achievingResults,
            orgImpact: orgImpact,
            learningAgility: learningAgility,
            versatility: versatility,
            achievingResultsComment: achievingResultsComment,
            orgImpactComment: orgImpactComment,
            learningAgilityComment: learningAgilityComment,
            versatilityComment: versatilityComment,
            status: status,
            reviewerId: reviewerId,
            pmoId: pmoId
        };
        
        updatepageData(id, achievingResults, orgImpact, learningAgility, versatility,status);

        if (checkScoredata(scoredata) == false)
        {
            scoredata.status = "Modified";
            allscore.push(scoredata);
            for (var i = 0; i < allscore.length; i++)
            {
                for (var j = i + 1; j < allscore.length; j++)
                {
                    if (allscore[i].employeeId == allscore[j].employeeId)
                    {
                        allscore[j].reviewerId = allscore[i].reviewerId;
                        allscore[j].pmoId = allscore[i].pmoId;
                        allscore.splice(i, 1);
                        j--;
                    }
                }
            }
            $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function () {

            }).error(function (data) {
                alert("Fail to save!");
            });
            return "Modified";
        } else
        {
            scoredata.status = "Completed";
            allscore.push(scoredata);
            for (var i = 0; i < allscore.length; i++)
            {
                for (var j = i + 1; j < allscore.length; j++)
                {
                    if (allscore[i].employeeId == allscore[j].employeeId)
                    {
                        allscore[j].reviewerId = allscore[i].reviewerId;
                        allscore[j].pmoId = allscore[i].pmoId;
                        allscore.splice(i, 1);
                        j--;
                    }
                }
            }
            $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function () {
            }).error(function (data) {
                alert("Fail to save!");
            });
            return "Completed";
        }
        $scope.apply();
    }
    var updatepageData=function(id, achievingResults, orgImpact, learningAgility,
            versatility,status){
        var temp = $scope.emps;
        for (var i = 0; i < temp.length; i++) {
            if (temp[i].id == id) {
                temp[i].score.achievingResults = achievingResults;
                temp[i].score.orgImpact = orgImpact;
                temp[i].score.learningAgility = learningAgility;
                temp[i].score.versatility = versatility;
                temp[i].status=status;
                if(achievingResults == undefined && orgImpact != undefined){
                    temp[i].performance = orgImpact;
                }else if(achievingResults != undefined && orgImpact == undefined){
                    temp[i].performance = achievingResults;
                }else if(achievingResults == undefined && orgImpact == undefined){
                    temp[i].performance = 0
                }else{
                    temp[i].performance = achievingResults + orgImpact;
                }
                
                if(learningAgility == undefined && versatility != undefined){
                    temp[i].potential = versatility;
                }else if(learningAgility != undefined && versatility == undefined){
                    temp[i].potential = learningAgility;
                }else if(learningAgility == undefined && versatility == undefined){
                    temp[i].potential = 0
                }else{
                    temp[i].potential = learningAgility + versatility;
                }
                
                temp[i].total = temp[i].performance + temp[i].potential;
            }
        }
        $scope.emps = temp;
    }
    var checkScoredata = function (data) {
        if (data.employeeId == undefined) {
            return false;
        } else if (data.achievingResults == undefined) {
            return false;
        } else if (data.orgImpact == undefined) {
            return false;
        } else if (data.learningAgility == undefined) {
            return false;
        } else if (data.versatility == undefined) {
            return false;
        } else if (data.achievingResultsComment == undefined) {
            return false;
        } else if (data.orgImpactComment == undefined) {
            return false;
        } else if (data.learningAgilityComment == undefined) {
            return false;
        } else if (data.versatilityComment == undefined) {
            return false;
        }
    }
    var valid = function () {
//        var a=true; 

        if (allscore.length != empslength)
        {
            return false;
        }
        for (var i = 0; i < allscore.length; i++)
        {
            if (checkScoredata(allscore[i]) == false) {
                return false;
            }


        }
        return true;
    }

    $scope.postSubmit = function ()
    {

        if (valid()) {
            for (var m = 0; m < allscore.length; m++)
            {
                allscore[m].status = "Submitted";
            }
//            var con =window.confirm("Are you sure to submit");
//            if(con){
            $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function () {

                $window.location.reload();
            }).error(function (data) {
                alert("Sorry,Fail to send message!");
            });
//         }
        } else
        {
            alert("Please input all data!");
        }
    };
    $scope.number = [1, 2, 3, 4, 5];



    $scope.sorterUp = function (condition) {
        $scope.p = true;
        return condition;
    }
    $scope.sorterDown = function (condition) {
        $scope.p = false;
        return condition;
    }
});
