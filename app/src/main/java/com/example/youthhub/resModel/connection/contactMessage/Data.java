package com.example.youthhub.resModel.connection.contactMessage;

import java.util.List;

public class Data{
	private String thumbnailPath;
	private String vidImgPath;
	private String mediumPath;
	private List<ChatListItem> chatList;
	private String sourcePath;

	public void setThumbnailPath(String thumbnailPath){
		this.thumbnailPath = thumbnailPath;
	}

	public String getThumbnailPath(){
		return thumbnailPath;
	}

	public void setVidImgPath(String vidImgPath){
		this.vidImgPath = vidImgPath;
	}

	public String getVidImgPath(){
		return vidImgPath;
	}

	public void setMediumPath(String mediumPath){
		this.mediumPath = mediumPath;
	}

	public String getMediumPath(){
		return mediumPath;
	}

	public void setChatList(List<ChatListItem> chatList){
		this.chatList = chatList;
	}

	public List<ChatListItem> getChatList(){
		return chatList;
	}

	public void setSourcePath(String sourcePath){
		this.sourcePath = sourcePath;
	}

	public String getSourcePath(){
		return sourcePath;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"thumbnail_path = '" + thumbnailPath + '\'' + 
			",vid_img_path = '" + vidImgPath + '\'' + 
			",medium_path = '" + mediumPath + '\'' + 
			",chat_list = '" + chatList + '\'' + 
			",source_path = '" + sourcePath + '\'' + 
			"}";
		}
}