package com.msb.dongbao.ums.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.ums.api.dto.UserParamDTO;
import com.msb.dongbao.ums.api.entity.UmsMember;
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

    String register(UserParamDTO userParamDTO);

}
