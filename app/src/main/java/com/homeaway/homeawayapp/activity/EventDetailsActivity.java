package com.homeaway.homeawayapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.homeaway.homeawayapp.R;
import com.homeaway.homeawayapp.model.Event;
import com.homeaway.homeawayapp.util.Constants;
import com.homeaway.homeawayapp.util.SharedPreferenceUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class EventDetailsActivity extends BaseActivity {
    private ImageLoader imageLoader;
    private int eventId;
    @Override
    public String getTag() {
        return EventDetailsActivity.class.getCanonicalName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        Intent intent = getIntent();
        if(intent != null) {
            this.eventId = intent.getIntExtra(Constants.IntentExtras.EVENT_ID,0);
            TextView titleTextView = (TextView) findViewById(R.id.search_name_textView);
            titleTextView.setText(intent.getStringExtra(Constants.IntentExtras.EVENT_TITLE));
            TextView locationTextView = (TextView) findViewById((R.id.location_textView));
            locationTextView.setText(intent.getStringExtra(Constants.IntentExtras.EVENT_LOCATION));
            TextView dateTimeTextView = (TextView) findViewById(R.id.dateTime_textView);
            dateTimeTextView.setText(intent.getStringExtra(Constants.IntentExtras.EVENT_DATE_TIME));
            ImageView eventImageView = (ImageView)findViewById(R.id.search_imageView);
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
            this.imageLoader = ImageLoader.getInstance();
            this.imageLoader.init(config);
            String  imageUrl = intent.getStringExtra(Constants.IntentExtras.EVENT_IMAGE_URL);
            if(imageUrl != null) {
                this.imageLoader.displayImage(imageUrl, eventImageView);
            }else{
                eventImageView.setImageResource(R.mipmap.ic_launcher);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.favorite_event){
            View itemView = item.getActionView();
            if(itemView != null) {
                ImageView favoriteImageView = itemView.findViewById(R.id.favorite_event);
                //TODO : Toggle the favorite icon
                boolean eventFavored = false;
                if (!eventFavored) {
                    favoriteImageView.setImageResource(R.drawable.ic_favorite_black_24dp);
                    eventFavored = true;
                } else if (eventFavored) {

                }
                //TODO : save the value
                SharedPreferenceUtil.savePreference(this, Constants.IntentExtras.EVENT_ID, this.eventId);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
