import java.util.*;
import java.io.*;
import java.util.concurrent.*;

class MinotaurVase {

  private static int GUESTNUM = 10;
  private static int MAXQUEUE = 10;
  
  public static class vaseViewer extends Thread
  {
    int count =0;
    public void run()
    {
      try{
        System.out.println(getName()+ " is entering, has visited " + count + " times before");
        sleep(100);
        System.out.println(getName()+ " is exiting");
        count++;
        }
      catch(InterruptedException e){}
    }
  }
  
  public static void main(String[] args) {


    Thread[] threadList = new Thread[GUESTNUM];
    
    for (int i = 0; i < GUESTNUM; i++) 
    {
      threadList[i] = new Thread(new vaseViewer());
    }

    Queue <Thread> queue = new LinkedList<Thread>();
    
    Random rand = new Random();
    int n = rand.nextInt(MAXQUEUE*2) + 10;
    System.out.println("There are "+ n +" entries for the queue");

    for(int i = 0; i < n; i++)
      {
        queue.add(threadList[rand.nextInt(GUESTNUM)]);
      }

    while(!queue.isEmpty())
      {
        try{
          Thread t = queue.remove();
          t.run();
          t.join();
        }
        catch(InterruptedException e){}
      }

    System.out.println("The queue is empty");
    
  }
}