package com.xuecheng.test.freemarker.controller;

import com.xuecheng.test.freemarker.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @RequestMapping("/test1")
   public String freemarker(Map<String,Object> map){
       map.put("name","飞创大厦27号");
       Student s1 = new Student();
       s1.setName("小米");
       s1.setAge(18);
       s1.setMoney(100.86f);
       s1.setBirthday(new Date());
       Student s2 = new Student();
       s2.setName("小傻逼");
       s2.setMoney(200.1f);
       s2.setAge(19);
        List<Student> friends= new ArrayList<>();
        friends.add(s1);
        s2.setFriends(friends);
        s2.setBestFriend(s1);
        List<Student> stus = new ArrayList<>();
        stus.add(s1);
        stus.add(s2);
        map.put("stus",stus);
        // 准备map数据
        HashMap<String,Student> stuMap = new HashMap<>();
        stuMap.put("stu1",s1);
        stuMap.put("stu2",s2);
        map.put("stu1",s1);
        map.put("stu2",s2);
        map.put("stuMap",stuMap);

       return "test1";
   }
}
