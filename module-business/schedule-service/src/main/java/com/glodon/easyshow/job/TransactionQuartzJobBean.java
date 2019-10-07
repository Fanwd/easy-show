package com.glodon.easyshow.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 23:46 2019/10/7
 */
public abstract class TransactionQuartzJobBean implements Job {

    /**
     * This implementation applies the passed-in job data map as bean property
     * values, and delegates to {@code executeInternal} afterwards.
     * @see #executeInternal
     */
    @Override
    @Transactional
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
            MutablePropertyValues pvs = new MutablePropertyValues();
            pvs.addPropertyValues(context.getScheduler().getContext());
            pvs.addPropertyValues(context.getMergedJobDataMap());
            bw.setPropertyValues(pvs, true);
        }
        catch (SchedulerException ex) {
            throw new JobExecutionException(ex);
        }
        executeInternal(context);
    }

    /**
     * Execute the actual job. The job data map will already have been
     * applied as bean property values by execute. The contract is
     * exactly the same as for the standard Quartz execute method.
     * @see #execute
     */
    protected abstract void executeInternal(JobExecutionContext context) throws JobExecutionException;


}
