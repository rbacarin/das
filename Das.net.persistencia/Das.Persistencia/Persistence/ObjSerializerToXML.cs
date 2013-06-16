using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.IO;
using System.Xml.Serialization;

namespace Das.Persistencia
{
    public class ObjSerializerToXML : Serializer
    {

        public override bool Save<T>( T value)
        {
            string FileName = typeof(T).Name + "1.xml";

            XmlSerializer xs = new XmlSerializer(typeof(List<T>));
            if (!File.Exists(FileName))
            {
                List<T> new_val = new List<T>() { value };
                Stream my_S = File.OpenWrite(FileName);
                    xs.Serialize(my_S, new_val);
                    my_S.Close();
            }
            else
            {
                Stream sx = File.OpenRead(FileName);
                List<T> new_val = (List<T>)xs.Deserialize(sx);
                sx.Close();
                new_val.Add(value);
                Stream s = File.OpenWrite(FileName);
                    xs.Serialize(s, new_val);
                    s.Close();
                
            }
            
            return true;
        }

        public override T Get<T>(string type)
        {
            XmlSerializer xs = new XmlSerializer(typeof(List<T>));
            return (T)xs.Deserialize(File.OpenWrite(typeof(T).Name));
        }

        public override bool Delete<T>(T key)
        {
            XmlSerializer xs = new XmlSerializer(typeof(List<T>));
            T obj = (T)xs.Deserialize(File.OpenWrite(typeof(T).Name));

            return true;
        }

        public override bool Compare<T>(T a, T b)
        {
            return a.GetHashCode() == b.GetHashCode();
        }
    }
}
