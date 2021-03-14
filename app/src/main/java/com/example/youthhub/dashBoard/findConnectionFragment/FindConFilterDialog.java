package com.example.youthhub.dashBoard.findConnectionFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.findConnectionFragment.multiSelectFilter.MultiSelectFilterDialog;
import com.example.youthhub.resModel.connection.conListMaster.BizSubServiceRes;
import com.example.youthhub.resModel.connection.conListMaster.BizSubservice;
import com.example.youthhub.resModel.connection.conListMaster.Bizservice;
import com.example.youthhub.resModel.connection.conListMaster.City;
import com.example.youthhub.resModel.connection.conListMaster.ConnCityRes;
import com.example.youthhub.resModel.connection.conListMaster.ConnectionListMaster;
import com.example.youthhub.resModel.connection.conListMaster.Region;
import com.example.youthhub.resModel.connection.conListMaster.Service;
import com.example.youthhub.resModel.connection.conListMaster.Tag;
import com.example.youthhub.resModel.connection.conListMaster.UserType;
import com.example.youthhub.resModel.connection.conListMaster.Wishlist;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.dashBoard.dashboard.PostImagesAdapter.TAG;

public class FindConFilterDialog extends Dialog implements MultiSelectFilterDialog.PassListItems {

    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.user_type_txt)
    TextView userTypeTxt;
    @BindView(R.id.user_type_spinner)
    AppCompatSpinner userTypeSpinner;
    @BindView(R.id.user_type_constrain)
    ConstraintLayout userTypeConstrain;
    @BindView(R.id.region_txt)
    TextView regionTxt;
    @BindView(R.id.region_spinner)
    TextView regionSpinner;
    @BindView(R.id.region_constrain)
    ConstraintLayout regionConstrain;
    @BindView(R.id.city_txt)
    TextView cityTxt;
    @BindView(R.id.city_spinner)
    TextView citySpinner;
    @BindView(R.id.city_constrain)
    ConstraintLayout cityConstrain;
    @BindView(R.id.wish_list)
    TextView wishList;
    @BindView(R.id.wish_list_spinner)
    TextView wishListSpinner;
    @BindView(R.id.wish_list_constrain)
    ConstraintLayout wishListConstrain;
    @BindView(R.id.service_type)
    TextView serviceType;
    @BindView(R.id.service_type_spinner)
    TextView serviceTypeSpinner;
    @BindView(R.id.service_type_constrain)
    ConstraintLayout serviceTypeConstrain;
    @BindView(R.id.sub_service_type)
    TextView subServiceType;
    @BindView(R.id.sub_service_type_spinner)
    TextView subServiceTypeSpinner;
    @BindView(R.id.sub_service_type_constrain)
    ConstraintLayout subServiceTypeConstrain;
    @BindView(R.id.tags)
    TextView tags;
    @BindView(R.id.tags_spinner)
    TextView tagsSpinner;
    @BindView(R.id.tags_constrain)
    ConstraintLayout tagsConstrain;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.clear_btn)
    Button clearBtn;
    private Activity activity;

    private ConnectionListMaster connectionListMaster;

    OnPassDataListener onPassDataListener;

    void setOnPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    private List<City> cityListResponse;
    private List<BizSubservice> bizSubservices;

    //restore previous filter
    private Integer userTypePosition;
    private List<Region> selectedRegions;
    private List<City> selectedCities;
    private List<Wishlist> selectedWishlist;
    private List<Service> selectedService;
    private List<Tag> selectedTag;
    private List<Bizservice> selectedBizSerevice;
    private List<BizSubservice> selectedBizSubservice;

    //pass filter data
    private String usertype = "";
    private String searchText;
    private String region;
    private String city;
    private String wishlist;
    private String service;
    private String bizservice;
    private String bizSubService;
    private String tag;
    private boolean bizService;

    FindConFilterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance( ConnectionListMaster connectionListMaster) {
        this.connectionListMaster = connectionListMaster;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.find_con_filter_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        callRestoreData();
        load_userType_spinner();
    }

    private void callRestoreData() {

        cityListResponse = null;
        bizSubservices = null;

        //restore previous filter
        userTypePosition = null;
        selectedRegions = new ArrayList<>();
        selectedCities = new ArrayList<>();
        selectedWishlist = new ArrayList<>();
        selectedService = new ArrayList<>();
        selectedTag = new ArrayList<>();
        selectedBizSerevice = new ArrayList<>();
        selectedBizSubservice = new ArrayList<>();

        //pass filter data
        searchText = "";
        region = "";
        city = "";
        wishlist = "";
        service = "";
        bizservice = "";
        bizSubService = "";
        tag = "";

        bizService = false;

        regionSpinner.setText("All");
        citySpinner.setText("All");
        wishListSpinner.setText("All");
        serviceTypeSpinner.setText("All");
        subServiceTypeSpinner.setText("All");
        tagsSpinner.setText("All");
    }

    private void load_userType_spinner() {
        List<UserType> userTypeList = connectionListMaster.getData().getUserType();
        ArrayAdapter<UserType> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, userTypeList);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        userTypeSpinner.setAdapter(adapter);
        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                UserType userType = (UserType) parent.getSelectedItem();
                callRestoreData();
                Log.d(TAG, "onItemSelected: "+userType.getId());
                switch (userType.getId()) {
                    case 6:
                        wishListConstrain.setVisibility(View.VISIBLE);
                        serviceTypeConstrain.setVisibility(View.GONE);
                        subServiceTypeConstrain.setVisibility(View.GONE);
                        tagsConstrain.setVisibility(View.GONE);
                        break;
                    case 5:
                    case 7:
                        wishListConstrain.setVisibility(View.GONE);
                        serviceTypeConstrain.setVisibility(View.GONE);
                        subServiceTypeConstrain.setVisibility(View.GONE);
                        tagsConstrain.setVisibility(View.GONE);
                        break;
                    case 8:
                        wishListConstrain.setVisibility(View.GONE);
                        serviceTypeConstrain.setVisibility(View.VISIBLE);
                        subServiceTypeConstrain.setVisibility(View.VISIBLE);
                        tagsConstrain.setVisibility(View.VISIBLE);
                        bizService = true;
                        break;
                    case 9:
                        Log.d(TAG, "onItemSelected: 99");
                        wishListConstrain.setVisibility(View.GONE);
                        serviceTypeConstrain.setVisibility(View.VISIBLE);
                        subServiceTypeConstrain.setVisibility(View.VISIBLE);
                        tagsConstrain.setVisibility(View.GONE);
                        break;
                    case 10:
                        Log.d(TAG, "onItemSelected: 10");
                    case 11:
                        Log.d(TAG, "onItemSelected: 11");
                        wishListConstrain.setVisibility(View.GONE);
                        serviceTypeConstrain.setVisibility(View.VISIBLE);
                        subServiceTypeConstrain.setVisibility(View.GONE);
                        tagsConstrain.setVisibility(View.VISIBLE);
                        break;
                }
                userTypePosition = position;
                usertype = String.valueOf(userType.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void callTypeFace() {
        filterTxt.setTypeface(FontTypeFace.fontBold(activity));
        userTypeTxt.setTypeface(FontTypeFace.fontBold(activity));
        cityTxt.setTypeface(FontTypeFace.fontBold(activity));
        regionTxt.setTypeface(FontTypeFace.fontBold(activity));
        wishList.setTypeface(FontTypeFace.fontBold(activity));
        clearBtn.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        serviceType.setTypeface(FontTypeFace.fontBold(activity));
        subServiceType.setTypeface(FontTypeFace.fontBold(activity));
        tags.setTypeface(FontTypeFace.fontBold(activity));

    }

    @OnClick({R.id.dialog_close, R.id.region_spinner, R.id.city_spinner, R.id.wish_list_spinner, R.id.service_type_spinner, R.id.sub_service_type_spinner, R.id.tags_spinner, R.id.apply_btn, R.id.clear_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.region_spinner:
                List<Region> region = connectionListMaster.getData().getRegion();
                MultiSelectFilterDialog regionDialog = new MultiSelectFilterDialog(activity);
                regionDialog.setPassListItems(this);
                regionDialog.newInstance(region, selectedRegions, "Region");
                regionDialog.show();
                break;
            case R.id.city_spinner:
                if(!regionSpinner.getText().toString().isEmpty()){
                    if (cityListResponse != null) {
                        MultiSelectFilterDialog cityDialog = new MultiSelectFilterDialog(activity);
                        cityDialog.setPassListItems(this);
                        cityDialog.newCityInstance(cityListResponse, selectedCities, "City");
                        cityDialog.show();
                    }
                }else {
                    MyToast.errorMessage("Kindly Select Region",activity);
                }
                break;
            case R.id.wish_list_spinner:
                List<Wishlist> wishlists = connectionListMaster.getData().getWishlist();
                MultiSelectFilterDialog wishListDialog = new MultiSelectFilterDialog(activity);
                wishListDialog.setPassListItems(this);
                wishListDialog.newWishListInstance(wishlists, selectedWishlist, "WishList");
                wishListDialog.show();
                break;
            case R.id.service_type_spinner:
                if (bizService) {
                    List<Bizservice> bizservices = connectionListMaster.getData().getBizservice();
                    MultiSelectFilterDialog bizServiceDialog = new MultiSelectFilterDialog(activity);
                    bizServiceDialog.setPassListItems(this);
                    bizServiceDialog.newBizServiceInstance(bizservices, selectedBizSerevice, "BizService");
                    bizServiceDialog.show();
                } else {
                    List<Service> services = connectionListMaster.getData().getService();
                    MultiSelectFilterDialog serviceDialog = new MultiSelectFilterDialog(activity);
                    serviceDialog.setPassListItems(this);
                    serviceDialog.newServiceInstance(services, selectedService, "Service");
                    serviceDialog.show();
                }
                break;
            case R.id.sub_service_type_spinner:
                if(!serviceTypeSpinner.getText().toString().isEmpty()){
                    if (bizSubservices != null) {
                        MultiSelectFilterDialog bizSubServiceDialog = new MultiSelectFilterDialog(activity);
                        bizSubServiceDialog.setPassListItems(this);
                        bizSubServiceDialog.newBizSubServiceInstance(bizSubservices, selectedBizSubservice, "BizSubService");
                        bizSubServiceDialog.show();
                    }
                }else {
                    MyToast.errorMessage("Kindly Select Service Type",activity);
                }
                break;
            case R.id.tags_spinner:
                List<Tag> tags = connectionListMaster.getData().getTag();
                MultiSelectFilterDialog tagsDialog = new MultiSelectFilterDialog(activity);
                tagsDialog.setPassListItems(this);
                tagsDialog.newTagInstance(tags, selectedTag, "Tag");
                tagsDialog.show();
                break;
            case R.id.apply_btn:
                apply_filter();
                break;
            case R.id.clear_btn:
                callRestoreData();
                userTypeSpinner.setSelection(0);
                search.setText("");
                break;
        }
    }

    private void apply_filter() {
        searchText = search.getText().toString();
        onPassDataListener.passData(usertype,searchText,region,city,wishlist,service,bizservice,bizSubService,tag);
        dismiss();
    }

    @Override
    public void RegionPassData(List<Region> regions) {
        this.selectedRegions = regions;
        String tags = "";
        region = "";
        for (int i = 0; i < regions.size(); i++) {
            if (tags.equals("")) {
                tags = regions.get(i).getReName();
                region = regions.get(i).getReRegionId();
            } else {
                tags = tags + "," + regions.get(i).getReName();
                region = region + "," + regions.get(i).getReRegionId();
            }
        }
        regionSpinner.setText(tags);
        citySpinner.setText("");
        cityListResponse = null;
        //restore previous filter
        selectedCities = new ArrayList<>();
        //pass filter data
        city = "";

        if (regions.size() > 0) {
            call_city_api(regions.get(0).getReRegionId());
        }
    }

    @Override
    public void CityPassData(List<City> cities) {
        this.selectedCities = cities;
        String tags = "";
        city = "";
        for (int i = 0; i < cities.size(); i++) {
            if (tags.equals("")) {
                tags = cities.get(i).getCiName();
                city = cities.get(i).getCiCityId();
            } else {
                tags = tags + "," + cities.get(i).getCiName();
                city = city + "," + cities.get(i).getCiCityId();
            }
        }
        citySpinner.setText(tags);
    }

    @Override
    public void WishListPassData(List<Wishlist> wishlists) {
        this.selectedWishlist = wishlists;
        String tags = "";
        wishlist = "";
        for (int i = 0; i < wishlists.size(); i++) {
            if (tags.equals("")) {
                tags = wishlists.get(i).getWitName();
                wishlist = wishlists.get(i).getWitTagId();
            } else {
                tags = tags + "," + wishlists.get(i).getWitName();
                wishlist = wishlist + "," + wishlists.get(i).getWitTagId();
            }
        }
        wishListSpinner.setText(tags);
    }

    @Override
    public void ServicePassData(List<Service> services) {
        this.selectedService = services;
        String tags = "";
        service = "";
        for (int i = 0; i < services.size(); i++) {
            if (tags.equals("")) {
                tags = services.get(i).getOgcName();
                service = services.get(i).getOgcCategoryId();
            } else {
                tags = tags + "," + services.get(i).getOgcName();
                service = service + "," + services.get(i).getOgcCategoryId();
            }
        }
        serviceTypeSpinner.setText(tags);
    }

    @Override
    public void BizServicesPassData(List<Bizservice> bizservices) {
        this.selectedBizSerevice = bizservices;
        String tags = "";
        bizservice = "";
        for (int i = 0; i < bizservices.size(); i++) {
            if (tags.equals("")) {
                tags = bizservices.get(i).getIcaName();
                bizservice = bizservices.get(i).getIcaCategoryId();
            } else {
                tags = tags + "," + bizservices.get(i).getIcaName();
                bizservice = bizservice + "," + bizservices.get(i).getIcaCategoryId();
            }
        }
        serviceTypeSpinner.setText(tags);
        subServiceTypeSpinner.setText("");
        bizSubservices = null;
        //restore previous filter
        selectedBizSubservice = new ArrayList<>();
        //pass filter data
        bizSubService = "";

        if (bizservices.size() > 0) {
            call_bizSubService_api(bizservices.get(0).getIcaCategoryId());
        }
    }

    @Override
    public void BizSubServicesPassData(List<BizSubservice> bizSubservices) {
        this.selectedBizSubservice = bizSubservices;
        String tags = "";
        bizSubService = "";
        for (int i = 0; i < bizSubservices.size(); i++) {
            if (tags.equals("")) {
                tags = bizSubservices.get(i).getIscName();
                bizSubService = bizSubservices.get(i).getIscSubCategoryId();
            } else {
                tags = tags + "," + bizSubservices.get(i).getIscName();
                bizSubService = bizSubService + "," + bizSubservices.get(i).getIscSubCategoryId();
            }
        }
        subServiceTypeSpinner.setText(tags);
    }

    @Override
    public void TagsPassData(List<Tag> tagslist) {
        this.selectedTag = tagslist;
        String tags = "";
        tag = "";
        for (int i = 0; i < tagslist.size(); i++) {
            if (tags.equals("")) {
                tags = tagslist.get(i).getTgName();
                tag = tagslist.get(i).getTgTagId();
            } else {
                tags = tags + "," + tagslist.get(i).getTgName();
                tag = tag + "," + tagslist.get(i).getTgTagId();
            }
        }
        tagsSpinner.setText(tags);
    }

    private void call_bizSubService_api(String icaCategoryId) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BizSubServiceRes> call = ApiClient.getApiInterface().getBizSubService(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), icaCategoryId);
            call.enqueue(new Callback<BizSubServiceRes>() {
                @Override
                public void onResponse(@NonNull Call<BizSubServiceRes> call, @NonNull Response<BizSubServiceRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                bizSubservices = response.body().getBizSubServiceData().getBizSubservice();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " BizService", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<BizSubServiceRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " BizService", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_city_api(String reRegionId) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ConnCityRes> call = ApiClient.getApiInterface().getConCity(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), reRegionId);
            call.enqueue(new Callback<ConnCityRes>() {
                @Override
                public void onResponse(@NonNull Call<ConnCityRes> call, @NonNull Response<ConnCityRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                cityListResponse = response.body().getConnCityData().getCities();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ConnCity", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ConnCityRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ConnCity", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    public interface OnPassDataListener {

        void passData(String usertype,
                      String search,
                      String region,
                      String city,
                      String wishlist,
                      String service,
                      String bizservice,
                      String bizSubService,
                      String tags);

        /*void selectedDatas(Integer usertypeposition,
                           String search,
                           List<Region> regions,
                           List<City> city,
                           List<Wishlist> wishlist,
                           List<Service> service,
                           List<Bizservice> bizservice,
                           List<Tag> tag);*/


    }

}
