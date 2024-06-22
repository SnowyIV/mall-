package com.geekaca.mall.service.impl;

import com.geekaca.mall.controller.param.PageParam;
import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.exceptions.LoginNameExsistsException;
import com.geekaca.mall.mapper.UserMapper;
import com.geekaca.mall.service.UserService;
import com.geekaca.mall.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.geekaca.mall.constants.MallConstants.CODE_LOGIN_NAME_EXSISTS;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserParam userParam) {
        return userMapper.selectUser(userParam);
    }

    @Override
    public int userRegister(String loginName, String password) {
        /**
         * 1, 检查用户名是否重复
         * 2，执行注册
         */
        int cnt = userMapper.selectCountByLoginName(loginName);
        if (cnt > 0) {
            //用户名已经被占用
            throw new LoginNameExsistsException(CODE_LOGIN_NAME_EXSISTS, "用户名" + loginName + "已经被占用");
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPasswordMd5(password);
        int inserted = userMapper.insertUser(user);
        return inserted;
    }

    @Override
    public User getUserById(long uidLong) {
        return userMapper.selectByPrimaryKey(uidLong);
    }

    @Override
    public int updateUserInfo(User userUpdateInfo) {
        return userMapper.updateUserInfo(userUpdateInfo);
    }

    @Override
    public PageResult selectAllMember(PageParam pageParam) {
        int counts = userMapper.selectCounts(pageParam);
        if (counts > 0) {
            pageParam.setStart((pageParam.getPageNO() - 1) * pageParam.getPageSize());
            List<User> userList = userMapper.selectAllUser(pageParam);
            PageResult pageResult = new PageResult(userList, counts, pageParam.getPageSize(), pageParam.getPageNO());
            return pageResult;
        }
        return null;
    }

    @Override
    public int updateUserLock(Long[] ids, int lockedFlag) {
        return userMapper.updateUserLock(ids, lockedFlag);
    }
}
