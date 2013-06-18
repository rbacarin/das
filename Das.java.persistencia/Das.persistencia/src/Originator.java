
public class Originator {
   private Object cached;
 
   public void SetCachedObj(Object state) { 
       System.out.println("Originator: caching ...");
       this.cached = state; 
   }

   public Memento SaveToMemento(String key) { 
       System.out.println("Originator: Saving to Memento.");
       return new Memento(cached,key); 
   }
   
   public Memento SaveToMemento(String key, Object o) { 
       System.out.println("Originator: Saving to Memento.");
       SetCachedObj(o);
       return new Memento(o,key); 
   }
   
   public Object RestoreFromMemento(Memento m) {
	   System.out.println("Originator: State after restoring from Memento: ");
       return ((Memento) m).getSavedState(); 
   }
}   