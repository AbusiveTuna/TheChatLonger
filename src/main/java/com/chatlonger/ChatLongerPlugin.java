package com.chatlonger;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@PluginDescriptor(
	name = "Chat Longer. It longifies your chat!"
)
public class ChatLongerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ChatLongerConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onChatMessage(ChatMessage message)
	{
		try(FileWriter fw = new FileWriter("C:\\YOURFILEHERE\\myfile.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{

			out.println(message.getSender() + ": " + message.getMessage());
		} catch (IOException e) {
			//exception handling left as an exercise for the reader
		}

	}

	@Provides
	ChatLongerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatLongerConfig.class);
	}
}
