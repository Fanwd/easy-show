package com.glodon.easyshow.job;

import com.glodon.easyshow.entity.TaskInfoEntity;
import com.glodon.easyshow.repository.TaskInfoRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 23:47 2019/10/7
 */
public class RequestJob extends TransactionQuartzJobBean {

    private static final Logger LOG = LoggerFactory.getLogger(RequestJob.class);

    @Autowired
    TaskInfoRepository taskInfoRepository;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        TaskInfoEntity one = taskInfoRepository.getOne(1L);
        LOG.info("request-job[{}]", one.getName());
    }
}
