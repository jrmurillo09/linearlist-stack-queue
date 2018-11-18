
/**
 * CS310 Fall 2015 <br>
 * Example driver for program 2
 * 
 * @see Blackboard or http://pindar.sdsu.edu/cs310/prog2.php
 * @version 1.0
 */

import data_structures.LinearList;
import data_structures.LinearListADT;

public class NewDriver {

  /**
   * The Unit Under Test. Through polymorphism we may assign any object that
   * implements this interface to this variable. For this driver, we use an
   * ArrayLinearList as the concrete class.
   */
  LinearListADT<Integer> uut;

  /**
   * Increase this value to see the impact of quadratic timing on the remove
   * method.
   */
  final int arraySize = 32;

  final int numItemsToPrint = 25;

  /**
   * When instantiated, this object automatically prepares and performs a series
   * of supported operations demonstrating basic functionality. 
   */
  public NewDriver() {
    setup();
    runTests();
  }

  private void setup() {
    uut = new LinearList<Integer>();
  }

  private void testFrontRearAddRemove() {

    printBanner("Adding 10 items to front");
    for (int i = 0; i < 10; i++) {
      uut.addFirst(i + 1);
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Adding 10 items to rear");
    for (int i = 0; i < 10; i++) {
      uut.addLast(i + 1);
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Removing 5 items from front");
    for (int i = 0; i < 5; i++) {
      uut.removeFirst();
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Removing 5 items from rear");
    for (int i = 0; i < 5; i++) {
      uut.removeLast();
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Adding 5 items to front and rear (10 total)");
    for (int i = 0; i < 5; i++) {
      uut.addFirst((i + 1) * 7);
      uut.addLast((i + 1) * 3);
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();
    
    printBanner("removing from the middle");
    uut.remove(1);
    printContents(numItemsToPrint);
    printSumContentsBoxed();
    printBanner("Removing tail");
    uut.remove(15);
    printContents(numItemsToPrint);
    printSumContentsBoxed();
    printBanner("Removing tail again");
	uut.remove(12);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing tail one more time");
	uut.remove(9);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Now remove random number not head or tail");
	uut.remove(7);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("One more random");
	uut.remove(28);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Head");
	uut.remove(35);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Head");
	uut.remove(21);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Head");
	uut.remove(14);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(4);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing First");
	uut.removeFirst();
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Tail");
	uut.removeLast();
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Tail");
	uut.removeLast();
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(2);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(3);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(2);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(5);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(3);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Tail");
	uut.removeLast();
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(1);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	printBanner("Removing Random");
	uut.remove(1);
	printContents(numItemsToPrint);
	printSumContentsBoxed();
	
  }

  private void runTests() {

    testFrontRearAddRemove();

  }

  private static void printBanner(String description) {
    System.out.println('\n' + "*** " + description + " ***");
  }

  private void printSumContentsBoxed() {

    Long sum = new Long(0);
    for (Integer e : uut) {
      sum += e;
    }
    System.out.println("Sum: " + sum);
  }

  private void printContents(int size) {
    System.out.print("Contents: ");
    for (int e : uut) {
      System.out.print(e + " ");
    }
    System.out.print('\n');
  }

  public static void main(String[] args) {
    new NewDriver();
  }
  
}