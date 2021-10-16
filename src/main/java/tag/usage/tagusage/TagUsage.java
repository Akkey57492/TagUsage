package tag.usage.tagusage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TagUsage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "TagUsageが有効になりました");
    }

    @Override
    public void onDisable() {
        getLogger().warning(ChatColor.RED + "TagUsageが無効になりました");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("thtag")) {
            if(args[0].equalsIgnoreCase("add")) {
                Player player = Bukkit.getServer().getPlayer(args[2]);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tag " + player.getName() + " add " + args[1]);
                sender.sendMessage(ChatColor.GREEN + "Success");
            }
            else if(args[0].equalsIgnoreCase("remove")) {
                Player player = Bukkit.getServer().getPlayer(args[2]);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tag " + player.getName() + " remove " + args[1]);
                sender.sendMessage(ChatColor.GREEN + "Success");
            }
            else {
                sender.sendMessage("Invalid Argument");
                sender.sendMessage("Usage: /thtag <type> <tagname> <username>");
            }
        }
        return false;
    }
}
