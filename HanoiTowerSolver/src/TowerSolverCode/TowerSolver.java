package TowerSolverCode;
import java.util.*;
public class TowerSolver {
	public int step=0;
	public void solveTower(char[] Pos,int towerSize) {
		if(towerSize<2){ // the other position is always 6 minus the other two (1+2+3=6)
			System.out.println("move from "+Pos[0]+" to "+Pos[1]);
			step++;
			return;
		}
		solveTower(new char[]{Pos[0],Pos[2],Pos[1]}, towerSize-1);
		System.out.println("move from "+Pos[0]+" to "+Pos[1]);
		step++;
		solveTower(new char[]{Pos[2],Pos[1],Pos[0]}, towerSize-1);	
	}
	public static void main(String[] args) {
		TowerSolver solv=new TowerSolver();
		solv.solveTower(new char[]{'1','2','3'}, 4);
		System.out.println("used "+solv.step+" steps");
	}
}
