package id.mydss.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import id.mydss.cores.Account;
import id.mydss.cores.ApiClient;
import id.mydss.cores.ApiInterfaces;
import id.mydss.cores.Modul;
import id.mydss.cores.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AttendanceApp extends AppCompatActivity {
    ApiInterfaces  apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_app);
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 apiInterface = ApiClient.getRetrofitInstance("xx", getApplicationContext()).create(ApiInterfaces.class);
                Call<User> call3 = apiInterface.Authenticate(new Account("budi@gmail.com", "root"));
                call3.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        //   LokasiList lokasiList = response.body();

                        User resp = response.body();
                        Log.wtf("APP-DSS-ON-RESPONSE", String.valueOf(response.raw()));

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        call.cancel();
                        Log.wtf("APP-DSS-ON-FAILURE", t.getMessage());
                        //Intent i = new Intent(getApplicationContext(), Biodata.class);
                        //  i.putExtra("name", name.getText().toString());
                        //startActivity(i);
                    }
                });
            }
        });
    }
}
