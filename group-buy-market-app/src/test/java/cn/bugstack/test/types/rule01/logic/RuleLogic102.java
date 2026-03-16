package cn.bugstack.test.types.rule01.logic;


import cn.bugstack.test.types.rule01.factory.Rule01TradeRuleFactory;
import cn.bugstack.wrench.design.framework.link.model1.AbstractLogicLink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RuleLogic102 extends AbstractLogicLink<String, Rule01TradeRuleFactory.DynamicContext, String> {

    @Override
    public String apply(String requestParameter, Rule01TradeRuleFactory.DynamicContext dynamicContext) {
        log.info("link model01 RuleLogic102");

        return "link model01 单实例链";
    }
}
