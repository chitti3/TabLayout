package com.example.youthhub.dashBoard.findConnectionFragment.multiSelectFilter;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.youthhub.R;
import com.example.youthhub.resModel.connection.conListMaster.BizSubservice;
import com.example.youthhub.resModel.connection.conListMaster.Bizservice;
import com.example.youthhub.resModel.connection.conListMaster.City;
import com.example.youthhub.resModel.connection.conListMaster.Region;
import com.example.youthhub.resModel.connection.conListMaster.Service;
import com.example.youthhub.resModel.connection.conListMaster.Tag;
import com.example.youthhub.resModel.connection.conListMaster.Wishlist;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MultiSelectFilterDialog extends Dialog implements
        ConnectionRegionAdapter.OnViewClickListener,
        ConnectionCityAdapter.OnViewClickListener,
        ConnectionWishListAdapter.OnViewClickListener,
        ConnectionServiceAdapter.OnViewClickListener,
        ConnectionTagsAdapter.OnViewClickListener,
        ConnectionBizServiceAdapter.OnViewClickListener,
        ConnectionBizSubServiceAdapter.OnViewClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    private Activity activity;

    //load data
    private List<Region> regions;
    private List<City> cities;
    private List<Wishlist> wishlists;
    private List<Service> services;
    private List<Tag> tags;
    private List<Bizservice> bizservices;
    private List<BizSubservice> bizSubservices;

    //load selected data
    private List<Region> selectedRegions;
    private List<City> selectedCities;
    private List<Wishlist> selectedWishlists;
    private List<Service> selectedService;
    private List<Tag> selectedTag;
    private List<Bizservice> selectedbizservice;
    private List<BizSubservice> selectedBizSubservices;

    //selected lists
    private List<Region> regionList = new ArrayList<>();
    private List<City> cityList = new ArrayList<>();
    private List<Wishlist> wishlist = new ArrayList<>();
    private List<Service> service = new ArrayList<>();
    private List<Tag> tag = new ArrayList<>();
    private List<Bizservice> bizservice = new ArrayList<>();
    private List<BizSubservice> bizSubservice = new ArrayList<>();

    private String dialogTypeName;
    private PassListItems passListItems;

    public MultiSelectFilterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance(List<Region> regions, List<Region> selectedRegions, String dialogTypeName) {
        this.regions = regions;
        this.dialogTypeName = dialogTypeName;
        this.selectedRegions = selectedRegions;
    }

    public void newCityInstance(List<City> cities, List<City> selectedCities, String dialogTypeName) {
        this.cities = cities;
        this.dialogTypeName = dialogTypeName;
        this.selectedCities = selectedCities;
    }

    public void newWishListInstance(List<Wishlist> wishlists, List<Wishlist> selectedWishlists, String dialogTypeName) {
        this.wishlists = wishlists;
        this.dialogTypeName = dialogTypeName;
        this.selectedWishlists = selectedWishlists;
    }

    public void newServiceInstance(List<Service> services, List<Service> selectedServices, String dialogTypeName) {
        this.services = services;
        this.dialogTypeName = dialogTypeName;
        this.selectedService = selectedServices;
    }

    public void newTagInstance(List<Tag> tags, List<Tag> selectedTags, String dialogTypeName) {
        this.tags = tags;
        this.dialogTypeName = dialogTypeName;
        this.selectedTag = selectedTags;
    }

    public void newBizServiceInstance(List<Bizservice> bizservices, List<Bizservice> selectedBizservice, String dialogTypeName) {
        this.bizservices = bizservices;
        this.dialogTypeName = dialogTypeName;
        this.selectedbizservice = selectedBizservice;
    }

    public void newBizSubServiceInstance(List<BizSubservice> bizSubservices, List<BizSubservice> selectedBizSubservice, String dialogTypeName) {
        this.bizSubservices = bizSubservices;
        this.dialogTypeName = dialogTypeName;
        this.selectedBizSubservices = selectedBizSubservice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(false);
        setContentView(R.layout.connection_multi_select_filter_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        call_adapter();
    }

    private void callTypeFace() {
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void call_adapter() {
        switch (dialogTypeName) {
            case "Region":
                ConnectionRegionAdapter connectionRegionAdapter = new ConnectionRegionAdapter(activity);
                connectionRegionAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionRegionAdapter);
                connectionRegionAdapter.addAll(regions, selectedRegions);
                break;
            case "City":
                ConnectionCityAdapter connectionCityAdapter = new ConnectionCityAdapter(activity);
                connectionCityAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionCityAdapter);
                connectionCityAdapter.addAll(cities, selectedCities);
                break;
            case "WishList":
                ConnectionWishListAdapter connectionWishListAdapter = new ConnectionWishListAdapter(activity);
                connectionWishListAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionWishListAdapter);
                connectionWishListAdapter.addAll(wishlists, selectedWishlists);
                break;
            case "Service":
                ConnectionServiceAdapter connectionServiceAdapter = new ConnectionServiceAdapter(activity);
                connectionServiceAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionServiceAdapter);
                connectionServiceAdapter.addAll(services, selectedService);
                break;
            case "Tag":
                ConnectionTagsAdapter connectionTagsAdapter = new ConnectionTagsAdapter(activity);
                connectionTagsAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionTagsAdapter);
                connectionTagsAdapter.addAll(tags, selectedTag);
                break;
            case "BizService":
                ConnectionBizServiceAdapter connectionBizServiceAdapter = new ConnectionBizServiceAdapter(activity);
                connectionBizServiceAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionBizServiceAdapter);
                connectionBizServiceAdapter.addAll(bizservices, selectedbizservice);
                break;
            case "BizSubService":
                ConnectionBizSubServiceAdapter connectionBizSubServiceAdapter = new ConnectionBizSubServiceAdapter(activity);
                connectionBizSubServiceAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(connectionBizSubServiceAdapter);
                connectionBizSubServiceAdapter.addAll(bizSubservices, selectedBizSubservices);
                break;
        }
    }

    @OnClick({R.id.apply_btn, R.id.cancel_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                call_click();
                dismiss();
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
        }
    }

    private void call_click() {
        switch (dialogTypeName) {
            case "Region":
                passListItems.RegionPassData(regionList);
                break;
            case "City":
                passListItems.CityPassData(cityList);
                break;
            case "WishList":
                passListItems.WishListPassData(wishlist);
                break;
            case "Service":
                passListItems.ServicePassData(service);
                break;
            case "Tag":
                passListItems.TagsPassData(tag);
                break;
            case "BizService":
                passListItems.BizServicesPassData(bizservice);
                break;
            case "BizSubService":
                passListItems.BizSubServicesPassData(bizSubservice);
                break;
        }
    }

    @Override
    public void OnViewItemClick(Region singleList) {
        int num;
        boolean itemTheir = false;
        if (regionList.size() == 0) {
            regionList.add(singleList);
        } else {
            num = regionList.size();
            for (int i = 0; i < num; i++) {
                if (regionList.get(i).getReRegionId().equals(singleList.getReRegionId())) {
                    regionList.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                regionList.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(City singleList) {
        int num;
        boolean itemTheir = false;
        if (cityList.size() == 0) {
            cityList.add(singleList);
        } else {
            num = cityList.size();
            for (int i = 0; i < num; i++) {
                if (cityList.get(i).getCiCityId().equals(singleList.getCiCityId())) {
                    cityList.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                cityList.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(Wishlist singleList) {
        int num;
        boolean itemTheir = false;
        if (wishlist.size() == 0) {
            wishlist.add(singleList);
        } else {
            num = wishlist.size();
            for (int i = 0; i < num; i++) {
                if (wishlist.get(i).getWitTagId().equals(singleList.getWitTagId())) {
                    wishlist.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                wishlist.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(Service singleList) {
        int num;
        boolean itemTheir = false;
        if (service.size() == 0) {
            service.add(singleList);
        } else {
            num = service.size();
            for (int i = 0; i < num; i++) {
                if (service.get(i).getOgcCategoryId().equals(singleList.getOgcCategoryId())) {
                    service.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                service.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(Tag singleList) {
        int num;
        boolean itemTheir = false;
        if (tag.size() == 0) {
            tag.add(singleList);
        } else {
            num = tag.size();
            for (int i = 0; i < num; i++) {
                if (tag.get(i).getTgTagId().equals(singleList.getTgTagId())) {
                    tag.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                tag.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(Bizservice singleList) {
        int num;
        boolean itemTheir = false;
        if (bizservice.size() == 0) {
            bizservice.add(singleList);
        } else {
            num = bizservice.size();
            for (int i = 0; i < num; i++) {
                if (bizservice.get(i).getIcaCategoryId().equals(singleList.getIcaCategoryId())) {
                    bizservice.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                bizservice.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(BizSubservice singleList) {
        int num;
        boolean itemTheir = false;
        if (bizSubservice.size() == 0) {
            bizSubservice.add(singleList);
        } else {
            num = bizSubservice.size();
            for (int i = 0; i < num; i++) {
                if (bizSubservice.get(i).getIscSubCategoryId().equals(singleList.getIscSubCategoryId())) {
                    bizSubservice.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                bizSubservice.add(singleList);
            }
        }
    }

    public interface PassListItems {
        void RegionPassData(List<Region> regions);

        void CityPassData(List<City> cities);

        void WishListPassData(List<Wishlist> wishlists);

        void ServicePassData(List<Service> services);

        void BizServicesPassData(List<Bizservice> bizservices);

        void BizSubServicesPassData(List<BizSubservice> bizSubservices);

        void TagsPassData(List<Tag> tags);
    }

    public void setPassListItems(PassListItems passListItems) {
        this.passListItems = passListItems;
    }

}