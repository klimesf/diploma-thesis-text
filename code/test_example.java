import org.junit.Assert;
import org.junit.Test;

public class BusinessContextWeaverTest {

    $$@Test
    public void test() {
        BusinessContextWeaver evaluator =
            new BusinessContextWeaver(createRegistry());
        BusinessOperationContext context =
            new BusinessOperationContext("user.create");

        context.setOutput(new User(
            "John Doe",
            "john.doe@example.com"
        ));
        evaluator.applyPostConditions(context);
        User user = (User) context.getOutput();

        Assert.assertEquals("John Doe", user.getName());
        Assert.assertNull(user.getEmail());
    }
}
