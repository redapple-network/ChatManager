package com.karahanbuhan.chatmanager.commands;

import com.karahanbuhan.chatmanager.ChatManagerPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LockChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Sohbet kilidi " + (ChatManagerPlugin.toggleChatLock() ? "aktif" : "pasif") + ".");

        return true;
    }

}
