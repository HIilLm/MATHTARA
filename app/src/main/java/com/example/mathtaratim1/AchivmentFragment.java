package com.example.mathtaratim1;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AchivmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AchivmentFragment extends Fragment {

    public AchivmentFragment() {
        // Required empty public constructor
    }

    public static AchivmentFragment newInstance(String param1, String param2) {
        AchivmentFragment fragment = new AchivmentFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_achivment, container, false);

        SharedPreferences prefs = requireActivity().getSharedPreferences("Achievements", requireActivity().MODE_PRIVATE);
        boolean isAchieved = prefs.getBoolean("achievement_story_1", false);

        ImageView achievement1 = view.findViewById(R.id.achievement1);
        if (isAchieved) {
            achievement1.setImageResource(R.drawable.achivement1_unlocked);
        } else {
            achievement1.setImageResource(R.drawable.achivement_locked);
        }

        return view;
    }
}
