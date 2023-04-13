package coatocl.exaatocl.retrofitbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    CustomModel customModel;
    EditText username,userEmail,userPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);

        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            if(validate(username) && validate(userEmail) && validate(userPassword))
            {
                signUp();
                Intent intent =new Intent(this,Recyclerview.class);
                startActivity(intent);
            }
        });
    }

    private void signUp()
    {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        Api.getClient().registration(username.getText().toString().trim(),
                userEmail.getText().toString().trim(),
                userPassword.getText().toString().trim(),
                "email", new Callback<CustomModel>() {
                    @Override
                    public void success(CustomModel customModel1, Response response) {

                        progressDialog.dismiss();
                        customModel = customModel1;
                        Toast.makeText(MainActivity.this, customModel1.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error)
                    {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                    }
                });
    }

    private boolean validate(EditText editText)
    {
        if(editText.getText().toString().trim().length()>0)
        {
            return true;
        }
        editText.setError("please filled up again...");
        return false;
    }
}
