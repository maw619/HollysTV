package com.wolff.com.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TV {

	private int id;
	
	private String channel;
	
	private String site;
	
	private String url;
	
	private String video;
	
	private String genre;
	
	private String image;
	
	public TV(){
		
	}
	
	

	public TV(int id, String channel, String site, String url, String video, String genre, String image) {
		this.id = id;
		this.channel = channel;
		this.site = site;
		this.url = url;
		this.video = video;
		this.genre = genre;
		this.image = image;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getVideo() {
		return video;
	}



	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "TV [id=" + id + ", channel=" + channel + ", site=" + site + ", url=" + url + ", video=" + video
				+ ", genre=" + genre + ", image=" + image + "]";
	}


	
}
