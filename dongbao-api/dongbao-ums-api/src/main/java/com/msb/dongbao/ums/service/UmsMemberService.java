package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.commom.base.response.ResponseWapper;
import com.msb.dongbao.ums.dto.UserLoginDTO;
import com.msb.dongbao.ums.dto.UserParamDTO;
import com.msb.dongbao.ums.entity.UmsMember;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author Adam
 * @since 2022-08-27
 */
@Component
public interface UmsMemberService extends IService<UmsMember> {

    ResponseWapper register(UserParamDTO userParamDTO);

    ResponseWapper login(UserLoginDTO userLoginDTO);

}
