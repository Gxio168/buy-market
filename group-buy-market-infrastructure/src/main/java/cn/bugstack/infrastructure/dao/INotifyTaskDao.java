package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.NotifyTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface INotifyTaskDao {
    void insert(NotifyTask notifyTask);

    List<NotifyTask> queryUnExecutedNotifyTaskList();

    NotifyTask queryUnExecutedNotifyTaskByTeamId(String teamId);

    int updateNotifyTaskStatusSuccess(NotifyTask notifyTask);

    int updateNotifyTaskStatusError(NotifyTask notifyTask);

    int updateNotifyTaskStatusRetry(NotifyTask notifyTask);
}
