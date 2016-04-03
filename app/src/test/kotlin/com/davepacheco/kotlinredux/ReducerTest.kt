import com.davepacheco.kotlinredux.redux.counter
import org.junit.Test

import org.junit.Assert

class ReducerTest {

    @Test fun expectIncrementActionToAddOneToState() {
        val state = counter(0, "INCREMENT")

        Assert.assertEquals(1, state)
    }

    @Test fun expectIncrementActionToAddOneToStateWithValueOfOne() {
        val state = counter(1, "INCREMENT")

        Assert.assertEquals(2, state)
    }

    @Test fun expectDecrementActionToRemoveOneToState() {
        val state = counter(1, "DECREMENT")

        Assert.assertEquals(0, state)
    }

    @Test fun expectSomeRandomActionReturnSameState() {
        val state = counter(1, "SOMETHING_ELSE")

        Assert.assertEquals(1, state)
    }

    @Test fun expectUndefinedStateReturnsInitialState() {
        val state = counter(action = "SOMETHING")

        Assert.assertEquals(0, state)
    }
}