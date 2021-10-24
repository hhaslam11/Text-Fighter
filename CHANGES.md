# Changes in this branch

## This branch addresses the following issue:
### Critical Hits, ([issue #25](https://github.com/hhaslam11/Text-Fighter/issues/25) in the source hhaslam11/Text-Fighter repository, [issue #1](https://github.com/emmamickas/Text-Fighter/issues/1) in the forked emmamickas/Text-Fighter repository)

## Desired modifications:
### In the current functionality, the damage that a weapon can do can be increased by a critical multiplier based upon the weapon's type. The changes include adding another critical modifier that increases the damage done by weapons with bullets only. This modifier has a 0.01% chance to activate and increases damage by a factor of 10.

## Modified files:
### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Dependency%20References), the following files were modified in the change:
 * [Weapon.java](https://github.com/emmamickas/Text-Fighter/blob/CriticalHits/src/com/hotmail/kalebmarc/textfighter/main/Weapon.java)

## Testing:
###  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [Weapon](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/src/com/hotmail/kalebmarc/textfighter/main)
 * [Enemy](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/src/com/hotmail/kalebmarc/textfighter/main)
 #### See [here](https://github.com/emmamickas/Text-Fighter/blob/CriticalHits/TESTING.md) for more information on testing.
 
 ## Resolution:
 ### Pending
 A [pull request](https://github.com/hhaslam11/Text-Fighter/pull/129) has been made to merge the change onto the master branch of the source repo.
 
 ## Additional resources:
 ### Please view the following to find additional documentation of the changes and the code involved in the changes.
  * [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Class%20Diagram) of modified classes.
  * [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Dependency%20References) of modified or dependent classes.
  * [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Sequence%20Diagrams) of modified or dependent methods.
