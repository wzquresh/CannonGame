package com.example.waqas.cannongame;

import android.app.Activity;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CannonGameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CannonGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CannonGameFragment extends Fragment {

    private CannonView cannonView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_cannon_game, container, false);

        cannonView = (CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onPause(){
        super.onPause();
        cannonView.stopGame();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cannonView.releaseResources();
    }

    public CannonGameFragment() {
        // Required empty public constructor
    }
}
