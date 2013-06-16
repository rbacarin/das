using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Das.Persistencia
{
    public abstract class Serializer
    {

        public abstract bool Save<T>(T value);

        public abstract T Get<T>(string key);

        public abstract bool Delete<T>(T key);

        public abstract bool Compare<T>(T a, T b);


    }
}
