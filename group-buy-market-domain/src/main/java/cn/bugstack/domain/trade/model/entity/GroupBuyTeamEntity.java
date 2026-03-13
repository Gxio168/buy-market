package cn.bugstack.domain.trade.model.entity;

import cn.bugstack.types.enums.GroupBuyOrderEnumVO;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyTeamEntity {

    /**
     * 拼单组队ID
     */
    private String teamId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 目标数量
     */
    private Integer targetCount;
    /**
     * 完成数量
     */
    private Integer completeCount;
    /**
     * 锁单数量
     */
    private Integer lockCount;
    /**
     * 有效开始时间
     */
    private Date validStartTime;
    /**
     * 有效结束时间
     */
    private Date validEndTime;
    /**
     * 状态（0-拼单中、1-完成、2-失败）
     */
    private GroupBuyOrderEnumVO status;
    /**
     * 回调地址
     */
    private String notifyUrl;

}
