import java.util.ArrayList;

public class Main {
	public static int RAGen = 1;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{ 
		//Cria classe de persistência passando o objeto que implementa a interface persistivel.
		ThePersistant tp = new ThePersistant(new ObjSerializertoXML());
		//Cria objectos para persistir em XML
		Aluno alunoInst = new Aluno("Robson",65);
		Aluno alunoInst2 = new Aluno("Fred",66);
		Aluno alunoInst3 = new Aluno("Cristiano",67);
		tp.Save(alunoInst);
		tp.Save(alunoInst2);
		tp.Save(alunoInst3);
			
		Aluno a = tp.Get("Aluno","Fred");
		System.out.println("Aluno buscado é :" + a.nomeAluno);
		
		ArrayList<Aluno> all = tp.GetAll("Aluno");
		for (Aluno aluno : all) {
			System.out.println("um dos alunos é: " + aluno.nomeAluno);
		}
				
		//Caching
		Originator ori = new Originator();
		//Cria o objeto de cache e Adiciona ao cache
		CareTaker.AddMemento(ori.SaveToMemento(alunoInst.nomeAluno,alunoInst));
		
		//Recupera do cache passando a chave
		Aluno cachedAluno = (Aluno) ori.RestoreFromMemento(CareTaker.GetMemento("Robson"));
		System.out.println(cachedAluno.nomeAluno);		
	}	
}

