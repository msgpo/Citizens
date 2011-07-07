package com.citizens.npctypes.interfaces;

import org.bukkit.entity.Player;

import com.citizens.Permission;
import com.citizens.economy.EconomyHandler;
import com.citizens.economy.EconomyHandler.Operation;
import com.citizens.resources.npclib.HumanNPC;
import com.citizens.utils.MessageUtils;

public class OperationPurchaser implements NPCPurchaser {
	private Operation getOperation(String type) {
		return Operation.valueOf(type.toUpperCase() + "_CREATION");
	}

	@Override
	public boolean canBuy(Player player, String type) {
		return !EconomyHandler.useEconomy()
				|| EconomyHandler.canBuy(getOperation(type), player);
	}

	@Override
	public double pay(Player player, String type) {
		if (EconomyHandler.useEconomy()) {
			return EconomyHandler.pay(getOperation(type), player);
		}
		return 0;
	}

	@Override
	public String getPaidMessage(Player player, HumanNPC npc, double paid,
			String type) {
		if (EconomyHandler.useEconomy()) {
			return MessageUtils.getPaidMessage(getOperation(type), paid,
					npc.getName(), type, true);
		}
		return "";
	}

	@Override
	public String getNoMoneyMessage(Player player, HumanNPC npc, String type) {
		return MessageUtils.getNoMoneyMessage(getOperation(type), player);
	}

	@Override
	public boolean hasPermission(Player player, String type) {
		return Permission.canCreate(player, type);
	}

	@Override
	public String getNoPermissionsMessage(Player player, String type) {
		return MessageUtils.noPermissionsMessage;
	}
}