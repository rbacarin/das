import java.io.*;

	public class ObjSerializer extends Serializer {
	
		/**
		 * 
		 * @param ClassName Class do objeto (Define o nome do arquivo)
		 * @param key Identificador do objeto buscado
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public <T> T Get(String ClassName, String key) {
			T o=null;
			 
			try
		      {
				File file = new File(ClassName+".ser");
				 
			      if (file.createNewFile()){
			        System.out.println("File is created!");
			      }else{
			        System.out.println("File already exists.");
			      }
				
		         FileInputStream fileIn = new FileInputStream(ClassName+".ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         o = (T) in.readObject();
		         in.close();
		         fileIn.close();
		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return null;
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Employee class not found");
		         c.printStackTrace();
		         return null;
		      }
		      
		      return o;
		}
		

		@Override
		public <T> boolean Save(T save) {
			try
			{
				String filename = save.getClass().getName() + ".ser";
				FileOutputStream fileOut = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(save);
				out.close();
				fileOut.close();
			}
			catch(IOException i)
			{
				i.printStackTrace();
				return false;
			}
			
			return true;
		}


		
		
		@Override
		public <T> boolean Compare(T a, T b) {
			return a.hashCode() == b.hashCode();
		}
		
		


		@Override
		public <T> boolean Delete(T value) {
			String filename = value.getClass().getName() + ".ser";
			
			File f = new File(filename);
			
			if (f.exists())
				return f.delete();
			
			return false;
		}
	}
