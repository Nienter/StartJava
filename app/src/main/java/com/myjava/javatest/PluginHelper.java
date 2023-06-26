package com.myjava.javatest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PluginHelper<JK> {
	
	private ArrayList<JK> registeredManagers;
	private Map<Class<? extends JK>, Collection<?>> registeredManagersCache;
	
	private HashMap<Class<?>, HashMap<Class<?>, JK>> mapInterceptPluginManagers;
	@SuppressWarnings("rawtypes")
	private ArrayList wrapTemps;
	
	public void addManager(JK manager) {
		if(manager != null){
			checkNull();
			if(!registeredManagers.contains(manager)){
				registeredManagers.add(manager);
				registeredManagersCache.clear();
			}
		}
	}
	
	public void addManagerAtHead(JK manager){
		if(manager != null){
			checkNull();
			if(!registeredManagers.contains(manager)){
				registeredManagers.add(0,manager);
				registeredManagersCache.clear();
			}
		}
	}
	
	public void removeManager(Object manager){
		if(manager != null){
			if(registeredManagers != null){
				if(registeredManagers.remove(manager)){
					registeredManagersCache.clear();
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends JK> Collection<T> getManagers(
			Class<T> cls) {
		checkNull();
		Collection<T> collection = (Collection<T>) registeredManagersCache.get(cls);
		if (collection == null) {
			collection = new ArrayList<T>();
			for (Object manager : registeredManagers)
				if (cls.isInstance(manager))
					collection.add((T) manager);
			collection = Collections.unmodifiableCollection(collection);
			registeredManagersCache.put(cls, collection);
		}
		if(mapInterceptPluginManagers != null){
			HashMap<Class<?>, JK> map = mapInterceptPluginManagers.get(cls);
			if(map != null){
				if(wrapTemps == null){
					wrapTemps = new ArrayList<JK>();
				}
				wrapTemps.clear();
				for(T item : collection){
					JK manager = map.get(item.getClass());
					if(manager == null){
						wrapTemps.add(item);
					}else{
						wrapTemps.add(manager);
					}
				}
				return wrapTemps;
			}
		}
		return collection;
	}
	
	protected void checkNull(){
		if(registeredManagers == null){
			registeredManagers = new ArrayList<JK>();
		}
		if(registeredManagersCache == null){
			registeredManagersCache = new HashMap<Class<? extends JK>, Collection<?>>();
		}
	}
	
	public void clear(){
		if(registeredManagers != null){
			registeredManagers.clear();
		}
		if(registeredManagersCache != null){
			registeredManagersCache.clear();
		}
	}
	
	public <T extends JK> void interceptPlugin(
            Class<T> plugin, Class<?> wrapClass, JK manager){
		if(mapInterceptPluginManagers == null){
			mapInterceptPluginManagers = new HashMap<Class<?>, HashMap<Class<?>, JK>>();
		}
		HashMap<Class<?>, JK> map = mapInterceptPluginManagers.get(plugin);
		if(map == null){
			map = new HashMap<Class<?>, JK>();
			mapInterceptPluginManagers.put(plugin, map);
		}
		map.put(wrapClass, manager);
	}
}
