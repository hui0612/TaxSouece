<%--
  Created by IntelliJ IDEA.
  User: hui
  Date: 2021/10/20
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
<table border="2" cellspacing="0" cellpadding="5px">
    <tr>
        <input type="hidden" name="id" value="${requestScope.tax.id}">
        <td>纳税人识别号</td>
        <td><input type="text" name = "payerCode" value="${requestScope.tax.payerCode}"></td>
        <td>纳税人名称</td>
        <td></td>
    </tr>
    <tr>
        <td>生产经营地址</td>
        <td></td>
        <td>生产经营地电话</td>
        <td><input type="text" name = "bizAddressPhone" value="${requestScope.tax.bizAddressPhone}"></td>
    </tr>
    <tr>
        <td>所属税务机关</td>
        <td>

        </td>
        <td>所属行业</td>
        <td>

        </td>
    </tr>
    <tr>
        <td>生产经营范围</td>
        <td><input type="text" name = "bizAddress" value="${requestScope.tax.bizAddress}"></td>
        <td>票种核定</td>
        <td>
            <select name="invoiceType">
                <c:forEach items="${requestScope.tax3}" var="tax3">
                    <option ${tax3.invoiceType == requestScope.tax.invoiceType ? "selected" : ""} value="${tax3.invoiceType}">${tax3.invoiceType}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>法人代表</td>
        <td><input type="text" name = "legalPerson" value="${requestScope.tax.legalPerson}"></td>
        <td>法人身份证号码</td>
        <td><input type="text" name = "legalIdCard" value="${requestScope.tax.legalIdCard}"></td>
    </tr>
    <tr>
        <td>主管财务</td>
        <td><input type="text" name = "finaceName" value="${requestScope.tax.finaceName}"></td>
        <td>财务身份证号码</td>
        <td><input type="text" name = "finaceIdCard" value="${requestScope.tax.finaceIdCard}"></td>
    </tr>
    <tr>
        <td>法人身份证照片</td>
        <td><input type="text" name = "legalIdCardImageURL" value="${requestScope.tax.legalIdCardImageURL}"></td>
        <td>财务身份证照片</td>
        <td><input type="text" name = "finaceIdCardImageURL" value="${requestScope.tax.finaceIdCardImageURL}"></td>
    </tr>
    <tr>
        <td>录入人员</td>
        <td><input type="text" name = "taxerName" value="${requestScope.tax.taxerName}"></td>
        <td>录入日期</td>
        <td><input type="date" name = "recordDate" value="${requestScope.tax.recordDate}"></td>
    </tr>
    <tr>
        <td><input type="submit" value="提交"><input type="reset" value="重置"></td>

    </tr>

</table>
</form>
</body>
</html>
