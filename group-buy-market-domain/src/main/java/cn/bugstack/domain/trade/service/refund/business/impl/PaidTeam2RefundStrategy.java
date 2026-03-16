package cn.bugstack.domain.trade.service.refund.business.impl;

import cn.bugstack.domain.trade.model.entity.TradeRefundOrderEntity;
import cn.bugstack.domain.trade.service.refund.business.IRefundOrderStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service("paidTeam2RefundStrategy")
public class PaidTeam2RefundStrategy implements IRefundOrderStrategy {
    @Override
    public void refundOrder(TradeRefundOrderEntity tradeRefundOrderEntity) {

    }
}
