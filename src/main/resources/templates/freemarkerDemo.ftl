<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker案例</title>
</head>
<body>
    <table border="1" align="center" width="50%">
        <tr>
            <th>id</th>
            <th>用户名</th>
            <th>年龄</th>
        </tr>
        <#list list as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.age}</td>
            </tr>
        </#list>
    </table>
</body>
</html>