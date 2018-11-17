app.controller("brandController",
    function($scope,brandService,$controller) {

        //伪继承，表示将baseController中的scope的值传给当前controller中的scope
        $controller("baseController",{$scope:$scope});

        //普通查询
        $scope.findAll = function() {
            brandService.findAll().success(
                function (response) {
                    $scope.list = response;
                }
            );
        }



        //分页
        $scope.findPage=function (page, rows) {
            brandService.findPage(page, rows).success(
                function (response) {
                    $scope.list=response.rows;//当前页数据
                    $scope.paginationConf.totalItems = response.total;//总记录数
                }
            );
        }

        //更新（添加/修改）
        $scope.save=function(){
            //post请求进行参数绑定
            var object = null;
            if($scope.entity.id!=null){
                object = brandService.update($scope.entity);
            }else{
                object = brandService.add($scope.entity);
            }
            object.success(
                function (response) {
                    if(response.success) {
                        $scope.reloadList();//刷新
                    }else{
                        alert(response.message);//弹出错误信息
                    }
                }
            );
        }

        //查询一个
        $scope.findOne=function (id) {
            brandService.findOne(id).success(
                function (response) {
                    $scope.entity = response;
                }
            );
        }

        //删除方法
        $scope.delete=function () {
            brandService.delete($scope.selectIds).success(
                function (response) {
                    if(response.success){
                        $scope.reloadList();//刷新
                    }else{
                        alert(response.message);
                    }
                }
            );
        }
        //初始化searchEntity
        $scope.searchEntity={};
        //条件查询
        $scope.search = function (page,rows) {
            brandService.search(page,rows,$scope.searchEntity).success(
                function (response) {
                    $scope.list=response.rows;//当前页数据
                    $scope.paginationConf.totalItems = response.total;//总记录数
                }
            );
        }


    }
);