package net.kaikk.mc.betterkits.sponge;

import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;

public class UuidSerializer implements TypeSerializer<List<String>>{

	@SuppressWarnings("serial")
	final public static TypeToken<List<String>> token = new TypeToken<List<String>>() {};

	@Override
	public List<String> deserialize( TypeToken<?> type, ConfigurationNode node) throws ObjectMappingException {

		List<String> uuidList = new ArrayList<String>();
		for(String s : node.getNode("uuidList").getList(TypeToken.of(String.class))) {
			uuidList.add(s);
		}
		
		return uuidList;
	}

	@Override
	public void serialize( TypeToken<?> type, List<String> uuidList,  ConfigurationNode node) throws ObjectMappingException {

		node.getNode("uuidList").setValue(uuidList);
	}

	
}
