package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.vo.PageVO;
import com.geekaca.mall.geekmall.utils.PageResult;

public interface MemberService {
    PageResult selectAllMember(PageVO pageVOparams);
}
