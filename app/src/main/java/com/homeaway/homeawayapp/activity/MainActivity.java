package com.homeaway.homeawayapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.homeaway.homeawayapp.R;
import com.homeaway.homeawayapp.adapter.SearchResultListAdapter;
import com.homeaway.homeawayapp.callback.GetEventListCallback;
import com.homeaway.homeawayapp.model.Event;
import com.homeaway.homeawayapp.network.DaggerNetworkComponent;
import com.homeaway.homeawayapp.network.EventServiceResponse;
import com.homeaway.homeawayapp.network.EventsApiService;
import com.homeaway.homeawayapp.network.NetworkComponent;
import com.homeaway.homeawayapp.network.NetworkModule;
import com.homeaway.homeawayapp.util.Constants;
import com.homeaway.homeawayapp.util.SharedPreferenceUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class MainActivity extends BaseActivity implements GetEventListCallback,
        SearchResultListAdapter.Listener,TextView.OnEditorActionListener{
    private EditText searchEditText;
    //private List<Event> eventDataList;
    private SearchResultListAdapter eventListAdapter;
    private ProgressDialog mProgressDialog;
    NetworkComponent networkComponent;
    @Inject
    EventsApiService mEventsApiService;
    private CompositeSubscription subscriptions;

    @Override
    public String getTag() {
        return MainActivity.class.getCanonicalName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.searchEditText = (EditText)findViewById(R.id.search_editText);
        this.searchEditText.setOnEditorActionListener(this);
        RecyclerView eventListView  = (RecyclerView) findViewById(R.id.search_result_listView);
        networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule()).build();
        networkComponent.inject(this);
        this.subscriptions = new CompositeSubscription();
        //this.eventDataList = new ArrayList();
        this.eventListAdapter = new SearchResultListAdapter(this,this);
        eventListView.setAdapter(this.eventListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        eventListView.setLayoutManager(layoutManager);
        eventListView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        eventListView.addItemDecoration(itemDecoration);
        mProgressDialog = new ProgressDialog(this);
        //mProgressDialog.setTitle("Loading");
        mProgressDialog.setMessage("One moment please...");
        mProgressDialog.setCancelable(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String searchQuery = SharedPreferenceUtil.readPreference(this,Constants.IntentExtras.SEARCH_QUERY,"");
        if(!searchQuery.isEmpty()){
            Subscription subscription = mEventsApiService.getEventsList(this,this.getResources().getString(R.string.seat_geek_api_client_id),searchQuery);
            subscriptions.add(subscription);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        subscriptions.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferenceUtil.clearSearchPreferences(this,Constants.IntentExtras.SEARCH_QUERY);
    }

    @Override
    public void onHttpResponseError(Throwable exception) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        Log.e(getTag(), exception.getMessage());
        showErrorDialog(exception.getMessage());
    }

    @Override
    public void onHttpRequestComplete(EventServiceResponse eventServiceResponse) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        //this.eventDataList = eventServiceResponse.getEventData();
        Log.d(getTag(),"Number of events from HTTP Response "+eventServiceResponse.getEventData().size());
        this.eventListAdapter.setmEventList(eventServiceResponse.getEventData());
        this.eventListAdapter.notifyDataSetChanged();
        Log.d(getTag(),"Number of events in adapter "+this.eventListAdapter.getItemCount());

    }

    @Override
    public void onRowItemClicked(@NonNull Event eventDetails) {
        Intent intent = new Intent(this,EventDetailsActivity.class);
        intent.putExtra(Constants.IntentExtras.EVENT_TITLE,eventDetails.getTitle());
        intent.putExtra(Constants.IntentExtras.EVENT_LOCATION,eventDetails.getVenue().getAddress()
                + ", " + eventDetails.getVenue().getCity() + ", "+eventDetails.getVenue().getCountry());
        intent.putExtra(Constants.IntentExtras.EVENT_DATE_TIME,eventDetails.getDatetimeLocal());
        intent.putExtra(Constants.IntentExtras.EVENT_IMAGE_URL,eventDetails.getPerformers().get(0).getImage());
        intent.putExtra(Constants.IntentExtras.EVENT_ID,eventDetails.getId());
        this.startActivity(intent);
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            performSearch();
            return true;
        }
        return false;

    }

    private void performSearch(){
        searchEditText.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
        mProgressDialog.show();
        String searchQuery = searchEditText.getText().toString();
        Log.d(getTag(),"Search query : "+searchQuery);
        SharedPreferenceUtil.savePreference(this,Constants.IntentExtras.SEARCH_QUERY,searchQuery);
        Subscription subscription = mEventsApiService.getEventsList(this,this.getResources().getString(R.string.seat_geek_api_client_id),searchQuery);
        subscriptions.add(subscription);
    }
}
