package cn.bugstack.domain.trade.model.entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRefundCommandEntity {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 外部交易单号
     */
    private String outTradeNo;

    /**
     * 渠道
     */
    private String source;

    /**
     * 来源
     */
    private String channel;
}
