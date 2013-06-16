using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Das.Persistencia.Cache
{
    public class ObjCache
    {
        static List<ICacheable> ObjsCache;
        public static List<ICacheable> GetObjCache()
        { if (ObjsCache == null)ObjsCache = new List<ICacheable>(); return ObjsCache; }

        public static T GetFromCache<T>(string key) where T : ICacheable
        {
            return (T)GetObjCache().FirstOrDefault(x => x.GetCacheKey() == key); 
        }

        public static bool InsertCache<T>(T obj) where T : ICacheable
        {
            string cacheKey = obj.GetCacheKey();
            return InsertCache<T>(cacheKey,obj);
        }

        public static bool InsertCache<T>(string cacheKey, T obj) where T : ICacheable
        {
            Cacheable<T> cachea = new Cacheable<T>();
            cachea.objToCache = obj;
            GetObjCache().Add(cachea);
            return true;
        }

    }
}
