package com.nt.jdbc;

import java.util.*;
enum items{
 IDLY,DOSA,PURI,VODA
}
 class Hotel 
 {
	public static void main(String[] args) 
	{
        
      String name;

       Scanner sc=new Scanner(System.in);
		int p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,qty1,qty2,qty3,qty4,qty5,qty6,qty7,qty8,qty9,qty10;
		p1=p2=p3=p4=p5=p6=p7=p8=p9=p10=qty1=qty2=qty3=qty4=qty5=qty6=qty7=qty8=qty9=qty10=0;

        System.out.println();
	    System.out.println("                                   Welcome to Manoj  Restaurent                   ");
	    System.out.println();
	    System.out.println("                        ------ Menu Items-----     ");

		System.out.println("  Veg Items                                        Non Veg items                       ");
		System.out.println(" ------------                                     -----------------                    ");

	    System.out.println("    1.IDLY(3)     = 20.00                          6.Chiken Biriyani               = 120.00 ");
	    System.out.println("    2.DOSA(1)     = 35.00                          7.Chiken LollyPop(3)            = 135.00");
	    System.out.println("    3.PURI (2)    = 30.00                          8.Chiken 65                     = 150.00 ");
	    System.out.println("    4.VODA (2)    = 20.00                          9.Chiken Dum Biriyani           = 170.00");
        System.out.println("    5.Chapathi(2) = 40.00                         10.Chiken Biriyani Family Pack   = 450.00 ");

		
		



		System.out.println();

		System.out.println("Enter customor Name :");
		name=sc.nextLine();
		System.out.println();
		System.out.println("       Hello "+name+" Please Order  What Do You Want ?...");
       System.out.println();
				  String s="";
				  int num;
				  int GT=0;
				  String foodname1="";
				  String foodname2="";
				  String foodname3="";
				  String foodname4="";
				  String foodname5="";
				  String foodname6="";
				  String foodname7="";
				  String foodname8="";
				  String foodname9="";
				  String foodname10="";
				  int t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
				  t1=t2=t3=t4=t5=t6=t7=t8=t9=t10=0;
				   do{
					    System.out.println(" Plese Enter The Dish Number ");
						num=sc.nextInt();
						sc.nextLine();

						switch(num){
						case 1:
							p1=20;
						   t1+=20;
						   foodname1="IDLY";
						   ++qty1;
						   break;

						   case 2:
							p2=35;
						   t2+=35;
						   foodname2="DOSA";
						   ++qty2;
						   break;
                         
						 case 3:
							p3=30;
						   t3+=30;
						   foodname3="PURI";
						   ++qty3;
						   break;
  
						   case 4:
							p4=20;
						   t4+=20;
						   foodname4="VODA";
						   ++qty4;
						   break;

						   case 5:
							p5=40;
						   t5+=40;
						   foodname5="Chapathi";
						   ++qty5;
						   break;

						   case 6:
							p6=120;
						   t6+=120;
						   foodname6="Chiken Biriyani";
						   ++qty6;
						   break;

						   case 7:
							p7=135;
						   t7+=135;
						   foodname7="Chiken LollyPop";
						   ++qty7;
						   break;

						   case 8:
							p8=150;
						   t8+=150;
						   foodname8="Chiken 65";
						   ++qty8;
						   break;

						   case 9:
							p9=170;
						   t9+=170;
						   foodname9="Chiken Dum Biriyani";
						   ++qty9;
						   break;

						   case 10:
							p10=450;
						   t10+=450;
						   foodname10="Chiken Biriyani Family pack";
						   ++qty10;
						   break;
						  default:
							  System.out.println(" Food is not Available");
						 

						}

						System.out.println(" Do you want to  Add more  Items : (Y/N) ?");
						s=sc.nextLine();
				   }
				   while(s.equalsIgnoreCase("y"));
				   System.out.println();
				  
                   System.out.println("                                        Bill Recipt                             ");
                   System.out.println("                                      ---------------                           ");
				    System.out.println(" Restaurent Name : Manu Restaurent                           ");
                    System.out.println(" Customer   Name  : "+name);
                   System.out.println();
				   System.out.println(); 

				   System.out.println("Items\t\t\t\t"+"Quantity \t"+"Price\t\t"+"Total");
				   System.out.println("-----------------------------------------------------------------------------------");

				   if(foodname1.equalsIgnoreCase("IDLY")){
					   System.out.println(foodname1+"              \t\t"+qty1+"\t\t"+p1+"\t\t"+t1);
				   }  if(foodname2.equalsIgnoreCase("DOSA")){
					   System.out.println(foodname2+"              \t\t"+qty2+"\t\t"+p2+"\t\t"+t2);
				   }  if(foodname3.equalsIgnoreCase("PURI")){
					   System.out.println(foodname3+"              \t\t"+qty3+"\t\t"+p3+"\t\t"+t3);
				   }  if(foodname4.equalsIgnoreCase("VODA")){
					   System.out.println(foodname4+"              \t\t"+qty4+"\t\t"+p4+"\t\t"+t4);
	               }
				      if(foodname5.equalsIgnoreCase("Chapathi")){
					   System.out.println(foodname5+"        \t\t"+qty5+"\t\t"+p5+"\t\t"+t5);
	               }

				   
				   if(foodname6.equalsIgnoreCase("Chiken Biriyani")){
					   System.out.println(foodname6+"        \t\t"+qty6+"\t\t"+p6+"\t\t"+t6);
				   }  if(foodname7.equalsIgnoreCase("Chiken LollyPop")){
					   System.out.println(foodname7+"        \t\t"+qty7+"\t\t"+p7+"\t\t"+t7);
				   }  if(foodname8.equalsIgnoreCase("Chiken 65")){
					   System.out.println(foodname8+"        \t\t"+qty8+"\t\t"+p8+"\t\t"+t8);
				   }  if(foodname9.equalsIgnoreCase("Chiken Dum Biriyani")){
					   System.out.println(foodname9+" \t\t"+qty9+"\t\t"+p9+"\t\t"+t9);
	               }
				      if(foodname10.equalsIgnoreCase("Chiken Biriyani Family pack")){
					   System.out.println(foodname10+"     "+qty10+"\t\t"+p10+"\t\t"+t10);
	               }
				  
				    System.out.println("                                                -----------------------");
				   GT=t1+t2+t3+t4+t5+t6+t8+t9+t10;
				   System.out.println("                                                   Grand Total = "+GT);
				   System.out.println("                                                 -----------------------");
	}  
}     


