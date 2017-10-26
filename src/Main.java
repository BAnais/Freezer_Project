

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Started");
		
		// Création du modèle
		Model model = new Model();
		
		//Création du controleur
		Controller controller = new Controller(model);
		
		// Création Arduino
		Arduino arduino = new Arduino(model);
		arduino.startArduino();
	}
}
