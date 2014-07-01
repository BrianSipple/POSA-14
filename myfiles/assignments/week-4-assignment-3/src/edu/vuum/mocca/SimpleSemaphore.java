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
 *        ConditionObject.  It must implement both "Fair" and
 *        "NonFair" semaphore semantics, just liked Java Semaphores. 
 */
public class SimpleSemaphore {
	/**
	 * Constructor initialize the data members.  
	 */

	private Semaphore mSema;
	private Condition mCondVar;
	private Lock mRLock;
	private volatile int mAvailablePermits;

	public SimpleSemaphore (int permits,
			boolean fair) throws Exception {
	
		if (permits < 0) { throw new Exception("Illegal Arguments!"); }
	 
		mRLock = new ReentrantLock(fair);
		mAvailablePermits = permits;
		mCondVar = mRLock.newCondition();
	}

	/**
	 * Acquire one permit from the semaphore in a manner that can
	 * be interrupted.
	 */
	public void acquire() throws InterruptedException {
		// TODO - you fill in here
		mRLock.lockInterruptibly();
		try {
			while (mAvailablePermits == 0) {
				mCondVar.await();
			}
			mAvailablePermits -= 1;
		} finally {
			mRLock.unlock();
		}
	}

	/**
	 * Acquire one permit from the semaphore in a manner that
	 * cannot be interrupted.
	 */
	public void acquireUninterruptibly() {
		// TODO - you fill in here
		mRLock.lock();
		try {
			while(mAvailablePermits == 0) {
				mCondVar.awaitUninterruptibly();
			}
			mAvailablePermits -= 1;
		} finally {
			mRLock.unlock();
		}
	}

	/**
	 * Return one permit to the semaphore.
	 */
	void release() {
		// TODO - you fill in here
		mRLock.lock();
		try {
			mAvailablePermits += 1;
			mCondVar.signal();
		} finally {
			mRLock.unlock();
		}
	}

	public int availablePermits() {
		return mAvailablePermits;
	}
}
