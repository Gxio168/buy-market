package cn.bugstack.domain.trade.service.refund.filter;

import cn.bugstack.domain.trade.model.entity.*;
import cn.bugstack.domain.trade.model.valobj.RefundTypeEnumVO;
import cn.bugstack.domain.trade.model.valobj.TradeOrderStatusEnumVO;
import cn.bugstack.domain.trade.service.refund.business.IRefundOrderStrategy;
import cn.bugstack.domain.trade.service.refund.factory.TradeRefundRuleFilterFactory;
import cn.bugstack.types.enums.GroupBuyOrderEnumVO;
import cn.bugstack.wrench.design.framework.link.model2.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Slf4j
@Service
public class RefundOrderNodeFilter implements ILogicHandler<TradeRefundCommandEntity, TradeRefundRuleFilterFactory.DynamicContext, TradeRefundBehaviorEntity> {

    @Resource
    private Map<String, IRefundOrderStrategy> refundOrderStrategyMap;

    @Override
    public TradeRefundBehaviorEntity apply(TradeRefundCommandEntity tradeRefundCommandEntity, TradeRefundRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        // 上下文数据
        MarketPayOrderEntity marketPayOrderEntity = dynamicContext.getMarketPayOrderEntity();
        TradeOrderStatusEnumVO tradeOrderStatusEnumVO = marketPayOrderEntity.getTradeOrderStatusEnumVO();

        GroupBuyTeamEntity groupBuyTeamEntity = dynamicContext.getGroupBuyTeamEntity();
        GroupBuyOrderEnumVO groupBuyOrderEnumVO = groupBuyTeamEntity.getStatus();
        // 获取执行策略
        RefundTypeEnumVO refundType = RefundTypeEnumVO.getRefundStrategy(groupBuyOrderEnumVO, tradeOrderStatusEnumVO);
        IRefundOrderStrategy refundOrderStrategy = refundOrderStrategyMap.get(refundType.getStrategy());
        // 执行退单操作
        refundOrderStrategy.refundOrder(TradeRefundOrderEntity.builder().userId(tradeRefundCommandEntity.getUserId())
                .orderId(marketPayOrderEntity.getOrderId()).teamId(marketPayOrderEntity.getTeamId())
                .activityId(groupBuyTeamEntity.getActivityId()).build());

        return TradeRefundBehaviorEntity.builder().userId(tradeRefundCommandEntity.getUserId())
                .orderId(marketPayOrderEntity.getOrderId()).teamId(marketPayOrderEntity.getTeamId())
                .tradeRefundBehaviorEnum(TradeRefundBehaviorEntity.TradeRefundBehaviorEnum.SUCCESS).build();
    }
}
