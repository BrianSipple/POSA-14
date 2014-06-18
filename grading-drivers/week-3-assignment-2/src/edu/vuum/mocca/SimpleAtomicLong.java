// Import the necessary Java synchronization and scheduling classes.

package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;


    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
<<<<<<< HEAD
    // TODO - replace the null with the appropriate initialization:
    private final ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();
=======
    // TODO - add the implementation
>>>>>>> 22b4842c2aa73578fdea5b227f2e6c9ef7197dde

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue) {
        // TODO - you fill in here
    	this.mValue = initialValue;
    }

    /**
     * @brief Gets the current value
     * 
     * @returns The current value
     */
    public long get() {
        // TODO - you fill in here
        long value;
        // TODO -- you fill in here
        mRWLock.readLock().lock();
        value = this.mValue;
        mRWLock.readLock().unlock();

        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet() {
        // TODO - you fill in here
    	long value = 0;

        // TODO -- you fill in here
        try {
			mRWLock.writeLock().lockInterruptibly();
			this.mValue--;
			value = this.mValue;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			mRWLock.writeLock().unlock();
		}
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement() {
        // TODO - you fill in here
    	 long value = 0;

         // TODO -- you fill in here
         try {
 			mRWLock.writeLock().lockInterruptibly();
 			value = this.mValue;
 			this.mValue++;
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}finally{
 			mRWLock.writeLock().unlock();
 		}
         return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement() {
        // TODO - you fill in here
    	long value = 0;

        // TODO -- you fill in here
        try {
			mRWLock.writeLock().lockInterruptibly();
			value = this.mValue;
			this.mValue--;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			mRWLock.writeLock().unlock();
		}
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet() {
        // TODO - you fill in here
    	long value = 0;

        // TODO -- you fill in here
        try {
			mRWLock.writeLock().lockInterruptibly();
			this.mValue++;
			value = this.mValue;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			mRWLock.writeLock().unlock();
		}
        return value;
    }
}

