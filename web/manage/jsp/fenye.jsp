<%--
  Created by IntelliJ IDEA.
  User: hui
  Date: 2021/10/20
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="../../static/easyui/themes/gray/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/easyui/themes/icon.css">
    <script type="text/javascript" src="../../static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<table id="dg"></table>
<script>
    $("#dg").datagrid({
        url:"/TaxpayerServlet",
        columns:[[
            {field:"payerCode",title:"纳税人识别号",width:100},
            {field:"payerName",title:"纳税人名称",width:100},
            {field:"organName",title:"税务机关名称",width:100},
            {field:"industryName",title:"行业名称",width:100},
            {field:"legalPerson",title:"法人代表",width:100},
            {field:"legalIdCard",title:"法人身份号码",width:100},
            {field:"finaceName",title:"财务人员",width:100},
            {field:"finaceIdCard",title:"财务人员身份号码",width:100},
            {field:"recordDate",title:"录入日期",width:100},
        ]],
        fitColumns:true,
        singleSelect:true,
        pagination:true,
        pageList:[2,4,8],
        pageSize:2
    });
</script>
</body>
</html>

