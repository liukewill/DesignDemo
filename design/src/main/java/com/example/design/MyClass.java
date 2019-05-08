package com.example.design;

import java.util.ArrayList;
import java.util.List;

import com.example.design.responsibility.handlers.CloseRefrigeratorHandler;
import com.example.design.responsibility.Handler;
import com.example.design.responsibility.handlers.MoveElephantHandler;
import com.example.design.responsibility.ProcessChain;
import com.example.design.responsibility.RequestContext;
import com.example.design.responsibility.handlers.OpenRefrigeratorHandler;

public class MyClass {
  public static void main(String[] args) {
    //构造请求
    RequestContext requestContext = new RequestContext(new RequestContext.Elephant(),new RequestContext.Refrigerator());

    //构造处理步骤
    List<Handler> list = new ArrayList<>();

    list.add(new OpenRefrigeratorHandler());
    list.add(new MoveElephantHandler());
    list.add(new CloseRefrigeratorHandler());

    //执行任务
    ProcessChain processChain = new ProcessChain(list,0,requestContext);
    processChain.proceed(requestContext);
  }
}
