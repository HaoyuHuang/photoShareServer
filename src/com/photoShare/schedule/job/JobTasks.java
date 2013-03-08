package com.photoShare.schedule.job;

import static org.quartz.JobBuilder.newJob;

import org.quartz.JobDetail;

import com.photoShare.schedule.QuartzIdProvider;

public class JobTasks {
	public JobDetail invokePopularPhotoEveryMidNight() {
		JobDetail job = newJob(PopularPhotoJob.class)
				.withIdentity("job" + QuartzIdProvider.Instance().getId())
				.withDescription("axis calling job").requestRecovery(false)
				.build();
		return job;
	}

	public JobDetail invokeSimpleJob() {
		JobDetail job = newJob(SimpleJob.class)
				.withIdentity("job" + QuartzIdProvider.Instance().getId())
				.withDescription("axis calling job").requestRecovery(false)
				.build();
		return job;
	}
}
