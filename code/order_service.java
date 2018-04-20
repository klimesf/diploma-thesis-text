$$@RestController
public class ShoppingCartController {

    /* ... */

    $$@GetMapping("/shopping-cart")
    public ResponseEntity<?> listShoppingCart() {
        List<ShoppingCartItem> shoppingCartItems = shoppingCartFacade
            .listShoppingCartItems();
        return new ResponseEntity<>(
            new ListShoppingCartItemsResponse(
                shoppingCartItems.size(),
                shoppingCartItems
            ),
            HttpStatus.OK
        );
    }

}
