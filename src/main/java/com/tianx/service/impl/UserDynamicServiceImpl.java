package com.tianx.service.impl;

import com.tianx.dto.UserDynamicDTO;
import com.tianx.entity.UserDynamic;
import com.tianx.mapper.UserDynamicMapper;
import com.tianx.service.IUserDynamicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author candy
 * @since 2019-12-02
 */
@Service
public class UserDynamicServiceImpl extends ServiceImpl<UserDynamicMapper, UserDynamic> implements IUserDynamicService {
    @Autowired
    private UserDynamicMapper userDynamicMapper;

//    @Override
//    public List<UserDynamicDTO> findDynamicAll() {
//
//        userDynamicMapper.sel
//        return null;
//    }
}
