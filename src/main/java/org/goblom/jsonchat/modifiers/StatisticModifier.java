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

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.goblom.jsonchat.ChatModifier;

/**
 *
 * @author Goblom
 */
public class StatisticModifier extends ChatModifier {

    private static final String PREFIX = "statistic:";
    private final Statistic stat;
    
    public StatisticModifier(Plugin plugin, Statistic stat) {
        super(plugin, PREFIX + stat.name(), "Displays the " + stat.name() + " statistic");
        
        this.stat = stat;
    }

    @Override
    public String onModify(Player sender) {
        try {
            return String.valueOf(sender.getStatistic(stat));
        } catch (Exception e) { }
        return "Unknown";
    }
    
}
