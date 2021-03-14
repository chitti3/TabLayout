package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.topics.TopicContent;
import com.example.youthhub.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExploreTopicAboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreTopicAboutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    Unbinder unbinder;

    public static final String EXPLOREDESCRIPTION = "exploreDescription";

    // TODO: Rename and change types of parameters

    ExploreTopicsAboutAdapter exploreTopicsAboutAdapter;

    private OnFragmentInteractionListener mListener;

    List<TopicContent> topicContent = null;
    String exploreDescription = null;
    Activity activity;

    public ExploreTopicAboutFragment() {
        // Required empty public constructor
    }

    public static ExploreTopicAboutFragment newInstance(List<TopicContent> topicContent, String xmDescription) {
        ExploreTopicAboutFragment fragment = new ExploreTopicAboutFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(Constants.TopicContent, (ArrayList<? extends Parcelable>) topicContent);
        args.putString(EXPLOREDESCRIPTION,xmDescription);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            topicContent = getArguments().getParcelableArrayList(Constants.TopicContent);
            exploreDescription = getArguments().getString(EXPLOREDESCRIPTION);
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore_topic_about, container, false);
        unbinder = ButterKnife.bind(this, view);
        call_adapter();
        return view;
    }

    private void call_adapter() {
        exploreTopicsAboutAdapter = new ExploreTopicsAboutAdapter(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(exploreTopicsAboutAdapter);
        if(topicContent!=null) {
            exploreTopicsAboutAdapter.addAll(topicContent,exploreDescription);
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
