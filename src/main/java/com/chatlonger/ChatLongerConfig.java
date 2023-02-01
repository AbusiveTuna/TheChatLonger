package com.chatlonger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("chatlonger")
public interface ChatLongerConfig extends Config
{
	@ConfigItem(
		keyName = "",
		name = "",
		description = ""
	)
	default String greeting()
	{
		return "Hello";
	}
}
