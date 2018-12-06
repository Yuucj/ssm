<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">


    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                数据管理
                <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">数据管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick="location.href='${pageContext.request.contextPath}/pages/product-add.jsp'">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" onclick="del();" title="删除">
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" onclick="act();" title="开启">
                                        <i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" onclick="block();" title="屏蔽">
                                        <i class="fa fa-ban"></i> 屏蔽
                                    </button>
                                    <button type="button" class="btn btn-default" onclick="location.reload();"
                                            title="刷新">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <form action="${pageContext.request.contextPath}/product/findAll" method="post">
                                    <input type="text" name="condition" value="${condition}"
                                           class="form-control input-sm"
                                           placeholder="搜索"> <span
                                        class="glyphicon glyphicon-search form-control-feedback"></span>
                                </form>
                            </div>
                        </div>
                        <!--工具栏/-->
                        <form id="products">
                            <!--数据列表-->
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="sorting_desc_disabled sorting_asc_disabled" style="padding-right: 0px;">
                                        <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                    </th>
                                    <th class="sorting">ID</th>
                                    <th class="sorting">编号</th>
                                    <th class="sorting ">产品名称</th>
                                    <th class="sorting ">出发城市</th>
                                    <th class="sorting">出发时间</th>
                                    <th class="text-center sorting">产品价格</th>
                                    <th class="sorting">产品描述</th>
                                    <th class="text-center sorting">状态</th>
                                    <th class="text-center disabled sorting_desc_disabled sorting_asc_disabled">操作</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${pageInfo.list}" var="product">
                                    <c:if test="${productNum == product.productNum}">
                                        <tr style="color: red">
                                    </c:if>
                                    <c:if test="${productNum != product.productNum}">
                                    <tr>
                                    </c:if>
                                        <td><input name="ids" value="${product.id}" type="checkbox"></td>
                                        <td>${product.id }</td>
                                        <td>${product.productNum }</td>
                                        <td>${product.productName }</td>
                                        <td>${product.cityName }</td>
                                        <td>${product.departureTimeStr }</td>
                                        <td class="text-center">${product.productPrice }</td>
                                        <td>${product.productDesc }</td>
                                        <td class="text-center">${product.productStatusStr }</td>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick="location.href='${pageContext.request.contextPath}/product/findById?id=${product.id}&next=product-show'">
                                                详情
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick="location.href='${pageContext.request.contextPath}/product/findById?id=${product.id}&next=product-update'">
                                                编辑
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </form>
                    </div>
                    <!-- /.box-body -->

                    <!-- .box-footer-->
                    <div class="box-footer">
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页 <select id="rows" class="form-control">
                                <option value="1" ${pageInfo.pageSize ==1?'selected' :""}>1</option>
                                <option value="2" ${pageInfo.pageSize ==2?'selected' :""}>2</option>
                                <option value="3" ${pageInfo.pageSize ==3?'selected' :""}>3</option>
                                <option value="4" ${pageInfo.pageSize ==4?'selected' :""}>4</option>
                                <option value="5" ${pageInfo.pageSize ==5?'selected' :""}>5</option>
                            </select> 条
                            </div>
                        </div>

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li>
                                    <a href="${pageContext.request.contextPath}/product/findAll?page=${pageInfo.firstPage}&rows=${pageInfo.pageSize}&condition=${condition}"
                                       aria-label="Previous">首页</a></li>
                                <c:if test="${pageInfo.hasPreviousPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/product/findAll?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}&condition=${condition}">上一页</a>
                                    </li>
                                </c:if>
                                <c:forEach items="${pageInfo.navigatepageNums}" var="nav">
                                    <c:if test="${nav == pageInfo.pageNum}">
                                        <li class="active">
                                    </c:if>
                                    <c:if test="${nav != pageInfo.pageNum}">
                                        <li>
                                    </c:if>
                                    <a href="${pageContext.request.contextPath}/product/findAll?page=${nav}&rows=${pageInfo.pageSize}&condition=${condition}">${nav}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/product/findAll?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}&condition=${condition}">下一页</a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="${pageContext.request.contextPath}/product/findAll?page=${pageInfo.lastPage}&rows=${pageInfo.pageSize}&condition=${condition}"
                                       aria-label="Next">尾页</a></li>
                            </ul>
                        </div>

                    </div>
                    <!-- /.box-footer-->

                </div>
                <!-- 正文区域 /-->
            </div>
        </section>

        <!-- @@close -->
        <!-- 内容区域 /-->

        <!-- 底部导航 -->
        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 1.0.8
            </div>
            <strong>Copyright &copy; 2014-2017 <a
                    href="http://www.itcast.cn">研究院研发部</a>.
            </strong> All rights reserved.
        </footer>
        <!-- 底部导航 /-->

    </div>


    <script
            src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script
            src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        /*隐藏不必要的元素*/
        $(document).ready(function () {
            // 选择框
            $(".select2").select2();

            // WYSIHTML5编辑器
            $(".textarea").wysihtml5({
                locale: 'zh-CN'
            });
        });

        // 设置激活菜单
        function setSidebarActive(tagUri) {
            var liObj = $("#" + tagUri);
            if (liObj.length > 0) {
                liObj.parent().parent().addClass("active");
                liObj.addClass("active");
            }
        }

        $(document).ready(function () {

            // 激活导航位置
            setSidebarActive("admin-datalist");

            // 列表按钮
            $("#dataList td input[type='checkbox']").iCheck({
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });
            // 全选操作
            $("#selall").click(function () {
                var clicks = $(this).is(':checked');
                if (!clicks) {
                    $("#dataList td input[type='checkbox']").iCheck("uncheck");
                } else {
                    $("#dataList td input[type='checkbox']").iCheck("check");
                }
                $(this).data("clicks", !clicks);
            });
        });

        function del() {
            var cbs = $(":checkbox[name='ids']");
            var flag = false;
            for (var i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    flag = true;
                }
            }
            if (flag) {
                if (confirm("确定要删除吗?")) {
                    $.post("${pageContext.request.contextPath}/product/delete", $("#products").serialize(), function () {
                        location.reload();
                    })
                }
            }else {
                alert("至少选择一条数据....")
            }

        }

        function act() {
            var cbs = $(":checkbox[name='ids']");
            var flag = false;
            for (var i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    flag = true;
                }
            }
            if (flag) {
                if (confirm("确定要激活吗?")) {
                    $.post("${pageContext.request.contextPath}/product/active", $("#products").serialize(), function () {
                        location.reload();
                    })
                }
            }else {
                alert("至少选择一条数据....")
            }

        }

        function block() {
            var cbs = $(":checkbox[name='ids']");
            var flag = false;
            for (var i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    flag = true;
                }
            }
            if (flag) {
                if (confirm("确定要屏蔽吗?")) {
                    $.post("${pageContext.request.contextPath}/product/block", $("#products").serialize(), function () {
                        location.reload();
                    })
                }
            }else {
                alert("至少选择一条数据....")
            }

        }

        $(function () {
            $("#rows").change(function () {
                var rows = $("#rows option:selected").val();
                location.href = "${pageContext.request.contextPath}/product/findAll?page=1&rows=" + rows + "&condition=${condition}"
            })

        });
        $(function () {
            $('#dataList').DataTable({
                'paging': false,
                'lengthChange': false,
                'searching': false,
                'ordering': true,
                'info': false,
                'autoWidth': true
            })
        })
    </script>
</body>

</html>