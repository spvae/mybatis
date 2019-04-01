package com.mybatis.utils;
import org.apache.ibatis.cache.Cache ;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;


/**
 * ref
 * PerpetualCache
 * the  defaultImp
 */

public class MyCustomCache implements Cache{

 private  String id = null;
 private Map<Object, Object> cache = new HashMap();

   @Override
   public  String getId(){
    return this.id;
   }

 @Override
    public void putObject(Object var1, Object var2){
          this.cache.put(var1, var2);
    }
 @Override
    public Object getObject(Object var1){
        return this.cache.get(var1);
    }

 @Override
    public  Object removeObject(Object var1){
        return this.cache.remove(var1);
    }

 @Override
    public void clear(){
       this.cache.clear();
    }

 @Override
    public int getSize(){
      return this.cache.size();
    }

 @Override
    public ReadWriteLock getReadWriteLock(){
      return null;
    }
}