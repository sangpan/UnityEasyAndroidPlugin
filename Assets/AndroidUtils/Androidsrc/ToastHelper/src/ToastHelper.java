package net.gamya.android.utils;

import android.app.Activity;
import android.widget.Toast;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.content.DialogInterface;
import android.view.KeyEvent;

import android.view.View;
import android.widget.RelativeLayout;


public class ToastHelper 
{
	private Activity activity;
	
	public ToastHelper(Activity activity) 
	{
		this.activity = activity;
	}

	public void showToast(String text) 
	{
		// final String t = "WOW EAAAAAAAAAASSY" + text;
		// activity.runOnUiThread(new Runnable() {
		// 	@Override
		// 	public void run() 
		// 	{
		// 		Toast.makeText(activity.getApplicationContext(), 
		// 			t != null? t : "",
   		// 			Toast.LENGTH_LONG).show();
		// 	}
		// });

		DialogTest newDialogTest = new DialogTest(this.activity);
		newDialogTest.startDialog();;
	}

	public class DialogTest {
		public DialogTest (Context context) {
			this.context = context;
		}
		private Context context;
		public void startDialog() {
			// avoid ThreadException Crash : 'Only the original thread that created a view hierarchy can touch its views.'
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					final Dialog dlg = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
					dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
					dlg.setContentView(
						//R.layout.blur_test
						context.getResources().getIdentifier("blur_test", "layout", context.getPackageName())
					);
					dlg.setCancelable(false);
					dlg.show();

					RelativeLayout mainbuton = dlg.findViewById(
						context.getResources().getIdentifier("popup_button_sub_button", "id", context.getPackageName())
						);
		
					mainbuton.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dlg.dismiss();
						}
					});

				}
			});

		}
	}


}