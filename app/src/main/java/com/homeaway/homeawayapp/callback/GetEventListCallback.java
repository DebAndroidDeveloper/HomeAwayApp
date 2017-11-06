package com.homeaway.homeawayapp.callback;

import com.homeaway.homeawayapp.network.EventServiceResponse;

public interface GetEventListCallback {
    void onHttpResponseError(Throwable exception);

    /*

     */
    void onHttpRequestComplete(EventServiceResponse eventServiceResponse);
}
