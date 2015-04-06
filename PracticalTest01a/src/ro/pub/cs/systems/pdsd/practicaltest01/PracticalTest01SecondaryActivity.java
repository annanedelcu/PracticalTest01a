package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {
	
protected ButtonClickListener l = new ButtonClickListener();
	
	private class ButtonClickListener implements OnClickListener {
		 
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.okButton:
	          setResult(RESULT_OK, new Intent());
	          finish();
	          break;
	        case R.id.cancelButton:
	          setResult(RESULT_CANCELED, new Intent());
	          finish();
	          break;
	      }
	    }
	  }  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Button okButton = (Button) findViewById(R.id.okButton);
		Button cancelButton = (Button) findViewById(R.id.cancelButton);
		TextView numberOfClicksTextView = (TextView)findViewById(R.id.sumText);
		
		okButton.setOnClickListener(l);
		cancelButton.setOnClickListener(l);
		
		 Intent intent = getIntent();
		    if (intent != null) {
		      String sablon = intent.getStringExtra("number_of_clicks");
		      if (sablon != null) {
		        numberOfClicksTextView.setText(getResources().getString(R.string.sumText).replace("", sablon));
		      }
		    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
