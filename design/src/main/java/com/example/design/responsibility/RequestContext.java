package com.example.design.responsibility;

/**
 * 请求上下文
 */
public class RequestContext {

  public Elephant mElephant;

  public Refrigerator mRefrigerator;

  public RequestContext(Elephant elephant, Refrigerator refrigerator) {
    mElephant = elephant;
    mRefrigerator = refrigerator;
  }

  /**
   *大象
   */
  public static class Elephant{

    public void move(){
      System.out.println("Moving elephant...");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Move fail!");
      }
      System.out.println("Move success!");
    }
  }

  /**
   * 冰箱
   */
  public static class Refrigerator{
    boolean mIsOpen;

    public void open(){
      mIsOpen = true;
      System.out.println("Refrigerator Opened");
    }

    public void close(){
      mIsOpen = false;
      System.out.println("Refrigerator Closed");
    }

    public boolean isOpen(){
      return mIsOpen;
    }
  }

}



