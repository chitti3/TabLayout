package com.example.youthhub.FirstOpenPage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.signUpPage.ActivitySignUp;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentInvitation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInvitation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.invite_img)
    ImageView inviteImg;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.invite_btn)
    Button inviteBtn;
    @BindView(R.id.constrain)
    ConstraintLayout constrain;
    @BindView(R.id.invite_txt)
    TextView inviteTxt;
    @BindView(R.id.invite_txt2)
    TextView inviteTxt2;
    @BindView(R.id.gotIt_btn)
    Button gotItBtn;
    Unbinder unbinder;

    private OnFragmentInteractionListener mListener;

    Activity activity;

    public FragmentInvitation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentInvitation.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentInvitation newInstance(String param1, String param2) {
        FragmentInvitation fragment = new FragmentInvitation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invitation, container, false);
        unbinder = ButterKnife.bind(this, view);

        callTypeFace();

        return view;
    }

    private void callTypeFace() {
        inviteBtn.setTypeface(FontTypeFace.fontBold(activity));
        inviteTxt.setTypeface(FontTypeFace.fontBold(activity));
        gotItBtn.setTypeface(FontTypeFace.fontBold(activity));
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

    @OnClick(R.id.gotIt_btn)
    public void onViewClicked() {
        Intent signUpIntent = new Intent(activity, ActivitySignUp.class);
        startActivity(signUpIntent);
        activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
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
