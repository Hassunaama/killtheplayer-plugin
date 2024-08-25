package fi.assyt.kysplugin

import org.bukkit.Bukkit
import org.bukkit.command.CommandExecutor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class MainClass : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        getCommand("kys")?.setExecutor(KysCommand())
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("so... you killed me?")
    }
}

class KysCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            sender.health = 0.0
            Bukkit.broadcastMessage("so " + sender.name + " decided to kill themselves (but why tho)")
        }

        return true
    }
}
