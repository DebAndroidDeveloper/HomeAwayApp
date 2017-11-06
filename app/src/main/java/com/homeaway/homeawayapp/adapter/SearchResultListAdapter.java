package com.homeaway.homeawayapp.adapter;
import com.homeaway.homeawayapp.R;
import com.homeaway.homeawayapp.model.Event;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultListAdapter extends RecyclerView.Adapter<SearchResultListAdapter.ViewHolder> {
    private static final String TAG = SearchResultListAdapter.class.getCanonicalName();
    private Context mContext;
    private List<Event> mEventList;
    private Listener mListener;
    private ImageLoader imageLoader;

    public SearchResultListAdapter(@NonNull Context context,@NonNull Listener listener){
        this.mEventList = new ArrayList<>();
        this.mContext = context;
        this.mListener = listener;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        this.imageLoader = ImageLoader.getInstance();
        this.imageLoader.init(config);
    }

    public interface Listener {
        void onRowItemClicked(@NonNull Event eventDetails);
    }

    @Override
    public SearchResultListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_search_list_row_view,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SearchResultListAdapter.ViewHolder holder, int position) {
        Event eventDetails =  mEventList.get(position);
        Log.d(TAG,"Event title : "+eventDetails.getTitle() +
                "\n Location : "+eventDetails.getVenue().getAddress()
                + ", " + eventDetails.getVenue().getCity() + ", "+eventDetails.getVenue().getCountry()+
                "\n Date Time : "+eventDetails.getDatetimeLocal());
        holder.txtSearchResult.setText(eventDetails.getTitle());
        holder.txtLocation.setText(eventDetails.getVenue().getAddress()
                + ", " + eventDetails.getVenue().getCity() + ", "+eventDetails.getVenue().getCountry());
        //TODO : Format the date
        holder.txtDateTime.setText(eventDetails.getDatetimeLocal());
        String  imageUrl = eventDetails.getPerformers().get(0).getImage();
        if(imageUrl != null) {
            imageLoader.displayImage(imageUrl, holder.searchImageView);
        }else{
            holder.searchImageView.setImageResource(R.mipmap.ic_launcher);
        }
        holder.itemView.setOnClickListener(createClickListener(eventDetails));
    }

    @Override
    public int getItemCount() {
        return this.mEventList.size();
    }


    public List<Event> getmEventList() {
        return mEventList;
    }

    public void setmEventList(List<Event> mEventList) {
        this.mEventList = mEventList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView searchImageView;
        public TextView txtSearchResult;
        public TextView txtLocation;
        public TextView txtDateTime;

        public ViewHolder(View view){
            super(view);
            this.searchImageView = (ImageView) view.findViewById(R.id.search_imageView);
            this.txtSearchResult = (TextView) view.findViewById(R.id.search_name_textView);
            this.txtLocation = (TextView) view.findViewById(R.id.location_textView);
            this.txtDateTime = (TextView) view.findViewById(R.id.dateTime_textView);
        }
    }

    private View.OnClickListener createClickListener(@NonNull final Event eventDetails) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRowItemClicked(eventDetails);
            }
        };
    }
}