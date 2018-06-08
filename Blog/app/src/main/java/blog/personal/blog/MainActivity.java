package blog.personal.blog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button explorebutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		explorebutton = findViewById(R.id.button_explore);

		explorebutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openSigninActivity();
			}
		});
	}

	public void openSigninActivity() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
}
