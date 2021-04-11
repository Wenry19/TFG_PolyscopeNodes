package com.upc.EasyProduction.blocks.productionBlocks;

import com.upc.EasyProduction.blocks.Block;

public class DespalletizeProduct extends Block{
	
	
	public DespalletizeProduct() {
		
		identation = "        ";
		
		defaultCode = "\n"
				+ "        # $ 72 \"MoveJ\"\n"
				+ "        # $ 73 \"Approach_2\" \"breakAfter\"\n"
				+ "        movej(get_inverse_kin(p[-.050273197644, -.341535366440, .102459786423, -.032924896149, 3.141372266899, -.000292544836], qnear=[-1.385470215474264, -1.690115753804342, -1.558995548878805, -1.463085953389303, 1.5708110332489014, 0.1643647700548172]), a=8.726646259971647, v=4.363323129985823)\n"
				+ "        # $ 75 \"'((((((Despalletize PRODUCT))))))'\"\n"
				+ "        # '((((((Despalletize PRODUCT))))))'\n"
				+ "        # $ 76 \"Pallet\"\n"
				+ "        cnt_5_x = cnt_5 % 2\n"
				+ "        cnt_5_y = floor(cnt_5 / 2)\n"
				+ "        pose_8 = interpolate_pose(interpolate_pose(p[-.110209633621, -.400798241069, .009725399388, .000262632384, 3.141493321512, -.000234405822], p[.004970221066, -.401270940244, .010001920963, .000344367912, 3.141488273201, -.000264838594], cnt_5_x/1), interpolate_pose(p[-.109906746146, -.295049659473, .010710437065, .000349421098, -3.141557552539, -.000330563446], p[.006849313810, -.295010200451, .009994673109, -.000113213599, 3.141585977963, -.000013454875],cnt_5_x/1), cnt_5_y/1)\n"
				+ "        if (cnt_5 >= 3):\n"
				+ "          cnt_5 = 0\n"
				+ "        else:\n"
				+ "          cnt_5 = cnt_5 + 1\n"
				+ "        end\n"
				+ "        # $ 83 \"ApproachProduct\" \"noBreak\"\n"
				+ "        movel(pose_trans(pose_8, pose_trans(pose_inv(p[-.110222921483, -.400694473317, .016073121842, .000281289657, 3.141507524398, .000442570959]),p[-.110198978938, -.400712165434, .059970625820, .000150012859, 3.141507240541, .000351946364])), a=2.5, v=0.25)\n"
				+ "        # $ 84 \"PatternPoint_4\" \"noBreak\"\n"
				+ "        movel(pose_8, a=2.5, v=0.25)\n"
				+ "        # $ 86 \"Wait: 0.5\" \"noBreak\"\n"
				+ "        sleep(0.5)\n"
				+ "        # $ 87 \"Exit_4\" \"noBreak\"\n"
				+ "        movel(pose_trans(pose_8, pose_trans(pose_inv(p[-.110222921483, -.400694473317, .016073121842, .000281289657, 3.141507524398, .000442570959]),p[-.110187854924, -.400679425425, .060006956619, .000206408095, 3.141448072859, .000559160477])), a=2.5, v=0.25)";
		
		name = "DespalletizeProduct";
		
		this.setText(name);
		
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
