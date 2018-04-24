void createOrder(User user, Collection<Product> products, Address shipping,
                   Address billing) {
    logger.info("Creating order"); // Logging aspect
    transaction.begin();           // Transaction aspect
    try {
        validator.validateAddress(shipping); // Shipping business rules aspect
        validator.validateAddress(billing);  // Billing business rules aspect
        Order order = new Order(user, product, shipping, billing);
        database.save(order);
        transaction.commit();                      // Transaction aspect
        logger.info("Order created successfully"); // Logging aspect
    } catch (Exception e) {
        transaction.rollback();                 // Transaction aspect
        logger.error("Could not create order"); // Logging aspect
    }
}
