package com.example.waqas.cannongame;


import android.media.AudioManager;
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

    private CannonView cannonView;  //This view will display the game

    //onCreateView is called to build and return a view containing the Fragment's GUI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //Inflates GUI of Fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_cannon_game, container, false);

        //Gets reference to Fragment's CannonView, so it's methods can be used
        cannonView = (CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //Allows game volume to be controlled by device's volume keys
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onPause(){
        super.onPause();
        cannonView.stopGame();  //Method defined in class CannonView
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cannonView.releaseResources();  //Method defined in class CannonView
    }

    public CannonGameFragment() {
        // Required empty public constructor
    }
}
