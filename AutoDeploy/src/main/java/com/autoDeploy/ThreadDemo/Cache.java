package com.autoDeploy.ThreadDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//ReentrantReadWriteLock读写锁示例
/** 3大特性
 * 公平选择性
 * 重进入
 * 锁降级
 * */
public class Cache{
	static Map<String,Object> map = new HashMap<String,Object>();
	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static Lock rLock = rwl.readLock();
	static Lock wLock = rwl.writeLock();
	//获取一个key对应的value
	public static final Object get(String key){
		rLock.lock();
		try{
			return map.get(key);
		}finally{
			rLock.unlock();
		}
	}
	//设置key对应的value并返回旧的value
	public static final Object put(String key,Object value){
		wLock.lock();
		try{
			return map.put(key,value);
		}finally {
			wLock.unlock();
		}
	}
	//清空缓存
	public static final void clear(){
		wLock.lock();
		try{
			map.clear();
		} finally{
			wLock.unlock();
		}
	}
}