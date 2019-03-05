package com.lizewu.miaosha.service.impl;

import com.lizewu.miaosha.dao.UserDOMapper;
import com.lizewu.miaosha.dao.UserPasswordDOMapper;
import com.lizewu.miaosha.dataobject.UserDO;
import com.lizewu.miaosha.dataobject.UserPasswordDO;
import com.lizewu.miaosha.service.UserService;
import com.lizewu.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //调用userDOMapper根据主键获取对应的用户对象dataObject
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if (userDO == null) {
            return null;
        }
        //通过用户id获取对应的用户加密密码信息
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        if (userPasswordDO == null) {
            return null;
        }
        UserModel userModel = convertFromDataObject(userDO, userPasswordDO);
        return userModel;
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        if(userDO == null)
        {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);

        if(userPasswordDO != null)
        {
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
