
/**
 * Here is an example test driver framework for you to improve and build upon.
 * Modify this file and *make it your own*. The way this design reports Expected
 * vs. Actual, for example, stands to be improved. Furthermore, hard-coding the
 * numbering in the test seems to break the idea of independence, and changing
 * the order in the future will lead to bedlam in the output. Imagine trying to
 * maintain something like this in production . . .
 * 
 * This test suite exercises the list, but you will also want to test the Stack
 * and Queue classes when you implement those. I recommend creating new test
 * classes for each of those instead of trying to cram everything into this
 * tester, for you want to encapsulate a single concept.
 * 
 * Keep the queue stuff in the queue tester, the stack stuff in the stack
 * tester, and the *doubly* linked list test stuff here.
 * 
 * Note: Please feel free to collaborate with your fellow students about your
 * test framework design as well as the tests you run. This interaction remains
 * a valuable part of the learning process. You may, in fact, freely distribute
 * any test or driver software you develop.
 * 
 * Sharing Stack.java, Queue.java, or LinearList.java, however, constitutes
 * cheating and results in a BAD TIME for everyone involved.
 */

import data_structures.LinearList;
import data_structures.LinearListADT;

public class LLDevTester {

  private final int ManyItems = 100000;

  public LLDevTester() {
    runTests();
  }

  public static void main(String[] args) {
    new LLDevTester();
  }

  private void displayTestResults(String description, String expected,
      String actual) {
    System.out.println(description);
    // String.format() could come in handy here, but let's keep it simple
    System.out.println("    Expected: " + expected);
    System.out.println("    Actual: " + actual);
  }

  private void displayElapsedTime(long startingTime) {
    System.out.println("    Elapsed Time: "
        + Double.toString(((System.nanoTime() - startingTime)) / 1000000.0)
        + " mS");
  }

  /**
   * Generates a new, empty list. Although this method seems to provide little
   * advantage over directly instantiating a LinearList when needed, it provides
   * a few benefits. First, it facilitates swapping out the data structure under
   * test. Should one decide to drop in a circular array, one need only change
   * it here for it to ripple through all the tests.
   * <p>
   * Additionally, this establishes our naming strategy for the framework. As
   * shown in the subsequent getAscendingItemList method.
   * </p>
   * 
   * @return a newly constructed LinearList on the heap
   */
  private static LinearListADT<Integer> getEmptyList() {
    return new LinearList<Integer>();
  }

  /**
   * Tests frequently require a known starting point. This method builds and
   * returns a LinearListADT conforming object with the specified number of
   * items already in place. It simplifies the find/contains methods.
   * <p>
   * Note: uses addLast to construct the list.
   * </p>
   * 
   * @param size
   *          Number of items to insert in the array
   * @return A newly constructed LinearListADT object on the heap filled with
   *         items in ascending order from 1-size
   */
  private static LinearListADT<Integer> getAscendingItemList(int size) {
    LinearListADT<Integer> uut = getEmptyList();

    for (int i = 0; i < size; i++) {
      uut.addLast(size + 1);
    }
    return uut;
  }

  private void runTests() {

    testConstructor_initialSize_zero();
    testAddFirst_manyItems_neverFalse_timed();
  }

  private void testConstructor_initialSize_zero() {

    LinearListADT<Integer> uut = getEmptyList();

    displayTestResults("[1] Construction size", "0",
        Integer.toString(uut.size()));
  }

  private void testAddFirst_manyItems_neverFalse_timed() {

    LinearListADT<Integer> uut = getEmptyList();

    boolean testPassed = true;
    long startTime = System.nanoTime();
    for (int i = 0; i < ManyItems; i++) {
      if (uut.addFirst(i) == false) // Note: Autoboxed to Integer
      {
        testPassed = false;
        break;
      }
    }
    displayTestResults("[2] addFirst ManyItems", "true",
        Boolean.toString(testPassed));
    displayElapsedTime(startTime);
  }
}