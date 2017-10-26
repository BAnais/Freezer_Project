

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Started");
		
		// Cr�ation du mod�le
		Model model = new Model();
		
		//Cr�ation du controleur
		Controller controller = new Controller(model);
		
		// Cr�ation Arduino
		Arduino arduino = new Arduino(model);
		arduino.startArduino();
	}
}
