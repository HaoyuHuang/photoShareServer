package com.photoShare.beans.photos;

import java.util.ArrayList;
import java.util.List;

public class PopularPhotoHolder {

	private static final PopularPhotoHolder holder = new PopularPhotoHolder();

	public static PopularPhotoHolder Instance() {
		return holder;
	}

	private List<PhotoBean> popularPhotos = new ArrayList<PhotoBean>();

	public void hold(List<PhotoBean> popularPhotos) {
		if (popularPhotos != null)
			this.popularPhotos = popularPhotos;
	}

	public List<PhotoBean> getPopularPhotos() {
		return popularPhotos;
	}

}
