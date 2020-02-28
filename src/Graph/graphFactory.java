package Graph;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class graphFactory {

	ResultSet rs = null;
	
	public graphFactory() {
		
	}
	
	public ChartPanel createGraph(ResultSet rs, String title, String xAxisName, String yAxisName) {
		this.rs = rs;
;
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		 try {
		    	while(rs.next()) {
					dataset.addValue(rs.getInt(2), xAxisName, rs.getDate(1));
		    	}	
		    } catch (SQLException e1) {
					e1.printStackTrace(); 
		}
		
		JFreeChart chart = ChartFactory.createLineChart(title, xAxisName, yAxisName, dataset);
		chart.setBackgroundPaint(Color.LIGHT_GRAY);
		chart.getTitle().setPaint(Color.BLACK);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setSize(350,200);
		
		return chartPanel;
	}
	
}
