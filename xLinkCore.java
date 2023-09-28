//comments have not been added for already explained code concepts as code is long
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Home{//this class is for the homepage
    Home(){    
    JFrame j=new JFrame(); //create the frame for homepage
    j.setSize(500,500); //set the frame attributes with frame methods
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminates the entire app when user clicks the X button
    j.setTitle("X-LINK ROUTER APP");
    j.setLocationRelativeTo(null);// this line ensures that the frame renders in the center of the screen
    JButton a=new JButton("Login");//create buttons
    JButton b=new JButton("Update Firmware");
    JButton c=new JButton("View Router Specs");
    JButton d=new JButton("Support");

    a.addActionListener(new ActionListener(){//here we specify the action to take when button is pressed
        public void actionPerformed(ActionEvent ae){  
            j.dispose();   //delete current frame
            new LoginFrame();  //calls the class constructor for login page           
        }
    });

    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent be){  
            j.dispose();       
            Updater m1=new Updater();  
            m1.start();     /*creating a new thread only for the updating firmware progressbar
        as otherwise it would conflict with event dispatching thread*/
    }
    });

    c.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent be){  
            JOptionPane.showMessageDialog(j,"ROUTER SPECS-\n\nDual-band Wireless AC1900 (1300 Mbps on 5 GHz + 600 Mbps on 2.4 GHz)\n802.11ac Wave 2 with MU-MIMO and Advanced AC SmartBeam\nGigabit WAN and 4 x Gigabit LAN","Router Specs",1);
          //this creates a dialog box to display information
        }
    });
    d.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent be){  
            JOptionPane.showMessageDialog(j,"X-Link’s Customer Service department is available by phone at 98913023170 or at the email options below:\n\nGeneral Inquiries: customerservice@xyz.com\nRMA Inquiries: rma_requests@xyz.com","Support",1);
          
        }
    });

    JPanel mainpanel=new JPanel();//creates a panel to contain the header name and icon
    mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));//setting the layout manager
    JPanel panel=new JPanel();
    panel.setLayout(new GridBagLayout());
    ImageIcon i=new ImageIcon("5238817 (1).png"); //passable object to encapsulate app icon
    GridBagConstraints gbc = new GridBagConstraints();// this object is used to arrange the grid elements
    gbc.gridwidth = GridBagConstraints.REMAINDER; 
    gbc.anchor = GridBagConstraints.NORTH;
    JLabel title=new JLabel("X-LINK ROUTER APP",i,JLabel.CENTER);//header of the window
    title.setFont(new Font("Helvetica",Font.BOLD,40));//specify font style,size
    title.setHorizontalTextPosition(JLabel.CENTER);
    title.setVerticalTextPosition(JLabel.BOTTOM);//align the header name below the icon
    panel.add(title, gbc); //add title label to the panel
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    mainpanel.add(panel,gbc);
    JPanel buttons = new JPanel(new GridBagLayout());//create a panel for all the buttons
    buttons.setSize(300, 500);
    buttons.add(a);
    buttons.add(b);
    buttons.add(c);
    buttons.add(d);
    gbc.anchor = GridBagConstraints.SOUTH;
    mainpanel.add(buttons,gbc);    
    JLabel jl=new JLabel();   
    jl=new JLabel("Copyright (c) 2023 by X-LINK Enterprises LTD"); // label for copyright statement
    jl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    mainpanel.add(jl);   
    j.add(mainpanel);
    j.setVisible(true); //makes the frame visible
    }
}

class LoginFrame{   
    LoginFrame()
    {
        JLabel userLabel=new JLabel("USERNAME");
        JLabel passwordLabel=new JLabel("PASSWORD");
        JTextField userTextField=new JTextField(15);//create text box
        JPasswordField passwordField=new JPasswordField(15);//create password box
        JButton loginButton=new JButton("LOGIN");
        JCheckBox showPassword=new JCheckBox("Show Password");//creates a check box
        JFrame k=new JFrame("Login");    
        k.setLayout(new BorderLayout());
        JPanel top=new JPanel();
        top.setLayout(new GridBagLayout());
        Dimension d=new Dimension(10,100);//creating a passable object containing width and height
        top.add(Box.createRigidArea(d));//creates an invisible box, for formatting purposes
        JLabel title=new JLabel("USER LOGIN");
        title.setFont(new Font("Helvetica",Font.BOLD,48));
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);//aligning header to center
        top.add(title);
        k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gb=new GridBagConstraints();// this object is used to customize layout of objects
        k.setSize(400,400);
        k.setLocationRelativeTo(null);
        loginButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae1){                
        String Username = userTextField.getText();
	    String Password1 = passwordField.getText();
	    if (Username.equals("abc") && Password1.equals("123"))/*logic for determining if login was successful or not
		Note that username is set to 'abc' and password is set to '123'*/
        JOptionPane.showMessageDialog(null, "Login Successful");//dialog box to display msg
	    else
		JOptionPane.showMessageDialog(null, "Username or Password incorrect");
}});
        JPanel center= new JPanel();  
        center.setLayout(new GridBagLayout());    
        Dimension d1=new Dimension(0,20); 
        gb.gridy=0;// used to specify y axis coordinate of grid to place element in
        center.add(userLabel,gb);       
        center.add(userTextField,gb);
        gb.gridy=1;
        center.add(Box.createRigidArea(d1),gb);
        gb.gridy=2;
        center.add(passwordLabel,gb);
        center.add(passwordField,gb);       
        gb.gridy=3;
        center.add(Box.createRigidArea(d1),gb);
        gb.gridy=4;            
        showPassword.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae1){  
            passwordField.setEchoChar((char)0); // when checkbox is ticked, password box shows the actual characters typed instead of ****           
        }
        });
        center.add(showPassword,gb);
        gb.gridy=5;
        center.add(loginButton,gb);
        JButton p=new JButton("Go back");
        p.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae1){  
            k.dispose();    //deletes the login frame
            new Home();     //calls class constructor for home page
        }
        });
        JPanel bottom=new JPanel();
        bottom.setLayout(new BorderLayout());
        bottom.add(p,BorderLayout.EAST);
        k.add(bottom,BorderLayout.SOUTH);
        k.add(top,BorderLayout.NORTH);
        k.add(center, BorderLayout.CENTER);
        k.setVisible(true);
   }
}

class Demo{
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){//create event dispatching thread
        public void run(){
            new Home();   //starts the app by calling the class constructor for home page
        }        
        });
    }
}

class Updater extends Thread{ /*class for updating firmware progress bar
    Note that it is a dummy progress bar and doesn't represent anything*/
    public void run(){
	JFrame frame = new JFrame("Updating Firmware");    
    frame.setLayout(new BorderLayout());
    JPanel pbar=new JPanel();
    JPanel bbar=new JPanel();
    JPanel tbar=new JPanel();
    tbar.setLayout(new BoxLayout(tbar,BoxLayout.Y_AXIS));
    bbar.setLayout(new BorderLayout());
    pbar.setLayout(new GridBagLayout());
	JProgressBar bar = new JProgressBar(0,100);//create the progress bar, set min and max values
		bar.setValue(0);//set initial value
        Dimension size= new Dimension(350,50);
		bar.setPreferredSize(size);
		bar.setStringPainted(true);//allow text to be placed on the progress bar			
		pbar.add(bar);
        frame.add(pbar,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
		JButton p=new JButton("Go back");
        p.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae1){  
           frame.dispose();  
            new Home();     
        }
        });
        Dimension d=new Dimension(10,50);
        JLabel q=new JLabel("INSTALLING UPDATES");
        q.setFont(new Font("Helvetica",Font.BOLD,32));
        q.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        tbar.add(Box.createRigidArea(d));
        tbar.add(q);
        frame.add(tbar,BorderLayout.NORTH);
        bbar.add(p,BorderLayout.EAST);
        frame.add(bbar, BorderLayout.SOUTH);
		frame.setVisible(true);
		int counter =0;		
		while(counter<=100) {  //logic for making the progress bar load from 0% to 100*			
			bar.setValue(counter);
			try {
				Thread.sleep(50);//put delay of 50ms between each percentage
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter +=1;
		}
		bar.setString("Done!"); //print "Done!" when bar reaches 100%
	}}