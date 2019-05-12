package com.karahanbuhan.chatmanager;

import com.karahanbuhan.chatmanager.commands.LockChatCommand;
import com.karahanbuhan.chatmanager.listeners.PlayerChatListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ChatManagerPlugin extends JavaPlugin {

    private static boolean isChatLocked = false;
    private static int spamInterval = 1000;

    private Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();

        registerListeners();
        setExecutors();

        logger.info("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        logger = getLogger();

        logger.info("Plugin disabled.");
    }

    public void setExecutors() {
        getCommand("kilitle").setExecutor(new LockChatCommand());
    }

    public void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerChatListener(), this);
    }

    public static boolean toggleChatLock() {
        isChatLocked = !isChatLocked;

        return isChatLocked;
    }

    public static boolean isChatLocked() {
        return isChatLocked;
    }

    public static int getSpamInterval() {
        return spamInterval;
    }

}
