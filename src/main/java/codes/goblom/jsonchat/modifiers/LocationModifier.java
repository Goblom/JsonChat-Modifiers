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

package codes.goblom.jsonchat.modifiers;

import org.bukkit.entity.Player;
import codes.goblom.jsonchat.ChatModifier;
import codes.goblom.jsonchat.ChatModifiers;

/**
 *
 * @author Goblom
 */
public class LocationModifier extends ChatModifier {

    public LocationModifier(ChatModifiers plugin, String lookFor) {
        super(plugin, lookFor, "Display the location of the player");
    }

    @Override
    public String modify(Player sender) {
        String world = sender.getLocation().getWorld().getName();
        int x = sender.getLocation().getBlockX();
        int y = sender.getLocation().getBlockY();
        int z = sender.getLocation().getBlockZ();
        
        return world + " " + x + " " + y + " " + z;
    }
    
}
