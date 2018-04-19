const chai = require('chai');

// Import other packages ...

chai.should();


describe('IsNotNull', () => {
    describe('#interpret', () => {
        it('evaluates if the argument is null', () => {
            const ctx = new BusinessOperationContext('user.create')
            let expression = new IsNotNull(new Constant(
                true,
                ExpressionType.BOOL
            ))
            let result = expression.interpret(ctx)
            result.should.equal(true)

        expression = new IsNotNull(new Constant(
            null,
            ExpressionType.VOID
        ))
        result = expression.interpret(ctx)
        result.should.equal(false)
        })
    })
})
