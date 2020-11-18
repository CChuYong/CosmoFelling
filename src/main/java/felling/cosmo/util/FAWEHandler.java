package felling.cosmo.util;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.transform.Transform;
import com.sk89q.worldedit.world.World;
import felling.cosmo.CosmoFelling;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;

public class FAWEHandler {
    public static boolean pasteSchematic(String schematicName, Location loc, boolean noAir) {
        World weWorld = new BukkitWorld(loc.getWorld());

        File file = new File(CosmoFelling.INSTANCE.getDataFolder() + File.separator + "schematics" + File.separator + schematicName + ".schematic");
        if (file.exists() == false) {
            return false;
        }
        Vector vec = new Vector(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        BlockVector3 alpha = BlockVector3.at(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        try {
            EditSession editSession = ClipboardFormats.findByFile(file)
                    .load(file)
                    .paste(weWorld, alpha, false, !noAir, null);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
