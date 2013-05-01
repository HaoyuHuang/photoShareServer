package com.photoShare.actions;

import java.io.File;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.async.AbstractAsyncListener;
import com.photoShare.async.AsyncUtils;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.IFileTools;
import com.photoShare.request.service.IPhotoService;
import com.photoShare.request.service.impl.FileTools;
import com.photoShare.request.service.impl.PhotoService;
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
	// private Semaphore semaphore = new Semaphore(0);
	private File image;
	private String imageFilePath;
	private String imageContentType;
	private String uid;

	@Override
	public String execute() throws Exception {
		async = AsyncUtils.getInstance();
		mFileTools = new FileTools();
		System.out.println(QuartzUtils.formattedNow() + "  UploadFileAction");
		// String realPath = ServletActionContext.getServletContext()
		// .getContextPath();
		String classpath = Server.SERVER_CLASS_PATH;

		if (image != null) {

			try {
				String relativePath = "/" + "test" + "/" + "photo" + "/"
						+ "upload" + "/";

				File dir = new File(classpath + relativePath);
				if (!dir.mkdir()) {
					dir.mkdirs();
				}

				String absolutePath = dir.getAbsolutePath();
				final TPhoto srcPhoto = new TPhoto();
				System.out.println("abpath -- " + absolutePath);
				String name = mFileTools.write(image, absolutePath);
				srcPhoto.setFCaption("");
				srcPhoto.setFLargeSizeHeight(720);
				srcPhoto.setFLargeSizeWidth(720);
				srcPhoto.setFLargeSizeUrl(relativePath + name);
				srcPhoto.setFMiddleSizeUrl(relativePath + name);
				srcPhoto.setFSmallSizeUrl(relativePath + name);
				photoService.publishPhoto(srcPhoto, uid);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// File origFile = new File(absolutePath, name);
			// processImages(srcPhoto, origFile, absolutePath,
			// Integer.parseInt(uid));
			// semaphore.acquire();
		}
		return SUCCESS;
	}

	public PhotoBean getPhoto() {
		return photo;
	}

	private void processImages(final TPhoto srcPhoto, final File origFile,
			final String webPath, final int uid) {
		async.processImages(srcPhoto, origFile,
				new AbstractAsyncListener<String>() {

					@Override
					public void onFault(Throwable fault) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onComplete(String bean) {
						try {
							PhotoService photoService = new PhotoService();
							photoService.setUserDAO(new TUserDAO());
							photoService.publishPhoto(srcPhoto, uid);
							System.out.println(srcPhoto.getFLargeSizeUrl());
							System.out.println(srcPhoto.getFMiddleSizeUrl());
							System.out.println(srcPhoto.getFSmallSizeUrl());
							BeansFactory factory = new BeansFactory();
							photo = factory.convertNewBean(srcPhoto);
							// semaphore.release();
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

	public void setImage(File image) {
		this.image = image;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@JSON(serialize = false)
	public IPhotoService getPhotoService() {
		return photoService;
	}

	@JSON(serialize = false)
	public IFileTools getmFileTools() {
		return mFileTools;
	}

	@JSON(serialize = false)
	public AsyncUtils getAsync() {
		return async;
	}

	@JSON(serialize = false)
	public File getImage() {
		return image;
	}

	@JSON(serialize = false)
	public String getImageFilePath() {
		return imageFilePath;
	}

	@JSON(serialize = false)
	public String getImageContentType() {
		return imageContentType;
	}

	@JSON(serialize = false)
	public String getUid() {
		return uid;
	}

	public void setPhoto(PhotoBean photo) {
		this.photo = photo;
	}

	public void setAsync(AsyncUtils async) {
		this.async = async;
	}
}
