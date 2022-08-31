package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.ums.dto.UserParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Adam
 * @since 2022-08-27
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Override
    public String register(UserParamDTO userParamDTO) {
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(userParamDTO.getUsername());
        umsMember.setEmail(userParamDTO.getEmail());
        umsMember.setNickName(userParamDTO.getNickName());
        umsMemberMapper.insert(umsMember);
        return "success";
    }
}
