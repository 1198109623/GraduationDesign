<%--
  Created by IntelliJ IDEA.
  User: GuoMingLi
  Date: 2018/1/2
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>电影院列表</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<!-- web路径：
    不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
    以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
            http://localhost:3306/crud
     -->
	<script type="text/javascript"
			src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<link
			href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
			rel="stylesheet">
	<script
			src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link
			href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/jeDate-test.css"
			rel="stylesheet">
	<link
			href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/jedate.css"
			rel="stylesheet">
	<script
			src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/jquery.jedate.js"></script>

</head>
<body>
<!-- 影院修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">影院修改</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">放映厅</label>
						<div class="col-sm-4">
							<input type="text" name="phName" class="form-control" id="phName_update_input"  disabled>
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">电影</label>
						<div class="col-sm-4">
							<input type="text" name="mName" class="form-control" id="mName_update_input"  disabled>
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">播出时间</label>
						<div class="col-sm-4" onclick="$.jeDate('#mpTime_update_input',{trigger:false,format: 'YYYY-MM-DD hh:mm'})">
							<input type="text" class="form-control" name="mpTime" id="mpTime_update_input"  >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">票价</label>
						<div class="col-sm-3">
							<div class="input-group">
								<input type="text" name="mpPrice" class="form-control" id="mpPrice_update_input" >
								<span class="input-group-addon">元</span>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
			</div>
		</div>
	</div>
</div>



<!-- 影院添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">放映厅-电影添加</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">放映厅</label>
						<div class="col-sm-4">
							<!-- 放映厅提交放映厅id即可 -->
							<select class="form-control" name="projectionHallId">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">电影</label>
						<div class="col-sm-4">
							<!-- 电影提交电影id即可 -->
							<select class="form-control" name="movieId">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">播出时间</label>
						<div class="col-sm-4" onclick="$.jeDate('#mpTime_add_input',{trigger:false,format: 'YYYY-MM-DD hh:mm'})">
							<input type="text" class="form-control" name="mpTime" id="mpTime_add_input"  placeholder="2018-01-01 00:00">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">票价</label>
						<div class="col-sm-3">
							<div class="input-group">
								<input type="text" name="mpPrice" class="form-control" id="mpPrice_add_input" placeholder="">
								<span class="input-group-addon">元</span>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<div class="col-sm-6" id="error-msg" style="color: red"></div>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
			</div>
		</div>
	</div>
</div>


<!-- 搭建显示页面 -->
<div class="container">
	<!-- 标题 -->
	<div class="row">
		<div class="col-md-12">
			<h3>SSM-CRUD</h3>
		</div>
	</div>
	<!-- 按钮 -->
	<div class="row">
		<div class="col-md-8">
			<div class="col-md-6" style="float: right">
				<div class="input-group">
					<input type="text" class="form-control" id="input-search" placeholder="放映厅名称">
					<span class="input-group-btn">
						<button class="btn btn-default" id="btn-search" type="button">搜索</button>
					</span>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
			<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
		</div>
	</div>
	<!-- 显示表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="emps_table">
				<thead>
				<tr>
					<th>
						<input type="checkbox" id="check_all"/>
					</th>
					<th>mphId</th>
					<th>放映厅</th>
					<th>电影</th>
					<th>播出时间</th>
					<th>票价</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
	</div>

	<!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-md-6" id="page_info_area"></div>
		<!-- 分页条信息 -->
		<div class="col-md-6" id="page_nav_area">

		</div>
	</div>

</div>
<script type="text/javascript">

    var totalRecord,currentPage;
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function(){
        //去首页
        to_page(1);
    });

    function to_page(pn){
        $.ajax({
            url:"${APP_PATH}/mph",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                console.log(result);
                //1、解析并显示员工数据
                build_emps_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }

    function build_emps_table(result){
        //清空table表格
        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        var mpTime = new Date();
        $.each(emps,function(index,item){
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var mphIdTd = $("<td></td>").append(item.id);
				var phNameTd = $("<td></td>").append(item.projctionHall.projectionHallName);
				var movieNameTd = $("<td></td>").append(item.movie.movieName);

				mpTime.setTime(item.mpTime);
				var mpTimeTd = $("<td></td>").append(mpTime.Format("yyyy-MM-dd HH:mm"));

				var mpPriceTd = $("<td></td>").append(parseFloat(item.mpPrice));
//				var broadcastingTimeTd = $("<td></td>").append(item1.broadcastingTime);
				/**
				 <button class="">
				 <span class="" aria-hidden="true"></span>
				 编辑
				 </button>
				 */
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前员工id
				editBtn.attr("edit-id",item.id);
				var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的员工id
//				delBtn.attr("del-cinemaId",item.cinemaId).attr("del-projHallId",item1.projHallId);
                delBtn.attr("del-Id",item.id);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				//var delBtn =
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(checkBoxTd)
					.append(mphIdTd)
					.append(phNameTd)
					.append(movieNameTd)
					.append(mpTimeTd)
					.append(mpPriceTd)
					.append(btnTd)
					.appendTo("#emps_table tbody");

        });
    }
    //解析显示分页信息
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
            result.extend.pageInfo.pages+"页,总"+
            result.extend.pageInfo.total+"条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result){
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加点击翻页的事件
            firstPageLi.click(function(){
                to_page(1);
            });
            prePageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum -1);
            });
        }



        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                to_page(result.extend.pageInfo.pages);
            });
        }



        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums,function(index,item){

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //清空表单样式及内容
    function reset_form(ele){
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#emp_add_modal_btn").click(function(){
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#empAddModal form");
        //s$("")[0].reset();
        //发送ajax请求，查出电影院信息，显示在下拉列表中
        getProjectionHalls("#empAddModal select[name='projectionHallId']");
        getMovies("#empAddModal select[name='movieId']")
        //弹出模态框
        $("#empAddModal").modal({
            backdrop:"static"
        });
    });

    //查出所有的放映厅信息并显示在下拉列表中
    function getProjectionHalls(ele){
        //清空之前下拉列表的值
        $(ele).empty();
        $.ajax({
            url:"${APP_PATH}/projectionHalls",
            type:"GET",
            success:function(result){
//                {"code":100,"msg":"处理成功！",
//                "extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
                console.log(result);
                //$("#empAddModal select").append("")
                $.each(result.extend.projectionHalls,function(){
                    var optionEle = $("<option></option>").append(this.projectionHallName).attr("value",this.projHallId);
                    optionEle.appendTo(ele);
//                    console.log("pId:"+optionEle.value());
                });
            }
        });

    }

    //查出所有的电影信息并显示在下拉列表中
    function getMovies(ele){
        //清空之前下拉列表的值
        $(ele).empty();
        $.ajax({
            url:"${APP_PATH}/allMovies",
            type:"GET",
            success:function(result){
//                {"code":100,"msg":"处理成功！",
//                "extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
                console.log(result);
                //$("#empAddModal select").append("")
                $.each(result.extend.movies,function(){
                    var optionEle = $("<option></option>").append(this.movieName).attr("value",this.movieId);
                    optionEle.appendTo(ele);
//                    console.log("pId:"+optionEle.value());
                });
            }
        });

    }

    //校验表单数据
    function validate_add_form(){
        //1、拿到要校验的数据，使用正则表达式
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(empName)){
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            show_validate_msg("#empName_add_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
            return false;
        }else{
            show_validate_msg("#empName_add_input", "success", "");
        };

        //2、校验邮箱信息
        var email = $("#email_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(email)){
            //alert("邮箱格式不正确");
            //应该清空这个元素之前的样式
            show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
            /* $("#email_add_input").parent().addClass("has-error");
            $("#email_add_input").next("span").text("邮箱格式不正确"); */
            return false;
        }else{
            show_validate_msg("#email_add_input", "success", "");
        }
        return true;
    }

    //显示校验结果的提示信息
    function show_validate_msg(ele,status,msg){
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if("error" == status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }



    //点击保存，保存电影院。
    $("#emp_save_btn").click(function(){
        //1、模态框中填写的表单数据提交给服务器进行保存
        console.log($("#empAddModal form").serialize());

        //2、发送ajax请求保存
        $.ajax({
            url:"${APP_PATH}/mph",
            type:"POST",
            data:$("#empAddModal form").serialize(),
            success:function(result){

                if(result.code == 100){
                    //电影院保存成功；
                    //1、关闭模态框
					alert("保存成功");
                    $("#empAddModal").modal('hide');
                    to_page(1);
                    //2、来到最后一页，显示刚才保存的数据
                    //发送ajax请求显示最后一页数据即可
                    //to_page(totalRecord);
                }else{
                    //显示失败信息
                    $("#error-msg").empty();
                    console.log(result);
                    $("#error-msg").append(result.extend.error);
                }
            }
        });
    });

    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function(){
        //alert("edit");

        //1、查出信息，显示信息
        getMPH($(this).attr("edit-id"));

        //2、把电影院的id传递给模态框的更新按钮
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#empUpdateModal").modal({
            backdrop:"static"
        });
    });

    function getMPH(id){
        $.ajax({
            url:"${APP_PATH}/mph/"+id,
            type:"GET",
            success:function(result){
                //console.log(result);
                var mphData = result.extend.mph;
                $("#phName_update_input").val(mphData.projctionHall.projectionHallName);
                $("#mName_update_input").val(mphData.movie.movieName);

                var mpTime = new Date(mphData.mpTime);
                $("#mpTime_update_input").val(mpTime.Format("yyyy-MM-dd HH:mm"));
                $("#mpPrice_update_input").val(parseFloat(mphData.mpPrice));
            }
        });
    }

    //点击更新，更新电影院信息
    $("#emp_update_btn").click(function(){
        //发送ajax请求保存更新的电影院数据
        $.ajax({
            url:"${APP_PATH}/mph/"+$(this).attr("edit-id"),
            type:"PUT",
            data:$("#empUpdateModal form").serialize(),
            success:function(result){
                //alert(result.msg);
                //1、关闭对话框
                $("#empUpdateModal").modal("hide");
                //2、回到本页面
                to_page(currentPage);
            }
        });
    });

    //单个删除
    $(document).on("click",".delete_btn",function(){
        //1、弹出是否确认删除对话框
        var pName = $(this).parents("tr").find("td:eq(2)").text();
        var mName = $(this).parents("tr").find("td:eq(3)").text();
        var mphId = $(this).attr("del-Id");
        //alert($(this).parents("tr").find("td:eq(1)").text());
        if(confirm("确认删除【"+pName+mName+"】吗？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"${APP_PATH}/mph/"+mphId,
                type:"DELETE",
                success:function(result){
                    alert(result.msg);
                    //回到本页
                    to_page(currentPage);
                }
            });
        }
    });

    //完成全选/全不选功能
    $("#check_all").click(function(){
        //attr获取checked是undefined;
        //我们这些dom原生的属性；attr获取自定义属性的值；
        //prop修改和读取dom原生属性的值
        $(".check_item").prop("checked",$(this).prop("checked"));
    });

    //check_item
    $(document).on("click",".check_item",function(){
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });

    //点击全部删除，就批量删除
    $("#emp_delete_all_btn").click(function(){
        //
        var pName = "";
        var mName = "";
        var del_idstr = "";
        $.each($(".check_item:checked"),function(){
            //this
            pName += $(this).parents("tr").find("td:eq(2)").text()+",";
            mName += $(this).parents("tr").find("td:eq(3)").text()+",";
            //组装cphId字符串
            del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        //去除cinemaName多余的,
        pName = pName.substring(0, pName.length-1);
        mName = mName.substring(0, mName.length-1);
        //去除删除的id多余的-
        del_idstr = del_idstr.substring(0, del_idstr.length-1);

//        var cpName = [];
//        for (var i = 0 ;i < cinemaName.length-1;i++){
//            cpName[i] = cinemaName[i]+projectionHallName[i];
//
//		}
        if(confirm("确认删除【"+pName+mName+"】吗？")){
            //发送ajax请求删除
            $.ajax({
                url:"${APP_PATH}/mph/"+del_idstr,
                type:"DELETE",
                success:function(result){
                    alert(result.msg);
                    //回到当前页面
                    to_page(currentPage);
                }
            });
        }
    });

	//搜索按钮
    $(document).on("click","#btn-search",function(){
//		console.log($("#input-search").val());
        var text = $("#input-search").val();
//        console.log(text);

        $.ajax({
            url:"${APP_PATH}/mphs/" + text,
            data:"pn=1",
            type:"GET",
            success:function(result){
                console.log(result);
                //1、解析并显示员工数据
                build_emps_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    });


    //格式化年月日
    Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "H+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
</script>
</body>
</html>