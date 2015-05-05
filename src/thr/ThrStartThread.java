package thr;

public class ThrStartThread implements Runnable{

	@Override
	public void run() {
		ControleBoucle.boucleMono();
	}

}
