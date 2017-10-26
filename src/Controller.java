import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ActionListener, ModelObserver, ChangeListener{

	private static int vCons;
	private static View1 view;
	private Model data;
	private Timer timer ;
	private int step =0;
	public Controller(Model data) {

		view = new View1();

		this.data = data;
		data.addObserver(this);

		view.setVisible(true);
		view.slide.setVisible(true);
		this.timer = new Timer(100,this);
		this.timer.start();

	        view.spinner.addChangeListener(new ChangeListener()
	        {
	            @Override
	            public void stateChanged(ChangeEvent e)
	            {
	                view.slide.setValue((int) view.spinner.getValue());
	            }
	        });
		

		view.slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int consigne = view.slide.getValue();
				view.spinner.setValue(consigne);
				data.setSlider(consigne);
			}
		});


		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				data.setStateChange(false);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(data.getpRosee() >= data.getTempInt()){
			
			Color color = null;
			switch(step){
			case 0 : color = Color.ORANGE; break;
			case 1 : color = Color.GRAY; break; 
			default : step = 0;
			}
			step++;
			this.view.buttonCondensation.setForeground(color);
			
		}
	}

	
	
	// METHODES DE L'OBSERVEUR
	
	@Override
	public void onTemperatureIntChanged(double value) {
		// TODO
		view.chart.update(value);
		view.temp.setText(data.getTempInt()+" �C");

		if (data.getTempInt() < data.getSlider()){
			view.temperatureReached = true;
			view.btnTempAtteinte.setBackground(Color.GREEN);
		}else if (data.getTempInt() >= data.getSlider()){
			view.temperatureReached = false;
			view.btnTempAtteinte.setBackground(Color.RED);

		}

	}

	@Override
	public void onHumidityChanged(double value) {
		//gObjects.chart2.update(value);
		view.progressBar.setValue((int) data.getHumid());

		
	}

	@Override
	public void onTemperatureConsigneChanged(double value) {
		view.slide.setValue((Integer) view.spinner.getValue());
		view.spinner.setValue(view.slide.getValue());
		view.chart.updateConsigne(value);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		//TODO pwm arduino
		if(e.getSource()==view.spinner) {
			data.setTempCons((Float)view.spinner.getValue());
		}
		else if (e.getSource()==view.slide){
			data.setTempCons(view.slide.getValue());
		}
		
	}

	@Override
	public void onStateChanged(boolean value) {
		// TODO Auto-generated method stub
		
	}

}

/*
 * 
 * public static void main(String[] args) throws Exception {
 * 
 * 
 * 
 * 
 * Thread t=new Thread() { public void run() { try {Thread.sleep(1000000);}
 * catch (InterruptedException ie) {} } }; t.start();
 * System.out.println("Started");
 * 
 * EventQueue.invokeLater(new Runnable() {
 * 
 * @Override public void run() { Model data = new Model(); data.initialize();
 * gObjects = new View();
 * 
 * Timer timer = new Timer(1000, new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * 
 * String dataS = Model.getInput();
 * 
 * if (dataS!=null){ String parts[] = dataS.split("_"); String hum = parts[0];
 * String temp = parts[1]; String pRosee = parts[2]; float t =
 * Float.parseFloat(temp); float h = Float.parseFloat(hum);
 * gObjects.chart.update(t); gObjects.chart2.update(h);
 * gObjects.rosee.setText("Point de rosée: " + pRosee + " C°");
 * 
 * gObjects.slide.addChangeListener(new ChangeListener(){ public void
 * stateChanged(ChangeEvent event){ vCons =
 * ((JSlider)event.getSource()).getValue(); data.setSlider(vCons); } }); } } });
 * timer.start(); } }); }
 */
