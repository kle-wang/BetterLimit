package cn.ikaile;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;
import java.util.HashMap;

import static cn.ikaile.BetterLimit.*;

public class Runnable extends BukkitRunnable {
    @Override
    public void run() {
       if(calendar.get(Calendar.DAY_OF_MONTH) != day){
           playerMoneyHashMap = new HashMap<>();
           day = calendar.get(Calendar.DAY_OF_MONTH);
       }
    }
}
