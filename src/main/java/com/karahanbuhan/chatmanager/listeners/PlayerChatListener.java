package com.karahanbuhan.chatmanager.listeners;

import com.karahanbuhan.chatmanager.ChatManagerPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.WeakHashMap;

public class PlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        LocalDateTime now = LocalDateTime.now();
        Player player = event.getPlayer();

        if (!player.hasPermission("chatmanager.bypass.lock") && ChatManagerPlugin.isChatLocked()) {
            player.sendMessage("Sohbet şu anda kilitli!");
            event.setCancelled(true);
        }
    }

}
