package com.upc.EasyProduction.blocks;


public class DestackBase extends Block {
	
	
	// Singleton (only one instance)
	
	private static DestackBase singleton = new DestackBase();
	
	
	private DestackBase() {
		
		defaultCode = "\n"
				+ "      # $ 21 \"'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\"\n"
				+ "      # 'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\n"
				+ "      # $ 22 \"If N_Bases<4\"\n"
				+ "      if (N_Bases<4):\n"
				+ "        # $ 23 \"BASEtime: Start\"\n"
				+ "        BASEtime_is_counting = True\n"
				+ "        # $ 24 \"'(((((((Destack BASE))))))'\"\n"
				+ "        # '(((((((Destack BASE))))))'\n"
				+ "        # $ 25 \"Set DO[4]=On\"\n"
				+ "        set_standard_digital_out(4, True)\n"
				+ "        # $ 26 \"Destack\"\n"
				+ "        if (interpolate_3 == 0.0):\n"
				+ "          # $ 27 \"StartPos_Bases\" \"breakAfter\"\n"
				+ "          movel(p[.298624768117, -.112368891041, .093007213993, -2.221473960271, 2.221233530776, -.000322140067], a=2.5, v=0.25)\n"
				+ "          global ur_start_point_26=get_forward_kin()\n"
				+ "        else:\n"
				+ "          movel(p[ur_start_point_26[0]+interpolate_3*-0.009182871541590216, ur_start_point_26[1]+interpolate_3*1.4480909105633898E-4, ur_start_point_26[2]+interpolate_3*-0.9999578260609682, ur_start_point_26[3],ur_start_point_26[4],ur_start_point_26[5]], a=2.5, v=0.25)\n"
				+ "        end\n"
				+ "        thread ur_Thread_direction_26():\n"
				+ "          speedl([-9.182871541590215E-5,1.4480909105633898E-6,-0.009999578260609682,0.0,0.0,0.0],2.5,100000.0)\n"
				+ "          ur_stacking_motion_running_26 = False\n"
				+ "        end\n"
				+ "        ur_thread_handler_26 = run ur_Thread_direction_26()\n"
				+ "        ur_stacking_motion_running_26 = True\n"
				+ "        while (ur_stacking_motion_running_26 == True):\n"
				+ "          if ((pose_dist(get_forward_kin(),ur_start_point_26)>0.06) and (force() >= 30)):\n"
				+ "            kill ur_thread_handler_26\n"
				+ "            ur_stacking_motion_running_26 = False\n"
				+ "            interpolate_3 = 0.0\n"
				+ "            stopl(2.5)\n"
				+ "          else:\n"
				+ "            if (get_standard_digital_out(4) ==   True  ):\n"
				+ "              kill ur_thread_handler_26\n"
				+ "              ur_stacking_motion_running_26 = False\n"
				+ "              interpolate_3 = pose_dist(get_forward_kin(),ur_start_point_26) +0.015\n"
				+ "              stopl(0.5)\n"
				+ "              pose_1 = get_forward_kin()\n"
				+ "              # $ 32 \"StackPos_Base\" \"breakAfter\"\n"
				+ "              movel(pose_1, a=2.5, v=0.25)\n"
				+ "              # $ 33 \"Retroceso\" \"breakAfter\"\n"
				+ "              movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298573010704, -.112439319284, .110002843631, 2.221292614300, -2.221583920517, .000199925827])), a=2.5, v=0.25)\n"
				+ "              # $ 35 \"GetBaseReady\" \"breakAfter\"\n"
				+ "              movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298537000070, -.112435425956, .072997228836, 2.221168910712, -2.221487718883, -.000017648768])), a=2.5, v=0.25)\n"
				+ "              # $ 37 \"Wait: 0.5\"\n"
				+ "              sleep(0.5)\n"
				+ "              # $ 38 \"Set DO[4]=Off\"\n"
				+ "              set_standard_digital_out(4, False)\n"
				+ "              # $ 39 \"Exit_Bases\" \"breakAfter\"\n"
				+ "              movel(pose_trans(pose_1, pose_trans(pose_inv(p[.298616370886, -.112392906623, .092972358085, -2.221423852054, 2.221343371111, -.000335514474]),p[.298577789554, -.112373604398, .128177700744, 2.221160317439, -2.221480561123, -.000221512900])), a=2.5, v=0.25)\n"
				+ "            end\n"
				+ "          end\n"
				+ "          sync()\n"
				+ "        end\n";
		
		name = "DestackBase";
		
		this.setText(name);
		
	}
	
	public static DestackBase getInstance() {
		return singleton;
	}
	
	// End Singleton
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
