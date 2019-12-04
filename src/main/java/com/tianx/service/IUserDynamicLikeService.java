package com.tianx.service;

import com.tianx.entity.UserDynamicLike;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author candy
 * @since 2019-12-02
 */
public interface IUserDynamicLikeService extends IService<UserDynamicLike> {
  void  addLike(UserDynamicLike userDynamicLike);
  Integer likeCount(Integer DynamicId);
}
