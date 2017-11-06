package com.homeaway.homeawayapp.network;

import android.content.Context;

import com.homeaway.homeawayapp.BuildConfig;
import com.homeaway.homeawayapp.R;
import com.homeaway.homeawayapp.callback.EventService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    Retrofit provideCall(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SEAT_GEEK_EVENT_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public EventService providesEventService(
            Retrofit retrofit) {
        return retrofit.create(EventService.class);
    }
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public EventsApiService providesEventApiService(
            EventService eventService) {
        return new EventsApiService(eventService);
    }

}