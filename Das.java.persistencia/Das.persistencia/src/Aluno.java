import java.io.Serializable;

public class Aluno extends Persistable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Aluno(String nome, int RA)
	{
		nomeAluno = nome;
		super.setID(RA);
	}
		
	public String nomeAluno;
	public int RA;
}