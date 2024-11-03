package com.appsdeveloperblog.estore.UsersService.query;


import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.core.model.PaymentDetails;
import com.appsdeveloperblog.estore.core.model.User;
import com.appsdeveloperblog.estore.core.query.FetchUserPaymentDetailsQuery;

@Component
public class UserEventsHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserEventsHandler.class);

  @QueryHandler
  public User findUser(FetchUserPaymentDetailsQuery query) {
    PaymentDetails paymentDetails = PaymentDetails.builder()
    .cardNumber("123Card")
    .cvv("123")
    .name("SERGEY KARGOPOLOV")
    .validUntilMonth(12)
    .validUntilYear(2030)
    .build();
     
    User user = User.builder()
    .firstName("Sergey")
    .lastName("Kargopolov")
    .userId(query.getUserId())
    .paymentDetails(paymentDetails)
    .build();

    LOGGER.info("WIP and needs some more love");

    return user;
  }
}
