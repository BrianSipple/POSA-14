package edu.vuum.mocca;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @class SimpleSemaphore
 * 
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject (which is accessed via a Condition). It must
 *        implement both "Fair" and "NonFair" semaphore semantics,
 *        just liked Java Semaphores.
 */
public class SimpleSemaphore {
    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here
	Lock mRLock;

    /**
     * Define a Condition that waits while the number of permits is 0.
     */
    // TODO - you fill in here
	Condition noPermits;

    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here.  Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..
	private int mPermits;
	
	private Semaphore mSema;

	
	public SimpleSemaphore(int permits, boolean fair) {
    	
    	mSema = new Semaphore(permits, fair);
    	mPermits = permits;
    	mRLock = new ReentrantLock(fair);
    	noPermits = mRLock.newCondition();

    }

    /**
     * Acquire one permit from the semaphore in a manner that can be
     * interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here.
    	mRLock.lockInterruptibly();
    	try {
    		while (availablePermits() == 0) {
    			noPermits.await();
    		}
    		mSema.acquire();
    		mPermits--;
    	} finally {
    		mRLock.unlock();
    	}
    }

    /**
     * Acquire one permit from the semaphore in a manner that cannot be
     * interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here.
    	mRLock.lock();
    	try {
    		while (availablePermits() == 0) {
    			noPermits.awaitUninterruptibly();
    		}
    		mSema.acquireUninterruptibly();
    		mPermits--;
    	} finally {
    		mRLock.unlock();
    	}
    }

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here.
    	try {
    		mRLock.lock();
    		mSema.release();
    		mPermits++;
    		//noPermits.notify();
    	} finally {
    		mRLock.unlock();
    	}
    }

    /**
     * Return the number of permits available.
     */
    public int availablePermits() {
        // TODO - you fill in here by changing null to the appropriate
        // return value.
        return mPermits;
    }
}
