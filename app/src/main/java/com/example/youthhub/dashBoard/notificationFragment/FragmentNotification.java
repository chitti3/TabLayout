package com.example.youthhub.dashBoard.notificationFragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.youthhub.DataModel1;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.FragmentTransfer;
import com.example.youthhub.utils.FontTypeFace;

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
 * Use the {@link FragmentNotification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNotification extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.notification_txt)
    TextView notificationTxt;
    @BindView(R.id.notification_recycler)
    RecyclerView notificationRecycler;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    Activity activity;
    FragmentTransfer fragmentTransfer;

    List<DataModel1> dataModel1List;

    public FragmentNotification() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNotification.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNotification newInstance(String param1, String param2) {
        FragmentNotification fragment = new FragmentNotification();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        unbinder = ButterKnife.bind(this, view);
        fragmentTransfer = (FragmentTransfer) activity;
        fragmentTransfer.hideSearchView(true);
        callTypeFace();

        notification_list();

        return view;
    }

    private void callTypeFace() {
        notificationTxt.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void notification_list() {

        notificationRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        dataModel1List = new ArrayList<>();

        dataModel1List.add(
                new DataModel1(
                        "<big><b><font color='#000000'>Peter</font></b></big> started following you",
                        "15 hours ago",
                        R.drawable.profile_img1));

        dataModel1List.add(
                new DataModel1(
                        "<big><b><font color='#000000'>Sara</font></b></big> liked your post",
                        "15 hours ago",
                        R.drawable.profile_img1));
        dataModel1List.add(
                new DataModel1(

                        "<big><b><font color='#000000'>Lee</font></b></big> sent you a follow request",
                        "15 hours ago",
                        R.drawable.profile_img1));

        dataModel1List.add(
                new DataModel1(

                        "<big><b><font color='#000000'>Sara</font></b></big> and <big><b><font color='#000000'>5 others</font></b></big> liked your post",
                        "15 hours ago",
                        R.drawable.profile_img1));
        dataModel1List.add(
                new DataModel1(

                        "<big><b><font color='#000000'>Mary</font></b></big> sent an invite",
                        "15 hours ago",
                        R.drawable.profile_img1));
        dataModel1List.add(
                new DataModel1(
                        "<big><b><font color='#000000'>Peter</font></b></big> started following you",
                        "15 hours ago",
                        R.drawable.profile_img1));

        dataModel1List.add(
                new DataModel1(
                        "<big><b><font color='#000000'>Sara</font></b></big> liked your post",
                        "15 hours ago",
                        R.drawable.profile_img1));
        dataModel1List.add(
                new DataModel1(

                        "<big><b><font color='#000000'>Lee</font></b></big> sent you a follow request",
                        "15 hours ago",
                        R.drawable.profile_img1));

        dataModel1List.add(
                new DataModel1(

                        "<big><b><font color='#000000'>Sara</font></b></big> and <big><b><font color='#000000'>5 others</font></b></big> liked your post",
                        "15 hours ago",
                        R.drawable.profile_img1));
        dataModel1List.add(
                new DataModel1(

                        "<big><b><font color='#000000'>Mary</font></b></big> sent an invite",
                        "15 hours ago",
                        R.drawable.profile_img1));


        NotificationAdapter adapter = new NotificationAdapter(activity,dataModel1List);
        notificationRecycler.setAdapter(adapter);

        adapter.notifyDataSetChanged();

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
