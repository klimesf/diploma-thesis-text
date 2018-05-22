def business_operation(name, weaver):
    def wrapper(func):
        def func_wrapper(*args, **kwargs):
            operation_context = OperationContext(name)
            weaver.evaluate_preconditions(operation_context)
            output = func(*args, **kwargs)
            operation_context.set_output(output)
            weaver.apply_post_conditions(operation_context)
            return operation_context.get_output()
        return func_wrapper
    return wrapper


weaver = BusinessContextWeaver()


class ProductRepository:

    @business_operation("product.listAll", weaver)
    def get_all(self) -> List[Product]:
        pass
