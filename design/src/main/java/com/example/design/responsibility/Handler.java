package com.example.design.responsibility;



/**
 * 处理者
 */
public interface Handler {

  /**
   * 处理链条上的请求
   */
  void handle(Chain chain);

  /**
   * 请求链
   */
  interface Chain {
    /**
     * 获取请求实体
     */
    RequestContext getContext();

    /**
     * 开始或继续执行请求。
     */
    void proceed(RequestContext context);

    /**
     * 中断任务
     */
    void abort();
  }

}



