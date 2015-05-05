package thr;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import util.MonUtil;


public class ControleBoucle{

	public static void boucleMono() { //en cas de probleme ce thread dois etre relancer automatiquement.
		System.out.print("Début du thread infini");
		ScheduledExecutorService scheduler;
		boolean infinite = true;
		
		while(infinite){
			scheduler = Executors.newSingleThreadScheduledExecutor();
			int id = MonUtil.randInt(1, 10);
			ScheduledFuture<?> handle = scheduler.scheduleWithFixedDelay (new Jobs(), 5, 5, TimeUnit.SECONDS);
	    	try {
				handle.get();
			} catch (InterruptedException e) {
				System.err.print("ThreadBoucle InterruptedException");
			} catch (ExecutionException e) {
				System.err.print("ThreadBoucle ExecutionException");
			} catch (ArithmeticException e) {
				System.err.print("ArithmeticException Exception");
		    } catch (Exception e){
		    	System.err.print("ThreadBoucle Exception");
		    }
		}
		
	}
	
	public static void boucleMulti(int nb) { //en cas de probleme ce thread dois etre relancer automatiquement.
		ScheduledExecutorService scheduler;
		scheduler = Executors.newScheduledThreadPool(nb);
		for(; nb>0;nb--){
			scheduler.schedule(new ThrStartThread(), 2, TimeUnit.SECONDS);
		}
	}
	

}
