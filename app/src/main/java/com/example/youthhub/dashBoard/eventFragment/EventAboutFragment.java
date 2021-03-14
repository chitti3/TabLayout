package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.event.eventView.EventViewData;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventAboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventAboutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Unbinder unbinder;
    @BindView(R.id.event_hosted)
    TextView eventHosted;
    @BindView(R.id.event_end_date)
    TextView eventEndDate;
    @BindView(R.id.event_desc_title)
    TextView eventDescTitle;
    @BindView(R.id.event_desc)
    TextView eventDesc;
    @BindView(R.id.event_location_title)
    TextView eventLocationTitle;
    @BindView(R.id.event_location)
    TextView eventLocation;
    @BindView(R.id.map_view)
    ImageView mapView;
    @BindView(R.id.nested_scroll)
    NestedScrollView nestedScroll;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    EventViewData eventViewData;

    public EventAboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventAboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventAboutFragment newInstance(String param1, String param2) {
        EventAboutFragment fragment = new EventAboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static EventAboutFragment newInstance(EventViewData eventViewData) {
        EventAboutFragment fragment = new EventAboutFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.EventViewData, eventViewData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventViewData = getArguments().getParcelable(Constants.EventViewData);

        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_about, container, false);
        unbinder = ButterKnife.bind(this, view);
        callTypeFace();
        updateView();

        return view;
    }

    private void updateView() {

        String hosted = "Hosted by " + eventViewData.getEventView().getPostbyUserName();
        String endDate = "End Date: "+eventViewData.getEventView().getEventEndDate();
        String desc = eventViewData.getEventView().getEventDetail();
        String location = eventViewData.getEventView().getEventAddress()+"\n"+
                eventViewData.getEventView().getEventCityName()+"\n"+
                eventViewData.getEventView().getEventRegionName()+"\n"+
                eventViewData.getEventView().getEventContactNo()+"\n"+
                eventViewData.getEventView().getEventContactEmail()+"\n"+
                eventViewData.getEventView().getEventContactName();

        eventHosted.setText(hosted);
        eventEndDate.setText(endDate);
        eventDesc.setText(desc);
        eventLocation.setText(location);
    }

    private void callTypeFace() {
        eventHosted.setTypeface(FontTypeFace.fontMedium(activity));
        eventDescTitle.setTypeface(FontTypeFace.fontMedium(activity));
        eventLocationTitle.setTypeface(FontTypeFace.fontMedium(activity));
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
