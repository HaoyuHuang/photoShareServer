package com.photoShare.actions;

import java.io.File;
import java.util.concurrent.Semaphore;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.async.AbstractAsyncListener;
import com.photoShare.async.AsyncUtils;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.request.service.IFileTools;
import com.photoShare.request.service.IPhotoService;
import com.photoShare.server.Server;
import com.photoShare.util.QuartzUtils;

public class UploadFileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7591271075785176268L;
	private PhotoBean photo;
	private IPhotoService photoService;
	private IFileTools mFileTools;
	private AsyncUtils async;
	private Semaphore semaphore = new Semaphore(0);

	@Override
	public String execute() throws Exception {

		System.out.println(QuartzUtils.formattedNow() + "  UploadFileAction");
		// String realPath = ServletActionContext.getServletContext()
		// .getContextPath();
		String classpath = Server.SERVER_CLASS_PATH;

		if (photo.getFile() != null) {

			File dir = new File(classpath + "\\" + "test" + "\\" + "photo"
					+ "\\" + "upload" + "\\");
			if (!dir.mkdir()) {
				dir.mkdirs();
			}

			String absolutePath = dir.getAbsolutePath();
			final TPhoto srcPhoto = new TPhoto();

			String name = mFileTools.write(photo.getFile(), absolutePath);

			File origFile = new File(absolutePath, name);
			processImages(srcPhoto, origFile, absolutePath, photo.getUid());
			semaphore.acquire();
		}
		return SUCCESS;
	}

	public PhotoBean getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoBean photo) {
		this.photo = photo;
	}

	private void processImages(final TPhoto srcPhoto, final File origFile,
			final String webPath, final int uid) {
		async.processImages(origFile, new AbstractAsyncListener<String>() {

			@Override
			public void onFault(Throwable fault) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete(String bean) {
				try {
					String name = origFile.getName();
					srcPhoto.setFMiddleSizeUrl(webPath + "middle" + name);
					srcPhoto.setFSmallSizeUrl(webPath + "tiny" + name);
					srcPhoto.setFLargeSizeUrl(webPath + "large" + name);
					photoService.publishPhoto(srcPhoto, photo.getUid());
					BeansFactory factory = BeansFactory.Instance();
					photo = factory.convertBean(srcPhoto, false);
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}

	public void setmFileTools(IFileTools mFileTools) {
		this.mFileTools = mFileTools;
	}

	public void setAsync(AsyncUtils async) {
		this.async = async;
	}
}
