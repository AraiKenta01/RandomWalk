package ComputerSimulation;

public class Random {
	private int trialNum = 100;
	
	private int[] walkTraj;
	private double prob;
	
	public Random(int trialNum, double prob) {
		this.trialNum = trialNum;
		this.prob = prob;
		compute();
	}
	
	public void compute() {
		walkTraj = new int[trialNum];
		for (int i = 0; i < trialNum; i++) {
			if(Math.random() < prob) {
				walkTraj[i] = 1;
			}
			else {
				walkTraj[i] = -1;
			}
		}
	}
	
	public int[] getTraj() {
		return walkTraj;
	}

}
