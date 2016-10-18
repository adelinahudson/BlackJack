import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class CardRunner
	{
		static ArrayList <Card> deck = new ArrayList<Card>();
		static ArrayList <Card> discard = new ArrayList<Card>();
		static ArrayList <Card> dealersCards = new ArrayList<Card>();
		static int bet;
		static int balance = 1000;
		static int dealerHand = 0;
		static int myHand= 0;
		public static void main(String[] args)
			{
				sayWelcomeStatement();
				fillDeck();
				checkDeck();
				shuffleDeck();
				askToBet();
				dealFirstTwoCardsToPlayer();
				//VOIDtellPlayerTheirFirstTwoCards();
				askToHitOrStay();
				checkDealersCards();
				showCards();
				seeWhoWins();
				guessDiscardPile();
				askToPLayAgain();
				
				
				
			}
		public static void sayWelcomeStatement()
			{
		System.out.println("Welcome to Black Jack");
			}
		public static void fillDeck()
		{
				
				//boolean hit = true;
				
			
				deck.add(new Card("ace","spades", 11));
				deck.add(new Card("two","spades", 2));
				deck.add(new Card("three","spades", 3));
				deck.add(new Card("four","spades", 4));
				deck.add(new Card("five","spades", 5));
				deck.add(new Card("six","spades", 6));
				deck.add(new Card("seven","spades", 7));
				deck.add(new Card("eigth","spades", 8));
				deck.add(new Card("nine","spades", 9));
				deck.add(new Card("ten","spades", 10));
				deck.add(new Card("jack","spades", 10));
				deck.add(new Card("queen","spades", 10));
				deck.add(new Card("king","spades", 10));
				
				deck.add(new Card("ace","hearts", 11));
				deck.add(new Card("two","hearts", 2));
				deck.add(new Card("three","hearts", 3));
				deck.add(new Card("four","hearts", 4));
				deck.add(new Card("five","hearts", 5));
				deck.add(new Card("six","hearts", 6));
				deck.add(new Card("seven","hearts", 7));
				deck.add(new Card("eigth","hearts", 8));
				deck.add(new Card("nine","hearts", 9));
				deck.add(new Card("ten","hearts", 10));
				deck.add(new Card("jack","hearts", 10));
				deck.add(new Card("queen","hearts", 10));
				deck.add(new Card("king","hearts", 10));

				deck.add(new Card("ace","clubs", 11));
				deck.add(new Card("two","clubs", 2));
				deck.add(new Card("three","clubs", 3));
				deck.add(new Card("four","clubs", 4));
				deck.add(new Card("five","clubs", 5));
				deck.add(new Card("six","clubs", 6));
				deck.add(new Card("seven","clubs", 7));
				deck.add(new Card("eigth","clubs", 8));
				deck.add(new Card("nine","clubs", 9));
				deck.add(new Card("ten","clubs", 10));
				deck.add(new Card("jack","clubs", 10));
				deck.add(new Card("queen","clubs", 10));
				deck.add(new Card("king","clubs", 10));
				
				deck.add(new Card("ace","diamonds", 11));
				deck.add(new Card("two","diamonds", 2));
				deck.add(new Card("three","diamonds", 3));
				deck.add(new Card("four","diamonds", 4));
				deck.add(new Card("five","diamonds", 5));
				deck.add(new Card("six","diamonds", 6));
				deck.add(new Card("seven","diamonds", 7));
				deck.add(new Card("eigth","diamonds", 8));
				deck.add(new Card("nine","diamonds", 9));
				deck.add(new Card("ten","diamonds", 10));
				deck.add(new Card("jack","diamonds", 10));
				deck.add(new Card("queen","diamonds", 10));
				deck.add(new Card("king","diamonds", 10));
				
				System.out.println();
				
				
			
				
		}
		public static void checkDeck()
			{
				Scanner userInput = new Scanner(System.in);
				System.out.println("To check for the whole deck, type 1. If you do not want to check for the whole deck, type 2.");
				int answer = userInput.nextInt();
				
				if(answer==1)
					{
						System.out.println("The whole deck:");
						
						for(Card q: deck)
							{
								System.out.println(q);
							}
						System.out.println();
						
					}
				
				else if(answer==2)
					{
						
					}
				else
					{
						System.out.println("That is not an option.");
						checkDeck();
					}
				
		
			}
		
		public static void shuffleDeck()
		{
			Collections.shuffle(deck);
		}
		
		public static void askToBet()
		{
			Scanner userInput = new Scanner(System.in);
			System.out.println("What is your name?");
			String name = userInput.nextLine();
			//System.out.println();
			System.out.println("Hello, " + name + " You have $1000.");
			
			Scanner userInput2 = new Scanner(System.in);
			System.out.println("How much do you want to bet?");
			bet = userInput2.nextInt();
			//System.out.println();
		}
		
		
		public static void dealFirstTwoCardsToPlayer()
			{
				String dealerFirstCardSuit= deck.get(0).getSuit();
				String dealerFirstCardRank= deck.get(0).getRank();
				
				
				String dealerSecondCardSuit= deck.get(1).getSuit();
				String dealerSecondCardRank= deck.get(1).getRank();
				if(dealerFirstCardRank.equals("ace"))
					{
						if(deck.get(1).getRank().equals("ace"))
							{
								deck.get(1).setRank("one");
								deck.get(1).setValue(1);
							} 
						
							}
				dealerHand= deck.get(0).getValue() + deck.get(1).getValue();
//				String dealerFirstCardSuit= deck.get(0).getSuit();
//				String dealerFirstCardRank= deck.get(0).getRank();
//				
//				
//				String dealerSecondCardSuit= deck.get(1).getSuit();
//				String dealerSecondCardRank= deck.get(1).getRank();
//				if(dealerFirstCardRank.equals("ace"))
//					{
//						if(deck.get(1).getRank().equals("ace"))
//							{
//								deck.get(1).setRank("one");
//								deck.get(1).setValue(1);
//							} 
//						
//							}
				discard.add(deck.get(0));
				discard.add(deck.get(1));
				dealersCards.add(deck.get(1));
				deck.remove(0);
				deck.remove(0);
				
				
				if(dealerFirstCardRank.substring(0,1).equals("a"))
					{
						System.out.println("The dealer's first card is an "+dealerFirstCardRank + " of " + dealerFirstCardSuit);
					}
				else if(dealerFirstCardRank.substring(0,1).equals("e"))
					{
						System.out.println("The dealer's first card is an "+ dealerFirstCardRank + " of " + dealerFirstCardSuit);
						
					}
				else
					{
						System.out.println("The dealer's first card is a "+ dealerFirstCardRank + " of " +dealerFirstCardSuit);
					}
				//System.out.println();

				
				myHand= deck.get(0).getValue() + deck.get(1).getValue();
				String myFirstCardSuit= deck.get(0).getSuit();
				String myFirstCardRank= deck.get(0).getRank();
				
				
				String mySecondCardSuit= deck.get(1).getSuit();
				String mySecondCardRank= deck.get(1).getRank();
				if(myFirstCardRank.equals("ace"))
					{
						if(deck.get(1).getRank().equals("ace"))
							{
								deck.get(1).setRank("one");
								deck.get(1).setValue(1);
							} 
						
							}
				discard.add(deck.get(0));
				discard.add(deck.get(1));
				deck.remove(0);
				deck.remove(0);
				
				//I put the method below into this method combining the methods so i dont loose my variables i just made
				if(myFirstCardRank.substring(0,1).equals("a"))
					{
						System.out.println("Your first card is an "+ myFirstCardRank + " of " + myFirstCardSuit);
					}
				else if(myFirstCardRank.substring(0,1).equals("e"))
					{
						System.out.println("Your first card is an "+ myFirstCardRank + " of " + myFirstCardSuit);
						
					}
				else
					{
						System.out.println("Your first card is a "+ myFirstCardRank + " of " + myFirstCardSuit);
					}
				
				if(mySecondCardRank.substring(0,1).equals("a"))
					{
						System.out.println("Your second card is an "+ mySecondCardRank + " of " + mySecondCardSuit);
					}
				else if(mySecondCardRank.substring(0,1).equals("e"))
					{
						System.out.println("Your second card is an "+ mySecondCardRank + " of " + mySecondCardSuit);
						
					}
				else
					{
						System.out.println("Your second card is a "+ mySecondCardRank + " of " + mySecondCardSuit);
					}
			//System.out.println();
				
				System.out.println("Your hand adds up to a total of " + myHand);
				//System.out.println();
			}
		
	
		public static void askToHitOrStay()
		{
			//boolean gameCont;
			//while (gameCont =true)
				//{
//			boolean noAnswer=true;
//			while(noAnswer)
//				{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Do you want to hit or stay? Type 1 to hit and 2 to stay");
			int answer = userInput.nextInt();

			if(answer==1)
				{
					
					if(deck.get(0).getRank().equals("ace"))
								{
									if(myHand>10)
										{
											deck.get(0).setValue(1);
										}
								}
					
					myHand+= deck.get(0).getValue();
					
					if(deck.get(0).getRank().substring(0,1).equals("a"))
						{
							System.out.println("You drew an " + deck.get(0).getRank() + " of " + deck.get(0).getSuit());
							}
					else if(deck.get(0).getRank().substring(0,1).equals("e"))
						{
							System.out.println("You drew an " + deck.get(0).getRank() + " of " + deck.get(0).getSuit());
							
						}
					else
						{

							System.out.println("You drew a " + deck.get(0).getRank() + " of " + deck.get(0).getSuit());
						}
					//System.out.println();
					System.out.println("Your cards now total up to " + myHand);
					discard.add(deck.get(0));
					deck.remove(0);
					if(myHand>=21)
						{
							//System.out.println();
							System.out.println("You Lost. Your hand went over 21 making you loose the game of Black Jack.");
							System.out.println("Your balance is $" + (balance-bet));
							//gameCont= false;
							//System.exit(0);
							guessDiscardPile();
							askToPLayAgain();
							System.exit(0);
							
						}
					
					askToHitOrStay();
				}
			else if(answer==2)
				{
					//noAnswer=false;
				}
			else
				{
					System.out.println("That is not an option.");
					
				}
			//System.out.println();
				//}
		}
		//}
		public static void checkDealersCards()
		{
			boolean dealerHandIsLessThanSeventeen=true;
			while(dealerHandIsLessThanSeventeen)
				{
					if(dealerHand<17)
						{
							if(deck.get(0).getRank().equals("ace"))
								{
									if(dealerHand>10)
										{
											deck.get(0).setValue(1);
										}
								}	
							
					dealerHand+= deck.get(0).getValue();
						
//					String firstLetter=deck.get(0).getRank();
//					
//					
//					if(firstLetter.substring(0,1).equals("a"))
//						{
//							System.out.println("The dealer drew an "+ deck.get(0).getRank() + " of "+ deck.get(0).getSuit());
//						}
//					else if(firstLetter.substring(0,1).equals("e"))
//						{
//							System.out.println("The dealer drew an "+ deck.get(0).getRank() + " of "+ deck.get(0).getSuit());
//							
//						}
//					else
//						{
//							System.out.println("The dealer drew a "+ deck.get(0).getRank() + " of "+ deck.get(0).getSuit());
//						}
//					
//					if(deck.get(0).getRank().equals("ace"))
//						{
//							if(dealerHand>10)
//								{
//									deck.get(0).setValue(1);
//								}
//						}
					discard.add(deck.get(0));
					dealersCards.add(deck.get(0));
					deck.remove(0);
						}
					if(dealerHand>17)
						{
					dealerHandIsLessThanSeventeen = false;
						}
				}
		}
			
		
		
				public static void showCards()
				{
					System.out.println("Your hand adds up to " + myHand);
					//System.out.println();
					System.out.println("The dealer ended up drawing:");
					for(int i=0; i<dealersCards.size(); i++)
						{
							System.out.println(dealersCards.get(i).getRank() + " of " + dealersCards.get(i).getSuit());
						}
					System.out.println("The dealers hand adds up to " + dealerHand);
					//System.out.println();
				}
				
				public static void seeWhoWins()
				{
					if(myHand>21)
						{
							System.out.println("You loose because your hand is bigger than 21");
							System.out.println("Your balance is $" + (balance-bet));
							
						}
					else if(dealerHand>21)
						{
							System.out.println("The dealer looses because the dealer's hand is bigger than 21");
							if(myHand>dealerHand)
								{
									System.out.println("You loose because your hand is also bigger than 21");
									System.out.println("You both loose, therefore your balance stays the same.");
									System.out.println("Your balance is $" + balance );
								
								}
							else if(myHand<=21)
								{
									System.out.println("You win because your hand did not bust.");
									System.out.println("Your balance is $" + (balance+bet));
									
								}
						}
					
					
					else if(myHand>dealerHand)
						{
							System.out.println("You win with a hand of "+myHand);
							System.out.println("Your balance is $" + (balance+bet));
						}
					else if(dealerHand>myHand)
						{
							System.out.println("The dealer wins with a hand of "+dealerHand);
							System.out.println("Your balance is $" + (balance-bet));
						}
					else if(myHand==dealerHand)
						{
							System.out.println("Tied game.");
						}
				}
				
				
				
				public static void guessDiscardPile()
				
				{
					Scanner userInput = new Scanner(System.in);
					System.out.println();
					System.out.println("Try to guess all the cards that were drawn and used in this game and in previous games in order. Type 1 to see the answer");
					int input = userInput.nextInt();
					if(input==1)
						{
					System.out.println("Here are all the cards drawn from you and the dealer together in order:");
					for(Card q: discard)
						{
							System.out.println(q);
						}
						}
				}
				
				public static void askToPLayAgain()
				{
					System.out.println("Do you want to play again?");
//					boolean noAnswer=true;
//					while(noAnswer)
//						{
					Scanner userInput = new Scanner(System.in);
					System.out.println("Type 1 to play again. Type 2 to exit program.");
					int answer = userInput.nextInt();
					if(answer==1)
						{
							sayWelcomeStatement();
							fillDeck();
							checkDeck();
							shuffleDeck();
							askToBet();
							dealFirstTwoCardsToPlayer();
							//VOIDtellPlayerTheirFirstTwoCards();
							askToHitOrStay();
							checkDealersCards();
							showCards();
							seeWhoWins();
							guessDiscardPile();
							askToPLayAgain();
		
//							noAnswer=false;
						}
					
					
					
					else if(answer==2)
						{
							System.exit(0);
//							noAnswer=false;
						}
					else
						{
							System.out.println("That is not an option.");
							askToPLayAgain();
						}
					//System.out.println();
						}
					
				//}
			}
