import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class customer extends Application implements EventHandler<ActionEvent> {
    public static void main(String[] args) {
        launch(args);
    }
    Button a=new Button("1");
    
    
    Button b=new Button("2");
    Button c=new Button("3");
    Button d=new Button("4");
    Button e=new Button("5");
    Button f=new Button("6");
    Button g=new Button("7");
    Button h=new Button("8");
    Button i=new Button("9");
    Button j=new Button("0");
    Button prev=new Button("prev");
    Button next=new Button("next");
    Button submit=new Button("Submit");
    Button delete=new Button("Delete");
    Label money =new Label();
    Label info=new Label();
    Atm client =new Atm();
Stage window;
Long[] ap = new Long[5];
Long[] an=new Long[5];
int i1=0;
Long at,ax;
Stage er=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        

    	a.setOnAction((event) ->{
    		String s=money.getText()+a.getText();
    		money.setText(s);
    	});
    	b.setOnAction((event) ->{
    		String s=money.getText()+b.getText();
    		money.setText(s);
    	});
    	c.setOnAction((event) ->{
    		String s=money.getText()+c.getText();
    		money.setText(s);
    	});
    	d.setOnAction((event) ->{
    		String s=money.getText()+d.getText();
    		money.setText(s);
    	});
    	e.setOnAction(( event) ->{
    		String s=money.getText()+e.getText();
    		money.setText(s);
    	});
    	f.setOnAction(( event) ->{
    		String s=money.getText()+f.getText();
    		money.setText(s);
    	});
    	g.setOnAction((event) ->{
    		String s=money.getText()+g.getText();
    		money.setText(s);
    	});
    	h.setOnAction((event) ->{
    		String s=money.getText()+h.getText();
    		money.setText(s);
    	});
    	i.setOnAction(( event) ->{
    		String s=money.getText()+i.getText();
    		money.setText(s);
    	});
    	j.setOnAction((event) ->{
    		String s=money.getText()+j.getText();
    		money.setText(s);
    	});
    	delete.setOnAction((event)->{
    		String s=money.getText();
    		
    		StringBuffer buff = new StringBuffer(s);
    		buff.toString();
    		
    		money.setText(" ");
    		buff.deleteCharAt(buff.length()-1);
    		String a=buff.toString();
    		money.setText(a);
    		});
//    	info.setOnAction((event) ->{
//    		String s=money.getText()+j.getText();
//    		info.setText(s);
//    	});
    	next.setOnAction((event) ->{
    		if(i1>4) {
    			//System.out.println(an[i1]);	
    			info.setText(ap[i1-1].toString());
    		}else if(i1<4){
    			//System.out.println(an[i1+1]);	
    			info.setText(ap[i1+1].toString());
    		i1++;
    		}
    	});
    	prev.setOnAction((event) ->{
    		if(i1<0) {
    			//System.out.println(ap[i1]);	
    			info.setText(ap[i1].toString());
    		}else if(i1>0) {
    			//System.out.println(ap[i1-1]);	
    			
    			info.setText(ap[i1-1].toString());
    			an[i1-1]=ap[i1-1];
    		i1--;
    		}
    	});
    	
    	
    	//next.setOnAction(e->window.setScene(scene2));
    	
    	this.window=primaryStage;
        primaryStage.setTitle("ATM");
        Label CardNumber=new Label("Card number =");
        TextField CardNumberField=new TextField();
        Button Confirm=new Button("Confirm");
        
           Confirm.setOnAction((event)-> {
        
        	   if(client.CardNumber==Integer.parseInt(CardNumberField.getText()))
        	   {
        		   
        		   window.setScene(Homepage());
        		   
        	   }else
        		   er.setScene(error());
            
       
    });
        
        GridPane grid=new GridPane();
        grid.add(CardNumber,0,0);
        grid.add(CardNumberField,1,0);
        grid.add(Confirm,0,1);
        
        Scene scene=new Scene(grid,300,300);
        primaryStage.setScene(scene);
        window.show();
    }
    
    public  Scene Homepage()
    {
    	
    	GridPane gridOfHomepage=new GridPane();
    	
    	Button deposit=new Button("Deposit");
        Button withdraw=new Button("Withdraw");
        Button balance=new Button("Balance");
        
       
        gridOfHomepage.add(deposit,1,0);
        gridOfHomepage.add(withdraw,2,0);
        gridOfHomepage.add(balance,3,0);
        gridOfHomepage.add(prev,1,2);
        gridOfHomepage.add(info, 4, 0);
        //grid.add(info, 4, 0);
        gridOfHomepage.add(next,3,2);
        
        deposit.setOnAction((event) ->{
    		window.setScene(DepositPage());
    		
    	});
        withdraw.setOnAction(e ->window.setScene(WithDraw()));
        balance.setOnAction(e ->window.setScene(Balance()));
        
        
        gridOfHomepage.setAlignment(Pos.CENTER);
       Scene homepage=new Scene(gridOfHomepage,300,300);
    	window.setScene(homepage);
    	window.show();
    	
   return homepage; }
    
 public Scene WithDraw() {
	 GridPane grid=new GridPane();
 	grid.add(a,1,0);
 	grid.add(b,2,0);
 	grid.add(c,3,0);
 	grid.add(d,1,1);
 	grid.add(e,2,1);
 	grid.add(f,3,1);
 	grid.add(g,1,2);
 	grid.add(h,2,2);
 	grid.add(i,3,2);
 	grid.add(j,2,3);
 	grid.add(money,5,0);
 	grid.add(submit, 3,4 );
 	grid.add(delete, 4, 0);
 	grid.setAlignment(Pos.CENTER);
 	
 	submit.setOnAction((event) ->{
		client.withdrawalMethod(Long.parseLong(money.getText()));
		window.setScene(Homepage());
//		money.getText();
//		money.setText("");
		if(client.getBalance()<0)
		er.setScene(error());
		else {
			System.out.println(client.getBalance());
			if(i1==5) {
    			i1--;
    			ax=Long.parseLong(money.getText());
    			for(i1=0;i1<4;i1++) {
    				ap[i1]=ap[i1+1];
    			}
    		
    		ap[4]=ax;
    		i1=5;
		}
		else {
			ap[i1]=Long.parseLong(money.getText());
			i1++;
		}
		}
	});
 	Scene withdrawpage=new Scene(grid,300,300);
 	return withdrawpage;
	 
 }
 public Scene Balance() {
	 GridPane grid=new GridPane();
	  System.out.println(client.getBalance());
	  Label balance=new Label("Balance:");
	  Button prev1=new Button("Prev");
	  money.setText(client.getBalance().toString());
	  prev1.setOnAction((event)->{
      	window.setScene(Homepage());
      	if(i1==5) {
			i1--;
			ax=Long.parseLong(money.getText());
			for(i1=0;i1<4;i1++) {
				ap[i1]=ap[i1+1];
			}
		
		ap[4]=ax;
		i1=5;
	}
	else {
		ap[i1]=Long.parseLong(money.getText());
		i1++;
	}
      });
 grid.add(money, 1, 0);
 grid.add(balance,0, 0);
 grid.add(prev1, 1, 3);
	
 
 grid.setAlignment(Pos.CENTER);
 Scene Balance=new Scene(grid,300,300);
 return Balance;
 }
    public Scene DepositPage()
    {
    	GridPane grid=new GridPane();
    	grid.add(a,1,0);
    	grid.add(b,2,0);
    	grid.add(c,3,0);
    	grid.add(d,1,1);
    	grid.add(e,2,1);
    	grid.add(f,3,1);
    	grid.add(g,1,2);
    	grid.add(h,2,2);
    	grid.add(i,3,2);
    	grid.add(j,2,3);
    	
//    	grid.add(prev, 1, 3);
//    	grid.add(next, 3, 3);
    	grid.add(money,5,0);
    	grid.add(submit, 3,4 );
    	grid.add(delete, 4, 0);
    	grid.setAlignment(Pos.CENTER);
    	submit.setOnAction((event) ->{
    		client.DepositMethod(Long.parseLong(money.getText()));
    		
    		window.setScene(Homepage());
//    	money.getText();
//    	money.setText(" ");
    		System.out.println(client.getBalance());
    		if(i1==5) {
    			i1--;
    			ax=Long.parseLong(money.getText());
    			for(i1=0;i1<4;i1++) {
    				ap[i1]=ap[i1+1];
    			}
    		
    		ap[4]=ax;
    		i1=5;
    		
    		}
    		else {
    			ap[i1]=Long.parseLong(money.getText());
    			i1++;
    		}
    	});
    	Scene depositpage=new Scene(grid,300,300);
    	
    	return depositpage; 	
    }
    
    public Scene error() {
    	
    	Label ero=new Label("error");
    	Button ok=new Button("Ok");
    	GridPane gridoferror=new GridPane();
    	gridoferror.add(ero, 0,0);
    	gridoferror.add(ok, 0,1);
    	gridoferror.setAlignment(Pos.CENTER);
    	Scene erro=new Scene(gridoferror,200,100);
    	er.setScene(erro);
    	
    	ok.setOnAction(( event) ->{
    		er.close();
    		
    	});
    	er.show();
    	return erro;
    }
    
}




