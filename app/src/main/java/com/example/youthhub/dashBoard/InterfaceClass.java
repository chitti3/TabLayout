package com.example.youthhub.dashBoard;

import com.example.youthhub.resModel.post.postList.PostListResponse;
import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;

public class InterfaceClass {

    public interface OnCustomStateListener {
        void stateChanged(PostDashboardListResponse response);
    }

    private static InterfaceClass mInstance;
    private OnCustomStateListener mListener;
    private PostDashboardListResponse response;

    private InterfaceClass() {
    }

    public static InterfaceClass getInstance() {
        if (mInstance == null) {
            mInstance = new InterfaceClass();
        }
        return mInstance;
    }

    void setListener(OnCustomStateListener listener) {
        mListener = listener;
    }

    public void changeState(PostDashboardListResponse response) {
        if (mListener != null) {
            this.response = response;
            notifyStateChange();
        }
    }

    public PostDashboardListResponse getList() {
        return response;
    }

    private void notifyStateChange() {
        mListener.stateChanged(response);
    }

}
