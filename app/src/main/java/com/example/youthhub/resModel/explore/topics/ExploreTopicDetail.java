
package com.example.youthhub.resModel.explore.topics;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreTopicDetail implements Parcelable
{

    @SerializedName("xm_explore_id")
    @Expose
    private String xmExploreId;
    @SerializedName("xm_code")
    @Expose
    private String xmCode;
    @SerializedName("xm_title")
    @Expose
    private String xmTitle;
    @SerializedName("xm_subject")
    @Expose
    private String xmSubject;
    @SerializedName("xm_tag")
    @Expose
    private String xmTag;
    @SerializedName("xm_description")
    @Expose
    private String xmDescription;
    @SerializedName("xm_logo")
    @Expose
    private String xmLogo;
    @SerializedName("xm_type")
    @Expose
    private String xmType;
    @SerializedName("xm_shared_type")
    @Expose
    private String xmSharedType;
    @SerializedName("xm_price")
    @Expose
    private String xmPrice;
    @SerializedName("xm_discount_type")
    @Expose
    private String xmDiscountType;
    @SerializedName("xm_discount_value")
    @Expose
    private String xmDiscountValue;
    @SerializedName("xm_discount_code")
    @Expose
    private String xmDiscountCode;
    @SerializedName("xm_total_view")
    @Expose
    private String xmTotalView;
    @SerializedName("xm_total_click")
    @Expose
    private String xmTotalClick;
    @SerializedName("xm_avg_rating")
    @Expose
    private String xmAvgRating;
    @SerializedName("xm_shu_url_id")
    @Expose
    private String xmShuUrlId;
    @SerializedName("xm_post_by")
    @Expose
    private String xmPostBy;
    @SerializedName("xm_post_date")
    @Expose
    private String xmPostDate;
    @SerializedName("xm_last_updated_on")
    @Expose
    private String xmLastUpdatedOn;
    @SerializedName("xm_created_on")
    @Expose
    private String xmCreatedOn;
    @SerializedName("xm_created_by")
    @Expose
    private String xmCreatedBy;
    @SerializedName("xm_updated_on")
    @Expose
    private String xmUpdatedOn;
    @SerializedName("xm_updated_by")
    @Expose
    private String xmUpdatedBy;
    @SerializedName("xm_active")
    @Expose
    private String xmActive;
    @SerializedName("xm_old_id")
    @Expose
    private String xmOldId;
    @SerializedName("xc_content")
    @Expose
    private String xcContent;
    @SerializedName("xc_content_poster")
    @Expose
    private String xcContentPoster;
    @SerializedName("xc_type")
    @Expose
    private String xcType;
    @SerializedName("xt_title")
    @Expose
    private String xtTitle;
    @SerializedName("xu_save")
    @Expose
    private Integer xuSave;
    @SerializedName("xu_um_user_id")
    @Expose
    private String xuUmUserId;
    @SerializedName("xu_shared_by")
    @Expose
    private String xuSharedBy;
    @SerializedName("um_name")
    @Expose
    private String umName;
    @SerializedName("um_code")
    @Expose
    private String umCode;
    @SerializedName("um_ut_type_id")
    @Expose
    private String umUtTypeId;
    @SerializedName("um_profile_picture")
    @Expose
    private String umProfilePicture;
    @SerializedName("xt_topic_id")
    @Expose
    private String xtTopicId;
    @SerializedName("xm_tag_name")
    @Expose
    private String xmTagName;
    @SerializedName("coverpath")
    @Expose
    private String coverpath;
    @SerializedName("coverfile")
    @Expose
    private String coverfile;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("xm_avg_rating_name")
    @Expose
    private String xmAvgRatingName;
    public final static Creator<ExploreTopicDetail> CREATOR = new Creator<ExploreTopicDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreTopicDetail createFromParcel(Parcel in) {
            return new ExploreTopicDetail(in);
        }

        public ExploreTopicDetail[] newArray(int size) {
            return (new ExploreTopicDetail[size]);
        }

    }
    ;

    protected ExploreTopicDetail(Parcel in) {
        this.xmExploreId = ((String) in.readValue((String.class.getClassLoader())));
        this.xmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.xmTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.xmSubject = ((String) in.readValue((String.class.getClassLoader())));
        this.xmTag = ((String) in.readValue((String.class.getClassLoader())));
        this.xmDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.xmLogo = ((String) in.readValue((String.class.getClassLoader())));
        this.xmType = ((String) in.readValue((String.class.getClassLoader())));
        this.xmSharedType = ((String) in.readValue((String.class.getClassLoader())));
        this.xmPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.xmDiscountType = ((String) in.readValue((String.class.getClassLoader())));
        this.xmDiscountValue = ((String) in.readValue((String.class.getClassLoader())));
        this.xmDiscountCode = ((String) in.readValue((String.class.getClassLoader())));
        this.xmTotalView = ((String) in.readValue((String.class.getClassLoader())));
        this.xmTotalClick = ((String) in.readValue((String.class.getClassLoader())));
        this.xmAvgRating = ((String) in.readValue((String.class.getClassLoader())));
        this.xmShuUrlId = ((String) in.readValue((String.class.getClassLoader())));
        this.xmPostBy = ((String) in.readValue((String.class.getClassLoader())));
        this.xmPostDate = ((String) in.readValue((String.class.getClassLoader())));
        this.xmLastUpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xmCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xmCreatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.xmUpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xmUpdatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.xmActive = ((String) in.readValue((String.class.getClassLoader())));
        this.xmOldId = ((String) in.readValue((String.class.getClassLoader())));
        this.xcContent = ((String) in.readValue((String.class.getClassLoader())));
        this.xcContentPoster = ((String) in.readValue((String.class.getClassLoader())));
        this.xcType = ((String) in.readValue((String.class.getClassLoader())));
        this.xtTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.xuSave = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.xuUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.xuSharedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
        this.umCode = ((String) in.readValue((String.class.getClassLoader())));
        this.umUtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.umProfilePicture = ((String) in.readValue((String.class.getClassLoader())));
        this.xtTopicId = ((String) in.readValue((String.class.getClassLoader())));
        this.xmTagName = ((String) in.readValue((String.class.getClassLoader())));
        this.coverpath = ((String) in.readValue((String.class.getClassLoader())));
        this.coverfile = ((String) in.readValue((String.class.getClassLoader())));
        this.videoId = ((String) in.readValue((String.class.getClassLoader())));
        this.xmAvgRatingName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreTopicDetail() {
    }

    public String getXmExploreId() {
        return xmExploreId;
    }

    public void setXmExploreId(String xmExploreId) {
        this.xmExploreId = xmExploreId;
    }

    public String getXmCode() {
        return xmCode;
    }

    public void setXmCode(String xmCode) {
        this.xmCode = xmCode;
    }

    public String getXmTitle() {
        return xmTitle;
    }

    public void setXmTitle(String xmTitle) {
        this.xmTitle = xmTitle;
    }

    public String getXmSubject() {
        return xmSubject;
    }

    public void setXmSubject(String xmSubject) {
        this.xmSubject = xmSubject;
    }

    public String getXmTag() {
        return xmTag;
    }

    public void setXmTag(String xmTag) {
        this.xmTag = xmTag;
    }

    public String getXmDescription() {
        return xmDescription;
    }

    public void setXmDescription(String xmDescription) {
        this.xmDescription = xmDescription;
    }

    public String getXmLogo() {
        return xmLogo;
    }

    public void setXmLogo(String xmLogo) {
        this.xmLogo = xmLogo;
    }

    public String getXmType() {
        return xmType;
    }

    public void setXmType(String xmType) {
        this.xmType = xmType;
    }

    public String getXmSharedType() {
        return xmSharedType;
    }

    public void setXmSharedType(String xmSharedType) {
        this.xmSharedType = xmSharedType;
    }

    public String getXmPrice() {
        return xmPrice;
    }

    public void setXmPrice(String xmPrice) {
        this.xmPrice = xmPrice;
    }

    public String getXmDiscountType() {
        return xmDiscountType;
    }

    public void setXmDiscountType(String xmDiscountType) {
        this.xmDiscountType = xmDiscountType;
    }

    public String getXmDiscountValue() {
        return xmDiscountValue;
    }

    public void setXmDiscountValue(String xmDiscountValue) {
        this.xmDiscountValue = xmDiscountValue;
    }

    public String getXmDiscountCode() {
        return xmDiscountCode;
    }

    public void setXmDiscountCode(String xmDiscountCode) {
        this.xmDiscountCode = xmDiscountCode;
    }

    public String getXmTotalView() {
        return xmTotalView;
    }

    public void setXmTotalView(String xmTotalView) {
        this.xmTotalView = xmTotalView;
    }

    public String getXmTotalClick() {
        return xmTotalClick;
    }

    public void setXmTotalClick(String xmTotalClick) {
        this.xmTotalClick = xmTotalClick;
    }

    public String getXmAvgRating() {
        return xmAvgRating;
    }

    public void setXmAvgRating(String xmAvgRating) {
        this.xmAvgRating = xmAvgRating;
    }

    public String getXmShuUrlId() {
        return xmShuUrlId;
    }

    public void setXmShuUrlId(String xmShuUrlId) {
        this.xmShuUrlId = xmShuUrlId;
    }

    public String getXmPostBy() {
        return xmPostBy;
    }

    public void setXmPostBy(String xmPostBy) {
        this.xmPostBy = xmPostBy;
    }

    public String getXmPostDate() {
        return xmPostDate;
    }

    public void setXmPostDate(String xmPostDate) {
        this.xmPostDate = xmPostDate;
    }

    public String getXmLastUpdatedOn() {
        return xmLastUpdatedOn;
    }

    public void setXmLastUpdatedOn(String xmLastUpdatedOn) {
        this.xmLastUpdatedOn = xmLastUpdatedOn;
    }

    public String getXmCreatedOn() {
        return xmCreatedOn;
    }

    public void setXmCreatedOn(String xmCreatedOn) {
        this.xmCreatedOn = xmCreatedOn;
    }

    public String getXmCreatedBy() {
        return xmCreatedBy;
    }

    public void setXmCreatedBy(String xmCreatedBy) {
        this.xmCreatedBy = xmCreatedBy;
    }

    public String getXmUpdatedOn() {
        return xmUpdatedOn;
    }

    public void setXmUpdatedOn(String xmUpdatedOn) {
        this.xmUpdatedOn = xmUpdatedOn;
    }

    public String getXmUpdatedBy() {
        return xmUpdatedBy;
    }

    public void setXmUpdatedBy(String xmUpdatedBy) {
        this.xmUpdatedBy = xmUpdatedBy;
    }

    public String getXmActive() {
        return xmActive;
    }

    public void setXmActive(String xmActive) {
        this.xmActive = xmActive;
    }

    public String getXmOldId() {
        return xmOldId;
    }

    public void setXmOldId(String xmOldId) {
        this.xmOldId = xmOldId;
    }

    public String getXcContent() {
        return xcContent;
    }

    public void setXcContent(String xcContent) {
        this.xcContent = xcContent;
    }

    public String getXcContentPoster() {
        return xcContentPoster;
    }

    public void setXcContentPoster(String xcContentPoster) {
        this.xcContentPoster = xcContentPoster;
    }

    public String getXcType() {
        return xcType;
    }

    public void setXcType(String xcType) {
        this.xcType = xcType;
    }

    public String getXtTitle() {
        return xtTitle;
    }

    public void setXtTitle(String xtTitle) {
        this.xtTitle = xtTitle;
    }

    public Integer getXuSave() {
        return xuSave;
    }

    public void setXuSave(Integer xuSave) {
        this.xuSave = xuSave;
    }

    public String getXuUmUserId() {
        return xuUmUserId;
    }

    public void setXuUmUserId(String xuUmUserId) {
        this.xuUmUserId = xuUmUserId;
    }

    public String getXuSharedBy() {
        return xuSharedBy;
    }

    public void setXuSharedBy(String xuSharedBy) {
        this.xuSharedBy = xuSharedBy;
    }

    public String getUmName() {
        return umName;
    }

    public void setUmName(String umName) {
        this.umName = umName;
    }

    public String getUmCode() {
        return umCode;
    }

    public void setUmCode(String umCode) {
        this.umCode = umCode;
    }

    public String getUmUtTypeId() {
        return umUtTypeId;
    }

    public void setUmUtTypeId(String umUtTypeId) {
        this.umUtTypeId = umUtTypeId;
    }

    public String getUmProfilePicture() {
        return umProfilePicture;
    }

    public void setUmProfilePicture(String umProfilePicture) {
        this.umProfilePicture = umProfilePicture;
    }

    public String getXtTopicId() {
        return xtTopicId;
    }

    public void setXtTopicId(String xtTopicId) {
        this.xtTopicId = xtTopicId;
    }

    public String getXmTagName() {
        return xmTagName;
    }

    public void setXmTagName(String xmTagName) {
        this.xmTagName = xmTagName;
    }

    public String getCoverpath() {
        return coverpath;
    }

    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath;
    }

    public String getCoverfile() {
        return coverfile;
    }

    public void setCoverfile(String coverfile) {
        this.coverfile = coverfile;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getXmAvgRatingName() {
        return xmAvgRatingName;
    }

    public void setXmAvgRatingName(String xmAvgRatingName) {
        this.xmAvgRatingName = xmAvgRatingName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xmExploreId);
        dest.writeValue(xmCode);
        dest.writeValue(xmTitle);
        dest.writeValue(xmSubject);
        dest.writeValue(xmTag);
        dest.writeValue(xmDescription);
        dest.writeValue(xmLogo);
        dest.writeValue(xmType);
        dest.writeValue(xmSharedType);
        dest.writeValue(xmPrice);
        dest.writeValue(xmDiscountType);
        dest.writeValue(xmDiscountValue);
        dest.writeValue(xmDiscountCode);
        dest.writeValue(xmTotalView);
        dest.writeValue(xmTotalClick);
        dest.writeValue(xmAvgRating);
        dest.writeValue(xmShuUrlId);
        dest.writeValue(xmPostBy);
        dest.writeValue(xmPostDate);
        dest.writeValue(xmLastUpdatedOn);
        dest.writeValue(xmCreatedOn);
        dest.writeValue(xmCreatedBy);
        dest.writeValue(xmUpdatedOn);
        dest.writeValue(xmUpdatedBy);
        dest.writeValue(xmActive);
        dest.writeValue(xmOldId);
        dest.writeValue(xcContent);
        dest.writeValue(xcContentPoster);
        dest.writeValue(xcType);
        dest.writeValue(xtTitle);
        dest.writeValue(xuSave);
        dest.writeValue(xuUmUserId);
        dest.writeValue(xuSharedBy);
        dest.writeValue(umName);
        dest.writeValue(umCode);
        dest.writeValue(umUtTypeId);
        dest.writeValue(umProfilePicture);
        dest.writeValue(xtTopicId);
        dest.writeValue(xmTagName);
        dest.writeValue(coverpath);
        dest.writeValue(coverfile);
        dest.writeValue(videoId);
        dest.writeValue(xmAvgRatingName);
    }

    public int describeContents() {
        return  0;
    }

}
