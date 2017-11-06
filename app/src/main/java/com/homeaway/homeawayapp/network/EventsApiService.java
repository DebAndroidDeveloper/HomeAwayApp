package com.homeaway.homeawayapp.network;

import android.util.Log;

import com.homeaway.homeawayapp.callback.EventService;
import com.homeaway.homeawayapp.callback.GetEventListCallback;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class EventsApiService {
    private static final String TAG  = EventsApiService.class.getCanonicalName();
    private EventService mEventService;

    public EventsApiService(EventService eventService){
        this.mEventService = eventService;
    }

    public Subscription getEventsList(final GetEventListCallback getEventListCallback,String clientId,String searchQuery){
        return mEventService.getEventList(clientId,searchQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends EventServiceResponse>>() {
                    @Override
                    public Observable<? extends EventServiceResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<EventServiceResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG,"HTTP Response complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,e.getMessage());
                        getEventListCallback.onHttpResponseError(e);
                    }

                    @Override
                    public void onNext(EventServiceResponse eventServiceResponse) {
                        getEventListCallback.onHttpRequestComplete(eventServiceResponse);
                    }
                });
    }
}