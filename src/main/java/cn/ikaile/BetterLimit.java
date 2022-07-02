package cn.ikaile;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

public final class BetterLimit extends JavaPlugin {

    //文件
    public static Plugin myPlugin;
    public static FileConfiguration config;
    public static int limitTotal;

    public static HashMap<Player, Integer> playerMoneyHashMap;
    public static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Calendar calendar;
    public static int day;
    @Override
    public void onEnable() {
        //注册经济插件
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Vault前置插件未找到", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
        }
        //注册配置文件
        myPlugin = this;
        new File().getConfig();

        //注册命令
        Bukkit.getPluginCommand("blmit").setExecutor(new Commands());

        //定义时间
        calendar=Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //初始化hash
        playerMoneyHashMap = new HashMap<>();

        //加载完毕 定时器启动
        new Runnable().runTaskLater(myPlugin,((200L)-100L));
    }
    @Override
    public void onDisable() {
        //拜拜
        this.getLogger().info("[BetterLimit] 下次再见");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
