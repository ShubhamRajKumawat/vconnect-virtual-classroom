package com.vconnect.dao;

import org.springframework.data.repository.CrudRepository;

import com.vconnect.entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
