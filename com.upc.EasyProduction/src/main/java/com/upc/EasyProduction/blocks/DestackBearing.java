package com.upc.EasyProduction.blocks;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DestackBearing extends Block {	

	// Singleton (only one instance)
	
	private static DestackBearing singleton = new DestackBearing();
	
	
	private DestackBearing() {
		
		defaultCode = "\n"
				+ "      # $ 41 \"If N_Bases≥4\"\n"
				+ "      if (N_Bases >= 4):\n"
				+ "        # $ 42 \"BEARINGtime: Start\"\n"
				+ "        BEARINGtime_is_counting = True\n"
				+ "        # $ 43 \"MoveJ\"\n"
				+ "        # $ 44 \"BEARINGready\" \"breakAfter\"\n"
				+ "        movej(get_inverse_kin(p[.298623961974, -.004480822059, .127082453796, 2.221537881908, -2.221289101494, .000338382310], qnear=[0.37087658047676086, -1.4807313124286097, -1.6561453978167933, -1.5754616896258753, 1.5705832242965698, 0.3707645833492279]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "        # $ 46 \"'(((((((Destack BEARING))))))'\"\n"
				+ "        # '(((((((Destack BEARING))))))'\n"
				+ "        # $ 47 \"Set DO[4]=On\"\n"
				+ "        set_standard_digital_out(4, True)\n"
				+ "        # $ 48 \"Destack\"\n"
				+ "        if (interpolate_2 == 0.0):\n"
				+ "          # $ 49 \"StartPos_1\" \"breakAfter\"\n"
				+ "          movel(p[.299961284094, -.003023643136, .087038648297, 2.221468076465, -2.221357463836, .000357837453], a=2.5, v=0.25)\n"
				+ "          global ur_start_point_48=get_forward_kin()\n"
				+ "        else:\n"
				+ "          movel(p[ur_start_point_48[0]+interpolate_2*-1.2164207743687688E-4, ur_start_point_48[1]+interpolate_2*-3.218337538111017E-4, ur_start_point_48[2]+interpolate_2*-0.9999999408131183, ur_start_point_48[3],ur_start_point_48[4],ur_start_point_48[5]], a=2.5, v=0.25)\n"
				+ "        end\n"
				+ "        thread ur_Thread_direction_48():\n"
				+ "          speedl([-1.2164207743687688E-6,-3.218337538111017E-6,-0.009999999408131182,0.0,0.0,0.0],2.5,100000.0)\n"
				+ "          ur_stacking_motion_running_48 = False\n"
				+ "        end\n"
				+ "        ur_thread_handler_48 = run ur_Thread_direction_48()\n"
				+ "        ur_stacking_motion_running_48 = True\n"
				+ "        while (ur_stacking_motion_running_48 == True):\n"
				+ "          if ((pose_dist(get_forward_kin(),ur_start_point_48)>0.051332977565098796)):\n"
				+ "            kill ur_thread_handler_48\n"
				+ "            ur_stacking_motion_running_48 = False\n"
				+ "            interpolate_2 = 0.0\n"
				+ "            stopl(2.5)\n"
				+ "          else:\n"
				+ "            if (get_standard_digital_out(4) ==   True  ):\n"
				+ "              kill ur_thread_handler_48\n"
				+ "              ur_stacking_motion_running_48 = False\n"
				+ "              interpolate_2 = pose_dist(get_forward_kin(),ur_start_point_48) +0.014\n"
				+ "              stopl(1.2)\n"
				+ "              pose_2 = get_forward_kin()\n"
				+ "              # $ 54 \"StackPos_Bearin\" \"breakAfter\"\n"
				+ "              movel(pose_2, a=2.5, v=0.25)\n"
				+ "              # $ 55 \"RetrocesBearing\" \"breakAfter\"\n"
				+ "              movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.299959936617, -.003013929312, .099996583094, 2.221416726466, -2.221332710455, .000238818527])), a=2.5, v=0.25)\n"
				+ "              # $ 57 \"GetBearingReady\" \"breakAfter\"\n"
				+ "              movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.300025795311, -.002987830780, .075986793985, -2.221419779077, 2.221255986351, -.000444930108])), a=2.5, v=0.25)\n"
				+ "              # $ 59 \"Wait: 0.5\"\n"
				+ "              sleep(0.5)\n"
				+ "              # $ 60 \"Set DO[4]=Off\"\n"
				+ "              set_standard_digital_out(4, False)\n"
				+ "              # $ 61 \"ExitStackBearin\" \"breakAfter\"\n"
				+ "              movel(pose_trans(pose_2, pose_trans(pose_inv(p[.299984752629, -.003021484200, .087054949052, -2.221469171956, 2.221385192051, -.000420102607]),p[.299994499457, -.003028398327, .127794425207, 2.221507439481, -2.221369363430, .000403330862])), a=2.5, v=0.25)\n"
				+ "            end\n"
				+ "          end\n"
				+ "          sync()\n"
				+ "        end\n";
		
		name = "DestackBearing";
		
		this.setText(name);
		
	}
	
	public static DestackBearing getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
