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

    private WeakHashMap<Player, LocalDateTime> lastMessageDates = new WeakHashMap<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        LocalDateTime now = LocalDateTime.now();
        Player player = event.getPlayer();

        if (!player.hasPermission("chatmanager.bypass.spam")
                && Duration.between(lastMessageDates.get(player), now).toMillis() < ChatManagerPlugin.getSpamInterval()) {
            player.sendMessage("Çok hızlı yazıyorsun!");
            event.setCancelled(true);
        } else if (!player.hasPermission("chatmanager.bypass.lock") && ChatManagerPlugin.isChatLocked()) {
            player.sendMessage("Sohbet şu anda kilitli!");
            event.setCancelled(true);
        }

        lastMessageDates.put(player, now);
    }

}
