package com.example.design.responsibility.handlers;


import com.example.design.responsibility.Handler;
import com.example.design.responsibility.RequestContext;

/**
 * 打开冰箱
 */
public class MoveElephantHandler implements Handler {
  @Override
  public void handle(Chain chain) {
    RequestContext requestContext = chain.getContext();
    //处理具体操作
    if (requestContext.mRefrigerator.isOpen()) {
      requestContext.mElephant.move();
      //处理完毕 继续执行下个操作
      chain.proceed(requestContext);
    } else {
      //发生异常 中断链条
      System.out.println("Please open Refrigerator first !");
      chain.abort();
      return;
    }
  }
}
