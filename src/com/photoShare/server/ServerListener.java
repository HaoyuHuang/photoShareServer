package com.photoShare.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.photoShare.schedule.ScheduleManager;

public class ServerListener implements ServletContextListener {

	private ServletContext context;

	private ScheduleManager manager = ScheduleManager.Instance();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		manager.shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		context = arg0.getServletContext();
		String classpath = context.getRealPath("/");
		Server.init(classpath);
		manager.start();
		manager.invokePopularPhotoAtMidNight();

	}

}
