package com.example.youthhub.dashBoard.createPost;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.youthhub.R;
import com.example.youthhub.profile.profileTabSubViews.TagsItemAdapter;
import com.example.youthhub.resModel.post.createPost.JourneyList;
import com.example.youthhub.resModel.post.createPost.Tag;
import com.example.youthhub.resModel.profile.visualjourney.TagsItem;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TagsJourneyDialog extends Dialog implements TagsAdapter.OnViewClickListener, JourneyListAdapter.OnViewClickListener, TagsItemAdapter.OnViewTagClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;

    private Activity activity;

    private String from;

    //load data
    private List<Tag> tags;
    private List<TagsItem> tagsItems;
    private List<JourneyList> journeys;

    //load selected data
    private List<Tag> selectedTag;
    private List<TagsItem> selectedTagItem;
    private List<JourneyList> selectedJourneyList;

    //selected lists
    private List<Tag> tagList = new ArrayList<>();
    private List<TagsItem> tagsItemList = new ArrayList<>();
    private List<JourneyList> journeyLists = new ArrayList<>();


    private PassListItems passListItems;

    public void setPassListItems(PassListItems passListItems) {
        this.passListItems = passListItems;
    }

    public TagsJourneyDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newTagsInstance(List<Tag> tags, List<Tag> selectedTag) {
        this.tags = tags;
        this.selectedTag = selectedTag;
        this.from = "Tags";
    }

    void newJourneyListInstance(List<JourneyList> journeys, List<JourneyList> selectedJourneyList) {
        this.journeys = journeys;
        this.selectedJourneyList = selectedJourneyList;
        this.from = "Journey";
    }

    public void newTagsInstance1(List<TagsItem> tags, List<TagsItem> selectedTags) {
        this.tagsItems = tags;
        this.selectedTagItem = selectedTags;
        this.from = "TagsItem";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tags_journey_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        call_adapter();
    }

    private void call_adapter() {
        switch (from) {
            case "Tags":

                TagsAdapter tagsAdapter = new TagsAdapter(activity);
                tagsAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(tagsAdapter);
                tagsAdapter.addAll(tags, selectedTag);
                break;
            case "Journey":
                JourneyListAdapter journeyListAdapter = new JourneyListAdapter(activity);
                journeyListAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(journeyListAdapter);
                journeyListAdapter.addAll(journeys, selectedJourneyList);
                break;
            case "TagsItem":
                TagsItemAdapter tagsItemAdapter = new TagsItemAdapter(activity);
                tagsItemAdapter.setOnViewClickListener(this);
                recyclerView.setAdapter(tagsItemAdapter);
                tagsItemAdapter.addAll(tagsItems, selectedTagItem);
                break;
        }
    }

    private void callTypeFace() {
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
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
        switch (from) {
            case "Tags":
                passListItems.TagsPassData(tagList);
                break;
            case "Journey":
                passListItems.JourneyPassData(journeyLists);
                break;
                case "TagsItem":
                passListItems.TagsItemPassData(tagsItemList);
                break;
        }
    }

    @Override
    public void OnViewItemClick(JourneyList singleList) {
        int num;
        boolean itemTheir = false;
        if (journeyLists.size() == 0) {
            journeyLists.add(singleList);
        } else {
            num = journeyLists.size();
            for (int i = 0; i < num; i++) {
                if (journeyLists.get(i).getJumJourneyId().equals(singleList.getJumJourneyId())) {
                    journeyLists.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                journeyLists.add(singleList);
            }
        }
    }

    @Override
    public void OnViewItemClick(Tag singleList) {
        int num;
        boolean itemTheir = false;
        if (tagList.size() == 0) {
            tagList.add(singleList);
        } else {
            num = tagList.size();
            for (int i = 0; i < num; i++) {
                if (tagList.get(i).getTgTagId().equals(singleList.getTgTagId())) {
                    tagList.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                tagList.add(singleList);
            }
        }
    }



    @Override
    public void OnViewTagItemClick(TagsItem singleList) {
        int num;
        boolean itemTheir = false;
        if (tagsItemList.size() == 0) {
            tagsItemList.add(singleList);
        } else {
            num = tagsItemList.size();
            for (int i = 0; i < num; i++) {
                if (tagsItemList.get(i).getTgTagId().equals(singleList.getTgTagId())) {
                    tagsItemList.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                tagsItemList.add(singleList);
            }
        }
    }

    public interface PassListItems {
        void TagsPassData(List<Tag> tags);
        void TagsItemPassData(List<TagsItem> tags);
        void JourneyPassData(List<JourneyList> journeyLists);
    }

}