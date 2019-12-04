package com.tianx.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.Date;

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
    public class UserDynamic implements Serializable {

    private static final long serialVersionUID = 1L;
private Integer Id;
            /**
            * 用户id
            */
    private Integer userId;

            /**
            * 动态内容
            */
    private String dynamicContent;

            /**
            * 图片
            */
    private String dynamicImage;

            /**
            * 发表时间
            */
    private Date cTime;


}
