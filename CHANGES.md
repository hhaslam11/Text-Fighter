# Changes in this branch

## This branch addresses the following issue:
### Critical Hits, ([issue #130](https://github.com/hhaslam11/Text-Fighter/issues/130) in the source hhaslam11/Text-Fighter repository, [issue #9](https://github.com/emmamickas/Text-Fighter/issues/9) in the forked emmamickas/Text-Fighter repository)

## Desired modifications:
### In the current implementation, selecting the weaponstash cheat involves accessing an array of weapons in which the final index being referenced is the size of the array, which is out of the bounds of the array. The changes involve updating the condition of the loop that accesses the array to prevent the violation of the index.

## Modified files:
### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Dependency%20References), the following files were modified in the change:
 * [Cheats.java](https://github.com/emmamickas/Text-Fighter/blob/CheatsIndexOutOfBoundsFix/src/com/hotmail/kalebmarc/textfighter/main/Cheats.java)

## Testing:
###  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [Cheats](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/CheatsTest.java)
 #### See [here](https://github.com/emmamickas/Text-Fighter/blob/CheatsIndexOutOfBoundsFix/TESTING.md) for more information on testing.
 
 ## Resolution:
 ### Pending
 A [pull request](https://github.com/hhaslam11/Text-Fighter/pull/131) has been made to merge the change onto the master branch of the source repo.
 
 ## Additional resources:
 ### Please view the following to find additional documentation of the changes and the code involved in the changes.
  * [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Class%20Diagram) of modified classes.
  * [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Dependency%20References) of modified or dependent classes.
  * [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Sequence%20Diagrams) of modified or dependent methods.
