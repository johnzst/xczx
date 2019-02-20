package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    /**
     *
     *   书写大量的测试方法
     */

    @Autowired
    CmsPageRepository cmsPageRepository;

    // 添加
    @Test
    public void testInsert(){
        CmsPage cmsPage = new CmsPage();
            cmsPage.setSiteId("s01");
            cmsPage.setTemplateId("t01");
            cmsPage.setPageName("测试页面");
            cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);

    }

    // 自定义条件查询测试
    @Test
    public void testFindAll(){
       // 条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        // 条件值
        CmsPage cmsPage = new CmsPage();
        // 站点id
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        // 模板id
        cmsPage.setTemplateId("5a962c16b00ffc514038fafd");
        // 创建实例条件
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Pageable pageable = new PageRequest(0,10);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all);


    }
    //删除
    @Test
    public void testDelete(){
        cmsPageRepository.deleteById("5b17a2c511fe5e0c409e5eb3");
    }

    // 修改 5abefd525b05aa293098fca6
    @Test
    public void testUpdate(){
        // 查询对象
        Optional<CmsPage> page = cmsPageRepository.findById("5b17a2c511fe5e0c409e5eb3");
        if(page.isPresent()){
            CmsPage cmsPage = page.get();
            cmsPage.setPageName("魏翩大美女");
            cmsPageRepository.save(cmsPage);
        }

    }


}