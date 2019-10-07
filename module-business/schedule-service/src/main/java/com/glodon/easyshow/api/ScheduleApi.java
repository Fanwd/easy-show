package com.glodon.easyshow.api;

import com.glodon.easyshow.job.RequestJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 23:45 2019/10/7
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleApi {

    @Autowired
    private Scheduler scheduler;

    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String addJob() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(RequestJob.class)
                .withIdentity("requestJob", "default")
                .storeDurably()
                .build();
        scheduler.addJob(job, Boolean.TRUE);
        return "OK";
    }

    @RequestMapping(value = "/addTrigger", method = RequestMethod.GET)
    public String addTrigger() throws SchedulerException {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob("requestJob", "default")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever()
                )
                .startNow()
                .build();
        scheduler.scheduleJob(trigger);
        return "OK";
    }

}
