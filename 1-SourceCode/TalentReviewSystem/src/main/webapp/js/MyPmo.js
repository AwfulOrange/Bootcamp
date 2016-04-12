angular.module('myApp1', []).controller('pmoCtrl',
        function ($scope, $http, $window) {
            var criteria = [];


            $http.get("http://10.2.1.183:8080/TRS/web/cri").success(function (data) {
                criteria = data;
            });
            $scope.order="reviewername"
            
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


            $http.get("http://10.2.1.183:8080/TRS/web/role")
                    .success(function (ndata) {
                        $scope.info = ndata;
                        var info = ndata;
                        var ID = ndata.id
                        $scope.checkT = function () {
                            if (info.role == "pmo") {
                                return true;
                            } else {
                                return false;
                            }
                        }



                        $http.get("http://10.2.1.183:8080/TRS/web/employee/pmo/" + ID)
                                .success(function (data) {
                                    $scope.pmos = data;
                                    var pmoslength=data.length;
                                    if(pmoslength>0){
                                    $scope.sortfilter=true;}
                                })
                    });

            $scope.editable = function (status) {
                if (status == "Submitted") {
                    return false;
                } else if (status == "Updated") {
                    return false;
                } else {
                    return true;
                }
            }
            var updatepageData=function(id, achievingResults, orgImpact, learningAgility,
                    versatility,status){
                var temp = $scope.pmos;
                for (var i = 0; i < temp.length; i++) {
                    if (temp[i].id == id) {
                        temp[i].score.achievingResults = achievingResults;
                        temp[i].score.orgImpact = orgImpact;
                        temp[i].score.learningAgility = learningAgility;
                        temp[i].score.versatility = versatility;
                        temp[i].status=status;
                        temp[i].ar=achievingResults;
                        temp[i].la=learningAgility;
                        temp[i].oi=orgImpact;
                        temp[i].ver=versatility;
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
                $scope.pmos = temp;
            }
            $scope.save = function (id, achievingResults, orgImpact, learningAgility,
                    versatility, achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, 
                    reviewerId, pmoId,FR)
            {
                var allscore = [];
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
                    status: "Updated",
                    reviewerId: reviewerId,
                    pmoId: pmoId,
                    force_ranking:FR
                };
                updatepageData(id, achievingResults, orgImpact, learningAgility,
                    versatility,"Updated");
                allscore.push(scoredata);
                for (var i = 0; i < allscore.length; i++)
                {
                    for (var j = i + 1; j < allscore.length; j++)
                    {
                        if (allscore[i].employeeId == allscore[j].employeeId)
                        {
                            allscore.splice(i, 1);
                            j--;
                        }
                    }
                }allscore
                $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function () {

                }).error(function (data) {
                    alert("Fail to save!");
                });
                return "Updated";
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

            $scope.postSubmit = function (id, achievingResults, orgImpact, learningAgility,
                    versatility, achievingResultsComment, orgImpactComment, learningAgilityComment, versatilityComment, reviewerId, pmoId,FR)
            {
                var postscore = [];
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
                    status: "Updated",
                    reviewerId: reviewerId,
                    pmoId: pmoId,
                    force_ranking:FR
                };
                if (checkScoredata(scoredata) == false)
                {
                    scoredata.status = "Updated";
                    postscore.push(scoredata);
                    for (var i = 0; i < postscore.length; i++)
                    {
                        for (var j = i + 1; j < postscore.length; j++)
                        {
                            if (postscore[i].employeeId == postscore[j].employeeId)
                            {
                                postscore.splice(i, 1);
                                j--;
                            }
                        }
                    }
                    updatepageData(id, achievingResults, orgImpact, learningAgility,
                    versatility,"Updated");
                    alert("Please input all data!");
                    return "Updated";
                } else
                {
                    scoredata.status = "Approved";
                    postscore.push(scoredata);
                    for (var i = 0; i < postscore.length; i++)
                    {
                        for (var j = i + 1; j < postscore.length; j++)
                        {
                            if (postscore[i].employeeId == postscore[j].employeeId)
                            {
                                postscore.splice(i, 1);
                                j--;
                            }
                        }
                    }
                    updatepageData(id, achievingResults, orgImpact, learningAgility,
                    versatility,"Approved");
                    $http.post('http://10.2.1.183:8080/TRS/web/score/', postscore).success(function () {
                    }).error(function (data) {
                        alert("Fail to save!");
                    });
                    return "Approved";
                }
            }

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
