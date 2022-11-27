package lineage.world.object.item.potion;

import lineage.network.packet.BasePacketPooling;
import lineage.network.packet.ClientBasePacket;
import lineage.network.packet.server.S_ObjectEffect;
import lineage.world.controller.BuffController;
import lineage.world.object.Character;
import lineage.world.object.instance.ItemInstance;
import lineage.world.object.magic.CursePoison;
import lineage.world.object.magic.monster.CurseGhoul;

public class CurePoisonPotion extends ItemInstance {

	static public ItemInstance clone(ItemInstance item){
		if(item == null)
			item = new CurePoisonPotion();
		return item;
	}
	
	@Override
	public void toClick(Character cha, ClientBasePacket cbp){
		if( !isClick(cha) )
			return;
		
		// 이팩트 표현
		cha.toSender(S_ObjectEffect.clone(BasePacketPooling.getPool(S_ObjectEffect.class), cha, getItem().getEffect()), true);
		// 버프제거
		BuffController.remove(cha, CursePoison.class);
		BuffController.remove(cha, CurseGhoul.class);
		// 아이템 수량 갱신
		cha.getInventory().count(this, getCount()-1, true);
	}
}
