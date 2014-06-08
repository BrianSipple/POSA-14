package edu.vuum.mocca;
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
public class PingPongRight_rough {
	/**
	 * Number of iterations to run the test program.
	 */
	public static int mMaxIterations = 10;

	/**
	 * Latch that will be decremented each time a thread exits.
	 */
	public static CountDownLatch latch = new CountDownLatch(2); // TODO - You fill in here

	/**
	 * @class PlayPingPongThread
	 *
	 * @brief This class implements the ping/pong processing algorithm
	 *         using the SimpleSemaphore to alternate printing "ping"
	 *         and "pong" to the console display.
	 */
	public static class PlayPingPongThread extends Thread
	{

		private SimpleSemaphore[] mSemas = new SimpleSemaphore[3];
		/**
		 * Constructor initializes the data member.
		 */
		public PlayPingPongThread (String stringToPrint, SimpleSemaphore sema1, SimpleSemaphore sema2)
		{
			mStringToPrint = stringToPrint;
			mSemas[FIRST_SEMA] = sema1;
			mSemas[SECOND_SEMA] = sema2;
		}

		/**
		 * Main event loop that runs in a separate thread of control
		 * and performs the ping/pong algorithm using the
		 * SimpleSemaphores.
		 */
		public void run () 
		{

			// Go for printout!
			mSemas[FIRST_SEMA].acquireUninterruptibly();
			System.out.println(mStringToPrint);
			mSemas[FIRST_SEMA].release();
			latch.countDown();
			

		}

		/**
		 * String to print (either "ping!" or "pong"!) for each
		 * iteration.
		 */
		// TODO - You fill in here.
		private String mStringToPrint;

		/**
		 * The two SimpleSemaphores use to alternate pings and pongs.
		 */
		// TODO - You fill in here.
		private int FIRST_SEMA = 1;
		private int SECOND_SEMA = 2;

	}

	/**
	 * The main() entry point method into PingPongRight program. 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		try {   
			System.out.println("Ready...Set...Go!");
			for (int currentIter = 0; currentIter < mMaxIterations; currentIter++) {

				// Create the ping and pong SimpleSemaphores that control
				// alternation between threads.

				// TODO - You fill in here.
				SimpleSemaphore pingSema = new SimpleSemaphore(1, true);
				SimpleSemaphore pongSema = new SimpleSemaphore(1, true);

				String pingString = "ping(" + currentIter + ")!";
				String pongString = "pong(" + currentIter + ")!";

				// Create the ping and pong threads, passing in the string
				// to print and the appropriate SimpleSemaphores.
				PlayPingPongThread ping =
						new PlayPingPongThread(pingString, pingSema, pongSema);
				PlayPingPongThread pong =
						new PlayPingPongThread(pongString, pongSema, pingSema);

				// Initiate the ping and pong threads, which will call the
				// run() hook method.
				ping.start();
				pong.start();
				
				// Use barrier synchronization to wait for both threads to
				// finish.

				// TODO - replace replace the following line with a
				// CountDownLatch barrier synchronizer call that waits for
				// both threads to finish.
				latch.await();
			}
		} 
		catch (java.lang.InterruptedException e){
			//e.printStackTrace();
		}

		Thread.sleep(1);
		System.out.println("Done!");
	}

}
