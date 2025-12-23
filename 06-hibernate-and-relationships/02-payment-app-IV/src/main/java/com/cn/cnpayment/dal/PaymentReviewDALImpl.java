package com.cn.cnpayment.dal;


import com.cn.cnpayment.entity.PaymentReview;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PaymentReviewDALImpl implements PaymentReviewDAL {

/**

 Complete the PaymentReviewDALImpl implementation class as mentioned below:

 	a. Autowire EntityManager.

 	b. Override the following methods:

 		1. getById(int id): This method fetches PaymentReview for a specific id.

 		2. getAllPaymentReview(): This method fetches the list of all PaymentReview from the database.

 		3. save(PaymentReview paymentReview): This method saves the PaymentReview entity into the database.

 		4. delete(int id): This method deletes the PaymentReview entity from the database for a specific id.

 		5. getByQueryType(String queryType): This method fetches the list of PaymentReview based on the
                                             queryType received.

 **/

	@Autowired
	EntityManager entityManager;

	@Override
	public PaymentReview getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(PaymentReview.class, id);
	}

		@Override
		public void save(PaymentReview paymentDetails) {
			Session session = entityManager.unwrap(Session.class);
			session.save(paymentDetails);

			session.flush();
		}

		@Override
		public void delete(int id) {
			Session session = entityManager.unwrap(Session.class);
			PaymentReview review = session.get(PaymentReview.class, id);
			if (review != null) {
				session.remove(review);
			}
		}

		@Override
		public List<PaymentReview> getAllPaymentReview() {
			Session session = entityManager.unwrap(Session.class);
			List<PaymentReview> allReviews =  session.createQuery("from PaymentReview").getResultList();
			return allReviews;
		}

	@Override
	public List<PaymentReview> getByQueryType(String queryType) {

		// 1️⃣ Null / empty check
		if (queryType == null || queryType.trim().isEmpty()) {
			throw new com.cn.cnpayment.exception.InvalidInputException("queryType is invalid.");
		}

		// 2️⃣ Allowed values check (REQUIRED by test)
		List<String> validQueryTypes = new ArrayList<>();
		validQueryTypes.add("Payment Issue");
		validQueryTypes.add("Bank Issue");
		validQueryTypes.add("Merchant Issue");

		boolean isValid = false;
		for (String valid : validQueryTypes) {
			if (valid.equalsIgnoreCase(queryType)) {
				isValid = true;
				break;
			}
		}

		if (!isValid) {
			throw new com.cn.cnpayment.exception.InvalidInputException("queryType is invalid.");
		}

		// 3️⃣ Fetch & filter
		Session session = entityManager.unwrap(Session.class);

		List<PaymentReview> allReviews = session
				.createQuery("from PaymentReview", PaymentReview.class)
				.getResultList();

		List<PaymentReview> result = new ArrayList<>();

		for (PaymentReview review : allReviews) {
			if (review.getQueryType() != null &&
					review.getQueryType().equalsIgnoreCase(queryType)) {
				result.add(review);
			}
		}

		return result;
	}


}
