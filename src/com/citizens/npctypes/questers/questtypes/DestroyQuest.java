package com.citizens.npctypes.questers.questtypes;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

import com.citizens.npctypes.questers.objectives.Objectives.ObjectiveCycler;
import com.citizens.npctypes.questers.quests.QuestIncrementer;
import com.citizens.resources.npclib.HumanNPC;

public class DestroyQuest extends QuestIncrementer {
	public DestroyQuest(HumanNPC npc, Player player, String questName,
			ObjectiveCycler objectives) {
		super(npc, player, questName, objectives);
	}

	@Override
	public void updateProgress(Event event) {
		if (event instanceof BlockBreakEvent) {
			BlockBreakEvent ev = (BlockBreakEvent) event;
			if (ev.getBlock().getType() == this.objective.getMaterial()) {
				this.getProgress().incrementCompleted(1);
			}
		}
	}

	@Override
	public boolean isCompleted() {
		return this.getProgress().getAmount() >= this.objective.getAmount();
	}
}