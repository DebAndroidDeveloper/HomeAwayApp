package com.homeaway.homeawayapp.util;

/**
 * Created by Debasis on 10/07/2015.
 */
public class Constants {
    public interface IntentExtras {
        String ERROR_NO_NETWORK = "com.homeaway.homeawayapp.ERROR_NO_NETWORK";
        String MESSAGE = "com.homeaway.homeawayapp.MESSAGE";
        String JSON_RESPONSE = "com.homeaway.homeawayapp.appIntentExtras.JSON_RESPONSE";
        String REQUEST_ID = "com.homeaway.homeawayapp.appIntentExtras.ID";
        String EVENT_TITLE  ="com.homeaway.homeawayapp.EVENT_TITLE";
        String EVENT_LOCATION = "com.homeaway.homeawayapp.EVENT_LOCATION";
        String EVENT_DATE_TIME = "com.homeaway.homeawayapp.EVENT_DATE_TIME";
        String EVENT_IMAGE_URL = "com.homeaway.homeawayapp.EVENT_IMAGE_URL";
        String EVENT_ID = "com.homeaway.homeawayapp.ID";
        String SEARCH_QUERY = "com.homeaway.homeawayapp.SEARCH_QUERY";
    }

    public interface IntentActions {
        String QUERY_DETAILS =  "com.homeaway.homeawayapp.QUERY_DETAILS";
        String ACTION_ERROR = "com.homeaway.homeawayapp.appIntentExtras.ACTION_ERROR";
        String ACTION_SUCCESS = "com.homeaway.homeawayapp.appIntentExtras.ACTION_SUCCESS";
    }

    public interface ApiMethods {

    }

    public interface JsonKeys {
        String ERRORS = "errors";
        String MESSAGE = "message";
    }

    public interface ApiRequestId {
        int API_BASE_VALUE = 200;
        int GET_SEAT_GEET_DATA = API_BASE_VALUE + 1;

    }
}
