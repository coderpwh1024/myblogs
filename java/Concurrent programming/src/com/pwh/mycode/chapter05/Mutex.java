package com.pwh.mycode.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author coderpwh
 * @Date: 2018/6/11.
 * @Description:
 */
public class Mutex implements Lock {


    private static  class  Sync  extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -4387327721959839431L;

        @Override
        protected  boolean isHeldExclusively(){
            return  getState()==1;
        }

        @Override
        public boolean tryAcquire(int acquires){
            assert acquires ==1;

            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return  true;
            }
            return  false;
        }

        @Override
        protected  boolean tryRelease(int releases){
            assert releases  ==1;
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition() {
            return new ConditionObject();
        }

    }

    // 仅需要将操作代理到Sync上即可
    private final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {

        return  sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return   sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
