package me.lojosho.hibiscuscommons.nms.v26_1_R1.packets.wrapper;

import me.lojosho.hibiscuscommons.packets.PacketType;
import me.lojosho.hibiscuscommons.packets.wrapper.PacketWrapper;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class EntityMoveWrapper implements PacketWrapper {

    private final int entityId;
    private final @NotNull Location from;
    private final @NotNull Location to;
    private final boolean onGround;

    public EntityMoveWrapper(int entityId, @NotNull Location from, @NotNull Location to, boolean onGround) {
        this.entityId = entityId;
        this.from = from;
        this.to = to;
        this.onGround = onGround;
    }

    @Override
    public PacketType getType() {
        return PacketType.ENTITY_MOVE;
    }

    @Override
    public Object toNativePacket() {
        short dx = (short) (Math.round(to.getX() * 4096) - Math.round(from.getX() * 4096));
        short dy = (short) (Math.round(to.getY() * 4096) - Math.round(from.getY() * 4096));
        short dz = (short) (Math.round(to.getZ() * 4096) - Math.round(from.getZ() * 4096));

        return new ClientboundMoveEntityPacket.Pos(entityId, dx, dy, dz, onGround);
    }
}
