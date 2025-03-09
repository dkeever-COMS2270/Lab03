# Balloon Class Testing Project

## Overview
This project tests the functionality of the `Balloon` class from the `balloon, balloon1, balloon2, balloon3, balloon4` packages using JUnit 4. The `Balloon` class models a spherical balloon that can be inflated, deflated, and popped. Its behavior is defined by a set of operations that ensure if it's overinflated beyond its maximum radius, it pops, and certain methods should have no effect when it is already popped.

## Test File
The test cases are defined in the `BalloonTests` class under the `lab3` package. The tests cover the following scenarios:

- **newlyConstructed**: Verifies that a newly constructed balloon is deflated (radius = 0) and not popped.
- **blow5**: Tests that blowing the balloon with a value of 5 increases the radius to 5 and does not pop it.
- **blowLimit**: Checks that blowing the balloon with a value exceeding the maximum (11 > 10) pops the balloon and resets its radius to 0.
- **popBlow**: Ensures that once a balloon is explicitly popped using `pop()`, subsequent calls to `blow()` have no effect.
- **blowPop**: Confirms that blowing the balloon to a value (e.g., 7) and then calling `pop()` pops the balloon and sets the radius to 0.
- **deflate**: Verifies that calling `deflate()` resets the radius to 0 but does not mark the balloon as popped.
- **negativeBlow**: Checks that calling `blow()` with a negative value does not change the current radius and the balloon remains not popped.

Each test compares the actual behavior of the `Balloon` class to the expected outcomes using assertions.

## Testing Methodology
The tests were executed using JUnit 4 with assertions that compare the expected and actual states of the balloon object. An `EPSILON` value (10e-07) is used for comparing floating point results. The test suite validates:
- **State Integrity**: When a balloon is newly constructed and after different operations.
- **Blow Operation**: Adjusts the balloon’s radius correctly when the operation is within limits.
- **Over inflation**: Triggers popping when the blow operation exceeds the maximum allowed radius.
- **Post-Popped Behavior**: Prevents further changes to the balloon's state after it has popped.
- **Deflation Operation**: Resets the radius without marking the balloon as popped.
- **Negative Values**: Ensures negative inputs do not erroneously alter the balloon’s state.

## Findings

### balloon1 Package
- **Popping Behavior Issue**: The `blow()` method does not pop the balloon when the input exceeds its maximum radius (e.g., blowing with 11 when maximum is 10 should pop the balloon, but it does not).
- **Post-Popped Inflation**: The balloon can still be blown after being popped (e.g., `b.blow(6)` modifies the radius instead of leaving it at 0).

### balloon2 Package
- **Post-Popped Inflation**: Similar to balloon1, the balloon remains blowable even when it should be locked (e.g., blowing with 6 on a popped balloon increases the radius incorrectly).

### balloon3 Package
- **Correct Behavior**: All tests pass with no errors. This package adheres to the specified behaviors of the `Balloon` class.

### balloon4 Package
- **Deflation Behavior Issue**: Calling `deflate()` inadvertently marks the balloon as popped instead of merely resetting the radius to 0.

## Conclusion
Based on the tests:
- **balloon and balloon3** is the only package meeting all the expected behaviors.
- **balloon1** and **balloon2** have functional issues that allow the balloon to be inflated after it has been popped.
- **balloon4** incorrectly marks a deflated balloon as popped.