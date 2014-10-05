package com.mh.wechat.entity.message.resp;

public class Music {

	/**
	 * The title of the music
	 */
	private String Title;
	/**
	 * The description of the message
	 */
	private String Description;
	/**
	 * The URL of the music
	 */
	private String MusicUrl;
	/**
	 * The high quality, WIFI environment will first use this URL
	 */
	private String HQMusicUrl;
	/**
	 * The summary image of the music, will get this id after upload the music
	 */
	private String ThumbMediaId;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
