# Testing potion functionality:
## The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 ### [Potion](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java) Tests including testing of the methods:
 * get(String kind)
 * set(String kind, int amount, boolean add)
 * use(String k)
 * used(String kind)

## Additional Notes on Testing:
### The potion tests are built to work when run all at once or separately except for the testUsed() test case.
### This test case keeps track of all previous actions of the class, and thus will be accurate when only when run with the other tests.
### If you wish to perform only the unit test for the used function, you may reenable the testUsedAlone test and run all tests, or only the testUsedAlone test.
