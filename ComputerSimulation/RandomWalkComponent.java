package ComputerSimulation;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RandomWalkComponent implements Runnable {
	private Random rnd;
	private int trialNum;

	public void simulate(int trialNum, double prob) {
		this.trialNum = trialNum;
		rnd = new Random(trialNum, prob);
		Thread th = new Thread(this);
		th.start();
	}
	
	public void run() {
		int[] walkTraj = rnd.getTraj();
		XYSeries xy = new XYSeries("Random Walk");
		int xValue = 0;
		for (int i = 0; i < trialNum; i++) {
			xy.add(i, xValue);
			xValue += walkTraj[i];
		}
		XYSeriesCollection xyc = new XYSeriesCollection();
		xyc.addSeries(xy);
		
		JFreeChart chart = ChartFactory.createXYLineChart("Random Walk", "The number of trial", "x", xyc, PlotOrientation.VERTICAL, true, false, false);
		chart.getXYPlot().getRenderer().setSeriesStroke(0, new BasicStroke(2));
		chart.getPlot().setBackgroundPaint(Color.WHITE);

		
		ChartFrame frame = new ChartFrame("Random Walk (^^)", chart);
		frame.setVisible(true);
		frame.setSize(600, 400);
	}

}
