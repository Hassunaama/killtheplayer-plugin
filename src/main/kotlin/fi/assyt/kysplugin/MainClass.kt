package fi.assyt.kysplugin

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class MainClass : JavaPlugin(), CommandExecutor {

    override fun onEnable() {
        // Plugin startup logic
        getCommand("kys")?.setExecutor(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("so... you killed me?")
    }

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            sender.health = 0.0
            Bukkit.getServer().broadcast(
                Component.text("so " + sender.name + " decided to kill themselves ")
                    .append(Component.text("(but why tho)", NamedTextColor.DARK_RED))
            )
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage("aight bet")
            Bukkit.getServer().broadcast(Component.text("server is shutting down"))

            Bukkit.shutdown()
        } else {
            sender.sendMessage("what are you? a mob?")
        }

        return true
    }
}
