const chai = require('chai')
// Other imports

chai.should();

describe('IsNotNull', () => {
    describe('#interpret', () => {
        it('returns true if the argument is null', () => {
            const ctx = new BusinessOperationContext('user.create')
            const expression = new IsNotNull(new Constant(
                true,
                ExpressionType.BOOL
            ))
            const result = expression.interpret(ctx)
            result.should.equal(true)
        })
    })
})
