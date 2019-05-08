package com.example.design.responsibility.handlers;


import com.example.design.responsibility.Handler;
import com.example.design.responsibility.RequestContext;

/**
 * 打开冰箱
 */
public class OpenRefrigeratorHandler implements Handler {
  @Override
  public void handle(Chain chain) {
    RequestContext requestContext = chain.getContext();
    //处理具体操作
    if(!requestContext.mRefrigerator.isOpen()) {
      requestContext.mRefrigerator.open();
    }
    //处理完毕 继续执行下个操作
    chain.proceed(requestContext);
  }
}
