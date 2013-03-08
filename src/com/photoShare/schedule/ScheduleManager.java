package com.photoShare.schedule;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.photoShare.schedule.job.JobTasks;

public class ScheduleManager {
	private ScheduleManager() {

	}

	private static final ScheduleManager MANAGER = new ScheduleManager();

	public static ScheduleManager Instance() {
		return MANAGER;
	}

	private Scheduler scheduler = ScheduleProducer.getScheduler();

	private JobTasks jobTasks = new JobTasks();

	private TriggerStore store = TriggerStore.Instance();

	public synchronized void invokePopularPhotoAtMidNight() {
		Trigger trigger = store.create("0 0 0 * * ?");
		try {
			scheduler.scheduleJob(jobTasks.invokePopularPhotoEveryMidNight(),
					trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void invokeSimpleJob() {
		Trigger trigger = store.create(5, 5);
		try {
			scheduler.scheduleJob(jobTasks.invokeSimpleJob(), trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void start() {
		try {
			if (scheduler.isStarted())
				return;
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void shutdown() {
		try {
			if (scheduler.isShutdown())
				return;
			scheduler.shutdown(true);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
