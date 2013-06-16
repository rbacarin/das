using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Das.Persistencia
{
    public interface IPersistence
    {
        bool Save<T>(T value);
        T Get<T>(string key);
        bool Delete<T>(T value);
    }
}
