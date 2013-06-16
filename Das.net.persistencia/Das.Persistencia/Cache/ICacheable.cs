using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Das.Persistencia.Cache
{
    public interface ICacheable {
        string GetCacheKey();
        void SetCacheKey(string value);
    }

    public class Cacheable<T> : ICacheable
    {
        public string cacheKey { get; set; }
        public T objToCache { get; set; }
        public string GetCacheKey() 
        {
            if(string.IsNullOrEmpty(cacheKey))
                throw new Exception("Chave de cache nao atribuida");
            return cacheKey;
        }
        public void SetCacheKey(string value) { cacheKey = value; }
    }
}
