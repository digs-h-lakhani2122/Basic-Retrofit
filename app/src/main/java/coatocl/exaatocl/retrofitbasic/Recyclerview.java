package coatocl.exaatocl.retrofitbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Recyclerview extends AppCompatActivity
{
    RecyclerView recycler;
    List<CustomModel> userListResponseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recycler = findViewById(R.id.recycler);
        getUserListData();

    }

    private void getUserListData()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        Api.getClient().getUsersList(new Callback<List<CustomModel>>() {
            @Override
            public void success(List<CustomModel> userListResponses, Response response) {

                progressDialog.dismiss();
                userListResponseData = userListResponses;
                setDataInRecyclerView();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(Recyclerview.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss(); //dismiss progress dialog

            }
        });
    }

    private void setDataInRecyclerView()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        Adapter adapter = new Adapter(this,userListResponseData);
        recycler.setAdapter(adapter);
    }
}
