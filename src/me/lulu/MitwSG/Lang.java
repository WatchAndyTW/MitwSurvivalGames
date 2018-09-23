package me.lulu.MitwSG;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.lulu.MitwSG.options.Options;

public class Lang {
	public static Lang ins;
	public static String prefix = Options.colored("&7[&6&lMitw&f&lSG&7]&f ");
	public static String Title = "&6&lMitw&f&lSG";
	public static String deathMatchTitle = "&c&lThe Final";
	public static ArrayList<String> watingList = new ArrayList<>();
	public static ArrayList<String> startingList = new ArrayList<>();
	public static ArrayList<String> gamingList = new ArrayList<>();
	public static ArrayList<String> finishList = new ArrayList<>();
	public static ArrayList<String> dmStartList = new ArrayList<>();
	public static ArrayList<String> dmList = new ArrayList<>();
	public static ItemStack specTp, playAnotherGame, returnToLobby, iVoteMap, RandomMap, arrowTrails;
	public static String outArena;
	public static String cantStart;
	public static String needDeathMatch;
	public static String lobbyCount, startCount, gameCount, deathMatchStartCount, allStrikeLightCount;
	public static String youKills1, youGotKillByS1, s1Death;
	public static String pplJoin, pplLeave;
	public static String gameStarted, allLightStart;
	public static String serverName,bungeeBroadCastCmd;
	public static ArrayList<String> victoryMsg = new ArrayList<>();
	public static ArrayList<String> infoMessage = new ArrayList<>();

	public Lang() {
		ins = this;
		setupList();
		setupString();
		setupItems();
	}

	public void setupString() {
		outArena = Options.colored(prefix + "&c&l�A�w�g�W�X&f&l���a����d��!!&c&l�л��֦^���a!!!");
		cantStart = Options.colored(prefix + "&c�C���H�Ƥ����y���L�k�}�l");
		needDeathMatch = Options.colored(prefix + "&c&l�ѩ�H�ƳѤU&f&l4�H!&c&l�]���[�ֹC���t��!&f&l2������K�n&c&l���`����!");
		gameStarted = Options.colored(prefix + "&f&l�C���}�l�F,���֦U��&6&l�n�B");
		allLightStart = Options.colored(prefix + "&f&l�{�b�}�l�A���ަb���̳��|����&6&l�ˮ`!&f&l�л����������!");

		lobbyCount = Options.colored(prefix + "&f�Y�N�b&a <time> &f����ǰe���a");
		startCount = Options.colored(prefix + "&6�C���Y�N�b&f <time> &6��}�l");
		gameCount = Options.colored(prefix + "&c���`���ԭ˼�&f <time>");
		deathMatchStartCount = Options.colored(prefix + "&c���a�Y�N�b <time> ��������");
		allStrikeLightCount = Options.colored(prefix + "&c&l�����^�O�Ҧ��Y�N�b &f&l<time> &c&l����}�l");

		youGotKillByS1 = Options.colored(prefix + "&f�A�Q&c <player> &f�H&b <heart>&c\u2764 &f�t�Z�����F");
		youKills1 = Options.colored(prefix + "&f�A�����F&6 <player>!");
		s1Death = Options.colored(prefix + "&c<player> &f���`�F!�C���ٳѤU&6 <size> &f�H�s��!");

		pplJoin = Options.colored(prefix + "&6<player> &f�[�J�F&6Mitw&eSG &7(<now>/&c24&7)");
		pplLeave = Options.colored(prefix + "&6<player> &7���}�F�C�� &7(<now>/&c24&7)");

	}

	public void setupItems() {
		specTp = Main.getIb().itemWithName(Material.SLIME_BALL, "&6�H���ǰe&7(Random Teleport)");
		playAnotherGame = Main.getIb().itemWithName(Material.PAPER, "&a&l�A���@��&7(Play Again)");
		returnToLobby = Main.getIb().itemWithName(Material.BED, "&b�^��j�U&7(Return to Lobby)");
		iVoteMap = Main.getIb().itemWithName(Material.PAPER, Options.colored("&6&l�벼&f&l�a��"));
		arrowTrails = Main.getIb().itemWithName(Material.CHEST, Options.colored("&f&l���&e&l�b�گS��"));
		RandomMap = Main.getIb().createRandomMap(Material.SIGN, "&e�H�t&7(Random Map)");

	}

	public void setupList() {
		watingList.add("&7&m---------------------------");
		watingList.add("&f�H��: &6<players>");
		watingList.add("&f�벼�Y�N�b &6<starting>&f ���ᤤ��!");
		watingList.add("");
		watingList.add("&f���A�����y: &6<server>");
		watingList.add("");
		watingList.add("&6&lMitw.Rip");
		watingList.add("&7&m---------------------------");

		startingList.add("&7&m---------------------------");
		startingList.add("&f�H��: &6<players>");
		startingList.add("&f�C���N�b &6<starting>&f ����}�l!");
		startingList.add("");
		startingList.add("&f���A�����y: &6<server>");
		startingList.add("");
		startingList.add("&6&lMitw.Rip");
		startingList.add("&7&m---------------------------");

		gamingList.add("&7&m---------------------------");
		gamingList.add("&f�ɶ��ѤU:&6 <time>");
		gamingList.add("&f�a��:&6 <arena>");
		gamingList.add("&f�H��:&6 <players>/<max>");
		gamingList.add("&f������:&6 <kills>");
		gamingList.add("");
		gamingList.add("&f���A�����y: &6<server>");
		gamingList.add("");
		gamingList.add("&6&lMitw.Rip");
		gamingList.add("&7&m---------------------------");

		finishList.add("&7&m---------------------------");
		finishList.add("&a&l�C������!");
		finishList.add("&6&l���� <player> ��o�ӧQ");
		finishList.add(" ");
		finishList.add("&6&lMitw.Rip");
		finishList.add("&7&m---------------------------");

		victoryMsg.add("��6��m--------------------------");
		victoryMsg.add("");
		victoryMsg.add(Options.colored("��f��l����&6&l <player> &f&l��o�ӧQ"));
		victoryMsg.add("");
		victoryMsg.add("��6��m--------------------------");

		dmStartList.add("&7&m---------------------------");
		dmStartList.add("&f�s�����a: &c<players>");
		dmStartList.add("&f���`���ԱN�b &c<starting>&f ����}�l!");
		dmStartList.add("");
		dmStartList.add("&f���A�����y: &c<server>");
		dmStartList.add("");
		dmStartList.add("&6&lMitw.Rip");
		dmStartList.add("&7&m---------------------------");

		dmList.add("&7&m---------------------------");
		dmList.add("&f�����^�O:&c <time>");
		dmList.add("&f�a��:&c <arena>");
		dmList.add("&f�s�����a:&c <players>/<max>");
		dmList.add("&f������:&c <kills>");
		dmList.add("");
		dmList.add("&f���A�����y: &c<server>");
		dmList.add("");
		dmList.add("&6&lMitw.Rip");
		dmList.add("&7&m---------------------------");

		infoMessage.add(Options.colored("&f&m-----------------------------"));
		infoMessage.add(Options.colored("              &6&l�w��Ө�MitwSG"));
		infoMessage.add(Options.colored("           &f�ɧA�ү઺�m��̦h�c�l"));
		infoMessage.add(Options.colored("&f�i�H����,���ը����K���a��j�M&e�����c"));
		infoMessage.add(Options.colored("              &c&l�åB�H�ɪ`�N����"));
		infoMessage.add(Options.colored("                &a&l�ؼ���o�ӧQ!"));
		infoMessage.add(Options.colored("&f&m-----------------------------"));
	}

}