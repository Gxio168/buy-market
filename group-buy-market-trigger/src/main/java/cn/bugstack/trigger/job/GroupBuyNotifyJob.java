package cn.bugstack.trigger.job;


import cn.bugstack.domain.trade.service.ITradeTaskService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GroupBuyNotifyJob {
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private ITradeTaskService tradeTaskService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void exec() {
        RLock lock = redissonClient.getLock("group_buy_market_notify_job_exec");
        try {
            // 分布式锁
            boolean isLocked = lock.tryLock(3, 0, TimeUnit.SECONDS);
            if (!isLocked) return;
            Map<String, Integer> result = tradeTaskService.execNotifyJob();
            log.info("定时任务，回调通知拼团完结任务 result:{}", JSON.toJSONString(result));
        } catch (Exception e) {
            log.error("定时任务，回调通知拼团完结任务失败", e);
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
