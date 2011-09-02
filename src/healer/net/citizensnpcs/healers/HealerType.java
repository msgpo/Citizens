package net.citizensnpcs.healers;

import net.citizensnpcs.commands.CommandHandler;
import net.citizensnpcs.healers.listeners.HealerCitizensListen;
import net.citizensnpcs.healers.listeners.HealerNPCListen;
import net.citizensnpcs.npctypes.CitizensNPC;
import net.citizensnpcs.npctypes.CitizensNPCType;
import net.citizensnpcs.npctypes.NPCTypeManager;
import net.citizensnpcs.properties.Properties;

import org.bukkit.event.Event.Type;

public class HealerType extends CitizensNPCType {

	@Override
	public Properties getProperties() {
		return HealerProperties.INSTANCE;
	}

	@Override
	public CommandHandler getCommands() {
		return HealerCommands.INSTANCE;
	}

	@Override
	public void registerEvents() {
		NPCTypeManager.registerEvent(Type.CUSTOM_EVENT,
				new HealerCitizensListen());
		NPCTypeManager.registerEvent(Type.CUSTOM_EVENT, new HealerNPCListen());
	}

	@Override
	public String getName() {
		return "healer";
	}

	@Override
	public CitizensNPC getInstance() {
		return new Healer();
	}
}