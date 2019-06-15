/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.ticktimers;

import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;

class NPCContainer
{
	@Getter
	private NPC npc;
	@Getter
	private int npcIndex;
	@Getter
	private String npcName;
	@Getter
	private int npcSize;
	@Setter
	@Getter
	private int TicksUntilAttack;
	@Setter
	@Getter
	private int npcSpeed;
	@Setter
	@Getter
	private Actor npcInteracting;
	@Setter
	@Getter
	private Attackstyle attackStyle;

	NPCContainer(NPC npc)
	{
		this.npc = npc;
		this.npcName = npc.getName();
		this.npcIndex = npc.getIndex();
		this.npcInteracting = npc.getInteracting();
		this.npcSpeed = 0;
		this.attackStyle = Attackstyle.UNKNOWN;
		this.TicksUntilAttack = 0;
		final NPCDefinition composition = npc.getTransformedDefinition();

		if (composition != null)
		{
			this.npcSize = composition.getSize();
		}
	}


	@AllArgsConstructor
	@Getter
	public enum Attackstyle
	{
		MAGE("Mage", Color.CYAN),
		RANGE("Range", Color.GREEN),
		MELEE("Melee", Color.RED),
		UNKNOWN("Unknown", Color.WHITE);

		private String name = "";
		private Color color;
	}
}