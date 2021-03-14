package com.example.youthhub.resModel.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProfileInfoMaster implements Serializable {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data implements Serializable{

        @SerializedName("login_user_id")
        @Expose
        private String login_user_id;
        @SerializedName("profile_user_id")
        @Expose
        private String profile_user_id;
        @SerializedName("profile_user_type")
        @Expose
        private String profile_user_type;
        @SerializedName("workinfo_tooltip")
        @Expose
        private String workinfo_tooltip;
        @SerializedName("communications_tooltip")
        @Expose
        private String communications_tooltip;
        @SerializedName("licence_type")
        @Expose
        private List<LicenseType> licence_type;
        @SerializedName("intended_destination")
        @Expose
        private List<IntendedDestination> intended_destination;
        @SerializedName("city_list")
        @Expose
        private List<CityList> city_list;
        @SerializedName("region_list")
        @Expose
        private List<RegionList> region_list;
        @SerializedName("location_iwi")
        @Expose
        private List<LocationIwi> location_iwi;
        @SerializedName("location_ethnicity")
        @Expose
        private List<LocationEthnicity> location_ethnicity;
        @SerializedName("organisation_data")
        @Expose
        private List<OrganisationData> organisation_data;
        @SerializedName("visa_type_master")
        @Expose
        private List<VisaTypeMaster> visa_type_master;
        @SerializedName("residency_status_master")
        @Expose
        private List<ResidencyStatusMaster> residency_status_master;
        @SerializedName("work_experience_master")
        @Expose
        private List<WorkExperienceMaster> work_experience_master;
        @SerializedName("work_availability_timing_master")
        @Expose
        private List<WorkAvailabilityTimingMaster> work_availability_timing_master;
        @SerializedName("work_status_master")
        @Expose
        private List<workStatusMaster> work_status_master;
        @SerializedName("gender_master")
        @Expose
        private List<GenderMaster> gender_master;
        @SerializedName("youth_info")
        @Expose
        private YouthInfo youth_info;

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

        public String getWorkinfo_tooltip() {
            return workinfo_tooltip;
        }

        public void setWorkinfo_tooltip(String workinfo_tooltip) {
            this.workinfo_tooltip = workinfo_tooltip;
        }

        public String getCommunications_tooltip() {
            return communications_tooltip;
        }

        public void setCommunications_tooltip(String communications_tooltip) {
            this.communications_tooltip = communications_tooltip;
        }

        public List<LicenseType> getLicence_type() {
            return licence_type;
        }

        public void setLicence_type(List<LicenseType> licence_type) {
            this.licence_type = licence_type;
        }

        public List<IntendedDestination> getIntended_destination() {
            return intended_destination;
        }

        public void setIntended_destination(List<IntendedDestination> intended_destination) {
            this.intended_destination = intended_destination;
        }

        public List<CityList> getCity_list() {
            return city_list;
        }

        public void setCity_list(List<CityList> city_list) {
            this.city_list = city_list;
        }

        public List<RegionList> getRegion_list() {
            return region_list;
        }

        public void setRegion_list(List<RegionList> region_list) {
            this.region_list = region_list;
        }

        public List<LocationIwi> getLocation_iwi() {
            return location_iwi;
        }

        public void setLocation_iwi(List<LocationIwi> location_iwi) {
            this.location_iwi = location_iwi;
        }

        public List<LocationEthnicity> getLocation_ethnicity() {
            return location_ethnicity;
        }

        public void setLocation_ethnicity(List<LocationEthnicity> location_ethnicity) {
            this.location_ethnicity = location_ethnicity;
        }

        public List<OrganisationData> getOrganisation_data() {
            return organisation_data;
        }

        public void setOrganisation_data(List<OrganisationData> organisation_data) {
            this.organisation_data = organisation_data;
        }

        public List<VisaTypeMaster> getVisa_type_master() {
            return visa_type_master;
        }

        public void setVisa_type_master(List<VisaTypeMaster> visa_type_master) {
            this.visa_type_master = visa_type_master;
        }

        public List<ResidencyStatusMaster> getResidency_status_master() {
            return residency_status_master;
        }

        public void setResidency_status_master(List<ResidencyStatusMaster> residency_status_master) {
            this.residency_status_master = residency_status_master;
        }

        public List<WorkExperienceMaster> getWork_experience_master() {
            return work_experience_master;
        }

        public void setWork_experience_master(List<WorkExperienceMaster> work_experience_master) {
            this.work_experience_master = work_experience_master;
        }

        public List<WorkAvailabilityTimingMaster> getWork_availability_timing_master() {
            return work_availability_timing_master;
        }

        public void setWork_availability_timing_master(List<WorkAvailabilityTimingMaster> work_availability_timing_master) {
            this.work_availability_timing_master = work_availability_timing_master;
        }

        public List<workStatusMaster> getWork_status_master() {
            return work_status_master;
        }

        public void setWork_status_master(List<workStatusMaster> work_status_master) {
            this.work_status_master = work_status_master;
        }

        public List<GenderMaster> getGender_master() {
            return gender_master;
        }

        public void setGender_master(List<GenderMaster> gender_master) {
            this.gender_master = gender_master;
        }

        public YouthInfo getYouth_info() {
            return youth_info;
        }

        public void setYouth_info(YouthInfo youth_info) {
            this.youth_info = youth_info;
        }

        public class YouthInfo implements Serializable {
            @SerializedName("yth_youth_id")
            @Expose
            private String yth_youth_id;
            @SerializedName("yth_first_name")
            @Expose
            private String yth_first_name;
            @SerializedName("yth_last_name")
            @Expose
            private String yth_last_name;
            @SerializedName("yth_dob")
            @Expose
            private String yth_dob;@SerializedName("yth_gender")
            @Expose
            private String yth_gender;
            @SerializedName("yth_full_description")
            @Expose
            private String yth_full_description;
            @SerializedName("yth_current_status")
            @Expose
            private String yth_current_status;@SerializedName("yth_region")
            @Expose
            private String yth_region;
            @SerializedName("yth_city")
            @Expose
            private String yth_city;@SerializedName("yth_suburb")
            @Expose
            private String yth_suburb;@SerializedName("yth_ogm_organisation_id")
            @Expose
            private String yth_ogm_organisation_id;
            @SerializedName("ogm_name")
            @Expose
            private String ogm_name;
            @SerializedName("yth_ethnicity")
            @Expose
            private String yth_ethnicity;
            @SerializedName("yth_ethnicity_name")
            @Expose
            private String yth_ethnicity_name;
            @SerializedName("yth_iwi")
            @Expose
            private String yth_iwi;
            @SerializedName("iw_name")
            @Expose
            private String iw_name;
            @SerializedName("yth_contact_email")
            @Expose
            private String yth_contact_email;@SerializedName("yth_mobile_no")
            @Expose
            private String yth_mobile_no;
            @SerializedName("yth_work_status")
            @Expose
            private String yth_work_status;
            @SerializedName("ind_des_name")
            @Expose
            private String ind_des_name;@SerializedName("yth_work_availability_timing")
            @Expose
            private String yth_work_availability_timing;
            @SerializedName("yth_work_availability_hour")
            @Expose
            private String yth_work_availability_hour;
            @SerializedName("yth_work_experience")
            @Expose
            private String yth_work_experience;@SerializedName("yth_work_preferred_region")
            @Expose
            private String yth_work_preferred_region;
            @SerializedName("yth_work_preferred_district")
            @Expose
            private String yth_work_preferred_district;
            @SerializedName("yth_intended_destination")
            @Expose
            private String yth_intended_destination;@SerializedName("yth_lt_type_id")
            @Expose
            private String yth_lt_type_id;@SerializedName("licence_type")
            @Expose
            private String licence_type;@SerializedName("yth_residency_type")
            @Expose
            private String yth_residency_type;
            @SerializedName("yth_visa_type")
            @Expose
            private String yth_visa_type;
            @SerializedName("yth_visa_expire_month")
            @Expose
            private String yth_visa_expire_month;@SerializedName("yth_visa_expire_year")
            @Expose
            private String yth_visa_expire_year;
            @SerializedName("slu_facebook")
            @Expose
            private String slu_facebook;@SerializedName("slu_twitter")
            @Expose
            private String slu_twitter;@SerializedName("slu_instagram")
            @Expose
            private String slu_instagram;
            @SerializedName("slu_google_plus")
            @Expose
            private String slu_google_plus;
            @SerializedName("slu_behance")
            @Expose
            private String slu_behance;
            @SerializedName("slu_linkedin")
            @Expose
            private String slu_linkedin;
            @SerializedName("slu_github")
            @Expose
            private String slu_github;@SerializedName("region_name")
            @Expose
            private String region_name;@SerializedName("city_name")
            @Expose
            private String city_name;@SerializedName("suburb_name")
            @Expose
            private String suburb_name;@SerializedName("preferred_region_name")
            @Expose
            private String preferred_region_name;
            @SerializedName("preferred_city_name")
            @Expose
            private String preferred_city_name;
            @SerializedName("yth_gender_name")
            @Expose
            private String yth_gender_name;
            @SerializedName("yth_work_status_name")
            @Expose
            private String yth_work_status_name;@SerializedName("yth_work_availability_timing_name")
            @Expose
            private String yth_work_availability_timing_name;
            @SerializedName("yth_work_experience_name")
            @Expose
            private String yth_work_experience_name;
            @SerializedName("yth_residency_type_name")
            @Expose
            private String yth_residency_type_name;
            @SerializedName("yth_visa_type_name")
            @Expose
            private String yth_visa_type_name;

            public String getYth_youth_id() {
                return yth_youth_id;
            }

            public void setYth_youth_id(String yth_youth_id) {
                this.yth_youth_id = yth_youth_id;
            }

            public String getYth_first_name() {
                return yth_first_name;
            }

            public void setYth_first_name(String yth_first_name) {
                this.yth_first_name = yth_first_name;
            }

            public String getYth_last_name() {
                return yth_last_name;
            }

            public void setYth_last_name(String yth_last_name) {
                this.yth_last_name = yth_last_name;
            }

            public String getYth_dob() {
                return yth_dob;
            }

            public void setYth_dob(String yth_dob) {
                this.yth_dob = yth_dob;
            }

            public String getYth_gender() {
                return yth_gender;
            }

            public void setYth_gender(String yth_gender) {
                this.yth_gender = yth_gender;
            }

            public String getYth_full_description() {
                return yth_full_description;
            }

            public void setYth_full_description(String yth_full_description) {
                this.yth_full_description = yth_full_description;
            }

            public String getYth_current_status() {
                return yth_current_status;
            }

            public void setYth_current_status(String yth_current_status) {
                this.yth_current_status = yth_current_status;
            }

            public String getYth_region() {
                return yth_region;
            }

            public void setYth_region(String yth_region) {
                this.yth_region = yth_region;
            }

            public String getYth_city() {
                return yth_city;
            }

            public void setYth_city(String yth_city) {
                this.yth_city = yth_city;
            }

            public String getYth_suburb() {
                return yth_suburb;
            }

            public void setYth_suburb(String yth_suburb) {
                this.yth_suburb = yth_suburb;
            }

            public String getYth_ogm_organisation_id() {
                return yth_ogm_organisation_id;
            }

            public void setYth_ogm_organisation_id(String yth_ogm_organisation_id) {
                this.yth_ogm_organisation_id = yth_ogm_organisation_id;
            }

            public String getOgm_name() {
                return ogm_name;
            }

            public void setOgm_name(String ogm_name) {
                this.ogm_name = ogm_name;
            }

            public String getYth_ethnicity() {
                return yth_ethnicity;
            }

            public void setYth_ethnicity(String yth_ethnicity) {
                this.yth_ethnicity = yth_ethnicity;
            }

            public String getYth_ethnicity_name() {
                return yth_ethnicity_name;
            }

            public void setYth_ethnicity_name(String yth_ethnicity_name) {
                this.yth_ethnicity_name = yth_ethnicity_name;
            }

            public String getYth_iwi() {
                return yth_iwi;
            }

            public void setYth_iwi(String yth_iwi) {
                this.yth_iwi = yth_iwi;
            }

            public String getIw_name() {
                return iw_name;
            }

            public void setIw_name(String iw_name) {
                this.iw_name = iw_name;
            }

            public String getYth_contact_email() {
                return yth_contact_email;
            }

            public void setYth_contact_email(String yth_contact_email) {
                this.yth_contact_email = yth_contact_email;
            }

            public String getYth_mobile_no() {
                return yth_mobile_no;
            }

            public void setYth_mobile_no(String yth_mobile_no) {
                this.yth_mobile_no = yth_mobile_no;
            }

            public String getYth_work_status() {
                return yth_work_status;
            }

            public void setYth_work_status(String yth_work_status) {
                this.yth_work_status = yth_work_status;
            }

            public String getInd_des_name() {
                return ind_des_name;
            }

            public void setInd_des_name(String ind_des_name) {
                this.ind_des_name = ind_des_name;
            }

            public String getYth_work_availability_timing() {
                return yth_work_availability_timing;
            }

            public void setYth_work_availability_timing(String yth_work_availability_timing) {
                this.yth_work_availability_timing = yth_work_availability_timing;
            }

            public String getYth_work_availability_hour() {
                return yth_work_availability_hour;
            }

            public void setYth_work_availability_hour(String yth_work_availability_hour) {
                this.yth_work_availability_hour = yth_work_availability_hour;
            }

            public String getYth_work_experience() {
                return yth_work_experience;
            }

            public void setYth_work_experience(String yth_work_experience) {
                this.yth_work_experience = yth_work_experience;
            }

            public String getYth_work_preferred_region() {
                return yth_work_preferred_region;
            }

            public void setYth_work_preferred_region(String yth_work_preferred_region) {
                this.yth_work_preferred_region = yth_work_preferred_region;
            }

            public String getYth_work_preferred_district() {
                return yth_work_preferred_district;
            }

            public void setYth_work_preferred_district(String yth_work_preferred_district) {
                this.yth_work_preferred_district = yth_work_preferred_district;
            }

            public String getYth_intended_destination() {
                return yth_intended_destination;
            }

            public void setYth_intended_destination(String yth_intended_destination) {
                this.yth_intended_destination = yth_intended_destination;
            }

            public String getYth_lt_type_id() {
                return yth_lt_type_id;
            }

            public void setYth_lt_type_id(String yth_lt_type_id) {
                this.yth_lt_type_id = yth_lt_type_id;
            }

            public String getLicence_type() {
                return licence_type;
            }

            public void setLicence_type(String licence_type) {
                this.licence_type = licence_type;
            }

            public String getYth_residency_type() {
                return yth_residency_type;
            }

            public void setYth_residency_type(String yth_residency_type) {
                this.yth_residency_type = yth_residency_type;
            }

            public String getYth_visa_type() {
                return yth_visa_type;
            }

            public void setYth_visa_type(String yth_visa_type) {
                this.yth_visa_type = yth_visa_type;
            }

            public String getYth_visa_expire_month() {
                return yth_visa_expire_month;
            }

            public void setYth_visa_expire_month(String yth_visa_expire_month) {
                this.yth_visa_expire_month = yth_visa_expire_month;
            }

            public String getYth_visa_expire_year() {
                return yth_visa_expire_year;
            }

            public void setYth_visa_expire_year(String yth_visa_expire_year) {
                this.yth_visa_expire_year = yth_visa_expire_year;
            }

            public String getSlu_facebook() {
                return slu_facebook;
            }

            public void setSlu_facebook(String slu_facebook) {
                this.slu_facebook = slu_facebook;
            }

            public String getSlu_twitter() {
                return slu_twitter;
            }

            public void setSlu_twitter(String slu_twitter) {
                this.slu_twitter = slu_twitter;
            }

            public String getSlu_instagram() {
                return slu_instagram;
            }

            public void setSlu_instagram(String slu_instagram) {
                this.slu_instagram = slu_instagram;
            }

            public String getSlu_google_plus() {
                return slu_google_plus;
            }

            public void setSlu_google_plus(String slu_google_plus) {
                this.slu_google_plus = slu_google_plus;
            }

            public String getSlu_behance() {
                return slu_behance;
            }

            public void setSlu_behance(String slu_behance) {
                this.slu_behance = slu_behance;
            }

            public String getSlu_linkedin() {
                return slu_linkedin;
            }

            public void setSlu_linkedin(String slu_linkedin) {
                this.slu_linkedin = slu_linkedin;
            }

            public String getSlu_github() {
                return slu_github;
            }

            public void setSlu_github(String slu_github) {
                this.slu_github = slu_github;
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

            public String getSuburb_name() {
                return suburb_name;
            }

            public void setSuburb_name(String suburb_name) {
                this.suburb_name = suburb_name;
            }

            public String getPreferred_region_name() {
                return preferred_region_name;
            }

            public void setPreferred_region_name(String preferred_region_name) {
                this.preferred_region_name = preferred_region_name;
            }

            public String getPreferred_city_name() {
                return preferred_city_name;
            }

            public void setPreferred_city_name(String preferred_city_name) {
                this.preferred_city_name = preferred_city_name;
            }

            public String getYth_gender_name() {
                return yth_gender_name;
            }

            public void setYth_gender_name(String yth_gender_name) {
                this.yth_gender_name = yth_gender_name;
            }

            public String getYth_work_status_name() {
                return yth_work_status_name;
            }

            public void setYth_work_status_name(String yth_work_status_name) {
                this.yth_work_status_name = yth_work_status_name;
            }

            public String getYth_work_availability_timing_name() {
                return yth_work_availability_timing_name;
            }

            public void setYth_work_availability_timing_name(String yth_work_availability_timing_name) {
                this.yth_work_availability_timing_name = yth_work_availability_timing_name;
            }

            public String getYth_work_experience_name() {
                return yth_work_experience_name;
            }

            public void setYth_work_experience_name(String yth_work_experience_name) {
                this.yth_work_experience_name = yth_work_experience_name;
            }

            public String getYth_residency_type_name() {
                return yth_residency_type_name;
            }

            public void setYth_residency_type_name(String yth_residency_type_name) {
                this.yth_residency_type_name = yth_residency_type_name;
            }

            public String getYth_visa_type_name() {
                return yth_visa_type_name;
            }

            public void setYth_visa_type_name(String yth_visa_type_name) {
                this.yth_visa_type_name = yth_visa_type_name;
            }
        }

        public class GenderMaster implements Serializable {
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public class workStatusMaster implements Serializable {
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        public class WorkAvailabilityTimingMaster implements Serializable {
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public class WorkExperienceMaster implements Serializable {
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public class ResidencyStatusMaster implements Serializable {
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public class VisaTypeMaster implements Serializable {
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public class OrganisationData implements Serializable {
            @SerializedName("ogm_organisation_id")
            @Expose
            private String ogm_organisation_id;
            @SerializedName("ogm_name")
            @Expose
            private String ogm_name;

            public String getOgm_organisation_id() {
                return ogm_organisation_id;
            }

            public void setOgm_organisation_id(String ogm_organisation_id) {
                this.ogm_organisation_id = ogm_organisation_id;
            }

            public String getOgm_name() {
                return ogm_name;
            }

            public void setOgm_name(String ogm_name) {
                this.ogm_name = ogm_name;
            }
        }

        public class LocationEthnicity implements Serializable {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;          @SerializedName("subethnicity")
            @Expose
            private Subethnicity subethnicity;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Subethnicity getSubethnicity() {
                return subethnicity;
            }

            public void setSubethnicity(Subethnicity subethnicity) {
                this.subethnicity = subethnicity;
            }

            public class Subethnicity implements Serializable{
                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("subsubethnicity")
                @Expose
                private List<Subsubethnicity> subsubethnicity;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<Subsubethnicity> getSubsubethnicity() {
                    return subsubethnicity;
                }

                public void setSubsubethnicity(List<Subsubethnicity> subsubethnicity) {
                    this.subsubethnicity = subsubethnicity;
                }

                public class Subsubethnicity implements Serializable{
                    @SerializedName("id")
                    @Expose
                    private String id;
                    @SerializedName("name")
                    @Expose
                    private String name;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }


        }

        public class LocationIwi implements Serializable {
            @SerializedName("iw_iwi_id")
            @Expose
            private String iw_iwi_id;
            @SerializedName("iw_name")
            @Expose
            private String iw_name;

            public String getIw_iwi_id() {
                return iw_iwi_id;
            }

            public void setIw_iwi_id(String iw_iwi_id) {
                this.iw_iwi_id = iw_iwi_id;
            }

            public String getIw_name() {
                return iw_name;
            }

            public void setIw_name(String iw_name) {
                this.iw_name = iw_name;
            }
        }

        public class RegionList implements Serializable {
            @SerializedName("re_region_id")
            @Expose
            private String re_region_id;
            @SerializedName("re_name")
            @Expose
            private String re_name;

            public String getRe_region_id() {
                return re_region_id;
            }

            public void setRe_region_id(String re_region_id) {
                this.re_region_id = re_region_id;
            }

            public String getRe_name() {
                return re_name;
            }

            public void setRe_name(String re_name) {
                this.re_name = re_name;
            }
        }

        public class CityList implements Serializable {
            @SerializedName("ci_city_id")
            @Expose
            private String ci_city_id;
            @SerializedName("ci_name")
            @Expose
            private String ci_name;

            public String getCi_city_id() {
                return ci_city_id;
            }

            public void setCi_city_id(String ci_city_id) {
                this.ci_city_id = ci_city_id;
            }

            public String getCi_name() {
                return ci_name;
            }

            public void setCi_name(String ci_name) {
                this.ci_name = ci_name;
            }
        }
        public class IntendedDestination implements Serializable {
            @SerializedName("sm_status_id")
            @Expose
            private String sm_status_id;
            @SerializedName("sm_name")
            @Expose
            private String sm_name;

            public String getSm_status_id() {
                return sm_status_id;
            }

            public void setSm_status_id(String sm_status_id) {
                this.sm_status_id = sm_status_id;
            }

            public String getSm_name() {
                return sm_name;
            }

            public void setSm_name(String sm_name) {
                this.sm_name = sm_name;
            }
        }
        public class LicenseType implements Serializable{
            @SerializedName("lt_type_id")
            @Expose
            private String lt_type_id;
            @SerializedName("lt_name")
            @Expose
            private String lt_name;

            public String getLt_type_id() {
                return lt_type_id;
            }

            public void setLt_type_id(String lt_type_id) {
                this.lt_type_id = lt_type_id;
            }

            public String getLt_name() {
                return lt_name;
            }

            public void setLt_name(String lt_name) {
                this.lt_name = lt_name;
            }
        }


    }
}
