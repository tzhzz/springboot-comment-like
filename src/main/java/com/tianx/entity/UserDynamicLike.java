package com.tianx.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    *
    * </p>
*
* @author candy
* @since 2019-12-02
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class UserDynamicLike implements Serializable {

    private static final long serialVersionUID = 1L;
        private Integer Id;
            /**
            * 被点赞的动态
            */
    private Integer dynamicId;

            /**
            * 点赞的用户
            */
    private Integer userId;

            /**
            * 点赞状态0.取消点赞1.点赞
            */
    private Integer likeState;


}
