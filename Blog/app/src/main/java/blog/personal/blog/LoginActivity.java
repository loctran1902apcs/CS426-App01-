package blog.personal.blog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends Activity {

	private CallbackManager mCallbackManager;
	private static final String TAG = "FACELOG";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// Initialize Facebook Login button
		mCallbackManager = CallbackManager.Factory.create();

		LoginButton loginButton = (LoginButton) findViewById(R.id.button_facebook_login);
		loginButton.setReadPermissions("email", "public_profile");
		loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {
				Log.d(TAG, "facebook:onSuccess:" + loginResult);
				//handleFacebookAccessToken(loginResult.getAccessToken());
			}

			@Override
			public void onCancel() {
				Log.d(TAG, "facebook:onCancel");
				// ...
			}

			@Override
			public void onError(FacebookException error) {
				Log.d(TAG, "facebook:onError", error);
				// ...
			}
		});

// ...
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Pass the activity result back to the Facebook SDK
		mCallbackManager.onActivityResult(requestCode, resultCode, data);
	}
}
