/*
 * Copyright (C) 2014 Goblom
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.goblom.jsonchat;

import org.bukkit.Statistic;
import org.bukkit.plugin.java.JavaPlugin;
import org.goblom.jsonchat.exceptions.InvalidModifierException;
import org.goblom.jsonchat.modifiers.*;

/**
 *
 * @author Goblom
 */
public class ChatModifiers extends JavaPlugin {
    
    @Override
    public void onEnable() {
        saveDefaultConfig();
        
        if (isEnabled("Health")) {
            register(new HealthModifier(this, "health"));
            register(new HealthModifier(this, "hp"));
        }
        
        if (isEnabled("Location")) {
            register(new LocationModifier(this, "location"));
            register(new LocationModifier(this, "loc"));
        }
        
        if (isEnabled("XP")) {
            register(new XpModifier(this));
        }
        
        if (isEnabled("Level")) {
            register(new LevelModifier(this, "level"));
            register(new LevelModifier(this, "lvl"));
        }
        
        if (isEnabled("Food")) {
            register(new FoodModifier(this));
        }
        
        if (isEnabled("Balance") && getServer().getPluginManager().getPlugin("Vault") != null) {
            BalanceModifier.load();
            register(new BalanceModifier(this, "balance"));
            register(new BalanceModifier(this, "bal"));
            register(new BalanceModifier(this, "money"));
        }
        
        if (isEnabled("Statistic")) {
            for (Statistic stat : Statistic.values()) {
                register(new StatisticModifier(this, stat));
            }
        }
    }
    
    private boolean isEnabled(String mod) {
        String path = "Modifiers." + mod;
        
        if (!getConfig().contains(path)) {
            getConfig().set(path, true);
            saveConfig();
        }
        
        return getConfig().getBoolean(path);
    }
    
    private void register(ChatModifier mod) {
        try {
            JSONChat.registerModifier(mod);
        } catch (InvalidModifierException e) {
            e.printStackTrace();
        }
    }
}
