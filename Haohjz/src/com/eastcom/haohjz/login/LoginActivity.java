package com.eastcom.haohjz.login;

import com.eastcom.haohjz.MainActivity;
import com.eastcom.haohjz.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText usernameEditText;
	private EditText psdEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		usernameEditText = (EditText)findViewById(R.id.login_usname);
		psdEditText = (EditText) findViewById(R.id.login_psd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	public void click(View view){
		switch (view.getId()) {
		case R.id.login_ok:
		{
			if (200 == login()) {
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
			}else {
				Toast.makeText(LoginActivity.this, "错误的账号或密码", Toast.LENGTH_LONG).show();
			}
			break;
		}	
		case R.id.login_cancel:
		{
			finish();
			break;
		}

		default:
			break;
		}
	}

	public int login()
	{
		if (usernameEditText.getText().toString().equals("yxc")) {
			return 200;
		}else{
			return 404;
		}
	}
}
