package me.lulu.MitwSG.utils;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;

import me.lulu.MitwSG.Main;
import me.lulu.MitwSG.options.Options;

public class Arena {
	public ArrayList<Location> spawnPoints = new ArrayList<>();
	public ArrayList<Location> tir2Chests = new ArrayList<>();
	public ArrayList<Location> centerChests = new ArrayList<>();
	public Location center;
	private String name;
	private World world;

	public void setWorld(World w) {
		world = w;
	}

	public void setCenter(Location l) {
		center = l;
	}

	public Location getCenter() {
		return center;
	}

	public ArrayList<Location> getSpawnPoints() {
		return spawnPoints;
	}
	
	public ArrayList<Location> getTir2Chests() {
		return tir2Chests;
	}


	public World getWorld() {
		return world;
	}

	public String getName() {
		return name;
	}

	public void setName(String str) {
		name = str;
	}

	public void addSpawn(Location l) {
		spawnPoints.add(l);
	}

	public void addTir2(Location l) {
		tir2Chests.add(l);
	}

	public void addCenter(Location l) {
		centerChests.add(l);
	}

	public void saveSpawns() {
		ArrayList<String> temp = new ArrayList<>();
		for (Location l : spawnPoints)
			temp.add(Options.locToStrPitch(l));
		Main.getFlm().getClocation().set("Arenas." + name + ".spawnPoints", temp.toArray());
		Main.getFlm().saveLocationConfig();
	}

	public void saveCenter() {
		Main.getFlm().getClocation().set("Arenas." + name + ".center", Options.locToStr(center));
		Main.getFlm().saveLocationConfig();
	}

	public void saveTir2Chests() {
		Main.getFlm().getClocation().set("Arenas." + name + ".Tir2s", Options.locToStringList(tir2Chests).toArray());
		Main.getFlm().saveLocationConfig();
	}

	public void saveCenterChest() {
		Main.getFlm().getClocation().set("Arenas." + name + ".centerChest", Options.locToStringList(centerChests).toArray());
		Main.getFlm().saveLocationConfig();
	}

}