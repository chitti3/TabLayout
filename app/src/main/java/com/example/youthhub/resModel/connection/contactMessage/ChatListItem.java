package com.example.youthhub.resModel.connection.contactMessage;

public class ChatListItem{
	private String fileUrl;
	private String chatTime;
	private String cmesMessage;
	private String cmesMessageId;
	private String umProfilePicture;
	private String cmesUmUserId;
	private String cmesFileName;
	private String cmesMediaCode;
	private String cmesCreatedOn;
	private String umName;
	private String umCode;
	private String usernameCode;
	private int isUnread;
	private String cmesCmChatId;
	private String cmesType;
	private String vidUrl;
	private String chatDate;

	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl;
	}

	public String getFileUrl(){
		return fileUrl;
	}

	public void setChatTime(String chatTime){
		this.chatTime = chatTime;
	}

	public String getChatTime(){
		return chatTime;
	}

	public void setCmesMessage(String cmesMessage){
		this.cmesMessage = cmesMessage;
	}

	public String getCmesMessage(){
		return cmesMessage;
	}

	public void setCmesMessageId(String cmesMessageId){
		this.cmesMessageId = cmesMessageId;
	}

	public String getCmesMessageId(){
		return cmesMessageId;
	}

	public void setUmProfilePicture(String umProfilePicture){
		this.umProfilePicture = umProfilePicture;
	}

	public String getUmProfilePicture(){
		return umProfilePicture;
	}

	public void setCmesUmUserId(String cmesUmUserId){
		this.cmesUmUserId = cmesUmUserId;
	}

	public String getCmesUmUserId(){
		return cmesUmUserId;
	}

	public void setCmesFileName(String cmesFileName){
		this.cmesFileName = cmesFileName;
	}

	public String getCmesFileName(){
		return cmesFileName;
	}

	public void setCmesMediaCode(String cmesMediaCode){
		this.cmesMediaCode = cmesMediaCode;
	}

	public String getCmesMediaCode(){
		return cmesMediaCode;
	}

	public void setCmesCreatedOn(String cmesCreatedOn){
		this.cmesCreatedOn = cmesCreatedOn;
	}

	public String getCmesCreatedOn(){
		return cmesCreatedOn;
	}

	public void setUmName(String umName){
		this.umName = umName;
	}

	public String getUmName(){
		return umName;
	}

	public void setUmCode(String umCode){
		this.umCode = umCode;
	}

	public String getUmCode(){
		return umCode;
	}

	public void setUsernameCode(String usernameCode){
		this.usernameCode = usernameCode;
	}

	public String getUsernameCode(){
		return usernameCode;
	}

	public void setIsUnread(int isUnread){
		this.isUnread = isUnread;
	}

	public int getIsUnread(){
		return isUnread;
	}

	public void setCmesCmChatId(String cmesCmChatId){
		this.cmesCmChatId = cmesCmChatId;
	}

	public String getCmesCmChatId(){
		return cmesCmChatId;
	}

	public void setCmesType(String cmesType){
		this.cmesType = cmesType;
	}

	public String getCmesType(){
		return cmesType;
	}

	public void setVidUrl(String vidUrl){
		this.vidUrl = vidUrl;
	}

	public String getVidUrl(){
		return vidUrl;
	}

	public void setChatDate(String chatDate){
		this.chatDate = chatDate;
	}

	public String getChatDate(){
		return chatDate;
	}

	@Override
 	public String toString(){
		return 
			"ChatListItem{" + 
			"file_url = '" + fileUrl + '\'' + 
			",chat_time = '" + chatTime + '\'' + 
			",cmes_message = '" + cmesMessage + '\'' + 
			",cmes_message_id = '" + cmesMessageId + '\'' + 
			",um_profile_picture = '" + umProfilePicture + '\'' + 
			",cmes_um_user_id = '" + cmesUmUserId + '\'' + 
			",cmes_file_name = '" + cmesFileName + '\'' + 
			",cmes_media_code = '" + cmesMediaCode + '\'' + 
			",cmes_created_on = '" + cmesCreatedOn + '\'' + 
			",um_name = '" + umName + '\'' + 
			",um_code = '" + umCode + '\'' + 
			",username_code = '" + usernameCode + '\'' + 
			",is_unread = '" + isUnread + '\'' + 
			",cmes_cm_chat_id = '" + cmesCmChatId + '\'' + 
			",cmes_type = '" + cmesType + '\'' + 
			",vid_url = '" + vidUrl + '\'' + 
			",chat_date = '" + chatDate + '\'' + 
			"}";
		}
}
