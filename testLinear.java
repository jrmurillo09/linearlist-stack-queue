/*
Driver for Project 2
Created by: Redgy Canos
Last Updated: 09 October 2015
*/

import data_structures.*;

public class testLinear 
{
   private LinearListADT<Integer> list;
   private LinearListADT<String> errList;
   private Queue<Integer> qlist;
   private Stack<Integer> slist;
    
   public testLinear() 
   {
       list = new LinearList<Integer>();
       errList = new ArrayLinearList<String>(18);
       qlist = new Queue<Integer>();
       slist = new Stack<Integer>();
       runTests();
   }
   
   private void runTests()
   {  
      //Test Linear List
      for(int i=50; i > 0; i--) 
         list.addFirst(i);
      print("Adding 50 through 1 at head of Linear List.");
      printList();
      for(int i = 51; i < 101; i++)
         list.addLast(i);
      print("Adding 51 through 100 at tail of Linear List.");
      printList();
      if(list.peekFirst() != 1)
         errList.addLast("1 ERROR with peekFirst");
      else
         errList.addLast("1 GOOD");
      
      if(list.peekLast() != 100)
         errList.addLast("2 ERROR with peekLast");
      else
         errList.addLast("2 GOOD");
      
      list.clear();
      if(!list.isEmpty())
         errList.addLast("3 ERROR with isEmpty");
      else
         errList.addLast("3 GOOD");
      
      if(list.peekFirst() != null || list.peekLast() != null)
         errList.addLast("4 ERROR with clear");
      else
         errList.addLast("4 GOOD");
      
      print("Cleared list.");
      print("Adding 19 to end of list.");
      list.addLast(19);
      if(list.peekFirst() != 19)
         errList.addLast("5 ERROR with addLast");
      else
         errList.addLast("5 GOOD");
      
      print("Removing 19.");
      list.removeFirst();
      print("Adding 4 to head.");
      list.addFirst(4);
      if(list.peekLast() != 4)
         errList.addLast("6 ERROR with addFirst");
      else
         errList.addLast("6 GOOD");
      
      list.removeLast();
      list.addFirst(701);
      print("Populating list with new numbers.");
      for(int i = 7; i < 13; i++)
      {
         list.addLast(i);
         list.addFirst(2*i);
      }
      printList();
      print("Find(5022); should not be in the list");
      if(list.contains(5022))
         errList.addLast("7 ERROR Linear List contains a number that should not be in the list");
      else
         errList.addLast("7 GOOD");
      print("Find(701); should be in the list");
      if(list.find(701) == null)
         errList.addLast("8 ERROR with find");
      else
         errList.addLast("8 GOOD");
      print("Finished checking Linear List methods.");
      
      
      //Test Stack
      blank();
      print("Pushing 50 through 1 onto Stack.");
      for(int i = 50; i > 0; i--)
         slist.push(i);
      printStack();
      if(slist.peek() != 1)
         errList.addLast("9 ERROR with peek");
      else
         errList.addLast("9 GOOD");
      print("Popping off the top 40 numbers of Stack.");
      for(int i = 0; i < 40; i++)
         slist.pop();
      if(slist.peek() != 41)
         errList.addLast("10 ERROR with peek");
      else
         errList.addLast("10 GOOD");
      printStack();
      
      print("Clearing list and pushing 90 through 190 onto Stack.");
      slist.makeEmpty();
      if(!slist.isEmpty())
         errList.addLast("11 ERROR with isEmpty");
      else
         errList.addLast("11 GOOD");
      
      for(int i = 90; i < 191; i++)
         slist.push(i);
      printStack();
      if(slist.size() != 101)
         errList.addLast("12 ERROR with size");
      else
         errList.addLast("12 GOOD");
      
      print("Removing 177 from stack.");
      if(!slist.remove(177))
         errList.addLast("13 ERROR with remove");
      else
         errList.addLast("13 GOOD");
      printStack();
      print("Finished checking Stack methods.");

      
      
      //Test Queue
      blank();
      print("Enqueueing 22 through 129 onto Queue.");
      for(int i = 22; i < 130; i++)
         qlist.enqueue(i);
      printQ();
      if(qlist.peek() != 22)
         errList.addLast("14 ERROR with peek");
      else
         errList.addLast("14 GOOD");
      print("Dequeuing first 83 numbers of Queue.");
      for(int i = 0; i < 83; i++)
         qlist.dequeue();
      printQ();
      if(qlist.peek() != 105)
         errList.addLast("15 ERROR with peek");
      else
         errList.addLast("15 GOOD");
      
      print("Clearing Queue.");
      qlist.makeEmpty();
      if(!qlist.isEmpty())
         errList.addLast("16 ERROR with peek");
      else
         errList.addLast("16 GOOD");
      
      print("Populating Queue with new numbers.");
      for(int i = 17; i < 46; i++)
         qlist.enqueue(i);
      printQ();
      print("Searching for number 1; should not be in list");
      if(qlist.contains(1))
         errList.addLast("17 ERROR with contains");
      else
         errList.addLast("17 GOOD");
      
      if(!qlist.remove(21))
         errList.addLast("18 ERROR with remove");
      else
         errList.addLast("18 GOOD");
      print("Removing number 21 from list");
      printQ();
      print("Finished checking Queue methods.");
      
      //Print out error messages
      blank();
      printError();
      
      
   } // End runTests
   
   
   private void blank()
   {
      System.out.println("\n\n");
   }
   
   private void print(String s) 
   {
        System.out.println(s);
   }
      
   
   private void printError()
   {
      System.out.println("***Printing Error Messages***");
      for(String i : errList)
         System.out.println(i);
      System.out.println("\nError Number Legend:");
      System.out.println("#1-8 (LinearList), 7-13 (Stack), 14-18 (Queue)");
   }
   
   
   private void printList() 
   {
      for(Integer i : list)
          System.out.printf("%5d", i);
      System.out.println();
   }
   
   private void printStack() 
   {
      for(Integer i : slist)
          System.out.printf("%5d", i);
      System.out.println();
   }
   
   private void printQ() 
   {
      for(Integer i : qlist)
          System.out.printf("%5d", i);
      System.out.println();
   }
   
   
   public static void main(String[] args) 
   {
      new testLinear();
   } // End main
   
} // End testLinear Class
