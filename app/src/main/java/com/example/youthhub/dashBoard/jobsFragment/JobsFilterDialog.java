package com.example.youthhub.dashBoard.jobsFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.jobs.listmaster.JobCategory;
import com.example.youthhub.resModel.jobs.listmaster.JobCitylist;
import com.example.youthhub.resModel.jobs.listmaster.JobListMaster;
import com.example.youthhub.resModel.jobs.listmaster.JobRegionslist;
import com.example.youthhub.resModel.jobs.listmaster.JobSalaryForHr;
import com.example.youthhub.resModel.jobs.listmaster.JobSalaryForYr;
import com.example.youthhub.resModel.jobs.listmaster.JobSalaryType;
import com.example.youthhub.resModel.jobs.listmaster.JobSubcategory;
import com.example.youthhub.resModel.jobs.listmaster.JobType;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.dashBoard.dashboard.PostImagesAdapter.TAG;

public class JobsFilterDialog extends Dialog {

    @BindView(R.id.filters_title)
    TextView filtersTitle;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.category_textview)
    TextView categoryTextview;
    @BindView(R.id.sub_category_textview)
    TextView subCategoryTextview;
    @BindView(R.id.category)
    AppCompatSpinner category;
    @BindView(R.id.sub_category)
    AppCompatSpinner subCategory;
    @BindView(R.id.region_textview)
    TextView regionTextview;
    @BindView(R.id.city_textview)
    TextView cityTextview;
    @BindView(R.id.region)
    AppCompatSpinner region;
    @BindView(R.id.city)
    AppCompatSpinner city;
    @BindView(R.id.salary_type_textview)
    TextView salaryTypeTextview;
    @BindView(R.id.salary_type_spinner)
    AppCompatSpinner salaryTypeSpinner;
    @BindView(R.id.from_textview)
    TextView fromTextview;
    @BindView(R.id.to_textview)
    TextView toTextview;
    @BindView(R.id.salary_from)
    AppCompatSpinner salaryFrom;
    @BindView(R.id.salary_to)
    AppCompatSpinner salaryTo;
    @BindView(R.id.jobType_txt)
    TextView jobTypeTxt;
    @BindView(R.id.jobType_spinner)
    AppCompatSpinner jobTypeSpinner;
    @BindView(R.id.apply_button)
    Button applyButton;
    @BindView(R.id.cancel_button)
    Button cancelButton;
    @BindView(R.id.sub_category_view)
    View subCategoryView;
    @BindView(R.id.city_view)
    View cityView;
    @BindView(R.id.salary_from_view)
    View salaryFromView;
    @BindView(R.id.salary_to_view)
    View salaryToView;
    private JobListMaster jobListMaster;
    private JobListMaster jobListMasterReplaceFields;
    private Activity activity;
    private Integer categoryPosition = null;
    private Integer regionPosition = null;
    private Integer salaryTypePosition = null;

    private OnPassDataListener onPassDataListener;


    //filterData
    private String searchText = "";
    private String categoryId = "";
    private String subCategoryId = "";
    private String regionId = "";
    private String cityId = "";
    private String salaryTypeId = "";
    private String salaryFromData = "";
    private String salaryToData = "";
    private String jobTypeId = "";



    private JobCategory categoryPassData = null;
    private JobSubcategory subCategoryPassData = null;
    private JobRegionslist regionPassData = null;
    private JobCitylist cityPassData = null;
    private JobSalaryType salaryTypePassData = null;
    private String salaryType = null;
    private JobSalaryForHr salaryFromHourData = null, salaryToHourData = null;
    private JobSalaryForYr salaryFromYearData = null, salaryToYearData = null;
    private JobType jobTypePassData = null;

    JobsFilterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance(JobListMaster jobListMaster) {
        this.jobListMaster = jobListMaster;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.jobs_filters_dialogue);
        ButterKnife.bind(this);
        callTypeFace();

        category_spinner_load();
        region_spinner_load();
        salary_type_spinner_load();
        salaryTypeSpinner.setSelection(1);
        job_type_spinner_load();

        init_sub_category_spinner_load();
        init_city_spinner_load();
        init_salary_from_spinner_load();
        init_salary_to_spinner_load();
    }

    private void init_sub_category_spinner_load() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.select_sub_category));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        subCategory.setAdapter(adapter);
    }


    private void init_city_spinner_load() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.select_city));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        city.setAdapter(adapter);
    }

    private void init_salary_from_spinner_load() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.salary_from));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        salaryFrom.setAdapter(adapter);
    }

    private void init_salary_to_spinner_load() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.salary_to));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        salaryTo.setAdapter(adapter);
    }

    private void callTypeFace() {
        filtersTitle.setTypeface(FontTypeFace.fontBold(activity));
        categoryTextview.setTypeface(FontTypeFace.fontBold(activity));
        cityTextview.setTypeface(FontTypeFace.fontBold(activity));
        regionTextview.setTypeface(FontTypeFace.fontBold(activity));
        salaryTypeTextview.setTypeface(FontTypeFace.fontBold(activity));
        jobTypeTxt.setTypeface(FontTypeFace.fontBold(activity));
        fromTextview.setTypeface(FontTypeFace.fontBold(activity));
        toTextview.setTypeface(FontTypeFace.fontBold(activity));
        applyButton.setTypeface(FontTypeFace.fontBold(activity));
        cancelButton.setTypeface(FontTypeFace.fontBold(activity));
        subCategoryTextview.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void category_spinner_load() {
        List<JobCategory> jobCategories = new ArrayList<>();

        JobCategory jobCategory = new JobCategory();
        jobCategory.setIcaCategoryId(null);
        jobCategory.setIcaName(activity.getResources().getString(R.string.select_category));
        jobCategories.add(jobCategory);
        JobCategory jobCategory1 = new JobCategory();
        jobCategory1.setIcaCategoryId("0");
        jobCategory1.setIcaName("All");
        jobCategories.add(jobCategory1);

        jobCategories.addAll(jobListMaster.getJobListMasterData().getJobCategories());
        if (jobCategories.size() > 0) {
            ArrayAdapter<JobCategory> adapter = new ArrayAdapter<JobCategory>(activity, R.layout.spinner_text, jobCategories) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);

            category.setAdapter(adapter);
            Log.d("JobFilter", "category_spinner_load: "+ new Gson().toJson(jobCategories));

            category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    categoryPosition = position;
                    if (position > 0) {
                        categoryPassData = (JobCategory) parent.getSelectedItem();
                        String category_id = categoryPassData.getIcaCategoryId();
                        if (categoryPassData.getIcaCategoryId().equals("0")){
                            category_id="";
                        }
                        call_subCategory_api(category_id);
                        subCategoryView.setVisibility(View.GONE);
                    }else {
                        categoryPassData = null;
                        subCategoryView.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void call_subCategory_api(String categoryId) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<JobListMaster> call = ApiClient.getApiInterface().getJobSubCategory(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), categoryId);
            call.enqueue(new Callback<JobListMaster>() {
                @Override
                public void onResponse(Call<JobListMaster> call, Response<JobListMaster> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                sub_category_spinner_load(response.body());
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " JobSubCategory", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(Call<JobListMaster> call, Throwable t) {
                    Log.d(Constants.failureResponse + " JobSubCategory", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }

    }

    private void sub_category_spinner_load(JobListMaster body) {
        List<JobSubcategory> jobSubcategories = new ArrayList<>();

        JobSubcategory jobSubcategory = new JobSubcategory();
        jobSubcategory.setIscSubCategoryId(null);
        jobSubcategory.setIscName(activity.getResources().getString(R.string.select_sub_category));
        jobSubcategories.add(jobSubcategory);

        jobSubcategories.addAll(body.getJobListMasterData().getJobSubcategories());

        if (jobSubcategories.size() > 0) {
            ArrayAdapter<JobSubcategory> adapter = new ArrayAdapter<JobSubcategory>(activity, R.layout.spinner_text, jobSubcategories) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            subCategory.setAdapter(adapter);
            subCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0) {
                        subCategoryPassData = (JobSubcategory) parent.getSelectedItem();
                    }else {
                        subCategoryPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }


    private void region_spinner_load() {
        List<JobRegionslist> jobRegionslists = new ArrayList<>();

        JobRegionslist jobRegionslist = new JobRegionslist();
        jobRegionslist.setReRegionId(null);
        jobRegionslist.setReName(activity.getResources().getString(R.string.select_region));
        jobRegionslists.add(jobRegionslist);
        JobRegionslist jobRegionslist1 = new JobRegionslist();
        jobRegionslist1.setReRegionId("0");
        jobRegionslist1.setReName("All");
        jobRegionslists.add(jobRegionslist1);

        jobRegionslists.addAll(jobListMaster.getJobListMasterData().getJobRegionslist());

        if (jobRegionslists.size() > 0) {
            ArrayAdapter<JobRegionslist> adapter = new ArrayAdapter<JobRegionslist>(activity, R.layout.spinner_text, jobRegionslists) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            region.setAdapter(adapter);
            region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    regionPosition = position;
                    if (position > 0) {
                        regionPassData = (JobRegionslist) parent.getSelectedItem();
                        String region_id = regionPassData.getReRegionId();
                        if (regionPassData.getReRegionId().equals("0")){
                            region_id="";
                        }
                        call_city_api(region_id);
                        cityView.setVisibility(View.GONE);
                    }else {
                        regionPassData = null;
                        cityView.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    private void call_city_api(String reRegionId) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<JobListMaster> call = ApiClient.getApiInterface().getJobCity(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), reRegionId);
            call.enqueue(new Callback<JobListMaster>() {
                @Override
                public void onResponse(Call<JobListMaster> call, Response<JobListMaster> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                city_spinner_load(response.body());
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " JobCityList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(Call<JobListMaster> call, Throwable t) {
                    Log.d(Constants.failureResponse + " JobCityList", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void city_spinner_load(JobListMaster body) {
        List<JobCitylist> jobCitylists = new ArrayList<>();

        JobCitylist jobCitylist = new JobCitylist();
        jobCitylist.setCiCityId(null);
        jobCitylist.setCiName(activity.getResources().getString(R.string.select_city));
        jobCitylists.add(jobCitylist);

        jobCitylists.addAll(body.getJobListMasterData().getJobCitylist());

        if (jobCitylists.size() > 0) {
            ArrayAdapter<JobCitylist> adapter = new ArrayAdapter<JobCitylist>(activity, R.layout.spinner_text, jobCitylists) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            city.setAdapter(adapter);
            city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0) {
                        cityPassData = (JobCitylist) parent.getSelectedItem();
                    }else {
                        cityPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }


    private void salary_type_spinner_load() {
        List<JobSalaryType> jobSalaryTypes = new ArrayList<>();

        JobSalaryType jobSalaryType = new JobSalaryType();
        jobSalaryType.setId(null);
        jobSalaryType.setName(activity.getResources().getString(R.string.select_salary_type));
        jobSalaryTypes.add(jobSalaryType);
        JobSalaryType jobSalaryType1 = new JobSalaryType();
        jobSalaryType1.setId(0);
        jobSalaryType1.setName("All");
        jobSalaryTypes.add(jobSalaryType1);

        jobSalaryTypes.addAll(jobListMaster.getJobListMasterData().getJobSalaryType());

        if (jobSalaryTypes.size() > 0) {
            ArrayAdapter<JobSalaryType> adapter = new ArrayAdapter<JobSalaryType>(activity, R.layout.spinner_text, jobSalaryTypes) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            salaryTypeSpinner.setAdapter(adapter);

            salaryTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    salaryTypePosition = position;
                    if (position > 0) {
                        salaryTypePassData = (JobSalaryType) parent.getSelectedItem();
                        salaryType = salaryTypePassData.getName();
                        String salarytype_id = ""+salaryTypePassData.getId();
                        if (salaryTypePassData.getId().equals("0")){
                            salarytype_id="";
                        }
                        salary_from_load(salaryTypePassData);
                        salary_to_load(salaryTypePassData);
                        salaryFromView.setVisibility(View.GONE);
                        salaryToView.setVisibility(View.GONE);
                    }else {
                        salaryTypePassData = null;
                        salaryType = null;
                        salaryFromView.setVisibility(View.VISIBLE);
                        salaryToView.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }


    private void salary_from_load(JobSalaryType jobSalaryType1) {
        if (jobSalaryType1.getName().equals("Hourly")) {
            List<JobSalaryForHr> jobSalaryForHrs = new ArrayList<>();

            JobSalaryForHr jobSalaryForHr = new JobSalaryForHr();
            jobSalaryForHr.setId(null);
            jobSalaryForHr.setName(activity.getResources().getString(R.string.salary_from));
            jobSalaryForHrs.add(jobSalaryForHr);

            jobSalaryForHrs.addAll(jobListMaster.getJobListMasterData().getJobSalaryForHr());

            if (jobSalaryForHrs.size() > 0) {
                ArrayAdapter<JobSalaryForHr> adapter = new ArrayAdapter<JobSalaryForHr>(activity, R.layout.spinner_text, jobSalaryForHrs) {
                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                        } else {
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                        }
                        return view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.spinner_text);
                salaryFrom.setAdapter(adapter);
                salaryFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            salaryFromHourData = (JobSalaryForHr) parent.getSelectedItem();
                        }else {
                            salaryFromHourData = null;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        } else {
            List<JobSalaryForYr> jobSalaryForYrs = new ArrayList<>();

            JobSalaryForYr jobSalaryForYr = new JobSalaryForYr();
            jobSalaryForYr.setId(null);
            jobSalaryForYr.setName(activity.getResources().getString(R.string.salary_from));
            jobSalaryForYrs.add(jobSalaryForYr);

            jobSalaryForYrs.addAll(jobListMaster.getJobListMasterData().getJobSalaryForYr());

            if (jobSalaryForYrs.size() > 0) {
                ArrayAdapter<JobSalaryForYr> adapter = new ArrayAdapter<JobSalaryForYr>(activity, R.layout.spinner_text, jobSalaryForYrs) {
                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                        } else {
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                        }
                        return view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.spinner_text);
                salaryFrom.setAdapter(adapter);
                salaryFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            salaryFromYearData = (JobSalaryForYr) parent.getSelectedItem();
                        }else {
                            salaryFromYearData = null;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }
    }

    private void salary_to_load(JobSalaryType jobSalaryType1) {

        if (jobSalaryType1.getName().equals("Hourly")) {
            List<JobSalaryForHr> jobSalaryForHrs = new ArrayList<>();

            JobSalaryForHr jobSalaryForHr = new JobSalaryForHr();
            jobSalaryForHr.setId(null);
            jobSalaryForHr.setName(activity.getResources().getString(R.string.salary_to));
            jobSalaryForHrs.add(jobSalaryForHr);

            jobSalaryForHrs.addAll(jobListMaster.getJobListMasterData().getJobSalaryForHr());

            if (jobSalaryForHrs.size() > 0) {
                ArrayAdapter<JobSalaryForHr> adapter = new ArrayAdapter<JobSalaryForHr>(activity, R.layout.spinner_text, jobSalaryForHrs) {
                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                        } else {
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                        }
                        return view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.spinner_text);
                salaryTo.setAdapter(adapter);
                salaryTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            salaryToHourData = (JobSalaryForHr) parent.getSelectedItem();
                            if (salaryFromYearData!=null) {
                                String fromdata = salaryFromYearData.getName().replace("$", "").replace("k", "");
                                String todata = salaryToYearData.getName().replace("$", "").replace("k", "");
                                Log.d(TAG, "onItemSelected: fromdata" + fromdata);
                                Log.d(TAG, "onItemSelected: todata" + todata);
                                if (Integer.parseInt(fromdata)<Integer.parseInt(todata)) {
                                    //MyToast.errorMessage("Salary",activity);
                                }else{
                                    salaryToHourData = null;
                                    salaryTo.setSelection(0);
                                    MyToast.errorMessage("Tosalary should lower than from salary",activity);
                                }
                            }
                        }else {
                            salaryToHourData = null;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

        } else {
            List<JobSalaryForYr> jobSalaryForYrs = new ArrayList<>();

            JobSalaryForYr jobSalaryForYr = new JobSalaryForYr();
            jobSalaryForYr.setId(null);
            jobSalaryForYr.setName(activity.getResources().getString(R.string.salary_to));
            jobSalaryForYrs.add(jobSalaryForYr);

            jobSalaryForYrs.addAll(jobListMaster.getJobListMasterData().getJobSalaryForYr());

            if (jobSalaryForYrs.size() > 0) {
                ArrayAdapter<JobSalaryForYr> adapter = new ArrayAdapter<JobSalaryForYr>(activity, R.layout.spinner_text, jobSalaryForYrs) {
                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                        } else {
                            tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                        }
                        return view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.spinner_text);
                salaryTo.setAdapter(adapter);
                salaryTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            salaryToYearData = (JobSalaryForYr) parent.getSelectedItem();
                            if (salaryFromYearData!=null) {
                                String fromdata = salaryFromYearData.getName().replace("$", "").replace("k", "");
                                String todata = salaryToYearData.getName().replace("$", "").replace("k", "");
                                Log.d(TAG, "onItemSelected: fromdata" + fromdata);
                                Log.d(TAG, "onItemSelected: todata" + todata);
                                if (Integer.parseInt(fromdata)<Integer.parseInt(todata)) {
                                    //MyToast.errorMessage("Salary",activity);
                                }else{
                                    salaryToHourData = null;
                                    salaryTo.setSelection(0);
                                    MyToast.errorMessage("Tosalary should lower than from salary",activity);
                                }
                            }
                        }else {
                            salaryToYearData = null;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }
    }

    private void job_type_spinner_load() {
        List<JobType> jobTypes = new ArrayList<>();

        JobType jobType = new JobType();
        jobType.setId(null);
        jobType.setName(activity.getResources().getString(R.string.select_job_type));

        jobTypes.add(jobType);

        jobTypes.addAll(jobListMaster.getJobListMasterData().getJobTypes());

        if (jobTypes.size() > 0) {
            ArrayAdapter<JobType> adapter = new ArrayAdapter<JobType>(activity, R.layout.spinner_text, jobTypes) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            jobTypeSpinner.setAdapter(adapter);
            jobTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0) {
                        jobTypePassData = (JobType) parent.getSelectedItem();
                    }else {
                        jobTypePassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @OnClick({R.id.dialog_close, R.id.apply_button, R.id.cancel_button, R.id.sub_category_view, R.id.city_view, R.id.salary_from_view, R.id.salary_to_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.apply_button:
                pass_Data();
                break;
            case R.id.cancel_button:
                clear_all();
                break;
            case R.id.sub_category_view:
                if (categoryPosition == 0) {
                    MyToast.errorMessage("Kindly Select Category", activity);
                }
                break;
            case R.id.city_view:
                if (regionPosition == 0) {
                    MyToast.errorMessage("Kindly Select Region", activity);
                }
                break;
            case R.id.salary_from_view:
            case R.id.salary_to_view:
               /* if (salaryTypePosition == 0) {
                    MyToast.errorMessage("Kindly Select Salary Type", activity);
                }*/
                break;
        }
    }

    private void clear_all() {
        searchText = "";
        categoryId = "";
        subCategoryId = "";
        regionId = "";
        cityId = "";
        salaryTypeId = "";
        salaryFromData = "";
        salaryToData = "";
        jobTypeId = "";

        search.setText("");

        category_spinner_load();
        region_spinner_load();
        salary_type_spinner_load();
        job_type_spinner_load();

        init_sub_category_spinner_load();
        init_city_spinner_load();
        init_salary_from_spinner_load();
        init_salary_to_spinner_load();

    }

    private void pass_Data() {

        if (!search.getText().toString().isEmpty()) {
            searchText = search.getText().toString();
        }else{
            searchText = "";
        }

        if (categoryPassData != null) {
            categoryId = categoryPassData.getIcaCategoryId();
        }

        if (subCategoryPassData != null) {
            subCategoryId = subCategoryPassData.getIscSubCategoryId();
        }

        if (regionPassData != null) {
            regionId = regionPassData.getReRegionId();
        }

        if (cityPassData != null) {
            cityId = cityPassData.getCiCityId();
        }

        if (salaryTypePassData != null) {
            salaryTypeId = String.valueOf(salaryTypePassData.getId());
        }

        if (salaryType != null) {
            if (salaryType.equals("Hourly")) {

                if (salaryFromHourData != null) {
                    salaryFromData = String.valueOf(salaryFromHourData.getId());
                }

                if (salaryToHourData != null) {
                    salaryToData = String.valueOf(salaryToHourData.getId());
                }

            } else {

                if (salaryFromYearData != null) {
                    salaryFromData = String.valueOf(salaryFromYearData.getId());
                }

                if (salaryToYearData != null) {
                    salaryToData = String.valueOf(salaryToYearData.getId());
                }

            }
        }

        if (jobTypePassData != null) {
            jobTypeId = String.valueOf(jobTypePassData.getId());
        }
        onPassDataListener.onPassData(searchText, categoryId, subCategoryId, regionId, cityId, salaryTypeId, salaryFromData, salaryToData, jobTypeId, true);
        dismiss();
    }

    public interface OnPassDataListener {
        void onPassData(String search,
                        String category,
                        String subCategory,
                        String region,
                        String city,
                        String salaryType,
                        String salaryFrom,
                        String salaryTo,
                        String jobType,
                        boolean filter);
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

}
