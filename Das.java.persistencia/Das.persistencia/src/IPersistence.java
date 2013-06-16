	public abstract class IPersistence {

		public abstract <T> boolean Save(T value);
		public abstract <T> T Get(String className, String key);
		public abstract <T> boolean Delete(T key);
	}