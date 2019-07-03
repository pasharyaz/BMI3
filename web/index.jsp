<%--
  Created by IntelliJ IDEA.
  User: pryazanov
  Date: 26.06.2019
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BMI</title>
</head>
<body>
<!-- header -->
<div>
    <h1>Body mass index (BMI)</h1>
</div>

<div>
    <div>
        <h2>Insert your parameters to count you BMI</h2>
    </div>
    <form method="post" action="BMI.jsp">

        <label>Weight in kg:
            <input type="text" name="weight"><br/>
        </label>
        <label>Height in cm:
            <input type="text" name="height"><br/>
        </label>
        <button type="submit">Submit</button>
    </form>

</div>
<%--<a href="BMI.jsp">History</a>--%>
</body>
</html>
