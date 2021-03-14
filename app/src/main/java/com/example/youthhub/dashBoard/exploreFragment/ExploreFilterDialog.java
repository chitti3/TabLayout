package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.masterApi.ExploreListMasterResponse;
import com.example.youthhub.resModel.explore.masterApi.ExploreTag;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExploreFilterDialog extends Dialog implements ExploreFilterTagsDialog.PassTagsListItems {

    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.dialog_close)
    ImageView dialogClose;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.post_by)
    EditText postBy;
    @BindView(R.id.tags_txt)
    TextView tagsTxt;
    @BindView(R.id.tags_spinner)
    TextView tagsSpinner;
    @BindView(R.id.shared_exp)
    RadioButton sharedExp;
    @BindView(R.id.my_exp)
    RadioButton myExp;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.clear_btn)
    Button clearBtn;

    //filter data
    String titleData = "";
    String postByData = "";
    private String explore;

    private Activity activity;
    private ExploreListMasterResponse exploreListMasterResponse;

    private List<ExploreTag> exploreTag;
    private List<ExploreTag> exploreTags = new ArrayList<>();

    private OnPassDataListener onPassDataListener;

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    ExploreFilterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance(ExploreListMasterResponse exploreListMasterResponse, List<ExploreTag> exploreTags){
        this.exploreListMasterResponse = exploreListMasterResponse;
        this.exploreTags = exploreTags;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.explore_filter_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        exploreTag = exploreListMasterResponse.getExploreMasterData().getExploreTags();

    }

    private void callTypeFace() {
        filterTxt.setTypeface(FontTypeFace.fontBold(activity));
        tagsTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        clearBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick({R.id.dialog_close, R.id.shared_exp, R.id.my_exp, R.id.apply_btn, R.id.clear_btn, R.id.tags_spinner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_close:
                dismiss();
                break;
            case R.id.shared_exp:
                myExp.setChecked(false);
                break;
            case R.id.my_exp:
                sharedExp.setChecked(false);
                break;
            case R.id.apply_btn:
                sendDatas();
                dismiss();
                break;
            case R.id.clear_btn:
                clear_all();
                break;
            case R.id.tags_spinner:
                tags_spinner_load(exploreTag);
                break;
        }
    }

    private void clear_all() {

        //clearing all values
        titleData = "";
        postByData = "";
        exploreTags = new ArrayList<>();

        title.setText("");
        postBy.setText("");
        tagsSpinner.setText("");
    }

    private void sendDatas() {
        if (sharedExp.isChecked()) {
            explore = "1";
        } else {
            explore = "0";
        }

        titleData = title.getText().toString();
        postByData = postBy.getText().toString();

        onPassDataListener.passData(titleData, postByData, explore , false, exploreTags);

    }

    private void tags_spinner_load(List<ExploreTag> exploreTag) {
        ExploreFilterTagsDialog exploreFilterTagsDialog = new ExploreFilterTagsDialog(activity, exploreTag, exploreTags);
        exploreFilterTagsDialog.setPassTagsListItems(this);
        exploreFilterTagsDialog.show();
    }

    @Override
    public void PassDatas(List<ExploreTag> exploreTags) {
        this.exploreTags = exploreTags;
        String tags = "";
        for(int i=0;i<exploreTags.size();i++){
            if(tags.equals("")){
                tags = exploreTags.get(i).getTgName();
            }else {
                tags = tags +","+ exploreTags.get(i).getTgName();
            }
        }
        tagsSpinner.setText(tags);
    }

    public interface OnPassDataListener {
        void passData(String title, String postBy, String explore, boolean clear, List<ExploreTag> exploreTags);
    }

}