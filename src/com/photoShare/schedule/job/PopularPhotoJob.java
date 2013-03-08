package com.photoShare.schedule.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.photoShare.beans.photos.PopularPhotoHolder;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.impl.PhotoService;

public class PopularPhotoJob extends BaseJob {

	private PopularPhotoHolder popularPhotoHolder = PopularPhotoHolder
			.Instance();

	private PhotoService photoService = new PhotoService();

	private TUserDAO userDAO = new TUserDAO();

	@Override
	protected void perform(JobExecutionContext context)
			throws JobExecutionException {
		photoService.setUserDAO(userDAO);
		try {
			popularPhotoHolder.hold(photoService.getPopularPhotos());
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
