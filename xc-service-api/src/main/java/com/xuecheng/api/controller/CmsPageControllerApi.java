package com.xuecheng.api.controller;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "cms页面管理接口",description = "cms 页面管理接口,提供页面的增删改查")
public interface CmsPageControllerApi {

    final String API_PRE = "/cms/page";

    @GetMapping(API_PRE+"/list/{page}/{size}")
    @ApiOperation(value="分页查询页面列表",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required = true,paramType = "path",dataType = "Integer"),
            @ApiImplicitParam(name="size",value="每页记录数",required = true,paramType = "path",dataType = "Integer")

    })
    // 分页参数查询结果
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest);

    @ApiOperation("添加页面")
    public CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("通过id 查询页面")
    public CmsPage findById(String id);

    @ApiOperation("修改页面")
    public CmsPageResult edit(String id, CmsPage cmsPage);

    @ApiOperation("通过id 删除页面")
    public ResponseResult delete(String id);
}
