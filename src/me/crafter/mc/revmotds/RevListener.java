package me.crafter.mc.revmotds;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.v1_6_R2.EntityPlayer;
import net.minecraft.server.v1_6_R2.Packet206SetScoreboardObjective;
import net.minecraft.server.v1_6_R2.Packet207SetScoreboardScore;
import net.minecraft.server.v1_6_R2.Packet208SetScoreboardDisplayObjective;
import net.minecraft.server.v1_6_R2.Scoreboard;
import net.minecraft.server.v1_6_R2.ScoreboardBaseCriteria;
import net.minecraft.server.v1_6_R2.ScoreboardScore;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;

public class RevListener implements Listener {
	//initiate the scoreboard to sb and make the toggle to on
	public Scoreboard sb;
	public boolean on = true;
	public String name;
	//constructer
	public RevListener(){
		sb = makeScoreboard();
	}
	//toggle function
	public void toggle(boolean set){
		if (set==true) {
			on=true;
		}
		else if (set==false) {
			on=false;
		}
	}
	//Player Join Event
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		if (!on) return;
		Player p = event.getPlayer();
		
	}
	
	public void sendHeader(Player p){
		Packet206SetScoreboardObjective head = new Packet206SetScoreboardObjective(sb.getObjective(name), 0);
		Packet208SetScoreboardDisplayObjective pos = new Packet208SetScoreboardDisplayObjective(1, sb.getObjective(name));
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(head);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(pos);
	}
	
	
	public Scoreboard makeScoreboard(){
		name = ChatColor.translateAlternateColorCodes("&".charAt(0) , name);
		Scoreboard sb = new Scoreboard();
		sb.registerObjective(name, new ScoreboardBaseCriteria(name));
		return sb;
	}
	
	
	
	int getPing(Player p) { CraftPlayer cp = (CraftPlayer) p; EntityPlayer ep = cp.getHandle(); return (int)ep.ping; }

//	public void onPlayerJoin(final PlayerJoinEvent event){
//	
//	final BukkitTask thetask = Bukkit.getServer().getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("RevMotd") , new Runnable() {
//		public void run(){
//			int hisping = getPing(event.getPlayer());
//			int onlineNumber = Bukkit.getOnlinePlayers().length;
//			int todaycount = (int)(event.getPlayer().getWorld().getFullTime()/24000L);
//			sendscoreboard3(event.getPlayer(),"&6Welcome to Rev","&a延迟",hisping,"&b在线玩家数量",onlineNumber,"&5游戏日",todaycount);
//		}
//
//	}, 20L, 20L);
//	
//	Bukkit.getServer().getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("RevMotd") , new Runnable() {
//		public void run(){
//			thetask.cancel();
//		}
//	}, 600L);
//	
//			
//}	
	
//	public void sendscoreboard1(final Player player, String name, String s1, Integer i1){
//		name = ChatColor.translateAlternateColorCodes("&".charAt(0) , name);
//		s1 = ChatColor.translateAlternateColorCodes("&".charAt(0) , s1);
//	    Scoreboard sb = new Scoreboard();
//	    sb.registerObjective(name, new ScoreboardBaseCriteria(name));
//	    final Packet206SetScoreboardObjective removePacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 1);
//	    Packet206SetScoreboardObjective createPacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 0);
//	    Packet208SetScoreboardDisplayObjective display = new Packet208SetScoreboardDisplayObjective(1, sb.getObjective(name));
//
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(createPacket);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(display);
//        ScoreboardScore scoreItem1 = new ScoreboardScore(sb, sb.getObjective(name), s1);
//        scoreItem1.setScore(i1);
//        Packet207SetScoreboardScore pScoreItem1 = new Packet207SetScoreboardScore(scoreItem1, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem1);
//	}
//	
//	
//	
//	public void sendscoreboard2(final Player player, String name, String s1, Integer i1, String s2, Integer i2){
//		name = ChatColor.translateAlternateColorCodes("&".charAt(0) , name);
//		s1 = ChatColor.translateAlternateColorCodes("&".charAt(0) , s1);
//		s2 = ChatColor.translateAlternateColorCodes("&".charAt(0) , s2);
//	    Scoreboard sb = new Scoreboard();
//	    sb.registerObjective(name, new ScoreboardBaseCriteria(name));
//	    final Packet206SetScoreboardObjective removePacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 1);
//	    Packet206SetScoreboardObjective createPacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 0);
//	    Packet208SetScoreboardDisplayObjective display = new Packet208SetScoreboardDisplayObjective(1, sb.getObjective(name));
//
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(createPacket);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(display);
//        ScoreboardScore scoreItem1 = new ScoreboardScore(sb, sb.getObjective(name), s1);
//        scoreItem1.setScore(i1);
//        Packet207SetScoreboardScore pScoreItem1 = new Packet207SetScoreboardScore(scoreItem1, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem1);
//        ScoreboardScore scoreItem2 = new ScoreboardScore(sb, sb.getObjective(name), s2);
//        scoreItem2.setScore(i2);
//        Packet207SetScoreboardScore pScoreItem2 = new Packet207SetScoreboardScore(scoreItem2, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem2);
//	}
//	
//	public void sendscoreboard3(final Player player, String name, String s1, Integer i1, String s2, Integer i2, String s3, Integer i3){
//		name = ChatColor.translateAlternateColorCodes("&".charAt(0) , name);
//		s1 = ChatColor.translateAlternateColorCodes("&".charAt(0) , s1);
//		s2 = ChatColor.translateAlternateColorCodes("&".charAt(0) , s2);
//		s3 = ChatColor.translateAlternateColorCodes("&".charAt(0) , s3);
//	    Scoreboard sb = new Scoreboard();
//	    sb.registerObjective(name, new ScoreboardBaseCriteria(name));
//	    final Packet206SetScoreboardObjective removePacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 1);
//	    Packet206SetScoreboardObjective createPacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 0);
//	    Packet208SetScoreboardDisplayObjective display = new Packet208SetScoreboardDisplayObjective(1, sb.getObjective(name));
//	    
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(createPacket);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(display);
//        ScoreboardScore scoreItem1 = new ScoreboardScore(sb, sb.getObjective(name), s1);
//        scoreItem1.setScore(i1);
//        Packet207SetScoreboardScore pScoreItem1 = new Packet207SetScoreboardScore(scoreItem1, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem1);
//        ScoreboardScore scoreItem2 = new ScoreboardScore(sb, sb.getObjective(name), s2);
//        scoreItem2.setScore(i2);
//        Packet207SetScoreboardScore pScoreItem2 = new Packet207SetScoreboardScore(scoreItem2, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem2);
//        ScoreboardScore scoreItem3 = new ScoreboardScore(sb, sb.getObjective(name), s3);
//        scoreItem3.setScore(i3);
//        Packet207SetScoreboardScore pScoreItem3 = new Packet207SetScoreboardScore(scoreItem3, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem3);
//	}
//	
//	
//	
//	
//	public void updatePlayer(Player player){
//		String name = "Stats";
//	    Scoreboard sb = new Scoreboard();
//	    sb.registerObjective(name, new ScoreboardBaseCriteria(name));
//	    Packet206SetScoreboardObjective createPacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 0);
//	    Packet208SetScoreboardDisplayObjective display = new Packet208SetScoreboardDisplayObjective(1, sb.getObjective(name));
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(createPacket);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(display);
//        ScoreboardScore scoreItem = new ScoreboardScore(sb, sb.getObjective(name), "thisisatest");
//        Packet207SetScoreboardScore pScoreItem = new Packet207SetScoreboardScore(scoreItem, 0);
//        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pScoreItem);
//	}

}
