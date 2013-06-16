using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Das.Persistencia
{
    public class ObjSerializerToTXT : Serializer
    {

        public override bool Save<T>(T value)
        {
            throw new NotImplementedException();
        }

        public override T Get<T>(string key)
        {
            throw new NotImplementedException();
        }

        public override bool Delete<T>(T key)
        {
            throw new NotImplementedException();
        }

        public override bool Compare<T>(T a, T b)
        {
            throw new NotImplementedException();
        }
    }
}
