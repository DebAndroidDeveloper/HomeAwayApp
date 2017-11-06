package com.homeaway.homeawayapp.network;

import com.homeaway.homeawayapp.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface NetworkComponent {
    void inject(MainActivity mainActivity);
}