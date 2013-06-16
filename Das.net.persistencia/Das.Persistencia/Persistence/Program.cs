using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Das.Persistencia.Cache;

namespace DAS.memento
{
    class Program
    {
        static void Main(string[] args)
        {
            Das.Persistencia.ObjSerializerToXML persistencia = new Das.Persistencia.ObjSerializerToXML();


            List<aluno> alunos = new List<aluno>();
            alunos.Add(new aluno() { nome = "aluno1", telefone = "1111-1111"});
            persistencia.Save<List<aluno>>(alunos);

            aluno a = new aluno() { nome = "aluno2", telefone = "1111-1111" };
            persistencia.Save<aluno>(a);

            ObjCache.InsertCache<aluno>(a);

            ObjCache.GetFromCache<aluno>("a2cachekey");

            Console.ReadKey();
            
        }

       
    }

    public class aluno:Das.Persistencia.Persistable, ICacheable
    {
        public string nome { get; set; }
        public string telefone { get; set; }

        public override string ToString()
        {
            return nome.GetHashCode().ToString();
        }

        public string GetCacheKey()
        {
            return GetCacheKey();
        }
    }
}
