package reservation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LoginDialog extends Dialog implements ActionListener,WindowListener{
		
		// TODO Auto-generated constructor stub
		boolean canceled;// キャンセルのときはtrue OKおしたら false
		TextField tfUserID;//ユーザIDを入力するテキストフィールト 
		TextField tfPassword;//パスワードを入力するテキストフィールト
		Button buttonOK; //OKボタン
		Button buttonCancel; //キャンセルボタン
		Panel panelNorth; //上部パネル 
		Panel panelMid; //中央のパネル 
		Panel panelSouth;//下部パネル

		public LoginDialog(Frame owner) {
			//基底クラス(Dialog)のコンストラクタを呼び出す
			super(owner,"Login",true);
			//キャンセルは初期値ではtrueとしておく
			canceled = true;

			// テキストフィールドの生成
			tfUserID = new TextField("",10);
			 tfPassword = new TextField("",10);
			// パスワードを入力するテキストフィールドは入力した文字が * になるようにする
			tfPassword.setEchoChar('*');

			// ボタンの生成
			buttonOK = new Button("OK");
			 buttonCancel = new Button("キャンセル");

			// パネルの生成
			 panelNorth = new Panel();
			 panelMid = new Panel();
			 panelSouth = new Panel();

			// 上部パネルに,ユーザIDテキストフィールドを追加
			panelNorth.add( new Label("ユーザID"));
			 panelNorth.add(tfUserID);

			// 中央パネルに,パスワードテキストフィールドを追加
			panelMid.add( new Label("パスワード"));
			 panelMid.add(tfPassword);

			// 下部パネルに2つのボタンを追加
			panelSouth.add(buttonCancel);
			panelSouth.add(buttonOK);

			// LoginDialogをBorderLayoutに設定し,3つのパネルを追加
			 setLayout( new BorderLayout());
			 add( panelNorth,BorderLayout.NORTH);
			 add( panelMid, BorderLayout.CENTER);
			 add( panelSouth, BorderLayout.SOUTH);

			// ウィンドウリスナを追加
			 addWindowListener(this);

			// ボタンにアクションリスナを追加
			 buttonOK.addActionListener(this);
			 buttonCancel.addActionListener(this);

			// 大きさの設定,ウィンドウのサイズ変更不可の設定
			this.setBounds( 100, 100, 350, 150);
            setResizable(false);			
		}


	


	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stu
		if ( e.getSource() == buttonCancel){
		canceled = true;
		 } else if ( e.getSource() == buttonOK){
		 canceled = false;
		}
		 setVisible(false);
		 dispose();

}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 setVisible(false);
		 canceled = true;
		 dispose();
}



@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
}
