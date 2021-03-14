package com.example.youthhub.retrofit;

import com.example.youthhub.dashBoard.messagesFragment.MessageChatHistoryResponse;
import com.example.youthhub.dashBoard.messagesFragment.MessageListResponse;
import com.example.youthhub.dashBoard.messagesFragment.MessageSendResponse;
import com.example.youthhub.profile.MilestoneDelete;
import com.example.youthhub.profile.profileupdate.ProfileUpdateResponse;
import com.example.youthhub.resModel.CommonNewResponse;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.CommonResponse;
import com.example.youthhub.resModel.connection.Connection;
import com.example.youthhub.resModel.connection.conListMaster.BizSubServiceRes;
import com.example.youthhub.resModel.connection.conListMaster.ConnCityRes;
import com.example.youthhub.resModel.connection.conListMaster.ConnectionListMaster;
import com.example.youthhub.resModel.connection.contactMessage.ContactMessageResponse;
import com.example.youthhub.resModel.connection.followunfollow.FollowUnfollowResponse;
import com.example.youthhub.resModel.connection.shared.SharedProfileResponse;
import com.example.youthhub.resModel.event.EventListResponse;
import com.example.youthhub.resModel.event.discussion.DiscussionAdd;
import com.example.youthhub.resModel.event.discussion.DiscussionListResponse;
import com.example.youthhub.resModel.event.eventView.EventViewResponse;
import com.example.youthhub.resModel.event.eventView.ParticipantListResponse;
import com.example.youthhub.resModel.event.gallery.GalleryResponse;
import com.example.youthhub.resModel.explore.ExploreListResponse;
import com.example.youthhub.resModel.explore.ExploreViewRes;
import com.example.youthhub.resModel.post.likepost.LikeResponse;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.CityListItem;
import com.example.youthhub.resModel.profile.ProfileInfoResponse;
import com.example.youthhub.resModel.explore.exploreDiscussion.ExploreDiscussionAdd;
import com.example.youthhub.resModel.explore.exploreDiscussion.ExploreDiscussionList;
import com.example.youthhub.resModel.explore.masterApi.ExploreListMasterResponse;
import com.example.youthhub.resModel.explore.topics.ExploreTopicsView;
import com.example.youthhub.resModel.jobs.JobView;
import com.example.youthhub.resModel.jobs.Jobs;
import com.example.youthhub.resModel.jobs.applyJob.ApplyCoverLetter;
import com.example.youthhub.resModel.jobs.applyJob.GetFileUpload;
import com.example.youthhub.resModel.jobs.applyJob.JobApplyMaster;
import com.example.youthhub.resModel.jobs.applyJob.ResumeMaster;
import com.example.youthhub.resModel.jobs.listmaster.JobListMaster;
import com.example.youthhub.resModel.login.LoginResponse;
import com.example.youthhub.resModel.login.ForgotPwdRes;
import com.example.youthhub.resModel.message.ProfileFileUploadResponse;
import com.example.youthhub.resModel.myjobs.MyJobsList;
import com.example.youthhub.resModel.post.CommentListResponse;
import com.example.youthhub.resModel.post.PostLikeResponse;
import com.example.youthhub.resModel.post.createPost.PostAddMaster;
import com.example.youthhub.resModel.post.createPost.PostGalleryUpload;
import com.example.youthhub.resModel.post.postList.PostListResponse;
import com.example.youthhub.resModel.profile.ProfileMasterResponse;
import com.example.youthhub.resModel.profile.ProfilePicUpload;
import com.example.youthhub.resModel.profile.attachcv.ProfileAttachCVMasterResponse;
import com.example.youthhub.resModel.profile.attachcv.add.ProfileAttachAddResponse;
import com.example.youthhub.resModel.profile.attachcv.upload.ProfileResumeUploadResponse;
import com.example.youthhub.resModel.profile.follower.ProfileFollowerResponse;
import com.example.youthhub.resModel.profile.getInfo.ProfileGetInfoResponse;
import com.example.youthhub.resModel.profile.interest.ProfileInterestAddResponse;
import com.example.youthhub.resModel.profile.journey.ProfileJourneyListResponse;
import com.example.youthhub.resModel.profile.language.ProfileLanguageAddResponse;
import com.example.youthhub.resModel.profile.milestone.ProfileMilestoneListResponse;
import com.example.youthhub.resModel.profile.profileawards.ProfileAwardsAddResponse;
import com.example.youthhub.resModel.profile.profileeducation.ProfileAddEducationResponse;
import com.example.youthhub.resModel.profile.profileeducation.update.ProfileUpdateEducationResponse;
import com.example.youthhub.resModel.profile.profileeducation.updatesuccess.ProfileUpdatedSuccessResponse;
import com.example.youthhub.resModel.profile.profileexperience.add.ProfileExperienceAddResponse;
import com.example.youthhub.resModel.profile.profileexperience.add.update.ProfileExperienceUpdateResponse;
import com.example.youthhub.resModel.profile.profileexperience.add.updatemaster.ProfileUpdateMasterResponse;
import com.example.youthhub.resModel.profile.profileinfo.CoverPictureUpload;
import com.example.youthhub.resModel.profile.profileinfo.ProfileDeleteResonse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.profilemaster.qualificationprovider.QualificatiionProviderResponse;
import com.example.youthhub.resModel.profile.profilemaster.titlequalification.TitleQualificationResponse;
import com.example.youthhub.resModel.profile.profiletestmonial.TestimonialResponse;
import com.example.youthhub.resModel.profile.profilewishlist.WishlistAddResponse;
import com.example.youthhub.resModel.profile.technicalskill.ProfileTechnicalSkillAddResponse;
import com.example.youthhub.resModel.profile.visualjourney.Delete.Journey_delete_model;
import com.example.youthhub.resModel.profile.visualjourney.Journey_Edit.Journey_after_edit_response;
import com.example.youthhub.resModel.profile.visualjourney.Journey_Edit.Journey_edit_response;
import com.example.youthhub.resModel.profile.visualjourney.Journey_Edit.MilestoneUpdate;
import com.example.youthhub.resModel.profile.visualjourney.ProfileVisualJourneyAddMasterResponse;
import com.example.youthhub.resModel.profile.visualjourney.add.AddJourneyResponse;
import com.example.youthhub.resModel.profile.visualjourney.add.MilestoneUpdateMaster;
import com.example.youthhub.resModel.profile.visualjourney.journeymilestonelist.JourneyMilestoneListResponse;
import com.example.youthhub.resModel.profile.visualjourney.journeyprofileupload.JourneyProfileUploadResponse;
import com.example.youthhub.resModel.profile.visualjourney.milestoneadd.MilestoneResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.ProfileAddVolunteerResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.update.ProfileUpdateVolunteerResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.updatemaster.ProfileVolunteerUpdateMasterResponse;
import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;
import com.example.youthhub.resModel.register.CityResponse;
import com.example.youthhub.resModel.register.RegisterResponse;
import com.example.youthhub.resModel.register.SignUpMasterResponse;
import com.example.youthhub.resModel.register.SignUpResponse;
import com.example.youthhub.resModel.supportRes.listmaster.SupportListMaster;
import com.example.youthhub.resModel.supportRes.SupportURL;
import com.example.youthhub.resModel.supportRes.raiseticket.SupportRaiseTicket;
import com.example.youthhub.resModel.supportRes.view.SupportListView;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    //Login
    //1
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> getLogin(@Header("YH-API-KEY") String apiKey,
                                 @Header("Device-Key") String devicekey,
                                 @Header("Device-Type") String devicetype,
                                 @Field("username") String username,
                                 @Field("password") String password,
                                 @Field("type") String type);

    //Forgot Pwd
    //2
    @FormUrlEncoded
    @POST("forgot-password-request")
    Call<LoginResponse> getForGotPassword(@Header("YH-API-KEY") String apiKey,
                                          @Field("email") String email);

    //3
    @FormUrlEncoded
    @POST("forgot-passcode-verify")
    Call<LoginResponse> getForGotPasswordVerify(@Header("YH-API-KEY") String apiKey,
                                                @Field("email") String email,
                                                @Field("passcode") String passcode);

    //4
    @FormUrlEncoded
    @POST("forgot-password")
    Call<ForgotPwdRes> getChangeForGotPasswordVerify(@Header("YH-API-KEY") String apiKey,
                                                     @Field("email") String email,
                                                     @Field("passcode") String passcode,
                                                     @Field("password") String password,
                                                     @Field("repassword") String repassword);

    //Register
    //5
    @GET("user-register-request-master")
    Call<SignUpMasterResponse> getSignUpMasterData(@Header("YH-API-KEY") String apiKey);

    //6
    @FormUrlEncoded
    @POST("user-register-request")
    Call<RegisterResponse> getUserRegisterRequest(@Header("YH-API-KEY") String apiKey,
                                                  @Field("email") String email,
                                                  @Field("user_type") String user_type,
                                                  @Field("dob") String dob,
                                                  @Field("accept_terms") String accept_terms);

    //7
    @FormUrlEncoded
    @POST("user-register-code-verify")
    Call<RegisterResponse> getUserRegisterCodeVerify(@Header("YH-API-KEY") String apiKey,
                                                     @Field("email") String email,
                                                     @Field("passcode") String passcode);

    //8
    @FormUrlEncoded
    @POST("city")
    Call<CityResponse> getGetCity(@Header("YH-API-KEY") String apiKey,
                                  @Field("region_id") String region_id);

    //9
    @FormUrlEncoded
    @POST("user-register")
    Call<SignUpResponse> getSignUp(@Header("YH-API-KEY") String apiKey,
                                   @Header("Device-Key") String devicekey,
                                   @Header("Device-Type") String devicetype,
                                   @Field("email") String email,
                                   @Field("passcode") String passcode,
                                   @Field("user_type") String user_type,
                                   @Field("firstname") String firstname,
                                   @Field("lastname") String lastname,
                                   @Field("gender") String gender,
                                   @Field("region") String region,
                                   @Field("district") String district,
                                   @Field("password") String password,
                                   @Field("password_confirm") String password_confirm,
                                   @Field("work_situation") String work_situation,
                                   @Field("work_experience") String work_experience,
                                   @Field("intended_destination") String intended_destination,
                                   @Field("prefered_regional") String prefered_regional,
                                   @Field("prefered_district") String prefered_district,
                                   @Field("licence_type") String licence_type,
                                   @Field("job_wishlist") String job_wishlist,
                                   @Field("current_qualification_type") String current_qualification_type,
                                   @Field("iwi") String iwi,
                                   @Field("ethnicity") String ethnicity,
                                   @Field("hours_required") String hours_required,
                                   @Field("type") String type);

    //Event
    //10
    @FormUrlEncoded
    @POST("event/list")
    Call<EventListResponse> getEventList(@Header("YH-API-KEY") String apiKey,
                                         @Header("YH-ACCESS-KEY") String access_key,
                                         @Header("Authorizations") String authorizations,
                                         @Field("ismyevent") String ismyevent,
                                         @Field("page_no") String page_no,
                                         @Field("region_ids") String region_ids,
                                         @Field("search_name") String search_name,
                                         @Field("city_ids") String city_ids,
                                         @Field("user_code") String user_code,
                                         @Field("post_by") String post_by);

    //11
    @FormUrlEncoded
    @POST("event/apply")
    Call<EventListResponse> getCountMeApplyStatus(@Header("YH-API-KEY") String apiKey,
                                                  @Header("YH-ACCESS-KEY") String access_key,
                                                  @Header("Authorizations") String authorizations,
                                                  @Field("event_code") String event_code,
                                                  @Field("is_count_me") String is_count_me);

    //above and below api call are same but needed different response

    //12
    @FormUrlEncoded
    @POST("event/apply")
    Call<EventViewResponse> getCountMeApplyStatusinView(@Header("YH-API-KEY") String apiKey,
                                                        @Header("YH-ACCESS-KEY") String access_key,
                                                        @Header("Authorizations") String authorizations,
                                                        @Field("event_code") String event_code,
                                                        @Field("is_count_me") String is_count_me);

    //13
    @FormUrlEncoded
    @POST("event/participants-list")
    Call<ParticipantListResponse> getParticipantList(@Header("YH-API-KEY") String apiKey,
                                                     @Header("YH-ACCESS-KEY") String access_key,
                                                     @Header("Authorizations") String authorizations,
                                                     @Field("event_code") String event_code,
                                                     @Field("page_no") String page_no);

    //14
    @FormUrlEncoded
    @POST("event/view")
    Call<EventViewResponse> getEventView(@Header("YH-API-KEY") String apiKey,
                                         @Header("YH-ACCESS-KEY") String access_key,
                                         @Header("Authorizations") String authorizations,
                                         @Field("event_code") String event_code);

    //15
    @FormUrlEncoded
    @POST("event/gallery")
    Call<GalleryResponse> getGallery(@Header("YH-API-KEY") String apiKey,
                                     @Header("YH-ACCESS-KEY") String access_key,
                                     @Header("Authorizations") String authorizations,
                                     @Field("event_code") String event_code,
                                     @Field("gallery_type") String gallery_type,
                                     @Field("page_no") String page_no);

    //16
    @FormUrlEncoded
    @POST("event/discussion-list")
    Call<DiscussionListResponse> getDiscussionList(@Header("YH-API-KEY") String apiKey,
                                                   @Header("YH-ACCESS-KEY") String access_key,
                                                   @Header("Authorizations") String authorizations,
                                                   @Field("event_code") String event_code,
                                                   @Field("page_no") String page_no);

    //17
    @FormUrlEncoded
    @POST("event/discussion-add")
    Call<DiscussionAdd> getDiscussion(@Header("YH-API-KEY") String apiKey,
                                      @Header("YH-ACCESS-KEY") String access_key,
                                      @Header("Authorizations") String authorizations,
                                      @Field("event_code") String event_code,
                                      @Field("message") String message);

    //18
    @FormUrlEncoded
    @POST("event/discussion-delete")
    Call<DiscussionAdd> getDeleteMsg(@Header("YH-API-KEY") String apiKey,
                                     @Header("YH-ACCESS-KEY") String access_key,
                                     @Header("Authorizations") String authorizations,
                                     @Field("event_code") String event_code,
                                     @Field("feed_id") String feed_id);

    //Explore
    //19
    @GET("explore/list-master")
    Call<ExploreListMasterResponse> getExploreMaster(@Header("YH-API-KEY") String apiKey,
                                                     @Header("YH-ACCESS-KEY") String access_key,
                                                     @Header("Authorizations") String authorizations);

    //20
    @FormUrlEncoded
    @POST("explore/list")
    Call<ExploreListResponse> getExploreList(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("type") String type,
                                             @Field("search_name") String search_name,
                                             @Field("page_no") String page_no,
                                             @Field("rating") String rating,
                                             @Field("content_type") String content_type,
                                             @Field("user_code") String user_code,
                                             @Field("tags") String tags,
                                             @Field("post_by") String post_by);

    //21
    @FormUrlEncoded
    @POST("explore/topic-list")
    Call<ExploreViewRes> getExploreView(@Header("YH-API-KEY") String apiKey,
                                        @Header("YH-ACCESS-KEY") String access_key,
                                        @Header("Authorizations") String authorizations,
                                        @Field("explore_code") String explore_code,
                                        @Field("page_no") String page_no);

    //22
    @FormUrlEncoded
    @POST("explore/add-my-explore")
    Call<CommonRes> getAddMyExplore(@Header("YH-API-KEY") String apiKey,
                                    @Header("YH-ACCESS-KEY") String access_key,
                                    @Header("Authorizations") String authorizations,
                                    @Field("explore_code") String explore_code,
                                    @Field("xm_shared_type") String xm_shared_type,
                                    @Field("xm_post_by") String xm_post_by,
                                    @Field("is_add_explore") String is_add_explore);

    //23
    @FormUrlEncoded
    @POST("explore/topic-view")
    Call<ExploreTopicsView> getExploreTopics(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("explore_code") String explore_code,
                                             @Field("topic_id") String topic_id);

    //24
    @FormUrlEncoded
    @POST("explore/discussion-list")
    Call<ExploreDiscussionList> getExploreDiscussionList(@Header("YH-API-KEY") String apiKey,
                                                         @Header("YH-ACCESS-KEY") String access_key,
                                                         @Header("Authorizations") String authorizations,
                                                         @Field("explore_code") String explore_code,
                                                         @Field("topic_id") String topic_id,
                                                         @Field("page_no") String page_no);

    //25
    @FormUrlEncoded
    @POST("explore/discussion-add")
    Call<ExploreDiscussionAdd> getExploreDiscussionAdd(@Header("YH-API-KEY") String apiKey,
                                                       @Header("YH-ACCESS-KEY") String access_key,
                                                       @Header("Authorizations") String authorizations,
                                                       @Field("explore_code") String explore_code,
                                                       @Field("topic_id") String topic_id,
                                                       @Field("message") String message);

    //26
    @FormUrlEncoded
    @POST("explore/discussion-delete")
    Call<ExploreDiscussionAdd> getExploreDiscussionDelete(@Header("YH-API-KEY") String apiKey,
                                                          @Header("YH-ACCESS-KEY") String access_key,
                                                          @Header("Authorizations") String authorizations,
                                                          @Field("explore_code") String explore_code,
                                                          @Field("topic_id") String topic_id,
                                                          @Field("feed_id") String feed_id);


    //Connections
    //27
    @FormUrlEncoded
    @POST("connection/list")
    Call<Connection> getConnection(@Header("YH-API-KEY") String apiKey,
                                   @Header("YH-ACCESS-KEY") String access_key,
                                   @Header("Authorizations") String authorizations,
                                   @Field("user_type") String user_type,
                                   @Field("serach_name") String serach_name,
                                   @Field("region_ids") String region_ids,
                                   @Field("city_ids") String city_ids,
                                   @Field("skills_ids") String skills_ids,
                                   @Field("wishlist_ids") String wishlist_ids,
                                   @Field("service_ids") String service_ids,
                                   @Field("bizservice_ids") String bizservice_ids,
                                   @Field("subservice_ids") String subservice_ids,
                                   @Field("tags_ids") String tags_ids,
                                   @Field("page_no") String page_no);

    //28
    @FormUrlEncoded
    @POST("connection/add-follow-unfollow")
    Call<FollowUnfollowResponse> getFollowUnFollow(@Header("YH-API-KEY") String apiKey,
                                                   @Header("YH-ACCESS-KEY") String access_key,
                                                   @Header("Authorizations") String authorizations,
                                                   @Field("user_code") String user_code,
                                                   @Field("is_follow") String is_follow);

    //29
    @GET("connection/list-master")
    Call<ConnectionListMaster> getConListMaster(@Header("YH-API-KEY") String apiKey,
                                                @Header("YH-ACCESS-KEY") String access_key,
                                                @Header("Authorizations") String authorizations);

    //30
    @FormUrlEncoded
    @POST("connection/get-city")
    Call<ConnCityRes> getConCity(@Header("YH-API-KEY") String apiKey,
                                 @Header("YH-ACCESS-KEY") String access_key,
                                 @Header("Authorizations") String authorizations,
                                 @Field("region_ids") String region_ids);   //30

    @FormUrlEncoded
    @POST("connection/get-city")
    Call<List<CityListItem>> getprofileCity(@Header("YH-API-KEY") String apiKey,
                                            @Header("YH-ACCESS-KEY") String access_key,
                                            @Header("Authorizations") String authorizations,
                                            @Field("region_ids") String region_ids);

    //31
    @FormUrlEncoded
    @POST("connection/get-biz-subservice")
    Call<BizSubServiceRes> getBizSubService(@Header("YH-API-KEY") String apiKey,
                                            @Header("YH-ACCESS-KEY") String access_key,
                                            @Header("Authorizations") String authorizations,
                                            @Field("biz_service_type") String biz_service_type);

    //Jobs
    //32
    @GET("job/list-master")
    Call<JobListMaster> getListMaster(@Header("YH-API-KEY") String apiKey,
                                      @Header("YH-ACCESS-KEY") String access_key,
                                      @Header("Authorizations") String authorizations);

    //33
    @FormUrlEncoded
    @POST("job/list")
    Call<Jobs> getJobs(@Header("YH-API-KEY") String apiKey,
                       @Header("YH-ACCESS-KEY") String access_key,
                       @Header("Authorizations") String authorizations,
                       @Field("page_no") String page_no,
                       @Field("search_name") String search_name,
                       @Field("region_ids") String region_ids,
                       @Field("city_ids") String city_ids,
                       @Field("category_ids") String category_ids,
                       @Field("subcategory_ids") String subcategory_ids,
                       @Field("job_type_id") String job_type_id,
                       @Field("salary_type") String salary_type,
                       @Field("salary_range_from") String salary_range_from,
                       @Field("salary_range_to") String salary_range_to,
                       @Field("user_code") String user_code
    );

    //34
    @FormUrlEncoded
    @POST("job/view")
    Call<JobView> getJob(@Header("YH-API-KEY") String apiKey,
                         @Header("YH-ACCESS-KEY") String access_key,
                         @Header("Authorizations") String authorizations,
                         @Field("job_code") String job_code);

    //35
    @FormUrlEncoded
    @POST("job/is-save")
    Call<CommonRes> getIsSave(@Header("YH-API-KEY") String apiKey,
                              @Header("YH-ACCESS-KEY") String access_key,
                              @Header("Authorizations") String authorizations,
                              @Field("job_code") String job_code,
                              @Field("is_save") String is_save);

    //36
    @FormUrlEncoded
    @POST("job/sub-category-list")
    Call<JobListMaster> getJobSubCategory(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorizations,
                                          @Field("category_ids") String category_ids);

    //37
    @FormUrlEncoded
    @POST("job/city-list")
    Call<JobListMaster> getJobCity(@Header("YH-API-KEY") String apiKey,
                                   @Header("YH-ACCESS-KEY") String access_key,
                                   @Header("Authorizations") String authorizations,
                                   @Field("region_ids") String category_ids);

    //38
    @FormUrlEncoded
    @POST("job/applied-list")
    Call<MyJobsList> getMyJobs(@Header("YH-API-KEY") String apiKey,
                               @Header("YH-ACCESS-KEY") String access_key,
                               @Header("Authorizations") String authorizations,
                               @Field("type") String type);

    //39
    @FormUrlEncoded
    @POST("job/apply-master")
    Call<JobApplyMaster> getJobApplyMaster(@Header("YH-API-KEY") String apiKey,
                                           @Header("YH-ACCESS-KEY") String access_key,
                                           @Header("Authorizations") String authorizations,
                                           @Field("job_code") String job_code);

    //40
    @FormUrlEncoded
    @POST("job/apply")
    Call<CommonRes> getJobApply(@Header("YH-API-KEY") String apiKey,
                                @Header("YH-ACCESS-KEY") String access_key,
                                @Header("Authorizations") String authorizations,
                                @Field("job_code") String job_code,
                                @Field("jap_notes") String jap_notes,
                                @Field("jap_ucv_cv_id") String jap_ucv_cv_id,
                                @Field("jap_expected_salary_from") String jap_expected_salary_from,
                                @Field("jap_expected_salary_to") String jap_expected_salary_to,
                                @Field("jap_expected_work_hour") String jap_expected_work_hour);

    //support
    //41
    @GET("helpdesk/list-master")
    Call<SupportListMaster> getSupportListMaster(@Header("YH-API-KEY") String apiKey,
                                                 @Header("YH-ACCESS-KEY") String access_key,
                                                 @Header("Authorizations") String authorizations);

    //42
    @FormUrlEncoded
    @POST("helpdesk/list")
    Call<SupportURL> getSupportList(@Header("YH-API-KEY") String apiKey,
                                    @Header("YH-ACCESS-KEY") String access_key,
                                    @Header("Authorizations") String authorizations,
                                    @Field("page_no") String page_no,
                                    @Field("ticket_status") String ticket_status,
                                    @Field("search_name") String search_name);

    //43
    @FormUrlEncoded
    @POST("helpdesk/view")
    Call<SupportListView> getListView(@Header("YH-API-KEY") String apiKey,
                                      @Header("YH-ACCESS-KEY") String access_key,
                                      @Header("Authorizations") String authorizations,
                                      @Field("ticket_code") String ticket_code);

    //44
    @FormUrlEncoded
    @POST("helpdesk/raise-ticket")
    Call<SupportRaiseTicket> getSupportRaiseTicket(@Header("YH-API-KEY") String apiKey,
                                                   @Header("YH-ACCESS-KEY") String access_key,
                                                   @Header("Authorizations") String authorizations,
                                                   @Field("subject") String subject,
                                                   @Field("description") String description,
                                                   @Field("file_name") String file_name);

    //45
    @FormUrlEncoded
    @POST("helpdesk/cancel")
    Call<CommonRes> getCancelRes(@Header("YH-API-KEY") String apiKey,
                                 @Header("YH-ACCESS-KEY") String access_key,
                                 @Header("Authorizations") String authorizations,
                                 @Field("ticket_code") String ticket_code);

    //46
    @Multipart
    @POST("helpdesk/attachedfile-upload")
    Call<GetFileUpload> getFileUploadName(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorizations,
                                          @Part MultipartBody.Part image);

    //47
    @FormUrlEncoded
    @POST("helpdesk/reply")
    Call<SupportListView> getReply(@Header("YH-API-KEY") String apiKey,
                                   @Header("YH-ACCESS-KEY") String access_key,
                                   @Header("Authorizations") String authorizations,
                                   @Field("ticket_code") String ticket_code,
                                   @Field("description") String description,
                                   @Field("file_name") String file_name,
                                   @Field("ticket_status") String ticket_status);


    //common api used in jobs apply
    //48
    @GET("profile/resume-cover-upload-master")
    Call<ResumeMaster> getResumeMaster(@Header("YH-API-KEY") String apiKey,
                                       @Header("YH-ACCESS-KEY") String access_key,
                                       @Header("Authorizations") String authorizations);

    //multipart key "cv_file" given in method call of getFileName
    //49
    @Multipart
    @POST("profile/resume-cover-upload")
    Call<GetFileUpload> getFileName(@Header("YH-API-KEY") String apiKey,
                                    @Header("YH-ACCESS-KEY") String access_key,
                                    @Header("Authorizations") String authorizations,
                                    @Part MultipartBody.Part image);

    //50
    @Multipart
    @POST("profile/add-resume-cover")
    Call<ApplyCoverLetter> getAddResume(@Header("YH-API-KEY") String apiKey,
                                        @Header("YH-ACCESS-KEY") String access_key,
                                        @Header("Authorizations") String authorizations,
                                        @Part MultipartBody.Part image,
                                        @Part("cv_type") RequestBody cv_type,
                                        @Part("cv_title") RequestBody cv_title,
                                        @Part("file_name") RequestBody file_name);

    //post
    //51
    @GET("post-add-master")
    Call<PostAddMaster> getPostAddMaster(@Header("YH-API-KEY") String apiKey,
                                         @Header("YH-ACCESS-KEY") String access_key,
                                         @Header("Authorizations") String authorizations);

    //52
    @Multipart
    @POST("post-gallery-upload")
    Call<PostGalleryUpload> getPostGalleryUpload(@Header("YH-API-KEY") String apiKey,
                                                 @Header("YH-ACCESS-KEY") String access_key,
                                                 @Header("Authorizations") String authorizations,
                                                 @Part MultipartBody.Part image);

    //53
    @FormUrlEncoded
    @POST("post-add")
    Call<PostDashboardListResponse> getAddPost(@Header("YH-API-KEY") String apiKey,
                                      @Header("YH-ACCESS-KEY") String access_key,
                                      @Header("Authorizations") String authorizations,
                                      @Field("post_title") String post_title,
                                      @Field("gallery_code") String gallery_code,
                                      @Field("tags") String tags,
                                      @Field("prime_tags") String prime_tags,
                                      @Field("group_code") String group_code,
                                      @Field("post_type") String post_type,
                                      @Field("journey_ids") String journey_ids);

    //54
    @FormUrlEncoded
    @POST("post-list")
    Call<PostDashboardListResponse> getPostList(@Header("YH-API-KEY") String apiKey,
                                                @Header("YH-ACCESS-KEY") String access_key,
                                                @Header("Authorizations") String authorizations,
                                                @Field("page_no") String page_no,
                                                @Field("user_code") String user_code,
                                                @Field("post_code") String post_code,
                                                @Field("group_code") String group_code);

    //55
    @FormUrlEncoded
    @POST("post-encourage")
    Call<LikeResponse> getPostEncourage(@Header("YH-API-KEY") String apiKey,
                                        @Header("YH-ACCESS-KEY") String access_key,
                                        @Header("Authorizations") String authorizations,
                                        @Field("post_code") String post_code,
                                        @Field("is_encourage") String is_encourage);

    //56
    @FormUrlEncoded
    @POST("post-encouragers-list")
    Call<PostLikeResponse> getPostEncourageList(@Header("YH-API-KEY") String apiKey,
                                                @Header("YH-ACCESS-KEY") String access_key,
                                                @Header("Authorizations") String authorizations,
                                                @Field("post_code") String post_code);

    //57
    @FormUrlEncoded
    @POST("post-favourite")
    Call<CommonRes> getPostFavourite(@Header("YH-API-KEY") String apiKey,
                                     @Header("YH-ACCESS-KEY") String access_key,
                                     @Header("Authorizations") String authorizations,
                                     @Field("post_code") String post_code,
                                     @Field("is_favourite") String is_favourite);

    //58
    @FormUrlEncoded
    @POST("post-comment-list")
    Call<CommentListResponse> getCommentList(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("post_code") String post_code);

    //59
    @FormUrlEncoded
    @POST("post-comment-add")
    Call<CommentListResponse> getCommentAdd(@Header("YH-API-KEY") String apiKey,
                                            @Header("YH-ACCESS-KEY") String access_key,
                                            @Header("Authorizations") String authorizations,
                                            @Field("post_code") String post_code,
                                            @Field("comments") String comments);

    //60
    @FormUrlEncoded
    @POST("post-comment-delete")
    Call<CommonNewResponse> getCommentDelete(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("post_code") String post_code,
                                             @Field("feed_id") String feed_id);


    //61
    @FormUrlEncoded
    @POST("post-update")
    Call<CommonRes> getPostUpdate(@Header("YH-API-KEY") String apiKey,
                                  @Header("YH-ACCESS-KEY") String access_key,
                                  @Header("Authorizations") String authorizations,
                                  @Field("post_code") String post_code,
                                  @Field("description") String description);

    //62
    @FormUrlEncoded
    @POST("post-delete")
    Call<CommonRes> getPostDelete(@Header("YH-API-KEY") String apiKey,
                                  @Header("YH-ACCESS-KEY") String access_key,
                                  @Header("Authorizations") String authorizations,
                                  @Field("post_code") String post_code);

    //63
    @FormUrlEncoded
    @POST("post-report")
    Call<CommonRes> getPostReport(@Header("YH-API-KEY") String apiKey,
                                  @Header("YH-ACCESS-KEY") String access_key,
                                  @Header("Authorizations") String authorizations,
                                  @Field("post_code") String post_code,
                                  @Field("report_message") String report_message);

    //64
    @FormUrlEncoded
    @POST("post-share")
    Call<PostDashboardListResponse> getPostShare(@Header("YH-API-KEY") String apiKey,
                                        @Header("YH-ACCESS-KEY") String access_key,
                                        @Header("Authorizations") String authorizations,
                                        @Field("post_code") String post_code,
                                        @Field("share_type") String share_type,
                                        @Field("share_title") String share_title);

    //Profile
    //65
    @FormUrlEncoded
    @POST("profile/get-info")
    Call<ProfileInfoResponse> getProfileInfo(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("user_code") String user_code);

    //66
    @Multipart
    @POST("profile-picture-upload")
    Call<ProfilePicUpload> getProfilePic(@Header("YH-API-KEY") String apiKey,
                                         @Header("YH-ACCESS-KEY") String access_key,
                                         @Header("Authorizations") String authorizations,
                                         @Part MultipartBody.Part profile_pic);

    //Chat
    //67
    @FormUrlEncoded
    @POST("chat/user-inbox-outbox-list")
    Call<MessageListResponse> getChatList(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorizations,
                                          @Field("page_no") String page_no,
                                          @Field("search_type") String search_type,
                                          @Field("search_name") String search_name);


    //Chat
    //68
    @FormUrlEncoded
    @POST("chat/view-chat-list")
    Call<MessageChatHistoryResponse> getChatListHistory(@Header("YH-API-KEY") String apiKey,
                                                        @Header("YH-ACCESS-KEY") String access_key,
                                                        @Header("Authorizations") String authorizations,
                                                        @Field("page_no") String page_no,
                                                        @Field("to_user_code") String to_user_code,
                                                        @Field("chat_id") String chat_id);

    //Chat
    //69
    @FormUrlEncoded
    @POST("chat/new-chat")
    Call<MessageSendResponse> sendMessage(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorizations,
                                          @Field("media_filename") String media_filename,
                                          @Field("message") String message,
                                          @Field("to_user_code") String to_user_code,
                                          @Field("chat_id") String chat_id);

    //Profile
    //70
    @FormUrlEncoded
    @POST("profile/get-youth-profile-info")
    Call<ProfileInfoResp> getYouthProfileInfo(@Header("YH-API-KEY") String apiKey,
                                              @Header("YH-ACCESS-KEY") String access_key,
                                              @Header("Authorizations") String authorization,
                                              @Field("user_code") String user_code);

    //Chat
    //71
    @Multipart
    @POST("chat/gallery-upload")
    Call<ProfileFileUploadResponse> getUploadChatFile(@Header("YH-API-KEY") String apiKey,
                                                      @Header("YH-ACCESS-KEY") String access_key,
                                                      @Header("Authorizations") String authorizations,
                                                      @Part MultipartBody.Part profile_pic);


    //Profile
    //72
    @FormUrlEncoded
    @POST("profile/update-master")
    Call<ProfileMasterResponse> getProfileInfoMaster(@Header("YH-API-KEY") String apiKey,
                                                     @Header("YH-ACCESS-KEY") String access_key,
                                                     @Header("Authorizations") String authorization,
                                                     @Field("user_code") String user_code);

    //Profile
    //73
    @FormUrlEncoded
    @POST("profile/youth-update")
    Call<ProfileUpdateResponse> updateProfileInfo(@Header("YH-API-KEY") String apiKey,
                                                  @Header("YH-ACCESS-KEY") String access_key,
                                                  @Header("Authorizations") String authorization,
                                                  @Field("fname") String fname,
                                                  @Field("lname") String lname,
                                                  @Field("dob") String dob,
                                                  @Field("gender") String gender,
                                                  @Field("region_name") String region_name,
                                                  @Field("city_name") String city_name,
                                                  @Field("conatact_email") String conatact_email,
                                                  @Field("current_education") String current_education,
                                                  @Field("ethnicity") String ethnicity,
                                                  @Field("iwi") String iwi,
                                                  @Field("mobile") String mobile,
                                                  @Field("work_status") String work_status,
                                                  @Field("work_availability") String work_availability,
                                                  @Field("work_experience") String work_experience,
                                                  @Field("work_per_week") String work_per_week,
                                                  @Field("preferred_region") String preferred_region,
                                                  @Field("preferred_city") String preferred_city,
                                                  @Field("residency_status") String residency_status,
                                                  @Field("visa_type") String visa_type,
                                                  @Field("visa_expire_month") String visa_expire_month,
                                                  @Field("visa_expire_year") String visa_expire_year,
                                                  @Field("instagram") String instagram,
                                                  @Field("facebook") String facebook,
                                                  @Field("twitter") String twitter,
                                                  @Field("google_plus") String google_plus,
                                                  @Field("linkedin") String linkedin,
                                                  @Field("github") String github,
                                                  @Field("behance") String behance,
                                                  @Field("description") String description,
                                                  @Field("intended_destination") String intended_destination,
                                                  @Field("licence_transport") String licence_transport
    );

    //Profile
    //74
    @FormUrlEncoded
    @POST("profile/resume-add-master")
    Call<ProfileAddMasterResponse> getProfileAddMaster(@Header("YH-API-KEY") String apiKey,
                                                       @Header("YH-ACCESS-KEY") String access_key,
                                                       @Header("Authorizations") String authorization,
                                                       @Field("type") String type);

    //Profile
    //75
    @FormUrlEncoded
    @POST("profile/add-wishlist")
    Call<WishlistAddResponse> addWishlist(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorization,
                                          @Field("edu_jobwishlist_tag") String edu_jobwishlist_tag);

    //Profile
    //76
    @GET("profile/testimonial-request-master")
    Call<TestimonialResponse> testmonialMaster(@Header("YH-API-KEY") String apiKey,
                                               @Header("YH-ACCESS-KEY") String access_key,
                                               @Header("Authorizations") String authorization);

    //Profile
    //77
    @FormUrlEncoded
    @POST("profile/testimonial-request")
    Call<BasicResponse> createTestimonials(@Header("YH-API-KEY") String apiKey,
                                           @Header("YH-ACCESS-KEY") String access_key,
                                           @Header("Authorizations") String authorization,
                                           @Field("testimonial_provider") String testimonial_provider,
                                           @Field("email") String email,
                                           @Field("organisation_name") String organisation_name,
                                           @Field("providers_title") String providers_title,
                                           @Field("comments") String comments);

    //Profile
    //78
    @FormUrlEncoded
    @POST("profile/delete-wishlist")
    Call<BasicResponse> deleteWishlist(@Header("YH-API-KEY") String apiKey,
                                       @Header("YH-ACCESS-KEY") String access_key,
                                       @Header("Authorizations") String authorization,
                                       @Field("wishlist_id") String wishlist_id);

    //Profile
    //79
    @FormUrlEncoded
    @POST("profile/delete-testimonial")
    Call<BasicResponse> deleteTestimonial(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorization,
                                          @Field("testimonial_id") String testimonial_id);

    //Profile
    //79
    @FormUrlEncoded
    @POST("profile/delete-experience")
    Call<BasicResponse> deleteExperience(@Header("YH-API-KEY") String apiKey,
                                         @Header("YH-ACCESS-KEY") String access_key,
                                         @Header("Authorizations") String authorization,
                                         @Field("employment_id") String experience_id);

    //Profile
    //80
    @FormUrlEncoded
    @POST("profile/delete-education")
    Call<BasicResponse> deleteEduction(@Header("YH-API-KEY") String apiKey,
                                       @Header("YH-ACCESS-KEY") String access_key,
                                       @Header("Authorizations") String authorization,
                                       @Field("qualification_id") String qualification_id);


    //Profile
    //81
    @FormUrlEncoded
    @POST("profile/delete-volunteering")
    Call<BasicResponse> deleteVolunteering(@Header("YH-API-KEY") String apiKey,
                                           @Header("YH-ACCESS-KEY") String access_key,
                                           @Header("Authorizations") String authorization,
                                           @Field("volunteering_id") String volunteering_id);

    //Profile
    //82
    @FormUrlEncoded
    @POST("profile/delete-achievement")
    Call<BasicResponse> deleteAchievement(@Header("YH-API-KEY") String apiKey,
                                          @Header("YH-ACCESS-KEY") String access_key,
                                          @Header("Authorizations") String authorization,
                                          @Field("achievement_id") String achievement_id);

    //Profile
    //83
    @FormUrlEncoded
    @POST("profile/resume-cover-delete")
    Call<BasicResponse> deleteCV(@Header("YH-API-KEY") String apiKey,
                                 @Header("YH-ACCESS-KEY") String access_key,
                                 @Header("Authorizations") String authorization,
                                 @Field("cv_id") String cv_id);

    //Profile
    //84
    @FormUrlEncoded
    @POST("profile/delete-technical-skills")
    Call<BasicResponse> deleteTechnicalSkills(@Header("YH-API-KEY") String apiKey,
                                              @Header("YH-ACCESS-KEY") String access_key,
                                              @Header("Authorizations") String authorization,
                                              @Field("technical_skills_id") String technical_skills_id);

    //Profile
    //85
    @FormUrlEncoded
    @POST("profile/delete-interest")
    Call<BasicResponse> deleteInterests(@Header("YH-API-KEY") String apiKey,
                                        @Header("YH-ACCESS-KEY") String access_key,
                                        @Header("Authorizations") String authorization,
                                        @Field("interest_id") String interest_id);


    //Profile
    //86
    @FormUrlEncoded
    @POST("profile/delete-languages")
    Call<BasicResponse> deleteLanguages(@Header("YH-API-KEY") String apiKey,
                                        @Header("YH-ACCESS-KEY") String access_key,
                                        @Header("Authorizations") String authorization,
                                        @Field("language_id") String language_id);

    //Profile
    //87
    @FormUrlEncoded
    @POST("profile/get-qualification-provider")
    Call<QualificatiionProviderResponse> getQualficationProvider(@Header("YH-API-KEY") String apiKey,
                                                                 @Header("YH-ACCESS-KEY") String access_key,
                                                                 @Header("Authorizations") String authorization,
                                                                 @Field("org_category_id") String org_category_id);

    //Profile
    //88
    @FormUrlEncoded
    @POST("profile/get-qualification")
    Call<TitleQualificationResponse> getTitleQualfication(@Header("YH-API-KEY") String apiKey,
                                                          @Header("YH-ACCESS-KEY") String access_key,
                                                          @Header("Authorizations") String authorization,
                                                          @Field("qap_provider_id") String qap_provider_id);

    //Profile
    //89
    @FormUrlEncoded
    @POST("profile/add-education")
    Call<ProfileAddEducationResponse> createEducation(@Header("YH-API-KEY") String apiKey,
                                                      @Header("YH-ACCESS-KEY") String access_key,
                                                      @Header("Authorizations") String authorization,
                                                      @Field("edu_region_name") String edu_region_name,
                                                      @Field("edu_org_category") String edu_org_category,
                                                      @Field("edu_qualification_provider") String edu_qualification_provider,
                                                      @Field("title_of_qualification") String title_of_qualification,
                                                      @Field("edu_description") String edu_description,
                                                      @Field("edu_ncea_level") String edu_ncea_level,
                                                      @Field("qualification_category") String qualification_category,
                                                      @Field("edu_start_date") String edu_start_date,
                                                      @Field("edu_end_date") String edu_end_date,
                                                      @Field("is_inprogress") String is_inprogress
    );

    //Profile
    //90
    @FormUrlEncoded
    @POST("profile/update-education-master")
    Call<ProfileUpdateEducationResponse> updateMasterEducation(@Header("YH-API-KEY") String apiKey,
                                                               @Header("YH-ACCESS-KEY") String access_key,
                                                               @Header("Authorizations") String authorization,
                                                               @Field("qualification_id") String qualification_id);

    //Profile
    //91
    @FormUrlEncoded
    @POST("profile/update-education")
    Call<ProfileUpdatedSuccessResponse> updateEducation(@Header("YH-API-KEY") String apiKey,
                                                        @Header("YH-ACCESS-KEY") String access_key,
                                                        @Header("Authorizations") String authorization,
                                                        @Field("qualification_id") String qualification_id,
                                                        @Field("edu_region_name") String edu_region_name,
                                                        @Field("edu_org_category") String edu_org_category,
                                                        @Field("edu_qualification_provider") String edu_qualification_provider,
                                                        @Field("title_of_qualification") String title_of_qualification,
                                                        @Field("edu_description") String edu_description,
                                                        @Field("edu_ncea_level") String edu_ncea_level,
                                                        @Field("qualification_category") String qualification_category,
                                                        @Field("edu_start_date") String edu_start_date,
                                                        @Field("edu_end_date") String edu_end_date,
                                                        @Field("is_inprogress") String is_inprogress);

    ///Profile
    //92
    @FormUrlEncoded
    @POST("profile/journey-all-milestone-list")
    Call<ProfileMilestoneListResponse> getMilestoneList(@Header("YH-API-KEY") String apiKey,
                                                        @Header("YH-ACCESS-KEY") String access_key,
                                                        @Header("Authorizations") String authorizations,
                                                        @Field("page_no") String page_no,
                                                        @Field("user_code") String user_code);

    //Profile
    //93
    @FormUrlEncoded
    @POST("profile/journey-list")
    Call<ProfileJourneyListResponse> getJourneyList(@Header("YH-API-KEY") String apiKey,
                                                    @Header("YH-ACCESS-KEY") String access_key,
                                                    @Header("Authorizations") String authorizations,
                                                    @Field("page_no") String page_no,
                                                    @Field("user_code") String user_code);

    //Profile
    //94
    @FormUrlEncoded
    @POST("profile/add-volunteering")
    Call<ProfileAddVolunteerResponse> createVolunteer(@Header("YH-API-KEY") String apiKey,
                                                      @Header("YH-ACCESS-KEY") String access_key,
                                                      @Header("Authorizations") String authorization,
                                                      @Field("volun_title") String volun_title,
                                                      @Field("volun_provider_name") String volun_provider_name,
                                                      @Field("volun_description") String volun_description,
                                                      @Field("volun_category_id") String volun_category_id,
                                                      @Field("vol_start_date") String vol_start_date,
                                                      @Field("vol_end_date") String vol_end_date,
                                                      @Field("is_inprogress") String is_inprogress);

    //Connection
    //95
    @FormUrlEncoded
    @POST("connection/get-following-followers")
    Call<ProfileFollowerResponse> getFollowingFollower(@Header("YH-API-KEY") String apiKey,
                                                       @Header("YH-ACCESS-KEY") String access_key,
                                                       @Header("Authorizations") String authorization,
                                                       @Field("page_no") String page_no,
                                                       @Field("type") String type,
                                                       @Field("user_code") String user_code);

    //Profile
    //96
    @FormUrlEncoded
    @POST("profile/update-volunteering-master")
    Call<ProfileVolunteerUpdateMasterResponse> updateMasterVolunteer(@Header("YH-API-KEY") String apiKey,

                                                                     @Header("YH-ACCESS-KEY") String access_key,
                                                                     @Header("Authorizations") String authorization,
                                                                     @Field("volunteering_id") String volunteering_id);

    //Profile
    //97
    @FormUrlEncoded
    @POST("profile/update-volunteering")
    Call<ProfileUpdateVolunteerResponse> updateVolunteer(@Header("YH-API-KEY") String apiKey,
                                                         @Header("YH-ACCESS-KEY") String access_key,
                                                         @Header("Authorizations") String authorization,
                                                         @Field("volunteering_id") String volunteering_id,
                                                         @Field("volun_title") String volun_title,
                                                         @Field("volun_provider_name") String volun_provider_name,
                                                         @Field("volun_description") String volun_description,
                                                         @Field("volun_category_id") String volun_category_id,
                                                         @Field("vol_start_date") String vol_start_date,
                                                         @Field("vol_end_date") String vol_end_date,
                                                         @Field("is_inprogress") String is_inprogress);

    //Profile
    //98
    @FormUrlEncoded
    @POST("profile/add-experience")
    Call<ProfileExperienceAddResponse> createExperience(@Header("YH-API-KEY") String apiKey,
                                                        @Header("YH-ACCESS-KEY") String access_key,
                                                        @Header("Authorizations") String authorization,
                                                        @Field("exp_title") String exp_title,
                                                        @Field("exp_designation") String exp_designation,
                                                        @Field("job_description") String job_description,
                                                        @Field("exp_job_type") String exp_job_type,
                                                        @Field("exp_start_date") String exp_start_date,
                                                        @Field("exp_end_date") String exp_end_date,
                                                        @Field("is_inprogress") String is_inprogress,
                                                        @Field("key_responsibilities") String key_responsibilities);

    //Profile
    //99
    @FormUrlEncoded
    @POST("profile/update-experience-master")
    Call<ProfileUpdateMasterResponse> updateMasterExperience(@Header("YH-API-KEY") String apiKey,

                                                             @Header("YH-ACCESS-KEY") String access_key,
                                                             @Header("Authorizations") String authorization,
                                                             @Field("employment_id") String employment_id);


    //Profile
    //100
    @FormUrlEncoded
    @POST("profile/update-experience")
    Call<ProfileExperienceUpdateResponse> updateExperience(@Header("YH-API-KEY") String apiKey,
                                                           @Header("YH-ACCESS-KEY") String access_key,
                                                           @Header("Authorizations") String authorization,
                                                           @Field("employment_id") String employment_id,
                                                           @Field("exp_title") String exp_title,
                                                           @Field("exp_designation") String exp_designation,
                                                           @Field("job_description") String job_description,
                                                           @Field("exp_job_type") String exp_job_type,
                                                           @Field("exp_start_date") String exp_start_date,
                                                           @Field("exp_end_date") String exp_end_date,
                                                           @Field("is_inprogress") String is_inprogress,
                                                           @Field("key_responsibilities") String key_responsibilities);

    //Profile
    //101
    @FormUrlEncoded
    @POST("profile/add-achievement")
    Call<ProfileAwardsAddResponse> createAwards(@Header("YH-API-KEY") String apiKey,
                                                @Header("YH-ACCESS-KEY") String access_key,
                                                @Header("Authorizations") String authorization,
                                                @Field("acu_title") String acu_title,
                                                @Field("acu_occupation") String acu_occupation,
                                                @Field("acu_provider_name") String acu_provider_name,
                                                @Field("acu_description") String acu_description,
                                                @Field("ach_date") String ach_date);

    //Profile
    //102
    @FormUrlEncoded
    @POST("profile/update-achievement")
    Call<ProfileAwardsAddResponse> updateAwards(@Header("YH-API-KEY") String apiKey,
                                                @Header("YH-ACCESS-KEY") String access_key,
                                                @Header("Authorizations") String authorization,
                                                @Field("achievement_id") String achievement_id,
                                                @Field("acu_title") String acu_title,
                                                @Field("acu_occupation") String acu_occupation,
                                                @Field("acu_provider_name") String acu_provider_name,
                                                @Field("acu_description") String acu_description,
                                                @Field("ach_date") String ach_date);

    //Profile
    //103
    @FormUrlEncoded
    @POST("profile/update-achievement-master")
    Call<ProfileAwardsAddResponse> updateMasterAwards(@Header("YH-API-KEY") String apiKey,

                                                      @Header("YH-ACCESS-KEY") String access_key,
                                                      @Header("Authorizations") String authorization,
                                                      @Field("achievement_id") String achievement_id);

    //Profile
    //104
    @GET("profile/resume-cover-upload-master")
    Call<ProfileAttachCVMasterResponse> attachCVMaster(@Header("YH-API-KEY") String apiKey,
                                                       @Header("YH-ACCESS-KEY") String access_key,
                                                       @Header("Authorizations") String authorization);


    //Profile
    //105
    @FormUrlEncoded
    @POST("profile/add-resume-cover")
    Call<ProfileAttachAddResponse> createAttachCV(@Header("YH-API-KEY") String apiKey,
                                                  @Header("YH-ACCESS-KEY") String access_key,
                                                  @Header("Authorizations") String authorization,
                                                  @Field("cv_type") String cv_type,
                                                  @Field("cv_title") String cv_title,
                                                  @Field("file_name") String file_name);

    //Profile
    //106
    @Multipart
    @POST("profile/resume-cover-upload")
    Call<ProfileResumeUploadResponse> getUploadResumeFile(@Header("YH-API-KEY") String apiKey,
                                                          @Header("YH-ACCESS-KEY") String access_key,
                                                          @Header("Authorizations") String authorizations,
                                                          @Part MultipartBody.Part profile_pic);

    //Profile
    //107
    @FormUrlEncoded
    @POST("profile/add-technical-skills")
    Call<ProfileTechnicalSkillAddResponse> createTechnicalSkill(@Header("YH-API-KEY") String apiKey,
                                                                @Header("YH-ACCESS-KEY") String access_key,
                                                                @Header("Authorizations") String authorization,
                                                                @Field("skill_name") String skill_name,
                                                                @Field("skill_level") String skill_level);

    //Profile
    //108
    @FormUrlEncoded
    @POST("profile/update-technical-skills")
    Call<ProfileTechnicalSkillAddResponse> updateTechnicalSkill(@Header("YH-API-KEY") String apiKey,
                                                                @Header("YH-ACCESS-KEY") String access_key,
                                                                @Header("Authorizations") String authorization,
                                                                @Field("technical_skills_id") String technical_skills_id,
                                                                @Field("skill_name") String skill_name,
                                                                @Field("skill_level") String skill_level);

    //Profile
    //109
    @FormUrlEncoded
    @POST("profile/update-technical-skills-master")
    Call<ProfileTechnicalSkillAddResponse> updateMasterTechnicalSkill(@Header("YH-API-KEY") String apiKey,
                                                                      @Header("YH-ACCESS-KEY") String access_key,
                                                                      @Header("Authorizations") String authorization,
                                                                      @Field("technical_skills_id") String technical_skills_id);

    //Profile
    //110
    @FormUrlEncoded
    @POST("profile/add-interest")
    Call<ProfileInterestAddResponse> createInterest(@Header("YH-API-KEY") String apiKey,
                                                    @Header("YH-ACCESS-KEY") String access_key,
                                                    @Header("Authorizations") String authorization,
                                                    @Field("interest") String interest);

    //Profile
    //111
    @FormUrlEncoded
    @POST("profile/update-interest-master")
    Call<ProfileInterestAddResponse> updateMasterInterest(@Header("YH-API-KEY") String apiKey,
                                                          @Header("YH-ACCESS-KEY") String access_key,
                                                          @Header("Authorizations") String authorization,
                                                          @Field("interest_id") String interest_id);

    //112
    @FormUrlEncoded
    @POST("profile/update-interest")
    Call<ProfileInterestAddResponse> updateInterest(@Header("YH-API-KEY") String apiKey,
                                                    @Header("YH-ACCESS-KEY") String access_key,
                                                    @Header("Authorizations") String authorization,
                                                    @Field("interest_id") String interest_id,
                                                    @Field("interest") String interest);

    //Profile
    //113
    @FormUrlEncoded
    @POST("profile/add-languages")
    Call<ProfileLanguageAddResponse> createLanguage(@Header("YH-API-KEY") String apiKey,
                                                    @Header("YH-ACCESS-KEY") String access_key,
                                                    @Header("Authorizations") String authorization,
                                                    @Field("edu_language") String edu_language,
                                                    @Field("edu_proficiency") String edu_profitiency
                                                    );


    //Profile
    //114
    @GET("profile/journey-add-master")
    Call<ProfileVisualJourneyAddMasterResponse> getJourneyMaster(@Header("YH-API-KEY") String apiKey,
                                                                 @Header("YH-ACCESS-KEY") String access_key,
                                                                 @Header("Authorizations") String authorization);

    //Profile
    //115
    @FormUrlEncoded
    @POST("profile/get-info")
    Call<ProfileGetInfoResponse> getProfileInfoOther(@Header("YH-API-KEY") String apiKey,
                                                     @Header("YH-ACCESS-KEY") String access_key,
                                                     @Header("Authorizations") String authorizations,
                                                     @Field("user_code") String user_code);

    //Setting
    //116
    @FormUrlEncoded
    @POST("password-change")
    Call<CommonRes> updatepassword(@Header("YH-API-KEY") String apiKey,
                                   @Header("YH-ACCESS-KEY") String access_key,
                                   @Header("Authorizations") String authorizations,
                                   @Field("oldpassword") String oldpassword,
                                   @Field("password") String password,
                                   @Field("repassword") String repassword
    );

    //Find Connection
    //117
    @FormUrlEncoded
    @POST("chat/new-chat")
    Call<ContactMessageResponse> createContactMessage(@Header("YH-API-KEY") String apiKey,
                                                      @Header("YH-ACCESS-KEY") String access_key,
                                                      @Header("Authorizations") String authorizations,
                                                      @Field("to_user_code") String to_user_code,
                                                      @Field("chat_id") String chat_id,
                                                      @Field("message") String message
    );

    //Find Connection
    //118
    @FormUrlEncoded
    @POST("connection/share-profile")
    Call<SharedProfileResponse> sharedProfile(@Header("YH-API-KEY") String apiKey,
                                              @Header("YH-ACCESS-KEY") String access_key,
                                              @Header("Authorizations") String authorizations,
                                              @Field("share_user_code") String share_user_code
    );

    //Dashboard
    //119
    @GET("logout")
    Call<CommonResponse> getlogout(@Header("YH-API-KEY") String apiKey,
                                   @Header("YH-ACCESS-KEY") String access_key,
                                   @Header("Authorizations") String authorizations);

    //Profile
    //120
    @FormUrlEncoded
    @POST("profile/journey-milestone-list")
    Call<ProfileMilestoneListResponse> getJourneyMilestoneList(@Header("YH-API-KEY") String apiKey,
                                                               @Header("YH-ACCESS-KEY") String access_key,
                                                               @Header("Authorizations") String authorizations,
                                                               @Field("page_no") String page_no,
                                                               @Field("journey_code") String journey_code);
    //Profile
    //121
    @Multipart
    @POST("profile/journey-images-upload")
    Call<JourneyProfileUploadResponse> getVisualJourneyImage(@Header("YH-API-KEY") String apiKey,
                                                             @Header("YH-ACCESS-KEY") String access_key,
                                                             @Header("Authorizations") String authorizations,
                                                             @Part MultipartBody.Part profile_pic);
    //Profile
    //122
    @FormUrlEncoded
    @POST("profile/journey-milestone-add")
    Call<MilestoneResponse> getVisualJourneyAdd(@Header("YH-API-KEY") String apiKey,
                                                @Header("YH-ACCESS-KEY") String access_key,
                                                @Header("Authorizations") String authorizations,
                                                @Field("journey_code") String journey_code,
                                                @Field("title") String title,
                                                @Field("description") String description,
                                                @Field("gallery_temp_code") String gallery_temp_code
                                                          );

    //Profile
    //120
    @FormUrlEncoded
    @POST("profile/journey-add")
    Call<AddJourneyResponse> getAddJourney(@Header("YH-API-KEY") String apiKey,
                                           @Header("YH-ACCESS-KEY") String access_key,
                                           @Header("Authorizations") String authorizations,
                                           @Field("title") String title,
                                           @Field("short_description") String short_description,
                                           @Field("description") String description,
                                           @Field("tags") String tags,
                                           @Field("prime_tags") String prime_tags,
                                           @Field("gallery_temp_code") String gallery_temp_code);

    //Profile
    //121
    @FormUrlEncoded
    @POST("user-picture-delete")
    Call<ProfileDeleteResonse> getProfileDelete(@Header("YH-API-KEY") String apiKey,
                                              @Header("YH-ACCESS-KEY") String access_key,
                                              @Header("Authorizations") String authorization,
                                              @Field("type") String type);


//VisualJourney
 //122
    @FormUrlEncoded
    @POST("profile/journey-delete")
    Call<Journey_delete_model> journeydelete(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorization,
                                             @Field("journey_code") String journey_code);



//123
//profile_journey_Edit_master_details

    @FormUrlEncoded
    @POST("profile/journey-edit-master")
    Call<Journey_edit_response> JourneyEditDetails(@Header("YH-API-KEY") String apiKey,
                                                   @Header("YH-ACCESS-KEY") String access_key,
                                                   @Header("Authorizations") String authorization,
                                                   @Field("journey_code") String journey_code);


    //124
    //profile_journey_Edit_master

    @FormUrlEncoded
    @POST("profile/journey-edit")
    Call<Journey_after_edit_response> Journey_Edit(@Header("YH-API-KEY") String apiKey,
                                                   @Header("YH-ACCESS-KEY") String access_key,
                                                   @Header("Authorizations") String authorization,
                                                   @Field("journey_code") String journey_code,
                                                   @Field("title") String title,
                                                   @Field("short_description") String short_description,
                                                   @Field("description") String description,
                                                   @Field("tags") String tags,
                                                   @Field("prime_tags") String prime_tags,
                                                   @Field("gallery_temp_code") String gallery_temp_code);

    //125
    //Milestone_Edit_delete
    @FormUrlEncoded
    @POST("profile/journey-milestone-delete")
    Call<MilestoneDelete> getmilestonedelete(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("milestone_id") String milestone_id,
                                             @Field("journey_code") String journey_code);



    //126
    //Milestone EditMaster
    @FormUrlEncoded
    @POST("profile/journey-milestone-edit-master")
    Call<MilestoneUpdateMaster> getmilestoneupdatemaster(@Header("YH-API-KEY") String apiKey,
                                                         @Header("YH-ACCESS-KEY") String access_key,
                                                         @Header("Authorizations") String authorizations,
                                                         @Field("milestone_id") String milestone_id,
                                                         @Field("journey_code") String journey_code);//Milestone EditMaster


    //Milestone Edit
    //127
    @FormUrlEncoded
    @POST("profile/journey-milestone-edit")
    Call<MilestoneUpdate> getmilestoneupdate(@Header("YH-API-KEY") String apiKey,
                                             @Header("YH-ACCESS-KEY") String access_key,
                                             @Header("Authorizations") String authorizations,
                                             @Field("milestone_id") String milestone_id,
                                             @Field("journey_code") String journey_code,
                                             @Field("title") String title,
                                             @Field("description") String description,
                                             @Field("gallery_temp_code") String gallery_temp_code);
    //CoverPictureUpload
    //128
    @Multipart
    @POST("cover-picture-upload")
    Call<CoverPictureUpload> getCoverPic(@Header("YH-API-KEY") String apiKey,
                                         @Header("YH-ACCESS-KEY") String access_key,
                                         @Header("Authorizations") String authorizations,
                                         @Part MultipartBody.Part cover_pic

    );

}
