package com.msb.dongbao.ums.mapper;

import com.msb.dongbao.ums.dto.UserParamDTO;
import com.msb.dongbao.ums.entity.UmsMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author Adam
 * @since 2022-08-27
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    UmsMember getUserInfoByCondtion(@Param("username") String username);

}
