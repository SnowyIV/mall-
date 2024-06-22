package com.geekaca.mall.controller.admin;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.controller.param.AdminLoginParam;
import com.geekaca.mall.domain.AdminUser;
import com.geekaca.mall.service.AdminUserService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/manage-api/v1")
public class AdminUserController {

@Autowired
private AdminUserService adminUserService;
//参照前台自己写的
//    @PostMapping("/adminUser/login")
//    public Result login(@RequestBody @Valid AdminLoginParam adminLoginParam){
//        AdminUser adminUser = adminUserService.login(adminLoginParam);
//        Result result = ResultGenerator.genSuccessResult();
//        if (adminUser != null){
//            String token = JwtUtil.createToken(String.valueOf(adminUser.getAdminUserId()), adminUser.getLoginUserName());
//            result.setData(token);
//            return result;
//        }
//        return ResultGenerator.genFailResult("登陆失败");
//
//    }

        @PostMapping("/adminUser/login")
        public Result login(@Valid @RequestBody AdminLoginParam adminLoginParam) {
            String token = adminUserService.login(adminLoginParam);
            if (token == null){
                return ResultGenerator.genFailResult("登陆失败");
            }else{
                Result rs = new Result();
                rs.setData(token);
                rs.setResultCode(ResultGenerator.RESULT_CODE_SUCCESS);
                return  rs;
            }
    }

    @GetMapping("/adminUser/profile")
    @ApiOperation(value = "获取管理员信息", notes = "获取管理员信息显示在前端界面")
    public Result profile(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        Claim userNameClaim = stringClaimMap.get("userName");
        String userName = userNameClaim.asString();
        //todo: 用userId 去数据库中查 用户的信息
        AdminUser user = new AdminUser();
        Result result = ResultGenerator.genSuccessResult(user);
        return result;
    }
}
