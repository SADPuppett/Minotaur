import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

class MinotaurMaze{

  private static AtomicBoolean cake = new AtomicBoolean(true);
  private static int N = 10;

  public static class leaderThread extends Thread
  {
    public void run(){
      if(cake.compareAndSet(false,true))
        System.out.println("Leader saw cupcake missing");
      else
        System.out.println("Leader saw a cupcake!");
    }
  }

  public static class workerThread extends Thread
  {
    boolean eaten = false;

    public workerThread()
    {
      eaten = false;
    }
    
    public void run(){
          if(eaten)
          {
            System.out.println("Worker didnt enter maze");
              return;
          }
          
          if(cake.compareAndSet(true,false))
          {
            System.out.println("Worker ate cupcake");
            eaten = true;
          }
        
          else
            System.out.println("Worker didnt eat cupcake");
    }
  }
  
  public static void main(String[] args) {

    Thread[] threadList = new Thread[N];
    
    threadList[0] = new Thread(new leaderThread());
    
    for (int i = 1; i < N; i++) 
    {
      threadList[i] = new Thread(new workerThread());
    }

    
      do{
        for(int i = 0; i < N; i++)
        {
          try{threadList[i].run();
            threadList[i].join();}
          catch (InterruptedException e){System.out.println("Error");}
        }
      }while(!cake.get());
      
    threadList[0].run();
    System.out.println("Reporting done to minotaur");
    System.out.println();
    
  }
}