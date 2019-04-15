package com.shsxt.controller;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseController;
import com.shsxt.base.BaseQuery;
import com.shsxt.base.ParamException;
import com.shsxt.model.ResultInfo;
import com.shsxt.po.User;
import com.shsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xlf on 2019/4/15.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryUser", method = RequestMethod.POST)
    @ResponseBody
    public User queryUser(Integer id) throws Exception {
        return userService.queryById(id);
    }

    @RequestMapping("queryUser2/{id}")
    @ResponseBody
    public User queryUser2(@PathVariable Integer id) throws Exception {

        if(true){
            throw new ParamException("参数异常");
        }

        int i  =1/0;
        return userService.queryById(id);
    }

    @RequestMapping("test/{id}/{name}")
    @ResponseBody
    public User test(@PathVariable Integer id, @PathVariable String name) throws Exception {
        System.out.println(id +" - "+name);
        return userService.queryById(id);
    }

    @RequestMapping("queryUserList")
    @ResponseBody
    public PageInfo<User> queryUserList(BaseQuery query) throws Exception {
        return userService.queryForPage(query);
    }

    @RequestMapping("queryUserList2")
    @ResponseBody
    public PageInfo<User> queryUserList2(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) throws Exception {
        System.out.println(pageNum +" - "+pageSize);
        BaseQuery query = new BaseQuery();
        query.setPageNum(pageNum);
        query.setPageSize(pageSize);
        return userService.queryForPage(query);
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public ResultInfo saveUser(User user) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        userService.insert(user);
        resultInfo.setCode(200);
        resultInfo.setMsg("添加成功");
        return resultInfo;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public ResultInfo deleteUser(Integer id) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        userService.delete(id);
        resultInfo.setCode(200);
        resultInfo.setMsg("删除成功");
        return resultInfo;
    }


}
