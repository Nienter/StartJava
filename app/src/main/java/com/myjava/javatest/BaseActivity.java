package com.myjava.javatest;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collection;
import java.util.Collections;

public abstract class BaseActivity extends AppCompatActivity implements EventManager.OnEventListener {
    private PluginHelper<ActivityBasePlugin> mPluginHelper;
    private EventManager eventManager;


    public boolean isSyncPlugin() {
        return false;
    }

    public final void registerPlugin(ActivityBasePlugin plugin) {
        if (mPluginHelper == null) {
            if (isSyncPlugin()) {
                mPluginHelper = new SyncPluginHelper<ActivityBasePlugin>();
            } else {
                mPluginHelper = new PluginHelper<ActivityBasePlugin>();
            }
        }
        mPluginHelper.addManager(plugin);
        if (plugin instanceof ActivityPlugin) {
            ((ActivityPlugin) plugin).setActivity(this);
        }
    }

    public final void registerPluginAtHead(ActivityBasePlugin plugin) {
        if (mPluginHelper == null) {
            mPluginHelper = new PluginHelper();
        }
        mPluginHelper.addManagerAtHead(plugin);
        if (plugin instanceof ActivityPlugin) {
            ((ActivityPlugin) plugin).setActivity(this);
        }
    }

    public final void removePlugin(ActivityBasePlugin plugin) {
        if (mPluginHelper != null) {
            mPluginHelper.removeManager(plugin);
        }
    }

    public final <T extends ActivityBasePlugin> Collection<T> getPlugins(Class<T> cls) {
//		if(mGetPluginDelegate != null){
//			return mGetPluginDelegate.getPlugins(cls);
//		}
        if (mPluginHelper == null) {
            return Collections.emptySet();
        }
        return mPluginHelper.getManagers(cls);
    }

    public final PluginHelper<ActivityBasePlugin> getPluginHelper() {
        return mPluginHelper;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPluginHelper != null) {
            for (ActivityPlugin<?> ap : getPlugins(ActivityPlugin.class)) {
                ap.onDestroy();
            }
            mPluginHelper.clear();
        }
    }

    @Override
    public void onEventRunEnd(Event event) {
        final String code = event.getStringCode();
        if (!event.isSuccess()) {
            final Exception e = event.getFailException();
            if (e != null) {
//                onHandleError();
            }
        }
    }


}
