public class OrderService {

    @BusinessOperation("order.create")
    public Order create(
        @BusinessOperationParameter("user")
        User user,
        @BusinessOperationParameter("email")
        String email,
        @BusinessOperationParameter("shippingAddress")
        Address shippingAddress,
        @BusinessOperationParameter("billingAddress")
        Address billingAddress
    ) { /* ... */ }

}
