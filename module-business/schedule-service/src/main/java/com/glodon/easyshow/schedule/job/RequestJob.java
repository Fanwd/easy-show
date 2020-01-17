package com.glodon.easyshow.schedule.job;

import com.glodon.easyshow.entity.ScheTaskInfoEntity;
import com.glodon.easyshow.schedule.repository.ScheTaskInfoRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: fanwd
 * @Description: 发送请求任务
 * @Date: Create in 23:47 2019/10/7
 */
public class RequestJob extends TransactionQuartzJobBean {

    private static final Logger LOG = LoggerFactory.getLogger(RequestJob.class);

    @Autowired
    ScheTaskInfoRepository scheTaskInfoRepository;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ScheTaskInfoEntity one = scheTaskInfoRepository.getOne(1L);
        LOG.info("request-job[{}]", one.getName());
    }
}
