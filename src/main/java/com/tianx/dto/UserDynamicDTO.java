package com.tianx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tianx.entity.UserDynamic;
import lombok.Data;

import java.util.List;

/**
 * @author shkstart
 * @date 2019/12/2 - 21:21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDynamicDTO extends UserDynamic {
    private List<String> imageList;

    private Integer likeCount;

    private Integer likeState;
}
