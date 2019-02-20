package com.xuecheng.api.controller;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value="cms 配置管理接口",description = "cms配置管理接口,提供数据模型的管理,查询接口")
public interface CmsConfigControllerApi {

    final String API_PRE = "/cms/config";

    @ApiOperation("根据主键Id查询数据模型信息")
    @GetMapping(API_PRE+"/getmodel/{id}")
    public CmsConfig getModel(@PathVariable("id")String id);
}
