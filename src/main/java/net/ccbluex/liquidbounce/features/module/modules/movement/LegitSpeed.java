package net.ccbluex.liquidbounce.features.module.modules.movement;

import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.JumpEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.ccbluex.liquidbounce.value.FloatValue;
import net.minecraft.potion.Potion;

@ModuleInfo(name = "LegitSpeed", description = "Allows you to move faster.", category = ModuleCategory.MOVEMENT)
public class LegitSpeed extends Module {
    public final FloatValue Boost = new FloatValue("Boost", 0.03F, 0F, 0.1F);
    public final FloatValue Boost1 = new FloatValue("Boost1", 0.14F, 0F, 0.2F);
    public final FloatValue Boost2 = new FloatValue("Boost2", 0.17F, 0F, 0.3F);

    @EventTarget
    public void onJump(JumpEvent event) {
        if (mc.thePlayer != null || MovementUtils.isMoving()) {
            float boost;
            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() != 1) {
                boost = (Boost.getValue());
                mc.thePlayer.motionX *= (1.0f + (float)BaseSpeed() * boost);
                mc.thePlayer.motionZ *= (1.0f + (float)BaseSpeed() * boost);
            }
            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() != 2) {
                boost = (Boost1.getValue());
                mc.thePlayer.motionX *= (1.0f + (float)BaseSpeed() * boost);
                mc.thePlayer.motionZ *= (1.0f + (float)BaseSpeed() * boost);
            }
            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() != 3) {
                boost = (Boost2.getValue());
                mc.thePlayer.motionX *= (1.0f + (float)BaseSpeed() * boost);
                mc.thePlayer.motionZ *= (1.0f + (float)BaseSpeed() * boost);
            }
        }
    }
    public int BaseSpeed() {
        if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
            return mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1;
        }
        return 0;
    }
}
