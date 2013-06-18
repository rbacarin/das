import java.util.ArrayList;

	public class ThePersistant extends IPersistence {

		private Serializer PersistenceEngine;

		public ThePersistant() {
			this.PersistenceEngine = new ObjSerializertoXML();
		}
		
		public ThePersistant(Serializer engine){
			this.PersistenceEngine=engine;
		}

		@Override
		public <T> boolean Delete(T key) {
			return PersistenceEngine.Delete(key);
		}

		@Override
		public <T> T Get(String className, String key) {
			return PersistenceEngine.Get(className,key);
		}
		
		public <T> ArrayList<T> GetAll(String className) {
			return PersistenceEngine.GetAll(className);
		}

		@Override
		public <T> boolean Save(T value) {
			return PersistenceEngine.Save(value);
		}
	}
