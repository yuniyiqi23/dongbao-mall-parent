package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.ums.dto.UserParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.deploy.util.ParameterUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String register(UserParamDTO userParamDTO) {
        // 组织参数
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(userParamDTO, umsMember);
        umsMember.setPassword(passwordEncoder.encode(userParamDTO.getPassword()));
        umsMemberMapper.insert(umsMember);
        return "success";
    }
}
