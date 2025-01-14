/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.playerscouter;

import java.util.LinkedHashMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.runelite.api.Player;
import net.runelite.http.api.hiscore.HiscoreResult;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@ToString(exclude = "player")
class PlayerContainer
{
	private HiscoreResult skills;
	private LinkedHashMap<Integer, Integer> gear;
	private LinkedHashMap<Integer, Integer> riskedGear;
	private LinkedHashMap<Integer, Integer> gearValue;
	private Player player;
	private String location;
	private String name;
	private String targetString;
	private boolean httpRetry;
	private boolean scouted;
	private int prayer;
	private int totalGear;
	private int risk;
	private int scoutTimer;
	private int weapon;
	private int wildyLevel;

	PlayerContainer(Player player)
	{
		this.gear = new LinkedHashMap<>();
		this.httpRetry = false;
		this.location = "N/A";
		this.name = player.getName();
		this.player = player;
		this.prayer = -1;
		this.totalGear = 0;
		this.gearValue = new LinkedHashMap<>();
		this.risk = 0;
		this.riskedGear = new LinkedHashMap<>();
		this.scoutTimer = 500;
		this.scouted = false;
		this.skills = null;
		this.targetString = "";
		this.weapon = 0;
		this.wildyLevel = 0;
	}
}