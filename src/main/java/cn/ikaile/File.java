package cn.ikaile;

import org.bukkit.configuration.file.YamlConfiguration;

import static cn.ikaile.BetterLimit.*;

public class File {
    public void getConfig(){
        //config
        config=myPlugin.getConfig();
        myPlugin.saveDefaultConfig();
        limitTotal = (int) config.get("limit.value");
        myPlugin.getLogger().info("[BetterLimit] 读取配置文件 \n[BetterLimit] 限制获得金币:" + limitTotal);
    }

}
