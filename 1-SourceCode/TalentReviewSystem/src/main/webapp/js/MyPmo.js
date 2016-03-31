angular.module('myApp1', []).controller('pmoCtrl',
        function ($scope, $http, $window) {
            var pmoslength = 0;
            var emplength = [];
            var allscore = [];
            var criteria = [];
            var reviewerId = "";
            var pmoId = "";


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
               // console.log(lvlCriteria);
                return lvlCriteria;
            }


            $http.get("http://10.2.1.183:8080/TRS/web/role")
                    .success(function (ndata) {
                        $scope.info=ndata;
                        var info = ndata;
                        var ID = ndata.id
                       // console.log(info);
                         // console.log(ndata)
                  
                 $scope.checkT=function(){
                 if(info.role=="pmo"){
                     console.log(info.title)
                     return true;}
                 else {
                     return false;}
             } 
             
             
             
                        $http.get("http://10.2.1.183:8080/TRS/web/employee/pmo/" + ID)
                                .success(function (data) {
                                    $scope.pmos = data;
                                    var p = data;
                                    pmoslength = data.length;
                                    // console.log(pmoslength);
                                    for (var i = 0; i < pmoslength; i++) {
                                        emplength[i] = p[i].emp.length;
                                    }
                                    // console.log(emplength);
                                    for (var i = 0; i < pmoslength; i++) {
                                        for (var j = 0; j < emplength[i]; j++) {
                                            //console.log(data[i].emp[j].score.status);
                                            if (data[i].emp[j].score != null)
                                            {
                                                var scoredata = {
                                                    employeeId: data[i].emp[j].id,
                                                    achievingResults: data[i].emp[j].score.achievingResults,
                                                    orgImpact: data[i].emp[j].score.orgImpact,
                                                    learningAgility: data[i].emp[j].score.learningAgility,
                                                    versatility: data[i].emp[j].score.versatility,
                                                    achievingResultsComment: data[i].emp[j].score.achievingResultsComment,
                                                    orgImpactComment: data[i].emp[j].score.orgImpactComment,
                                                    learningAgilityComment: data[i].emp[j].score.learningAgilityComment,
                                                    versatilityComment: data[i].emp[j].score.versatilityComment,
                                                    status: data[i].emp[j].score.status,
                                                    reviewerId: data[i].emp[j].score.reviewerId,
                                                    pmoId: data[i].emp[j].score.pmoId
                                                }

                                                allscore.push(scoredata);
                                            }
                                        }
                                    }
                                })







                    });





          



            $scope.editable = function (status) {
                if (status == "Submitted") {
                    return false;
                } else {
                    return true;
                }
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
                    status: statustoNum(status),
                    reviewerId: reviewerId,
                    pmoId: pmoId
                };
                if (checkScoredata(scoredata) == false)
                {
                    scoredata.status = 3;
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
                    }
                    $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function () {

                    }).error(function (data) {
                        alert("Fail to save!");
                    });
                    return "Modified";
                } else
                {
                    scoredata.status = 1;
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
                    }
                    $http.post('http://10.2.1.183:8080/TRS/web/score/', allscore).success(function () {
                    }).error(function (data) {
                        alert("Fail to save!");
                    });
                    return "Completed";
                }
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
                for (var i = 0; i < pmoslength; i++)
                {


                    if (allscore.length != emplength)
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


            }

            $scope.postSubmit = function ()
            {

                if (valid()) {
                    for (var m = 0; m < allscore.length; m++)
                    {
                        allscore[m].status = 2;
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
            var changestatus = function (data) {
                for (var i = 0; i < pmoslength; i++)
                {
                    for (var j = 0; j < emplength[i]; j++)
                    {
                        if (data[i].emp[j].status == 0)
                        {
                            data[i].emp[j].status = "New";
                        } else if (data[i].emp[j].status == 1)
                        {
                            data[i].emp[j].status == "Completed"
                        } else if (data[i].emp[j].status == 2)
                            data[i].emp[j].status == "Submitted";
                        else
                            data[i].emp[j].status == "Modified"
                    }
                }
            }
            $scope.backstatus = function (status)
            {
                if (status == 1)
                {
                    status = "Completed";
                } else if (status == 0)
                {
                    status = "New";
                } else if (status == 2)
                    status = "Submitted";
                else if (status == 3)
                    status = "Modified";

                return status;
            }
            var statustoNum = function (status)
            {
                if (status == "Completed")
                {
                    status = 1;
                } else if (status == "New")
                {
                    status = 0;
                } else if (status == "Modified")
                {
                    status = 3;
                } else if (status == "Submitted")
                {
                    status = 2;
                }
                return status;
            }

            $scope.editablebutton = function () {

                    return true;

            }


        });
