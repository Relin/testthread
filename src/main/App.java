package main;

import thr.ControleBoucle;

public class App {

	public static void main(String[] args) {
		System.out.println("Start");
		try{
			ControleBoucle.boucleMono();
//			ControleBoucle.boucleMulti(2);
		} catch (Exception e) {
			System.err.println("Exception remonter dans le main");
		}
		System.out.println("End");
	}
	
	/*
	 * Que ce passe t'il ?
	 * Le thread de controle/job est bloquant et infini.
	 * Donc si on veux l'appeler 2 fois directement, il faut
	 * lancer 2 thread qui n'ont comme but que de démarrer ce thread controle/job.
	 */
	
	/*
	 * Note N°2, si on passe directement par ControleBoucle.boucleMono();
	 * Celle-ci sera bloquante et on ne passera pas par le System.out.println("End");
	 * Par contre si on utilise ControleBoucle.boucleMulti(1);
	 * Le thread sera lancer 1 seul fois et passera par le System.out.println("End");
	 */
}
