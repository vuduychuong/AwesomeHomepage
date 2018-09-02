package com.chuongvd.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chuongvd.awesomehomepage.listener.DrawerSupport;

/**
 * Created on 9/2/18
 *
 * @author Chuongvd
 */
public class SampleFragment extends Fragment implements DrawerSupport {

    private static final String TITLE = "title";

    public static SampleFragment newInstance(String title) {
        Bundle data = new Bundle();
        data.putString(TITLE, title);
        SampleFragment fragment = new SampleFragment();
        fragment.setArguments(data);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        String title = getArguments().getString(TITLE);
        TextView textView = view.findViewById(R.id.textview);
        textView.setText(title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleDrawer();
            }
        });
        return view;
    }

    @Override
    public void toggleDrawer() {
        if (getActivity() == null) return;
        if (getActivity() instanceof DrawerSupport) {
            ((DrawerSupport) getActivity()).toggleDrawer();
            return;
        }
        if (getActivity().getParent() instanceof DrawerSupport) {
            ((DrawerSupport) getActivity().getParent()).toggleDrawer();
        }
    }
}
