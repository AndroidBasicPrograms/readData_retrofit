package com.example.jayhind.lecture_app.Retrofit;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jayhind.lecture_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class readDataActivity extends AppCompatActivity implements retrofitAdapter.UserClickListener {
    RecyclerView Rv;
    private Context context;
    apiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_read_data);
        setTitle("hello");
        Rv=findViewById(R.id.rv);
        apiService =apiClient.getclient().create(apiService.class);
        Rv.setLayoutManager(new LinearLayoutManager(context));
        fetchUsers();
    }

    private void fetchUsers() {
        Call<userResponse> call = apiService.getAllUser();
        call.enqueue(new Callback<userResponse>() {
            @Override
            public void onResponse(Call<userResponse> call, Response<userResponse> response) {
                ArrayList<user> users = (ArrayList<user>) response.body().getData();
                Log.d("TAG", "Number of Users received: " + users.size());
//              Rv.setAdapter(new MyDataAdapter(users, R.layout.list_item_user,context));
                Rv.setAdapter(new retrofitAdapter(users,readDataActivity.this));
            }

            @Override
            public void onFailure(Call<userResponse>call, Throwable t) {
                // Log error here since request failed
                Log.d("TAG", t.toString());
            }
        });
    }

    @Override
    public void onUserClick(user users) {
       fetchUsers();
    }
}
