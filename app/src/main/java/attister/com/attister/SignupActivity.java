package attister.com.attister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword;
    Spinner department;
    TextView tvLogin;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.name);
        etEmail = findViewById(R.id.email);
        department = findViewById(R.id.department);
        etPassword = findViewById(R.id.password);
        etConfirmPassword = findViewById(R.id.confirm_password);
        btnSubmit = findViewById(R.id.submit);
        tvLogin = findViewById(R.id.login);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etPassword.getText().toString().trim().equals(etConfirmPassword.getText().toString().trim())){
                    Toast.makeText(SignupActivity.this, "Password and Confirm Password doesn't match", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etEmail.getText()) || !Patterns.EMAIL_ADDRESS.matcher(etEmail.getText()).matches()) {
                    Toast.makeText(SignupActivity.this, "Email Required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etName.getText().toString().trim().length() == 0) {
                    Toast.makeText(SignupActivity.this, "Email Required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etConfirmPassword.getText().toString().trim().length() == 0) {
                    Toast.makeText(SignupActivity.this, "Email Required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etPassword.getText().toString().trim().length() == 0) {
                    Toast.makeText(SignupActivity.this, "Email Required", Toast.LENGTH_SHORT).show();
                    return;
                }

                //TODO: Enter data in google sheets
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
