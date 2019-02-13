package net.kaikk.mc.betterkits.sponge;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;

public class EventListener {
	private BetterKits instance;
	
	public EventListener(BetterKits instance) {
		this.instance = instance;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Listener
	public void onInventoryClick(ClickInventoryEvent event) {
		if (event.getTargetInventory().getName().equals("BetterKits")) {
			event.setCancelled(true);
		}
	}
	
	@Listener
	public void onPlayerJoin(ClientConnectionEvent.Join event) {
		
		event.getTargetEntity().getUniqueId();
	}
}
