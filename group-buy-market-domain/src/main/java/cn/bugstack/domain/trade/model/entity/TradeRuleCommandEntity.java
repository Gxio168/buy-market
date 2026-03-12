package cn.bugstack.domain.trade.model.entity;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRuleCommandEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;
}
