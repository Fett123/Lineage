//sp
package lineage.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lineage.bean.database.Npc;
import lineage.plugin.Plugin;
import lineage.plugin.PluginController;
import lineage.share.TimeLine;
import lineage.thread.AiThread;
import lineage.world.object.object;
import lineage.world.object.instance.NpcInstance;
import lineage.world.object.npc.ClanMaker;
import lineage.world.object.npc.Doett;
import lineage.world.object.npc.Ellyonne;
import lineage.world.object.npc.GoddessAgata;
import lineage.world.object.npc.Hurin;
import lineage.world.object.npc.Maid;
import lineage.world.object.npc.Morien;
import lineage.world.object.npc.Sedia;
import lineage.world.object.npc.Siris;
import lineage.world.object.npc.TalkMovingNpc;
import lineage.world.object.npc.TalkNpc;
import lineage.world.object.npc.Theodor;
import lineage.world.object.npc.buff.ArmorEnchanter;
import lineage.world.object.npc.buff.Curer;
import lineage.world.object.npc.buff.Hadesty;
import lineage.world.object.npc.buff.Haste;
import lineage.world.object.npc.buff.PolymorphMagician;
import lineage.world.object.npc.buff.TownEnchanter;
import lineage.world.object.npc.buff.WeaponEnchanter;
import lineage.world.object.npc.craft.Anton;
import lineage.world.object.npc.craft.Arachne;
import lineage.world.object.npc.craft.Detecter;
//import lineage.world.object.npc.craft.DioCraft;
import lineage.world.object.npc.craft.Ent;
import lineage.world.object.npc.craft.Est;
import lineage.world.object.npc.craft.Eveurol;
import lineage.world.object.npc.craft.Fairy;
import lineage.world.object.npc.craft.FairyQueen;
import lineage.world.object.npc.craft.Farlin;
import lineage.world.object.npc.craft.Hector;
import lineage.world.object.npc.craft.Herbert;
import lineage.world.object.npc.craft.Ivelviin;
import lineage.world.object.npc.craft.Joel;
import lineage.world.object.npc.craft.Julie;
import lineage.world.object.npc.craft.Ladar;
import lineage.world.object.npc.craft.Lien;
import lineage.world.object.npc.craft.Luudiel;
import lineage.world.object.npc.craft.Moria;
import lineage.world.object.npc.craft.Narhen;
import lineage.world.object.npc.craft.Nerupa;
import lineage.world.object.npc.craft.Pan;
import lineage.world.object.npc.craft.Pierce;
import lineage.world.object.npc.craft.Pin;
import lineage.world.object.npc.craft.Reona;
import lineage.world.object.npc.craft.Sarsha;
import lineage.world.object.npc.craft.Vincent;
import lineage.world.object.npc.dwarf.Axellon;
import lineage.world.object.npc.dwarf.Bahof;
import lineage.world.object.npc.dwarf.Borgin;
import lineage.world.object.npc.dwarf.Dorin;
import lineage.world.object.npc.dwarf.El;
import lineage.world.object.npc.dwarf.Gotham;
import lineage.world.object.npc.dwarf.Haidrim;
import lineage.world.object.npc.dwarf.Hakim;
import lineage.world.object.npc.dwarf.Hirim;
import lineage.world.object.npc.dwarf.Jianku;
import lineage.world.object.npc.dwarf.Juke;
import lineage.world.object.npc.dwarf.Kamu;
import lineage.world.object.npc.dwarf.Karim;
import lineage.world.object.npc.dwarf.Karudim;
import lineage.world.object.npc.dwarf.Kasham;
import lineage.world.object.npc.dwarf.Kriom;
import lineage.world.object.npc.dwarf.Kuhatin;
import lineage.world.object.npc.dwarf.Kuron;
import lineage.world.object.npc.dwarf.Kusian;
import lineage.world.object.npc.dwarf.Nodim;
import lineage.world.object.npc.dwarf.Rayearth;
import lineage.world.object.npc.dwarf.Sauram;
import lineage.world.object.npc.dwarf.Tarkin;
import lineage.world.object.npc.dwarf.Thram;
import lineage.world.object.npc.dwarf.Tigus;
import lineage.world.object.npc.dwarf.Timpukin;
import lineage.world.object.npc.dwarf.Tofen;
import lineage.world.object.npc.dwarf.Tulak;
import lineage.world.object.npc.guard.PatrolGuard;
import lineage.world.object.npc.guard.SentryGuard;
import lineage.world.object.npc.inn.Elly;
import lineage.world.object.npc.inn.Enke;
import lineage.world.object.npc.inn.Lolia;
import lineage.world.object.npc.inn.Miranda;
import lineage.world.object.npc.inn.Molly;
import lineage.world.object.npc.inn.Sabin;
import lineage.world.object.npc.inn.Selena;
import lineage.world.object.npc.inn.Velisa;
import lineage.world.object.npc.kingdom.Hunt;
import lineage.world.object.npc.kingdom.Ishmael;
import lineage.world.object.npc.kingdom.Orville;
import lineage.world.object.npc.kingdom.Othmond;
import lineage.world.object.npc.kingdom.Potempin;
import lineage.world.object.npc.kingdom.SeghemAtuba;
import lineage.world.object.npc.pet.Almon;
import lineage.world.object.npc.pet.Cove;
import lineage.world.object.npc.pet.Dick;
import lineage.world.object.npc.pet.Hans;
import lineage.world.object.npc.pet.Johnson;
import lineage.world.object.npc.pet.Kevin;
import lineage.world.object.npc.pet.Marbin;
import lineage.world.object.npc.pet.Mild;
import lineage.world.object.npc.pet.Pau;
import lineage.world.object.npc.quest.Aanon;
import lineage.world.object.npc.quest.AdminNovice;
import lineage.world.object.npc.quest.Aria;
import lineage.world.object.npc.quest.Dilong;
import lineage.world.object.npc.quest.FairyPrincess;
import lineage.world.object.npc.quest.Gatekeeper;
import lineage.world.object.npc.quest.GatekeeperAnt;
import lineage.world.object.npc.quest.Gerard;
import lineage.world.object.npc.quest.Gereng;
import lineage.world.object.npc.quest.Gunter;
import lineage.world.object.npc.quest.Heit;
import lineage.world.object.npc.quest.Jem;
import lineage.world.object.npc.quest.Jim;
import lineage.world.object.npc.quest.Kan;
import lineage.world.object.npc.quest.Lekman;
import lineage.world.object.npc.quest.Lyra;
import lineage.world.object.npc.quest.Mack;
import lineage.world.object.npc.quest.Mark;
import lineage.world.object.npc.quest.Marshall;
import lineage.world.object.npc.quest.Oth;
import lineage.world.object.npc.quest.Richard;
import lineage.world.object.npc.quest.Ricky;
import lineage.world.object.npc.quest.Ronde;
import lineage.world.object.npc.quest.Ruba;
import lineage.world.object.npc.quest.SearchAnt;
import lineage.world.object.npc.quest.Serian;
import lineage.world.object.npc.quest.Talass;
import lineage.world.object.npc.quest.Tio;
import lineage.world.object.npc.quest.Zero;
import lineage.world.object.npc.shop.Aaman;
import lineage.world.object.npc.shop.Andyn;
import lineage.world.object.npc.shop.Ashur;
import lineage.world.object.npc.shop.Balshim;
import lineage.world.object.npc.shop.Berry;
import lineage.world.object.npc.shop.Bius;
import lineage.world.object.npc.shop.Britt;
import lineage.world.object.npc.shop.BuyShop;
import lineage.world.object.npc.shop.Catty;
import lineage.world.object.npc.shop.Chiky;
import lineage.world.object.npc.shop.Cold;
import lineage.world.object.npc.shop.Derek;
import lineage.world.object.npc.shop.Dico;
import lineage.world.object.npc.shop.Dio;
import lineage.world.object.npc.shop.Elmina;
import lineage.world.object.npc.shop.Evert;
import lineage.world.object.npc.shop.Franko;
import lineage.world.object.npc.shop.Fraoun;
import lineage.world.object.npc.shop.Glen;
import lineage.world.object.npc.shop.Gora;
import lineage.world.object.npc.shop.HarborMaster;
import lineage.world.object.npc.shop.Illusina;
import lineage.world.object.npc.shop.Isvall;
import lineage.world.object.npc.shop.Izawa;
import lineage.world.object.npc.shop.JackLantern;
import lineage.world.object.npc.shop.Jackson;
import lineage.world.object.npc.shop.Jason;
import lineage.world.object.npc.shop.Jode;
import lineage.world.object.npc.shop.Kreister;
import lineage.world.object.npc.shop.Luth;
import lineage.world.object.npc.shop.Maeno;
import lineage.world.object.npc.shop.Mandra;
import lineage.world.object.npc.shop.Mayer;
import lineage.world.object.npc.shop.Margaret;
import lineage.world.object.npc.shop.Philip;
import lineage.world.object.npc.shop.Melissa;
import lineage.world.object.npc.shop.Mellin;
import lineage.world.object.npc.shop.OrcSanta;
import lineage.world.object.npc.shop.Orim;
import lineage.world.object.npc.shop.Pagoru;
import lineage.world.object.npc.shop.Pandora;
import lineage.world.object.npc.shop.Premium;
import lineage.world.object.npc.shop.Ralf;
import lineage.world.object.npc.shop.Randal;
import lineage.world.object.npc.shop.Raon;
import lineage.world.object.npc.shop.Rinda;
import lineage.world.object.npc.shop.Rose;
import lineage.world.object.npc.shop.SellShop;
import lineage.world.object.npc.shop.Shivan;
import lineage.world.object.npc.shop.Squalid;
import lineage.world.object.npc.shop.Tilon;
import lineage.world.object.npc.shop.Tina;
import lineage.world.object.npc.shop.Varyeth;
import lineage.world.object.npc.shop.Vergil;
import lineage.world.object.npc.shop.Verita;
import lineage.world.object.npc.shop.Werner;
import lineage.world.object.npc.shop.Ysorya;
import lineage.world.object.npc.teleporter.Amisoo;
import lineage.world.object.npc.teleporter.Ants;
import lineage.world.object.npc.teleporter.Barnia;
import lineage.world.object.npc.teleporter.Brad;
import lineage.world.object.npc.teleporter.Coco;
import lineage.world.object.npc.teleporter.ColiseumManager;
import lineage.world.object.npc.teleporter.Cspace;
import lineage.world.object.npc.teleporter.Deanos;
import lineage.world.object.npc.teleporter.Drist;
import lineage.world.object.npc.teleporter.Duvall;
import lineage.world.object.npc.teleporter.Edlin;
import lineage.world.object.npc.teleporter.Elleris;
import lineage.world.object.npc.teleporter.Entgate;
import lineage.world.object.npc.teleporter.Enya;
import lineage.world.object.npc.teleporter.Dwell;
import lineage.world.object.npc.teleporter.Escapefi;
import lineage.world.object.npc.teleporter.Esmereld;
import lineage.world.object.npc.teleporter.FieldOfHonor;
import lineage.world.object.npc.teleporter.FirstTeleporter;
import lineage.world.object.npc.teleporter.Illdrath;
import lineage.world.object.npc.teleporter.Ishtar;
import lineage.world.object.npc.teleporter.Karen;
import lineage.world.object.npc.teleporter.Kirius;
import lineage.world.object.npc.teleporter.Kiyari;
import lineage.world.object.npc.teleporter.Kun;
import lineage.world.object.npc.teleporter.Leslie;
import lineage.world.object.npc.teleporter.Lucas;
import lineage.world.object.npc.teleporter.Luck;
import lineage.world.object.npc.teleporter.Mammon;
import lineage.world.object.npc.teleporter.MarketGuard;
import lineage.world.object.npc.teleporter.MarketTeleporter;
import lineage.world.object.npc.teleporter.Matt;
import lineage.world.object.npc.teleporter.Merlin;
import lineage.world.object.npc.teleporter.Ober;
import lineage.world.object.npc.teleporter.OrcfbuWoo;
import lineage.world.object.npc.teleporter.Ribian;
import lineage.world.object.npc.teleporter.Riol;
import lineage.world.object.npc.teleporter.Sirius;
import lineage.world.object.npc.teleporter.Sky;
import lineage.world.object.npc.teleporter.Stanley;
import lineage.world.object.npc.teleporter.Stevie;
import lineage.world.object.npc.teleporter.Telefire;
import lineage.world.object.npc.teleporter.Trey;
import lineage.world.object.npc.teleporter.Wilma;
import lineage.world.object.npc.teleporter.Zeno;

public final class NpcSpawnlistDatabase {

	static private List<object> pool;

	static public void init(Connection con){
		TimeLine.start("NpcSpawnlistDatabase..");

		pool = new ArrayList<object>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM npc_spawnlist");
			rs = st.executeQuery();
			while(rs.next())
				toSpawnNpc(rs.getString("name"), rs.getString("npcName"), rs.getString("title"), rs.getInt("locX"), rs.getInt("locY"), rs.getInt("locMap"), rs.getInt("heading"), rs.getInt("respawn"));

		} catch (Exception e) {
			lineage.share.System.printf("%s : init(Connection con)\r\n", NpcSpawnlistDatabase.class.toString());
			lineage.share.System.println(e);
		} finally {
			DatabaseConnection.close(st, rs);
		}

		TimeLine.end();
	}

	/**
	 * ???????????? ?????????.
	 * @param npc
	 * @param title
	 * @param x
	 * @param y
	 * @param map
	 * @param heading
	 * @param respawn
	 */
	static public void toSpawnNpc(String key, String npc, String title, int x, int y, int map, int heading, int respawn){
		Npc n = NpcDatabase.find(npc);
		if(n!=null){
			object o = newObject(n, newObject(n));
			o.setDatabaseKey(key);
			o.setTitle( title );
			o.setHomeX( x );
			o.setHomeY( y );
			o.setHomeMap( map );
			o.setHomeHeading( heading );
			o.setHeading( heading );
			o.setReSpawnTime( respawn );
			o.toTeleport(o.getHomeX(), o.getHomeY(), o.getHomeMap(), false);
			if(n.isAi())
				AiThread.append(o);
		}
	}

	static public object newObject(Npc n, object o){
		if(n==null || o==null)
			return null;

		o.setObjectId( ServerDatabase.nextEtcObjId() );
		o.setName( n.getNameId() );
		o.setGfx( n.getGfx() );
		o.setGfxMode( n.getGfxMode() );
		o.setMaxHp(n.getHp()==0 ? 1 : n.getHp());
		o.setNowHp(n.getHp()==0 ? 1 : n.getHp());
		o.setLawful( n.getLawful() );
		o.setClassGfx( o.getGfx() );
		o.setClassGfxMode( o.getGfxMode() );
		o.setLight( n.getLight() );

		return o;
	}

	static public object newObject(Npc n){
		// ???????????? ??????.
		Plugin p = PluginController.find(NpcSpawnlistDatabase.class);
		if(p != null){
			object o = ((lineage.plugin.bean.NpcSpawnlistDatabase)p).newObject(n);
			if(o != null)
				return o;
		}

		switch(n.getNameIdNumber()){
		case 240:		// ?????? ?????? ?????????
		case 58240:		// ????????? ?????????
		case 360240:	// ?????? ?????????
		case 951240:	// ???????????? ?????????
		case 1513240:	// ????????? ?????????
		case 1242240:	// ?????? ?????????
			return new SentryGuard(n);
		case 269:	// ?????????
			return new Pandora(n);
		case 270:	// ??????
			return new Gunter(n);
		case 304:	// ??????
			return new Balshim(n);
		case 309:	// ??????
			return new Dorin(n);
		case 320:	// ????????? ?????????
			return new HarborMaster(n);
		case 332:	// ??????
			return new Catty(n);
		case 333:	// 
			return new Luth(n);
		case 334:	// ??????
			return new Karim(n);
		case 365:	// ??????
			return new Aaman(n);
		case 373:	// ??????
			return new Gora(n);
		case 374:	// ??????
			return new Gereng(n);
		case 406:	// ??????
			return new Orim(n);
		case 432:	// ????????????
			return new Ishmael(n);
		case 445:	// ??????
			return new Hunt(n);
		case 446:	// ?????????
			return new TalkMovingNpc(n, "ashton1");
		case 447:	// ??????
			return new TalkMovingNpc(n, "dunkan1");
		case 448:	// ??????
			return new TalkMovingNpc(n, "moor1");
		case 449:	// ??????
			return new TalkMovingNpc(n, "cana1");
		case 450:	// ?????????
			return new Lolia(n);
		case 451:	// ?????????
			return new TalkMovingNpc(n, "farbo1");
		case 453:	// ??????
			return new TalkMovingNpc(n, "rjyta1");
		case 454:	// ??????
			return new TalkMovingNpc(n, "lengo1");
		case 455:	// ???
			return new TalkMovingNpc(n, "fiin1");
		case 456:	// ?????????
			return new TalkMovingNpc(n, "judice1");
		case 458:	// ??????
			return new Andyn(n);
		case 459:	// ????????????
			return new Ysorya(n);
		case 468:	// ?????????
			return new Bahof(n);
		case 474:	// ?????????
			return new Gatekeeper(n);
		case 478:	// ??????
			return new TalkNpc("touma1", false);
		case 479:	// ????????????
			return new TalkMovingNpc(n, "woodford1");
		case 480:	// ??????
			return new TalkMovingNpc(n, "ofo1");
		case 481:	// ??????
			return new TalkMovingNpc(n, "rohan1");
		case 483:	// ??????
			return new TalkMovingNpc(n, "tommy1");
		case 484:	// ?????????
			return new Lyra(n);
		case 485:	// ?????????
			return new TalkMovingNpc(n, "sanita1");
		case 486:	// ??????
			return new TalkMovingNpc(n, "ellne1");
		case 487:	// ??????
			return new TalkMovingNpc(n, "hanna1");
		case 488:	// ?????? ?????????
			return new SeghemAtuba(n);
		case 568:	// ??????
			return new Thram(n);
		case 614:	// ??????
			return new Johnson(n);
		case 615:	// ???
			return new Dick(n);
		case 737:	// ???
			return new TalkMovingNpc(n, "bob1");
		case 738:	// ??????
			return new TalkMovingNpc(n, "ruka1");
		case 749:	// ?????????
			return new Nerupa(n);
		case 750:	// ???
			return new El(n);
		case 752:	// ????????????
			return new Arachne(n);
		case 753:	// ???
			return new Pan(n);
		case 754:	// ?????????
			return new Fairy(n);
		case 755:	// ??????
			return new Ent(n);
		case 805:	// ????????? ???
			return new FairyQueen(n);
		case 811:	// ?????????
			return new Narhen(n);
		case 812:	// ?????????
			return new Doett(n);
		case 813:	// ????????????
			return new Hurin(n);
		case 820:	// ?????????
			return new Morien(n);
		case 821:	// ????????????
			return new Theodor(n);
		case 826:	// ??????
			return new TalkMovingNpc(n, "laban1");
		case 829:	// ?????????
			return new Lucas(n);
		case 830:	// ?????????
			return new Stevie(n);
		case 831:	// ?????????
			return new Stanley(n);
		case 838:	// ??????
			return new Philip(n);
		case 846:	// ??????
			return new Hector(n);
		case 848:	// ?????????
			return new Vincent(n);
		case 849:	// ?????????
			return new Evert(n);
		case 854:	// ??????
			return new Maeno(n);
		case 855:	// ?????????
			return new Jason(n);
		case 857:	// ??????
			return new Randal(n);
		case 858:	// ??????
			return new Izawa(n);
		case 859:	// ?????? ??????
			return new Dio(n);
		case 860:	// ??????
			return new Anton(n);
		case 861:	// ??????
			return new Derek(n);
		case 862:	// ??????
			return new TalkMovingNpc(n, "mona1");
		case 865:	// ?????????
			return new Moria(n);
		case 866:	// ?????????
			return new Margaret(n);			
		case 870:	// ??????
			return new TalkMovingNpc(n, "jenny1");
		case 872:	// ?????????
			return new TalkMovingNpc(n, "alice1");
		case 873:	// ?????????
			return new TalkMovingNpc(n, "evelyn1");
		case 874:	// ?????????
			return new TalkMovingNpc(n, "tovia1");
		case 875:	// ??????
			return new TalkMovingNpc(n, "leal1");
		case 876:	// ??????
			return new TalkMovingNpc(n, "alda1");
		case 878:	// ??????
			return new TalkMovingNpc(n, "lina1");
		case 880:	// ?????????
			return new TalkMovingNpc(n, "daisy1");
		case 881:	// ?????????
			return new TalkMovingNpc(n, "bridget1");
		case 882:	// ??????
			return new TalkMovingNpc(n, "tanya1");
		case 883:	// ?????????
			return new TalkMovingNpc(n, "daria1");
		case 884:	// ?????????
			return new TalkMovingNpc(n, "doris1");
		case 885:	// ????????????
			return new TalkMovingNpc(n, "tracy1");
		case 891:	// ?????????
			return new Verita(n);
		case 909:	// ?????????
			return new TalkMovingNpc(n, "brunner1");
		case 910:	// ?????????
			return new Elmina(n);
		case 911:	// ??????
			return new Marbin(n);
		case 912:	// ?????????
			return new Velisa(n);
		case 914:	// ?????????
			return new Gerard(n);
		case 915:	// ??????
			return new Glen(n);
		case 916:	// ??????
			return new Mellin(n);
		case 917:	// ??????
			return new Aanon(n);
		case 918:	// ?????????.
			return new Miranda(n);
		case 921:	// ????????????
			return new Othmond(n);
		case 927:	// ??????
			return new TalkMovingNpc(n, "pig1");
		case 928:	// ??????
			return new TalkMovingNpc(n, "hen1");
		case 929:	// ??????
			return new TalkMovingNpc(n, "milkcow1");
		case 934:	// ?????????
			return new TalkMovingNpc(n, "anotte1");
		case 946:	// ?????????
			return new Trey(n);
		case 947:	// ??????
			return new Matt(n);
		case 948:	// ?????????
			return new Tarkin(n);
		case 949:	// ??????
			return new Gotham(n);
		case 950:	// ??????
			return new Borgin(n);
		case 955:	// ?????????
			return new Selena(n);
		case 963:	// ??????
			return new Hans(n);
		case 964:	// ??????
			return new Jackson(n);
		case 965:	// ?????????
			return new Ashur(n);
		case 1053:	// ?????????
			return new Ladar(n);
		case 1054:	// ??????
			return new Farlin(n);
		case 1055:  // ?????????
			return new Lien(n);
		case 1056:	// ??????
			return new Julie(n);
		case 1057:	// ???
			return new Pin(n);
		case 1058:	// ??????
			return new Joel(n);
		case 1068:	// ?????????
		case 1069:	// ?????????
		case 1070:	// ????????? ??? ??????
		case 1071:	// ???
		case 1072:	// ??????
			return new Telefire(n);
		case 1073:	// ?????????
			return new Kuhatin(n);
		case 1145:	// ?????????
			return new Est(n);
		case 1177:	// ?????????
			return new PatrolGuard(n);
		case 1238:	// ??????
			return new Orville(n);
		case 1246:	// ?????????
			return new Herbert(n);
		case 1248:	// ?????????
			return new Sauram(n);
		case 1249:	// ??????
			return new Nodim(n);
		case 1250:	// ??????
			return new Molly(n);
		case 1259:	// ??????
			return new TalkMovingNpc(n, "malcom1");
		case 1260:	// ?????????
			return new TalkMovingNpc(n, "damon1");
		case 1261:	// ????????????
			return new TalkMovingNpc(n, "tyrus1");
		case 1262:	// ??????
			return new TalkMovingNpc(n, "sherwin1");
		case 1263:	// ??????
			return new TalkMovingNpc(n, "moran1");
		case 1264:	// ???????????????
			return new TalkMovingNpc(n, "ferdinand1");
		case 1265:	// ?????????
			return new TalkMovingNpc(n, "giles1");
		case 1266:	// ????????????
			return new TalkMovingNpc(n, "aldred1");
		case 1267:	// ?????????
			return new TalkMovingNpc(n, "gulian1");
		case 1268:	// ?????????
			return new TalkMovingNpc(n, "manus1");
		case 1269:	// ?????????
			return new TalkMovingNpc(n, "pierre1");
		case 1271:	// ?????????
			return new TalkMovingNpc(n, "oliver1");
		case 1272:	// ????????????
			return new TalkMovingNpc(n, "ernest1");
		case 1286:	// ??????
			return new Werner(n);
		case 1295:	// ??????
			return new Vergil(n);
		case 1298:	// ??????
			return new Kevin(n);
		case 1299:	// ??????
			return new Almon(n);
		case 1301:	// ?????????
			return new Mayer(n);
			
			
			
			
		case 1536:	// ??????
			return new Dwell(n);
		case 1354:	// ??????
			return new Wilma(n);
		case 1380:	// ??????
			return new Tofen(n);
		case 1382:	// ???????????????
			return new TalkNpc("auction1", true);
		case 1396:	// ????????? ???
			return new TalkMovingNpc(n, "paperman");
		case 1415:	// ?????????
			return new Curer();
		case 1416:	// ?????????
			return new Siris();
		case 1417:	// ?????????
			return new Ishtar(n);
		case 1418:	// ??????
			return new Zeno(n);
		case 1420:	// ?????????
			return new Fraoun(n);
		case 1422:	// ????????????
			return new Illdrath(n);
		case 1423:	// ????????????
			return new Drist(n);
		case 1488:	// ?????????
			return new Eveurol(n);
		case 1500:	// ????????? ?????????
			return new FieldOfHonor(n);
		case 1510:	// ?????????
			return new Luudiel(n);
		case 1501:	// ??????
			return new TalkNpc("goodman", false);
		case 1502:	// ????????????
			return new TalkNpc("neutralman", false);
		case 1503:	// ?????????
			return new TalkNpc("evilman", false);
		case 1515:	// ??????
			return new Shivan(n);
		case 1516:	// ?????????
			return new Britt(n);
		case 1517:	// ??????
			return new Riol(n);
		case 1518:	// ??????
			return new TalkMovingNpc(n, "derick1");
		case 1524:	// ?????????
			return new TalkMovingNpc(n, "arina1");
		case 1525:	// ?????????
			return new TalkMovingNpc(n, "annabel1");
		case 1526:	// ?????????
			return new TalkMovingNpc(n, "felix1");
		case 1527:	// ?????????
			return new TalkMovingNpc(n, "oriel1");
		case 1528:	// ?????????
			return new TalkMovingNpc(n, "barent1");
		case 1529:	// ??????
			return new TalkMovingNpc(n, "paults1");
		case 1530:	// ?????????
			return new TalkMovingNpc(n, "spencer1");
		case 1531:	// ??????
			return new TalkMovingNpc(n, "gale1");
		case 1538:	// ??????
			return new Hakim(n);
		case 1539:	// ??????
			return new Elly(n);
		case 1551:	// ????????????
			return new Haidrim(n);
		case 1557:	// ??????
			return new TalkMovingNpc(n, "sasha");
		case 1578:	// ?????? ??????
			return new OrcSanta(n);
		case 1591:	// ?????????
			return new Potempin(n);
		case 1592:	// ?????????
			return new Ivelviin(n);
		case 1594:	// ??????
			return new Berry(n);
		case 1595:	// ??????
			return new Ralf(n);
		case 1596:	// ?????????
			return new Leslie(n);
		case 1597:	// ??????
			return new Cove(n);
		case 1598:	// ??????
			return new TalkMovingNpc(n, "gavin1");
		case 1599:	// ?????????
			return new TalkMovingNpc(n, "daley1");
		case 1600:	// ?????????
			return new TalkMovingNpc(n, "atara1");
		case 1604:	// ?????????
			return new Axellon(n);
		case 1609:	// ???????????? ?????????
		case 1902:	// ???????????? ????????????
			return new ColiseumManager(n);
		case 1611:	// ?????????
			return new Kriom(n);
		case 1637:	// ??????
			return new Cold(n);
		case 1643:	// ??????
			return new Rose(n);
		case 1644:	// ??????
			return new Tina(n);
		case 1653:	// ???????????????
			return new Esmereld(n);
		case 1674:	// ?????? ?????????
			return new GoddessAgata();
		case 1684:	// ????????????
			return new PolymorphMagician();
		case 1685:	// ????????? ?????????
			return new ArmorEnchanter();
		case 1686:	// ?????? ?????????
			return new WeaponEnchanter();
		case 9158:	// ?????????
			return new TownEnchanter();
		case 1724:	// ??????
			return new TalkNpc("rion1", false);
		case 1725:	// ??????
			return new TalkNpc("cuse1", false);
		case 1728:	// ??????
			return new Ruba(n);
		case 1729:
			return new Tio(n);
		case 1730:	// ???
			return new Kun(n);
		case 1731:	// ?????????
			return new Kiyari(n);
		case 1737:	// ??????
			return new Coco(n);
		case 1738:	// ?????????
			return new Sky(n);
		case 1772:	// ?????????
			return new Mild(n);
		case 1773:	// ????????????
			return new Kirius(n);
		case 1775:	// ?????????
			return new Bius(n);
		case 1776:	// ?????????
			return new Mandra(n);
		case 1777:	// ?????????
			return new TalkMovingNpc(n, "derian1");
		case 1778:	// ?????????
			return new Talass(n);
		case 1779:	// ????????????
			return new Varyeth(n);
		case 1780:	// ?????????
			return new Ellyonne();
		case 1781:	// ????????????
			return new Kreister(n);
		case 1792:	// ??????
			return new TalkMovingNpc(n, "bion1");
		case 1793:	// ??????
			return new TalkMovingNpc(n, "dima1");
		case 1794:	// ??????
			return new TalkMovingNpc(n, "ruru1");
		case 1795:	// ??????
			return new TalkMovingNpc(n, "dekan1");
		case 1796:	// ?????????
			return new TalkMovingNpc(n, "rotus1");
		case 1797:	// ?????????
			return new TalkMovingNpc(n, "garuga1");
		case 1823:	// ?????????
			return new TalkNpc("defuri", false);
		case 1824:	// ?????????
			return new TalkNpc("tifany", false);
		case 1825:	// ??????
			return new TalkNpc("roku", false);
		case 1826:	// ?????????
			return new TalkNpc("taus", true);
		case 1827:	// ??????
			return new TalkNpc("biyan", true);
		case 1828:	// ??????
			return new Enke(n);
		case 1875:	// ??????
			return new Rinda(n);
		case 1876:	// ?????????
			return new Pagoru(n);
		case 1877:	// ??????
			return new Dico(n);
		case 1878:	// ??????
			return new Hirim(n);
		case 1897:	// ????????????
			return new Barnia(n);
		case 1898:	// ?????????
			return new Ribian(n);
		case 1925:	// ??????
			return new Ricky(n);
		case 1926:	// ??????
			return new Oth(n);
		case 1927:	// ??????
			return new Zero(n);
		case 1928:	// ???
			return new Jem(n);
		case 1931:	// ????????? - ????????? ????????? ?????????
			return new Isvall(n);
		case 1932:	// ????????????
			return new Escapefi(n);
		case 1953:	// ?????????
			return new Detecter(n);
		case 1954:	// ??????
			return new Chiky(n);
		case 1955:	// ??????
			return new Luck(n);
		case 1956:	// ??????
			return new Tilon(n);
		case 2002:	// ????????????
			return new Illusina(n);
		case 2012:	// ??????
			return new Mark(n);
		case 2013:	// ???
			return new Jim(n);
		case 2098:	// ?????? ????????????
			return new FirstTeleporter(n);
		case 2014:	// ????????????
			return new SearchAnt();
		case 2015:	// ???????????????
			return new GatekeeperAnt();
		case 2016:	// ?????????
			return new Aria(n);
		case 2018:	// ????????? ????????????
			return new FairyPrincess(n);
		case 2019:	// ??????
			return new Dilong(n);
		case 2021:	// ??????
			return new Marshall(n);
		case 2082:	// ???-???-??????
			return new JackLantern(n);
		case 2122:	// ??????
			return new Raon(n);
		case 2123:	// ??????
			return new Pau(n);
		case 2124:	// ??????
			return new Kamu(n);
		case 2126:	// ????????????
			return new Sirius(n);
		case 2135:	// ?????????
			return new TalkMovingNpc(n, "mikey1");
		case 2138:	// ????????????
			return new TalkMovingNpc(n, "elleano1");
		case 2141:	// ?????????
			return new TalkMovingNpc(n, "maren1");
		case 2143:	// ?????????
			return new TalkMovingNpc(n, "sheryan1");
		case 2144:	// ?????????
			return new TalkMovingNpc(n, "buckley1");
		case 2145:	// ??????
			return new TalkMovingNpc(n, "jones1");
		case 2146:	// ???
			return new TalkMovingNpc(n, "bim1");
		case 2150:	// ??????
			return new TalkMovingNpc(n, "marx1");
		case 2151:	// ?????????
			return new TalkMovingNpc(n, "rapael1");
		case 2152:	// ?????????
			return new TalkNpc("babara1", true);
		case 2153:	// ?????????
			return new TalkNpc("kidman1", true);
		case 2154:	// ??????
			return new TalkNpc("aquin1", true);
		case 2157:	// ??????
			return new TalkMovingNpc(n, "calvin1");
		case 2160:	// ?????????
			return new Richard();
		case 2161:	// ???
			return new Mack(n);
		case 2163:	// ??????
			return new Sabin(n);
		case 2166:	// ?????????
			return new Brad(n);
		case 2228:	// ?????????
			return new Karudim(n);
		case 2229:	// ??????
			return new Juke(n);
		case 2230:	// ?????????
			return new Timpukin(n);
		case 2234:	// ????????????
			return new Elleris(n);
		case 2237:	// ?????????
			return new Melissa(n);
		case 2238:	// ???????????????
			return new ClanMaker();
		case 2257:	// ?????????
			return new TalkMovingNpc(n, "searcherk4");
		case 2258:	// ?????????
			return new Heit(n);
		case 2343:	// ???????????????
			return new Haste();
		case 2430:	// ?????? ??????
			return new Kan(n);
		case 2432:	// ??????
			return new Ronde(n);
		case 2448:	// ??????
			return new TalkMovingNpc(n, "haro1");
		case 2491:	// ????????????
			return new Hadesty();
		case 2492:	// ????????????
			return new Rayearth(n);
		case 2493:	// ??????????????? ??????
			return new Enya(n);
		case 2494:	// ????????????
			return new Squalid(n);
		case 2496:	// ??????
			return new Karen(n);
		case 2497:	// ?????????
			return new Edlin(n);
		case 2498:	// ?????? ?????????
			return new TalkNpc("kandum", false);
		case 2501:	// ????????? ?????????
			return new TalkNpc("rondedum", false);
		case 2550:	// ??????
			return new TalkMovingNpc(n, "derin1");
		case 2552:	// ?????????
			return new Sedia();
		case 2554:	// ?????????
			return new TalkMovingNpc(n, "pierot1"); 
		case 2556:	// ??????
			return new TalkMovingNpc(n, "bishop1");
		case 2557:	// ?????????
			return new Pierce(n);
		case 2558:	// ????????????
			return new TalkMovingNpc(n, "grandik1");
		case 2560:	// ????????????
			return new TalkMovingNpc(n, "ellvienue1");
		case 2561:	// ?????????
			return new TalkMovingNpc(n, "lamune1");
		case 2586:	// ????????????
			return new Deanos(n);
		case 2860:	// ??????
			return new Jode(n);
		case 2929:	// ?????????
			return new Franko(n);
		case 2934:	// ??????
			return new TalkMovingNpc(n, "citizen1");
		case 2935:	// ??????
			return new TalkMovingNpc(n, "citizen2");
		case 2936:	// ?????????
			return new TalkMovingNpc(n, "citizen3");
		case 2938:	// ?????????
			return new TalkMovingNpc(n, "citizen5");
		case 2941:	// ?????????
			return new TalkMovingNpc(n, "citizen8");
		case 2942:	// ?????????
			return new TalkMovingNpc(n, "citizen9");
		case 2943:	// ?????????
			return new TalkMovingNpc(n, "citizen10");
		case 2986:	// ?????????
			return new Sarsha(n);
		case 3053:	// ?????? ????????????
			return new MarketTeleporter(n);
		case 3054:	// ?????? ?????????
			return new MarketGuard(n);
		case 3055:	// ??????
			return new Jianku(n);
		case 3070:	// ??????
			return new Kuron(n);
		case 3071:	// ??????
			return new Tulak(n);
		case 3072:	// ??????
			return new Kusian(n);
		case 3135:	// ?????????
			return new Reona(n);
		case 3161:	// ??????
			return new TalkMovingNpc(n, "redin1");
		case 3164:	// ??????
			return new TalkMovingNpc(n, "burns1");
		case 3170:	// ?????????
			return new TalkMovingNpc(n, "yastin1");
		case 3224:	// ??????
			return new Kasham(n);
		case 3316:	// ?????????
			return new Lekman(n);
		case 3317:	// ?????????
			return new Serian(n);
		case 3427:	// ?????????
			return new Ober(n);
		case 3436:	// ??????
			return new Duvall(n);
		case 3449:	// ?????????
			return new TalkMovingNpc(n, "arka1");
		case 3526:	// ??????
			return new Tigus(n);
		case 3531:	// ?????????
			return new TalkMovingNpc(n, "kamit1");
		case 3561:	// ?????????
			return new TalkMovingNpc(n, "rudian1a");
		case 3563:	// ?????????
			return new Tigus(n);
		case 3594:	// ??????
			return new TalkMovingNpc(n, "rooney");
		case 3595:	// ????????????
			return new TalkMovingNpc(n, "roberto");
		case 3596:	// ?????????
			return new TalkMovingNpc(n, "lupus");
		case 3597:	// ??????
			return new TalkMovingNpc(n, "karu");
		case 3947:	// ????????? ????????????
			return new Entgate(n);
		case 4641:	// ????????? ???
			return new Cspace(n);
		case 4656:	// ???????????? ??????
			return new OrcfbuWoo(n);
		case 4809:	// ????????? ??????
			return new Mammon(n);
		case 4850:	// ???????????? ?????????
			return new Amisoo(n);
		case 5201:	// ??????
			return new TalkNpc("kuen1", false);
		case 5290:	// ?????????
			return new TalkMovingNpc(n, "aurora1");
		case 5291:	// ??????
			return new TalkMovingNpc(n, "becky1");
		case 5293:	// ?????????
			return new TalkMovingNpc(n, "chase1");
		case 5294:	// ?????????
			return new TalkMovingNpc(n, "jericho1");
		case 5138:	// ????????? ?????? ??????
		case 5324:	// ????????? ?????????
		case 5742:	// ????????? ????????????
		case 5743:	// ????????? ?????? ??????
		case 5744:	// ????????? ?????? ??????
			return new Premium(n);
		case 8447: // ????????? ?????????
			return new AdminNovice(n);
		case 7441: // ????????? ??????
			return new Merlin(n);
		case 14291: // ????????????
			return new Ants(n);
		default:
			switch (n.getGfx()) {
			case 1256: // ????????? ??????
				return new Maid();
			default:
				if(n.isAi()){
					return new NpcInstance(n);
				}else{
					if(n.getType().equalsIgnoreCase("buy shop")){
						return new BuyShop(n);
					}else if(n.getType().equalsIgnoreCase("sell shop")){
						return new SellShop(n);
					}else{
						return new object();
					}
				}
			}
		}
	}

	static public object getPool(Class<?> c){
		object r_o = null;
		for(object o : pool){
			if(o.getClass().equals(c)){
				r_o = o;
				break;
			}
		}
		if(r_o != null)
			pool.remove(r_o);

		//		lineage.share.System.println(NpcSpawnlistDatabase.class.toString()+" : pool.remove("+pool.size()+")");
		return r_o;
	}

	static public void setPool(NpcInstance ni){
		ni.close();
		pool.add(ni);

		//		lineage.share.System.println(NpcSpawnlistDatabase.class.toString()+" : pool.add("+pool.size()+")");
	}

	static public int getPoolSize(){
		return pool.size();
	}

	static public int selectCount(Connection con){
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT COUNT(*) FROM npc_spawnlist");
			rs = st.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			lineage.share.System.printf("%s : selectCount(Connection con)\r\n", NpcSpawnlistDatabase.class.toString());
			lineage.share.System.println(e);
		} finally {
			DatabaseConnection.close(st, rs);
		}
		return 0;
	}

	static public void insert(
			Connection con, final String name, final String npcName, final int locX, final int locY, final int locMap, 
			final int heading, final int respawn, final String title
			){
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("INSERT INTO npc_spawnlist SET name=?, npcName=?, locX=?, locY=?, locMap=?, heading=?, respawn=?, title=?");
			st.setString(1, name);
			st.setString(2, npcName);
			st.setInt(3, locX);
			st.setInt(4, locY);
			st.setInt(5, locMap);
			st.setInt(6, heading);
			st.setInt(7, respawn);
			st.setString(8, title);
			st.executeUpdate();
		} catch (Exception e) {
			lineage.share.System.printf("%s : insert()\r\n", NpcSpawnlistDatabase.class.toString());
			lineage.share.System.println(e);
		} finally {
			DatabaseConnection.close(st);
		}
	}
}
