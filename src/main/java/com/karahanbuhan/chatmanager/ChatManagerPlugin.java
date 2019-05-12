package com.karahanbuhan.chatmanager;

import com.karahanbuhan.chatmanager.commands.LockChatCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ChatManagerPlugin extends JavaPlugin {

    private static boolean isChatLocked = false;

    private Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();

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

    public static boolean toggleChatLock() {
        isChatLocked = !isChatLocked;

        return isChatLocked;
    }

}
