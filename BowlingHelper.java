package Bowling;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BowlingHelper {
	
	Scanner scan = new Scanner(System.in);
	int intPlayerNum;
	String[] name;
	int [] score;
	String isStrike;
	int randomNum;
	int randomThrow2;
	int randomThrow1;
	String separator = "--------------------------";
	int playerPoint1;
	int playerPoint2;
	int totalScore;

	
	public int randomKnocked(int minVal, int maxVal) {

		int randomNum = ThreadLocalRandom.current().nextInt(minVal, maxVal);
		  this.randomNum = randomNum;
		  return randomNum;
	}
	
	public int numOfPlayer() {
		System.out.println("Please input number of players: ");
		String playerNum = scan.nextLine();
		int intPlayerNum = Integer.parseInt(playerNum);
		this.intPlayerNum = intPlayerNum;
		return intPlayerNum; 			//nagmumura walang gagawin pinapunta 1
	}
	
	public void playerName() {
		name = new String [intPlayerNum];
//		this.name = name;
		for(int i =0; i<intPlayerNum; i++) {
			System.out.println("Please enter Player"+(i+1)+" name: ");
			String playerName = scan.nextLine();
			name [i] = playerName;
		}
		System.out.println("\nWelcome, Player(s) \n");
	}
	
	public int pointSystematFirstThrow() {
		int playerPoint1 = 0;
		System.out.println(separator+ "\n"+"FIRST THROW:");
		
		randomThrow1 = randomKnocked(0, 11);
		System.out.print("Pins knocked at 1st throw: "+randomThrow1+"\n");
		
		if(randomThrow1 ==10) {
			playerPoint1 = 20;
			this.playerPoint1 = playerPoint1;
		}
		else if(randomThrow1<10) {
			playerPoint1 = randomThrow1;
			this.playerPoint1 = playerPoint1;
		}
		if(randomThrow1 ==0) {
			  playerPoint1 =0;
		}
		System.out.println("Player score: " + playerPoint1 + "\n");
		return playerPoint1;
	}
	
	public void pointSystematSecondThrow() {
		
		int playerPoint2 = 0;
		int firstThrow = pointSystematFirstThrow() ;
		System.out.println("SECOND THROW");
		
		if(firstThrow ==20) {
			System.out.println("0");
			playerPoint2 =20;
		}
		
		else if((firstThrow>0 && firstThrow <20)) {
			int maxValue = (10 - firstThrow) +1;
			randomThrow2 = randomKnocked(0, maxValue);
			System.out.print("Pins knocked at 2nd throw: "+randomThrow2 + "\n");
			if(randomThrow1+randomThrow2 ==10) {
				playerPoint2 = 15;
				this.playerPoint2 = playerPoint2;
				System.out.println("Player score: "+playerPoint2 );
				System.out.println("GOOD JOB");
			}
			else if(randomThrow2<10) {
				playerPoint2 = randomThrow2 + playerPoint1;
				System.out.println("Player score: "+playerPoint2 );
				this.playerPoint2 = playerPoint2;
			}
			else if(randomThrow2 ==0) {
				System.out.print("STRIKE!");
				playerPoint2 = 0 + playerPoint1;
				System.out.println("Player score: "+playerPoint2 );
				this.playerPoint2 = playerPoint2;
			}
		}
		else if(firstThrow == 0) {
			System.out.print("STRIKE on first throw!\n");
		}
		System.out.println(separator);
		
	}
	
	public int playerAlteration() {
		int[] score = new int [intPlayerNum];
		int i=0;
		for(i = 0; i<10 ; i++) {
			for(int j=0; j<intPlayerNum;j++) {
				System.out.println(name[j] + "'s turn");
				pointSystematSecondThrow();
				score[j] = score[j] + playerPoint2;
				System.out.println(name[j]+"'s Total score is: " + score[j]+ "\n");
			}
		}
		return i;
	}
}
