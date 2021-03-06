package hr.fer.zemris.optjava.dz5.part2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class OX2 implements ICrossP {

	private Random rand=null;
	
	public OX2(Random r) {
		rand = r;
	}

	@Override
	public PermSolution[] cross(PermSolution p1, PermSolution p2) {
		int brPoz = rand.nextInt(p1.p.length);
		Set<Integer> poz = new HashSet<Integer>();
		PermSolution[] ch = new PermSolution[2];
		ch[0] = new PermSolution(p1.p.length);
		ch[1] = new PermSolution(p1.p.length);
		
		while(poz.size()<brPoz) {
			poz.add(rand.nextInt(p1.p.length));
		}
		ArrayList<Integer> ph1 = new ArrayList<Integer>();
		ArrayList<Integer> ph2 = new ArrayList<Integer>();
		
		Iterator<Integer> pozi = poz.iterator();
		
		while(pozi.hasNext()) {
			int i = pozi.next();
			ph1.add(p1.p[i]);
			ph2.add(p2.p[i]);
		}
		
		for(int i=0;i<p1.p.length;i++) {
			if(ph1.contains(p2.p[i])) {
				ch[0].p[i] = ph1.get(0);
				ph1.remove(0);
			}else {
				ch[0].p[i] = p2.p[i];
			}
			if(ph2.contains(p1.p[i])) {
				ch[1].p[i] = ph2.get(0);
				ph2.remove(0);
			}else {
				ch[1].p[i] = p1.p[i];
			}
		}
		
		return ch;
	}

}
