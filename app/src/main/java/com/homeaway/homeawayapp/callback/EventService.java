package com.homeaway.homeawayapp.callback;

import com.homeaway.homeawayapp.network.EventServiceResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface EventService {
    @GET("events?")
    Observable<EventServiceResponse> getEventList(@Query("client_id") String clientId,@Query("q") String searchQuery);
}