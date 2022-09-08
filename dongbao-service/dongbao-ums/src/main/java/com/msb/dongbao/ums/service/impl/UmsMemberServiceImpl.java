package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.commom.base.constants.IdentityConstant;
import com.msb.dongbao.commom.base.constants.TokenTypeConstant;
import com.msb.dongbao.commom.base.response.ResponseWapper;
import com.msb.dongbao.commom.base.response.TokenResponse;
import com.msb.dongbao.common.util.JwtUtils;
import com.msb.dongbao.ums.dto.UserLoginDTO;
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
    public ResponseWapper register(UserParamDTO userParamDTO) {
        // 组织参数
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(userParamDTO, umsMember);
        umsMember.setPassword(passwordEncoder.encode(userParamDTO.getPassword()));
        umsMemberMapper.insert(umsMember);
        return ResponseWapper.success();
    }

    @Override
    public ResponseWapper login(UserLoginDTO userLoginDTO) {
        // 组织参数
        UmsMember umsMember = umsMemberMapper.getUserInfoByCondtion(userLoginDTO.getUsername());
        if (null != umsMember) {
            // 校验密码
            boolean matches = passwordEncoder.matches(userLoginDTO.getPassword(), umsMember.getPassword());
            if (matches) {
                String token = JwtUtils.generateToken(umsMember.getUsername(), IdentityConstant.USER_IDENTITY, TokenTypeConstant.ACCESS_TOKEN_IDENTITY);
                TokenResponse tokenResponse = new TokenResponse();
                tokenResponse.setAccessToken(token);
                // TODO token存redis
                return ResponseWapper.success(tokenResponse);
            }
            // TODO 用户名或密码错误
            return ResponseWapper.fail();
        }
        // TODO 用户名或密码错误
        return ResponseWapper.fail();
    }
}
