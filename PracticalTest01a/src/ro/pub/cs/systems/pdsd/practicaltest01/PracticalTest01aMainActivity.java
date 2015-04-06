package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01aMainActivity extends Activity {
	
	ButtonClickListener l = new ButtonClickListener();
	EditText text;
	Button[] buttons = new Button[6];
	
	int press_no;
	
	protected class ButtonClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			switch(v.getId()) {
			case R.id.top_left:
				String firstString = text.getText().toString();
				String  secondString = buttons[1].getText().toString();
				text.setText(firstString + secondString + ","); 
				press_no++;
				break;
				
			case R.id.top_right:
				firstString = text.getText().toString();
				secondString = buttons[2].getText().toString();
				text.setText(firstString + secondString + ",");     
				break;
				
			case R.id.center:
				firstString = text.getText().toString();
				secondString = buttons[3].getText().toString();
				text.setText(firstString + secondString + ",");     
				break;
				
			case R.id.bottom_left:
				firstString = text.getText().toString();
				secondString = buttons[4].getText().toString();
				text.setText(firstString + secondString + ",");     
				break;
				
			case R.id.bottom_right:
				firstString = text.getText().toString();
				secondString = buttons[5].getText().toString();
				text.setText(firstString + secondString + ",");     
				break;
			
			case R.id.navigate:
		          Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
		          intent.putExtra("number_of_clicks", String.valueOf(text.getText().toString()));
		          startActivityForResult(intent, 1);
		          break;
			}
			
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01a_main);
		
		int i;
		
		text = (EditText) findViewById(R.id.text);
		
		buttons[0] = (Button) findViewById(R.id.navigate);
		buttons[1] = (Button) findViewById(R.id.top_left);
		buttons[2] = (Button) findViewById(R.id.top_right);
		buttons[3] = (Button) findViewById(R.id.center);
		buttons[4] = (Button) findViewById(R.id.bottom_left);
		buttons[5] = (Button) findViewById(R.id.bottom_right);
		
		for(i = 0; i < 6; i++) {
			buttons[i].setOnClickListener(l);
		}
		
		
		if(savedInstanceState != null) {
			Toast.makeText(this, Integer.toString(savedInstanceState.getInt("press_no")), Toast.LENGTH_LONG).show();
			press_no = savedInstanceState.getInt("press_no");
		} else
			press_no = 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01a_main, menu);
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
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	 
	  savedInstanceState.putInt("press_no", press_no);
	}
	
//	protected void onRestoreInstanceState(Bundle savedInstanceState) {
//		  super.onRestoreInstanceState(savedInstanceState);
//		  
//		  Toast.makeText(this, Integer.toString(savedInstanceState.getInt("press_no")), Toast.LENGTH_LONG).show();
//		  
//		}
	
	@Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
      Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
      //press_no = 0;
      text.setText(""); 
      
    }
}
