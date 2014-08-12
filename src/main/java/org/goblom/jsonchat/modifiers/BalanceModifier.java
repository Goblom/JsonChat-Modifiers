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

package org.goblom.jsonchat.modifiers;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.goblom.jsonchat.ChatModifier;

/**
 *
 * @author Goblom
 */
public class BalanceModifier extends ChatModifier{
    private static Economy econ;
    
    public static void load() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) return;
        
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return;
        
        BalanceModifier.econ = rsp.getProvider();
    }

    
    public BalanceModifier(Plugin plugin, String lookFor) {
        super(plugin, lookFor, "Display the balance of the player");
    }

    @Override
    public String onModify(Player sender) {
        if (econ == null) {
            return "0.00";
        }
        try {
            return String.valueOf(econ.getBalance(sender));
        } catch (Exception e) {}
        return "0.00";
    }
    
}
