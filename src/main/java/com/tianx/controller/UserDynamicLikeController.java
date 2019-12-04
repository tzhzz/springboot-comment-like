package com.tianx.controller;


import com.tianx.dto.UserDynamicDTO;
import com.tianx.entity.UserDynamic;
import com.tianx.entity.UserDynamicLike;
import com.tianx.service.IUserDynamicLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author candy
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/user")
public class UserDynamicLikeController {
    @Autowired
    private IUserDynamicLikeService userDynamicLikeService;



    /**
     *发布动态
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @RequestMapping(value = "/like",method = {RequestMethod.POST})
    public void saveInfoList(@RequestParam("userId") Integer userId,
                             @RequestParam("dynamicId") Integer  dynamicId,
                             @RequestParam("likeState") Integer likeState
    ){
        UserDynamicLike  userDynamicLike=new UserDynamicLike();
        userDynamicLike.setLikeState(likeState);
        userDynamicLike.setUserId(userId);
        userDynamicLike.setDynamicId(dynamicId);
        userDynamicLikeService.addLike(userDynamicLike);

    }



}
