// Import the necessary Java synchronization and scheduling classes.

import java.util.concurrent.CountDownLatch;

/**
 * @class PingPongRight
 *
 * @brief This class implements a Java program that creates two
 *        instances of the PlayPingPongThread and start these thread
 *        instances to correctly alternate printing "Ping" and "Pong",
 *        respectively, on the console display.
 */
public class PingPongRight {
	/**
	 * Number of iterations to run the test program.
	 */
	public static int mMaxIterations = 10;

	/**
	 * Latch that will be decremented each time a thread exits.
	 */
	public static CountDownLatch latch = new CountDownLatch(mMaxIterations); // TODO - You fill in here

	/**
	 * @class PlayPingPongThread
	 *
	 * @brief This class implements the ping/pong processing algorithm
	 *         using the SimpleSemaphore to alternate printing "ping"
	 *         and "pong" to the console display.
	 */
	public static class PlayPingPongThread extends Thread
	{
		/**
		 * Constructor initializes the data member.
		 */
		public PlayPingPongThread (/* TODO - You fill in here */)
		{
			// TODO - You fill in here.
			SimpleSemaphore pingSema = new SimpleSemaphore(mMaxIterations, true);
			SimpleSemaphore pongSema = new SimpleSemaphore(mMaxIterations, true);

			ping = "Ping(" + pingSema.getAvailablePermits() + ")!";
			pong = "Pong(" + pongSema.getAvailablePermits() + ")!";

		}

		/**
		 * Main event loop that runs in a separate thread of control
		 * and performs the ping/pong algorithm using the
		 * SimpleSemaphores.
		 */
		public void run () 
		{
			// TODO - You fill in here.

			// print "ping(#)!"
			try {
				latch.await();			//acquire a countdown instance from the latch's synchronizer
				pingSema.acquire();		//attempts to acquire lock and decrement the semaphore, and return the lock
				System.out.println(ping);	// in the context of the strategy pattern, this would be the console strategy.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				pingSema.release();
				latch.countDown();		// count down the latch

			}

			//print "pong(#)!"... see method comments directly above
			try {
				latch.await();
				pongSema.acquire();
				System.out.println(pong);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				pongSema.release();				
				latch.countDown();

			}        	
		}

		/**
		 * String to print (either "ping!" or "pong"!) for each
		 * iteration.
		 */
		// TODO - You fill in here.
		private String ping;
		private String pong;

		/**
		 * The two SimpleSemaphores use to alternate pings and pongs.
		 */
		// TODO - You fill in here.
		private SimpleSemaphore pingSema;
		private SimpleSemaphore pongSema;

	}

	/**
	 * The main() entry point method into PingPongRight program. 
	 */
	public static void main(String[] args) {
		try {         
			// Create the ping and pong SimpleSemaphores that control
			// alternation between threads.

			// TODO - You fill in here.

			System.out.println("Ready...Set...Go!");

			// Create the ping and pong threads, passing in the string
			// to print and the appropriate SimpleSemaphores.
			PlayPingPongThread ping =
					new PlayPingPongThread(/* TODO - You fill in here */);
			PlayPingPongThread pong =
					new PlayPingPongThread(/* TODO - You fill in here */);

			// Initiate the ping and pong threads, which will call the
			// run() hook method.
			ping.start();
			pong.start();

			// Use barrier synchronization to wait for both threads to
			// finish.

			// TODO - replace replace the following line with a
			// CountDownLatch barrier synchronizer call that waits for
			// both threads to finish.
			throw new java.lang.InterruptedException();
		} 
		catch (java.lang.InterruptedException e)
		{}

		System.out.println("Done!");
	}
}
