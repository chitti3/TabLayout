package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.VideoViewActivity;
import com.example.youthhub.resModel.event.eventView.EventViewData;
import com.example.youthhub.resModel.event.gallery.Gallery;
import com.example.youthhub.resModel.event.gallery.GalleryData;
import com.example.youthhub.resModel.event.gallery.GalleryResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventVideosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventVideosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "EventVideosFragment";
    Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;

    private OnFragmentInteractionListener mListener;
    Activity activity;

    EventViewData eventViewData;
    Integer page_no = null;
    GalleryResponse galleryResponse;
    GalleryData galleryData;
    List<Gallery> galleries = new ArrayList<>();

    GalleryAdapter galleryAdapter;

    public EventVideosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventVideosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventVideosFragment newInstance(String param1, String param2) {
        EventVideosFragment fragment = new EventVideosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static EventVideosFragment newInstance(EventViewData eventViewData) {
        EventVideosFragment fragment = new EventVideosFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.EventViewData, eventViewData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           /* mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
            eventViewData = getArguments().getParcelable(Constants.EventViewData);
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_videos, container, false);
        unbinder = ButterKnife.bind(this, view);
        //call_adapter();
        call_gallary_api();
        return view;
    }

    private void call_gallary_api() {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            final String access_key = Preference.getInstance(activity).getStr(Constants.AccessKey);
            final String authorizations = "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);

            String eventCode = eventViewData.getEventView().getEventCode();
            String galleryType = "2";
            String pageNo;
            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }

            Call<GalleryResponse> responseCall = ApiClient.getApiInterface().getGallery(Constants.getApiKey(activity),access_key, authorizations, eventCode, galleryType, pageNo);
            responseCall.enqueue(new Callback<GalleryResponse>() {
                @Override
                public void onResponse(@NonNull Call<GalleryResponse> call, @NonNull Response<GalleryResponse> response) {
                    if (response.isSuccessful()) {
                        galleryResponse = response.body();
                        if (galleryResponse != null) {
                            if (galleryResponse.getStatus() == 1) {
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                galleryData = galleryResponse.getGalleryData();
                                galleries.addAll(galleryData.getGallery());
                                if (page_no == null) {
                                    call_adapter(galleryResponse, galleries);
                                } else {
                                    galleryAdapter.addAll(galleries);
                                    galleryAdapter.setLoaded();
                                }
                                page_no = galleryResponse.getNextpage();
                            } else {
                                if (!galleryResponse.getMessage().isEmpty() && galleryResponse.getMessage() != null) {
                                    noListImg.setVisibility(View.VISIBLE);
                                    noListTxt.setVisibility(View.VISIBLE);

                                    Glide.with(activity)
                                            .load(Constants.getLoadGlide(activity,galleryResponse.getStatus_img()))
                                            .apply(AppUtils.getRequestOptionWithoutOverride())
                                            .into(noListImg);

                                    noListTxt.setText(galleryResponse.getMessage());
                                    //MyToast.normalMessage(galleryResponse.getMessage(), activity);
                                }else {
                                    noListImg.setVisibility(View.GONE);
                                    noListTxt.setVisibility(View.GONE);
                                }
                                page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " Gallery", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<GalleryResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " Gallery", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                    Loader.showLoad(activity,false);
                }
            });
        }
    }

    /*private void call_adapter() {
        recyclerView.setNestedScrollingEnabled(false);
        projectsAdapter = new ProjectsAdapter(activity, "EventVideosFragment");
        recyclerView.setAdapter(projectsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        projectsAdapter.notifyDataSetChanged();
    }*/

    private void call_adapter(GalleryResponse galleryResponse, final List<Gallery> galleries) {

        final Map<String, String> imagePath = new HashMap<>();
        imagePath.put("path_video", galleryResponse.getGalleryData().getPathVideo());
        imagePath.put("path_video_poster", galleryResponse.getGalleryData().getPathVideoPoster());

        if (recyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
            recyclerView.setLayoutManager(gridLayoutManager);
            galleryAdapter = new GalleryAdapter(activity, recyclerView, imagePath, galleries, "Videos");
            Log.d(TAG, "call_adapter: "+new Gson().toJson(galleries));
            recyclerView.setAdapter(galleryAdapter);
            recyclerView.setNestedScrollingEnabled(false);
            galleryAdapter.setOnLoadMoreListener(this::onLoadMore);
            galleryAdapter.setPassGalleryDatas(new GalleryAdapter.PassGalleryDatas() {
                @Override
                public void passData(int position) {

                }

                @Override
                public void passVideo(Gallery gallery, String videoPath) {
                    Log.d(TAG, "passVideo: "+videoPath + gallery.getEgaVideo()+"?yh-access-key="+Preference.getInstance(activity).getStr(Constants.AccessKey));
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.VideoPath, videoPath + gallery.getEgaVideo()+"?yh-access-key="+Preference.getInstance(activity).getStr(Constants.AccessKey));
                    Intent videoIntent = new Intent(activity, VideoViewActivity.class);
                    videoIntent.putExtras(bundle);
                    activity.startActivity(videoIntent);
                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                }
            });
        }
    }

    private void onLoadMore() {
        if (page_no != null) {
            galleries.add(null);
            recyclerView.post(new Runnable() {
                                  public void run() {
            galleryAdapter.notifyItemInserted(galleries.size() - 1);
                                  }
            });
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                galleries.remove(galleries.size() - 1);
                int scrollPosition = galleries.size();
                galleryAdapter.notifyItemRemoved(scrollPosition);
                call_gallary_api();
            }, 2000);
        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
