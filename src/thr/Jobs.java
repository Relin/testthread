package thr;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import util.MonUtil;

public class Jobs implements Runnable {


	@Override
	public void run(){
		int id = MonUtil.randInt(1, 1000);
		long threadId = Thread.currentThread().getId();
		System.out.println("Le thread " + threadId + " Je doit traiter des données pour "+ id +" !!!");
		for(int i=0; i<10; i++){
			int ran = MonUtil.randInt(1, 2);
			if(ran==1){
				for(int j=0; j<1000; j++){
					for(int x=0; x<1000; x++){
						int t = MonUtil.randInt(25, 75);
						for(int y=0; y<t;y++){
							int az = MonUtil.randInt(1000, 1000000);
							int aa = MonUtil.randInt(1000, 1000000);
							int bb = 0;
							if (aa>az){
								bb=aa%az;
								
							}
							else{
								bb=az%aa;
							}
							
						}
						int r1 = MonUtil.randInt(1, 1000000);
						if(r1==100){
							System.out.println("Le thread " + threadId + " Bingo 100");
						}
						if(r1==1000){
							System.out.println("Le thread " + threadId + " Bingo 1000");
						}
					}
				}
			}
			System.out.println("Le thread " + threadId + " Je fais des truc " + i);
			if(ping("www.google.be"))
				System.out.println("ping ok");
			else
				System.out.println("ping failed");
			System.out.println("Le thread " + threadId +" prog " + id + " est terminer a "+ (i+1) + "0%");
		}
		int r2 = MonUtil.randInt(1, 10);
		if(r2==5){
			int error = 10/0;
		}
		System.out.println(threadId + "J'ai fini le jobs "+id+" petite pause avant la suite !!!");
	}
	
	private boolean ping(String url) {
		Socket socket = null;
		boolean reachable = false;
		try {
		    socket = new Socket(url, 80);
		    reachable = true;
		} catch (UnknownHostException e) {
			System.err.println("UnknownHostException");
		} catch (IOException e) {
			System.err.println("IOException");
		} finally {            
		    if (socket != null)
		    	try {
		    		socket.close();
		    	} catch(IOException e) {}
		}
		return reachable;
	}
	

}
