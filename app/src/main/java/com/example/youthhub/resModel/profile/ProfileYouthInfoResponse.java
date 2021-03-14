package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfileYouthInfoResponse implements Parcelable {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ProfileYouthData data;
    @SerializedName("message")
    @Expose
    private String message;

    public ProfileYouthInfoResponse() {
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ProfileYouthData getData() {
        return data;
    }

    public void setData(ProfileYouthData data) {
        this.data = data;
    }

    public  class ProfileYouthData implements Parcelable {
        @SerializedName("login_user_id")
        @Expose
        private String login_user_id;
        @SerializedName("profile_user_id")
        @Expose
        private String profile_user_id;
        @SerializedName("profile_user_type")
        @Expose
        private String profile_user_type;
        @SerializedName("user_medium_path")
        @Expose
        private String user_medium_path;
        @SerializedName("user_thumbnail_path")
        @Expose
        private String user_thumbnail_path;
        @SerializedName("user_cover_path")
        @Expose
        private String user_cover_path;

        @SerializedName("cv_path")
        @Expose
        private String cv_path;

        @SerializedName("profile_info")
        @Expose
        private ProfileInfo profile_info;
        @SerializedName("user_settings")
        @Expose
        private UserSetting user_settings;
        @SerializedName("language")
        @Expose
        private List<Language> language;
        @SerializedName("interests")
        @Expose
        private List<Interests> interests;
        @SerializedName("technical_skills")
        @Expose
        private List<TechnicalSkills> technical_skills;
        @SerializedName("user_cv")
        @Expose
        private List<UserCv> user_cv;
        @SerializedName("achievement")
        @Expose
        private List<Achievement> achievement;

        @SerializedName("skills")
        @Expose
        private List<Skills> skills;

        @SerializedName("volunteering")
        @Expose
        private List<Volunteering> volunteering;

        @SerializedName("education")
        @Expose
        private List<Education> education;

        @SerializedName("experience")
        @Expose
        private List<Experience> experience;
        @SerializedName("testimonials")
        @Expose
        private List<Testimonials> testimonials;

        @SerializedName("job_wishlist")
        @Expose
        private List<JobWishlist> job_wishlist;

        @SerializedName("workinfo")
        @Expose
        private WorkInfo workinfo;


        public String getLogin_user_id() {
            return login_user_id;
        }

        public void setLogin_user_id(String login_user_id) {
            this.login_user_id = login_user_id;
        }

        public String getProfile_user_id() {
            return profile_user_id;
        }

        public void setProfile_user_id(String profile_user_id) {
            this.profile_user_id = profile_user_id;
        }

        public String getProfile_user_type() {
            return profile_user_type;
        }

        public void setProfile_user_type(String profile_user_type) {
            this.profile_user_type = profile_user_type;
        }

        public String getUser_medium_path() {
            return user_medium_path;
        }

        public void setUser_medium_path(String user_medium_path) {
            this.user_medium_path = user_medium_path;
        }

        public String getUser_thumbnail_path() {
            return user_thumbnail_path;
        }

        public void setUser_thumbnail_path(String user_thumbnail_path) {
            this.user_thumbnail_path = user_thumbnail_path;
        }

        public String getUser_cover_path() {
            return user_cover_path;
        }

        public void setUser_cover_path(String user_cover_path) {
            this.user_cover_path = user_cover_path;
        }

        public String getCv_path() {
            return cv_path;
        }

        public void setCv_path(String cv_path) {
            this.cv_path = cv_path;
        }

        public ProfileInfo getProfile_info() {
            return profile_info;
        }

        public void setProfile_info(ProfileInfo profile_info) {
            this.profile_info = profile_info;
        }

        public UserSetting getUser_settings() {
            return user_settings;
        }

        public void setUser_settings(UserSetting user_settings) {
            this.user_settings = user_settings;
        }

        public List<Language> getLanguage() {
            return language;
        }

        public void setLanguage(List<Language> language) {
            this.language = language;
        }

        public List<Interests> getInterests() {
            return interests;
        }

        public void setInterests(List<Interests> interests) {
            this.interests = interests;
        }

        public List<TechnicalSkills> getTechnical_skills() {
            return technical_skills;
        }

        public void setTechnical_skills(List<TechnicalSkills> technical_skills) {
            this.technical_skills = technical_skills;
        }

        public List<UserCv> getUser_cv() {
            return user_cv;
        }

        public void setUser_cv(List<UserCv> user_cv) {
            this.user_cv = user_cv;
        }

        public List<Achievement> getAchievement() {
            return achievement;
        }

        public void setAchievement(List<Achievement> achievement) {
            this.achievement = achievement;
        }

        public List<Skills> getSkills() {
            return skills;
        }

        public void setSkills(List<Skills> skills) {
            this.skills = skills;
        }

        public List<Volunteering> getVolunteering() {
            return volunteering;
        }

        public void setVolunteering(List<Volunteering> volunteering) {
            this.volunteering = volunteering;
        }

        public List<Education> getEducation() {
            return education;
        }

        public void setEducation(List<Education> education) {
            this.education = education;
        }

        public List<Experience> getExperience() {
            return experience;
        }

        public void setExperience(List<Experience> experience) {
            this.experience = experience;
        }

        public List<Testimonials> getTestimonials() {
            return testimonials;
        }

        public void setTestimonials(List<Testimonials> testimonials) {
            this.testimonials = testimonials;
        }

        public List<JobWishlist> getJob_wishlist() {
            return job_wishlist;
        }

        public void setJob_wishlist(List<JobWishlist> job_wishlist) {
            this.job_wishlist = job_wishlist;
        }

        public WorkInfo getWorkinfo() {
            return workinfo;
        }

        public void setWorkinfo(WorkInfo workinfo) {
            this.workinfo = workinfo;
        }



        public class WorkInfo implements Parcelable {
            @SerializedName("workinfo_tooltip")
            @Expose
            private String workinfo_tooltip;
            @SerializedName("work_experience")
            @Expose
            private String work_experience;
            @SerializedName("licence_type")
            @Expose
            private String licence_type;
            @SerializedName("work_availability")
            @Expose
            private String work_availability;
            @SerializedName("work_availability_hour")
            @Expose
            private String work_availability_hour;

            public String getWorkinfo_tooltip() {
                return workinfo_tooltip;
            }

            public void setWorkinfo_tooltip(String workinfo_tooltip) {
                this.workinfo_tooltip = workinfo_tooltip;
            }

            public String getWork_experience() {
                return work_experience;
            }

            public void setWork_experience(String work_experience) {
                this.work_experience = work_experience;
            }

            public String getLicence_type() {
                return licence_type;
            }

            public void setLicence_type(String licence_type) {
                this.licence_type = licence_type;
            }

            public String getWork_availability() {
                return work_availability;
            }

            public void setWork_availability(String work_availability) {
                this.work_availability = work_availability;
            }

            public String getWork_availability_hour() {
                return work_availability_hour;
            }

            public void setWork_availability_hour(String work_availability_hour) {
                this.work_availability_hour = work_availability_hour;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.workinfo_tooltip);
                dest.writeString(this.work_experience);
                dest.writeString(this.licence_type);
                dest.writeString(this.work_availability);
                dest.writeString(this.work_availability_hour);
            }

            public WorkInfo() {
            }

            protected WorkInfo(Parcel in) {
                this.workinfo_tooltip = in.readString();
                this.work_experience = in.readString();
                this.licence_type = in.readString();
                this.work_availability = in.readString();
                this.work_availability_hour = in.readString();
            }

            public  final Creator<WorkInfo> CREATOR = new Creator<WorkInfo>() {
                @Override
                public WorkInfo createFromParcel(Parcel source) {
                    return new WorkInfo(source);
                }

                @Override
                public WorkInfo[] newArray(int size) {
                    return new WorkInfo[size];
                }
            };
        }
        public  class JobWishlist implements Parcelable {
            @SerializedName("wiu_wishlist_id")
            @Expose
            private String wiu_wishlist_id;
            @SerializedName("wit_name")
            @Expose
            private String wit_name;

            public String getWiu_wishlist_id() {
                return wiu_wishlist_id;
            }

            public void setWiu_wishlist_id(String wiu_wishlist_id) {
                this.wiu_wishlist_id = wiu_wishlist_id;
            }

            public String getWit_name() {
                return wit_name;
            }

            public void setWit_name(String wit_name) {
                this.wit_name = wit_name;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.wiu_wishlist_id);
                dest.writeString(this.wit_name);
            }

            public JobWishlist() {
            }

            protected JobWishlist(Parcel in) {
                this.wiu_wishlist_id = in.readString();
                this.wit_name = in.readString();
            }

            public  final Creator<JobWishlist> CREATOR = new Creator<JobWishlist>() {
                @Override
                public JobWishlist createFromParcel(Parcel source) {
                    return new JobWishlist(source);
                }

                @Override
                public JobWishlist[] newArray(int size) {
                    return new JobWishlist[size];
                }
            };
        }
        public class Testimonials implements Parcelable {
            @SerializedName("teu_testimonial_id")
            @Expose
            private String teu_testimonial_id;
            @SerializedName("teu_provider_id")
            @Expose
            private String teu_provider_id;
            @SerializedName("teu_provider_name")
            @Expose
            private String teu_provider_name;
            @SerializedName("teu_provider_company")
            @Expose
            private String teu_provider_company;
            @SerializedName("teu_provider_title")
            @Expose
            private String teu_provider_title;
            @SerializedName("teu_provider_email")
            @Expose
            private String teu_provider_email;
            @SerializedName("teu_provider_phone")
            @Expose
            private String teu_provider_phone;
            @SerializedName("teu_provider_message")
            @Expose
            private String teu_provider_message;
            @SerializedName("teu_created_on")
            @Expose
            private String teu_created_on;
            @SerializedName("skm_name")
            @Expose
            private String skm_name;

            public String getTeu_testimonial_id() {
                return teu_testimonial_id;
            }

            public void setTeu_testimonial_id(String teu_testimonial_id) {
                this.teu_testimonial_id = teu_testimonial_id;
            }

            public String getTeu_provider_id() {
                return teu_provider_id;
            }

            public void setTeu_provider_id(String teu_provider_id) {
                this.teu_provider_id = teu_provider_id;
            }

            public String getTeu_provider_name() {
                return teu_provider_name;
            }

            public void setTeu_provider_name(String teu_provider_name) {
                this.teu_provider_name = teu_provider_name;
            }

            public String getTeu_provider_company() {
                return teu_provider_company;
            }

            public void setTeu_provider_company(String teu_provider_company) {
                this.teu_provider_company = teu_provider_company;
            }

            public String getTeu_provider_title() {
                return teu_provider_title;
            }

            public void setTeu_provider_title(String teu_provider_title) {
                this.teu_provider_title = teu_provider_title;
            }

            public String getTeu_provider_email() {
                return teu_provider_email;
            }

            public void setTeu_provider_email(String teu_provider_email) {
                this.teu_provider_email = teu_provider_email;
            }

            public String getTeu_provider_phone() {
                return teu_provider_phone;
            }

            public void setTeu_provider_phone(String teu_provider_phone) {
                this.teu_provider_phone = teu_provider_phone;
            }

            public String getTeu_provider_message() {
                return teu_provider_message;
            }

            public void setTeu_provider_message(String teu_provider_message) {
                this.teu_provider_message = teu_provider_message;
            }

            public String getTeu_created_on() {
                return teu_created_on;
            }

            public void setTeu_created_on(String teu_created_on) {
                this.teu_created_on = teu_created_on;
            }

            public String getSkm_name() {
                return skm_name;
            }

            public void setSkm_name(String skm_name) {
                this.skm_name = skm_name;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.teu_testimonial_id);
                dest.writeString(this.teu_provider_id);
                dest.writeString(this.teu_provider_name);
                dest.writeString(this.teu_provider_company);
                dest.writeString(this.teu_provider_title);
                dest.writeString(this.teu_provider_email);
                dest.writeString(this.teu_provider_phone);
                dest.writeString(this.teu_provider_message);
                dest.writeString(this.teu_created_on);
                dest.writeString(this.skm_name);
            }

            public Testimonials() {
            }

            protected Testimonials(Parcel in) {
                this.teu_testimonial_id = in.readString();
                this.teu_provider_id = in.readString();
                this.teu_provider_name = in.readString();
                this.teu_provider_company = in.readString();
                this.teu_provider_title = in.readString();
                this.teu_provider_email = in.readString();
                this.teu_provider_phone = in.readString();
                this.teu_provider_message = in.readString();
                this.teu_created_on = in.readString();
                this.skm_name = in.readString();
            }

            public  final Creator<Testimonials> CREATOR = new Creator<Testimonials>() {
                @Override
                public Testimonials createFromParcel(Parcel source) {
                    return new Testimonials(source);
                }

                @Override
                public Testimonials[] newArray(int size) {
                    return new Testimonials[size];
                }
            };
        }
        public class Experience implements Parcelable {
            @SerializedName("emu_employment_id")
            @Expose
            private String emu_employment_id;
            @SerializedName("emu_employer_name")
            @Expose
            private String emu_employer_name;
            @SerializedName("emu_status")
            @Expose
            private String emu_status;
            @SerializedName("emu_start_year")
            @Expose
            private String emu_start_year;
            @SerializedName("emu_start_month")
            @Expose
            private String emu_start_month;
            @SerializedName("emu_end_year")
            @Expose
            private String emu_end_year;
            @SerializedName("emu_end_month")
            @Expose
            private String emu_end_month;
            @SerializedName("emu_designation")
            @Expose
            private String emu_designation;@SerializedName("emu_description")
            @Expose
            private String emu_description;
            @SerializedName("emu_responsibilities")
            @Expose
            private List<EmuResponsibilities> emu_responsibilities;
            public class EmuResponsibilities implements Serializable {
                @SerializedName("name")
                @Expose
                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
            @SerializedName("emu_ica_category_id")
            @Expose
            private String emu_ica_category_id;
            @SerializedName("emu_isc_sub_category_id")
            @Expose
            private String emu_isc_sub_category_id;
            @SerializedName("emu_jt_type_id")
            @Expose
            private String emu_jt_type_id;@SerializedName("emu_ica_category_name")
            @Expose
            private String emu_ica_category_name;
            @SerializedName("emu_isc_sub_category_name")
            @Expose
            private String emu_isc_sub_category_name;
            @SerializedName("emu_jt_type_name")
            @Expose
            private String emu_jt_type_name;
            @SerializedName("diff_year")
            @Expose
            private String diff_year;
            @SerializedName("is_inprogress")
            @Expose
            private String is_inprogress;
            @SerializedName("start_date")
            @Expose
            private String start_date;
            @SerializedName("end_date")
            @Expose
            private String end_date;


            public String getEmu_employment_id() {
                return emu_employment_id;
            }

            public void setEmu_employment_id(String emu_employment_id) {
                this.emu_employment_id = emu_employment_id;
            }

            public String getEmu_employer_name() {
                return emu_employer_name;
            }

            public void setEmu_employer_name(String emu_employer_name) {
                this.emu_employer_name = emu_employer_name;
            }

            public String getEmu_status() {
                return emu_status;
            }

            public void setEmu_status(String emu_status) {
                this.emu_status = emu_status;
            }

            public String getEmu_start_year() {
                return emu_start_year;
            }

            public void setEmu_start_year(String emu_start_year) {
                this.emu_start_year = emu_start_year;
            }

            public String getEmu_start_month() {
                return emu_start_month;
            }

            public void setEmu_start_month(String emu_start_month) {
                this.emu_start_month = emu_start_month;
            }

            public String getEmu_end_year() {
                return emu_end_year;
            }

            public void setEmu_end_year(String emu_end_year) {
                this.emu_end_year = emu_end_year;
            }

            public String getEmu_end_month() {
                return emu_end_month;
            }

            public void setEmu_end_month(String emu_end_month) {
                this.emu_end_month = emu_end_month;
            }

            public String getEmu_designation() {
                return emu_designation;
            }

            public void setEmu_designation(String emu_designation) {
                this.emu_designation = emu_designation;
            }

            public String getEmu_description() {
                return emu_description;
            }

            public void setEmu_description(String emu_description) {
                this.emu_description = emu_description;
            }

            public List<EmuResponsibilities> getEmu_responsibilities() {
                return emu_responsibilities;
            }

            public void setEmu_responsibilities(List<EmuResponsibilities> emu_responsibilities) {
                this.emu_responsibilities = emu_responsibilities;
            }

            public String getEmu_ica_category_id() {
                return emu_ica_category_id;
            }

            public void setEmu_ica_category_id(String emu_ica_category_id) {
                this.emu_ica_category_id = emu_ica_category_id;
            }

            public String getEmu_isc_sub_category_id() {
                return emu_isc_sub_category_id;
            }

            public void setEmu_isc_sub_category_id(String emu_isc_sub_category_id) {
                this.emu_isc_sub_category_id = emu_isc_sub_category_id;
            }

            public String getEmu_jt_type_id() {
                return emu_jt_type_id;
            }

            public void setEmu_jt_type_id(String emu_jt_type_id) {
                this.emu_jt_type_id = emu_jt_type_id;
            }

            public String getEmu_ica_category_name() {
                return emu_ica_category_name;
            }

            public void setEmu_ica_category_name(String emu_ica_category_name) {
                this.emu_ica_category_name = emu_ica_category_name;
            }

            public String getEmu_isc_sub_category_name() {
                return emu_isc_sub_category_name;
            }

            public void setEmu_isc_sub_category_name(String emu_isc_sub_category_name) {
                this.emu_isc_sub_category_name = emu_isc_sub_category_name;
            }

            public String getEmu_jt_type_name() {
                return emu_jt_type_name;
            }

            public void setEmu_jt_type_name(String emu_jt_type_name) {
                this.emu_jt_type_name = emu_jt_type_name;
            }

            public String getDiff_year() {
                return diff_year;
            }

            public void setDiff_year(String diff_year) {
                this.diff_year = diff_year;
            }

            public String getIs_inprogress() {
                return is_inprogress;
            }

            public void setIs_inprogress(String is_inprogress) {
                this.is_inprogress = is_inprogress;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.emu_employment_id);
                dest.writeString(this.emu_employer_name);
                dest.writeString(this.emu_status);
                dest.writeString(this.emu_start_year);
                dest.writeString(this.emu_start_month);
                dest.writeString(this.emu_end_year);
                dest.writeString(this.emu_end_month);
                dest.writeString(this.emu_designation);
                dest.writeString(this.emu_description);
                dest.writeList(this.emu_responsibilities);
                dest.writeString(this.emu_ica_category_id);
                dest.writeString(this.emu_isc_sub_category_id);
                dest.writeString(this.emu_jt_type_id);
                dest.writeString(this.emu_ica_category_name);
                dest.writeString(this.emu_isc_sub_category_name);
                dest.writeString(this.emu_jt_type_name);
                dest.writeString(this.diff_year);
                dest.writeString(this.is_inprogress);
                dest.writeString(this.start_date);
                dest.writeString(this.end_date);
            }

            public Experience() {
            }

            protected Experience(Parcel in) {
                this.emu_employment_id = in.readString();
                this.emu_employer_name = in.readString();
                this.emu_status = in.readString();
                this.emu_start_year = in.readString();
                this.emu_start_month = in.readString();
                this.emu_end_year = in.readString();
                this.emu_end_month = in.readString();
                this.emu_designation = in.readString();
                this.emu_description = in.readString();
                this.emu_responsibilities = new ArrayList<EmuResponsibilities>();
                in.readList(this.emu_responsibilities, EmuResponsibilities.class.getClassLoader());
                this.emu_ica_category_id = in.readString();
                this.emu_isc_sub_category_id = in.readString();
                this.emu_jt_type_id = in.readString();
                this.emu_ica_category_name = in.readString();
                this.emu_isc_sub_category_name = in.readString();
                this.emu_jt_type_name = in.readString();
                this.diff_year = in.readString();
                this.is_inprogress = in.readString();
                this.start_date = in.readString();
                this.end_date = in.readString();
            }

            public  final Creator<Experience> CREATOR = new Creator<Experience>() {
                @Override
                public Experience createFromParcel(Parcel source) {
                    return new Experience(source);
                }

                @Override
                public Experience[] newArray(int size) {
                    return new Experience[size];
                }
            };
        }

        public class Education implements Parcelable {
            @SerializedName("qau_qualification_id")
            @Expose
            private String qau_qualification_id;
            @SerializedName("qau_title")
            @Expose
            private String qau_title;
            @SerializedName("qau_description")
            @Expose
            private String qau_description;
            @SerializedName("re_name")
            @Expose
            private String re_name;
            @SerializedName("qac_name")
            @Expose
            private String qac_name;
            @SerializedName("qap_name")
            @Expose
            private String qap_name;
            @SerializedName("qam_title")
            @Expose
            private String qam_title;
            @SerializedName("qua_provider_name")
            @Expose
            private String qua_provider_name;
            @SerializedName("ogc_name")
            @Expose
            private String ogc_name;
            @SerializedName("qau_status")
            @Expose
            private String qau_status;
            @SerializedName("qau_start_date")
            @Expose
            private String qau_start_date;
            @SerializedName("qau_ncea_level")
            @Expose
            private String qau_ncea_level;
            @SerializedName("qau_re_region_id")
            @Expose
            private String qau_re_region_id;
            @SerializedName("qau_ogc_category_id")
            @Expose
            private String qau_ogc_category_id;
            @SerializedName("qau_qap_provider_id")
            @Expose
            private String qau_qap_provider_id;
            @SerializedName("qau_qam_qualification_id")
            @Expose
            private String qau_qam_qualification_id;
            @SerializedName("qau_qac_category_id")
            @Expose
            private String qau_qac_category_id;
            @SerializedName("diff_year")
            @Expose
            private String diff_year;
            @SerializedName("diff_month")
            @Expose
            private String diff_month;
            @SerializedName("qau_end_date")
            @Expose
            private String qau_end_date;

            public String getQau_qualification_id() {
                return qau_qualification_id;
            }

            public void setQau_qualification_id(String qau_qualification_id) {
                this.qau_qualification_id = qau_qualification_id;
            }

            public String getQau_title() {
                return qau_title;
            }

            public void setQau_title(String qau_title) {
                this.qau_title = qau_title;
            }

            public String getQau_description() {
                return qau_description;
            }

            public void setQau_description(String qau_description) {
                this.qau_description = qau_description;
            }

            public String getRe_name() {
                return re_name;
            }

            public void setRe_name(String re_name) {
                this.re_name = re_name;
            }

            public String getQac_name() {
                return qac_name;
            }

            public void setQac_name(String qac_name) {
                this.qac_name = qac_name;
            }

            public String getQap_name() {
                return qap_name;
            }

            public void setQap_name(String qap_name) {
                this.qap_name = qap_name;
            }

            public String getQam_title() {
                return qam_title;
            }

            public void setQam_title(String qam_title) {
                this.qam_title = qam_title;
            }

            public String getQua_provider_name() {
                return qua_provider_name;
            }

            public void setQua_provider_name(String qua_provider_name) {
                this.qua_provider_name = qua_provider_name;
            }

            public String getOgc_name() {
                return ogc_name;
            }

            public void setOgc_name(String ogc_name) {
                this.ogc_name = ogc_name;
            }

            public String getQau_status() {
                return qau_status;
            }

            public void setQau_status(String qau_status) {
                this.qau_status = qau_status;
            }

            public String getQau_start_date() {
                return qau_start_date;
            }

            public void setQau_start_date(String qau_start_date) {
                this.qau_start_date = qau_start_date;
            }

            public String getQau_ncea_level() {
                return qau_ncea_level;
            }

            public void setQau_ncea_level(String qau_ncea_level) {
                this.qau_ncea_level = qau_ncea_level;
            }

            public String getQau_re_region_id() {
                return qau_re_region_id;
            }

            public void setQau_re_region_id(String qau_re_region_id) {
                this.qau_re_region_id = qau_re_region_id;
            }

            public String getQau_ogc_category_id() {
                return qau_ogc_category_id;
            }

            public void setQau_ogc_category_id(String qau_ogc_category_id) {
                this.qau_ogc_category_id = qau_ogc_category_id;
            }

            public String getQau_qap_provider_id() {
                return qau_qap_provider_id;
            }

            public void setQau_qap_provider_id(String qau_qap_provider_id) {
                this.qau_qap_provider_id = qau_qap_provider_id;
            }

            public String getQau_qam_qualification_id() {
                return qau_qam_qualification_id;
            }

            public void setQau_qam_qualification_id(String qau_qam_qualification_id) {
                this.qau_qam_qualification_id = qau_qam_qualification_id;
            }

            public String getQau_qac_category_id() {
                return qau_qac_category_id;
            }

            public void setQau_qac_category_id(String qau_qac_category_id) {
                this.qau_qac_category_id = qau_qac_category_id;
            }

            public String getDiff_year() {
                return diff_year;
            }

            public void setDiff_year(String diff_year) {
                this.diff_year = diff_year;
            }

            public String getDiff_month() {
                return diff_month;
            }

            public void setDiff_month(String diff_month) {
                this.diff_month = diff_month;
            }

            public String getQau_end_date() {
                return qau_end_date;
            }

            public void setQau_end_date(String qau_end_date) {
                this.qau_end_date = qau_end_date;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.qau_qualification_id);
                dest.writeString(this.qau_title);
                dest.writeString(this.qau_description);
                dest.writeString(this.re_name);
                dest.writeString(this.qac_name);
                dest.writeString(this.qap_name);
                dest.writeString(this.qam_title);
                dest.writeString(this.qua_provider_name);
                dest.writeString(this.ogc_name);
                dest.writeString(this.qau_status);
                dest.writeString(this.qau_start_date);
                dest.writeString(this.qau_ncea_level);
                dest.writeString(this.qau_re_region_id);
                dest.writeString(this.qau_ogc_category_id);
                dest.writeString(this.qau_qap_provider_id);
                dest.writeString(this.qau_qam_qualification_id);
                dest.writeString(this.qau_qac_category_id);
                dest.writeString(this.diff_year);
                dest.writeString(this.diff_month);
                dest.writeString(this.qau_end_date);
            }

            public Education() {
            }

            protected Education(Parcel in) {
                this.qau_qualification_id = in.readString();
                this.qau_title = in.readString();
                this.qau_description = in.readString();
                this.re_name = in.readString();
                this.qac_name = in.readString();
                this.qap_name = in.readString();
                this.qam_title = in.readString();
                this.qua_provider_name = in.readString();
                this.ogc_name = in.readString();
                this.qau_status = in.readString();
                this.qau_start_date = in.readString();
                this.qau_ncea_level = in.readString();
                this.qau_re_region_id = in.readString();
                this.qau_ogc_category_id = in.readString();
                this.qau_qap_provider_id = in.readString();
                this.qau_qam_qualification_id = in.readString();
                this.qau_qac_category_id = in.readString();
                this.diff_year = in.readString();
                this.diff_month = in.readString();
                this.qau_end_date = in.readString();
            }

            public  final Creator<Education> CREATOR = new Creator<Education>() {
                @Override
                public Education createFromParcel(Parcel source) {
                    return new Education(source);
                }

                @Override
                public Education[] newArray(int size) {
                    return new Education[size];
                }
            };
        }
        public class Volunteering implements Parcelable {
            @SerializedName("vou_qualification_id")
            @Expose
            private String vou_qualification_id;
            @SerializedName("vou_title")
            @Expose
            private String vou_title;
            @SerializedName("vou_description")
            @Expose
            private String vou_description;
            @SerializedName("voc_name")
            @Expose
            private String voc_name;
            @SerializedName("vou_provider_name")
            @Expose
            private String vou_provider_name;
            @SerializedName("vou_status")
            @Expose
            private String vou_status;
            @SerializedName("vou_start_date")
            @Expose
            private String vou_start_date;
            @SerializedName("vou_end_date")
            @Expose
            private String vou_end_date;
            @SerializedName("diff_year")
            @Expose
            private String diff_year;
            @SerializedName("diff_month")
            @Expose
            private String diff_month;

            public String getVou_qualification_id() {
                return vou_qualification_id;
            }

            public void setVou_qualification_id(String vou_qualification_id) {
                this.vou_qualification_id = vou_qualification_id;
            }

            public String getVou_title() {
                return vou_title;
            }

            public void setVou_title(String vou_title) {
                this.vou_title = vou_title;
            }

            public String getVou_description() {
                return vou_description;
            }

            public void setVou_description(String vou_description) {
                this.vou_description = vou_description;
            }

            public String getVoc_name() {
                return voc_name;
            }

            public void setVoc_name(String voc_name) {
                this.voc_name = voc_name;
            }

            public String getVou_provider_name() {
                return vou_provider_name;
            }

            public void setVou_provider_name(String vou_provider_name) {
                this.vou_provider_name = vou_provider_name;
            }

            public String getVou_status() {
                return vou_status;
            }

            public void setVou_status(String vou_status) {
                this.vou_status = vou_status;
            }

            public String getVou_start_date() {
                return vou_start_date;
            }

            public void setVou_start_date(String vou_start_date) {
                this.vou_start_date = vou_start_date;
            }

            public String getVou_end_date() {
                return vou_end_date;
            }

            public void setVou_end_date(String vou_end_date) {
                this.vou_end_date = vou_end_date;
            }

            public String getDiff_year() {
                return diff_year;
            }

            public void setDiff_year(String diff_year) {
                this.diff_year = diff_year;
            }

            public String getDiff_month() {
                return diff_month;
            }

            public void setDiff_month(String diff_month) {
                this.diff_month = diff_month;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.vou_qualification_id);
                dest.writeString(this.vou_title);
                dest.writeString(this.vou_description);
                dest.writeString(this.voc_name);
                dest.writeString(this.vou_provider_name);
                dest.writeString(this.vou_status);
                dest.writeString(this.vou_start_date);
                dest.writeString(this.vou_end_date);
                dest.writeString(this.diff_year);
                dest.writeString(this.diff_month);
            }

            public Volunteering() {
            }

            protected Volunteering(Parcel in) {
                this.vou_qualification_id = in.readString();
                this.vou_title = in.readString();
                this.vou_description = in.readString();
                this.voc_name = in.readString();
                this.vou_provider_name = in.readString();
                this.vou_status = in.readString();
                this.vou_start_date = in.readString();
                this.vou_end_date = in.readString();
                this.diff_year = in.readString();
                this.diff_month = in.readString();
            }

            public  final Creator<Volunteering> CREATOR = new Creator<Volunteering>() {
                @Override
                public Volunteering createFromParcel(Parcel source) {
                    return new Volunteering(source);
                }

                @Override
                public Volunteering[] newArray(int size) {
                    return new Volunteering[size];
                }
            };
        }
        public class Skills implements Parcelable {
            @SerializedName("skm_skill_id")
            @Expose
            private String skm_skill_id;
            @SerializedName("teu_testimonial_id")
            @Expose
            private String teu_testimonial_id;
            @SerializedName("teu_provider_id")
            @Expose
            private String teu_provider_id;
            @SerializedName("teu_provider_name")
            @Expose
            private String teu_provider_name;
            @SerializedName("skm_name")
            @Expose
            private String skm_name;
            @SerializedName("endorsed_by")
            @Expose
            private List<EndorsedBy> endorsed_by;

            public String getSkm_skill_id() {
                return skm_skill_id;
            }

            public void setSkm_skill_id(String skm_skill_id) {
                this.skm_skill_id = skm_skill_id;
            }

            public String getTeu_testimonial_id() {
                return teu_testimonial_id;
            }

            public void setTeu_testimonial_id(String teu_testimonial_id) {
                this.teu_testimonial_id = teu_testimonial_id;
            }

            public String getTeu_provider_id() {
                return teu_provider_id;
            }

            public void setTeu_provider_id(String teu_provider_id) {
                this.teu_provider_id = teu_provider_id;
            }

            public String getTeu_provider_name() {
                return teu_provider_name;
            }

            public void setTeu_provider_name(String teu_provider_name) {
                this.teu_provider_name = teu_provider_name;
            }

            public String getSkm_name() {
                return skm_name;
            }

            public void setSkm_name(String skm_name) {
                this.skm_name = skm_name;
            }

            public List<EndorsedBy> getEndorsed_by() {
                return endorsed_by;
            }

            public void setEndorsed_by(List<EndorsedBy> endorsed_by) {
                this.endorsed_by = endorsed_by;
            }

            public class EndorsedBy implements Serializable{
               @SerializedName("code")
               @Expose
               private String code;
               @SerializedName("name")
               @Expose
               private String name;

               public String getCode() {
                   return code;
               }

               public void setCode(String code) {
                   this.code = code;
               }

               public String getName() {
                   return name;
               }

               public void setName(String name) {
                   this.name = name;
               }
           }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.skm_skill_id);
                dest.writeString(this.teu_testimonial_id);
                dest.writeString(this.teu_provider_id);
                dest.writeString(this.teu_provider_name);
                dest.writeString(this.skm_name);
                dest.writeList(this.endorsed_by);
            }

            public Skills() {
            }

            protected Skills(Parcel in) {
                this.skm_skill_id = in.readString();
                this.teu_testimonial_id = in.readString();
                this.teu_provider_id = in.readString();
                this.teu_provider_name = in.readString();
                this.skm_name = in.readString();
                this.endorsed_by = new ArrayList<EndorsedBy>();
                in.readList(this.endorsed_by, EndorsedBy.class.getClassLoader());
            }

            public  final Creator<Skills> CREATOR = new Creator<Skills>() {
                @Override
                public Skills createFromParcel(Parcel source) {
                    return new Skills(source);
                }

                @Override
                public Skills[] newArray(int size) {
                    return new Skills[size];
                }
            };
        }

        public class Achievement implements Parcelable {
            @SerializedName("acu_achievement_id")
            @Expose
            private String acu_achievement_id;
            @SerializedName("acu_title")
            @Expose
            private String acu_title;
            @SerializedName("acu_occupation")
            @Expose
            private String acu_occupation;
            @SerializedName("acu_description")
            @Expose
            private String acu_description;
            @SerializedName("acu_provider_name")
            @Expose
            private String acu_provider_name;
            @SerializedName("acu_issued_year")
            @Expose
            private String acu_issued_year;
            @SerializedName("acu_issued_month")
            @Expose
            private String acu_issued_month;
            @SerializedName("issued_year")
            @Expose
            private String issued_year;

            public String getAcu_achievement_id() {
                return acu_achievement_id;
            }

            public void setAcu_achievement_id(String acu_achievement_id) {
                this.acu_achievement_id = acu_achievement_id;
            }

            public String getAcu_title() {
                return acu_title;
            }

            public void setAcu_title(String acu_title) {
                this.acu_title = acu_title;
            }

            public String getAcu_occupation() {
                return acu_occupation;
            }

            public void setAcu_occupation(String acu_occupation) {
                this.acu_occupation = acu_occupation;
            }

            public String getAcu_description() {
                return acu_description;
            }

            public void setAcu_description(String acu_description) {
                this.acu_description = acu_description;
            }

            public String getAcu_provider_name() {
                return acu_provider_name;
            }

            public void setAcu_provider_name(String acu_provider_name) {
                this.acu_provider_name = acu_provider_name;
            }

            public String getAcu_issued_year() {
                return acu_issued_year;
            }

            public void setAcu_issued_year(String acu_issued_year) {
                this.acu_issued_year = acu_issued_year;
            }

            public String getAcu_issued_month() {
                return acu_issued_month;
            }

            public void setAcu_issued_month(String acu_issued_month) {
                this.acu_issued_month = acu_issued_month;
            }

            public String getIssued_year() {
                return issued_year;
            }

            public void setIssued_year(String issued_year) {
                this.issued_year = issued_year;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.acu_achievement_id);
                dest.writeString(this.acu_title);
                dest.writeString(this.acu_occupation);
                dest.writeString(this.acu_description);
                dest.writeString(this.acu_provider_name);
                dest.writeString(this.acu_issued_year);
                dest.writeString(this.acu_issued_month);
                dest.writeString(this.issued_year);
            }

            public Achievement() {
            }

            protected Achievement(Parcel in) {
                this.acu_achievement_id = in.readString();
                this.acu_title = in.readString();
                this.acu_occupation = in.readString();
                this.acu_description = in.readString();
                this.acu_provider_name = in.readString();
                this.acu_issued_year = in.readString();
                this.acu_issued_month = in.readString();
                this.issued_year = in.readString();
            }

            public  final Creator<Achievement> CREATOR = new Creator<Achievement>() {
                @Override
                public Achievement createFromParcel(Parcel source) {
                    return new Achievement(source);
                }

                @Override
                public Achievement[] newArray(int size) {
                    return new Achievement[size];
                }
            };
        }

        public class UserCv implements Parcelable {
            @SerializedName("ucv_cv_id")
            @Expose
            private String ucv_cv_id;
            @SerializedName("ucv_title")
            @Expose
            private String ucv_title;
            @SerializedName("ucv_file_name")
            @Expose
            private String ucv_file_name;
            @SerializedName("ucv_created_on")
            @Expose
            private String ucv_created_on;
            @SerializedName("ucv_type")
            @Expose
            private String ucv_type;
            @SerializedName("ucv_type_name")
            @Expose
            private String ucv_type_name;

            public String getUcv_cv_id() {
                return ucv_cv_id;
            }

            public void setUcv_cv_id(String ucv_cv_id) {
                this.ucv_cv_id = ucv_cv_id;
            }

            public String getUcv_title() {
                return ucv_title;
            }

            public void setUcv_title(String ucv_title) {
                this.ucv_title = ucv_title;
            }

            public String getUcv_file_name() {
                return ucv_file_name;
            }

            public void setUcv_file_name(String ucv_file_name) {
                this.ucv_file_name = ucv_file_name;
            }

            public String getUcv_created_on() {
                return ucv_created_on;
            }

            public void setUcv_created_on(String ucv_created_on) {
                this.ucv_created_on = ucv_created_on;
            }

            public String getUcv_type() {
                return ucv_type;
            }

            public void setUcv_type(String ucv_type) {
                this.ucv_type = ucv_type;
            }

            public String getUcv_type_name() {
                return ucv_type_name;
            }

            public void setUcv_type_name(String ucv_type_name) {
                this.ucv_type_name = ucv_type_name;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.ucv_cv_id);
                dest.writeString(this.ucv_title);
                dest.writeString(this.ucv_file_name);
                dest.writeString(this.ucv_created_on);
                dest.writeString(this.ucv_type);
                dest.writeString(this.ucv_type_name);
            }

            public UserCv() {
            }

            protected UserCv(Parcel in) {
                this.ucv_cv_id = in.readString();
                this.ucv_title = in.readString();
                this.ucv_file_name = in.readString();
                this.ucv_created_on = in.readString();
                this.ucv_type = in.readString();
                this.ucv_type_name = in.readString();
            }

            public  final Creator<UserCv> CREATOR = new Creator<UserCv>() {
                @Override
                public UserCv createFromParcel(Parcel source) {
                    return new UserCv(source);
                }

                @Override
                public UserCv[] newArray(int size) {
                    return new UserCv[size];
                }
            };
        }

        public class TechnicalSkills implements Parcelable {
            @SerializedName("sku_sequence_id")
            @Expose
            private String sku_sequence_id;
            @SerializedName("sku_name")
            @Expose
            private String sku_name;
            @SerializedName("sku_level")
            @Expose
            private String sku_level;

            public String getSku_sequence_id() {
                return sku_sequence_id;
            }

            public void setSku_sequence_id(String sku_sequence_id) {
                this.sku_sequence_id = sku_sequence_id;
            }

            public String getSku_name() {
                return sku_name;
            }

            public void setSku_name(String sku_name) {
                this.sku_name = sku_name;
            }

            public String getSku_level() {
                return sku_level;
            }

            public void setSku_level(String sku_level) {
                this.sku_level = sku_level;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.sku_sequence_id);
                dest.writeString(this.sku_name);
                dest.writeString(this.sku_level);
            }

            public TechnicalSkills() {
            }

            protected TechnicalSkills(Parcel in) {
                this.sku_sequence_id = in.readString();
                this.sku_name = in.readString();
                this.sku_level = in.readString();
            }

            public final Creator<TechnicalSkills> CREATOR = new Creator<TechnicalSkills>() {
                @Override
                public TechnicalSkills createFromParcel(Parcel source) {
                    return new TechnicalSkills(source);
                }

                @Override
                public TechnicalSkills[] newArray(int size) {
                    return new TechnicalSkills[size];
                }
            };
        }

        public class Interests implements Parcelable {
            @SerializedName("inu_interest_id")
            @Expose
            private String inu_interest_id;
            @SerializedName("inu_name")
            @Expose
            private String inu_name;

            public String getInu_interest_id() {
                return inu_interest_id;
            }

            public void setInu_interest_id(String inu_interest_id) {
                this.inu_interest_id = inu_interest_id;
            }

            public String getInu_name() {
                return inu_name;
            }

            public void setInu_name(String inu_name) {
                this.inu_name = inu_name;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.inu_interest_id);
                dest.writeString(this.inu_name);
            }

            public Interests() {
            }

            protected Interests(Parcel in) {
                this.inu_interest_id = in.readString();
                this.inu_name = in.readString();
            }

            public  final Creator<Interests> CREATOR = new Creator<Interests>() {
                @Override
                public Interests createFromParcel(Parcel source) {
                    return new Interests(source);
                }

                @Override
                public Interests[] newArray(int size) {
                    return new Interests[size];
                }
            };
        }

        public class Language implements Parcelable {
            @SerializedName("lau_sequence_id")
            @Expose
            private String lau_sequence_id;
            @SerializedName("lau_lam_language_id")
            @Expose
            private String lau_lam_language_id;
            @SerializedName("lam_name")
            @Expose
            private String lam_name;

            public String getLau_sequence_id() {
                return lau_sequence_id;
            }

            public void setLau_sequence_id(String lau_sequence_id) {
                this.lau_sequence_id = lau_sequence_id;
            }

            public String getLau_lam_language_id() {
                return lau_lam_language_id;
            }

            public void setLau_lam_language_id(String lau_lam_language_id) {
                this.lau_lam_language_id = lau_lam_language_id;
            }

            public String getLam_name() {
                return lam_name;
            }

            public void setLam_name(String lam_name) {
                this.lam_name = lam_name;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.lau_sequence_id);
                dest.writeString(this.lau_lam_language_id);
                dest.writeString(this.lam_name);
            }

            public Language() {
            }

            protected Language(Parcel in) {
                this.lau_sequence_id = in.readString();
                this.lau_lam_language_id = in.readString();
                this.lam_name = in.readString();
            }

            public  final Creator<Language> CREATOR = new Creator<Language>() {
                @Override
                public Language createFromParcel(Parcel source) {
                    return new Language(source);
                }

                @Override
                public Language[] newArray(int size) {
                    return new Language[size];
                }
            };
        }

        public class UserSetting implements Parcelable {
            @SerializedName("ust_setting_id")
            @Expose
            private String ust_setting_id;
            @SerializedName("ust_um_user_id")
            @Expose
            private String ust_um_user_id;
            @SerializedName("ust_info")
            @Expose
            private String ust_info;
            @SerializedName("ust_gallery")
            @Expose
            private String ust_gallery;
            @SerializedName("ust_testimonial")
            @Expose
            private String ust_testimonial;
            @SerializedName("ust_experience")
            @Expose
            private String ust_experience;
            @SerializedName("ust_education")
            @Expose
            private String ust_education;
            @SerializedName("ust_volunteering")
            @Expose
            private String ust_volunteering;
            @SerializedName("ust_skills")
            @Expose
            private String ust_skills;
            @SerializedName("ust_achievements")
            @Expose
            private String ust_achievements;
            @SerializedName("ust_cv")
            @Expose
            private String ust_cv;
            @SerializedName("yth_gender_name")
            @Expose
            private String ust_technical_skills;
            @SerializedName("ust_interests")
            @Expose
            private String ust_interests;
            @SerializedName("ust_languages")
            @Expose
            private String ust_languages;
            @SerializedName("ust_created_by")
            @Expose
            private String ust_created_by;
            @SerializedName("ust_created_on")
            @Expose
            private String ust_created_on;
            @SerializedName("ust_updated_by")
            @Expose
            private String ust_updated_by;
            @SerializedName("ust_updated_on")
            @Expose
            private String ust_updated_on;
            @SerializedName("ust_active")
            @Expose
            private String ust_active;

            public String getUst_setting_id() {
                return ust_setting_id;
            }

            public void setUst_setting_id(String ust_setting_id) {
                this.ust_setting_id = ust_setting_id;
            }

            public String getUst_um_user_id() {
                return ust_um_user_id;
            }

            public void setUst_um_user_id(String ust_um_user_id) {
                this.ust_um_user_id = ust_um_user_id;
            }

            public String getUst_info() {
                return ust_info;
            }

            public void setUst_info(String ust_info) {
                this.ust_info = ust_info;
            }

            public String getUst_gallery() {
                return ust_gallery;
            }

            public void setUst_gallery(String ust_gallery) {
                this.ust_gallery = ust_gallery;
            }

            public String getUst_testimonial() {
                return ust_testimonial;
            }

            public void setUst_testimonial(String ust_testimonial) {
                this.ust_testimonial = ust_testimonial;
            }

            public String getUst_experience() {
                return ust_experience;
            }

            public void setUst_experience(String ust_experience) {
                this.ust_experience = ust_experience;
            }

            public String getUst_education() {
                return ust_education;
            }

            public void setUst_education(String ust_education) {
                this.ust_education = ust_education;
            }

            public String getUst_volunteering() {
                return ust_volunteering;
            }

            public void setUst_volunteering(String ust_volunteering) {
                this.ust_volunteering = ust_volunteering;
            }

            public String getUst_skills() {
                return ust_skills;
            }

            public void setUst_skills(String ust_skills) {
                this.ust_skills = ust_skills;
            }

            public String getUst_achievements() {
                return ust_achievements;
            }

            public void setUst_achievements(String ust_achievements) {
                this.ust_achievements = ust_achievements;
            }

            public String getUst_cv() {
                return ust_cv;
            }

            public void setUst_cv(String ust_cv) {
                this.ust_cv = ust_cv;
            }

            public String getUst_technical_skills() {
                return ust_technical_skills;
            }

            public void setUst_technical_skills(String ust_technical_skills) {
                this.ust_technical_skills = ust_technical_skills;
            }

            public String getUst_interests() {
                return ust_interests;
            }

            public void setUst_interests(String ust_interests) {
                this.ust_interests = ust_interests;
            }

            public String getUst_languages() {
                return ust_languages;
            }

            public void setUst_languages(String ust_languages) {
                this.ust_languages = ust_languages;
            }

            public String getUst_created_by() {
                return ust_created_by;
            }

            public void setUst_created_by(String ust_created_by) {
                this.ust_created_by = ust_created_by;
            }

            public String getUst_created_on() {
                return ust_created_on;
            }

            public void setUst_created_on(String ust_created_on) {
                this.ust_created_on = ust_created_on;
            }

            public String getUst_updated_by() {
                return ust_updated_by;
            }

            public void setUst_updated_by(String ust_updated_by) {
                this.ust_updated_by = ust_updated_by;
            }

            public String getUst_updated_on() {
                return ust_updated_on;
            }

            public void setUst_updated_on(String ust_updated_on) {
                this.ust_updated_on = ust_updated_on;
            }

            public String getUst_active() {
                return ust_active;
            }

            public void setUst_active(String ust_active) {
                this.ust_active = ust_active;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.ust_setting_id);
                dest.writeString(this.ust_um_user_id);
                dest.writeString(this.ust_info);
                dest.writeString(this.ust_gallery);
                dest.writeString(this.ust_testimonial);
                dest.writeString(this.ust_experience);
                dest.writeString(this.ust_education);
                dest.writeString(this.ust_volunteering);
                dest.writeString(this.ust_skills);
                dest.writeString(this.ust_achievements);
                dest.writeString(this.ust_cv);
                dest.writeString(this.ust_technical_skills);
                dest.writeString(this.ust_interests);
                dest.writeString(this.ust_languages);
                dest.writeString(this.ust_created_by);
                dest.writeString(this.ust_created_on);
                dest.writeString(this.ust_updated_by);
                dest.writeString(this.ust_updated_on);
                dest.writeString(this.ust_active);
            }

            public UserSetting() {
            }

            protected UserSetting(Parcel in) {
                this.ust_setting_id = in.readString();
                this.ust_um_user_id = in.readString();
                this.ust_info = in.readString();
                this.ust_gallery = in.readString();
                this.ust_testimonial = in.readString();
                this.ust_experience = in.readString();
                this.ust_education = in.readString();
                this.ust_volunteering = in.readString();
                this.ust_skills = in.readString();
                this.ust_achievements = in.readString();
                this.ust_cv = in.readString();
                this.ust_technical_skills = in.readString();
                this.ust_interests = in.readString();
                this.ust_languages = in.readString();
                this.ust_created_by = in.readString();
                this.ust_created_on = in.readString();
                this.ust_updated_by = in.readString();
                this.ust_updated_on = in.readString();
                this.ust_active = in.readString();
            }

            public  final Creator<UserSetting> CREATOR = new Creator<UserSetting>() {
                @Override
                public UserSetting createFromParcel(Parcel source) {
                    return new UserSetting(source);
                }

                @Override
                public UserSetting[] newArray(int size) {
                    return new UserSetting[size];
                }
            };
        }

        public class ProfileInfo implements Parcelable {
            @SerializedName("yth_gender_name")
            @Expose
            private String yth_gender_name;
            @SerializedName("region_name")
            @Expose
            private String region_name;
            @SerializedName("city_name")
            @Expose
            private String city_name;
            @SerializedName("intended_destination_name")
            @Expose
            private String intended_destination_name;

            public String getYth_gender_name() {
                return yth_gender_name;
            }

            public void setYth_gender_name(String yth_gender_name) {
                this.yth_gender_name = yth_gender_name;
            }

            public String getRegion_name() {
                return region_name;
            }

            public void setRegion_name(String region_name) {
                this.region_name = region_name;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getIntended_destination_name() {
                return intended_destination_name;
            }

            public void setIntended_destination_name(String intended_destination_name) {
                this.intended_destination_name = intended_destination_name;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.yth_gender_name);
                dest.writeString(this.region_name);
                dest.writeString(this.city_name);
                dest.writeString(this.intended_destination_name);
            }

            public ProfileInfo() {
            }

            protected ProfileInfo(Parcel in) {
                this.yth_gender_name = in.readString();
                this.region_name = in.readString();
                this.city_name = in.readString();
                this.intended_destination_name = in.readString();
            }

            public  final Creator<ProfileInfo> CREATOR = new Creator<ProfileInfo>() {
                @Override
                public ProfileInfo createFromParcel(Parcel source) {
                    return new ProfileInfo(source);
                }

                @Override
                public ProfileInfo[] newArray(int size) {
                    return new ProfileInfo[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.login_user_id);
            dest.writeString(this.profile_user_id);
            dest.writeString(this.profile_user_type);
            dest.writeString(this.user_medium_path);
            dest.writeString(this.user_thumbnail_path);
            dest.writeString(this.user_cover_path);
            dest.writeString(this.cv_path);
            dest.writeParcelable(this.profile_info, flags);
            dest.writeParcelable(this.user_settings, flags);
            dest.writeList(this.language);
            dest.writeList(this.interests);
            dest.writeList(this.technical_skills);
            dest.writeList(this.user_cv);
            dest.writeList(this.achievement);
            dest.writeList(this.skills);
            dest.writeList(this.volunteering);
            dest.writeList(this.education);
            dest.writeList(this.experience);
            dest.writeList(this.testimonials);
            dest.writeList(this.job_wishlist);
            dest.writeParcelable(this.workinfo, flags);
        }

        public ProfileYouthData() {
        }

        protected ProfileYouthData(Parcel in) {
            this.login_user_id = in.readString();
            this.profile_user_id = in.readString();
            this.profile_user_type = in.readString();
            this.user_medium_path = in.readString();
            this.user_thumbnail_path = in.readString();
            this.user_cover_path = in.readString();
            this.cv_path = in.readString();
            this.profile_info = in.readParcelable(ProfileInfo.class.getClassLoader());
            this.user_settings = in.readParcelable(UserSetting.class.getClassLoader());
            this.language = new ArrayList<Language>();
            in.readList(this.language, Language.class.getClassLoader());
            this.interests = new ArrayList<Interests>();
            in.readList(this.interests, Interests.class.getClassLoader());
            this.technical_skills = new ArrayList<TechnicalSkills>();
            in.readList(this.technical_skills, TechnicalSkills.class.getClassLoader());
            this.user_cv = new ArrayList<UserCv>();
            in.readList(this.user_cv, UserCv.class.getClassLoader());
            this.achievement = new ArrayList<Achievement>();
            in.readList(this.achievement, Achievement.class.getClassLoader());
            this.skills = new ArrayList<Skills>();
            in.readList(this.skills, Skills.class.getClassLoader());
            this.volunteering = new ArrayList<Volunteering>();
            in.readList(this.volunteering, Volunteering.class.getClassLoader());
            this.education = new ArrayList<Education>();
            in.readList(this.education, Education.class.getClassLoader());
            this.experience = new ArrayList<Experience>();
            in.readList(this.experience, Experience.class.getClassLoader());
            this.testimonials = new ArrayList<Testimonials>();
            in.readList(this.testimonials, Testimonials.class.getClassLoader());
            this.job_wishlist = new ArrayList<JobWishlist>();
            in.readList(this.job_wishlist, JobWishlist.class.getClassLoader());
            this.workinfo = in.readParcelable(WorkInfo.class.getClassLoader());
        }

        public  final Creator<ProfileYouthData> CREATOR = new Creator<ProfileYouthData>() {
            @Override
            public ProfileYouthData createFromParcel(Parcel source) {
                return new ProfileYouthData(source);
            }

            @Override
            public ProfileYouthData[] newArray(int size) {
                return new ProfileYouthData[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.status);
        dest.writeParcelable(this.data, flags);
        dest.writeString(this.message);
    }

    protected ProfileYouthInfoResponse(Parcel in) {
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.data = in.readParcelable(ProfileYouthData.class.getClassLoader());
        this.message = in.readString();
    }

    public  final Parcelable.Creator<ProfileYouthInfoResponse> CREATOR = new Parcelable.Creator<ProfileYouthInfoResponse>() {
        @Override
        public ProfileYouthInfoResponse createFromParcel(Parcel source) {
            return new ProfileYouthInfoResponse(source);
        }

        @Override
        public ProfileYouthInfoResponse[] newArray(int size) {
            return new ProfileYouthInfoResponse[size];
        }
    };
}
