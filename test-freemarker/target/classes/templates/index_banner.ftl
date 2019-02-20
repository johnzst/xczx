<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF‐8">
        <title>Title</title>
</head>
<body>
<div class="banner‐roll">
    <div class="banner‐item">
        <#if map?? && map.success==true>
            <#list map.cmsConfig.model as model>
                <div class="item" style="background‐image: url(${model.value});"></div>
            </#list>
        </#if>
    </div>
    <div class="indicators"></div>
</div>
</body>
</html>