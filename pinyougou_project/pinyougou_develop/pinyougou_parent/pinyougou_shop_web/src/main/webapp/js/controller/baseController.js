app.controller("baseController",function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    //刷新列表
    $scope.reloadList=function() {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

    //用户勾选的id的集合
    $scope.selectIds = [];
    //用户勾选复选框
    $scope.updateSelection = function ($event,id) {
        //通过源的target属性可以获取的input标签对象，在根据标签的selected属性判断是否已经被选中
        if($event.target.checked){
            //如果选中(第一次点击)
            $scope.selectIds.push(id);//向集合添加元素
        }else{
            //没有选中(第二次点击，取消选中)
            //获取选中的id在集合中的位置，从0开始
            var index = $scope.selectIds.indexOf(id);
            //根据位置删除
            $scope.selectIds.splice(index);
        }
    }

    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);
        var value = '';
        for(var i = 0; i < json.length; i++){
            if(i > 0){
                value += ',';
            }
            value += json[i][key];
        }
        return value;
    }
});


