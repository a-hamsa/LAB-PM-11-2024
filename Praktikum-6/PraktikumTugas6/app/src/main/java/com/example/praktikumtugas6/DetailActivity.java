package com.example.praktikumtugas6;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_AVATAR = "extra_avatar";
    public static final String EXTRA_FIRSTNAME = "extra_firstname";
    public static final String EXTRA_LASTNAME = "extra_lastname";
    public static final String EXTRA_EMAIL = "extra_email";

    private ApiService apiService;

    ProgressBar ad_progressBar;
    ImageView ad_iv_profile;
    TextView ad_tv_name;
    TextView ad_tv_email;
    LinearLayout ad_ll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ad_progressBar = findViewById(R.id.ad_progressBar);
        ad_iv_profile = findViewById(R.id.ad_iv_profile);
        ad_tv_name = findViewById(R.id.ad_tv_name);
        ad_tv_email = findViewById(R.id.ad_tv_email);
        ad_ll = findViewById(R.id.ad_ll);

        apiService = RetrofitClient.getClient();

        int userId = getIntent().getIntExtra("user", -1);

        ad_progressBar.setVisibility(View.VISIBLE);
        ad_ll.setVisibility(View.GONE);

        Call<SingleUserResponse> call = apiService.getUser(userId);
        call.enqueue(new Callback<SingleUserResponse>() {

            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if (response.isSuccessful()){
                    ad_progressBar.setVisibility(View.GONE);
                    ad_ll.setVisibility(View.VISIBLE);
                    User user = response.body().getDataUser();


                    Picasso.get().load(user.getAvatar()).into(ad_iv_profile);
                    ad_tv_name.setText(user.getFirst_name() + " " + user.getLast_name());
                    ad_tv_email.setText(user.getEmail());

                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {

            }
        });

    }
}