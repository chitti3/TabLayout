package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.ProfileYouthInfoResponse;
import com.example.youthhub.resModel.profile.profileinfo.EmuResponsibilitiesItem;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.update.ProfileUpdateVolunteerResponse;
import com.example.youthhub.utils.AppUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KeyResponabilityAdapter extends RecyclerView.Adapter<KeyResponabilityAdapter.MyViewHolder> {

    Activity activity;


OnPassDataListener onPassDataListener;

    List<EmuResponsibilitiesItem> emuResponsibilities;



    public KeyResponabilityAdapter(Activity activity, List<EmuResponsibilitiesItem> emuResponsibilities) {
        this.activity = activity;
        this.emuResponsibilities = emuResponsibilities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_keyresponability, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        callTypeFace(holder);

        holder.keyResponabilityDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAt(i);
            }
        });

        holder.keyResponabilityAdapter.setText(emuResponsibilities.get(i).getName());
        holder.keyResponabilityAdapter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              //  holder.keyResponabilityAdapter.setText(s.toString());
                EmuResponsibilitiesItem emuResponsibilitiesItem = new EmuResponsibilitiesItem();
                emuResponsibilitiesItem.setName(s.toString());
                emuResponsibilities.set(i,emuResponsibilitiesItem);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



       // onPassDataListener.onPassData(responability_data,true);
    }

    private void callTypeFace(MyViewHolder holder) {

    }

    @Override
    public int getItemCount() {
        return emuResponsibilities.size();
    }

    public String getData(){
        String responability_data = "";
        for (int j = 0; j < emuResponsibilities.size(); j++) {
            if (emuResponsibilities.get(j).getName().length()>0) {
                responability_data = responability_data + emuResponsibilities.get(j).getName() + ",";
            }else{
                responability_data = "";
                break;
            }
        }
        if (responability_data.length()>0){
            responability_data = AppUtils.removeLastChar(responability_data);
        }
        return responability_data;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.key_responability_adapter)
        EditText keyResponabilityAdapter;
        @BindView(R.id.key_responability_delete)
        ImageView keyResponabilityDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public void removeAt(int position) {
        emuResponsibilities.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, emuResponsibilities.size());
    }

    public interface OnPassDataListener {
        void onPassData(String responability, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }
}