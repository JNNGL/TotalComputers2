/*
   Computers in vanilla Minecraft
   Copyright (C) 2022  JNNGL

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.jnngl.totalcomputers2;

import com.jnngl.totalcomputers2.commands.TotalComputers2;
import com.jnngl.totalcomputers2.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public class Plugin extends JavaPlugin {

   private final Config config = new Config(this, "/config.yml").load();

   public Plugin() throws IOException {}

   @Override
   public void onEnable() {
      Objects.requireNonNull(this.getCommand("totalcomputers2")).setExecutor(new TotalComputers2());
   }

   @Override
   public void onDisable() {

   }

}
