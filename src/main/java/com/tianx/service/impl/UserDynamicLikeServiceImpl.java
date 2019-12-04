package com.tianx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tianx.entity.UserDynamicLike;
import com.tianx.mapper.UserDynamicLikeMapper;
import com.tianx.service.IUserDynamicLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author candy
 * @since 2019-12-02
 */
@Service
public class UserDynamicLikeServiceImpl extends ServiceImpl<UserDynamicLikeMapper, UserDynamicLike> implements IUserDynamicLikeService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static String KEY_PREFIX = "tianx:like:uid:";
    @Autowired
    private UserDynamicLikeMapper userDynamicLikeMapper;

    @Override
    public void addLike(UserDynamicLike userDynamicLike) {
        //Redis的key
        String key=KEY_PREFIX+userDynamicLike.getUserId()+":DynamicId:"+userDynamicLike.getDynamicId();
        //获取hash操作对象
        BoundHashOperations<String,Object,Object> hashOperations = this.stringRedisTemplate.boundHashOps(key);
        //查询是否存在
        Integer userId=userDynamicLike.getUserId();
        Integer dynamicId=userDynamicLike.getDynamicId();
        Integer num = userDynamicLike.getLikeState();
        Boolean result = hashOperations.hasKey(userId.toString()+dynamicId.toString());
        if(result){
            //存在，获取数据
            String json = hashOperations.get(userId.toString()+dynamicId.toString()).toString();

            userDynamicLike = JsonUtils.parse(json,UserDynamicLike.class);
            userDynamicLike.setLikeState(num);
        }
        hashOperations.put(userId.toString()+dynamicId.toString(),JsonUtils.serialize(userDynamicLike));
    }

    @Override
    public Integer likeCount(Integer DynamicId) {

        Integer count=userDynamicLikeMapper.selectCount(new QueryWrapper<UserDynamicLike>().eq("dynamic_id", DynamicId).eq("like_state",1));

        return count;
    }
}
