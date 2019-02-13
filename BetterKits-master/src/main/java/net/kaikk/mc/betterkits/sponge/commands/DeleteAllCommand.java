package net.kaikk.mc.betterkits.sponge.commands;

import java.util.UUID;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import net.kaikk.mc.betterkits.sponge.BetterKits;
import net.kaikk.mc.betterkits.sponge.Kit;
import net.kaikk.mc.betterkits.sponge.Messages;
import net.kaikk.mc.betterkits.sponge.PlayerData;

public class DeleteAllCommand implements CommandExecutor {
	private BetterKits instance;
	public DeleteAllCommand(BetterKits instance) {
		this.instance = instance;
	}
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final String kitName = args.<String>getOne("kit").get();

		final Kit kit = instance.getKit(kitName);
		if (kit == null) {
			src.sendMessage(Messages.get("KitNotFound"));
			return CommandResult.empty();
		}
		
		for(String stringuuid : instance.getUuidList()) {
			
			UUID uuid = UUID.fromString(stringuuid);
			
			PlayerData pd = instance.getPlayersData().get(uuid);
			if (pd == null) {
				pd = new PlayerData(uuid);
				instance.getPlayersData().put(uuid, pd);
			}
			
			int amount = args.<Integer>getOne("amount").isPresent() ? args.<Integer>getOne("amount").get() : 1;
			
			Integer current = pd.getPendingKits().get(kit.getName());
			if (current == null) {
				current = 0;
			}
			if(current - amount < 0) {
				amount = 0;
			} else {
				amount = amount-current;
			}
			pd.getPendingKits().put(kit.getName(), amount);
			
			try {
				instance.saveData();
			} catch (Exception e) {
				src.sendMessage(Text.of(TextColors.RED, "An error occurred while saving data."));
				e.printStackTrace();
			}
			
			
		}
			return CommandResult.success();
	}
}
