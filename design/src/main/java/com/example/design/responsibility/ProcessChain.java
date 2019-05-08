package com.example.design.responsibility;

import java.util.List;

public class ProcessChain implements Handler.Chain {

  private List<Handler> mProcessors;
  private RequestContext mChainContext;
  private int mIndex;

  public ProcessChain(List<Handler> processors, int index, RequestContext chainContext) {
    mProcessors = processors;
    mIndex = index;
    mChainContext = chainContext;
  }

  @Override
  public RequestContext getContext() {
    return mChainContext;
  }

  public void abort(){
    mProcessors.clear();
    System.out.println("Missing abort !");
  }

  @Override
  public void proceed(RequestContext processContext) {
    if (mProcessors.size() > mIndex) {
      //获取当前处理者
      Handler processor = mProcessors.get(mIndex);

      //更新index 与 Context
      ProcessChain nextChain = new ProcessChain(mProcessors, mIndex + 1, processContext);

      //处理者执行处理步骤
      processor.handle(nextChain);
    }else{
      System.out.println("Missing success!");
    }
  }
}
