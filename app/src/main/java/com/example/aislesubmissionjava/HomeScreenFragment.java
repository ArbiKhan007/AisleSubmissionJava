package com.example.aislesubmissionjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aislesubmissionjava.adapter.Profile2Adapter;
import com.example.aislesubmissionjava.adapter.ProfileAdapter;
import com.example.aislesubmissionjava.databinding.FragmentHomeScreenBinding;
import com.example.aislesubmissionjava.model.Invites;
import com.example.aislesubmissionjava.model.Profile;
import com.example.aislesubmissionjava.model.Profile__1;
import com.example.aislesubmissionjava.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenFragment extends Fragment {
    private FragmentHomeScreenBinding binding;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ProfileAdapter adapter;
    private Profile2Adapter adapter2;
    private List<Profile> tileList;

    public HomeScreenFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.recyclerView;
        adapter = new ProfileAdapter(requireActivity(), new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        recyclerView2 = binding.recyclerView2;
        adapter2 = new Profile2Adapter(requireActivity(), new ArrayList<>());
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setHasFixedSize(false);
        recyclerView2.setLayoutManager(new GridLayoutManager(requireActivity(), 2));

        setupObservers();

        viewModel.getInvites();
    }

    private void setupObservers() {
        viewModel.getInvitesLiveData().observe(requireActivity(), new Observer<Invites>() {
            @Override
            public void onChanged(Invites invites) {
                if(invites != null){
                    List<Profile> profiles = invites.getInvites().getProfiles();
                    List<Profile__1> profileLikes = invites.getLikes().getProfiles();

                    adapter.setProfileList(profiles);
                    adapter2.setProfileList(profileLikes);

                    adapter.notifyDataSetChanged();
                    adapter2.notifyDataSetChanged();
                }
            }
        });
    }
}