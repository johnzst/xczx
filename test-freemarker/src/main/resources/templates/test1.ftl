<!DOCTYPE html>
<html>
<head>
        <meta charset="utf‐8">
        <title>Hello World!</title>
</head>
<body>
输出stu1的学生信息: <br/>
姓名: ${stuMap['stu1'].name}<br/>
年龄: ${stuMap['stu1'].age}<br/>
输出stu的学生信息: <br/>
姓名: ${stuMap.stu1.name}<br/>
年龄: ${stuMap.stu1.age}<br/>
遍历输出两个学生信息: <br/>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#list stus as stu>
        <tr>
            <td>${stu_index+1}</td>
            <td<#if stu.name=='小明'>style="background:red;"</#if>> ${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.money}</td>
        </tr>
    </#list>

</table>
</br>
    <table>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>出生日期</td>
            <td>钱包</td>
            <td>最好的朋友</td>
            <td>朋友个数</td>
            <td>朋友列表</td>
        </tr>
        <#if stus??>
            <#list stus as stu>
                <td>${stu.name!''}</td>
                <td>${stu.age}</td>
                <td>${stu.money}</td>
                <td>${(stu.bestFriend.name)!''}</td>
                <td>${(stu.friends.size()!0)}</td>
            <td>
                <#if stu.friends??>
                    <#list stu.friends as friend>
                        ${friend.name!''}<br/>
                    </#list>
                </#if>
            </td>
            </#list>
        </#if>


    </table>


</body>
</html>