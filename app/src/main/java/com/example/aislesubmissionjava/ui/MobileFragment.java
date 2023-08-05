package com.example.aislesubmissionjava.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aislesubmissionjava.R;
import com.example.aislesubmissionjava.databinding.FragmentMobileBinding;
import com.example.aislesubmissionjava.model.MobileStatusReq;
import com.example.aislesubmissionjava.model.Status;
import com.example.aislesubmissionjava.viewmodel.MainViewModel;

import java.util.regex.Matcher;

public class MobileFragment extends Fragment implements View.OnClickListener {
    private FragmentMobileBinding binding;
    private MainViewModel viewModel;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMobileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnContinueMob.setOnClickListener(this);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        navController = Navigation.findNavController(view);

        setupObservers();

        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(false) {
            @Override
            public void handleOnBackPressed() {
                navController.navigateUp();
            }
        });
    }

    private void setupObservers() {
        try {
            viewModel.getUserStatus().observe(requireActivity(), new Observer<Status>() {
                @Override
                public void onChanged(Status status) {
                    if(status != null){
                        if(status.getStatus()){
                            binding.pb.setVisibility(View.GONE);
                            navController.navigate(R.id.action_mobileFragment_to_OTPFragment);
                        }else{
                            Toast.makeText(requireActivity(), "User not found!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_continue_mob){
            String mobileNumber = binding.edtPhoneNumber.getText().toString();
            String countryCode = binding.edtCountryCode.getText().toString();

            if(mobileNumber.trim().isEmpty() || mobileNumber.trim().length() != 10){
                Toast.makeText(requireActivity(), "Mobile Number Invalid", Toast.LENGTH_SHORT).show();
                return;
            }

            if(countryCode.trim().isEmpty() || countryCode.trim().length() != 3){
                Toast.makeText(requireActivity(), "Country Code Invalid", Toast.LENGTH_SHORT).show();
                return;
            }

            MobileStatusReq mobileStatusReq = new MobileStatusReq();
            mobileStatusReq.setNumber(countryCode+mobileNumber);
            viewModel.setMobileNumber(countryCode+mobileNumber);
            viewModel.getUserStatus(mobileStatusReq);
            binding.pb.setVisibility(View.VISIBLE);
        }
    }
}