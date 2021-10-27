<%--
  Created by IntelliJ IDEA.
  User: hui
  Date: 2021/10/20
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" cellspacing="0" cellpadding="5px">
    <tr>
        <td>纳税人识别号</td>
        <td>${sessionScope.tp.payerCode}</td>
        <td>纳税人名称</td>
        <td>${sessionScope.tp.payerName}</td>
    </tr>
    <tr>
        <td>生产经营地址</td>
        <td>${sessionScope.tp.bizAddress}</td>
        <td>生产经营地电话</td>
        <td>${sessionScope.tp.bizAddressPhone}</td>
    </tr>
    <tr>
        <td>所属税务机关</td>
        <td>${sessionScope.tp.organName}</td>
        <td>所属行业</td>
        <td>${sessionScope.tp.industryName}</td>
    </tr>
    <tr>
        <td>生产经营范围</td>
        <td>${sessionScope.tp.bizScope}</td>
        <td>票种核定</td>
        <td>${sessionScope.tp.invoiceType}</td>
    </tr>
    <tr>
        <td>法人代表</td>
        <td>${sessionScope.tp.legalPerson}</td>
        <td>法人身份证号码</td>
        <td>${sessionScope.tp.legalIdCard}</td>
    </tr>
    <tr>
        <td>主管财务</td>
        <td>${sessionScope.tp.finaceName}</td>
        <td>财务身份证号码</td>
        <td>${sessionScope.tp.finaceIdCard}</td>
    </tr>
    <tr>
        <td>法人身份证照片</td>
        <td>${sessionScope.tp.legalIdCardImageURL}</td>
        <td>财务身份证照片</td>
        <td>${sessionScope.tp.finaceIdCardImageURL}</td>
    </tr>
    <tr>
        <td>录入人员</td>
        <td>${sessionScope.tp.taxerName}</td>
        <td>录入日期</td>
        <td>${sessionScope.tp.recordDate}</td>
    </tr>

</table>
</body>
</html>
