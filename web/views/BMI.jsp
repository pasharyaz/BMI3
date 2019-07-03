<%--
  Created by IntelliJ IDEA.
  User: pryazanov
  Date: 26.06.2019
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BMI</title>
</head>
<body>
<div>
    <h1>Body mass index (BMI)</h1>
</div>


<div>
    <h2>Insert your parameters to count you BMI</h2>
</div>
<form method="post">

    <label>Weight in kg:
        <input type="text" name="weight"><br/>
    </label>

    <label>Height in cm:
        <input type="text" name="height"><br/>
    </label>

    <button type="submit">Submit</button>
</form>


<u1>Your BMI is:</u1>
<u1>${lastBMI}</u1>


<div>
    <h2>History of BMI</h2>
</div>

<ul>
    <table>
        <c:forEach var="modelEx" items="${model}">

            <p>${modelEx}</p>


        </c:forEach>

    </table>

</ul>
<a href="/">Back to main</a>
</body>
</html>
