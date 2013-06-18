import java.util.ArrayList;

public class CareTaker {
	   private static ArrayList<Memento> savedStates = new ArrayList<Memento>();

	   public static void AddMemento(Memento m) { 
		   savedStates.add(m);
		   }
	   
	   public static Memento GetMemento(String key) {
		   for (Memento element : savedStates) {
			if(element.getKey().equals(key))
				return element;
		   }
		   return null;		   
	   }
}