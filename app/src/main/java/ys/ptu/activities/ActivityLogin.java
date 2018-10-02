package ys.ptu.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import ys.ptu.R;

/**
 * A login screen that offers login via email/password.
 */
public class ActivityLogin extends AppCompatActivity{

    // UI references.
    private EditText txtUser;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txt_user);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn(txtUser.getEditableText().toString());
            }
        });

    }

    private void logIn(String user) {
        if(user.equals("YannickPTU")) {
           //laad de adminpage
        } else {
            // laad regular page
        }


        Intent intent = new Intent(this, ActAdminHome.class);

        intent.putExtra("user", user);
        startActivity(intent);
    }

}

