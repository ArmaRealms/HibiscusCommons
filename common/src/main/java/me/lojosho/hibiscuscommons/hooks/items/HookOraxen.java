package me.lojosho.hibiscuscommons.hooks.items;

import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.items.ItemBuilder;
import me.lojosho.hibiscuscommons.hooks.Hook;
import me.lojosho.hibiscuscommons.hooks.HookFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * A hook that integrates the plugin {@link io.th0rgal.oraxen.OraxenPlugin OraxenPlugin} to provide custom items
 */
@SuppressWarnings("SpellCheckingInspection")
public class HookOraxen extends Hook {
    public HookOraxen() {
        super("oraxen", HookFlag.ITEM_SUPPORT);
        setActive(true);
    }

    /**
     * Gets a cosmetic {@link ItemStack} that is associated with the provided id from the plugin {@link io.th0rgal.oraxen.OraxenPlugin OraxenPlugin}
     */
    @Override
    public ItemStack getItem(@NotNull String itemId) {
        ItemBuilder builder = OraxenItems.getItemById(itemId);
        if (builder == null) return null;
        return builder.build();
    }

    @Override
    public String getItemString(ItemStack itemStack) {
        if (itemStack == null) return null;
        if (!itemStack.hasItemMeta()) return null;
        if (!OraxenItems.exists(itemStack)) return null;
        return OraxenItems.getIdByItem(itemStack);
    }
}
