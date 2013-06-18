public class Memento {
   private Object state;
   private String Key;

   public Memento(Object stateToSave, String key) { state = stateToSave; setKey(key); }
   public Object getSavedState() { return state; }

   public String getKey() {
	   return Key;
   }
   public void setKey(String key) {
	   Key = key;
   }
}