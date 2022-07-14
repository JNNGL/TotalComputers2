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

package com.jnngl.totalcomputers2.config;

import com.jnngl.totalcomputers2.Plugin;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Config {

   private final YamlConfiguration defaults;
   private final Plugin plugin;
   private final String name;
   private YamlConfiguration config;

   public Config(@NotNull Plugin plugin, @NotNull String name) throws IOException {
      this.plugin = plugin;
      this.name = name;

      try (InputStream inputStream = Config.class.getResourceAsStream(name)) {
         if (inputStream == null) {
            throw new IllegalStateException("Could not find defaults for " + name);
         }
         this.defaults = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
      }
   }

   public @NotNull Config load() {
      this.config = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), name));
      this.config.setDefaults(defaults);
      return this;
   }

   public @NotNull YamlConfiguration get() {
      return this.config;
   }

}
