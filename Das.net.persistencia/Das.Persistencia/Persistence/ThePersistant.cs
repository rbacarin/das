using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Das.Persistencia
{
    public class ThePersistant : IPersistence
    {
        public ThePersistant(Serializer engine)
        {
            this.PersistenceEngine = engine;
        }
        public ThePersistant()
        {
            this.PersistenceEngine = new ObjSerializerToTXT();
        }

        private Serializer PersistenceEngine
        {
            get;
            set;
        }

        public bool Save<T>(T value)
        {
            throw new NotImplementedException();
        }

        public T Get<T>(string key)
        {
            throw new NotImplementedException();
        }

        public bool Delete<T>(T value)
        {
            throw new NotImplementedException();
        }
    }
}
