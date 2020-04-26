package com.vconnect.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vconnect.entity.Subscription;
import com.vconnect.service.SubscriptionService;

@CrossOrigin
@RestController
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;

	@GetMapping(value = "/subscription") // Fetch all subscriptions.
	public List<Subscription> getSubscription() {
		return subscriptionService.getAllSubscription();
	}

	@GetMapping(value = "/subscription/{id}") // Fetch Subscription by ID.
	public Optional<Subscription> getSubscriptionById(@PathVariable("id") int id) {
		return subscriptionService.getSubscriptionById(id);
	}

	@PostMapping(value = "/subscription/") // Add subscription.
	public String addSubscriptionInfo(@RequestBody Subscription studentInfo) {
		return subscriptionService.addSubscription(studentInfo);

	}

	@DeleteMapping(value = "/subscription/{id}") // Soft Delete Subscription.
	public String deleteSubscriptionInfo(@PathVariable("id") int id) {
		return subscriptionService.deleteSubscription(id);
	}

}
