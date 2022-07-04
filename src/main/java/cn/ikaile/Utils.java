package cn.ikaile;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static cn.ikaile.BetterLimit.*;

public class Utils {
    //加钱
    public static void addMoney(Player player, int num){
        if(playerMoneyHashMap.isEmpty()){
            playerMoneyHashMap.put(player,num);
        }
        if(isEnoughMoney(player)){
            int money = playerMoneyHashMap.get(player);
            playerMoneyHashMap.put(player,(money+num));
            econ.depositPlayer(player, num);
            int tempMoney = (limitTotal-money);
            if(tempMoney < 0) tempMoney = 0;
            player.sendMessage("今日从系统获得了"+money+"金币，还可以获得"+tempMoney+"金币(可能存在缓存 下一次消费时会刷新)，请注意超出限制后物品仍然接受回收但无法获得到金币，请等待每日0:00自动刷新限制");
        }else{
            player.sendMessage("今日从系统获得的金币已经达到了上限，请等待每日0:00自动刷新限制，每日限制"+limitTotal+"金币");
        }
    }
    public static boolean isEnoughMoney(Player player){
        return playerMoneyHashMap.get(player) < limitTotal;
    }
    public static Player findPlayer(String s){
        return Bukkit.getPlayer(s);
    }
}
