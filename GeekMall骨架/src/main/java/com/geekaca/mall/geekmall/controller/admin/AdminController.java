package com.geekaca.mall.geekmall.controller.admin;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.geekmall.common.ServiceResultEnum;
import com.geekaca.mall.geekmall.config.annotation.TokenToAdminUser;
import com.geekaca.mall.geekmall.controller.param.AdminLoginParam;
import com.geekaca.mall.geekmall.domain.AdminUserToken;
import com.geekaca.mall.geekmall.domain.MallAdminUser;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.domain.MallUser;
import com.geekaca.mall.geekmall.mapper.MallAdminUserMapper;
import com.geekaca.mall.geekmall.mapper.MallGoodsInfoMapper;
import com.geekaca.mall.geekmall.service.AdminUserService;
import com.geekaca.mall.geekmall.utils.JwtUtil;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class AdminController {

    @Autowired
    private MallGoodsInfoMapper goodsInfoMapper;
    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation(value = "根据id查询商品详情")
    @RequestMapping(value = "/getGoodsById", method = RequestMethod.GET)
//    @ResponseBody
    public MallGoodsInfo getGoodsById(Long gid){
        System.out.println("test");
        MallGoodsInfo mallGoodsInfo = goodsInfoMapper.selectByPrimaryKey(gid);
        return mallGoodsInfo;
    }

    /**
     * 增加商品
     * 参数要求 JSON
     * @param goodsInfo
     * @return
     */
    @PostMapping("/addGoods")
    public Result addGoods(@Valid @RequestBody  MallGoodsInfo goodsInfo){
//        if (goodsInfo.getGoodsId() == null ){
//
//        }
        int insert = goodsInfoMapper.insert(goodsInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/adminUser/login")
    public Result login(@Valid @RequestBody AdminLoginParam adminLoginParam){
        String token = adminUserService.login(adminLoginParam);
        if (token != null){
            Result result = ResultGenerator.genSuccessResult();
            //把token返回给前端
            result.setData(token);
            return result;
        }else{
            return ResultGenerator.genFailResult("登陆失败");
        }
    }

    @RequestMapping(value = "/adminUser/profile", method = RequestMethod.GET)
    @ApiOperation(value = "获取管理员信息", notes = "获取管理员信息显示在前端界面")
    public Result profile(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        MallAdminUser userInfo = adminUserService.getUserById(uidLong);
        Result result = ResultGenerator.genSuccessResult(userInfo);
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public Result logout(@TokenToAdminUser AdminUserToken adminUser) {
        log.info("adminUser:{}", adminUser.toString());
        adminUserService.logout(adminUser.getAdminUserId());
        return ResultGenerator.genSuccessResult();
    }
}
