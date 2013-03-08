package com.photoShare.schedule.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.photoShare.util.QuartzUtils;

public abstract class BaseJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("[" + QuartzUtils.format(new Date()) + "]  "
				+ this.getClass().getName() + " Invoked");
	}

	protected abstract void perform(JobExecutionContext context)
			throws JobExecutionException;

}
