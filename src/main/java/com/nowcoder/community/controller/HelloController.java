package com.nowcoder.community.controller;

import com.nowcoder.community.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }

    @RequestMapping("/testController")
    public String testController() {
        return helloService.testService();
    }

    //servlet原生获取请求参数方式
    @RequestMapping("/testHttp")
    public void testHttp(HttpServletRequest request, HttpServletResponse response) {
        //获取请求数据：获取请求方法、路径、请求头、请求参数
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
        }
        System.out.println(request.getParameter("code"));

        //向浏览器响应数据:设置响应类型为html的文本，字符集为utf-8
        // JDK1.7之后将要关闭的资源直接写在try的小括号中，实现资源的关闭，前提是必须有close方法
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
        ) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //从控制器获取请求参数
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String getStudents(
            @RequestParam(name = "id", required = false, defaultValue = "1") int id,
            @RequestParam(name = "name", required = false, defaultValue = "hehe") String name) {
        System.out.println(id);
        System.out.println(name);
        return "some students";
    }

    //restful风格的请求方式和获取参数方式
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    public String getStudents(
            @PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    //处理post请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应html数据：使用ModelAndView、Model、Map、ModelAndMap
    // ModelAndView是将数据和视图都封装在一个ModelAndView对象中返回
    // Model是将数据封装在里面，最后直接返回视图名称
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "北京大学");
        model.addAttribute("age", 80);
        return "/demo/view";
    }

    //响应json数据（异步请求）
    // Java对象 -> JSON字符串 -> JS对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "李四");
        emp.put("age", 24);
        emp.put("salary", 9000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "王五");
        emp.put("age", 25);
        emp.put("salary", 10000.00);
        list.add(emp);

        return list;
    }

}
