package com.upc.EasyProduction.blocks;

public class PutBearing {
	final private String defaultCode = "\n"
			+ "    def PUT_BEARING_MATRIZ_ASSEMBLY():\n"
			+ "      # $ 132 \"PUT_BEARING_MATRIZ_ASSEMBLY\" \"noBreak\"\n"
			+ "      # $ 133 \"'Ver 1.0 rev 05/10/2020 Bases in matrix 4*4'\"\n"
			+ "      # 'Ver 1.0 rev 05/10/2020 Bases in matrix 4*4'\n"
			+ "      # $ 134 \"MoveJ\"\n"
			+ "      # $ 135 \"Approach_2\" \"breakAfter\"\n"
			+ "      movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=8.726646259971647, v=4.363323129985823)\n"
			+ "      # $ 136 \"Set\"\n"
			+ "      # $ 137 \"Pallet\"\n"
			+ "      cnt_3_x = cnt_3 % 2\n"
			+ "      cnt_3_y = floor(cnt_3 / 2)\n"
			+ "      pose_5 = interpolate_pose(interpolate_pose(p[-.110698014011, -.404256215370, .037039855074, -.032651951944, 3.141303350114, -.024820428486], p[.008365619902, -.401875405937, .037033485025, .032546504275, -3.141349295395, -.004489768950], cnt_3_x/1), interpolate_pose(p[-.111984878209, -.294051331752, .035907576276, .032792806628, -3.141285338428, -.003236093701], p[.008342654262, -.293291574903, .037005687781, .032781646304, -3.141194481082, -.003042610230],cnt_3_x/1), cnt_3_y/1)\n"
			+ "      if (cnt_3 >= 3):\n"
			+ "        cnt_3 = 0\n"
			+ "      else:\n"
			+ "        cnt_3 = cnt_3 + 1\n"
			+ "      end\n"
			+ "      # $ 144 \"Approach_3\" \"noBreak\"\n"
			+ "      movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836])), a=2.5, v=0.25)\n"
			+ "      # $ 145 \"Waypoint_2\" \"noBreak\"\n"
			+ "      movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.110702578703, -.402720127022, .054984750320, .032876732918, -3.141314066424, .000327064816])), a=2.5, v=0.25)\n"
			+ "      # $ 146 \"PatternPoint_2\" \"noBreak\"\n"
			+ "      movel(pose_5, a=2.5, v=0.25)\n"
			+ "      # $ 147 \"Set\" \"noBreak\"\n"
			+ "      # $ 149 \"Wait: 0.5\" \"noBreak\"\n"
			+ "      sleep(0.5)\n"
			+ "      # $ 150 \"Waypoint_3\" \"noBreak\"\n"
			+ "      movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.110702578703, -.402720127022, .054984750320, .032876732918, -3.141314066424, .000327064816])), a=2.5, v=0.25)\n"
			+ "      # $ 151 \"N_Bearings≔N_Bearings+1\" \"noBreak\"\n"
			+ "      global N_Bearings=N_Bearings+1\n"
			+ "      # $ 152 \"BEARINGs≔BEARINGs+1\" \"noBreak\"\n"
			+ "      global BEARINGs=BEARINGs+1\n"
			+ "      # $ 153 \"Exit_3\" \"noBreak\"\n"
			+ "      movel(pose_trans(pose_5, pose_trans(pose_inv(p[-.110694380911, -.403562251454, .036970609834, .032592691804, -3.141316894964, .012342883790]),p[-.050258128201, -.341513912103, .102443674357, -.033037479367, 3.141376028057, -.000141032752])), a=2.5, v=0.25)\n"
			+ "      if (cnt_3 == 0):\n"
			+ "        # $ 154 \"AfterEnd\" \"noBreak\"\n"
			+ "        # $ 155 \"BEARINGtime: Stop\" \"noBreak\"\n"
			+ "        BEARINGtime_is_counting = False\n"
			+ "        # $ 156 \"CycleTimeBEARIN≔BEARINGtime\" \"noBreak\"\n"
			+ "        global CycleTimeBEARIN=BEARINGtime\n"
			+ "        # $ 157 \"BEARINGtime: Reset\" \"noBreak\"\n"
			+ "        BEARINGtime = 0\n"
			+ "      end\n"
			+ "    end";
	
	private String code;
	
	// Singleton (only one instance)
	
	private static PutBearing singleton = new PutBearing();
	
	
	private PutBearing() {
		
	}
	
	public static PutBearing getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	public String getCode() {
		return generateCode();
	}
	
	public String getDefaultCode() {
		return defaultCode;
	}
	
	private String generateCode() {
		code = "";
		
		return code;
	}
}
