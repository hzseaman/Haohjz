package com.eastcom.haohjz.login;

import com.eastcom.haohjz.MainActivity;
import com.eastcom.haohjz.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment implements OnClickListener{
    private EditText usernamEditText;
    private EditText psdEditText;
    private Button loginOK;
    private Button loginCancel;
    private View view;
    
    static LoginFragment newInstance(String s) {
    	LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hello", s);
        loginFragment.setArguments(bundle);
        return loginFragment;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.TAG, "TestFragment-----onCreate");
        Bundle args = getArguments();
    }
    
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment, container, false);
        usernamEditText = (EditText) view.findViewById(R.id.login_usname);
        psdEditText = (EditText) view.findViewById(R.id.login_psd);
        loginOK = (Button) view.findViewById(R.id.login_ok);
        loginCancel = (Button) view.findViewById(R.id.login_cancel);
        loginOK.setOnClickListener(this);
        loginCancel.setOnClickListener(this);
        return view;

    }
    
    private int login() {
		if (usernamEditText.getText().toString().equals("yxc")&&psdEditText.getText().toString().equals("eastcom")) {
			return 200;
		}else {
			
			return 404;
		}
	}
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG, "TestFragment-----onDestroy");
    }
	@Override
	public void onClick(View v) {
    	switch (v.getId()) {
		case R.id.login_ok:
		{
			if (200 == login()) {
				Intent intent = new Intent(view.getContext(), MainActivity.class);
				startActivity(intent);
			}else {
				Toast.makeText(view.getContext(), "’À∫≈ªÚ’ﬂ√‹¬Î¥ÌŒÛ", Toast.LENGTH_LONG).show();
			}
			break;
		}
		case R.id.login_cancel:
		{
			getActivity().finish();
			break;
		}

		default:
			break;
		}
    	
    }
}
