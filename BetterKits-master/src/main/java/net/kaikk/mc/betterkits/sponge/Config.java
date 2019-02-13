package net.kaikk.mc.betterkits.sponge;

import java.net.URL;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;

import com.google.common.reflect.TypeToken;

import net.kaikk.mc.betterkits.common.CommonUtils;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.yaml.YAMLConfigurationLoader;

public class Config {
	public Set<BlockType> allowedChests = new HashSet<BlockType>();
	public String starterKitName;
	
	public Config(BetterKits instance) throws Exception {
		
		this.staterKitName = "stater";
		
	}
}

