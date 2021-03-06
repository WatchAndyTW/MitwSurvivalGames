package mitw.survivalgames.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

import mitw.survivalgames.GameStatus;
import mitw.survivalgames.SurvivalGames;
import mitw.survivalgames.manager.ArenaManager;
import mitw.survivalgames.manager.GameManager;
import mitw.survivalgames.manager.PlayerManager;
import mitw.survivalgames.tasks.LobbyTask;
import mitw.survivalgames.utils.Utils;

public class JoinQuitListener implements Listener {
	public boolean isCast = false;

	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		PlayerManager.createCache(p);
		e.setJoinMessage(null);
		switch (GameStatus.getState()) {
			case WAITING:
				PlayerManager.clearInventory(p);
				PlayerManager.tpToSpawn(p);
				PlayerManager.giveWaitingItem(p);
				p.setGameMode(GameMode.SURVIVAL);
				if (!isCast) {
					Bukkit.getScheduler().runTaskLater(SurvivalGames.getInstance(), () -> {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), SurvivalGames.getFileManager().getCsettings().getString("broadCastCommand"));
						isCast = true;
					}, 5);
				}
				if (GameManager.canStart() && !GameManager.starting) {
					GameManager.starting = true;
					Utils.playSoundAll(Sound.NOTE_PLING);
					new LobbyTask().runTaskTimer(SurvivalGames.getInstance(), 0, 20);
				}
				Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(SurvivalGames.getLanguage().translate(player, "pplJoin").replaceAll("<player>", p.getName()).replaceAll("<now>", String.valueOf(Bukkit.getOnlinePlayers().size()))));
				break;
			default:
				PlayerManager.setSpec(p);
				PlayerManager.randomTeleportPlayer(p);
				break;
		}
	}

	@EventHandler
	public void onLeave(final PlayerQuitEvent e) {
		e.setQuitMessage(null);
		final Player p = e.getPlayer();
		e.setQuitMessage(null);
		PlayerManager.saveCache(p.getUniqueId());
		switch (GameStatus.getState()) {
			case WAITING:
				PlayerManager.getPlayers().remove(p.getUniqueId());
				Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(SurvivalGames.getLanguage().translate(player, "pplLeave").replaceAll("<player>", p.getName()).replaceAll("<now>", String.valueOf(Bukkit.getOnlinePlayers().size() - 1))));
				if (ArenaManager.getVotes().containsKey(p.getUniqueId())) {
					ArenaManager.getVotes().remove(p.getUniqueId());
				}
				if (ArenaManager.getVoteRandom().contains(p.getUniqueId())) {
					ArenaManager.getVoteRandom().remove(p.getUniqueId());
				}
				if (Bukkit.getOnlinePlayers().size() - 1 <= 0F) {
					isCast = false;
				}
				PlayerManager.removeCache(p.getUniqueId());
				return;
			case GAMING:
				if (PlayerManager.isGameingPlayer(p)) {
					p.setHealth(0.0);
					PlayerManager.getPlayers().remove(p.getUniqueId());
					GameManager.checkWin();
				}
				break;
			case STARRTING:
				if (PlayerManager.isGameingPlayer(p)) {
					PlayerManager.getPlayers().remove(p.getUniqueId());
				}
				break;
			case DMSTARTING:
				if (PlayerManager.isGameingPlayer(p)) {
					p.setHealth(0.0);
					PlayerManager.getPlayers().remove(p.getUniqueId());
					GameManager.checkWin();
				}
			case DEATHMATCH:
				if (PlayerManager.isGameingPlayer(p)) {
					p.setHealth(0.0);
					PlayerManager.getPlayers().remove(p.getUniqueId());
					GameManager.checkWin();
				}
			default:
				break;
		}
	}

	@EventHandler
	public void onLogin(final PlayerLoginEvent e) {
		if (GameStatus.isWaiting() && GameManager.isFull()) {
			e.disallow(Result.KICK_WHITELIST, Utils.colored("&c遊戲滿人了!!"));
		} else if (GameStatus.isStarting()) {
			e.disallow(Result.KICK_WHITELIST, Utils.colored("&c遊戲正在傳送中,請稍等再加入觀戰"));
		} else if (GameStatus.isFinished()) {
			e.disallow(Result.KICK_WHITELIST, Utils.colored("&c遊戲結束了!等等再加入遊玩吧!"));
		}

	}

}