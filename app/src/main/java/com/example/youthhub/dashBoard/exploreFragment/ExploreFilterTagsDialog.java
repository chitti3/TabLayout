package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Button;

import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.masterApi.ExploreTag;
import com.example.youthhub.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExploreFilterTagsDialog extends Dialog implements ExploreTagsAdapter.OnViewClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.pass_btn)
    Button passBtn;

    private Activity activity;
    private List<ExploreTag> exploreTag;
    private PassTagsListItems passTagsListItems;

    private List<ExploreTag> exploreTags = new ArrayList<>();
    private List<ExploreTag> selectedTags;

    ExploreFilterTagsDialog(Activity activity, List<ExploreTag> exploreTag, List<ExploreTag> selectedTags) {
        super(activity);
        this.activity = activity;
        this.exploreTag = exploreTag;
        this.selectedTags = selectedTags;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(false);
        setContentView(R.layout.explore_filter_tags_dialog);
        ButterKnife.bind(this);
        call_adapter();
    }

    private void call_adapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        ExploreTagsAdapter exploreTagsAdapter = new ExploreTagsAdapter(activity, exploreTag,selectedTags);
        exploreTagsAdapter.setOnViewClickListener(this);
        recyclerView.setAdapter(exploreTagsAdapter);
    }


    void setPassTagsListItems(PassTagsListItems passTagsListItems) {
        this.passTagsListItems = passTagsListItems;
    }

    @Override
    public void OnViewItemClick(ExploreTag exploreTag) {
        int num;
        boolean itemTheir = false;
        if (exploreTags.size() == 0) {
            exploreTags.add(exploreTag);
        } else {
            num = exploreTags.size();
            for (int i = 0; i < num; i++) {
                if (exploreTags.get(i).getTgTagId().equals(exploreTag.getTgTagId())) {
                    exploreTags.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                exploreTags.add(exploreTag);
            }
        }
    }

    @OnClick(R.id.pass_btn)
    public void onViewClicked() {
        passTagsListItems.PassDatas(exploreTags);
        dismiss();
    }

    public interface PassTagsListItems {
        void PassDatas(List<ExploreTag> exploreTags);
    }

}
