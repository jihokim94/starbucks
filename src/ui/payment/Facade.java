package ui.payment;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Member;
import ui.payment.Factory.JButtonCreator;
import ui.payment.Factory.JLabelCreator;

public class Facade {
	private JPanel mainPanel;
	private JPanel subPanel;
	private Member member;
	private JLabelCreator labelCreator;
	private JButtonCreator btnCreator;
	
	public Facade(JPanel _mainPanel,JPanel _subPanel,Member _member) {
		this.mainPanel = _mainPanel;
		this.subPanel = _subPanel;
		this.member = _member;
		
		labelCreator = new JLabelCreator();
		btnCreator = new JButtonCreator();
	}
	
	public void viewClientInfo() {
		checkName();
		
		checkPhoneNum();
		
		checkEmail();
	}
	
	private void checkEmail() {
		JLabel lbEmail = (JLabel) labelCreator.createWithIcon("\uC774\uBA54\uC77C"
				, "C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"
				, -1, -1, -1, -1);
		subPanel.add(lbEmail);
		
		String email = member.getEmail();
		JLabel lbEmail2 = (JLabel) labelCreator.createWithHorizontal(email, null, -1, -1, -1, -1, 0);
		subPanel.add(lbEmail2);
	}

	private void checkPhoneNum() {
		JLabel lbPhone = (JLabel) labelCreator.createWithIcon("\uC5F0\uB77D\uCC98 ( - \uC5C6\uC774 \uC785\uB825\uD574\uC8FC\uC138\uC694)"
				, "C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"
				, -1, -1, -1, -1);
		subPanel.add(lbPhone);
		
		String phone = member.getPhone();
		JLabel lbPhoneNo = (JLabel) labelCreator.createWithHorizontal(phone, null, -1, -1, -1, -1, 0);
		subPanel.add(lbPhoneNo);
	}
	
	private void checkName() {	//¸â¹ö, panel1_1
		JLabel lbName = (JLabel) labelCreator.createWithIcon("\uACB0\uC81C\uC790 \uC131\uBA85"
				, "C:\\dev2020\\java_ws\\FamilyCafeteria\\icons\\control_play_blue.png"
				, -1, -1, -1, -1);
		subPanel.add(lbName);
		
		String name = member.getName();
		JLabel lbNameIn = (JLabel) labelCreator.createWithHorizontal(name, null, -1, -1, -1, -1, 0);
		subPanel.add(lbNameIn);
	}
	
}
