package com.example.aislesubmissionjava.ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aislesubmissionjava.R;
import com.example.aislesubmissionjava.databinding.FragmentOtpBinding;
import com.example.aislesubmissionjava.model.TokenGenReq;
import com.example.aislesubmissionjava.model.TokenResponse;
import com.example.aislesubmissionjava.viewmodel.MainViewModel;

import retrofit2.http.Body;

public class OTPFragment extends Fragment implements View.OnClickListener {
    private FragmentOtpBinding binding;
    private MainViewModel viewModel;
    private NavController navController;

    public OTPFragment() {
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
        binding = FragmentOtpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnContinue.setOnClickListener(this);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        navController = Navigation.findNavController(view);
        setupObservers();

        new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                // formula for conversion for
                // milliseconds to minutes.
                long minutes = (l / 1000) / 60;

                // formula for conversion for
                // milliseconds to seconds
                long seconds = (l / 1000) % 60;

                binding.timer.setText(minutes + ":" + seconds);
            }

            @Override
            public void onFinish() {

            }
        }.start();

        binding.tvMobileNumber.setText(viewModel.getMobileNumberLiveData().getValue());

        binding.edtOtpNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 4) {
                    Toast.makeText(requireActivity(), "Max 4 digit allowed", Toast.LENGTH_SHORT).show();
                    binding.edtOtpNum.setText(charSequence.subSequence(0, 4));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setupObservers() {
        viewModel.getToken().observe(requireActivity(), new Observer<TokenResponse>() {
            @Override
            public void onChanged(TokenResponse tokenResponse) {
                binding.pb.setVisibility(View.GONE);
                if (tokenResponse != null) {
                    if(tokenResponse.getToken() != null){
                        try {
                            navController.navigate(R.id.action_OTPFragment_to_homeScreenFragment);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        Toast.makeText(requireActivity(), "Wrong OTP", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_continue) {
            String otp = binding.edtOtpNum.getText().toString();

            if (otp.trim().isEmpty()) {
                Toast.makeText(requireActivity(), "Invalid OTP", Toast.LENGTH_SHORT).show();
                return;
            }

            String userMobileNumber = viewModel.getMobileNumberLiveData().getValue();
            if (userMobileNumber != null) {
                TokenGenReq tokenGenReq = new TokenGenReq();
                tokenGenReq.setOtp(otp);
                tokenGenReq.setNumber(userMobileNumber);
                viewModel.getUserToken(tokenGenReq);
                binding.pb.setVisibility(View.VISIBLE);
            }
        }
    }
}