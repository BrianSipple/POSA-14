package edu.vuum.mocca;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
<<<<<<< HEAD
	/**
	 * The value that's manipulated atomically via the methods.
	 */
	private long mValue;

	/**
	 * The ReentrantReadWriteLock used to serialize access to mValue.
	 */

	// TODO -- you fill in here by replacing the null with an
	// initialization of ReentrantReadWriteLock.
	private ReadWriteLock mRWLock = new ReentrantReadWriteLock(false);

	/**
	 * Creates a new SimpleAtomicLong with the given initial value.
	 */
	public SimpleAtomicLong(long initialValue)
	{
		// TODO -- you fill in here
		this.mValue = initialValue;
	}

	/**
	 * @brief Gets the current value.
	 * 
	 * @returns The current value
	 */
	public long get()
	{
		long value;

		// TODO -- you fill in here
		mRWLock.readLock().lock();
		value = mValue;	
		mRWLock.readLock().unlock();
		return value;

	}

	/**
	 * @brief Atomically decrements by one the current value
	 *
	 * @returns the updated value
	 */
	public long decrementAndGet()
	{
		long value = 0;

		// TODO -- you fill in here
		mRWLock.writeLock().lock();
		
		mValue--;
		value = get();
		
		mRWLock.writeLock().unlock();
		//value = get();
		
		return value;
	}


	/**
	 * @brief Atomically increments by one the current value
	 *
	 * @returns the previous value
	 */
	public long getAndIncrement()
	{
		long value = 0;

		// TODO -- you fill in here

		//value = get();
		mRWLock.writeLock().lock();

		value = get();
		mValue++;
		
		mRWLock.writeLock().unlock();
		
		return value;
	}

	/**
	 * @brief Atomically decrements by one the current value
	 *
	 * @returns the previous value
	 */
	public long getAndDecrement()
	{
		long value = 0;

		// TODO -- you fill in here

		//value = get();
		mRWLock.writeLock().lock();

		value = get();
		mValue--;
		
		mRWLock.writeLock().unlock();
		
		return value;
	}

	/**
	 * @brief Atomically increments by one the current value
	 *
	 * @returns the updated value
	 */
	public long incrementAndGet()
	{
		long value = 0;

		// TODO -- you fill in here

		mRWLock.writeLock().lock();
		
		mValue++;
		value = get();
		
		mRWLock.writeLock().unlock();
		//value = get();
		
		return value;
	}
=======
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;


    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    // TODO - add the implementation

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue) {
        // TODO - you fill in here
    }

    /**
     * @brief Gets the current value
     * 
     * @returns The current value
     */
    public long get() {
        // TODO - you fill in here
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet() {
        // TODO - you fill in here
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement() {
        // TODO - you fill in here
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement() {
        // TODO - you fill in here
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet() {
        // TODO - you fill in here
    }
>>>>>>> 22b4842c2aa73578fdea5b227f2e6c9ef7197dde
}

