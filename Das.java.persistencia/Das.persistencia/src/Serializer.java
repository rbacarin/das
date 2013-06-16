	public abstract class Serializer {
		
		public abstract <T> boolean Save(T save);

		public abstract <T> T Get(String ClassName, String key);

		public abstract <T> boolean Delete(T value);

		public abstract <T> boolean Compare(T a, T b);

	}