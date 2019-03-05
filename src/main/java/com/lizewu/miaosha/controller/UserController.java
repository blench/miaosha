package com.lizewu.miaosha.controller;

import com.lizewu.miaosha.controller.viewobject.UserVO;
import com.lizewu.miaosha.service.UserService;
import com.lizewu.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller("user")
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam(name="id")Integer id)
    {
        //调用 Service 服务获取对应 id 的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        return convertFromModel(userModel);
    }

    private UserVO convertFromModel(UserModel userModel)
    {
        if(userModel == null)
        {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userVO, userModel);
        return userVO;
    }
}
