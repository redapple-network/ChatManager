package com.karahanbuhan.chatmanager;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ChatManagerPlugin extends JavaPlugin {

    private Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();

        logger.info("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        logger = getLogger();

        logger.info("Plugin disabled.");
    }

}
