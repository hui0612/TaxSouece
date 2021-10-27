<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改纳税人</title>
    <link href="../../static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="../../static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/icon.css">
    <link href="../../static/css/edit.css" rel="stylesheet">

  </head>
  <body>
     <div class="container">
        <div class="content">
            <div title="纳税人信息" data-options="closable:false" class="basic-info">
                <div class="column"><span class="current">修改纳税人信息</span></div>
                <form id="editForm">
                <input name="id" id="id" type="hidden" value="${requestScope.tax.id }">
                <table class="kv-table">              	
                    <tbody>                 
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content"><input type="text" name = "payerCode" value="${requestScope.tax.payerCode}"></td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content"><input type="text" name = "payerName" value="${requestScope.tax.payerName}"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><input type="text" name = "bizAddress" value="${requestScope.tax.bizAddress}"></td>
                        <td class="kv-label">生成经营地电话</td>
                        <td class="kv-content"><input type="text" name = "bizAddressPhone" value="${requestScope.tax.bizAddressPhone}"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content">
                            <select name="taxOrganid">
                                <c:forEach items="${requestScope.tax2}" var="tax2">
                                    <option  ${tax2.id == requestScope.tax.taxOrganid ? "selected" : ""} value="${tax2.id}">${tax2.organName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content">
                            <select name="industryId">
                                <c:forEach items="${requestScope.tax1}" var="tax1">
                                    <option ${tax1.id == requestScope.tax.industryId ? "selected" : ""} value="${tax1.id}">${tax1.industryName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content">
                            <input type="text" name = "bizScope" value="${requestScope.tax.bizScope}">
                        </td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content">
                            <select name="invoiceType">
                                <c:forEach items="${requestScope.tax3}" var="tax3">
                                    <option ${tax3.invoiceType == requestScope.tax.invoiceType ? "selected" : ""} value="${tax3.id}">${tax3.invoiceType}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content">
                            <input type="text" name = "legalPerson" value="${requestScope.tax.legalPerson}">
                        </td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content">
                            <input type="text" name = "legalIdCard" value="${requestScope.tax.legalIdCard}">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content">
                            <input type="text" name = "finaceName" value="${requestScope.tax.finaceName}">
                        </td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content">
                            <input type="text" name = "finaceIdCard" value="${requestScope.tax.finaceIdCard}">
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">办税人员</td>
                        <td class="kv-content">
                           <label>${requestScope.tax.taxerName}</label>
                        </td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content">${requestScope.tax.recordDate}</td>
                    </tr>
                    </tbody>                                
                </table>
                </form>
            </div>
            <div class="btn-selection">
                <a href="javascript:void(0);" class="easyui-linkbutton save-btn" id="editPayer" data-options="selected:true">修改</a>
                <a href="javascript:void(0);" class="easyui-linkbutton reset-btn" id="reset" data-options="selected:true">重置</a>
            </div>
        </div>
    </div>
  </body>
  <script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../static/js/calendar.js"></script>
<script type="text/javascript">
    $("input[name=executeTime]").datebox({
        formatter: easyUIFormater,
        parser: easyUIparser
    });   
    $(function(){
    	$("#editPayer").on("click",function(){
    		var isValid = $('#editForm').form('validate');
			if(!isValid){
				return;
			}	
    		$.post("TaxUpDateServlet",$("#editForm").serialize(),function(data){
    			if(data.success){
       				parent.$.messager.alert({
       					title:"提示",
       					msg:data.msg
       				})
       				parent.$("#topWindow").window("close")
					//parent.doSearch()	
     			}else{
    				$.messager.alert({
	           			title:"提示",
	           			msg:data.msg
			        })
			     } 			
    		},"json")    	    	
    	})
    	$("#reset").on("click",function(){
			$("#editForm").form("reset")
		})           
    })
</script>
</html>
