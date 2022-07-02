package cn.ikaile;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            if(args.length <1){
                System.out.println("§a/blmit add 玩家id 金额 \n§a/blmit reload");
                return true;
            }
        }
        if(!sender.isOp()){
            sender.sendMessage("[BetterLimit] 您没有权限完成这件事情");
            return true;
        }
        if(args.length <1){
            getHelp((Player) sender);
            return true;
        }
        switch (args[0]){
            case "add":
                if(args.length < 3){
                    return true;
                }
                Player player = Utils.findPlayer(args[1]);
                Utils.addMoney(player, Integer.parseInt(args[2]));
                return true;
            case "reload":
                new File().getConfig();
        }

        return true;
    }
    public static void getHelp(Player player){
        player.sendMessage("§6---------------[§aBetterLimit§6]---------------");
        player.sendMessage("§a/blmit add 玩家id 金额 \n§a/blmit reload");
        player.sendMessage("§6-----------------------------------");
    }
}
